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


public class LookatUpdatepasswordCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 목적 : 요청 받은 비밀번호로 변경
		// 성공 - updateSuccess 페이지 전환
		// 에러 - serverErrorPage 페이지 전환
		HttpSession ss = request.getSession();
		
		MemberVO member = (MemberVO) ss.getAttribute("member");
		
        String updatePassword = request.getParameter("updatePassword");
        
        
        // 수정 작업: 사용자 정보를 DB에 업데이트
        int result = MemberDAO.updatePassword(updatePassword, member.getMemberId());
            
        if (result > 0) {
        	
        	// 업데이트 비밀번호 멤버에 셋팅
        	member.setMemberPassword(updatePassword);
            ss.setAttribute("member", member); // 업데이트된 MemberVO를 세션에 저장
            return Common.PATH = "main/mylookat/info/update/updateSuccess.jsp"; // 페이지 반환 
            
        } else {
        	return Common.ERROR_PATH; // 에러 페이지 
        }
			
      
    }
	
}
