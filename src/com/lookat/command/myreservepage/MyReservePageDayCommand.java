package com.lookat.command.myreservepage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.AmountpaidDAO;
import com.lookat.dao.MemberDAO;
import com.lookat.dao.MovieDAO;
import com.lookat.dao.ReserveDAO;
import com.lookat.dao.RuntimeDAO;
import com.lookat.dao.SeatDAO;
import com.lookat.dao.TheaterDAO;
import com.lookat.vo.AmountpaidVO;
import com.lookat.vo.MemberVO;
import com.lookat.vo.ReserveVO;
import com.lookat.vo.RuntimeVO;

public class MyReservePageDayCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 나의 예매 확인 페이지
		HttpSession ss = request.getSession();
		MemberVO member = (MemberVO) ss.getAttribute("member");
		
		// 선택된 payDate
		String selectPayDate = request.getParameter("payDate");
		
		
		// -----------------------------------------------------------------
		// 전체 예매내역 리스트 표현 위한 데이터 추출 ----------------------
		// 1. MEMBER_ID를 통한 예약내역 전부 데이터 추출 / O
		List<ReserveVO> reserveList = ReserveDAO.getReserveListByPayDate(member.getMemberId(), selectPayDate);
		
		// 중복 제거 예약 리스트
		List<ReserveVO> finalReserveList = new LinkedList<ReserveVO>();
		Map<String, Integer> peopleCountMap = new HashMap<String, Integer>();
		Map<String, String> seatMap = new HashMap<String, String>();
		Map<String, String> reserveNumMap = new HashMap<String, String>();
		
		// 중복 데이터 지우고 인원수, 좌석 따로 구분하기
		int count = reserveList.size();
		String totalSeat = "";
		String reserveNum = "";
		for (ReserveVO reserve : reserveList) {
			
			// 비교할 첫 데이터 삽입
			if(finalReserveList.isEmpty()) {
				finalReserveList.add(reserve);
			}
				
			if(reserve.getPayDate().equals(selectPayDate)) {
				// 최종출력 리스트에서 중복값 검사
				if(finalReserveList.contains(reserve)) {
					totalSeat += reserve.getSeatId() + " ";
					reserveNum += reserve.getReserveNum() + " ";
					continue;
				} else {
					totalSeat += reserve.getSeatId() + " ";
					reserveNum += reserve.getReserveNum() + " ";
				}
			}
		}
		peopleCountMap.put(selectPayDate, count);
		seatMap.put(selectPayDate, totalSeat);
		reserveNumMap.put(selectPayDate, reserveNum);
		
		ss.setAttribute("finalReserveList", finalReserveList);
		ss.setAttribute("peopleCountMap", peopleCountMap);
		ss.setAttribute("seatMap", seatMap);
		ss.setAttribute("reserveNumMap", reserveNumMap);
		
		// 3. 중복 제거한 런타임ID 리스트 (Order by) / 영화관명, 영화명을 가져오기 위한 중복 제거
		List<Integer> runtimeIdList = ReserveDAO.getRuntimeIdDis(member.getMemberId());
		request.setAttribute("runtimeIdList", runtimeIdList);
		
		// 4. 런타임ID리스트를 통해 영화관명, 영화명 가져오기 / O
		// 영화관,영화별 Map 생성 key: runtimeId, value: 영화관명 & 영화명
		// -----------------------------------------------------------------
		// (추가기능) 영화 포스터 영화테이블에 추가시 영화 VO를 가져오는 것으로 변경
		Map<Integer, String> theaterNameMap = new HashMap<Integer, String>();
		Map<Integer, String> movieNameMap = new HashMap<Integer, String>();
		Map<Integer, RuntimeVO> runtimeMap = new HashMap<Integer, RuntimeVO>();
		
		for (Integer runtimeId : runtimeIdList) {
			
			// 영화관명 가져오기
			String theaterName = TheaterDAO.getTheaterNameByRuntimeId(runtimeId);
			theaterNameMap.put(runtimeId, theaterName);
				
			// 영화명 가져오기
			String movieName = MovieDAO.getMovieNameByRuntimeId(runtimeId);
			movieNameMap.put(runtimeId, movieName);
			
			// 일시 가져오기
			RuntimeVO findRuntime = RuntimeDAO.getFindOneRuntime(runtimeId);
			runtimeMap.put(runtimeId, findRuntime);
			
		}
		
		ss.setAttribute("theaterNameMap", theaterNameMap);
		ss.setAttribute("movieNameMap", movieNameMap);
		ss.setAttribute("runtimeMap", runtimeMap);
		
		// 결제금액 로직----------------------------- 
		// PAY_DATE, SEAT_ID 일치 하면 totalPrice 합산 후 아래 Map에 담기
		// Map<payDate, Integer> payDate = payDate, Integer = totalPrice
		// 결제 금액 화면 출력할 때 key=payDate 통해 같이 출력
		Map<String, Integer> totalPriceMap = new HashMap<String, Integer>(); // 결제가격을 담을 맵
		Map<String, String> discountMap = new HashMap<String, String>(); // 할인내역 담을 맵
		// 결제 금액과 할인내역 추출
		List<AmountpaidVO> amountpaidList = AmountpaidDAO.getAmountpaid(selectPayDate, member.getMemberId());
		
		// 리스트가 있는 경우에만
		if (!amountpaidList.isEmpty()) {
			totalPriceMap.put(selectPayDate, amountpaidList.get(0).getPayprice());
			discountMap.put(selectPayDate, amountpaidList.get(0).getDiscountContents());
		}
		
		ss.setAttribute("totalPriceMap", totalPriceMap);
		ss.setAttribute("discountMap", discountMap);
		
		return "main/reserve/myReservePage.jsp";
	}
	
	

}
