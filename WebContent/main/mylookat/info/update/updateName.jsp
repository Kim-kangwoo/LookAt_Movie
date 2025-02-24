<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>이름 변경</title>
    <style>
        /* 전체 페이지 스타일 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #1e1e1e, #434343); /* 배경 색상 */
            color: #ff66b2; /* 글자 색상 */
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h1 {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #ff66b2; /* 제목 색상 */
            text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.5); /* 텍스트 그림자 */
        }

        /* 네비게이션 바 스타일 */
        .navbar {
            background-color: #ff66b2; /* 핑크색 배경 */
            width: 100%;
            padding: 10px 0;
            position: fixed;
            top: 0;
            left: 0;
            display: flex;
            align-items: center;
            justify-content: flex-start; /* 왼쪽 정렬 */
            padding-left: 15px; /* 왼쪽 여백 추가 */
        }

        .navbar-brand {
            color: white;
            font-size: 1.5rem;
            font-weight: bold;
            display: flex;
            align-items: center;
        }

        .navbar-brand img {
            margin-right: 10px;
        }

        /* 폼 스타일 */
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: rgba(0, 0, 0, 0.7); /* 배경색 */
            padding: 30px;
            border-radius: 10px;
            width: 100%;
            max-width: 400px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.5); /* 그림자 */
            margin-top: 80px; /* 네비게이션 바 아래에 여백 추가 */
        }

        label {
            font-size: 1.2rem;
            margin-bottom: 10px;
            color: #ffffff;
        }

        input[type="text"] {
            padding: 10px;
            margin: 10px 0;
            font-size: 1rem;
            width: 100%;
            border: none;
            border-radius: 5px;
            background-color: #444;
            color: #fff;
        }

        input[type="text"]:focus {
            outline: none;
            background-color: #555;
        }

        /* 버튼 스타일 */
        .button-container {
            display: flex;
            justify-content: space-between;
            width: 100%;
            margin-top: 20px;
        }

        button {
            background: linear-gradient(45deg, #ff4081, #ff66b2);
            color: white;
            font-size: 1rem;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 5px 15px rgba(255, 64, 129, 0.6);
        }

        button:hover {
            background: linear-gradient(45deg, #ff66b2, #ff4081);
            transform: scale(1.05);
            box-shadow: 0 0 20px rgba(255, 64, 129, 0.8);
        }

        button:active {
            transform: scale(0.95);
        }

        /* 링크 제거 스타일 */
        a {
            text-decoration: none;
        }
          /* 푸터 스타일 */
        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
            width: 100%;
            position: absolute;
            bottom: 0;
            left: 0;
        }

    </style>
    <script>
        // 폼 제출 전에 얼럿을 띄우는 함수
        function showAlert(event) {
          
            // 얼럿 창을 띄움
            const newName = document.getElementById('updateName').value;
            if (newName) {
                alert("회원님의 이름이 변경되었습니다: " + newName);
                // 얼럿 이후 폼 제출
                document.getElementById('nameChangeForm').submit();
            } else {
                alert("이름을 입력해주세요.");
            }
        }
    </script>
</head>
<body>
	
    <!-- 네비게이션 바 -->
    <nav class="navbar">
        <a class="navbar-brand" href="#">
            <img src="img/logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            My Look At 이름 변경
        </a>
    </nav>

    <h1>이름 변경</h1>
	
    <!-- 이름 변경 폼 -->
    <form action="${pageContext.request.contextPath }/controller?command=updateName" method="post" onsubmit="showAlert(event)">
        <label for="name">새로운 이름</label>
        <input type="text" id="updateName" name="updateName" required placeholder="새 이름을 입력하세요 (현재 이름 : ${member.memberName })">

        <!-- 버튼들 -->
        <div class="button-container">
            <button type="submit">수정</button>
            <button type="button" class="home-btn" onclick="location.href='main/index.jsp'">홈으로 돌아가기</button>
            <a href="${pageContext.request.contextPath }/controller?command=myUpdatePage">
                <button type="button">뒤로가기</button>
            </a>
        </div>
    </form>
     

</body>
</html>