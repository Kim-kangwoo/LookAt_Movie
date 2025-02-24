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
import com.lookat.dao.SeatDAO;
import com.lookat.dao.TheaterDAO;
import com.lookat.vo.MovieVO;
import com.lookat.vo.RuntimeVO;
import com.lookat.vo.SeatVO;
import com.lookat.vo.TheaterVO;

public class ReserveSeatCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 좌석선택(ReserveSeat) 페이지 전환 ------------------------
		// 좌석선택(ReserveSeat)에 가지고 있어야 하는 데이터 목록
		// memberId(세션에 포함), runtimeId, seatList(전체좌석, 잔여좌석들), theaterId, movieId
		
		// 포함되지 않은 좌석만 표시 (어떻게??) // html 구조는 동일하게 출력, 예매 안된 것만 css다르게 추가
		// c:foreach 문을 통해 구조 출력 시 예매 안된 name 비교 
		// 같으면 css 추가 된 html 출력
		HttpSession ss = request.getSession();
		
		// runtimeId, theaterId, movieId를 통해 정보 가져오기
		int runtimeId = (int) ss.getAttribute("runtimeId");
		int theaterId = (int) ss.getAttribute("theaterId");
		int movieId = (int) ss.getAttribute("movieId");
		
		TheaterVO findTheater = TheaterDAO.getFindOneTheater(theaterId);
		MovieVO findMovie = MovieDAO.getFindOneMovie(movieId);
		RuntimeVO findRuntime = RuntimeDAO.getFindOneRuntime(runtimeId);
		
		ss.setAttribute("findTheater", findTheater);
		ss.setAttribute("findMovie", findMovie);
		ss.setAttribute("findRuntime", findRuntime);
		
		// seatList(전체좌석) / leftSeatList(잔여좌석) 데이터 추출 / 넘겨주기

		// 1. 전체 좌석 데이터 추출
		int totalSeatCount  = SeatDAO.getSeatTotalCount(); // 전체좌석 카운트 42석
			
		// 2. 상영시간번호(selectRuntimeId)로 잔여좌석 확인
		// 상영시간 보여주고 잔여좌석 표시
		List<SeatVO> leftSeatList = SeatDAO.getLeftSeatList(findRuntime.getRuntimeId());
		
		// 등급별 좌석 추출
		// A좌석리스트 (1 ~ 6)
		List<SeatVO> SeatA1to6 = SeatDAO.getSeatA1to6();
		// A좌석리스트 (7 ~ 12)
		List<SeatVO> SeatA7to12 = SeatDAO.getSeatA7to12();
		// A좌석리스트 (13 ~ 18) 
		List<SeatVO> SeatA13to18 = SeatDAO.getSeatA13to18();
		// A좌석리스트 (19 ~ 24)
		List<SeatVO> SeatA19to24 = SeatDAO.getSeatA19to24();
		// B좌석리스트 (1 ~ 6)
		List<SeatVO> SeatB1to6 = SeatDAO.getSeatB1to6();
		// B좌석리스트 (7 ~ 12)
		List<SeatVO> SeatB7to12 = SeatDAO.getSeatB7to12();
		// C좌석리스트 (1 ~ 6)
		List<SeatVO> SeatC1to6 = SeatDAO.getSeatC1to6();
		
		
		ss.setAttribute("leftSeatList", leftSeatList);
		ss.setAttribute("totalSeatCount", totalSeatCount);
		request.setAttribute("SeatA1to6", SeatA1to6);
		request.setAttribute("SeatA7to12", SeatA7to12);
		request.setAttribute("SeatA13to18", SeatA13to18);
		request.setAttribute("SeatA19to24", SeatA19to24);
		request.setAttribute("SeatB1to6", SeatB1to6);
		request.setAttribute("SeatB7to12", SeatB7to12);
		request.setAttribute("SeatC1to6", SeatC1to6);
		
		
		return "main/reserve/reserveSeat.jsp";
	}
	
	

}
