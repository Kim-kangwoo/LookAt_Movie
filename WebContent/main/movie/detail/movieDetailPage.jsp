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
   href="${pageContext.request.contextPath}/css/moviedetailpage.css">
<head>


<body>
   <%@ include file="/main/header.jspf"%>
   <%@ include file="/main/nav.jspf"%>
   
   <h3>영화 상세정보 표시</h3>

<div class="movie-detail">
   <div class="movie-info">
      <c:forEach var="movie" items="${movieDetailList}">
         <div class="movie-item">
            <div class="movie-poster">
               <img src="${movie.movieImgPath}" alt="${movie.movieName } 포스터" title="${movie.movieName } 포스터">
            </div>
            <div class="movie-details">
               <ul>
                  <li>영화명: ${movie.movieName }</li>
                  <li>감독: ${movie.movieDirector }</li>
                  <li>배우: ${movie.movieActor }</li>
                  <li>장르: ${movie.movieType }</li>
                  <li>줄거리: ${movie.movieStory }</li>
                  <li>평점: ${movie.movieStar} / 5</li>
               </ul>
               <a href="${pageContext.request.contextPath }/controller?command=reserveTheater&movieId=${movie.movieId}">
                  <button>예매하기</button>
               </a>
            </div>
         </div>
      </c:forEach>
   </div>
</div>



<p> 성별에 따른 예매율 </p>
	<table>
		<thead>
			<tr>
				<th> 남 </th>
				<th> 여 </th>
 			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${malePercentage == 0.0 && femalePercentage == 0.0 }">
					<tr>
						<td colspan="2"> 집계된 데이터가 없습니다. </td>
					</tr>
				</c:when>
				<c:when test="${malePercentage == 0.0 }">
					<tr>
						<td> 집계된 데이터가 없습니다. </td>
						<td> ${femalePercentage}</td>
					</tr>
				</c:when>
				<c:when test="${femalePercentage == 0.0 }">
					<tr>
						<td> ${malePercentage} </td>
						<td> 집계된 데이터가 없습니다. </td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td> ${malePercentage} </td>
						<td> ${femalePercentage} </td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>


</body>
</html>