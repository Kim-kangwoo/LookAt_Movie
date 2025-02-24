package com.lookat.command.theater;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.TheaterDAO;
import com.lookat.vo.TheaterVO;

public class TheaterListPageCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TheaterVO> list = TheaterDAO.getTheaterList();
		System.out.println("극장 목록 확인용 : " + list);
		request.setAttribute("theaterList", list);
		
		return "main/theater/theaterListPage.jsp";
	}

}
