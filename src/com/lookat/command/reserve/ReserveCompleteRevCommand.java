package com.lookat.command.reserve;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.lookat.command.Command;
import com.lookat.common.Common;
import com.lookat.dao.AmountpaidDAO;
import com.lookat.dao.CouponDAO;
import com.lookat.dao.MembershipDAO;
import com.lookat.dao.ReserveDAO;
import com.lookat.dao.RuntimeDAO;
import com.lookat.mybatis.DBService;
import com.lookat.vo.MemberVO;
import com.lookat.vo.MembershipVO;
import com.lookat.vo.RuntimeVO;
import com.lookat.vo.TheaterVO;

public class ReserveCompleteRevCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전체 트랜잭션 적용 하나라도 실패 시 전체 실패
		SqlSession sqlss = DBService.getFactory().openSession();
		
		try {
			
			// DB에 예매 정보 Insert, 포인트 사용 및 적립 업데이트
			HttpSession ss = request.getSession();
			// 멤버쉽 등급별 적립과 쿠폰 사용 삭제를 위한 데이터 추출
			MembershipVO membership = (MembershipVO) ss.getAttribute("membership");
			MemberVO member = (MemberVO) ss.getAttribute("member");
			
			// Insert할 데이터 추출 -----------------------------------------------------------
			String selectSeatId = String.valueOf(ss.getAttribute("selectSeatId")); // 선택 좌석
			String selectPeople = String.valueOf(ss.getAttribute("selectPeople")); // 선택 인원수
			
			RuntimeVO runtimeVO = (RuntimeVO) ss.getAttribute("findRuntime");
			TheaterVO theaterVO = (TheaterVO) ss.getAttribute("findTheater");
			MemberVO memberVO = (MemberVO) ss.getAttribute("member");
			String parseUsePoint = String.valueOf(ss.getAttribute("usePointValue"));
			String parseCouponValue = String.valueOf(ss.getAttribute("couponValue"));
			String discountContent = String.valueOf(ss.getAttribute("discountContent"));
			
			System.out.println("[ReserveCompleteRevCommand] 결제커맨드 discountContent : " + discountContent);
			// undefined인 경우 0 값
			int usePointValue = 0;
			int couponValue = 0;
			
			//  포인트 사용한 경우 int 파싱
			if (!parseUsePoint.isBlank()) {
					
				// 사용 포인트 문자열 파싱
				usePointValue = Integer.parseInt(parseUsePoint); 
			} 
			
			if(!parseCouponValue.isBlank()) {
				
				couponValue = Integer.parseInt(parseCouponValue);
			}
			
			// 쿠폰 사용한 경우 int 파싱
			if (discountContent.isBlank()) {
				
				// 사용 포인트 문자열 파싱
				discountContent = "할인내역 없음";
			} 
				
			
			// 남은 결제 금액
			int leftTotalPrice = Integer.parseInt(request.getParameter("leftTotalPrice")); 
			
			// 좌석 정보 파싱
			String[] seatIdList = selectSeatId.split("\u00a0");
			
			// insert 결과문 
			// 예매 내역(Reserve) 테이블 insert----------------------------------------------------------
			// (추가사항) DAO 두번 날리는거 최적화하기
			for (String seatId : seatIdList) {
				Map<String, Object> reserveInsertMap = new HashMap<String, Object>();
				reserveInsertMap.put("runtimeId", runtimeVO.getRuntimeId());
				reserveInsertMap.put("seatId", seatId);
				reserveInsertMap.put("theaterId", theaterVO.getTheaterId());
				reserveInsertMap.put("memberId", memberVO.getMemberId());
				ReserveDAO.insertReserve(reserveInsertMap, sqlss);
			}
				
			
			
			
			// 상영시간(Runtime) 테이블 update(좌석 수 줄이기)--------------------------------------------
			// 1. 기존 잔여좌석, 선택 좌석 수 추출
			int leftSeatCount = runtimeVO.getLeftSeatCount();
			int selectPeopleCnt = Integer.parseInt(selectPeople);
			// 2. 기존 잔여좌석 - 선택좌석 수 담기
			int updateSeatCount = leftSeatCount - selectPeopleCnt;
			
			// 2. 잔여좌석 update 쿼리 보내기
			RuntimeDAO.updateLeftSeat(runtimeVO.getRuntimeId(), updateSeatCount, sqlss);
			
			// 멤버쉽 적립포인트 update----------------------------------------------------------
			// 1. 사용한 포인트 차감 DAO
			MembershipDAO.updatePointMinus(memberVO.getMemberId(), usePointValue, sqlss);
			
			// 2. 적립 포인트 추가 (등급별) 
			// BRONZE[0.01%], SILVER[0.015%], GOLD[0.02%]
			String grade = membership.getGrade();
			
			if(leftTotalPrice > 0) {
				
				int addPoint = 0;
				
				switch(grade) {
				
				case "BRONZE":
					addPoint = leftTotalPrice / 100;
					break;
					
				case "SLIVER":
					addPoint = (leftTotalPrice * 15) / 1000;
					break;
					
				case "GOLD":
					addPoint = (leftTotalPrice * 2) / 100;
					break;
				
				}
				
				MembershipDAO.updatePointAdd(memberVO.getMemberId(), addPoint, sqlss);
				
			}
			// 사용한 쿠폰 삭제
			// 멤버쉽ID, 쿠폰ID 활용 사용한 쿠폰 업데이트
			if (couponValue > 1) {
				
				CouponDAO.deleteCoupon(membership.getMembershipId(), couponValue, sqlss);
			}
			
			// 결제 후 예매 횟수에 따른 등급 재조정 로직 짜기
			// 예매횟수 조회 MEMBER_ID 이용
			int reserveCount = ReserveDAO.getReserveCount(member.getMemberId(), sqlss);
			String updateGrade = "";
			// 횟수에 따른 등급 조정 UPDATE 쿼리 보내기
			switch(reserveCount) {
			
			case 20:
				updateGrade = "SLIVER";
				break;
				
			case 30:
				updateGrade = "GOLD";
				break;
			}
				
			// 값이 대입 되었을 때만 업데이트 쿼리 날리기 
			if (!updateGrade.isBlank()) {
				
				MembershipDAO.updateGrade(membership.getMembershipId(), updateGrade, sqlss);
			}
			
			// 결제 금액, 할인 내역 insert
			// 결제금액, 결제일, 멤버id, 할인내역
			AmountpaidDAO.insert(leftTotalPrice, member.getMemberId(), discountContent, sqlss);
			
			// 마지막 다 성공 된 경우 커밋
			sqlss.commit();
			// 성공 경로 
			return Common.PATH = "controller?command=reserveSwitch";
			
		} catch (Exception e) {
			e.printStackTrace();
			// 하나라도 실패 시 롤백
			sqlss.rollback();
			// 실패경로
			return Common.ERROR_PATH;
		} finally {
			
			sqlss.close();
		}
	}

}
