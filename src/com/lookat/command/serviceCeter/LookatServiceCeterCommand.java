package com.lookat.command.serviceCeter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;

public class LookatServiceCeterCommand implements Command {

	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 서비스 센터 페이지로 이동
		return "main/serviceceter/serviceCeter.jsp";
	}
	
	
	
	
	
}
