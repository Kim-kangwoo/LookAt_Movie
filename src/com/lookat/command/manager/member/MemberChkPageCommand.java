package com.lookat.command.manager.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;
import com.lookat.dao.MembershipDAO;

public class MemberChkPageCommand implements Command  {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//회원수
		//1. 전체 회원수
		int totalMemberCount = MemberDAO.getTotalMemberCount();
		System.out.println("전체 회원수 확인 : " + totalMemberCount);
		request.setAttribute("totalMemberCount", totalMemberCount);
		
		//2. 여성 회원수
		int memberFemaleCount = MemberDAO.getFemaleCount();
		System.out.println("여성 회원수 확인 : " + memberFemaleCount);
		request.setAttribute("memberFemaleCount", memberFemaleCount);
		
		//3. 남성 회원수
		int memberMaleCount = MemberDAO.getMaleCount();
		System.out.println("여성 회원수 확인 : " + memberMaleCount);
		request.setAttribute("memberMaleCount", memberMaleCount);
			
		return "/main/manager/memberChk/memberChkPage.jsp";
	}

}
