package com.lookat.command.mylookat.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.common.Common;
import com.lookat.dao.MemberDAO;
import com.lookat.vo.MemberVO;


public class LookatUpdateBirthdayCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 목적 : 입력받은 정보를 토대로 생년월일 변경
		// 생년월일 : 포맷으로 변경 "---- 인덱스에 맞게"
        HttpSession ss = request.getSession();
        
        // 로그인 된 멤버 추출
        MemberVO member = (MemberVO) ss.getAttribute("member");
        
        // 입력받은 새로운 이름 추출
        String paramBirthday = request.getParameter("updateBirthday");
        
        // 생년월일 : 포맷으로 변경 "인덱스에 맞게 - 추가"
        StringBuilder updateBirthday = new StringBuilder();
        updateBirthday.append(paramBirthday);
        updateBirthday.insert(4, "-");
        updateBirthday.insert(7, "-");
        
        // 기존 멤버 이름을 업데이트
        if (member != null) {
        	member.setMemberBirthday(updateBirthday.toString());
        }
        
        // 사용자 정보를 DB에 업데이트합니다.
        int result = MemberDAO.updateBirthday(updateBirthday.toString(), member.getMemberId()); // 실제 DB 업데이트 메서드 호출
        
        // 사용자 정보가 성공적으로 업데이트되었으면 세션에 갱신된 MemberVO를 저장합니다.
        if (result > 0) {
            ss.setAttribute("member", member); // 업데이트된 MemberVO를 세션에 저장
            return Common.PATH = "main/mylookat/info/update/updateSuccess.jsp"; // 페이지 반환 
            
        } else {
        	return Common.ERROR_PATH; // 에러 페이지 
        }
        
	}
}
