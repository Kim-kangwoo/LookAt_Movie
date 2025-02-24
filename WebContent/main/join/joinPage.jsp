<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입 │ 신나는 영화! LookAt</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/joinok.css">
</head>


<!-- 내가 추가한거 -->
<c:if test="${status eq 'null or empty' }">
	<script>
		alert("모든 항목을 입력해주세요.");
	</script>
</c:if>
<c:if test="${status eq 'join success' }">
	<script>
		if (confirm("회원가입이 완료되었습니다.\n로그인 페이지로 이동하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/controller?command=loginPage";
		}
		location.href = "main/index.jsp";
	</script>
</c:if>
<c:if test="${status eq 'join FAIL' }">
	<script>
		alert("회원가입 실패. 관리자에게 문의하세요....");
	</script>
</c:if>


<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
	
    <div class="container">
    	<c:if test="${userAge >=  18 }">
	        <h2>18세 이상 회원가입</h2>
    	</c:if>
    	<c:if test="${userAge < 18 }">
	        <h2>18세 미만 회원가입</h2>
    	</c:if>
        <form action="${pageContext.request.contextPath}/controller?command=join" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="logId">사용할 ID</label>
                <input type="text" id="logId" name="logId" placeholder="아이디를 입력하세요"  pattern="[a-zA-Z0-9]*" maxlength="18" title="영문자만 입력해주세요" required>
            </div>

			<div class="form-group">
                <label for="pw">비밀번호</label>
                <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요" pattern="[a-zA-Z0-9]*"  maxlength="18" required onkeyup="checkPasswordStrength()">
                <div id="password-strength" class="strength-indicator">
                    <span id="strength-text">비밀번호 강도: </span>
                    <div id="strength-bar" class="strength-bar"></div>
                </div>
            </div>

            <div class="form-group">
                <label for="confirmPw">비밀번호 확인</label>
                <input type="password" id="confirmPw" name="confirmPw" placeholder="비밀번호를 다시 입력하세요" pattern="[a-zA-Z0-9]*" maxlength="18"  maxlength="18"  required onkeyup="checkPasswordMatch()">
                <div id="pwError" class="error-message" style="display:none;">비밀번호가 일치하지 않습니다.</div>
            </div>       

            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" id="name" name="name"  value=${userName } readonly="readonly" >
            </div>

            <div class="form-group">
                <label for="nickname">닉네임</label>
                <input type="text" id="nickname" name="nickname" required>
                <button type="button" onclick="checkNickname()">닉네임 중복 확인</button>
                <div id="nicknameError" class="error-message" style="display:none;">이미 사용 중인 닉네임입니다.</div>
                <div id="nicknameAvailable" class="error-message" style="display:none;">사용 가능한 닉네임입니다!</div>
            </div>

            <div class="form-group">
                <label for="sex">성별</label>
                <select id="sex" name="sex" required>
                    <option value="M">남성</option>
                    <option value="F">여성</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="birthday">생년월일</label>
                <input type="date" id="birthday" name="birthday" value="${userBirthday}" readonly="readonly" >
            </div>
            
            <div class="form-group">
                <label for="age">나이</label>
                <input type="number" id="age" name="age" value=${userAge } readonly="readonly">
            </div>

            <div class="form-group">
                <label for="phoneNumber">핸드폰 번호</label>
                <input type="number" id="phoneNum" name="phoneNum" value="${userPhoneNum }" readonly="readonly"> 
            </div>

            <input type="submit" value="회원가입">
        </form>
    </div>
    
<script>

	//닉네임 입력 바이트 제한
	const inputField = document.getElementById('nickname');
	const maxBytes = 50;
	
	inputField.addEventListener('input', () => {
	    let value = inputField.value;
	
	    // 바이트 계산
	    let byteCount = 0;
	    let newValue = '';
	
	    for (let i = 0; i < value.length; i++) {
	        const char = value.charAt(i);
	        const charByte = new TextEncoder().encode(char).length; // UTF-8 바이트 계산
	        if (byteCount + charByte > maxBytes) break;
	        byteCount += charByte;
	        newValue += char;
	    }
	
	    // 입력값 제한 적용
	    inputField.value = newValue;

	});





	//닉네임 중복 여부 확인 
	function checkNickname() {
		var nickname = document.getElementById('nickname').value;
		
		if (!nickname.trim()) {
			alert('닉네임을 입력해주세요.');
			return;
		}
		
		 $.ajax({
			 url : `${pageContext.request.contextPath}/controller?command=nicknameDuplicateCheck`
			 , type : 'POST'
			 , data : {nickname : nickname}
			 , success : function(response) {
				 console.log(response);
				 
				 if (response.nickname === 'nickname available') {
					 alert('사용 가능한 닉네임입니다!');
					 document.getElementById('nicknameError').style.display = 'none';
					 document.getElementById('nicknameAvailable').style.display = 'block';
				 } else if (response.nickname === 'nickname duplicated') {
					 alert('이미 사용 중인 닉네임입니다. 다른 닉네임을 입력해주세요.');
					 document.getElementById('nicknameAvailable').style.display = 'none';
					 document.getElementById('nicknameError').style.display = 'block';
				 } else {
					 alert('알 수 없는 응답입니다.');
				 }
			 }
			 , error : function() {
				 alert('닉네임 중복 확인 중 오류 발생. 다시 시도해주세요.');
			 }
			 
		 });
		

	}
 
       //form 제출 전 비밀번호 일치여부 확인
      function validateForm() {
		var password = document.getElementById('pw').value;
		var confirmPassword = document.getElementById('confirmPw').value;
		
		if (password !== confirmPassword) {
			alert('비밀번호가 일치하지 않습니다. 다시 확인해주세요.');
			return flase; //폼 제출 중단
		}
		return true; //폼 제출 허용
       }
       
       
       //비밀번호 일치 여부 확인
       function checkPasswordMatch() {
    	   var password = document.getElementById('pw').value;
    	   var confirmPassword = document.getElementById('confirmPw').value;
    	   var pwError = document.getElementById('pwError');
    	   
    	   if (password === confirmPassword) {
    		   pwError.style.display = 'none';
    	   } else {
    		   pwError.style.display = 'block';
    	   }
       }
       
       
       //비밀번호 강도 확인 
	    function checkPasswordStrength() {
	        var password = document.getElementById('pw').value;
	        var strengthBar = document.getElementById('strength-bar');
	        var strengthText = document.getElementById('strength-text');
	        
	        // 기본 강도 값
	        var strength = 0;
	        
	        // 비밀번호 조건 체크
	        var hasNumber = /\d/; // 숫자
	        var hasLowerCase = /[a-z]/; // 소문자
	        var hasUpperCase = /[A-Z]/; // 대문자
	        var isLengthValid = password.length >= 6; // 길이 6자 이상
	        
	        // 강도 평가
	        if (hasNumber.test(password)) strength++;
	        if (hasLowerCase.test(password)) strength++;
	        if (hasUpperCase.test(password)) strength++;
	        if (isLengthValid) strength++;
	
	        // 강도에 따른 시각적 표시
	        if (strength === 1) {
	            strengthBar.className = "strength-bar low"; // low 클래스 추가
	            strengthText.textContent = "비밀번호 강도: 낮음";
	            strengthBar.style.width = "25%"; // 강도 낮을 때 25%
	        } else if (strength === 2 || strength === 3) {
	            strengthBar.className = "strength-bar medium"; // medium 클래스 추가
	            strengthText.textContent = "비밀번호 강도: 적당함";
	            strengthBar.style.width = "50%"; // 강도 중간일 때 50%
	        } else if (strength === 4) {
	            strengthBar.className = "strength-bar high"; // high 클래스 추가
	            strengthText.textContent = "비밀번호 강도: 어려움";
	            strengthBar.style.width = "100%"; // 강도 높을 때 100%
	        } else {
	            strengthBar.className = "strength-bar"; // 아무것도 입력되지 않았을 때 초기화
	            strengthText.textContent = "비밀번호 강도: ";
	            strengthBar.style.width = "0%"; // 아무것도 입력되지 않았을 때 0%
	        }
	    }
</script>
    



    
    
    
    
    

</body>
</html>