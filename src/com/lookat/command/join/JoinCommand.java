package com.lookat.command.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;
import com.lookat.dao.CouponDAO;
import com.lookat.dao.MemberDAO;
import com.lookat.dao.MembershipDAO;
import com.lookat.dto.MemberDTO;

public class JoinCommand  implements Command{
	
	//null, 공백 체크
	private boolean isNullOrEmpty(String str) {
	       return str == null || str.trim().isEmpty();
	}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원가입 폼 데이터 받기
        String logId = request.getParameter("logId");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String birthday = request.getParameter("birthday");
        String phoneNum = request.getParameter("phoneNum");
        
        System.out.println("파라미터 검증 : " + logId + ", " + pw  + ", " + name + ", " + nickname
        		+ ", " + sex + ", " + age + ", " + birthday + ", " + phoneNum);
		
        //입력값 검증
        String status = "";
        // null 체크
	    if (isNullOrEmpty(logId) || isNullOrEmpty(pw) || isNullOrEmpty(name) || 
	    		isNullOrEmpty(nickname) || isNullOrEmpty(sex)|| age == 0 || isNullOrEmpty(birthday) || isNullOrEmpty(phoneNum) ) {
	    	status = "null or empty";
	    	request.setAttribute("status", status);
	        return "/main/join/joinPage.jsp";  
	    }
	    
	    //닉네임 중복 체크
	    boolean nicknameCheckResult = MemberDAO.checkNicknameExists(nickname);
		System.out.println("이미 가입된 별명인지 체크 (true: 사용불가 / false: 사용가능) : " + nicknameCheckResult);
		if (nicknameCheckResult == true) {
			status = "nickname duplicated";
			request.setAttribute("status", status);
			return "/main/join/joinPage.jsp";  
		}
		
		//DB 데이터 넣기
		MemberDTO member = new MemberDTO(
				logId, pw, name, nickname, sex, age, birthday, phoneNum);
		
		int result =  MemberDAO.insertMember(member);
		System.out.println("member insert 확인용 (1이면 성공) : " + result);
		if (result == 1) {
			status = "join success";
			request.setAttribute("status", status);
		} else {
			status = "join FAIL";
		}
		request.setAttribute("status", status);
		
		//멤버십 테이블에도 데이터 넣기 (멤버십 가입 처리)
		int membershipResult = MembershipDAO.insertMembership(member);
		System.out.println("membership insert 확인용 (1이면 성공) : " + membershipResult);

		
		//회원가입시 쿠폰 없음으로 coupon_cart에 추가
		int couponDefault = CouponDAO.insertDefaultCoupon(member);
		System.out.println("쿠폰 없음 수정 여부 : " + couponDefault);
		
		
		return "/main/join/joinPage.jsp"; 
		
		
	}

}
