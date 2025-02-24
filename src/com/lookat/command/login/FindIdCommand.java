package com.lookat.command.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;

public class FindIdCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자 입력값 파라미터 받기
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String birthday = request.getParameter("birthday");
		
		//사용자 입력값 유효성 검증
		String status = ""; //findPage로 넘겨줄 상태값
		
		if ((name == null || name.trim().isEmpty()) ||
					(number == null || number.trim().isEmpty()) ||
					(birthday == null ||  birthday.trim().isEmpty())) {
			status = "null";
			request.setAttribute("status", status);
			return "/main/login/find/findIdPage.jsp";
			
		} else if (number.contains("-")) { //전화번호에 - 포함되있다면
			status = "contains -";
			request.setAttribute("status", status);
			return "/main/login/find/findIdPage.jsp";
		} else if (birthday.length() > 6 ) { //법정생년월일 6자리 넘으면
			status = "length problem";
			request.setAttribute("status", status);
			return "/main/login/find/findIdPage.jsp";
		}
		
		//DB 조회값 받아오기
		String foundId = MemberDAO.findId(name, number, birthday);
		System.out.println("확인용 : " + foundId);
		if (foundId == null) { 
			status = "일치하는 아이디가 없습니다.";
			request.setAttribute("status", status);
		} 
		request.setAttribute("foundId", foundId);
		return "main/login/found/foundIdPage.jsp";
		
	}

}
