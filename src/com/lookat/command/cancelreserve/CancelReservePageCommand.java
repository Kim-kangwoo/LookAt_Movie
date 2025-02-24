package com.lookat.command.cancelreserve;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.vo.MemberVO;
import com.lookat.vo.ReserveVO;

public class CancelReservePageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이지 목적: <캔슬 페이지로 이동 시켜주는 곳>
		
		// 변수지정 -----------------------------------------------------------------------
		int cancelTotalPrice = 0;
		HttpSession ss = request.getSession();
		// 취소 페이지에 보낼 예약 리스트
		List<ReserveVO> cancelReserveList = new LinkedList<ReserveVO>();
		MemberVO member = (MemberVO) ss.getAttribute("member");
		
		// 데이터 추출 -----------------------------------------------------------------------
		// 캔슬 할 Data 추출
		String payDate = request.getParameter("payDate");
		// 2개 이상일 경우 
		String[] payDateList = payDate.split(",");
		//request.setAttribute("payDate", payDate);
		
		// session에서 예매 건당 totalPriceMap 추출
		Map<String, Integer> totalPriceMap = (Map<String, Integer>) ss.getAttribute("totalPriceMap");
		System.out.println("[TEST] totalPriceMap :  " + totalPriceMap ) ;
		
		// 선택된 payDate를 통해 취소리스트 추출 (취소 페이지에 넘길)
		// 아래 작업 하는 이유
		// 선택값으로 넘어온게 payDate라 전체 내역에서 한번 더 걸러줘야 한다.
		List<ReserveVO> finalReserveList = (List<ReserveVO>) ss.getAttribute("finalReserveList"); // 중복 제거된 예약 리스트
		for (ReserveVO reserve : finalReserveList) {
			for(String payDt : payDateList) {
				if(reserve.getPayDate().equals(payDt)) {
					cancelReserveList.add(reserve);
					// 선택된 예약 총 금액
					int totalPrice = totalPriceMap.get(payDt);
					cancelTotalPrice += totalPrice;
				}
			}
		}
		
		// 비밀번호 검증 -------------------------------------------------------------
		// 암호화 된 비밀번호
		String num = request.getParameter("num");
		if (num != null) {

			// 복호화
			num = URLDecoder.decode(new String(Base64.getDecoder().decode(num), "utf-8"), "utf-8");
			// 페이지에 넘길 체크
			boolean check = false;

			// 입력받은 비밀번호 검증
			if (num.equals(member.getMemberPassword())) {

				// 비밀번호가 같은 경우
				check = true;
				request.setAttribute("check", check);

			} else {
				// 비밀번호가 다른 경우
				request.setAttribute("check", check);
			}

		}
		
		
		// 캔슬 할 예매 정보 표시를 위한 set -----------------------------------------------------------------------
		// *** 만약 취소 완료페이지도 보이길 원한다면 ss으로 설정
		ss.setAttribute("cancelReserveList", cancelReserveList);
		request.setAttribute("cancelTotalPrice", cancelTotalPrice);
		
		return "main/reserve/cancelReservePage.jsp";
	}
	
	

}
