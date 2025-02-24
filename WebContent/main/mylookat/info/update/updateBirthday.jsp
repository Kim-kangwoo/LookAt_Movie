<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>생년월일 변경</title>
    <style>
        /* 전체 페이지 스타일 */
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

	function update(frm){
		
		let updateBirthday = document.getElementById('updateBirthday').value;	
		// 19921012
		let checkYear = parseInt(updateBirthday.slice(0, 4), 10);
		let checkMonth = parseInt(updateBirthday.slice(4, 6), 10);
		let checkDay = parseInt(updateBirthday.slice(6, 8), 10);
		
		// 자릿수 8자리 검증, 숫자로 변환 뒤 문자가 들어오면 안된다고 표시
		// 1900~ 2024년, 1~12 월, 1 ~ 31 일 범위 안에 들어오는 지 검증
		
		if(updateBirthday.length == 8){
			// 년도 검증
			if (1900 <= checkYear && checkYear <= 2024){
				// 월 검증
				if(1 <= checkMonth && checkMonth <= 12){
					//일 검증
					if(1 <= checkDay && checkDay <= 31){
						// 4, 6, 9, 11월 30일 검증
						if((checkMonth == 4 || checkMonth == 6 || checkMonth == 9 || checkMonth == 11) && checkDay == 31){
							alert("해당 월에 존재하지 않는 일을 입력하셨습니다! [30일검증] 월 : " + checkMonth +  ", 일 : " + checkDay);
							
							// 2월 28일 검증
						} else if (checkMonth == 2 && checkDay > 28) {
							alert("해당 월에 존재하지 않는 일을 입력하셨습니다! [2월검증] 월 : " + checkMonth +  ", 일 : " + checkDay);
							
						} else {
							
							var theForm = document.form;
							theForm.method = "post";
							theForm.action = "${pageContext.request.contextPath }/controller?command=updateBirthday&updateBirthday=" + updateBirthday;
							theForm.submit();
							
						    // 수정 성공 알림
	                        alert("회원님의 생년월일이 변경되었습니다!" + updateBirthday );
						}
					} else{
						alert("잘못된 일 입력입니다! : " + checkDay);
					}
				} else {
					alert("잘못된 월 입력입니다! : " + checkMonth);	
				}
			} else {
				alert("잘못된 년도 입력입니다! : " + checkYear);
			}
		} else {
			
			alert("입력양식에 맞지 않는 값입니다 다시 입력해주세요!\n입력값: " + updateBirthday);
			
		}
		
	}
	


</script>
</head>
<body>

	 <!-- 네비게이션 바 -->
    <nav class="navbar">
        <a class="navbar-brand" href="#">
            <img src="img/logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            My Look At 생년월일 변경
        </a>
    </nav>
    <h1>생년월일 변경</h1>

    <form name="form" >
        <label for="Birthday">새로운 생년월일 (기존 생년월일 : ${member.memberBirthday })</label>
        <input type="text" name="updateBirthday" id="updateBirthday" required placeholder="생년월일을 입력하세요 (양식 : 20240131 *하이폰제외)">
        
        <div class="button-container">
            <button type="button" onclick="update()">수정</button>
            <button type="button" class="home-btn" onclick="location.href='main/index.jsp'">홈으로 돌아가기</button>
            <a href="${pageContext.request.contextPath }/controller?command=myUpdatePage">
                <button type="button">뒤로가기</button>
            </a>
        </div>
    </form>
   

</body>
</html>