package com.lookat.command.cancelreserve;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.common.Common;
import com.lookat.dao.ReserveDAO;
import com.lookat.dao.RuntimeDAO;
import com.lookat.vo.ReserveVO;
import com.lookat.vo.RuntimeVO;

public class CancelReserveCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 	(추가기능사항)
		 *  새로 고침 할 때 한번 더 요청을 보내지 않는 로직 추가하기
		 */
		
		// 페이지 목적: <DB 삭제하고 완료 페이지 전환>
		
		// 변수지정 -----------------------------------------------------------------------
		HttpSession ss = request.getSession();
		int result = 0; // 예약 삭제 결과값
		int recoverSeatResult = 0; // 좌석 복원 결과값
		int updateSeatCount = 0;
		
		// 데이터 추출 -----------------------------------------------------------------------
		// 중복 제거 된 예약 내역 리스트 
		List<ReserveVO> cancelReserveList = (List<ReserveVO>) ss.getAttribute("cancelReserveList");
		// reserveNum 추출할 맵 
		// 사용 이유 : payDate로 그룹화 reserveNum 따로
		Map<String, String> reserveNumMap = (Map<String, String>) ss.getAttribute("reserveNumMap"); // 예약 삭제 위해
		Map<Integer, RuntimeVO> runtimeMap = (Map<Integer, RuntimeVO>) ss.getAttribute("runtimeMap"); // 좌석 복원 결과값
		
		// DAO로 전달 -----------------------------------------------------------------------
		for(ReserveVO reserve : cancelReserveList) {
			
			// cancelReserveList의 payDate로 취소할 예약 PK 추출 
			String reserveNum = reserveNumMap.get(reserve.getPayDate());
			String[] reserveNumList = reserveNum.split(" "); // 2개 이상 일 수 있음
			for (String reserveNm : reserveNumList) {
				System.out.println("[CancelReserveCommand] reserveNm 검증 : " + reserveNm);
				result += ReserveDAO.deleteReserve(Integer.parseInt(reserveNm));
			}
			// 삭제 후 잔여좌석 다시 늘리는 DAO 날릴 count 추출
			int count = reserveNumList.length;  // 좌석 복원 수 
			int leftSeatCount = runtimeMap.get(reserve.getRuntimeId()).getLeftSeatCount(); // 기존 좌석 잔여수
			updateSeatCount = count + leftSeatCount;
			
			// 삭제 후 잔여좌석 다시 늘리는 DAO 날리기
			recoverSeatResult = RuntimeDAO.updateLeftSeat(reserve.getRuntimeId(), updateSeatCount);
			System.out.println("[TEST] recoverSeatResult :" + recoverSeatResult);
		}
		
		
		// 삭제 결과값에 따른 반응페이지 -----------------------------------------------------------------------
		if(result > 0) {
			// 성공 삭제 페이지 이동
			return Common.PATH = "/controller?command=myReserveSessionDelete&success=true";
			
		} else {			
			// 내부 문제 페이지로 이동하기
			return Common.ERROR_PATH;
		}
		
		
	}
	
	

}
