<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>비밀번호 변경</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
    /* 전체 페이지 스타일 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
		/* 기본 스타일 */
		@font-face {
		    font-family: 'Cafe24Simplehae-v2.0';
		    src: url('../font/Cafe24Simplehae-v2.0.ttf') format('truetype');
		}
		
		@font-face {
		    font-family: 'Cafe24Danjunghae-v2.0';
		    src: url('../font/Cafe24Danjunghae-v2.0.ttf') format('truetype');
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
         	font-weight: bold;
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

        input[type="password"] {
            padding: 10px;
            margin: 10px 0;
            font-size: 1rem;
            width: 100%;
            border: none;
            border-radius: 5px;
            background-color: #444;
            color: #fff;
        }

        input[type="password"]:focus {
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
    

    		/* 
    			추가기능 개발
    			1. 새로운 비밀번호 두 번 다 맞게 입력했는지 체크
    		*/
    		
    		function update() {
				
    			// 바꿀 비밀번호 두번 다 맞게 입력했는지 비교할 데이터 추출
    			let updatePassword = document.getElementById('updatePassword').value;
        		let updatePasswordCheck = document.getElementById('updatePasswordCheck').value;
        		// 비밀번호 양식 정규식
        		const regExp = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
        		
        		// 비밀번호와 비밀번호확인 일치여부
        		if (updatePassword == updatePasswordCheck){
        			if(regExp.test(updatePassword)){
        				
        				const form = document.getElementById('passwordForm');
        				form.submit();
        				alert("회원님의 비밀번호가 변경되었습니다 :" + updatePassword )
        				
        			} else {
        				alert("입력양식에 올바르지 않은 값입니다.");
        			}
        			
        		} else {
        			alert("비밀번호와 비밀번호확인이 일치하지 않습니다");
        		}
    			
			}
    		
    		
    		
    		
    
    </script>
</head>
<body>
 <!-- 네비게이션 바 -->
    <nav class="navbar">
        <a class="navbar-brand" href="#">
            <img src="img/logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            My Look At 비밀번호 변경
        </a>
    </nav>

    <h1>비밀번호 변경</h1>
    
        <main>
            <section id="update-info">
                <form id="passwordForm" action="${pageContext.request.contextPath }/controller?command=updatePassword" method="post">
                	
                	<div class="form-group">
                		<label for="newPassword" style="color: white;">비밀번호 입력양식 : 최소 8자리 최대 20자리 영문,특수문자 포함</label>
                	</div>
                	
                    <div class="form-group">
                        <label for="newPassword">새로운 비밀번호</label>
                        <input type="password" id="updatePassword" name="updatePassword" required required placeholder="새로운 비밀번호를 입력하세요">
                    </div>
                    
                    <div class="form-group">
                        <label for="newPassword">새로운 비밀번호 확인</label>
                        <input type="password" id="updatePasswordCheck" name="updatePasswordCheck" required required placeholder="새로운 비밀번호를 입력하세요">
                    </div>

                    <div class="button-container">
                        <button type="button" onclick="update()" value="수정">수정</button>
                        <button type="button" class="home-btn" onclick="location.href='main/index.jsp'">홈으로 돌아가기</button>
                        <a href="${pageContext.request.contextPath }/controller?command=myUpdatePage">
                            <button type="button">뒤로가기</button>
                        </a>
                    </div>
                    
                </form>
            </section>
        </main>
    
 

</body>
</html>