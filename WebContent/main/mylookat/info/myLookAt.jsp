<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 정보 조회</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
   
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage/myLookAt.css">
</head>
<style>


</style>
<body>
<%@ include file="/main/font.jspf" %>
<%@ include file="/main/header.jspf" %>

<!-- 정보 조회 영역 -->
<div class="container">
    <h2 class="text-center mb-4">내 정보 조회</h2>
    
    <!-- 테이블을 사용하여 정보 조회 -->
    <div class="table-container">
        <table class="member-table">
            <tr>
                <th>항목</th>
                <th>정보</th>
            </tr>
            <tr>
                <td>이름</td>
                <td>${member.memberName}</td>
            </tr>
            <tr>
                <td>성별 (F:여 M:남)</td>
                <td>${member.memberSex}</td>
            </tr>
            <tr>
                <td>나이</td>
                <td>${member.memberAge}</td>
            </tr>
            <tr>
                <td>닉네임</td>
                <td>${member.memberNickname}</td>
            </tr>
            <tr>
                <td>생일</td>
                <td>${member.memberBirthday}</td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td>${member.memberPhonenum}</td>
            </tr>
            <tr>
                <td>아이디</td>
                <td>${member.memberLogid}</td>
            </tr>
	         <tr>
			    <td>비밀번호</td>
			    <td>
			        <div class="password-input-container d-flex align-items-center">
			            <input type="password" value="${member.memberPassword}" id="passwordInput" disabled class="form-control" style="flex-grow: 1; margin-right: 10px;"/>
			            <button type="button" id="togglePassword" class="btn btn-custom">비밀번호 보기</button>
			        </div>
			    </td>
			</tr>

        </table>
    </div>

    <hr>

    <!-- 홈으로 돌아가기 버튼 -->
    <div class="d-grid gap-2 mt-4">
        <a href="controller?command=mainPage" class="btn btn-custom">홈으로 돌아가기</a>
    </div>
    
    <div class="d-grid gap-2 mt-4">
        <a href="${pageContext.request.contextPath }/controller?command=myPage"><button class="btn btn-custom">뒤로 가기</button></a>
    </div>
</div>



<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-8tNPF4lH6cRkD8yfpdYWwFtWfRzFDbXoIS5ZClfMKgUjHL9Vh/Jz4vwHw+9So9lH" crossorigin="anonymous"></script>

<script>
    // 비밀번호 표시/숨기기 기능
    document.getElementById('togglePassword').addEventListener('click', function () {
        var passwordInput = document.getElementById('passwordInput');
        // passwordInput의 type이 'password'이면 'text'로, 그렇지 않으면 'password'로 변경
        var type = passwordInput.type === 'password' ? 'text' : 'password';
        passwordInput.type = type;
        
        // 버튼 텍스트 변경
        this.textContent = this.textContent === '비밀번호 보기' ? '비밀번호 숨기기' : '비밀번호 보기';
    });
</script>


</body>
</html>
