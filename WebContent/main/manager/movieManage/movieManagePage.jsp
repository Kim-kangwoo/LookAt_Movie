<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신나는 영화! LookAt</title>
<!-- 외부 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/moviemanagepage.css">
<head>
<title>영화 정보 수정 페이지</title>
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>

	<h3 class="page-title">영화 정보 관리 페이지</h3>
	<br>
	<br>

	<p class="movie-count">▶ 등록된 영화 개수 : ${movieCnt }</p>
	<br>
	<p class="movie-list-title">▼ 현재 등록된 영화 목록</p>
	<br>

	<table id="movieTable" class="movie-table">
		<thead>
			<tr>
				<th class="table-header">번호</th>
				<th class="table-header">영화 제목</th>
				<th class="table-header">감독 이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="movieList" items="${movieList }" varStatus="status">
				<tr class="table-row">
					<td class="table-cell">${status.count}</td>
					<!-- 번호 매기기 -->
					<td class="table-cell"><a
						href="${pageContext.request.contextPath }/controller?command=movieDetailPage&movieId=${movieList.movieId}"
						class="movie-link"> ${movieList.movieName} </a></td>
					<td class="table-cell">${movieList.movieDirector}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>

	<ul class="action-list">
		<li class="action-item"><a
			href="${pageContext.request.contextPath }/controller?command=MA_movieInsertPage"
			class="action-link"> <span>새로운 영화 등록</span>
		</a></li>
		<li class="action-item"><a
			href="${pageContext.request.contextPath }/controller?command=MA_movieUpdatePage"
			class="action-link"> <span>기존 영화 정보 수정</span>
		</a></li>
		<li class="action-item"><a
			href="${pageContext.request.contextPath }/controller?command=MA_movieDeletePage"
			class="action-link"> <span>영화 삭제</span>
		</a></li>
	</ul>

</body>
</html>
