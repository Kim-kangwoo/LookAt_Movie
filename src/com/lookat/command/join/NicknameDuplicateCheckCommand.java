package com.lookat.command.join;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;

public class NicknameDuplicateCheckCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickname = request.getParameter("nickname");
		System.out.println("사용자 입력 닉네임 확인 : " + nickname);
		
		if (nickname != null && !nickname.isEmpty()) {
			
			boolean nicknameCheckResult = MemberDAO.checkNicknameExists(nickname);
			System.out.println("이미 가입된 별명인지 체크 (true: 사용불가 / false: 사용가능) : " + nicknameCheckResult);
			
			 // JSON
		    String status = nicknameCheckResult ? "nickname duplicated" : "nickname available";
		    String jsonResponse = "{\"nickname\":\"" + status + "\"}";
		    
		    // 응답 ContentType 설정 및 출력
		    response.setContentType("application/json; charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    out.print(jsonResponse);
		    out.flush();
			
			Cookie[] cookies =  request.getCookies();
			if (cookies != null) {
				for (Cookie coo : cookies) {
					String key  = coo.getName();
					String value = coo.getValue();
					System.out.println("쿠키가 넘어왔니..? : " + key + " , " + value);
					request.setAttribute("type", value);
				}
			}
			return "/main/join/joinPage.jsp";  
		}
		
		return "/main/join/joinPage.jsp";  
		
	}

}
