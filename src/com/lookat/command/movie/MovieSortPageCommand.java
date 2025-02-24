package com.lookat.command.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.dto.MovieDTO;
import com.lookat.vo.MovieVO;

public class MovieSortPageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderType = request.getParameter("orderType");
		System.out.println("영화 정렬 파라미터 확인용 : " + orderType);
		
		request.setAttribute("orderType", orderType);
		
		//1 예매율순
		//2 평점순
		if (orderType.equals("1")) {
			List<MovieDTO> list =  MovieDAO.getMovieListOrderByReserve();
			System.out.println("예매율순 정렬 확인 : " + list);
			request.setAttribute("movieList", list);
			return "/main/movie/movieListPage.jsp";
		} else if (orderType.equals("2")) {
			List<MovieVO> list =  MovieDAO.getMovieListOrderByStar();
			System.out.println("별점순 정렬 확인 : " + list);
			request.setAttribute("movieList", list);
			return "/main/movie/movieListPage.jsp";
		}
	
		
		return null;
	}

}
