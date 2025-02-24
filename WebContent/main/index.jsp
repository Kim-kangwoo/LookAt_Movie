<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="user" value="${sessionScope.member }" />
<!-- 로그인 상태인지 확인 -->
<c:set var="isManager" value="${sessionScope.isManager }" />
<!-- 관리자 - 일반사용자 확인 -->

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신나는 영화! LookAt</title>
<!-- 외부 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
</head>

<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>

	<!-- 영상광고 넣을 자리 -->
	<div id="ctl00_PlaceHolderContent_divMovieSelection_wrap" class="movieSelection_wrap">
                <div class="contents">

                    <div class="video_wrap">
                        
                    <video autoplay="" muted="">
                        <source src="https://adimg.cgv.co.kr/images/202411/TheUnrighteous/TheUnrighteous_1080x608_PC.mp4" type="video/mp4">
                        이 브라우저는 Video 태그를 지원하지 않습니다. (Your browser does not support the video tag.)
                    </video>
                    </div>
                </div>
            </div>
	
	
	
	<!-- 메인 콘텐츠 -->
	<div class="container">
		<section>
			<h2 class="section-title">최신 영화 소개</h2>
			<div class="movies">
				<div class="movie-card">
					<img
						src="${pageContext.request.contextPath}/img/gladiator_poster.jpg"
						alt="글래디에이터2">
					<p>글래디에이터 </p>
					<p>액션과 스릴이 가득한 영화, 꼭 보세요!</p>
					<div class="overlay">
						<a
							href="${pageContext.request.contextPath }/controller?command=movieDetailPage&movieId=3">
							<button class="book-button">상세보기</button>
						</a>
						<a id="movie" href="${pageContext.request.contextPath }/controller?command=reserveTheater&movieId=3">
							<button class="book-button">예매하기</button>
						</a>
					</div>
				</div>
				<div class="movie-card">
					<img
						src="${pageContext.request.contextPath}/img/chungsul_poster3.jpg"
						alt="청설">
					<p>청설</p>
					<p>액션과 스릴이 가득한 영화, 꼭 보세요!</p>
					<div class="overlay">
						<a
							href="${pageContext.request.contextPath }/controller?command=movieDetailPage&movieId=2">
							<button class="book-button">상세보기</button>
						</a>
						<a id="movie" href="${pageContext.request.contextPath }/controller?command=reserveTheater&movieId=2">
							<button class="book-button">예매하기</button>
						</a>
					</div>
				</div>
				<div class="movie-card">
					<img src="${pageContext.request.contextPath}/img/wikid_poster.jpg"
						alt="위키드">
					<p>위키드</p>
					<p>액션과 스릴이 가득한 영화, 꼭 보세요!</p>
					<div class="overlay">
						<a
							href="${pageContext.request.contextPath }/controller?command=movieDetailPage&movieId=1">
							<button class="book-button">상세보기</button>
						</a>
						<a id="movie" href="${pageContext.request.contextPath }/controller?command=reserveTheater&movieId=1">
							<button class="book-button">예매하기</button>
						</a>
					</div>
				</div>
			</div>
		</section>
	</div>

	<!-- 푸터 -->
	<div class="footer">
		<p>&copy; 2024 LookAt. All rights reserved.</p>
	</div>

</body>
</html>