package com.lookat.command.mylookat;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.common.Common;
import com.lookat.vo.MemberVO;

public class LookatPwdCheckCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		MemberVO member = (MemberVO) ss.getAttribute("member");
		
		// 비밀번호 검증 -------------------------------------------------------------
		// 암호화 된 비밀번호
		String num = request.getParameter("password");

		// 입력받은 비밀번호 검증
		if (num.equals(member.getMemberPassword())) {

			// 비밀번호가 같은 경우
			return Common.PATH = "main/mylookat/mypage.jsp";

		} else {
			// 비밀번호가 다른 경우
			
			// 페이지에 넘길 체크
			boolean check = false;
			request.setAttribute("check", check);
			return Common.PATH = "main/passwordCheck.jsp";
		}
		
		
	}

}
