package com.lookat.command.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;

public class FindPwdCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자 입력값 파라미터 받기
		String id = request.getParameter("id");
		String number = request.getParameter("number");
		String birthday = request.getParameter("birthday");
		
		//사용자 입력값 유효성 검증
		String status = ""; //findPage로 넘겨줄 상태값
		
		if ((id == null || id.trim().isEmpty()) ||
				(number == null || number.trim().isEmpty()) ||
				(birthday == null ||  birthday.trim().isEmpty())) {
			status = "null";
			request.setAttribute("status", status);
			return "/main/login/find/findPwdPage.jsp";
		} else if (number.contains("-")) { //전화번호에 - 포함되있다면
			status = "contains -";
			request.setAttribute("status", status);
			return "/main/login/find/findPwdPage.jsp";
		} else if (birthday.length() > 6 ) { //법정생년월일 6자리 넘으면
			status = "length problem";
			request.setAttribute("status", status);
			return "/main/login/find/findPwdPage.jsp";
		}	
		
		//DB 조회값 받아오기
		String foundPwd = MemberDAO.findPwd(id, number, birthday);
		System.out.println("Pwd 확인용 : " + foundPwd);
		if (foundPwd == null) { 
			status = "일치하는 비밀번호가 없습니다.";
			request.setAttribute("status", status);
		} 
		request.setAttribute("foundPwd", foundPwd);
		return "/main/login/found/foundPwdPage.jsp";
	}

}
