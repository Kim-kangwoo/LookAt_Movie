package com.lookat.command.mylookat;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Delete;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;

public class LookatDeleteMemberPageCommand  implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//delete 페이지로 이동
		
	        return "main/mylookat/delete/deleteMember.jsp";  // 삭제된 후 이동할 JSP 페이지
	    }
	}
		

	
	

