package com.lookat.command.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.vo.MovieVO;


public class MovieListCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movieId = request.getParameter("movieId");
		System.out.println("movieId 파라미터 확인 : " + movieId);
		
		List<MovieVO> list = MovieDAO.getMovieDetail(movieId);
		System.out.println("가져온 영화 상세정보 확인 : " + list);
		request.setAttribute("movieDetailList", list);
		
		//성별 선호도
		// 여성 비율
		double femalePercentage = MovieDAO.getMovivePreferByFemale(movieId);
		System.out.println("성별 영화 선호도 확인용 - 여성 : " + femalePercentage);
		request.setAttribute("femalePercentage", femalePercentage);
		
		//남성 비율
		double malePercentage = MovieDAO.getMovivePreferByMale(movieId);
		System.out.println("성별 영화 선호도 확인용 - 남성 : " + malePercentage);
		request.setAttribute("malePercentage", malePercentage);
		
		return "/main/movie/detail/movieDetailPage.jsp";
		
		
	}

}
