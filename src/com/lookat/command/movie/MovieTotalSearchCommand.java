package com.lookat.command.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.vo.MovieVO;

public class MovieTotalSearchCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목적 : 통합 검색 페이지로 결과 전달 및 페이지 표시
		
		// 입력 받은 값을 통해 영화 검색
		String searchValue = request.getParameter("searchValue");
		
		// DAO를 통해 전달
		List<MovieVO> findMovieList = MovieDAO.getMovieListByName(searchValue);
		System.out.println("[MovieTotalSearchCommand] findMovieList : " + findMovieList);
		
		// 검색 결과를 화면에 표시 
		request.setAttribute("findMovieList", findMovieList);
		request.setAttribute("searchValue", searchValue);
		
		return "main/totalSearch.jsp";
	}

	
	
}
