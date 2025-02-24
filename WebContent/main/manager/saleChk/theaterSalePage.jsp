<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신나는 영화! LookAt</title>
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/theatersalepage.css">
</head>
<body>
    <%@ include file="/main/header.jspf"%>
    <%@ include file="/main/nav.jspf"%>

    <h3 class="page-title">영화관별 상영중 영화 매출 순위</h3>
    <h3 class="theater-sales-title">${theaterName} 영화 매출 순위</h3>

    <table class="sales-table">
        <thead>
            <tr>
                <th class="table-header">순위</th>
                <th class="table-header">상영중 영화 제목</th>
                <th class="table-header">매출</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${movieSaleList == null || movieSaleList.isEmpty()}">
                <tr>
                    <td colspan="3" class="no-data">상영 중인 영화가 없습니다.</td>
                </tr>
            </c:if>
            <c:forEach var="movieList" items="${movieSaleList}" varStatus="status">
                <tr>
                    <td class="rank">${status.count}</td>
                    <td class="movie-title">
                        <a href="${pageContext.request.contextPath}/controller?command=movieDetailPage&movieId=${movieList.movieId}">
                            ${movieList.movieName}
                        </a>
                    </td>
                    <td class="sales">${movieList.movieSale}</td>
                </tr>
            </c:forEach>
            <tr class="total-row">
                <td colspan="2" class="total-text">총 매출</td>
                <td class="total-sales">${theaterSale}</td>
            </tr>
        </tbody>
    </table>
</body>
</html>
