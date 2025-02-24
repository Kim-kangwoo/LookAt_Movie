<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>나의 예매 | Look at Movie</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reserve/myReservePage.css">
<script type="text/javascript">
	
	// 페이지 벗어날 시 세션 삭제
	function sessionDelete() {
		
		location.href="${pageContext.request.contextPath }/controller?command=myReserveSessionDelete";
		
	}
	
    // 전체 예매 조회
    function getTotalReserve() {
        location.href="${pageContext.request.contextPath }/controller?command=myReserveTotalPage";
    }

    // 날짜별 예매 조회
    function getDateReserve() {
        const select = document.getElementById('selectPayDate');
        const option = select.options[select.selectedIndex];

        if (option.value != undefined){
            location.href="${pageContext.request.contextPath }/controller?command=myReserveDayPage&payDate=" + option.value;
        } else {
            alert("날짜를 선택해주세요! ");
        }
    }

    // 선택된 예약 취소
    function moveToCancelReservePage() {
        const query = 'input[name="reservePayDate"]:checked';
        const selectedEls = document.querySelectorAll(query);

        let result = '';
        selectedEls.forEach((el) => {
            result += el.value + ',';
        });

        if(result != '') {
            location.href="${pageContext.request.contextPath }/controller?command=cancelReservePage&payDate=" + result;
        } else {
            alert("취소하실 영화를 선택해주세요! ");
        }
    }
</script>
</head>
<body onbeforeunload="return sessionDelete()">

    <div class="container">
        <h1>나의 예매</h1>
        <hr>

        <div class="search-container">
            <button onclick="getTotalReserve()">전체 조회</button>
            <div class="select-container">
                <span>날짜별 조회</span>
                <select id="selectPayDate" name="selectPayDate">
                    <c:forEach var="payDate" items="${payDateList}">
                        <option class="selectPayDate">${payDate }</option>
                    </c:forEach>
                </select>
                <button onclick="getDateReserve()">조회하기</button>
            </div>
        </div>

        <div id="reserve">
            <div>예약 내역</div>

            <c:forEach var="reserve" items="${finalReserveList}">
                <c:set var="payDate" value="${reserve.payDate}" />
                <c:set var="runtimeId" value="${reserve.runtimeId}" />
                <hr>
                <div class="reserve-info">
                    <input type="checkbox" class="reservePayDate" name="reservePayDate" value="${reserve.payDate }">
                    <label>예매 정보</label>
                    <hr>
                    <span>영화명 : <c:out value="${theaterNameMap[runtimeId]}" /></span>
                    <span>극장 : <c:out value="${movieNameMap[runtimeId]}" /></span>
                    <span>일시 : <c:out value="${runtimeMap[runtimeId].runDate}" /> &nbsp; <c:out value="${runtimeMap[runtimeId].startTime}" /> ~ <c:out value="${runtimeMap[runtimeId].endTime}" /></span>
                    <span>인원 : <c:out value="${peopleCountMap[payDate]}" /> 명</span>
                    <span>좌석 : <c:out value="${seatMap[payDate]}" /></span>
                    <span>결제된 금액 : <c:out value="${totalPriceMap[payDate]}" /></span>
                    <span>할인 내역 : <c:out value="${discountMap[payDate]}" /></span>
                    <span>결제일 : ${reserve.payDate}</span>
                </div>
            </c:forEach>

            <div class="reserve-buttons">
                <button onclick="moveToCancelReservePage()" class="cancel">취소하기</button>
                <a href="#" onclick="sessionDelete()"><button>홈으로</button></a>
            </div>
        </div>
    </div>

</body>
</html>