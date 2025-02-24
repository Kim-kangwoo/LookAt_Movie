package com.lookat.command.mylookat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.MembershipDAO;
import com.lookat.vo.MemberVO;
import com.lookat.vo.MembershipVO;

public class LookatPointCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 포인트조회페이지로 이동하는 커맨드
		HttpSession ss = request.getSession();
		
		MemberVO member = (MemberVO) ss.getAttribute("member");
		
		// 멤버쉽 포인트 조회
		// 멤버쉽 가입되지 않은 경우를 검증하기
		MembershipVO membership = MembershipDAO.findOne(member.getMemberId());
		request.setAttribute("membership", membership);
		
		return "main/mylookat/info/myPoint.jsp";
	}

	
	
}
