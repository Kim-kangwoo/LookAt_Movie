package com.lookat.command.manager.movie;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.vo.MovieVO;

public class MovieUpdateSearchCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		 * //체크박스 선택해서 영화 수정하는 거 기능 구현 추가 int movieId =
		 * Integer.parseInt(request.getParameter("movieId"));
		 * System.out.println("체크박스로통해 온 movieId : " + movieId); if (movieId > 0) {
		 * List<MovieVO> searchResult = MovieDAO.searchMovieUpdate(movieId); String
		 * status = ""; if (searchResult.isEmpty()) { status = "no movie found";
		 * request.setAttribute("status", status); return
		 * "/controller?command=MA_movieUpdatePage"; } else {
		 * request.setAttribute("searchResult", searchResult); return
		 * "/main/manager/movieManage/movieUpdateSearch.jsp"; } }
		 */
		
		String searchMovieName = request.getParameter("searchMovieName");
		String searchDirectorName = request.getParameter("searchDirectorName");
		System.out.println("[수정] 영화 이름, 감독이름 확인용 : " + searchMovieName + ", " + searchDirectorName);
		
		List<MovieVO> searchResult = MovieDAO.searchMovieUpdate(searchMovieName, searchDirectorName);
		System.out.println("[수정] DB조회후 일치하는 영화, 감독's 영화 : " + searchResult);
		
		
		//DB조회후 리턴 데이터 검증
		String status = "";
		if (searchResult.isEmpty()) {
			status = "일치하는 영화가 없습니다.";
			request.setAttribute("status", status);
			return "/main/manager/movieManage/movieUpdateSearch.jsp";
		}
		
		status = "조회 성공.";
		request.setAttribute("status", status);
		request.setAttribute("searchResult", searchResult);
		return "/main/manager/movieManage/movieUpdateSearch.jsp";
	}

}
