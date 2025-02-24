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

public class MovieUpdateCommand implements Command{
	
	//null, 공백 체크
		private boolean isNullOrEmpty(String str) {
		       return str == null || str.trim().isEmpty();
		}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String movieName = request.getParameter("movieName");
	    String movieType = request.getParameter("movieType");
	    String movieDirector = request.getParameter("movieDirector");
	    String movieStudio = request.getParameter("movieStudio");
	    String movieActor = request.getParameter("movieActor");
	    String movieStory = request.getParameter("movieStory");
	    String movieImgPath = request.getParameter("movieImgPath");
	    double movieStar = Double.parseDouble(request.getParameter("movieStar"));
	    
	    System.out.println("사용자 입력 수정 내용 확인용 :  " + movieId + ", " + movieName + ", " + movieType
		 + ", " + movieDirector + ", " + movieStudio + ", " + movieActor + ", " + movieImgPath + ", " + movieStar );
	    
	    //입력값 확인
	    String error = "";
	    // null 체크
	    if (isNullOrEmpty(movieName) || isNullOrEmpty(movieType) || isNullOrEmpty(movieDirector) || 
	    		isNullOrEmpty(movieStudio) || isNullOrEmpty(movieActor)|| isNullOrEmpty(movieStory) || isNullOrEmpty(movieImgPath)) {
	        error = "null or empty";
	    	request.setAttribute("error", error);
	        return "/controller?command=MA_movieUpdateSearch";  //또 command로 날려야되네
	    }
	    
	    MovieDTO movieDto = new MovieDTO(
	    		movieId, movieName, movieType, movieDirector, movieStudio, movieActor, movieStory, movieImgPath, movieStar
		);
		
		//DB 처리결과 확인 
		int updateResult = MovieDAO.updateMovie(movieDto);
		System.out.println("update 확인용 : " + updateResult); 
		
		String result = "";
		if (updateResult == 1) {
			result = "update Success";
		} else {
			result = "update Fail";
		}
		request.setAttribute("result", result);
		return "/controller?command=MA_movieUpdateSearch"; 
		//return "/controller?command=MA_movieManagePage"; 
	}

}
