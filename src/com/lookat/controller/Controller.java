package com.lookat.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.command.MainPageCommand;
import com.lookat.command.cancelreserve.CancelReserveCommand;
import com.lookat.command.cancelreserve.CancelReservePageCommand;
import com.lookat.command.error.ServerErrorPageCommand;
import com.lookat.command.join.JoinAgreePageCommand;
import com.lookat.command.join.JoinCheckCommand;
import com.lookat.command.join.JoinCheckPageCommand;
import com.lookat.command.join.JoinCommand;
import com.lookat.command.join.JoinPageCommand;
import com.lookat.command.join.NicknameDuplicateCheckCommand;
import com.lookat.command.login.FindIdCommand;
import com.lookat.command.login.FindIdPageCommand;
import com.lookat.command.login.FindPwdCommand;
import com.lookat.command.login.FindPwdPageCommand;
import com.lookat.command.login.LogOutCommand;
import com.lookat.command.login.LoginCommand;
import com.lookat.command.login.LoginPageCommand;
import com.lookat.command.manager.data.DataPageCommand;
import com.lookat.command.manager.member.MemberChkPageCommand;
import com.lookat.command.manager.member.MemberListPageCommand;
import com.lookat.command.manager.member.MemberSearchPageCommand;
import com.lookat.command.manager.member.MembershipListPageCommand;
import com.lookat.command.manager.movie.MovieDeleteCommand;
import com.lookat.command.manager.movie.MovieDeletePageCommand;
import com.lookat.command.manager.movie.MovieDetailPageCommand;
import com.lookat.command.manager.movie.MovieInsertCommand;
import com.lookat.command.manager.movie.MovieInsertPageCommand;
import com.lookat.command.manager.movie.MovieManagePageCommand;
import com.lookat.command.manager.movie.MovieUpdateByIdCommand;
import com.lookat.command.manager.movie.MovieUpdateCommand;
import com.lookat.command.manager.movie.MovieUpdatePageCommand;
import com.lookat.command.manager.movie.MovieUpdateSearchCommand;
import com.lookat.command.manager.sales.MoviePreferPageCommand;
import com.lookat.command.manager.sales.SalesChkPageCommand;
import com.lookat.command.manager.sales.TheaterSalePageCommand;
import com.lookat.command.movie.MovieListCommand;
import com.lookat.command.movie.MovieListPageCommand;
import com.lookat.command.movie.MovieSortPageCommand;
import com.lookat.command.movie.MovieTotalSearchCommand;
import com.lookat.command.mylookat.LookatCommand;
import com.lookat.command.mylookat.LookatDeleteMemberPageCommand;
import com.lookat.command.mylookat.LookatMyPageCommand;
import com.lookat.command.mylookat.LookatPointCommand;
import com.lookat.command.mylookat.LookatPwdCheckCommand;
import com.lookat.command.mylookat.LookatSuccessDeleteMemberCommand;
import com.lookat.command.mylookat.update.LookatUpdateBirthdayCommand;
import com.lookat.command.mylookat.update.LookatUpdateCommand;
import com.lookat.command.mylookat.update.LookatUpdateNameCommand;
import com.lookat.command.mylookat.update.LookatUpdateNicknameCommand;
import com.lookat.command.mylookat.update.LookatUpdatePageCommand;
import com.lookat.command.mylookat.update.LookatUpdatePhoneCommand;
import com.lookat.command.mylookat.update.LookatUpdatepasswordCommand;
import com.lookat.command.myreservepage.MyReservePageCommand;
import com.lookat.command.myreservepage.MyReservePageDayCommand;
import com.lookat.command.myreservepage.MyReservePageTotalCommand;
import com.lookat.command.myreservepage.MyReserveSessionDeleteCommand;
import com.lookat.command.reserve.ReserveAllCommand;
import com.lookat.command.reserve.ReserveCommand;
import com.lookat.command.reserve.ReserveCompleteCheckCommand;
import com.lookat.command.reserve.ReserveCompleteRevCommand;
import com.lookat.command.reserve.ReserveDateCommand;
import com.lookat.command.reserve.ReservePaymentPageCommand;
import com.lookat.command.reserve.ReserveSeatCommand;
import com.lookat.command.reserve.ReserveSwitchCommand;
import com.lookat.command.reserve.ReserveTheaterCommand;
import com.lookat.command.reserve.ReserveTimeCommand;
import com.lookat.command.serviceCeter.LookatServiceCeterCommand;
import com.lookat.command.theater.TheaterListPageCommand;

