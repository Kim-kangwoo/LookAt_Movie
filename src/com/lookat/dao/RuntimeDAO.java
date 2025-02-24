package com.lookat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lookat.mybatis.DBService;
import com.lookat.vo.RuntimeVO;

public class RuntimeDAO {
	
	// 영화관, 영화ID를 통한 런타임 가져오기
	public static List<RuntimeVO> getRuntimeList(int theaterId, int movieId, String date) {

		HashMap<String, Object> selectOption = new HashMap<String, Object>();
		selectOption.put("theaterId", theaterId);
		selectOption.put("movieId", movieId);
		selectOption.put("date", date);

		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectList("runtime.runtimeList", selectOption);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	// Runtime 테이블 날짜 추출
	public static List<String> getDateList(int theaterId, int movieId) {

		HashMap<String, Integer> selectOption = new HashMap<String, Integer>();
		selectOption.put("theaterId", theaterId);
		selectOption.put("movieId", movieId);

		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectList("runtime.dateList", selectOption);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	// 런타임 객체 하나 추출
	public static RuntimeVO getFindOneRuntime(int runtimeId) {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectOne("runtime.findOneRuntime", runtimeId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	// 남은 좌석 수 업데이트
	public static void updateLeftSeat(int runtimeId, int updateSeatCount, SqlSession sqlss) {
		
		// DAO용
		Map<String, Object> updateLeftseat = new HashMap<String, Object>();
		updateLeftseat.put("runtimeId", runtimeId);
		updateLeftseat.put("updateSeatCount", updateSeatCount);
		
		sqlss.update("runtime.updateLeftSeat", updateLeftseat);
			
	}
	
	// 남은 좌석 수 업데이트
	public static int updateLeftSeat(int runtimeId, int updateSeatCount) {
			
		// DAO용
		Map<String, Object> updateLeftseat = new HashMap<String, Object>();
		updateLeftseat.put("runtimeId", runtimeId);
		updateLeftseat.put("updateSeatCount", updateSeatCount);

		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.update("runtime.updateLeftSeat", updateLeftseat);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return -1;
			
	}
	
	
	
	
	
}
