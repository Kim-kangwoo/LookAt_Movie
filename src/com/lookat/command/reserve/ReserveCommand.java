package com.lookat.command.reserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;
import com.lookat.dao.MovieDAO;
import com.lookat.dao.ReserveDAO;
import com.lookat.dao.TheaterDAO;
import com.lookat.vo.MemberVO;
import com.lookat.vo.MovieVO;
import com.lookat.vo.TheaterVO;

public class ReserveCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		ss.removeAttribute("theaterList");
		ss.removeAttribute("findMovie");
		ss.removeAttribute("findTheater");
		ss.removeAttribute("runtimeList");
		ss.removeAttribute("dateList");
		ss.removeAttribute("movieId");
		ss.removeAttribute("theaterId");
		ss.removeAttribute("date");
		ss.removeAttribute("runtimeId");
		
		List<MovieVO> movieList = MovieDAO.getMovieList();
		
		ss.setAttribute("movieList", movieList);
		
		return "main/reserve/reserve.jsp";
	}
	
	

}
