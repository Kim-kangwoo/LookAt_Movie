package com.lookat.command.mylookat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;

public class LookatCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 내 정보 조회로 거쳐가는 커맨드
		
		return "main/mylookat/info/myLookAt.jsp";
	}
	
	
	
	
	
}
