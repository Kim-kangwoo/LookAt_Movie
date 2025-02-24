package com.lookat.command.manager.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.vo.MovieVO;

public class MovieUpdateByIdCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //체크박스 선택해서 영화 수정하는 거 기능 구현 추가 
		 //int movieId = Integer.parseInt(request.getParameter("updateMovieId"));
		 String movieId = request.getParameter("movieId"); 
		 System.out.println("체크박스로통해 온 movieId : " + movieId); 
		
		 List<MovieVO> searchResult = MovieDAO.searchMovieById(movieId);
		 System.out.println("확인용 : " + searchResult);
		 
		 String status = ""; 
		 if (searchResult.isEmpty()) { 
			 status = "조회 실패.";
		}
		 status = "조회 성공.";
		 request.setAttribute("status", status); 
		 request.setAttribute("searchResult", searchResult); 
		 return "/main/manager/movieManage/movieUpdateSearch.jsp";
			 
		
	}

}
