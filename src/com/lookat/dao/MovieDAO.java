package com.lookat.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lookat.dto.MovieDTO;
import com.lookat.mybatis.DBService;
import com.lookat.vo.MovieVO;

public class MovieDAO {
	
	// 영화 리스트 추출
	public static List<MovieVO> getMovieListByTheateId(int theaterId) {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("movie.getMovieListByTheateId", theaterId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	// 영화 하나 추출
	public static MovieVO getFindOneMovie(int movieId) {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectOne("movie.findOneMovie", movieId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	// 런타임 ID를 이용한 영화 이름 추출
	public static String getMovieNameByRuntimeId(Integer runtimeId) {

		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectOne("movie.getMovieNameByRuntimeId", runtimeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//------------------------------------------------------------------
	//영화 상세정보 가져오기 
	public static List<MovieVO> getMovieDetail(String movieId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("movie.movieDetail", movieId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 별점순 정렬 영화 목록
	public static List<MovieVO> getMovieListOrderByStar() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("movie.movieListOrderByStar");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 예매율순 정렬 영화 목록
	public static List<MovieDTO> getMovieListOrderByReserve() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("movie.movieListOrderByReserve");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 등록된 영화 목록
	public static List<MovieVO> getMovieList() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("movie.movieList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 등록된 영화 개수
	public static int getMovieCnt() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("movie.movieCnt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 관리자
	// 1. 영화
	// 새로운 영화 등록하기
	public static int insertMovie(MovieDTO movieDto) {
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			ss.insert("movie.movieInsert", movieDto);
			return 1; // 성공
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; // 실패
	}

	// 영화 삭제하기
	public static int deleteMovie(String[] selectedMovieList) {
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			int result = ss.delete("movie.movieDelete", selectedMovieList);
			return result; // 성공
		} catch (Exception e) {
			e.printStackTrace();
			return 0; // 실패
		}
	}

	// 수정할 영화이름, 감독이름 조회
	public static List<MovieVO> searchMovieUpdate(String searchMovieName, String searchDirectorName) {
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			Map<String, String> map = new HashMap<>();
			map.put("searchMovieName", searchMovieName);
			map.put("searchDirectorName", searchDirectorName);

			List<MovieVO> check = new ArrayList<MovieVO>();
			check = ss.selectList("movie.movieUpdateSearch", map);

			return check; // 성공

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//수정할 영화 영화 아이디로 검색
	public static List<MovieVO> searchMovieById(String movieId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("movie.movieDetail", movieId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public static int updateMovie(MovieDTO movieDto) {
		int check = -1;
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			check = ss.update("movie.movieUpdate", movieDto);

			return check; // 성공 1(update 된 행 개수)

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check; // 실패 0
	}

	// 영화 이름 가져오기
	public static String getMovieName(String movieId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("movie.getMovieName", movieId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 영화별 성별에 따른 선호도 : 여성
	public static double getMovivePreferByFemale(String movieId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("movie.getMoviePreferByFemale", movieId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 영화별 성별에 따른 선호도 : 남성
	public static double getMovivePreferByMale(String movieId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("movie.getMoviePreferByMale", movieId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//영화 통합 검색
	public static List<MovieVO> getMovieListByName(String searchValue) {
		
		System.out.println("[TEST] searchValue : " + searchValue);
		System.out.println("[TEST] searchValue.isBlank : " + searchValue.isBlank());
		if(searchValue.isBlank()) {
			
		}
		
		searchValue = "%" + searchValue + "%";
		
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("movie.getMovieListByName", searchValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	
}
