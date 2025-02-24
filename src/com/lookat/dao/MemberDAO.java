package com.lookat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lookat.dto.MemberDTO;
import com.lookat.mybatis.DBService;
import com.lookat.vo.MemberAndMembershipVO;
import com.lookat.vo.MemberVO;

public class MemberDAO {
	
	// 멤버 추출
	public static MemberVO getMember(int memberId) {
		
		try(SqlSession ss = DBService.getFactory().openSession()) {
			
			return ss.selectOne("member.getMember", memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	//로그인
	public static List<MemberVO> loginCheck(String id, String pw) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			Map<String, String> map = new HashMap<>();
			map.put("id", id);
			map.put("pw", pw);

			return ss.selectList("member.login", map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//아이디 찾기
	public static String findId(String name, String number, String birthday) {
		
		try (SqlSession ss = DBService.getFactory().openSession()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", name);
			map.put("number", number);
			map.put("birthday", birthday);

			return ss.selectOne("member.findId", map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//비번찾기
	public static String findPwd(String id, String number, String birthday) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("number", number);
			map.put("birthday", birthday);

			return ss.selectOne("member.findPwd", map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//관리자
	// 일반 사용자 전체 데이터 조회
	public static List<MemberVO> getMemberList() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectList("member.getMemberList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 전체회원수 (일반 회원 + 멤버십 회원)
	public static int getTotalMemberCount() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("member.getTotalMemberCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 일반 회원 수
	public static int getMemberCount() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("member.MemberCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 전체 회원에서 회원 조회
	public static List<MemberAndMembershipVO> searchMember(String name, String birthday, String phoneNum) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", name);
			map.put("birthday", birthday);
			map.put("phoneNum", phoneNum);

			return ss.selectList("member.searchMember", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//소인언니 기능 구현 추가 시작 ------------
	// 이미 존재하는 회원인지 체크하는 메소드
	public static int checkMemberExists(String name, String birthday, String phoneNum) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberName", name);
			map.put("memberBirthday", birthday);
			map.put("memberPhonenum", phoneNum);
			return ss.selectOne("member.checkMemberExists", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 확인해서 수정 ----------------------------------------
	// 닉네임 중복 체크 메소드
	public static boolean checkNicknameExists(String nickname) {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			int count = ss.selectOne("member.checkNicknameExists", nickname); // 중복되면 1 아니면 0
			return count > 0; // 중복된 닉네임이 있으면 true 반환
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// 회원가입 처리 메소드(member 테이블에 추가)
	public static int insertMember(MemberDTO member) {
		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.insert("member.insertMember", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	// 수정----------------------------------------------------------------
	// 비밀번호 수정하기
	public static int updatePassword(String updatePassword, int memberId) {

		HashMap<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("updatePassword", updatePassword);
		updateMap.put("memberId", memberId);

		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.update("member.updatePassword", updateMap);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return -1;
	}
	
	// 이름 수정
	public static int updateName(String updateName, int memberId) {

		HashMap<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("updateName", updateName);
		updateMap.put("memberId", memberId);

		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.update("member.updateName", updateMap);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return -1;
	}
	
	// 닉네임 수정
	public static int updateNickName(String updateNickName, int memberId) {

		HashMap<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("updateNickName", updateNickName);
		updateMap.put("memberId", memberId);

		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.update("member.updateNickName", updateMap);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return -1;
	}
	
	// 닉네임 중복확인
	public static List<MemberVO> checkNickName(String checkNickName) {

		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.selectList("member.checkNickName", checkNickName);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
	
	// 핸드폰번호 수정
	public static int updatePhone(String updatePhone, int memberId) {

		HashMap<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("updatePhone", updatePhone);
		updateMap.put("memberId", memberId);

		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.update("member.updatePhone", updateMap);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return -1;
	}
	
	// 생년월일 수정
	public static int updateBirthday(String updateBirthday, int memberId) {

		HashMap<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("updateBirthday", updateBirthday);
		updateMap.put("memberId", memberId);

		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.update("member.updateBirthday", updateMap);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return -1;
	}
	
	
	// 회원 삭제
	public static int delete(int memberId) {


		try (SqlSession ss = DBService.getFactory().openSession(true)) {
			return ss.delete("member.delete", memberId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return -1;
	}

	//여성 회원수
	public static int getFemaleCount() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("member.getFemaleCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//남성 회원수
	public static int getMaleCount() {
		try (SqlSession ss = DBService.getFactory().openSession()) {
			return ss.selectOne("member.getMaleCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
