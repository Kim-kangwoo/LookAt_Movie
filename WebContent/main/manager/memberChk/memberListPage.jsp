<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세 정보</title>
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/memberlistpage.css">
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>

<h3>회원 상세 정보</h3>

	<div class="table-container">
	    <table class="member-table">
	        <thead>
	            <tr>
	                <th>번호</th>
	                <th>이름</th>
	                <th>성별</th>
	                <th>나이</th>
	                <th>별명</th>
	                <th>생년월일</th>
	                <th>아이디</th>
	               <!--  <th>비밀번호</th> -->
	                <th>전화번호</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach var="memberList" items="${memberList }" varStatus="status">
	                <tr>
	                    <td>${status.count}</td>
	                    <td>${memberList.memberName}</td>
	                    <td>${memberList.memberSex}</td>
	                    <td>${memberList.memberAge}</td>
	                    <td>${memberList.memberNickname}</td>
	                    <td>${memberList.memberBirthday}</td>
	                    <td>${memberList.memberLogid}</td>
	                    <%-- <td>${memberList.memberPassword}</td> --%>
	                    <td>${memberList.memberPhonenum}</td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	</div>

</body>
</html>
