package com.lookat.command.manager.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MembershipDAO;
import com.lookat.vo.MemberAndMembershipVO;

public class MembershipListPageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//멤버십 회원 정보
		List<MemberAndMembershipVO> list = MembershipDAO.getMembershipList();
		System.out.println("멤버십 회원 정보 확인 : " + list);
		request.setAttribute("membershipList", list);
		
		return "/main/manager/memberChk/membershipListPage.jsp";
	}

}
