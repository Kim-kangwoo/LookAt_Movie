package com.lookat.command.mylookat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookat.command.Command;
import com.lookat.common.Common;
import com.lookat.dao.MemberDAO;
import com.lookat.vo.MemberVO;

public class LookatSuccessDeleteMemberCommand  implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//데이터 추출
			HttpSession ss = request.getSession();
			MemberVO member = (MemberVO) ss.getAttribute("member");
			
			// 성공 결과값 반환
			int result = MemberDAO.delete(member.getMemberId());

			// 결과값 조건에 맞게 실행
			if (result > 0) {
				
				// 성공 시 mypage
				return Common.PATH = "main/mylookat/mypage.jsp";
				
			} else {
				
				// 실패 시 에러페이지
				return Common.ERROR_PATH;
			}
	    }
	}
		

	
	

