package com.lookat.command.manager.movie;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.dto.MovieDTO;
import com.lookat.vo.MovieVO;

public class MovieDetailPageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movieId = request.getParameter("movieId");
	    
	    List<MovieVO> list = MovieDAO.getMovieDetail(movieId);
	    request.setAttribute("movieList", list);
		
		return "/main/manager/movieManage/movieDetailPage.jsp";
	}

}
