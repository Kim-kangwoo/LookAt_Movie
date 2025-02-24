package com.lookat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lookat.dto.MemberDTO;
import com.lookat.mybatis.DBService;
import com.lookat.vo.MemberAndMembershipVO;
import com.lookat.vo.MembershipVO;

public class MembershipDAO {
	
	// 멤버ID 멤버쉽 찾는 거
	public static MembershipVO findOne(int memberId) {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectOne("membership.findOne", memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	// 사용한 포인트 빼기
		public static void updatePointMinus (int memberId, int usePointValue, SqlSession sqlss) {
			
			Map<String, Integer> optionMap = new HashMap<>();
			optionMap.put("memberId", memberId);
			optionMap.put("usePointValue", usePointValue);
			
			sqlss.update("membership.updatePointMinus", optionMap);
		}

	
		// 적립한 포인트 추가하기
		public static void updatePointAdd(int memberId, int addPoint, SqlSession sqlss) {
			
			Map<String, Integer> optionMap = new HashMap<>();
			optionMap.put("memberId", memberId);
			optionMap.put("addPoint", addPoint);
				
			sqlss.update("membership.updatePointAdd", optionMap);
		}

	
	// 관리자
	// 멤버십 회원 정보 조회
	public static List<MemberAndMembershipVO> getMembershipList() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("membership.getMembershipList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//멤버십 회원수
	public static int getMembershipCount() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("membership.getMembershipCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//회원가입시 멤버십 가입 처리
	public static int insertMembership(MemberDTO member) {
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.insert("membership.insertMembership", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
public static void updateGrade(int membershipId, String updateGrade, SqlSession sqlss) {
		
		Map<String, Object> optionMap = new HashMap<>();
		optionMap.put("membershipId", membershipId);
		optionMap.put("updateGrade", updateGrade);
		
		sqlss.update("membership.updateGrade", optionMap);
		
		
	}

	
	
}
