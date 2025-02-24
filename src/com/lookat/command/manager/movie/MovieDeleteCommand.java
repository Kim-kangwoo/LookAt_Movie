package com.lookat.command.manager.movie;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;

public class MovieDeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selectedMovieList = request.getParameterValues("deleteMovie");
		System.out.println(Arrays.toString(selectedMovieList)); 
		
		//DB 처리결과 확인
		int deleteResult = MovieDAO.deleteMovie(selectedMovieList);
		System.out.println("delete 확인용 1이면 성공: " + deleteResult);
		
		//return "/controller?command=MA_moviePage"; 
		return "/controller?command=MA_movieManagePage";
	}

}
