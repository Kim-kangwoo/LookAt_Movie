<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원확인 │ 신나는 영화! LookAt</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/joincheck.css">
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>


    <!-- 메인 콘텐츠 -->
    <div class="container">
        <h2>회원가입 여부 안내</h2>
        <form class="check-form" action="${pageContext.request.contextPath}/controller?command=joinCheck" method="post">
            
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required>
            
            <label for="birthday">생년월일</label>
            <input type="date" id="birthday" name="birthday" min="1900-01-01" max="2024-12-31" required>
            
            <label for="phone">핸드폰번호</label>
            <input type="number" id="phone" name="phoneNum" placeholder="핸드폰번호를 (-)없이 입력하세요" pattern="\d*" required>

            <button type="submit" class="form-button">회원가입 확인</button>
        </form>

        <div class="form-footer">
            <p>이미 회원이신가요? <a href="${pageContext.request.contextPath}/controller?command=loginPage">로그인</a></p>
        </div>
    </div>
    
    <c:if test="${status eq 'registered'}">
    	<script>
    	if (confirm("기존 회원입니다.\n로그인을 진행하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/controller?command=loginPage";
		} else {
			location.href="${pageContext.request.contextPath}/controller?command=joinCheckPage";
		}
		</script>
    </c:if>
    <c:if test="${status eq 'NOT registered'}">
    	<script>
			if (confirm("회원가입이 되어 있지 않습니다.\n회원가입을 진행하시겠습니까?")) {
				location.href = "${pageContext.request.contextPath}/controller?command=joinAgreePage";
			} else {
				location.href="${pageContext.request.contextPath}/controller?command=joinCheckPage";
			}
		</script>
    </c:if>
    
    
</body>
</html>