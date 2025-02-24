package com.lookat.command.manager.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.vo.MovieVO;

public class MovieDeletePageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//등록된 영화 목록
		List<MovieVO> movieList = MovieDAO.getMovieList();
		request.setAttribute("movieList", movieList);
		
		return "/main/manager/movieManage/movieDeletePage.jsp";
	}

}
