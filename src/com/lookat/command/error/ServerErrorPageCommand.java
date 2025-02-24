package com.lookat.command.error;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.ReserveDAO;
import com.lookat.vo.MemberVO;
import com.lookat.vo.MovieVO;
import com.lookat.vo.RuntimeVO;
import com.lookat.vo.SeatVO;
import com.lookat.vo.TheaterVO;

public class ServerErrorPageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		return "main/serverErrorPage.jsp";
	}
	
	

}
