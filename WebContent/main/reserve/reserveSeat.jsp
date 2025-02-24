<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>좌석 선택 | Look at Movie</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reserve/reserveSeat.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>

    let selectCount = 0; // 좌석 선택 횟수
    let selectSeatId = ""; // 선택한 좌석
    let selectPeople; // 선택 인원 수
    const leftSeatCount = ${findRuntime.leftSeatCount}; // 남은 좌석 수
    
    function getSeatId(seatId) {
    	// 선택한 인원수가 있는 경우
        if (selectPeople !== undefined) {
        	// 좌석 선택 횟수가 선택 인원 보다 작은 경우
            if (selectCount < selectPeople) {
            	// 이미 선택한 좌석이 없는 경우
                if (!selectSeatId.includes(seatId)) {
                    selectSeatId += seatId + "\u00a0";
                    // 선택한 좌석 표시를 위한 div Id 추출
                    const selectSeat = document.getElementById('selectSeat');
                    selectSeat.appendChild(document.createTextNode(seatId + "\u00a0")); // 선택 좌석 div에 텍스트 추가 
                    selectCount += 1;
                    
                    document.getElementById(seatId).className = 'seat_selected';
                    
                } else {
                    alert("같은 좌석을 선택하실 수 없습니다!");
                }
            } else {
                alert("선택한 좌석 수 이상으로 선택할 수 없습니다!");
            }
        } else {
            alert("인원을 먼저 선택해주세요!");
        }
    }

    function getPeople(getPeople) {
    	
    	// 기존에 선택한 인원이 있다면 스타일 원상태로
    	const choice_people_check = document.getElementsByClassName("choice_people_selected");
    	
		Array.from(choice_people_check).forEach((people) => {
        	
			if (people.className != undefined){
	    		
				people.className = "choice_people_select";
				people.style.backgroundColor = '#ffcc00';
	    		
	    	}
        });
    	
    	// 남은 좌석보다 인원 선택 수가 많지 않게
        if (getPeople <= leftSeatCount) {
            selectPeople = getPeople;
            const people = document.getElementById('people');
            people.innerText = '인원 : ' + selectPeople + '명';
            // 선택한 인원 스타일변경
            const element = document.getElementById(getPeople);
            element.className = 'choice_people_selected';
            element.style.backgroundColor = '#ff66b2';
            
        } else {
            alert("남은 좌석 수 보다 많이 선택하셨습니다!");
        }
    	
    	
    }

    function moveToPaymentPage() {
        if ((selectSeatId == "") || (selectPeople == undefined)) {
            alert("인원과 좌석을 선택해주세요!");
        } else {
            if (selectPeople == selectCount) {
                let href = '${pageContext.request.contextPath }/controller?command=reservePaymentPage&selectSeatId=' + selectSeatId + '&selectPeople=' + selectPeople;
                location.href = href;
            } else {
                alert("인원 수에 맞게 좌석을 선택해주세요!");
            }
        }
    }
	
    // 리셋 좌석, 인원
    function resetPeopleSeat() {
    	
        selectPeople = 0;
        selectCount = 0;
        selectSeatId = "";
        document.getElementById('people').innerText = '인원 : ';
        document.getElementById('selectSeat').innerText = '좌석 : ';
        
        // 선택된 좌석 인원 다시 원상태로
        const seat_selectList = document.getElementsByClassName("seat_selected");
        const choice_people_selectList = document.getElementsByClassName("choice_people_selected");
        
        Array.from(seat_selectList).forEach((seat) => {
        	
        	seat.className = "leftSeat";
        });
        
        Array.from(choice_people_selectList).forEach((people) => {
        	
        	people.className = "choice_people_select";
        	people.style.backgroundColor = '#ffcc00';
        });
        
    }
    
