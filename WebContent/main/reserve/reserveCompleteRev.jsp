<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>예매 성공 | Look at Movie</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reserve/reserveCompleteRev.css">

<script>

    // 마이페이지로 이동
    function moveToMyReservePage() {
        location.href = "${pageContext.request.contextPath }/controller?command=myReservePage";
    }
</script>
</head>
<body>
   <%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
    
    <div class="container">
        <h1>예매 성공 페이지</h1>
        
        <div class="movie-info-wrapper">
            <div class="movie-poster" style="background-image: url('${findMovie.movieImgPath}')"></div>
            <div class="movie-info">
                <span><strong>영화명:</strong> ${findMovie.movieName}</span>
                <span><strong>극장:</strong> ${findTheater.theaterName}</span>
                <span><strong>일시:</strong> ${findRuntime.runDate} &nbsp; ${findRuntime.startTime} ~ ${findRuntime.endTime}</span>
                <span><strong>인원:</strong> ${selectPeople}명</span>
                <span><strong>좌석:</strong> ${selectSeatId}</span>
                <span><strong>결제된 금액:</strong> ${leftTotalPrice} 원</span>
            </div>
        </div>

        <div class="separator"></div>

        <div>
            <button class="button" onclick="moveToMyReservePage()">나의 예매 확인하기 (마이페이지로 이동)</button>
        </div>
    </div>
</body>
</html>