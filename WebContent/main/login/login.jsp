<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 │ 신나는 영화! LookAt</title>
    <!-- Cafe24Simplehae-v2.0 폰트 CDN 링크 추가 -->
    <link href="https://cdn.cafe24.com/fonts/Cafe24Simplehae-v2.0.css" rel="stylesheet">
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>

<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
	
	<h1>로그인</h1>
	<div class='login-container'>
		<form action="${pageContext.request.contextPath }/controller?command=login" method="post"> 	
			아이디 : <input type="text" name="id" required><br>
			비밀번호 : <input type="password" name="pw" required><br>
			<input type="submit" value="로그인">
		</form>
		
			<div class='button-cotainer'>
				<a href="${pageContext.request.contextPath }/controller?command=findIdPage">
					<button> 아이디 찾기 </button>
				</a>
				<a href="${pageContext.request.contextPath }/controller?command=findPwdPage">
					<button> 비밀번호 찾기 </button>
				</a>
				<a href="${pageContext.request.contextPath }/controller?command=joinCheckPage">
					<button> 회원가입 하기 </button>
				</a>
			</div>
		
		<c:choose>
		    <c:when test="${status == 'id and pwd is blank'}">
		        <script>alert("아이디와 비밀번호를 입력하세요.");</script>
		    </c:when>
		    <c:when test="${status == 'pwd is blank'}">
		        <script>alert("비밀번호를 입력하세요.");</script>
		    </c:when>
		    <c:when test="${status == 'id is blank'}">
		        <script>alert("아이디를 입력하세요.");</script>
		    </c:when>
		    <c:when test="${status == 'login denied'}">
		        <script>alert("아이디 혹은 비밀번호를 확인하세요.");</script>
		    </c:when>
		</c:choose>
	</div>
</body>
</html>