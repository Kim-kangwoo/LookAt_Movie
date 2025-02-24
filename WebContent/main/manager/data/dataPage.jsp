<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신나는 영화! LookAt</title>
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/datapage.css">
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
	
    <div class="container">
		<h3 class="page-title">영화 예매 통계 페이지</h3>
	
<div class="stats-table-container">
			<table class="stats-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>영화 제목</th>
						<th>감독</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="movieList" items="${movieList}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td><a class="movie-link"
								href="${pageContext.request.contextPath}/controller?command=MA_moviePreferPage&movieId=${movieList.movieId}">${movieList.movieName}</a></td>
							<td>${movieList.movieDirector}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
    
    
    
    
    

</body>
</html>