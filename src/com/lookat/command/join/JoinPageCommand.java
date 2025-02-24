package com.lookat.command.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;

public class JoinPageCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/main/join/joinPage.jsp";
		/*
		//18세 이상, 18세 미만 파라미터 확인
		String type = request.getParameter("type");
		System.out.println("성인 여부 파라미터 확인 : " + type);
		
		Cookie cookie = null;
		
		if (type.equals("adult")) {
			request.setAttribute("type", type);
			cookie = new Cookie("type", "adult"); 
		} else if (type.equals("minor")) {
			request.setAttribute("type", type);
			cookie = new Cookie("type", "minor");
		}
		
		response.addCookie(cookie);
		return "/main/join/joinPage.jsp";
		*/
		
	}
	
	/*
	 * joinAgreePage : 클라이언트가 18세 이상 회원가입 누르면 type : adult <-> 반대면 type : minor)
	 * -> joinPageCommand(type : adult / minor 파라미터 get). joinPage로 페이징처리
	 * -> joinPage : (type이 adult면 18세 이상 회원가입 페이지 띄우기)
	 * -> 닉네임 중복확인용(NicknameDuplicateCheckCommand)에서 닉네임 확인 후 다시 joinPage로 리다이렉트
	 * -> 문제 발생 : 리다이렉트 후 type이 사라져서 <c:if test="${type eq 'adult'}">로 조건 걸어놓은 나이, 생년월일 input 화면에 안뜸
	 * -> 해결 : 1. joinPageCommand에서 받은 type을 쿠키에 저장 하고
	 * 				 2. NicknameDuplicateCheckCommand 에서 쿠키값 가져와서 setAttribute("type", 쿠키값) 저장 후 joinPage로 리다이렉트
	 * 			     3. joinPage로 type이 넘어와서 나이, 생년월일 잘 뜸
	 * 				 4. 쿸이를 이렇게 쓰는지 모르겠지만 일단 돌아가긴 함 
	 * 
	 * 
	 */

}
