package com.lookat.command.reserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.CouponDAO;
import com.lookat.dao.MembershipDAO;
import com.lookat.dao.SeatDAO;
import com.lookat.vo.CouponVO;
import com.lookat.vo.MemberVO;
import com.lookat.vo.MembershipVO;

public class ReservePaymentPageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 목적 : 결제 페이지로 이동 
		HttpSession ss = request.getSession();
		MemberVO member = (MemberVO) ss.getAttribute("member");
		
		// 데이터 추출 ----------------------------------------------
		//MemberVO member = (MemberVO) ss.getAttribute("member");
		String selectSeatId = request.getParameter("selectSeatId");
		String selectPeople = request.getParameter("selectPeople");
			
		
		String[] seatIdList = selectSeatId.split("\u00a0");
		
		// 1. 결제할 좌석 금액 가져오기 -----------------------------  
		int totalPrice = SeatDAO.getTotalPrice(seatIdList);
		// 금액 불러오기 실패시 오류 페이지 전환
		if(totalPrice < 0) {
			return "reserve/serverErrorPage.jsp";
		}
		
		// 2. 포인트 조회 하기 --------------------------------------
		MembershipVO membership = MembershipDAO.findOne(member.getMemberId());
		
		// 3. 쿠폰 조회 전달 ----------------------------------------
		// 보유하고 있는 쿠폰 조회
		List<CouponVO> couponList = CouponDAO.findCoupon(membership.getMembershipId());
		
		
		// 다음 화면을 위한 셋
		ss.setAttribute("membership", membership);
		ss.setAttribute("selectSeatId", selectSeatId);
		ss.setAttribute("selectPeople", selectPeople);
		ss.setAttribute("totalPrice", totalPrice);
		ss.setAttribute("couponList", couponList);
		
		return "main/reserve/reservePayment.jsp";
	}
	
	

}
