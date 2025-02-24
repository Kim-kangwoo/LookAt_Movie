package com.lookat.command.manager.sales;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.dao.TheaterDAO;
import com.lookat.dto.MovieDTO;
import com.lookat.dto.TheaterDTO;
import com.lookat.vo.MovieVO;
import com.lookat.vo.TheaterVO;

public class SalesChkPageCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//이후 구현 가능하면 해보기
				//상영관별 매출  
				//연령대별 매출 -> 칼럼 추가한다면 해보기 
		
		//등록된 영화관 수, 총  영화관 정보
		List<TheaterVO> list1 = TheaterDAO.getTheaterList();
		System.out.println("영화관 정보 확인용 : " + list1);
		request.setAttribute("theaterList", list1);
		
		//영화관 수
		int countTheater = TheaterDAO.getTheaterCount();
		System.out.println("영화관 개수 확인용 : " + countTheater);
		request.setAttribute("countTheater", countTheater);
		
		//각 영화관 지점별 매출
		List<TheaterDTO> list2 = TheaterDAO.getTheaterSaleList();
		System.out.println("영화관별 매출 확인용 : " + list2);
		request.setAttribute("theaterSaleList", list2);
		
		//영화관(CGV) 총매출
		int totalSale = TheaterDAO.getTotalSale();
		System.out.println("총매출 확인용 : " + totalSale);
		request.setAttribute("totalSale", totalSale);
		
		
		//영화별 매출 
		//List<MovieVO> list =  MovieDAO.getMovieListOrderByReserve();
		List<MovieDTO> list = MovieDAO.getMovieListOrderByReserve();
		
		
		//성별 매출 
		
		
		return "/main/manager/saleChk/saleChkPage.jsp";
	}

}