@WebServlet("/controller")
public class Controller extends HttpServlet {
		
	private Map<String, Command> map = new HashMap<>();
	
	
	@Override
	public void init() throws ServletException {
		
		//메인 페이지 전환
		map.put("mainPage", new MainPageCommand());
		
		
		//로그인 ----------------------
		map.put("loginPage", new LoginPageCommand()); // 로그인 페이지로 이동
		map.put("login", new LoginCommand()); // 로그인
		map.put("findIdPage", new FindIdPageCommand()); // 아이디 찾기 페이지로 이동
		map.put("findId", new FindIdCommand()); // 아이디 찾기
		map.put("findPwdPage", new FindPwdPageCommand()); // 비밀번호 찾기 페이지로 이동
		map.put("findPwd", new FindPwdCommand()); // 비밀번호 찾기
		// map.put("join", new JoinPageCommand()); //회원가입 하기
		map.put("logOut", new LogOutCommand()); // 로그아웃 하기
		
		//영화 목록 ---------------------- 
		map.put("moviePage", new MovieListPageCommand()); // 영화 목록 페이지로 이동
		map.put("movieSortPage", new MovieSortPageCommand()); // 영화 정렬하기
		map.put("movieDetailPage", new MovieListCommand()); // 영화 상세 목록
		
		//관리자 ----------------------
		// 1. 영화
		map.put("MA_movieManagePage", new MovieManagePageCommand()); // 영화 정보 관리 페이지로 이동
		map.put("MA_movieInsertPage", new MovieInsertPageCommand()); // 영화 등록 페이지로 이동
		map.put("MA_movieInsert", new MovieInsertCommand()); // 영화 등록
		map.put("MA_movieUpdatePage", new MovieUpdatePageCommand()); // 영화 정보 수정 페이지로 이동
		map.put("MA_movieUpdateById", new MovieUpdateByIdCommand()); // 영화 수정 정보 입력 페이지로 이동
		map.put("MA_movieUpdateSearch", new MovieUpdateSearchCommand()); // 영화 정보 수정할 영화 이름 검색
		map.put("MA_movieUpdate", new MovieUpdateCommand()); // 영화 정보 수정
		map.put("MA_movieDetailPage", new MovieDetailPageCommand()); // 수정 후 확인용 영화상세페이지
		map.put("MA_movieDeletePage", new MovieDeletePageCommand()); // 영화 삭제 페이지로 이동
		map.put("MA_movieDelete", new MovieDeleteCommand()); // 영화 삭제
		
		map.put("movieTotalSearch", new MovieTotalSearchCommand()); // 영화 통합 검색

		
		//2. 매출 관리
		map.put("MA_salesPage", new SalesChkPageCommand()); // 매출 관리 페이지로 이동 --바로 데이터 띄우면 될듯
		map.put("MA_theaterSalePage", new TheaterSalePageCommand()); // 영화관별 매출 페이지로 이동

		// 3. 통계
		map.put("MA_dataPage", new DataPageCommand()); // 영화별 성별, 연령별 선호도. 기타등등
		map.put("MA_moviePreferPage", new MoviePreferPageCommand()); // 영화별 (성별, 연령별)통계 페이지

		// 4. 회원 관리
		map.put("MA_memberPage", new MemberChkPageCommand()); // 회원 관리 페이지로 이동
		map.put("MA_memberListPage", new MemberListPageCommand()); // 일반 회원 목록 보기(페이지로 이동)
		map.put("MA_membershipListPage", new MembershipListPageCommand()); // 멤버십 회원 목록 보기(페이지로 이동)
		map.put("MA_memberSearch", new MemberSearchPageCommand()); // 회원 검색 하기


		
		
		
		// 회원가입
		map.put("joinCheckPage", new JoinCheckPageCommand()); // 회원가입 여부 처리 페이지로 이동
		map.put("joinCheck", new JoinCheckCommand()); // 회원가입 여부 처리
		map.put("joinAgreePage", new JoinAgreePageCommand()); // 회원가입 전 이용약관 동의 페이지로 이동
		map.put("joinPage", new JoinPageCommand()); // 회원가입 페이지로 이동
		map.put("nicknameDuplicateCheck", new NicknameDuplicateCheckCommand()); // 닉네임 중복 체크
		map.put("join", new JoinCommand()); // 회원가입
		
		
		
		
		// My Look at (내 정보 확인)
		map.put("myLookatPwdCheck", new LookatPwdCheckCommand()); // My Look at 접근 시 비밀번호 입력을 위한 커맨드
		map.put("myPage", new LookatMyPageCommand());
		map.put("myLookAt", new LookatCommand()); // 내정보조회
		map.put("myUpdatePage", new LookatUpdatePageCommand()); // 내정보관리 페이지이동
		map.put("myPoint", new LookatPointCommand()); // 포인트 조회
		
		// 회원정보 변경
		map.put("update", new LookatUpdateCommand()); // 변경하고자하는 페이지로 전환 커맨드
		map.put("updatePassword", new LookatUpdatepasswordCommand()); // 비밀번호 변경
		map.put("updateName", new LookatUpdateNameCommand()); 		    // 이름 변경
		map.put("updateNickname", new LookatUpdateNicknameCommand()); // 닉네임 변경
		map.put("updatePhone", new LookatUpdatePhoneCommand());			// 핸드폰 변경
		map.put("updateBirthday", new LookatUpdateBirthdayCommand());		// 생일 변경
		
		// 회원삭제 
		map.put("deleteMember", new LookatDeleteMemberPageCommand());	// 회원 삭제 페이지로 이동	
		map.put("successDelete", new LookatSuccessDeleteMemberCommand()); // 회원 삭제 커맨드
		
		// 예매
		map.put("reserve", new ReserveCommand());
		map.put("reserveTheater", new ReserveTheaterCommand());
		map.put("reserveDate", new ReserveDateCommand());
		map.put("reserveRuntime", new ReserveTimeCommand());
		map.put("reserveAll", new ReserveAllCommand());
		map.put("reserveSeat", new ReserveSeatCommand());
		map.put("reservePaymentPage", new ReservePaymentPageCommand());
		map.put("reserveCompleteCheck", new ReserveCompleteCheckCommand());
		map.put("reserveCompleteRev", new ReserveCompleteRevCommand());
		map.put("reserveSwitch", new ReserveSwitchCommand());
		
		
		// 취소
		map.put("cancelReservePage", new CancelReservePageCommand());
		map.put("cancelReserve", new CancelReserveCommand());
		
		// 예매 내역 확인
		map.put("myReservePage", new MyReservePageCommand());
		map.put("myReserveTotalPage", new MyReservePageTotalCommand());
		map.put("myReserveDayPage", new MyReservePageDayCommand());
		map.put("myReserveSessionDelete", new MyReserveSessionDeleteCommand());
		
		// 서버 오류 페이지
		map.put("serverErrorPage", new ServerErrorPageCommand());
		
		
		// 고객센터
		map.put("serviceCeter", new LookatServiceCeterCommand());
		
		//nav - 극장
		map.put("theater", new TheaterListPageCommand());

	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contents = request.getParameter("command");
		
		// Ajax 사용 용도 contents = jobType
		if ("nicknameDuplicateCheck".equals(contents)) {
            new NicknameDuplicateCheckCommand().exec(request, response);
            return;
        }
		
		if (contents == null) {
			// 커맨드가 null일 때
			response.sendRedirect("main/serverErrorPage.jsp");
			return;
		}
		
		
		Command comm = map.get(contents);
		String path = comm.exec(request, response);
		
		// 다른 페이지로 이동
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		
	}
	
}
