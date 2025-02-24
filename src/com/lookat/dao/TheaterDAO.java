package com.lookat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookat.dto.TheaterDTO;
import com.lookat.mybatis.DBService;
import com.lookat.vo.MovieVO;
import com.lookat.vo.TheaterVO;

public class TheaterDAO {
	
	// 영화관 목록 추출
	public static List<TheaterVO> getTheaterList () {
		
	try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("theater.theaterList");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
		
	}

	// 영화관 하나 추출
	public static TheaterVO getFindOneTheater(int theaterId) {
	
	try(SqlSession ss = DBService.getFactory().openSession()) {
		
		return ss.selectOne("theater.getFindOneTheater", theaterId);
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
	return null;
	
	}
	
	// 런타임 ID를 이용해 영화관 이름 추출
	public static String getTheaterNameByRuntimeId(Integer runtimeId) {

		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectOne("theater.getTheaterNameByRuntimeId", runtimeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	
	//---------------------------------------------------------------
	//전체 영화관 수
	public static int getTheaterCount() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("theater.getTheaterCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//각 영화관 지점별 매출, 영화관(CGV) 총매출
	public static List<TheaterDTO> getTheaterSaleList() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("theater.getTheaterSaleList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//영화관(CGV) 총매출
	public static int getTotalSale() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("theater.getTotalSale");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//영화관별 상영 영화별 매출 순위
	public static List<TheaterDTO> getTheaterMovieSaleList(String theaterId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("theater.getTheaterMovieSaleList", theaterId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 어딘지 체크
	//영화관 이름 가져오기
	public static String getTheaterName(String theaterId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("theater.getTheaterName", theaterId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//영화관별 총매출
	public static int getTheaterSale(String theaterId) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("theater.getTheaterSale", theaterId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	// 무비 ID를 이용한 영화관 리스트 추출
	public static List<TheaterVO> getTheaterListByMovieId(int movieId) {

		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectList("theater.getTheaterListByMovieId", movieId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	

}
