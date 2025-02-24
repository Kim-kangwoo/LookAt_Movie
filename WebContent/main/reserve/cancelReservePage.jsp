<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매취소 | Look at Movie</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reserve/cancelReservePage.css">

<script>
	
	//서버에서 넘어온 불린
	let check = "${check}";
	
	// 비밀번호 서버에서 검증
	function cancelReserve() {
		
		let answer = confirm("예매내역을 삭제 할까요?");
		
	    if (answer) {
	    	
	    	// 회원 비밀번호 input
	    	let num = prompt("회원 비밀번호를 입력해주세요");
	    	if (num != null) {
				
	    		// 1. 비밀번호 서버로 전송
	    		// 경로 파라미터 말고 post로 넘길 수 있는지 확인
	    		
	    		// 파라미터 값 암호화방법
	    		//var parameter = 'abc가나다123!@#';
				//parameter = btoa(encodeURIComponent(parameter));
				
				// 파라미터 값 암호화
				num = btoa(encodeURIComponent(num));
	    		// 현 경로 (전에 받은 파라미터 값 유지)
				let href = window.location.href;
	    		const url = new URL(href);
	    		const urlParams = url.searchParams;
	    		const payDate = urlParams.get('payDate');
	    		
	    		// 암호화와 함께 커맨드로 전송
	    		location.href="${pageContext.request.contextPath }/controller?command=cancelReservePage&payDate=" + payDate + "&num=" + num;
				
				
	    	}
	    	
	    } 
	}
	
	// 2. 돌려 받은 불린 값에 따라 결제 페이지로 이동
	if (check == "true") {
		
		// true 결제 커맨드 이동
		location.href="${pageContext.request.contextPath }/controller?command=cancelReserve"

	} else if (check == "false") {
		// false 재차 확인
		alert("비밀번호가 알맞지 않습니다! 다시 시도해주세요");
	}
	
</script>
</head>
<body>
	<%@ include file="/main/header.jspf" %>
	<%@ include file="/main/nav.jspf" %>
	
	<!-- 취소여부 한번 더 묻기 -->
	 <div class="cancel-content">
        <h1>선택한 예매 취소 내역</h1>

        <c:forEach var="reserve" items="${cancelReserveList}">
            <c:set var="payDate" value="${reserve.payDate }" />
            <c:set var="runtimeId" value="${reserve.runtimeId }" />
            <c:set var="price" value="${totalPriceMap[payDate]}" />
            
            <div class="reserve-info">
                <label>예매 정보</label>
                <span>영화명 : <c:out value="${theaterNameMap[runtimeId]}" /></span>
                <span>극장 : <c:out value="${movieNameMap[runtimeId]}" /></span>
                <span>일시 : <c:out value="${runtimeMap[runtimeId].runDate}" /> <c:out value="${runtimeMap[runtimeId].startTime}" /> ~ <c:out value="${runtimeMap[runtimeId].endTime}" /></span>
                <span>인원 : <c:out value="${peopleCountMap[payDate]}" /> 명</span>
                <span>좌석 : <c:out value="${seatMap[payDate]}" /></span>
                <span>결제된 금액 : <c:out value="${totalPriceMap[payDate]}" /> </span>
                <span>결제일 : ${reserve.payDate }</span>
            </div>
        </c:forEach>
        
        <div class="total-price">
            총 취소 금액 : ${cancelTotalPrice }원
        </div>

        <button onclick="cancelReserve()">취소하기</button>
    </div>
</body>
</html>