package com.lookat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lookat.mybatis.DBService;
import com.lookat.vo.MemberVO;
import com.lookat.vo.MovieVO;
import com.lookat.vo.ReserveVO;
import com.lookat.vo.RuntimeVO;
import com.lookat.vo.SeatVO;
import com.lookat.vo.TheaterVO;

public class ReserveDAO {
	

	// 예약 삽입
	public static void insertReserve(Map<String, Object> reserveInsertMap, SqlSession sqlss) {
		
		sqlss.insert("reserve.reserveInsert", reserveInsertMap);
			
	}
	
	
	// 멤버ID를 이용한 예약 리스트 추출
	public static List<ReserveVO> getReserveList(int memberId) {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("reserve.getReserveList", memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	// PayDate를 이용한 예약 리스트 추출
	public static List<ReserveVO> getReserveListByPayDate(int memberId, String selectPayDate) {
		
		Map<String, Object> optionMap = new HashMap<String, Object>();
		optionMap.put("memberId", memberId);
		optionMap.put("selectPayDate", selectPayDate);
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("reserve.getReserveListByPayDate", optionMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	
	// 중복을 제거한 결제일 리스트 추출
	public static List<String> getPayDateList(int memberId) {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("reserve.getPayDateList", memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	// memberId를 이용한 중복 제거 runtimeId 추출
	public static List<Integer> getRuntimeIdDis(int memberId) {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("reserve.getRuntimeIdDis", memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	// 예약넘버를 이용한 예약 삭제
	public static int deleteReserve(int reserveNum) {
		
		try(SqlSession ss = DBService.getFactory().openSession(true)) {
			
			return ss.delete("reserve.deleteReserve", reserveNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return -1;
	}
	
	// 예매횟수 조회 MEMBER_ID 이용
		public static int getReserveCount(int memberId, SqlSession sqlss) {
			
			return sqlss.selectOne("reserve.getReserveCount", memberId);
		}

	
}
