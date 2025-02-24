<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신나는 영화! LookAt</title>
<!-- 외부 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/salechkpage.css">
</head>

<body>
   <%@ include file="/main/header.jspf"%>
   <%@ include file="/main/nav.jspf"%>

   <h3 class="page-title">매출 관리 페이지</h3>

   <!-- 영화관별 매출, CGV 총매출 -->
   <p class="theater-count">▶ 현재 등록된 영화관 수: ${countTheater}</p>
   <h3 class="section-title">▼ 영화관별 매출 순위</h3> 
   <table class="theater-sales-table">
      <thead>
         <tr>
            <th class="rank-column">순위</th>
            <th class="theater-name-column">이름</th>
            <th class="sales-column">매출</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="theaterSaleList" items="${theaterSaleList}" varStatus="status">
            <tr>
               <td class="rank">${status.count}</td>
               <td class="theater-name">
                  <a href="${pageContext.request.contextPath }/controller?command=MA_theaterSalePage&theaterId=${theaterSaleList.theaterId}">
                     ${theaterSaleList.theaterName}
                  </a> 
               </td>
               <td class="sales">${theaterSaleList.theaterSale}</td>
            </tr>
         </c:forEach>
         <tr class="total-sales">
            <td colspan="2">총 매출</td>
            <td>${totalSale}</td>
         </tr>
      </tbody>
   </table>
   
</body>
</html>
