package com.lookat.command.manager.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;
import com.lookat.vo.MemberAndMembershipVO;

public class MemberSearchPageCommand implements Command{
	
	//null, 공백 체크
	private boolean isNullOrEmpty(String str) {
	       return str == null || str.trim().isEmpty();
	}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("searchMemName");
		String birthday = request.getParameter("searchMemBirthday");
		String phoneNum = request.getParameter("searchMemPhonenum");
		
		//관리자 입력값 검증
		String status = "";
		if (isNullOrEmpty(name) || isNullOrEmpty(birthday) || isNullOrEmpty(phoneNum)) {
			status = "null";
		} else if (phoneNum.contains("-")) { //전화번호에 - 포함되있다면
			status = "contains -";
		}
			
		List<MemberAndMembershipVO> list = MemberDAO.searchMember(name, birthday, phoneNum);
		System.out.println("검색된 회원 결과 확인 : " + list);
		request.setAttribute("status", status);
		request.setAttribute("foundMemberList", list);
		return "/controller?command=MA_memberPage";
		  
		//지금 여기로 보내지 말고 그냥 한 페이지에서 끝내보자
		//return "/main/manager/memberChk/memberSearchPage.jsp";
	}

}
