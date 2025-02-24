package com.lookat.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface Command {
	
	public String exec(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;

}
