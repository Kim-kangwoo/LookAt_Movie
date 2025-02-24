package com.lookat.command.manager.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.dto.MovieDTO;

public class MovieInsertCommand implements Command{
	
	//null, 공백 체크
	private boolean isNullOrEmpty(String str) {
	       return str == null || str.trim().isEmpty();
	}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieName = request.getParameter("movieName");
	    String movieType = request.getParameter("movieType");
	    String movieDirector = request.getParameter("movieDirector");
	    String movieStudio = request.getParameter("movieStudio");
	    String movieActor = request.getParameter("movieActor");
	    String movieStory = request.getParameter("movieStory");
	    String movieImgPath = request.getParameter("movieImgPath");
	    double movieStar = Double.parseDouble(request.getParameter("movieStar"));
	    

	    String status = "";
	    // null 체크
	    if (isNullOrEmpty(movieName) || isNullOrEmpty(movieType) || isNullOrEmpty(movieDirector) || 
	    		isNullOrEmpty(movieStudio) || isNullOrEmpty(movieActor)|| isNullOrEmpty(movieStory)
	    		|| isNullOrEmpty(movieImgPath) ) {
	        status = "null or empty";
	    	request.setAttribute("status", status);
	        return "/main/manager/movieManage/movieInsertPage.jsp"; 
	    }
		
		MovieDTO movieDto = new MovieDTO(
				movieName, movieType, movieDirector, movieStudio, movieActor, movieStory, movieImgPath, movieStar
		);
		
		int result = MovieDAO.insertMovie(movieDto); //성공 1   실패 0
		if (result == 0) { 
			status = "insert fail";
			System.out.println(result + " "  + status);
		} if (result == 1) {
			System.out.println("1이면 성공임 : " + result);
			status = "insert success";
		}
		
		request.setAttribute("status", status);
		return "/main/manager/movieManage/movieInsertPage.jsp";
		//return "/controller?command=MA_movieManagePage";
	}

}
