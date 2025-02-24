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

public class MovieListPageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MovieDTO> list = MovieDAO.getMovieListOrderByReserve(); //그냥 기본 정렬을 예매율순으로 함
		System.out.println("전체 영화 목록 확인 : " + list);
		request.setAttribute("movieList", list);
		
		
		return "/main/movie/movieListPage.jsp";
	}

}
