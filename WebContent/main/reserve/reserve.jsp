<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예매 | Look at Movie</title>
   <!-- 외부 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reserve/reserve.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<script>

	let movie = "${movieId}";
	let theater = "${theaterId}";
	let date = "${date}";
	let runtime;
	let selectAll = true;
	let urlParams = new URLSearchParams(window.location.href);
	let member = "${member.memberType}"; 
	
	// 마지막 런타임 선택 유무를 위한 로직
	let values = urlParams.values();
	let reserveAll = 'reserveAll';
	for (let value of values) {
		
		if (value == reserveAll){
			selectAll = false;
		}
	}
	
	function moveToReserveSeat() {
		
		if (movie == ""){
			
			alert("영화를 선택해주세요 !");
			
		} else if (theater == ""){
			
			alert("극장을 선택해주세요 !");
			
		} else if (date == ""){
		
			alert("날짜를 선택해주세요 !");
			
		} else if (selectAll){
			
			alert("시간을 선택해주세요 !");
		} else {
			
			if(member == ''){
				
				alert("로그인이 필요한 화면입니다 \n로그인 페이지로 이동합니다.");
				location.href='${pageContext.request.contextPath }/controller?command=loginPage';
				
			} else {
				
				// 좌석 선택 페이지로 전환
				location.href='${pageContext.request.contextPath }/controller?command=reserveSeat';
				
			}
		}
	}
	
	
	
    </script>
</head>
<body>

 	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
	
	<!-- 네비게이션 -->
    <div class="navi">
        <button onclick="location.href='${pageContext.request.contextPath }/controller?command=movieschedule'" >영화관별 상영시간표</button>
        <button onclick="location.href='${pageContext.request.contextPath }/controller?command=reserve'">예매 다시하기</button> 
    </div>
	
	<!-- 컨텐츠 선택 -->
	  <div class="ticket_choose">
		    <!-- 영화 포스터 이미지 -->
		    <img class="moviePoster" alt="movieposter" src="${findMovie.movieImgPath}" onerror="this.style.visibility='hidden'" />
		    
		    <!-- 정보와 선택 항목을 나누는 컨테이너 -->
		    <div class="info-container">
		        <span class="info">선택된 영화: ${findMovie.movieName}</span>
		        <span class="info">선택된 극장: ${findTheater.theaterName}</span>
		    </div>
		
		    <!-- 좌석선택과 결제를 수평으로 배치하는 공간 -->
		    <div class="actions">
		        <span>> 좌석선택</span>
		        <span>> 결제</span>
		    </div>
		
		    <!-- 좌석 선택 버튼 -->
		    <button onclick="moveToReserveSeat()">좌석선택</button>
		</div>
	
	
	<!-- 컨텐츠 메인 -->
    <div class="stepsMain">
        <div class="steps">
        	 <!-- 영화 선택 -->
            <div class="step">
                <span>영화선택</span>
                <ul>
                    <c:forEach var="movie" items="${movieList }">
                        <li>
                        	<a id="movie${movie.movieId }" href="${pageContext.request.contextPath }/controller?command=reserveTheater&movieId=${movie.movieId }">${movie.movieName }</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        
            <!-- 극장 선택 -->
            <div class="step">
                <span>극장선택</span>
                <ul>
                    <c:forEach var="theater" items="${theaterList }">
                        <li>						
                        	<a id="theater${theater.theaterId }" href="${pageContext.request.contextPath }/controller?command=reserveDate&theaterId=${theater.theaterId }">${theater.theaterName }</a>						
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <!-- 날짜 선택 -->
            <div class="step">
                <span>날짜선택</span>
                <span>12월</span>
                <ul>
                    <c:forEach var="date" items="${dateList }">
                        <li>
                            <a id="${date }" onclick="choiceDate('${date }')" href="${pageContext.request.contextPath }/controller?command=reserveRuntime&date=${date}">${date}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <!-- 시간 선택 -->
            <div class="step">
                <span>시간선택</span>
                <ul>
                    <c:forEach var="runtime" items="${runtimeList }">
                        <c:set var="leftSeatCount" value="${runtime.leftSeatCount}" />
                        <li>
                            <c:choose>
                                <c:when test="${leftSeatCount == 0}">
                                    <a style="background-color: rgba(0, 0, 0, 0.2);">${runtime.startTime} ~ ${runtime.endTime}</a>
                                    <span>잔여좌석 : ${runtime.leftSeatCount}석</span>
                                </c:when>
                                <c:when test="${leftSeatCount > 0}">
                                    <a id="runtime${runtime.runtimeId }"  onclick="choiceTime('${runtime.runtimeId}')" href="${pageContext.request.contextPath }/controller?command=reserveAll&runtimeId=${runtime.runtimeId }">${runtime.startTime} ~ ${runtime.endTime}</a>
                                    <span>잔여좌석 : ${runtime.leftSeatCount}석</span>
                                </c:when>
                            </c:choose>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
<%@ include file="/main/footer.jspf" %> 
<script>
	
	// 선택한 것들 스타일 유지를 위한 로직 ---------------------------
	let movieId = "movie${movieId}";
	let theaterId = "theater${theaterId}";
	let dateId = "${date}";
	let runtimeId = "runtime${runtimeId}";
	
	if (movieId != ""){
		
		// 스타일 변경 class 추가
		document.getElementById(movieId).className = 'selected';
	}
	
	if (theaterId != ""){
		
		// 스타일 변경 class 추가
		document.getElementById(theaterId).className = "selected";
		
	}
		
	if (dateId != ""){
		
		// 스타일 변경 class 추가
		document.getElementById(dateId).className = "selected";
	}
	
	if (runtimeId != ""){
		
		// 스타일 변경 class 추가
		document.getElementById(runtimeId).className = "selected";
		
	}

</script>
</body>
</html>