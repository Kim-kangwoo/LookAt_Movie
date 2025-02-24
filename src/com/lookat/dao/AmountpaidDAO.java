package com.lookat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lookat.mybatis.DBService;
import com.lookat.vo.AmountpaidVO;

public class AmountpaidDAO {

	// 결제금액 할인내역 가져오기
	public static List<AmountpaidVO> getAmountpaid(String selectPayDate, int memberId) {
		
		Map<String, Object> optionMap = new HashMap<>();
		optionMap.put("selectPayDate", selectPayDate);
		optionMap.put("memberId", memberId);
		
		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectList("amountpaid.getAmountpaid", optionMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}

	// 결제금액 결제내역 삽입
	public static void insert(int leftTotalPrice, int memberId, String discountContent, SqlSession sqlss) {
		
		Map<String, Object> optionMap = new HashMap<>();
		optionMap.put("leftTotalPrice", leftTotalPrice);
		optionMap.put("memberId", memberId);
		optionMap.put("discountContent", discountContent);
		
		sqlss.insert("amountpaid.insert", optionMap);
	}

}
