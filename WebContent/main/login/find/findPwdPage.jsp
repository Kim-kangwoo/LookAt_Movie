<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/findpwdpage.css">
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
	
<h3>비밀번호 찾기 페이지 </h3>

	<div class="form-container">
		<form action="${pageContext.request.contextPath }/controller?command=findPwd" method="post"> 	
				<div>
					<label for="id">아이디 :</label>
					<input class="input-field" type="text" id="id" name="id" required><br>
				</div>
				<div>
					<label for="number">전화번호 :</label>
					<input class="input-field" type="text" id="number" name="number" placeholder="'-'제외 숫자만 입력" required><br>
				</div>
				<div>
					<label for="birthday">생년월일 :</label>
					<input class="input-field" type="text" id="birthday" name="birthday" placeholder="법정 생년월일 6자리" required><br>
				</div>
				<input class="button-style" type="submit" value="찾기">
				<input class="button-style" type="button" onclick="window.history.back()" value="뒤로가기">
		</form>
</div>	
	
	
	
	
	

</body>
</html>