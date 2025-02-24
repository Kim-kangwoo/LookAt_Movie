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

public class LookatPwdCheckCommand_copy implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		MemberVO member = (MemberVO) ss.getAttribute("member");
		
		// 비밀번호 검증 -------------------------------------------------------------
		// 암호화 된 비밀번호
		String num = request.getParameter("num");
		if (num != null) {

			// 복호화
			num = URLDecoder.decode(new String(Base64.getDecoder().decode(num), "utf-8"), "utf-8");
			// 페이지에 넘길 체크
			boolean check = false;

			// 입력받은 비밀번호 검증
			if (num.equals(member.getMemberPassword())) {

				// 비밀번호가 같은 경우
				check = true;
				request.setAttribute("check", check);

			} else {
				// 비밀번호가 다른 경우
				request.setAttribute("check", check);
			}

		}
		
		return "/main/index.jsp";
	}

}
