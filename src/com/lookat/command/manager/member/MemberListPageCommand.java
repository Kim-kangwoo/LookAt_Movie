package com.lookat.command.manager.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;
import com.lookat.vo.MemberVO;

public class MemberListPageCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//일반 회원 목록 가져오기
		List<MemberVO> list = MemberDAO.getMemberList();
		System.out.println("일반 회원 목록 확인 : " + list);
		request.setAttribute("memberList", list);
		
		return "/main/manager/memberChk/memberListPage.jsp";
	}

}