</script>
</head>
<body>
	
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>   
   
    <div class="content">
        <div class="content_bar">
            <span>인원 / 좌석</span>
            <button class="reset-button" onclick="resetPeopleSeat()">다시하기</button>
        </div>

        <div class="people_movie_theater">
            <div class="choice_people">
                <span>*최대 5명 가능</span>
                <ul>
                    <c:forEach var="i" begin="1" end="5">
                        <li id="${i }" class="choice_people_select" onclick="getPeople('${i}')">${i}명</li>
                    </c:forEach>
                </ul>
            </div>

            <div class="theater_info">
                <span>${findTheater.theaterName}</span><br>
                <span>남은 좌석 ${findRuntime.leftSeatCount} : ${totalSeatCount}</span><br>
                <div>2024/${findRuntime.runDate} ${findRuntime.startTime} ~ ${findRuntime.endTime}</div>
            </div>
        </div>

		<!-- 좌석 선택 contents -->
        <div class="screen_seat_total">
            <div class="screen_seat_main">
                <div class="screen_seat_screen">SCREEN</div>
                <div class="seatAll">
                
	                <!-- A1 to  A6 -->
                	<div class="screen_seat_screen_seatA1to6 seatstyle">
	                    <c:forEach var="seat" items="${SeatA1to6}">
	                        <c:set var="check_flag" value="true" />
	                        
	                        <!-- 조건검사를 통한 남은 좌석 -->
	                        <c:forEach var="leftSeat" items="${leftSeatList}">
	                            <c:if test="${seat.seatId == leftSeat.seatId}">
	                                <div id="${seat.seatId }" class="leftSeat" data-name="${seat.seatId}" onclick="getSeatId('${seat.seatId}')">${seat.seatId}</div>
	                                <c:set var="check_flag" value="false" />
	                            </c:if>
	                        </c:forEach>
	                        <!-- 조건검사를 통한 예약된 좌석 -->
	                        <c:if test="${check_flag}">
	                            <div class="seat" data-name="${seat.seatId}">${seat.seatId}</div>
	                        </c:if>
	                        			
	                    </c:forEach>
                    </div>
                    
	                <!-- A7 to  A12 -->
                    <div class="screen_seat_screen_seatA7to12 seatstyle">
	                    <c:forEach var="seat" items="${SeatA7to12}">
	                        <c:set var="check_flag" value="true" />
	                        
	                        <!-- 조건검사를 통한 남은 좌석 -->
	                        <c:forEach var="leftSeat" items="${leftSeatList}">
	                            <c:if test="${seat.seatId == leftSeat.seatId}">
	                                <div id="${seat.seatId }" class="leftSeat" data-name="${seat.seatId}" onclick="getSeatId('${seat.seatId}')">${seat.seatId}</div>
	                                <c:set var="check_flag" value="false" />
	                            </c:if>
	                        </c:forEach>
	                        <!-- 조건검사를 통한 예약된 좌석 -->
	                        <c:if test="${check_flag}">
	                            <div class="seat" data-name="${seat.seatId}">${seat.seatId}</div>
	                        </c:if>		
	                        					
	                    </c:forEach>
                    </div>
                    
                    <div class="screen_seat_screen_seatB1to6 seatstyle">
	                    <!-- B1 to  B6 -->
	                    <c:forEach var="seat" items="${SeatB1to6}">
	                        <c:set var="check_flag" value="true" />
	                        
	                        <!-- 조건검사를 통한 남은 좌석 -->
	                        <c:forEach var="leftSeat" items="${leftSeatList}">
	                            <c:if test="${seat.seatId == leftSeat.seatId}">
	                                <div id="${seat.seatId }" class="leftSeat" data-name="${seat.seatId}" onclick="getSeatId('${seat.seatId}')">${seat.seatId}</div>
	                                <c:set var="check_flag" value="false" />
	                            </c:if>
	                        </c:forEach>
	                        <!-- 조건검사를 통한 예약된 좌석 -->
	                        <c:if test="${check_flag}">
	                            <div class="seat" data-name="${seat.seatId}">${seat.seatId}</div>
	                        </c:if>		
	                        					
	                    </c:forEach>
                    </div>
                    
                    
                    <div class="screen_seat_screen_seatC1to6 seatstyle">
	                    <!-- C1 to  C6 -->
	                    <c:forEach var="seat" items="${SeatC1to6}">
	                        <c:set var="check_flag" value="true" />
	                        
	                        <!-- 조건검사를 통한 남은 좌석 -->
	                        <c:forEach var="leftSeat" items="${leftSeatList}">
	                            <c:if test="${seat.seatId == leftSeat.seatId}">
	                                <div id="${seat.seatId }" class="leftSeat" data-name="${seat.seatId}" onclick="getSeatId('${seat.seatId}')">${seat.seatId}</div>
	                                <c:set var="check_flag" value="false" />
	                            </c:if>
	                        </c:forEach>
	                        
	                        <!-- 조건검사를 통한 예약된 좌석 -->
	                        <c:if test="${check_flag}">
	                            <div class="seat" data-name="${seat.seatId}">${seat.seatId}</div>
	                        </c:if>		
	                        						
	                    </c:forEach>
                    </div>
					
					<div class="screen_seat_screen_seatB7to12 seatstyle">                    
	                    <!-- B7 to  B12 -->
	                    <c:forEach var="seat" items="${SeatB7to12}">
	                        <c:set var="check_flag" value="true" />
	                        
	                        <!-- 조건검사를 통한 남은 좌석 -->
	                        <c:forEach var="leftSeat" items="${leftSeatList}">
	                            <c:if test="${seat.seatId == leftSeat.seatId}">
	                                <div id="${seat.seatId }" class="leftSeat" data-name="${seat.seatId}" onclick="getSeatId('${seat.seatId}')">${seat.seatId}</div>
	                                <c:set var="check_flag" value="false" />
	                            </c:if>
	                        </c:forEach>
	                        
	                        <!-- 조건검사를 통한 예약된 좌석 -->
	                        <c:if test="${check_flag}">
	                            <div class="seat" data-name="${seat.seatId}">${seat.seatId}</div>
	                        </c:if>		
	                       				
	                    </c:forEach>
                    </div>
                    
	                <!-- A13 to  A18 -->
                    <div class="screen_seat_screen_seatA13to18 seatstyle">  
	                    <c:forEach var="seat" items="${SeatA13to18}">
	                        <c:set var="check_flag" value="true" />
	                        
	                        <c:forEach var="leftSeat" items="${leftSeatList}">
	                            <c:if test="${seat.seatId == leftSeat.seatId}">
	                                <div id="${seat.seatId }" class="leftSeat" data-name="${seat.seatId}" onclick="getSeatId('${seat.seatId}')">${seat.seatId}</div>
	                                <c:set var="check_flag" value="false" />
	                            </c:if>
	                        </c:forEach>
	                        
	                        <!-- 조건검사를 통한 예약된 좌석 -->
	                        <c:if test="${check_flag}">
	                            <div class="seat" data-name="${seat.seatId}">${seat.seatId}</div>
	                        </c:if>		
	                    </c:forEach>
	            	</div>
	            	
	                <!-- A19 to  A24 -->
	            	<div class="screen_seat_screen_seatA19to24 seatstyle">  
	                    <c:forEach var="seat" items="${SeatA19to24}">
	                        <c:set var="check_flag" value="true" />
	                        
	                        <c:forEach var="leftSeat" items="${leftSeatList}">
	                            <c:if test="${seat.seatId == leftSeat.seatId}">
	                                <div id="${seat.seatId }" class="leftSeat" data-name="${seat.seatId}" onclick="getSeatId('${seat.seatId}')">${seat.seatId}</div>
	                                <c:set var="check_flag" value="false" />
	                            </c:if>
	                        </c:forEach>
	                        
	                        <!-- 조건검사를 통한 예약된 좌석 -->
	                        <c:if test="${check_flag}">
	                            <div class="seat" data-name="${seat.seatId}">${seat.seatId}</div>
	                        </c:if>		
	                    </c:forEach>
	            	</div>
	            	
	            	
                </div>
            </div>
        </div>

        <div class="ticket_choose">
            <span>영화 : ${findMovie.movieName}</span>
            <img class="moviePoster" src="${findMovie.movieImgPath}" alt="movie poster"/>
            <span>상영관 : ${findTheater.theaterName}</span>
             <span>일시 : 2024/${findRuntime.runDate} ${findRuntime.startTime} ~ ${findRuntime.endTime}</span>
            <span id="people">인원 : </span>
            <span id="selectSeat">좌석 : </span>
            <button onclick="moveToPaymentPage()">좌석결제</button>
        </div>
    </div>

</body>
</html>