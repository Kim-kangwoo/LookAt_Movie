<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매내역 확인 | Look at Movie</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reserve/reserveCompleteCheck.css">
<script>
    // 선택 시 전체 클릭
    function selectAll(selectAll) {
        const checkboxes = document.getElementsByName('condition');
        checkboxes.forEach((checkbox) => {
            checkbox.checked = selectAll.checked;
        });
    }

    // 결제 요청과 결제 완료 페이지로 전환
    function moveToPay() {
        // 변수지정
        let checkString = " ";

        // 체크박스 추출
        const checkboxCheck = document.querySelectorAll('input[type="checkbox"]');

        // 모든 체크박스 돌면서 값 확인
        checkboxCheck.forEach((check) => {
            // 불린 -> 문자열로 변환
            let checkChange = check.checked;
            checkString += checkChange.toString() + " ";
        });

        // 체크박스 전부 체크 시 이동
        if (checkString.includes("false")) {
            checkString = " ";
            alert("약관에 모두 동의해주세요!");
        } else {
            checkString = " ";
            location.href = "${pageContext.request.contextPath }/controller?command=reserveCompleteRev&leftTotalPrice=" + ${leftTotalPrice};
        }
    }
</script>

</head>
<body>
    <div class="container">
        <h1>예매 결제 전 확인</h1>

        <div class="movie-info">
            <div>
                <div class="movie_info_child"><strong>영화명:</strong> ${findMovie.movieName}</div>
                <div class="movie_info_child"><strong>극장:</strong> ${findTheater.theaterName}</div>
                <div class="movie_info_child"><strong>일시:</strong> ${findRuntime.runDate} &nbsp; ${findRuntime.startTime} ~ ${findRuntime.endTime}</div>
                <div class="movie_info_child"><strong>인원:</strong> ${selectPeople}명</div>
                <div class="movie_info_child"><strong>좌석:</strong> ${selectSeatId}</div>
            </div>
            <div class="movie-poster" style="background-image: url('${findMovie.movieImgPath}')"></div>
        </div>

        <div class="separator"></div>

        <div class="payment-info">
            <h2>결제정보</h2>
            <div><strong>결제 금액:</strong> ${leftTotalPrice}</div>
            <div><strong>결제 수단:</strong> <c:out value="${paymentType[radioValue]}" /></div>
        </div>

        <div class="separator"></div>

        <div class="terms-agree">
            <h2>약관 동의</h2>
            <div>
                <input type="checkbox" name="condition">
                <span class="checkbox-label">전자금융거래 이용약관</span>
            </div>
            <div>
                <input type="checkbox" name="condition">
                <span class="checkbox-label">개인정보 수집 이용약관</span>
            </div>
            <div>
                <input type="checkbox" name="all" value="selectall" onclick="selectAll(this)">
                <span class="checkbox-label">상기 결제 내역을 모두 확인했습니다</span>
            </div>
        </div>

        <div class="separator"></div>

        <div class="button" onclick="moveToPay()">결제</div>
        <div class="button" onclick="history.back()">취소</div>
    </div>
</body>
</html>
