package com.lookat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lookat.dto.MemberDTO;
import com.lookat.mybatis.DBService;
import com.lookat.vo.CouponVO;

public class CouponDAO {	
	
	// 멤버쉽ID를 통해 보유하고 있는 쿠폰 조회
	public static List<CouponVO> findCoupon (int membershipId) {

		try (SqlSession ss = DBService.getFactory().openSession()) {

			return ss.selectList("coupon.findCoupon", membershipId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	// 멤버쉽ID, 쿠폰ID 활용 사용한 쿠폰 업데이트
	public static void deleteCoupon(int membershipId, int couponValue, SqlSession sqlss) {
		
		Map<String, Integer> optionMap = new HashMap<>();
		optionMap.put("membershipId", membershipId);
		optionMap.put("couponValue", couponValue);
		
		sqlss.delete("coupon.deleteCoupon", optionMap);
		
	}
//
//	//회원가입시 웰컴쿠폰 발급
//	public static int insertWelcomeCoupon(MemberDTO member) {
//		try (SqlSession ss = DBService.getFactory().openSession()) {
//			return ss.insert("coupon. insertWelcomeCoupon", member);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//	

	//회원가입시 쿠폰 없음으로 COUPON_CART에 INSERT
	public static int insertDefaultCoupon(MemberDTO member) {
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
				return ss.insert("coupon.insertDefaultCoupon", member);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return 0;
	}

}
