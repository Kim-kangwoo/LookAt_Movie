<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이용약관 동의</title>
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/movieupdatesearchpage.css">
<title>수정용 조회된 영화 표시 페이지</title>
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>

<h3>영화 정보 수정 페이지</h3>

<c:choose>
	<c:when test="${status eq '일치하는 영화가 없습니다.' }">
		<p> 검색 결과 : ${status } </p>	
	</c:when>
	<c:when test="${status eq '조회 성공.' }">
		<c:forEach var="list" items="${searchResult }">
				
				<h2>수정할 내역을 작성해주시기 바랍니다.</h2>
				<form id="updateForm" action="${pageContext.request.contextPath }/controller?command=MA_movieUpdate" method="post">
					영화 제목 : <input type="text" name="movieName" value="${list.movieName }" maxlength="30" required><br>
					감독 : <input type="text" name="movieDirector" value="${list.movieDirector }" maxlength="30" required><br>
					장르 : <input type="text" name="movieType" value="${list.movieType }" maxlength="6" required><br>
					제작사 : <input type="text" name="movieStudio" value="${list.movieStudio }" maxlength="16" required><br>
					출연 배우 : <textarea name="movieActor" class="large-input" maxlength="100" required>${list.movieActor }</textarea><br>
					줄거리 : <textarea name="movieStory" class="large-input" maxlength="330" required>${list.movieStory }</textarea><br>
					이미지 경로 : <input type="text" name="movieImgPath" value="${list.movieImgPath }"  maxlength="330" title="영문자만 입력해주세요" required><br>
					평점 : <input type="number" name="movieStar"  value="${list.movieStar }" placeholder="5점만점, 소수점이하 1자리" min="0" max="5" step="0.1" pattern="^\d(\.\d)?$" required><br>
					
					<input type="hidden" name= "movieId" value="${list.movieId }"> 
					
					<div class = "button-style">
						<input type="submit" value="수정하기">
						<input type="reset" value="초기화">
					</div>
				</form>
		</c:forEach>	
	</c:when>
	<c:otherwise>
		<p> 뭔일이다냐 </p>
	</c:otherwise>
</c:choose>

<c:if test="${result eq 'update Success' }">
	<script>
		alert("영화 정보 수정이 완료되었습니다. 영화 목록 페이지로 이동합니다");
		location.href = "${pageContext.request.contextPath }/controller?command=MA_movieManagePage";
	</script>
</c:if>
<c:if test="${result eq 'update Fail' }">
	<script>
		alert("영화 정보 수정중 오류가 발생했습니다. 관리자에게 문의하세요.");
	</script>
</c:if>

<script>

	//바이트 계산 함수
	function getByteLength(str) {
		let byteLength = 0;
		for (let i = 0; i < str.length; i++) {
			const char = str.charAt(i);
			byteLength += (escape(char).length > 4) ? 2 : 1; // 한글은 2바이트, 그 외 문자는 1바이트
		}
		return byteLength;
	} 
	
	const movieActor = document.querySelector('textarea[name="movieActor"]')
	const movieStory = document.querySelector('textarea[name="movieStory"]')
	
	//출연 배우 textarea 바이트수 300제한 처리
	movieActor.addEventListener('input', function() {
		const text = movieActor.value;
		const byteLength = getByteLength(text);
		
		if (byteLength > 300) {
			movieActor.value = text.substring(0, text.length - 1); //초과한 문자는 제거
		}
		
	});
	
	//줄거리 textarea 바이트수 1000제한 처리
	movieStory.addEventListener('input', function() {
		const text = movieStory.value;
		const byteLength = getByteLength(text);
		
		if (byteLength > 1000) {
			movieStory.value = text.substring(0, text.length - 1);
		}
		
	});
	

</script>



</body>
</html>