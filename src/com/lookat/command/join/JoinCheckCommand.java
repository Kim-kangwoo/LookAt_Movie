package com.lookat.command.join;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.dao.MemberDAO;

public class JoinCheckCommand implements Command {
	
	private boolean isNullOrEmpty(String str) {
	       return str == null || str.trim().isEmpty();
	}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		
		// 클라이언트로부터 입력된 데이터
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String phoneNum = request.getParameter("phoneNum");
        
        //사용자 입력값 세션에 저장
        if (isNullOrEmpty(name) || isNullOrEmpty(phoneNum)) {
        	return "/main/join/joinCheckPage.jsp";
        }
        ss.setAttribute("userName", name);
        ss.setAttribute("userPhoneNum", phoneNum);
        
        // 회원 존재 여부 확인
        int count = MemberDAO.checkMemberExists(name, birthday, phoneNum);
        System.out.println("회원 존재 여부 확인 (1이면 이미 회원가입 회원) :" + count);
        
        String status = "";
        if (count > 0) {
        	status = "registered";
        } else {
        	status = "NOT registered";
        }
        request.setAttribute("status", status);
        
        //나이 확인
        if (birthday != null) {
        	ss.setAttribute("userBirthday", birthday);  //사용자 입력한 생년월일 세션에 저장
        	birthday = birthday.replaceAll("-", "");
        }
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate birthDate = LocalDate.parse(birthday, formatter);
        
        int age = today.getYear() - birthDate.getYear();
        if (birthDate.plusYears(age).isAfter(today)) {
        	age--; //생일 안 지났음 1살 차감
        }
        
        //나이 계산 후 세션에 저장
        ss.setAttribute("userAge", age);
        return "/main/join/joinCheckPage.jsp"; 
        
	}

}
