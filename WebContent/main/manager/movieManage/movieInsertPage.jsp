<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신나는 영화! LookAt</title>
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/movieinsertpage.css">
<head>
<title>새로운 영화 등록</title>
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>

	<h3>새로운 영화 등록 페이지</h3> 
	<form id="insertForm" action="${pageContext.request.contextPath }/controller?command=MA_movieInsert" method="post">
		영화 제목 : <input type="text" name="movieName" maxlength="30" required><br>
		감독 : <input type="text" name="movieDirector" maxlength="30" required><br>
		장르 : <input type="text" name="movieType" maxlength="6" required><br>
		제작사 : <input type="text" name="movieStudio" maxlength="16" required><br>
		출연 배우 : <textarea name="movieActor" class="large-input" maxlength="100" required></textarea><br>
		줄거리 : <textarea name="movieStory" class="large-input" maxlength="330" required></textarea><br>
		이미지 경로 : <input type="text" name="movieImgPath" pattern="[a-zA-Z0-9]*"  maxlength="330" title="영문자만 입력해주세요" required><br>
		평점 : <input type="number" name="movieStar" placeholder="5점만점, 소수점이하 1자리" min="0" max="5" step="0.1" pattern="^\d(\.\d)?$" required><br>
		
		<input type="submit" value="등록하기">
		<input type="reset" value="초기화">
	</form>
	

	<c:choose>
		<c:when test="${status eq 'null or empty'}">
			<script>alert("모든 항목을 입력해주세요");</script>
		</c:when>
		<c:when test="${status == 'insert fail'}">
			<script>
				alert("영화 등록에 오류가 발생했습니다.");
			</script> 
		</c:when>
		<c:when test="${status == 'insert success'}"> 
			<script>
				if (confirm("영화 등록이 완료되었습니다. \n영화를 더 추가하시겠습니까?")) {
					location.href="${pageContext.request.contextPath }/controller?command=MA_movieInsertPage";
				} else {
					location.href="${pageContext.request.contextPath }/controller?command=MA_movieManagePage"
				}
			</script>
		</c:when>
	</c:choose>
	
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