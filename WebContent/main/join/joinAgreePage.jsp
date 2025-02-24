<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이용약관 동의</title>
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/joinagree.css">
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>
    <div class="container">
        <h2>이용약관 동의</h2>

        <!-- 모두 동의 -->
        <div class="checkbox">
            <input type="checkbox" id="agreeAll">
            <label for="agreeAll"><strong>모두 동의합니다.</strong></label>
        </div>

        <!-- 약관 1 -->
        <div class="terms-container">
            <div class="terms-header" onclick="toggleTerms('terms1')">
                <h3>[LookAt 서비스 이용약관(필수)]</h3>
                <span class="toggle-icon">+</span>
            </div>
            <div class="terms-content" id="terms1">
                <p>우리 서비스 이용하려면 네가 잘해야함 이런 내용임.</p>
                <p>난 이 내용을 한 번도 읽어본 적이 없어.</p>
            </div>
            <div class="checkbox">
                <input type="checkbox" id="agreeTerms1">
                <label for="agreeTerms1">이용약관에 동의합니다.</label>
            </div>
        </div>

        <!-- 약관 2 -->
        <div class="terms-container">
            <div class="terms-header" onclick="toggleTerms('terms2')">
                <h3>[개인정보 수집 및 활용 동의(필수)]</h3>
                <span class="toggle-icon">+</span>
            </div>
            <div class="terms-content" id="terms2">
                <p>여기에 동의하시면 당신의 정보가 팔려나갑니다.</p>
                <p>하지만 동의 안하면 가입 안되죠?</p>
            </div>
            <div class="checkbox">
                <input type="checkbox" id="agreeTerms2">
                <label for="agreeTerms2">개인정보 처리방침에 동의합니다.</label>
            </div>
        </div>
        
        <!-- 약관 3 -->
        <div class="terms-container">
            <div class="terms-header" onclick="toggleTerms('terms3')">
                <h3>멤버십 및 마케팅을 위한 개인정보 수집 및 활용 동의(선택)</h3>
                <span class="toggle-icon">+</span>
            </div>
            <div class="terms-content" id="terms3">
                <p>함정을 파기 위한 선택메뉴</p>
                <p>조심하세요</p>
            </div>
            <div class="checkbox">
                <input type="checkbox" id="agreeTerms3">
                <label for="agreeTerms3">개인정보 수집에 동의합니다.</label>
            </div>
        </div>

        <!-- 버튼 -->
        <!-- 나중에 18세 미만 회원이 청불영화 예매 못하게 할라고 구분함. 기능은 모르겠어요 어려워요. -->
        <div class="buttons">
        <button id="btnJoinGo">회원가입 하기</button>
        <!-- 
            <button id="btnAbove18">18세 이상 가입</button>
            <button id="btnUnder18">18세 미만 가입</button>
         -->
        </div>
    </div>

    <script>
        // 아코디언 토글 기능
        // 이용약관이 너무 길어서 접었다 폈다 할 수 있습니다
        function toggleTerms(id) {
            const content = document.getElementById(id);
            const icon = content.previousElementSibling.querySelector('.toggle-icon');
            if (content.style.maxHeight) {
                content.style.maxHeight = null;
                icon.textContent = '+';
            } else {
                content.style.maxHeight = content.scrollHeight + "px";
                icon.textContent = '-';
            }
        }

        // 모두 동의 체크박스 동작
        const agreeAll = document.getElementById('agreeAll');
		const agreeTerms = document.querySelectorAll('.terms-container input[type="checkbox"]');
		
		agreeAll.addEventListener('change', () => {
		    agreeTerms.forEach(checkbox => checkbox.checked = agreeAll.checked);
		});
		
		agreeTerms.forEach(checkbox => {
		    checkbox.addEventListener('change', () => {
		        agreeAll.checked = [...agreeTerms].every(cb => cb.checked);
		    });
		});

		//회원가입 하기
		const btnJoinGo = document.getElementById('btnJoinGo');
		btnJoinGo.addEventListener('click', () => {
			 if (agreeTerms1.checked && agreeTerms2.checked) {
				window.location.href = `${pageContext.request.contextPath}/controller?command=joinPage`;
			 } else {
			        alert('모든 필수 약관에 동의해주세요.');
			    }
		});
		
        // 연령대별 버튼 동작
        /*
        const btnAbove18 = document.getElementById('btnAbove18'); 
		const btnUnder18 = document.getElementById('btnUnder18'); 
		
		btnAbove18.addEventListener('click', () => {
		    if (agreeTerms1.checked && agreeTerms2.checked) {
		        alert('18세 이상 회원가입 페이지로 이동합니다.');
		        window.location.href = `${pageContext.request.contextPath}/controller?command=joinPage&type=adult`;
		    } else {
		        alert('모든 필수 약관에 동의해주세요.');
		    }
		});
		
		btnUnder18.addEventListener('click', () => {
		    if (agreeTerms1.checked && agreeTerms2.checked) {
		        alert('18세 미만 회원가입 페이지로 이동합니다.');
		        window.location.href = `${pageContext.request.contextPath}/controller?command=joinPage&type=minor`;
		    } else {
		        alert('모든 필수 약관에 동의해주세요.');
		    }
		});
		*/
    </script>
</body>
</html>