package com.lookat.command.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;


public class LogOutCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		ss.invalidate();
		
		ss = request.getSession(false); //기존 세션 있으면 가져옴
		
		if (ss == null) {
			System.out.println("세션 삭제 완료");
		} else {
			System.out.println("세션 삭제 실패");
		}
		
		
		return "/main/index.jsp";
	}

}
