package com.lookat.command.manager.sales;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.TheaterDAO;
import com.lookat.dto.TheaterDTO;

public class TheaterSalePageCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theaterId = request.getParameter("theaterId");
		System.out.println("theaterId 확인용 : " + theaterId);
		
		//영화관 이름
		String theaterName = TheaterDAO.getTheaterName(theaterId);
		System.out.println("영화관 이름 확인용 : " + theaterName);
		request.setAttribute("theaterName", theaterName);
		
		
		//영화관별 상영 영화, 영화별 매출
		List<TheaterDTO> list = TheaterDAO.getTheaterMovieSaleList(theaterId);
		System.out.println("영화관별 상영 영화, 영화별 매출 확인용 : " + list);
		request.setAttribute("movieSaleList", list);
		
		
		//영화관별 총매출
		int theaterSale = TheaterDAO.getTheaterSale(theaterId);
		System.out.println("영화관별 총매출 확인 : " + theaterSale);
		request.setAttribute("theaterSale", theaterSale);
		
		
		return "/main/manager/saleChk/theaterSalePage.jsp";
	}

}
