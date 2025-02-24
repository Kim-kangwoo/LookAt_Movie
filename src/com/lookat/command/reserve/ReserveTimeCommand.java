package com.lookat.command.reserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.RuntimeDAO;
import com.lookat.vo.RuntimeVO;

public class ReserveTimeCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		
		// 영화관, 영화 ID 상영일로 시간 가져오기 
		int theaterId = (int) ss.getAttribute("theaterId");
		int movieId = (int) ss.getAttribute("movieId");
		String date = request.getParameter("date");
		
		// 시간  가져오기
		List<RuntimeVO> runtimeList = RuntimeDAO.getRuntimeList(theaterId, movieId, date);
		
		ss.setAttribute("date", date);
		ss.setAttribute("runtimeList", runtimeList);
		
		return "main/reserve/reserve.jsp";
	}
	
	

}
