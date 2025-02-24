<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>My Look At 고객센터</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/serviceceter/serviceCeter.css">
</head>
<body>
<%@ include file="/main/header.jspf" %>

<div class="container mt-4">
  <h1>My Look At 고객센터</h1>
  <h3>무엇을 도와드릴까요?</h3>
  
  <!-- 검색 기능 -->
  <div class="search-bar">
    <form class="d-flex">
      <input class="form-control me-2" type="search" placeholder="검색하세요" aria-label="Search">
      <button class="btn btn-outline-dark" type="submit">검색</button>
    </form>
  </div>
  
  <!-- 버튼들 -->
  <div class="buttons">
    <button class="btn-toggle" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFAQ" aria-expanded="false" aria-controls="collapseFAQ">
      자주 묻는 질문
    </button>
    <button class="btn-toggle" type="button" data-bs-toggle="collapse" data-bs-target="#collapseUpdate" aria-expanded="false" aria-controls="collapseUpdate">
      영화 정보 수정/추가요청
    </button>
    <button class="btn-toggle" type="button" data-bs-toggle="collapse" data-bs-target="#collapseMembership" aria-expanded="false" aria-controls="collapseMembership">
      멤버십 질문
    </button>
    <button class="btn-toggle" type="button" data-bs-toggle="collapse" data-bs-target="#collapseMovie" aria-expanded="false" aria-controls="collapseMovie">
      영화 질문
    </button>
    <button class="btn-toggle" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWithdraw" aria-expanded="false" aria-controls="collapseWithdraw">
      회원탈퇴 질문
    </button>
  </div>

  <!-- 자주 묻는 질문 아코디언 -->
  <div class="collapse" id="collapseFAQ">
    <div class="accordion">
      <!-- 예매 관련 아코디언 항목 -->
      <div class="accordion-item">
        <h2 class="accordion-header" id="headingBooking">
          <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseBooking" aria-expanded="true" aria-controls="collapseBooking">
            예매 관련
          </button>
        </h2>
        <div id="collapseBooking" class="accordion-collapse collapse" aria-labelledby="headingBooking" data-bs-parent="#collapseFAQ">
          <div class="accordion-body">
            <p>예매창을 클릭하고 원하는 영화를 선택한 뒤, 예매하기를 누르면 됩니다.</p>
          </div>
        </div>
      </div>
      <!-- 비밀번호 관련 아코디언 항목 -->
      <div class="accordion-item">
        <h2 class="accordion-header" id="headingPassword">
          <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapsePassword" aria-expanded="false" aria-controls="collapsePassword">
            비밀번호 관련
          </button>
        </h2>
        <div id="collapsePassword" class="accordion-collapse collapse" aria-labelledby="headingPassword" data-bs-parent="#collapseFAQ">
          <div class="accordion-body">
            <p>홈페이지 상단 로그인 버튼을 클릭하고, '아이디 찾기' 또는 '비밀번호 찾기'를 통해 재설정 가능합니다.</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- 영화 정보 수정/추가요청 -->
  <div class="collapse" id="collapseUpdate">
    <div class="accordion">
      <div class="accordion-item">
        <h3 class="accordion-header" id="headingUpdate">
          <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseUpdateContent" aria-expanded="false" aria-controls="collapseUpdateContent">
            영화 정보 수정/추가요청
          </button>
        </h3>
        <div id="collapseUpdateContent" class="accordion-collapse collapse" aria-labelledby="headingUpdate" data-bs-parent="#collapseUpdate">
          <div class="accordion-body">
            <p>영화 정보 페이지의 배우 및 제작진, 줄거리, 기타 정보 수정을 위해서는 저작권자(감독 또는 영화사)가 요청해 주셔야 합니다. 잘못된 정보가 있다면 아래 항목을 기입하여 보내주세요. 검토 후 답변을 드리겠습니다.</p>
            <ul>
              <li>인물 필모그래피 URL</li>
              <li>크레딧 정보: 파일 작성 후 첨부 (크레딧 예시 파일 다운로드)</li>
              <li>영화사의 경우 사업자 등록증, 배우 또는 스탭일 경우 참여사실확인서 및 계약서 첨부</li>
            </ul>
            <p>※ 참고해 주세요! 수정을 요청하신 영화의 저작권자가 아니라면 도움을 드릴 수 없습니다.</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- 멤버십 관련 -->
  <div class="collapse" id="collapseMembership">
    <div class="accordion">
      <div class="accordion-item">
        <h3 class="accordion-header" id="headingMembership">
          <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseMembershipContent" aria-expanded="false" aria-controls="collapseMembershipContent">
            멤버십 문의
          </button>
        </h3>
        <div id="collapseMembershipContent" class="accordion-collapse collapse" aria-labelledby="headingMembership" data-bs-parent="#collapseMembership">
          <div class="accordion-body">
            <p>LOOK AT MOVIE 멤버십은 2024년 12월에 출시한 구독형 서비스입니다.</p>
            <p>등급은 BRONZE, SILVER, GOLD로 분류됩니다.</p>
            <ul>
              <li>혜택 1: 멤버십 가입 시 생일자에게 쿠폰을 드립니다</li>
              <li>혜택 2: 포인트가 적립되어 결제시 포인트를 사용할 수 있습니다.</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- 영화 관련 -->
  <div class="collapse" id="collapseMovie">
    <div class="accordion">
      <div class="accordion-item">
        <h3 class="accordion-header" id="headingMovie">
          <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseMovieContent" aria-expanded="true" aria-controls="collapseMovieContent">
            영화 문의
          </button>
        </h3>
        <div id="collapseMovieContent" class="accordion-collapse collapse" aria-labelledby="headingMovie" data-bs-parent="#collapseMovie">
          <div class="accordion-body">
            <p>최대한 빠르게 업로드될 수 있도록 노력하겠습니다.</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- 탈퇴 관련 -->
  <div class="collapse" id="collapseWithdraw">
    <div class="accordion">
      <div class="accordion-item">
        <h3 class="accordion-header" id="headingWithdraw">
          <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWithdrawContent" aria-expanded="false" aria-controls="collapseWithdrawContent">
            회원탈퇴 문의
          </button>
        </h3>
        <div id="collapseWithdrawContent" class="accordion-collapse collapse" aria-labelledby="headingWithdraw" data-bs-parent="#collapseWithdraw">
          <div class="accordion-body">
            <p>회원 탈퇴는 회원 정보 페이지에서 가능합니다. 탈퇴 후 복구가 불가능하므로 신중하게 결정해주세요.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
