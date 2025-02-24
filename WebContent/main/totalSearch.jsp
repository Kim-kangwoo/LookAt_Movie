<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>통합검색 | Look At Movie</title>
	   <!-- 외부 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/totalSearch.css">
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
	
	<div class="totalMain">
		<div class="totalSearch">
			<div class="totalSearch_title">
				<!-- 상단 고정 -->
				<div>지금 예매 가능한 영화</div>	
			</div>
			
			<div class="totalSearch_contents">
				<!-- 영화 표시 -->
				<c:set var="findMovieListSize" value="${findMovieList.size() }" />
				<c:choose>
					<c:when test="${findMovieListSize > 0 }">
						<c:forEach var="movie" items="${findMovieList }">
							<div class="totalSearch_contents_findMovie">
						 		<div class="totalSearch_contents_moivePoster">
							 		<!-- 영화 포스터 이미지 -->
						    		<img class="moviePoster" alt="movieposter" src="${movie.movieImgPath}" onerror="this.style.visibility='hidden'" />
						    	</div>
						 		
						 		<div class="totalSearch_contents_moiveDetail">
						 			<div class="totalSearch_contents_moiveDetail_name">${movie.movieName }</div>
							 		<div class="totalSearch_contents_moiveDetail_star">별점 : ${movie.movieStar }</div>
							 		<div class="totalSearch_contents_moiveDetail_story">${movie.movieStory }</div>
							 		<div class="totalSearch_contents_moiveDetail_button">
							 			<a class="btn-gradient normal small" href="${pageContext.request.contextPath }/controller?command=movieDetailPage&movieId=${movie.movieId}" >상세보기</a>
							 			<a class="btn-gradient red small" href="${pageContext.request.contextPath }/controller?command=reserveTheater&movieId=${movie.movieId}" >예매하기</a>
									</div>
						 		</div>
				 			</div>
						</c:forEach>
					</c:when>
				
					<c:when test="${findMovieListSize == 0 }">
					
						<div class="totalSearch_contents_fail">
							<div>'${searchValue }' 검색결과가 없습니다</div>
							<div>영화 또는 인물명을 확인 후 다시 검색해주세요</div>
						</div>
				 		
			 		</c:when>	
				</c:choose>
			</div>
			<hr>
		</div>
	</div>		
</body>
</html>