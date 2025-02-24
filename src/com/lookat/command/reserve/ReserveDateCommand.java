package com.lookat.command.reserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.dao.RuntimeDAO;
import com.lookat.dao.TheaterDAO;
import com.lookat.vo.MovieVO;
import com.lookat.vo.TheaterVO;

public class ReserveDateCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		ss.removeAttribute("date");
		
		
		// 영화관, 영화 ID로 상영시간 가져오기 
		int movieId = (int) ss.getAttribute("movieId"); // movieId
		int theaterId = Integer.parseInt(request.getParameter("theaterId")); // theaterId
		ss.setAttribute("theaterId", theaterId);
		
		// 예매 가능 월 가져오기
		List<String> dateList = RuntimeDAO.getDateList(theaterId, movieId);
		// 선택된 영화관 가져오기
		TheaterVO findTheater = TheaterDAO.getFindOneTheater(theaterId);
		
		ss.setAttribute("dateList", dateList);
		ss.setAttribute("findTheater", findTheater);
		
		return "main/reserve/reserve.jsp";
	}
	
	

}
