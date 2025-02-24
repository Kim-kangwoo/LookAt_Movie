<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/serviceceter/serverErrorPage.css">
<title>서버 내부 오류 페이지</title>
</head>
<body>

    <!-- 오류 카드 -->
    <div class="error-card">
        <!-- 오류 아이콘 (여기서는 문자 사용) -->
        <div class="error-icon">❌</div>

        <!-- 오류 메시지 -->
        <h1>죄송합니다! 내부 서버 오류가 발생했습니다.</h1>
        <p>현재 요청하신 작업을 처리할 수 없습니다. 잠시 후 다시 시도해 주세요.</p>

        <!-- 홈으로 이동 버튼 -->
        <a href="${pageContext.request.contextPath }/controller?command=mainPage">
        <button>홈으로</button>   
        </a>
    </div>

</body>
</html>
