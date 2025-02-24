<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디 찾기</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/foundidpage.css">
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>

	<h1>아이디 찾기 결과</h1>

	<div class="found-id-page">
		<div class="found-id-container">
			<!-- foundId 존재 여부 체크 -->
			<c:if test="${not empty foundId}">
				<div class="found-id-result">
					<p>
						가입하신 아이디는 <strong>${foundId}</strong>입니다.
					</p>
				</div>
				
				<div class="button-container">
			<button class="button-style"
				onclick="window.location.href='controller?command=loginPage'">로그인 하기</button>
				<a href="${pageContext.request.contextPath}/controller?command=findPwdPage">
					<button class="button-style">비밀번호  찾기</button>
				</a>
		</div>
				
				
			</c:if>

			<c:if test="${empty foundId}">
				<div class="found-id-warning">
					<p>입력하신 정보에 해당하는 아이디가 없습니다. 다시 시도해주세요.</p>
				</div>
				
				<div class="button-container">
			<button class="button-style"
				onclick="window.location.href='controller?command=loginPage'">로그인 하기</button>
				<a href="${pageContext.request.contextPath}/controller?command=findIdPage">
					<button class="button-style" onclick="history.back()">다시 아이디 찾기</button>
				</a>
		</div>
				
				
				
			</c:if>
		</div>

<!-- 
		<div class="button-container">
			<button class="button-style"
				onclick="window.location.href='controller?command=loginPage'">로그인</button>
			<button class="button-style" onclick="history.back()">뒤로가기</button>
		</div>
		 -->
		
		
	</div>
	</div>
</body>
</html>
