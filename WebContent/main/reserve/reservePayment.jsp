<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 | Look at Movie</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reserve/reservePayment.css">

<script>
	const selectSeatId = "${selectSeatId}" // 전 단계에서 선택한 좌석
    let cardName; // 선택한 카드사
    let phoneNumber; // 선택한 폰 넘버
    let simplePayment; // 선택한 간편비밀번호 //Ajax 구현으로??
    let couponSelect; // 선택한 쿠폰
   	let couponValue; // 선택한 쿠폰ID
   	let discount = parseInt(0); // 총 할인 가격
   	let discountContent = " "; // 총 할인 내역
   	let couponCheck = parseInt(0); // 쿠폰 사용확인
   	let pointCheck = parseInt(0); // 포인트 사용확인
    
    let leftPoint; // 사용 후 포인트
    let usePointValue; // 사용할 포인트
    const existPoint = "${membership.membershipPoint }"; // 기존 포인트
    let point = 0; // 기존포인트 파싱 전 기본값
    if(existPoint != undefined){
    	point = parseInt(existPoint);
    }
    const totalPrice = ${totalPrice }; // 결제할 금액 (변하면 X)
    let leftTotalPrice; // 포인트,쿠폰 등이 적용된 결제할 금액
    let radioValue; // 결제방식 선택값 (결제하기 누를 때 제한조건 가능)
	
    // 결제 수단 선택 로직
    function choosePayment(event) {
        radioValue = event.target.value; 
        let phoneClasses = document.querySelectorAll('.phonePay');
        let simpleClasses = document.querySelectorAll('.simple');
        let creditCardClasses = document.querySelectorAll('.creditCard');
        let paymentResult = document.getElementById('paymentResult');
        
        switch (radioValue) {
        
        case 'card':
            for (let creditCard of creditCardClasses){
                creditCard.disabled = false;
            }
            for (let phone of phoneClasses){
                phone.disabled = true;
            }
            for (let simple of simpleClasses){
                simple.disabled = true;
            }
            paymentResult.innerText = '결제종류 : 신용카드';
            break;
            
        case 'phone':
            for (let creditCard of creditCardClasses){
                creditCard.disabled = true;
            }
            for (let phone of phoneClasses){
                phone.disabled = false;
            }
            for (let simple of simpleClasses){
                simple.disabled = true;
            }
            paymentResult.innerText = '결제종류 : 휴대폰';
            break;
            
        case 'simple':
            for (let creditCard of creditCardClasses){
                creditCard.disabled = true;
            }
            for (let phone of phoneClasses){
                phone.disabled = true;
            }
            for (let simple of simpleClasses){
                simple.disabled = false;
            }
            paymentResult.innerText = '결제종류 : 간편결제';
            break;
        }
    }
	
    // 결제 종류에 선택한 카드 종류 추가
    function chooseCard() {
        const creditCardId = document.getElementById('creditCard');
        cardName = creditCardId.options[creditCardId.selectedIndex].text;
        paymentResult.innerText = '결제종류 : 신용카드 (' + cardName + ')';
    }
	
    // 포인트 사용하기
    function usePoint() {
    	
    	// 중복사용 확인
    	if (pointCheck == 0){
    		
	    	// 입력받은 포인트
	        usePointValue = document.getElementById('inputPoint').value;
	    	
	    	// 입력받은 포인트 입력값 확인
	        if(usePointValue != "") {
	        	
	        	// 기존 포인트 보다 작고 총 가격보다 작은 경우 사용
	            if (point >= usePointValue && usePointValue <= totalPrice){
	            	
	            	// 쿠폰 사용 안한 경우
	            	if (discount == 0){
	            		
	            		 leftTotalPrice = totalPrice - usePointValue;
	                     discount = discount + parseInt(usePointValue);
	                     discountContent = discountContent + usePointValue + "P";
	                     document.getElementById('discount').innerText = "할인 내역 :" + discountContent;
	                     document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
	                     document.getElementById('totalDiscount').innerText = "총 할인 내역 : " + discount;
	                     pointCheck++;
	            	
	            	} else {
	            		
	            		// 쿠폰 사용한 경우 적용된 금액에서 포인트 차감
	            		if(point >= usePointValue && usePointValue <= leftTotalPrice && usePointValue != 0){
	            			
	            			leftTotalPrice = leftTotalPrice - usePointValue;
	                        discount = parseInt(discount) + parseInt(usePointValue);
	                        discountContent = discountContent + " " + usePointValue + "P";
	                        document.getElementById('discount').innerText = "할인 내역 :" + discountContent;
	                        document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
	                        document.getElementById('totalDiscount').innerText = "총 할인 내역 : " + discount;
	                        pointCheck++;
	            			
	            		} else {
	                        alert("입력하신 포인트 보다 보유하신 포인트가 부족하거나 입력범위에 맞지 않습니다.");
	                    }
	            		
	            	}
	            } else {
	                alert("입력하신 포인트 보다 보유하신 포인트가 부족하거나 입력범위에 맞지 않습니다.");
	            }
	        } else {
	            alert("사용하실 포인트를 입력해주세요 !");
	        }
    	
    	} else {
    		
    		alert("중복해서 사용하실 수 없습니다 할인 취소 후 다시 이용해주세요!");
    	}
    	
    	
    }
	
    // 포인트 사용 시 남은 포인트 자동 계산
    function calculatorPrintPoint() {
    	
        let inputPoint = document.getElementById('inputPoint').value;
        let printLeftPoint = point - inputPoint;
        
        if (printLeftPoint >= 0){
            document.getElementById('leftPoint').innerText =  printLeftPoint;    
        } else {
            alert("올바르지 않은 값입니다!");
        }
    }
	
    
    // 쿠폰 사용
    function useCoupon() {
    	
    	
    	// 최종 결제에서 확인해야 되니까 넘기자
    	const couponSelectId = document.getElementById('couponSelect');
    	couponSelect = couponSelectId.options[couponSelectId.selectedIndex].text;
    	couponValue = couponSelectId.options[couponSelectId.selectedIndex].value;
    	
    	
    	// 중복사용 확인
    	if (couponCheck == 0) {
    	
	    	// 선택값에 따른 가격 적용 
	    	switch(couponValue){
	    	
	    	// 관람권(value : 2) 좌석 가격 14,000원 차감
	    	case '2':
	    		
	    		// 포인트 사용 안한 경우
	        	if (discount == 0){
	    		
		    	    leftTotalPrice = totalPrice - 14000; // 포인트,쿠폰 등이 적용된 결제할 금액
		    	    discount = discount + 14000;
		    		discountContent = discountContent + couponSelect;
		            document.getElementById('discount').innerText = "할인 내역 :" + discountContent;
		            document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
		            document.getElementById('totalDiscount').innerText = "총 할인 내역 : " + discount;
		            couponCheck++;
	            
	        	} else {
	        		
		    	    leftTotalPrice = leftTotalPrice - 14000; // 포인트,쿠폰 등이 적용된 결제할 금액
		    	    discount = parseInt(discount) + 14000;
		    		discountContent = discountContent + " " + couponSelect;
		            document.getElementById('discount').innerText = "할인 내역 :" + discountContent;
		            document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
		            document.getElementById('totalDiscount').innerText = "총 할인 내역 : " + discount;
		            couponCheck++;
	        		
	        	}
	    	    
	    		break;
	    	
	    	// 생일쿠폰(value : 3) 좌석 가격 14,000원 차감
	    	case '3':
	    		
	    		// 포인트 사용 안한 경우
	        	if (discount == 0){
	    		
		    	    leftTotalPrice = totalPrice - 14000; // 포인트,쿠폰 등이 적용된 결제할 금액
		    	    discount = discount + 14000;
		    		discountContent = discountContent + couponSelect;
		            document.getElementById('discount').innerText = "할인 내역 :" + discountContent;
		            document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
		            document.getElementById('totalDiscount').innerText = "총 할인 내역 : " + discount;
		            couponCheck++;
	            
	        	} else {
	        		
		    	    leftTotalPrice = leftTotalPrice - 14000; // 포인트,쿠폰 등이 적용된 결제할 금액
		    	    discount = parseInt(discount) + 14000;
		    		discountContent = discountContent + " " + couponSelect;
		            document.getElementById('discount').innerText = "할인 내역 :" + discountContent;
		            document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
		            document.getElementById('totalDiscount').innerText = "총 할인 내역 : " + discount;
		            couponCheck++;
	        		
	        	}
	            
	    		break;
	    		
	    	// 10%할인(value : 4) 전체 좌석 가격에서 10%할인 적용 차감	
	    	case '4':
	    		
	    		
	    		// 포인트 사용 안한 경우
	        	if (discount == 0){
	    		
	        		leftTotalPrice = totalPrice - (totalPrice / 10); // 포인트,쿠폰 등이 적용된 결제할 금액
	        		discount = discount + (totalPrice / 10);
	        		discountContent = discountContent  + couponSelect;
	        		document.getElementById('discount').innerText = "할인 내역 : " + discountContent;
	                document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
	                document.getElementById('totalDiscount').innerText = "총 할인 내역 : " + discount;
	                couponCheck++;
	            
	        	} else {
	        		
	        		leftTotalPrice = leftTotalPrice - (leftTotalPrice / 10); // 포인트,쿠폰 등이 적용된 결제할 금액
	        		discount = parseInt(discount) + (totalPrice / 10);
	        		discountContent = discountContent + " " + couponSelect;
	        		document.getElementById('discount').innerText = "할인 내역 : " + discountContent;
	                document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
	                document.getElementById('totalDiscount').innerText = "총 할인 내역 : " + discount;
	                couponCheck++;
	        		
	        	}
	            
	            break;
	    	}
    	
    	} else {
    		
    		alert("중복해서 사용하실 수 없습니다 할인 취소 후 다시 이용해주세요!");
    	}
    	
	}
    
    // 휴대폰 결제
    function choosePhone() {
		
    	let phonePay = document.getElementById('phonePay').value;
    	console.log("[TEST] phonePay : " + phonePay);
    		
   		// 핸드폰번호 양식 정규식
   		const cellPhone = /^(?:(010)|(01[1|6|7|8|9]))(\d{3,4})(\d{4})$/;
   		if (cellPhone.test(phonePay)){
   			
   			// 고객 휴대폰 번호 비교
   			let customPhone = "${member.memberPhonenum}";
   			if (customPhone != phonePay){
   				alert("핸드폰번호가 맞지 않습니다!");
   			} 
   			
   		} else {
   			alert("입력양식에 알맞지 않은 값입니다!");
   		}
	}
    
    
    // 포인트 & 쿠폰 리셋
    function resetPointCoupon() {
    	
    	// 대입 값 전부 리셋
        leftTotalPrice = totalPrice;
        usePointValue = parseInt(0);
        discount = parseInt(0);
        discountContent = " ";
    	couponCheck = parseInt(0);
       	pointCheck = parseInt(0);
       	document.getElementById('inputPoint').value = null;
       	document.getElementById('leftPoint').innerText = point;
       	
        document.getElementById('discount').innerText = "할인 내역 : ";
        document.getElementById('leftTotalResult').innerText = "남은 결제 금액 : " + leftTotalPrice;
        document.getElementById('totalDiscount').innerText = "총 할인 내역 : ";
    }
	
    
    // 결제 페이지로 전환
    function moveToCompleteReserve() {
    	
    	alert("[공지사항]\n포인트 또는 쿠폰을 사용한 결제는 \n결제취소 후 복구가 안되는 점 알려드립니다. ");
    	
    	// 결제수단 선택 검증
    	if ((cardName == undefined) && (phoneNumber == undefined) && (simplePayment == undefined)){
    		// 결제 수단 미 선택 시
	    	alert("결제 수단을 선택해주세요!");
    		
    	} else {
    		// 카드이름 || 폰번호 || 간편비밀번호 중 하나라도 선택했을 때 넘어가기
    		if(leftTotalPrice == undefined){
    			leftTotalPrice = totalPrice;
    		}
    
			// 결제 시 필요한 파라미터 전달
    		location.href = '${pageContext.request.contextPath }/controller?command=reserveCompleteCheck&radioValue=' + radioValue + '&leftTotalPrice=' + leftTotalPrice + '&usePointValue=' + usePointValue + '&couponValue=' + couponValue + '&discountContent=' + discountContent;
        	
    	}
    	
        
    }
    

    
