<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인 | Look at Movie</title>
<!-- 외부 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/passwordCheck.css">
<script>
	
	
	let check = "${check}"; //서버에서 넘어온 불린
	let password; // 서버에 보낼 비밀번호
	
	// 1. 돌려 받은 불린 값에 따라 회원관리 페이지 이동
	if (check == "false") {
		
		// false 재차 확인
		alert("비밀번호가 알맞지 않습니다! 다시 시도해주세요");
	}
	
	
	// 비밀번호 두번 다 맞게 입력했는지 먼저 확인
	function pwdInputCheck() {
		
		password = document.getElementById('password').value;
		let passwordCheck = document.getElementById('passwordCheck').value;
		
		// 비밀번호 입력없이 제출 했을때 방지
		if (password != "" && passwordCheck != "") {
		
			if (password == passwordCheck){
				
				// 비밀번호 서버로 보내서 검증
				const button = document.getElementById('passwordButton');
				button.type = "submit"
				
			} else {
				
				// 값 초기화 & 입력창으로 focus
				document.getElementById('password').value = null;
				document.getElementById('passwordCheck').value = null;
				document.getElementById('password').focus();
				 
				alert("비밀번호와 비밀번호 확인이 같지 않습니다. \n다시 입력해주세요");
				
			}
			
		} else {
			
			document.getElementById('password').focus();
			alert("비밀번호와 비밀번호 확인을 입력해주세요! ");
		}
	}

</script>
</head>
<body>
	
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
	
	<h3 class="page-title">MY LOOK AT 비밀번호 확인</h3>
	<br>
	<br>
	
	<div class="password">
		
		<div class="password_content">
			<form action="${pageContext.request.contextPath }/controller?command=myLookatPwdCheck" method="post">
				<div class="password_content_password">
					<span>비밀번호</span>
					<input type="password" id="password" name="password" placeholder="비밀번호 입력">
				</div>
				<div class="password_content_password">
					<span>비밀번호 확인</span>
					<input type="password" id="passwordCheck" name="passwordcheck" placeholder="비밀번호 입력 확인">
					<input type="button" id="passwordButton" onclick="pwdInputCheck()" value="확인">
				</div>
			</form>
		</div>
		
			
		<!-- 푸터 -->
		<div class="footer">
			<p>&copy; 2024 LookAt. All rights reserved.</p>
		</div>
	</div>
</body>
</html>