package com.lookat.command.reserve;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;

public class ReserveCompleteCheckCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 목적 : 최종 결제 확인
		HttpSession ss = request.getSession();
		
		// 변수 설정
		Map<String, String> paymentType = new HashMap<String, String>();
		paymentType.put("card", "신용카드");
		paymentType.put("phone", "휴대폰");
		paymentType.put("simple", "간편결제");
		
		// 데이터 추출
		String radioValue = request.getParameter("radioValue");
		String leftTotalPrice = request.getParameter("leftTotalPrice");
		String usePointValue = request.getParameter("usePointValue");
		String couponValue = request.getParameter("couponValue");
		String discountContent = request.getParameter("discountContent");
		
		if(usePointValue.equals("undefined")) {
			usePointValue = "";
		}
		if (couponValue.equals("undefined")) {
			couponValue = "";
		}
		
		request.setAttribute("paymentType", paymentType);
		request.setAttribute("radioValue", radioValue);
		ss.setAttribute("discountContent", discountContent);
		ss.setAttribute("usePointValue", usePointValue);
		ss.setAttribute("couponValue", couponValue);
		ss.setAttribute("leftTotalPrice", leftTotalPrice);
		
		
		return "main/reserve/reserveCompleteCheck.jsp";
	}
	
	

}
