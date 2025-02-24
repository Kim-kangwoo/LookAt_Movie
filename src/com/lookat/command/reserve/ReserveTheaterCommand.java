package com.lookat.command.reserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.dao.TheaterDAO;
import com.lookat.vo.MovieVO;
import com.lookat.vo.TheaterVO;

// Theater Command로 이름 변경
public class ReserveTheaterCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		// 남아있는 영화관 세션 삭제
		ss.removeAttribute("findTheater");
		ss.removeAttribute("theaterId");
		
		// date 세션 삭제
		ss.removeAttribute("dateList");
		ss.removeAttribute("runtimeList");
		ss.removeAttribute("theaterList");
		
		// 메인 화면에서 바로 영화 예매로 오는 경우
		Object checkMovieList = ss.getAttribute("movieList");
		if (checkMovieList == null) {
			
			List<MovieVO> movieList = MovieDAO.getMovieList();
			ss.setAttribute("movieList", movieList);
		}
		
		int movieId = Integer.parseInt(request.getParameter("movieId")); // 수정 => movieId
		
		//선택된 영화 가져오기
		MovieVO findMovie = MovieDAO.getFindOneMovie(movieId);
		
		// 영화관 목록 가져오기 
		List<TheaterVO> theaterList = TheaterDAO.getTheaterListByMovieId(movieId);
		
		// 세션 설정
		ss.setAttribute("theaterList", theaterList); // TheaterList으로 변경
		ss.setAttribute("movieId", movieId);
		ss.setAttribute("findMovie", findMovie); // findMovie로 변경
		
		
		
		return "main/reserve/reserve.jsp";
	}
	
	

}
