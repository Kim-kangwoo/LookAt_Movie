package com.lookat.command.mylookat.update;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lookat.command.Command;

public class LookatUpdateCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 목적 : 업데이트를 원하는 페이지로 이동
		
		// key : 정보변경타입,  value: 해당하는 경로
		Map<String, String> pathMap = new HashMap<>();
		pathMap.put("name",  "main/mylookat/info/update/updateName.jsp");
		pathMap.put("nickname",  "main/mylookat/info/update/updateNickname.jsp");
		pathMap.put("birthday",  "main/mylookat/info/update/updateBirthday.jsp");
		pathMap.put("phone",  "main/mylookat/info/update/updatePhone.jsp");
		pathMap.put("password",  "main/mylookat/info/update/updatePassword.jsp");
		
		
		String type =  request.getParameter("type");
		
		return pathMap.get(type);
	}

};
