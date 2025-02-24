package com.lookat.command.mylookat.update;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.common.Common;
import com.lookat.dao.MemberDAO;
import com.lookat.vo.MemberVO;


public class LookatUpdateNicknameCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 목적 : 요청 받은 닉네임으로 변경
		// 성공 - updateSuccess 페이지 전환
		// 에러 - serverErrorPage 페이지 전환
        HttpSession ss = request.getSession();
        MemberVO member = (MemberVO) ss.getAttribute("member");
        
        // 중복값이라고 알릴 불린값
        boolean duplNickName = false;
        
        // 요청에서 새로운 닉네임 추출
        String updateNickName = request.getParameter("updateNickName");
        
        // 입력받은 닉네임 중복검사
        List<MemberVO> checkMember = MemberDAO.checkNickName(updateNickName);
        
        // 있을 때 (중복) FALSE 없을 때 TRUE
       if (checkMember.isEmpty()) {
    	   
    	   // 닉네임 업데이트 하기
    	   int result = MemberDAO.updateNickName(updateNickName, member.getMemberId());
    	   if(result > 0) {
    		   
    		   // 기존 멤버에 업데이트 된 닉네임 설정
    		   member.setMemberNickname(updateNickName);
    		   ss.setAttribute("member", member);
    		   // 성공 페이지로 전환
    		   return Common.PATH = "main/mylookat/info/update/updateSuccess.jsp";
    		   
    	   } else {
    		   // 에러 페이지로 전환
    		   return Common.ERROR_PATH;
    	   }
    	   
       } else {
    	   // 이미 있는 닉네임 불린으로 전달
    	   duplNickName = true;
    	   request.setAttribute("duplNickName", duplNickName);
    	   return "main/mylookat/info/update/updateNickname.jsp";
    	   
       }
        
    }

}
