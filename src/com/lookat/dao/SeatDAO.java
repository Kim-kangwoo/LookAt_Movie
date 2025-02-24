package com.lookat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lookat.mybatis.DBService;
import com.lookat.vo.SeatVO;

public class SeatDAO {
	
	// 남은좌석 추출
	public static List<SeatVO> getLeftSeatList(int selectRuntimeId) {

		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.leftSeat", selectRuntimeId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	// 전체 좌석 추출
	public static List<SeatVO> getSeatList() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.seatList");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	// 전체 좌석 추출
	public static int getSeatTotalCount() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectOne("seat.getSeatTotalCount");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return -1;
	}
	
	// 좌석테이블 가격 추출
	public static int getTotalPrice(String[] seatIdList) {

		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectOne("seat.getTotalPrice", seatIdList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;

	}
	
	// 결제일과 멤버ID를 이용해 해당 결제일 총 결제 금액 추출
	public static int getTotalPriceByPayDate(String payDate, int memberId) {

		Map<String, Object> optionMap = new HashMap<String, Object>();
		optionMap.put("payDate", payDate);
		optionMap.put("memberId", memberId);

		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectOne("seat.getTotalPriceByPayDate", optionMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static List<SeatVO> getSeatA1to6() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.getSeatA1to6");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static List<SeatVO> getSeatA7to12() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.getSeatA7to12");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	public static List<SeatVO> getSeatA13to18() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.getSeatA13to18");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static List<SeatVO> getSeatA19to24() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.getSeatA19to24");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	public static List<SeatVO> getSeatB1to6() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.getSeatB1to6");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	public static List<SeatVO> getSeatB7to12() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.getSeatB7to12");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	public static List<SeatVO> getSeatC1to6() {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectList("seat.getSeatC1to6");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
}
