package com.lookat.command.manager.data;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.MovieDAO;
import com.lookat.vo.MovieVO;

public class DataPageCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상영 중인 영화 목록 => 제목 누르면 성별, 나이대별 선호도
		List<MovieVO> list =  MovieDAO.getMovieList();
		System.out.println("상영 중인 영화 목록 확인용 : " + list);
		request.setAttribute("movieList", list);
		
		
		return "/main/manager/data/dataPage.jsp";
	}

}
