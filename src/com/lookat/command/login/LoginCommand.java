package com.lookat.command.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;
import com.lookat.vo.MemberVO;

public class LoginCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id"); 
		String pw = request.getParameter("pw");
		
		//(이상값 처리) 다시 로그인 페이지로 전환될 때 넘겨줄 상태값
		String status = "";
		
		//빈값으로 로그인 누르면
		if ((id == null || id.isBlank()) && (pw == null || pw.isBlank())) {
			System.out.println(">>아이디x, 비번x 둘 다 공백으로 로그인 누른 경우");
			status = "id and pwd is blank";
		} else if (id != null && pw.isBlank()) { 
			System.out.println(">>아이디o, 비번x 로그인 누른 경우");
			status = "pwd is blank";
		}  else if (id.isBlank() && pw != null) {
			System.out.println(">>아이디x, 비번o  로그인 누른 경우");
			status = "id is blank";
		}
		request.setAttribute("status", status);
		

		List<MemberVO> userList = MemberDAO.loginCheck(id, pw);
		System.out.println("login 확인용 " + userList);
		HttpSession ss = request.getSession(); 
		
		 if (userList == null || userList.isEmpty()) { //로그인실패
			 System.out.println("로그인 실패");
			 request.setAttribute("status", "login denied"); 
			 return "/main/login/login.jsp"; 
		 } 
		 
		 //로그인 성공
		 request.setAttribute("status", "login approved");
		 MemberVO member = userList.get(0);
		 ss.setAttribute("member", member); //세션에 "member"memberVO 저장
		 for (MemberVO vo : userList) { //관리자 로그인이면
			 if (vo.getMemberType().equals("Manager")) {
				 ss.setAttribute("isManager", true); //세션에 isManager 추가
				 return "/main/index.jsp";
			 }
		 }
		 ss.setAttribute("isManager", false); //일반 사용자
		 return "/main/index.jsp";
		 
		
	}
	
	

}