</script>

</head>
<body>
    <div class="container">
        <h1>결제 페이지</h1>
        <div class="payment-options">
            <label><input type="radio" name="payment" value="card" onclick="choosePayment(event)" />신용카드</label>
            <label><input type="radio" name="payment" value="phone" onclick="choosePayment(event)" />휴대폰 결제</label>
            <label><input type="radio" name="payment" value="simple" onclick="choosePayment(event)" />간편결제</label>
        </div>
        
        <div class="section">
            <span>카드 종류</span>
            <select class="creditCard" id="creditCard" disabled="disabled">
                <option value="shinhan">신한카드</option>
                <option value="kokmin">국민카드</option>
                <option value="hana">하나카드</option>
                <option value="ibk">IBK카드</option>
            </select>
            <input type="button" class="creditCard" onclick="chooseCard()" value="선택" disabled="disabled">
        </div>

        <div class="section">
            <span>휴대폰 결제</span> <span style="color: rgba(0, 0, 0, 0.4)">* 입력형식 (01012349876) </span>
            <input type="number" class="phonePay" id="phonePay" name="phonePay" disabled="disabled">
            <input type="button" class="phonePay" onclick="choosePhone()" value="입력">
	
		<hr>
	
	        <div class="section">
                <span>간편 결제</span> <span style="color: rgba(0, 0, 0, 0.4);">* 입력형식 (456789) </span>
                <input type="number" class="simple" name="simple" placeholder="간편비밀번호 6자리" disabled="disabled">
                <input type="button" class="simple"  value="입력" disabled="disabled">
                
            </div>

			<div class="section">
                <span>쿠폰 사용</span>
                <select class="couponSelect" id="couponSelect">
                	<c:forEach var="coupon" items="${couponList }">
		                <option value="${coupon.couponId }">${coupon.couponType }</option>
		            </c:forEach>
            	</select>
                <input type="button" onclick="useCoupon()" value="사용">
            </div>

            <div class="section">
                <span>멤버쉽 포인트 사용</span>
                <input type="number" id="inputPoint" onkeyup="calculatorPrintPoint()" placeholder="포인트 입력">
                <input type="button" onclick="usePoint()" value="사용">
                <span style="width: 150px; display: inline;">사용 가능한 포인트: </span>
                <span id="leftPoint" style="width: 80px; display: inline;">${membership.membershipPoint} </span>
                <span style="display: inline;"> P </span>
            </div>

            <hr>

            <div class="total-section">
                <div>결제하실 금액 : ${totalPrice}</div>
                <div id="discount">할인 내역 : </div>
                <div id="totalDiscount" >총 할인 내역 : </div>
                <input type="button" onclick="resetPointCoupon()" value="할인취소">
            </div>

            <hr>

            <div class="payment-result">
                <div>결제내역</div>
                <div id="paymentResult">결제 종류 : </div>
                <div id="leftTotalResult">남은 결제 금액 : ${totalPrice}</div>
            </div>

            <hr>

            <div class="buttons-container">
                <div class="confirm" onclick="moveToCompleteReserve()">결제하기</div>
                <div class="cancel" onclick="location.href='${pageContext.request.contextPath }/controller?command=reserveSeat'">취소</div>
            </div>
        </div>
    </div>

</body>
</html>
