<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>닉네임 변경하기</title>
    <style>
	    /* 기본 스타일 */
	@font-face {
	    font-family: 'Cafe24Simplehae-v2.0';
	    src: url('../font/Cafe24Simplehae-v2.0.ttf') format('truetype');
	}
	
	@font-face {
	    font-family: 'Cafe24Danjunghae-v2.0';
	    src: url('../font/Cafe24Danjunghae-v2.0.ttf') format('truetype');
	}
        /* 전체 페이지 스타일 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
          
            background: linear-gradient(135deg, #1e1e1e, #434343); /* 배경 색상 */
            color: #ff66b2; /* 글자 색상 */
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh; /* 전체 화면 높이 */
            padding: 0;
        }

        h1 {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #ff66b2; /* 제목 색상 */
            text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.5); /* 텍스트 그림자 */
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
            flex-direction: column;
            align-items: center;
            margin-top: 20px;
        }

        .button-container button {
            background: linear-gradient(45deg, #ff4081, #ff66b2);
            color: white;
            font-size: 1rem;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 5px 15px rgba(255, 64, 129, 0.6);
            margin: 10px 0;
            width: 100%;
        }

        .button-container button:hover {
            background: linear-gradient(45deg, #ff66b2, #ff4081);
            transform: scale(1.05);
            box-shadow: 0 0 20px rgba(255, 64, 129, 0.8);
        }

        .button-container button:active {
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
        

    </style>
<script>
	
	let duplNickname = "${duplNickName}"; 

	if (duplNickname == 'true'){
		alert("중복된 닉네임입니다! ");
	}
	
	function update() {
		
		let updateNickName = document.getElementById('updateNickName').value;
		
		console.log("updateNickName : " + updateNickName);
		console.log("updateNickName.length : " + updateNickName.length);
		
		if (0 < updateNickName.length && updateNickName.length <= 10){
		
			var theForm = document.form;
			theForm.action = "${pageContext.request.contextPath }/controller?command=updateNickname&updateNickname=" + updateNickName;
			theForm.method = "post"
			theForm.submit();
			
			alert("회원님의 닉네임이 변경되었습니다 : " + updateNickName)
		} else {
			alert("글자수는 최소 0에서 10자리까지입니다! ");
		}
		
	}


</script>

</head>
<body>
 <!-- 네비게이션 바 -->
    <nav class="navbar">
        <a class="navbar-brand" href="#">
            <img src="img/logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            My Look At 정보 수정
        </a>
    </nav>
    
    <!-- 닉네임 변경 제목 -->
    <h1>닉네임 변경하기</h1>

    <!-- 닉네임 변경 폼 -->
    <form name="form">
        <label for="nickname">기존 닉네임 : ${member.memberNickname }</label>
        <input type="text" id="updateNickName" name="updateNickName" required placeholder="새 닉네임을 입력하세요 글자수 제한 : 10">

        <!-- 버튼들 -->
        <div class="button-container">
            <button type="button" onclick="update()">수정</button>
            <a href="main/index.jsp">
                <button type="button" class="home-btn">홈으로 돌아가기</button>
            </a>
            <a href="${pageContext.request.contextPath }/controller?command=myUpdatePage">
                <button type="button" class="back-btn">뒤로가기</button>
            </a>
        </div>
    </form>

  

</body>
</html>