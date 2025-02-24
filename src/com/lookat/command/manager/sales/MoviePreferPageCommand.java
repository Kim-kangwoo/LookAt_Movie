package com.lookat.command.manager.sales;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.dto.PreferDTO;

public class MoviePreferPageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieId = request.getParameter("movieId");
		System.out.println("movieId 확인용 : " + movieId);
		
		//영화 이름
		String movieName = MovieDAO.getMovieName(movieId);
		System.out.println("영화 이름 확인용 : " + movieName);
		request.setAttribute("movieName", movieName);
		
		//연령대별 선호도
//		List<E> agePreferList = MovieDAO.getMoviePreferByAge();
//		System.out.println("연령대별 영화 선호도 확인용 : " + agePreferList);
//		request.setAttribute("agePreferList", agePreferList);
		
		//성별 선호도
		// 여성 비율
		double femalePercentage = MovieDAO.getMovivePreferByFemale(movieId);
		System.out.println("성별 영화 선호도 확인용 - 여성 : " + femalePercentage);
		request.setAttribute("femalePercentage", femalePercentage);
		
		//남성 비율
		double malePercentage = MovieDAO.getMovivePreferByMale(movieId);
		System.out.println("성별 영화 선호도 확인용 - 남성 : " + malePercentage);
		request.setAttribute("malePercentage", malePercentage);
		
		return "/main/manager/data/moviePreferPage.jsp";
	}

}
