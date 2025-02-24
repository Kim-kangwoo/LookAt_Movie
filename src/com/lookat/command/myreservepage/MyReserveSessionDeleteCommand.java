package com.lookat.command.myreservepage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;
import com.lookat.dao.ReserveDAO;
import com.lookat.vo.MemberVO;

public class MyReserveSessionDeleteCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 나의 예매 확인 페이지로 이동 시켜주는 Command
		HttpSession ss = request.getSession();
		
		ss.removeAttribute("totalPriceMap");
		ss.removeAttribute("discountMap");
		ss.removeAttribute("theaterNameMap");
		ss.removeAttribute("movieNameMap");
		ss.removeAttribute("runtimeMap");
		ss.removeAttribute("finalReserveList");
		ss.removeAttribute("peopleCountMap");
		ss.removeAttribute("seatMap");
		ss.removeAttribute("reserveNumMap");
		
		
		String success = request.getParameter("success");
		
		if (success != null) {
			// 삭제 성공 시 세션 삭제 후 예매내역 조회 이동
			return "/controller?command=myReservePage";
			
		} else {
			// 홈으로 
			return "main/index.jsp";
		}
		
	}
	
	

}
