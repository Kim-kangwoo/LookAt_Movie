package com.lookat.command.reserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;
import com.lookat.dao.MovieDAO;
import com.lookat.dao.TheaterDAO;
import com.lookat.vo.MemberVO;
import com.lookat.vo.MovieVO;
import com.lookat.vo.TheaterVO;

public class ReserveSwitchCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "main/reserve/switch.jsp";
	}
	
	

}
