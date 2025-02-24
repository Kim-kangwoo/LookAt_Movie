<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage/myUpdatePage.css">
    <meta charset="UTF-8">
    <title>수정 페이지</title>
   
<script>
    // 로그인 쿠키 검증
    let memberCheck = "${member}";

    // 로그인 확인
    if (memberCheck == undefined) {
        alert("로그인 세션이 만료되었습니다 ");
        location.href="main/index.jsp";
    }
</script>

</head>
<body>
<%@ include file="/main/header.jspf" %>

<h1>내 정보 관리</h1>



<!-- 버튼 그룹 -->
<div class="button-group">
    <a href="${pageContext.request.contextPath }/controller?command=update&type=name">
        <button type="button" class="back-btn">이름 변경</button>
    </a>

    <a href="${pageContext.request.contextPath }/controller?command=update&type=nickname">
        <button type="button" class="back-btn">닉네임 변경</button>
    </a>

    <a href="${pageContext.request.contextPath }/controller?command=update&type=birthday">
        <button type="button" class="back-btn">생년월일 변경</button>
    </a>

    <a href="${pageContext.request.contextPath }/controller?command=update&type=phone">
        <button type="button" class="back-btn">전화번호 변경</button>
    </a>

    <a href="${pageContext.request.contextPath }/controller?command=update&type=password">
        <button type="button" class="back-btn">비밀번호 변경</button>
    </a>
    
    <a href="${pageContext.request.contextPath }/controller?command=myPage">
        <button type="button" class="back-btn">뒤로가기</button>
    </a>
</div>



</body>
</html>

