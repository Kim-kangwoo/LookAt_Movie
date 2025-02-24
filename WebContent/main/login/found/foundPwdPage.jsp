<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 찾기 페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/foundpwdpage.css">
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>

	<h3>비밀번호 찾기</h3>

	<div class="found-pwd-page">
		<div class="found-pwd-container">

			<c:choose>
				<c:when test="${foundPwd != null}">
					<div class="found-pwd-result">
						<p>
							가입한 비밀번호는 <strong>${foundPwd}</strong> 입니다.
						</p>
					</div>
					
					<div class="found-pwd-actions">
				<a
					href="${pageContext.request.contextPath}/controller?command=loginPage">
					<button class="found-pwd-button">로그인 하기</button>
				</a> 
				<a
					href="${pageContext.request.contextPath}/controller?command=updatePassword">
					<button class="found-pwd-button">비밀번호 변경 하기</button>
				</a> 
			</div>
					
					
				</c:when>
				<c:otherwise>
					<div class="found-pwd-warning">
						<p>
							<span>${status}</span>
						</p>
					</div>
					
					<div class="found-pwd-actions">
						<a href="${pageContext.request.contextPath}/controller?command=loginPage">
							<button class="found-pwd-button">로그인 하기</button>
						</a> 
						<a href="${pageContext.request.contextPath}/controller?command=findPwdPage">
							<button class="found-pwd-button" onclick="history.back()">다시 비밀번호 찾기</button>
						</a>
					</div>
			
				</c:otherwise>
			</c:choose>

			<%-- 
			<div class="found-pwd-actions">
				<a
					href="${pageContext.request.contextPath}/controller?command=loginPage">
					<button class="found-pwd-button">로그인 하기</button>
				</a> 
				<a
					href="${pageContext.request.contextPath}/controller?command=updatePassword">
					<button class="found-pwd-button">비밀번호 변경 하기</button>
				</a> 
				<button class="found-pwd-button" onclick="history.back()">뒤로가기</button>
			</div>
		</div>
		 --%>
		
	</div>
</body>
</html>
