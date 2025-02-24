<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
<style>
  /* 전체 스타일 */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #000000;
    color: #ff66b2;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

 /* 영화 목록 컨테이너 */
    .movie-list {
        display: flex;
        flex-wrap: wrap; /* 항목이 여러 줄로 나뉘도록 설정 */
        gap: 20px; /* 카드 간 여백 */
        padding: 20px;
        justify-content: flex-start; /* 카드들을 왼쪽 정렬 */
    }
    

    /* 각 영화 항목 */
    .movie-list li {
        width: 30%; /* 각 카드의 너비를 30%로 설정 */
        min-width: 250px; /* 카드 크기가 너무 작아지지 않도록 최소 너비 설정 */
        background-color: #222222; /* 카드 배경 색상 */
        border-radius: 15px; /* 둥근 모서리 */
        padding: 20px;
        box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2); /* 부드러운 그림자 효과 */
        transition: transform 0.3s ease, box-shadow 0.3s ease; /* 호버 시 애니메이션 */
        text-align: center;
        color: #ff66b2; /* 영화 제목 색상 */
    }

    .movie-list li:hover {
        transform: translateY(-10px); /* 호버 시 약간 위로 올라가는 효과 */
        box-shadow: 0 12px 25px rgba(0, 0, 0, 0.3); /* 호버 시 그림자 효과 강화 */
    }

    /* 영화 포스터 스타일 */
    .movie-list img {
        width: 300px;
        height: 400px;
        object-fit: cover;
        border-radius: 10px; /* 이미지 모서리 둥글게 */
        margin-bottom: 15px;
    }
  
    /* 영화 제목 스타일 */
    .movie-list h2 {
        font-size: 1.2rem;
        margin: 10px 0;
        font-weight: bold;
    }

/* 예매하기 버튼 스타일 */
.movie-list button {
    background-color: #ff66b2;
    color: #000000;
    border: none;
    padding: 12px 25px;
    border-radius: 30px;
    font-size: 1rem;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.3s ease;
    text-transform: uppercase;
}

.movie-list button:hover {
    background-color: #ff3385;
    transform: scale(1.05);
}

/* 예매율순, 평점순 드롭다운 스타일 */
.movie-sorting {
    margin: 20px auto;
    text-align: center;
}

.movie-sorting select {
    background-color: #222222;
    color: #ff66b2;
    padding: 10px;
    border: 1px solid #ff66b2;
    border-radius: 20px;
    font-size: 1rem;
    cursor: pointer;
    width: 150px;
    transition: background-color 0.3s ease, color 0.3s ease;
}

.movie-sorting select:hover {
    background-color: #ff66b2;
    color: #000;
}

.movie-sorting input[type="submit"] {
    background-color: #ff66b2;
    color: #000;
    border: none;
    padding: 12px 25px;
    border-radius: 30px;
    font-size: 1rem;
    cursor: pointer;
    text-transform: uppercase;
    margin-left: 10px;
    transition: background-color 0.3s, transform 0.3s ease;
}

.movie-sorting input[type="submit"]:hover {
    background-color: #ff3385;
    transform: scale(1.05);
}

/* 예매율순, 평점순 옵션에 대한 스타일 */
.success {
    padding: 10px 20px;
    font-size: 1rem;
    background-color: #ff66b2;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.success:hover {
    background-color: #e60099;
}

   /* 영화 목록 제목 스타일 */
.movie {
    line-height: 3;
    font-weight: bold;
    font-size: 1.2rem;
    color: #ff66b2;
}

hr {
    border: 1px solid #ff66b2;
    margin: 20px 0;
}

</style>


</head>
<body>
<%@ include file="/main/header.jspf" %>
<%@ include file="/main/nav.jspf" %>

<hr>
<h2 class="movie">전체 영화 목록</h2>
	
	<div class="movie-sorting">
		<form action="${pageContext.request.contextPath}/controller" method="post">
              <select name="orderType">
                  <option value="1" ${orderType == '1' ? 'selected' : ''}>예매율순</option>
                  <option value="2" ${orderType == '2' ? 'selected' : ''}>평점순</option>
              </select>
              <input class="success" type="submit" value="적용">
              <input type="hidden" name="command" value="movieSortPage">
          </form>
	</div>
	
	
	    <div class="movie-list">
        <c:forEach var="movieList" items="${movieList}" varStatus="status">
            <li class="movie">
                No.${status.count} <br>
                <a href="${pageContext.request.contextPath}/controller?command=movieDetailPage&movieId=${movieList.movieId}">
                    <img src="${movieList.movieImgPath}" alt="${movieList.movieName} 포스터" title="${movieList.movieName} 포스터">
                </a><br>
                ${movieList.movieName}
                <a href="${pageContext.request.contextPath}/controller?command=movieDetailPage&movieId=${movieList.movieId}">
                    <button>예매하기</button>
                </a>
            </li>
        </c:forEach>
    </div>
	
	
	


</body>
</html>