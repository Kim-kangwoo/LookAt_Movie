<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/findidpage.css">
</head>
<c:choose>
	<c:when test="${status == 'contains -'}">
		<script>alert("'-'를 제외한 전화번호를 입력해주세요.");</script>
	</c:when>
	<c:when test="${status == 'length problem'}">
		<script>alert("법정 생년월일 6자리를 입력해주세요. (예시: 980928)");</script>
	</c:when>
	<c:when test="${status == 'null'}">
		<script>alert("값을 전부 입력해주세요.");</script>
	</c:when>
</c:choose>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
	
<h3>아이디 찾기 페이지</h3>
	<div class="form-container">
		<form action="${pageContext.request.contextPath }/controller?command=findId" method="post">
			<div>
				<label for="name">이름 :</label>
				<input class="input-field" type="text" id="name" name="name" required><br>
			</div>
			<div>
				<label for="birthday">생년월일 :</label>
				<input class="input-field" type="text" id="birthday" name="birthday"  required placeholder="법정 생년월일 6자리"><br>
			</div>
			<div>
				<label for="number">전화번호 :</label>
				<input class="input-field" type="text" id="number" name="number" placeholder="'-'제외 숫자만 입력" required><br>
			</div>
			<input class="button-style" type="submit" value="찾기">
			<input class="button-style" type="button" onclick="window.history.back()" value="뒤로가기">
		</form>
	</div>

</body>
</html>