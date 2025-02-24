package com.lookat.command.mylookat;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.vo.MemberVO;

public class LookatMyPageCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 마이페이지로 넘어가는 
		return "main/mylookat/mypage.jsp";
	}
	
	
	
	
	
}
