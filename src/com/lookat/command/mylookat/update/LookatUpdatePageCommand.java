package com.lookat.command.mylookat.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.vo.MemberVO;

public class LookatUpdatePageCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업데이트 페이지로 이동 커맨드
		
		return "main/mylookat/info/myUpdatePage.jsp";
	}

};
