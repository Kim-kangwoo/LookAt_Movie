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

public class MyReservePageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 나의 예매 확인 페이지로 이동 시켜주는 Command
		HttpSession ss = request.getSession();
		MemberVO member = (MemberVO) ss.getAttribute("member");
		
		List<String> payDateList = ReserveDAO.getPayDateList(member.getMemberId());
		ss.setAttribute("payDateList", payDateList);
		
		return "main/reserve/myReservePage.jsp";
	}
	
	

}
