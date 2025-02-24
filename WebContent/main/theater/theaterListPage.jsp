<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>극장 목록 페이지</title>
</head>
<body>

<%@ include file="/main/header.jspf"%>
<%@ include file="/main/nav.jspf"%>

		
<c:set var="theater" value="${request.theaterList }"  />

<!-- 영화관 목록 -->
<c:forEach var="theater" items="${theaterList }" varStatus="status">
	<a href="">
		<p> ${theater.theaterName }</p>
	</a>
</c:forEach>



</body>
</html>