<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신나는 영화! LookAt</title>
<!-- 외부 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/movieupdatepage.css">
<head>
<title>기존 영화 정보 수정</title>
</head>
<body>
    <%@ include file="/main/header.jspf"%>
    <%@ include file="/main/nav.jspf"%>

    <h3>기존 영화 정보 수정 : 수정할 영화 찾기</h3>

    <div class="container">
        <!-- 왼쪽: 영화 검색 폼 -->
        <div class="left-container">
            <form id="searchForm" action="${pageContext.request.contextPath }/controller?command=MA_movieUpdateSearch" method="post">
                <p>검색할 영화 이름, 감독 이름을 입력해주세요.</p>

                <div class="input-group">
                    <label for="searchMovieName">영화 이름 :</label> 
                    <input type="text" id="searchMovieName" name="searchMovieName" required>
                </div>

                <div class="input-group">
                    <label for="searchDirectorName">감독 이름 :</label> 
                    <input type="text" id="searchDirectorName" name="searchDirectorName" required>
                </div>

                <input type="submit" value="검색">
            </form>
        </div>

        <!-- 오른쪽: 영화 목록 테이블 -->
        <div class="right-container">
            <form id="updateForm" action="${pageContext.request.contextPath }/controller?command=MA_movieUpdateById" method="post">
                <table id="movieTable">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>영화 제목</th>
                            <th>감독 이름</th>
                            <th>선택</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="movieList" items="${movieList }" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td><a class="movie-link" href="${pageContext.request.contextPath }/controller?command=movieDetailPage&movieId=${movieList.movieId}">${movieList.movieName }</a></td>
                                <td>${movieList.movieDirector }</td>
                                <td><button type="submit" name="movieId" value="${movieList.movieId}" class="update-btn">수정</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
