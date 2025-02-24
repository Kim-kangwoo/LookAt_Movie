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

public class LookatUpdateNameCommand implements Command {

    @Override
    public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 목적 : 입력받은 정보를 토대로 이름 변경
        HttpSession ss = request.getSession();
        
        // 로그인 된 멤버 추출
        MemberVO member = (MemberVO) ss.getAttribute("member");
        
        // 입력받은 새로운 이름 추출
        String updateName = request.getParameter("updateName");
        
        // 기존 멤버 이름 업데이트
        if (member != null) {
        	member.setMemberName(updateName); // MemberVO에 setMemberName 메서드가 있다고 가정
        }
        
        // 사용자 정보를 DB에 업데이트
        int result = MemberDAO.updateName(updateName, member.getMemberId()); // 실제 DB 업데이트 메서드 호출
        
        // 성공적 업데이트 시 성공 페이지로 전환
        if (result > 0) {
            ss.setAttribute("member", member); // 업데이트된 MemberVO를 세션에 저장
            return Common.PATH = "main/mylookat/info/update/updateSuccess.jsp"; // 페이지 반환 
            
        } else {
        	return Common.ERROR_PATH; // 에러 페이지 
        }

    }
    
}