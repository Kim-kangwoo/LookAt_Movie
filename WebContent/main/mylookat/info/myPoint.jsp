<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage/myPoint.css">
</head>

<body>
<%@ include file="/main/header.jspf" %>
  
  <title>포인트 조회</title>

    <div class="container">
        <header>
            <h1>MY 포인트</h1>
            <p>나의 포인트 현황을 확인하세요!</p>
        </header>

        <main>
            <section id="point-info">
                <div class="point-card">
                    <h2>현재 보유 포인트</h2>
                    <p id="points"> ${membership.membershipPoint}P </p>
                </div>
                <div class="actions">
                    <a href="${pageContext.request.contextPath }/controller?command=myPage" method="post"><button >뒤로가기</button></a>
                </div>
            </section>
        </main>

       
    </div>

    <script src="scripts.js"></script>
    
    
	


</body>
</html>