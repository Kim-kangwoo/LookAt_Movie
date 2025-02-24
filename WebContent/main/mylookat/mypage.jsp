<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage/mypage.css">
</head>

<body class="bg-dark text-light">
<%@ include file="/main/header.jspf" %>
   <title>마이페이지</title>

    
    <div class="container mt-5">
    
       
            
            <hr>
            <h1 class="text-center text-pink">My LookAt Movie 마이페이지</h1>
            <p class="list-group-item text-center">
                <span class="border border-danger-subtle">${member.memberName}</span>님 안녕하세요
            </p>
        </figure>
      
        <div class="row">
            <!-- 내 정보 -->
            <div class="col-lg-3 mb-4">
                <div class="card bg-dark text-light">
                    <div class="card-body">
                        <h3 class="card-title text-pink">내 정보</h3>
                        <ul class="list-unstyled">
                            <li><a href="${pageContext.request.contextPath }/controller?command=myLookAt"><button class="btn btn-pink btn-block mb-2">내 정보 조회</button></a></li>
                            <li><a href="${pageContext.request.contextPath }/controller?command=myUpdatePage"><button onclick="check()" class="btn btn-pink btn-block mb-2">내 정보 관리</button></a></li>
                            <li><a href="${pageContext.request.contextPath }/controller?command=myPoint"><button class="btn btn-pink btn-block mb-2">내 포인트</button></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- 예매내역 -->
            <div class="col-lg-3 mb-4">
                <div class="card bg-dark text-light">
                    <div class="card-body">
                        <h3 class="card-title text-pink">예매내역</h3>
                        <ul class="list-unstyled">
                            <li><a href="${pageContext.request.contextPath }/controller?command=myReservePage"><button class="btn btn-pink btn-block mb-2">예매내역 조회</button></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- 회원탈퇴 -->
            <div class="col-lg-3 mb-4">
                <div class="card bg-dark text-light">
                    <div class="card-body">
                        <h3 class="card-title text-pink">회원탈퇴</h3>
                        <ul class="list-unstyled">
                            <li><a href="${pageContext.request.contextPath }/controller?command=deleteMember"><button class="btn btn-pink btn-block mb-2">회원탈퇴</button></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>