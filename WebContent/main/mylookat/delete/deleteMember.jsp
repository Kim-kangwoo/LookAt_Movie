<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원탈퇴</title>
    <link rel="stylesheet" href="styles.css"> <!-- 외부 CSS 파일 링크 -->
    <style type="text/css">
        body {
            background-color: #1a1a1a; /* 어두운 배경 */
            color: white; /* 텍스트 색상 */
            font-family: 'Arial', sans-serif; /* 기본 글꼴 */
        }

        h1 {
            font-size: 3rem; /* 제목 폰트 크기 확대 */
            color: #ff66b2; /* 핑크색 텍스트 */
            font-weight: bold;
            margin-bottom: 20px;
        }

        p {
            font-size: 1.5rem; /* 본문 텍스트 크기 확대 */
            color: #f1f1f1; /* 본문 텍스트 색상 */
        }

        .btn {
            padding: 15px 30px; /* 버튼 크기 증가 */
            border-radius: 8px;
            font-size: 1.2rem; /* 버튼 텍스트 크기 증가 */
            width: 300px; /* 버튼 넓이 */
        }

        .btn-danger {
            background-color: #e60000; /* 빨간색 버튼 */
            color: white;
            border: none;
            transition: background-color 0.3s ease;
        }

        .btn-danger:hover {
            background-color: #c90000; /* 호버 시 짙은 빨간색 */
        }

        .btn-light {
            background-color: #f8f9fa; /* 연한 회색 배경 */
            color: black;
            border: none;
        }

        .btn-light:hover {
            background-color: #e2e6ea; /* 호버 시 연한 회색 */
        }

        .container {
            max-width: 600px; /* 컨테이너 너비 확장 */
            margin: 0 auto;
            padding: 40px;
            background-color: #2c2f33; /* 어두운 배경 */
            border-radius: 10px;
            text-align: center;
        }

        hr {
            border: 1px solid #ff66b2; /* 핑크색 구분선 */
            margin-top: 30px;
        }

        /* 홈으로 돌아가기 버튼 디자인 */
        .home-button, .back-button {
            position: absolute;
            top: 20px;
            left: 20px;
        }

        .btn-home, .btn-back {
            background-color: #ff66b2; /* 핑크색 버튼 */
            color: white;
            padding: 10px 20px;
            font-size: 1.2rem;
            border-radius: 8px;
            text-decoration: none; /* 링크의 기본 스타일 제거 */
            transition: background-color 0.3s ease;
        }

        .btn-home:hover, .btn-back:hover {
            background-color: #e600b3; /* 핑크색 버튼 호버 시 더 짙은 색상 */
        }

        /* 작은 화면에서 버튼 스타일 */
        @media (max-width: 768px) {
            .container {
                padding: 30px; /* 작은 화면에서는 패딩을 줄임 */
            }
            
            .btn {
                width: 100%; /* 작은 화면에서 버튼이 화면 너비를 차지하도록 설정 */
            }

            h1 {
                font-size: 2rem; /* 작은 화면에서 제목 크기 축소 */
            }

            p {
                font-size: 1.2rem; /* 본문 텍스트 크기 축소 */
            }

            .home-button, .back-button {
                top: 10px;
                left: 10px;
            }

            .btn-home, .btn-back {
                font-size: 1rem; /* 작은 화면에서 버튼 크기 축소 */
                padding: 8px 16px;
            }
        }
    </style>

<script>

		function deleteMember() {
			
		    if (confirm("정말 탈퇴하시겠습니까?")) {
		    		
			let inputPassword = prompt("비밀번호를 입력해주세요");
			console.log("[TEST] inputPassword : " + inputPassword);
			let password = "${member.memberPassword}";
			if (password != inputPassword) {
				alert("비밀번호가 일치하지 않습니다");
			} else {
				let form = document.getElementById('deleteForm');
				form.submit();
			}

		}

	}
</script>


</head>
<body class="bg-dark text-light">

  

    <!-- 뒤로가기 버튼 (좌측 상단) -->
    <div class="back-button">
        <a href="${pageContext.request.contextPath }/controller?command=myPage" class="btn btn-back">뒤로가기</a>
    </div>

    <div class="container mt-5">
        <h1>LookAt Movie 회원탈퇴</h1>
        <form id="deleteForm" action="${pageContext.request.contextPath }/controller?command=successDelete" method="post">
            <p>회원탈퇴 하시겠습니까?</p>
            <div class="d-flex justify-content-center">
                <input type="button" onclick="deleteMember()" value="회원탈퇴" class="btn btn-danger btn-lg" id="deleteButton">
            </div>
        </form>

        <hr>
    </div>

</body>
</html>