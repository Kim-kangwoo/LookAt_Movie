<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 페이지</title>
<!-- 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/memberchkpage.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <%@ include file="/main/header.jspf"%>
    <%@ include file="/main/nav.jspf"%>

    <h3 class="page-title">회원 관리 페이지</h3>

    <div class="container">
        <!-- 왼쪽 컨테이너 (그래프 + 전체/남/여 인원수 테이블) -->
        <div class="left-container">
            <div class="chart-container">
                <canvas id="memberChart"
                    style="max-width: 400px; height: 400px; margin: 0 auto;"></canvas>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels"></script>

            <script>
                const ctx = document.getElementById('memberChart').getContext('2d');
                const memberChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: ['여성', '남성'],
                        datasets: [{
                            label: '회원 성별 분포',
                            data: [${memberFemaleCount}, ${memberMaleCount}],
                            backgroundColor: ['#ff66b2', '#000000'],
                            borderColor: ['#ffffff', '#ffffff'],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: true,
                        plugins: {
                            datalabels: {
                                display: true,
                                color: '#ffffff',
                                font: { size: 18, weight: 'bold' },
                                formatter: (value) => value + '명',
                                alignment: 'center',
                                anchor: 'center'
                            },
                            legend: { position: 'top' },
                            tooltip: {
                                callbacks: {
                                    label: (tooltipItem) => tooltipItem.label + ': ' + tooltipItem.raw + '명'
                                }
                            }
                        }
                    }
                });
            </script>

            <!-- 전체/남/여 인원수 테이블 -->
            <div class="member-table">
                <table>
                    <thead>
                        <tr>
                            <th>전체 회원</th>
                            <th>여성</th>
                            <th>남성</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${totalMemberCount}명</td>
                            <td>${memberFemaleCount}명</td>
                            <td>${memberMaleCount}명</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            
            <div class="left-container-button">
                <!-- 전체 회원 상세 정보 보기 버튼 (링크) -->
                <a href="${pageContext.request.contextPath }/controller?command=MA_memberListPage">전체
                    회원 상세 정보 보기</a>
            </div>
            
        </div>

        <!-- 오른쪽 컨테이너 (검색창 + 상세보기 버튼 + 회원 목록 테이블) -->
        <div class="right-container">
            <!-- 회원 조회 폼 -->
            <h2>회원 조회하기</h2>
            <form id="searchMemberForm"
                action="${pageContext.request.contextPath }/controller?command=MA_memberSearch"
                method="post" class="search-form">
                <div class="input-group">
                    <label for="searchMemName">이름:</label> <input type="text"
                        id="searchMemName" name="searchMemName" placeholder="검색할 회원의 이름"
                        required>
                </div>

                <div class="input-group">
                    <label for="searchMemBirthday">생년월일:</label> <input type="date"
                        id="searchMemBirthday" name="searchMemBirthday" min="1900-01-01"
                        max="2024-12-31" required>
                </div>

                <div class="input-group">
                    <label for="searchMemPhonenum">전화번호:</label> <input type="text"
                        id="searchMemPhonenum" name="searchMemPhonenum"
                        placeholder="'-'제외 숫자만 입력" pattern="^[0-9]{11}$" maxlength="11"
                        title="숫자만 입력해주세요." required>
                </div>

                <div class="right-container-button">
                    <!-- 검색 버튼 -->
                    <input type="submit" value="검색">
                </div>

            </form>

            <!-- 회원 목록 테이블 -->
            <c:if test="${foundMemberList != null && !foundMemberList.isEmpty() }">
                <table class="member-list-table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>이름</th>
                            <th>성별</th>
                            <th>나이</th>
                            <th>별명</th>
                            <th>생년월일</th>
                            <th>아이디</th>
                            <!-- <th>비밀번호</th> -->
                            <th>전화번호</th>
                            <th>누적 포인트</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="mem" items="${foundMemberList }"
                            varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${mem.memberName}</td>
                                <td>${mem.memberSex}</td>
                                <td>${mem.memberAge}</td>
                                <td>${mem.memberNickname}</td>
                                <td>${mem.memberBirthday}</td>
                                <td>${mem.memberLogid}</td>
                               <%--  <td>${mem.memberPassword}</td> --%>
                                <td>${mem.memberPhonenum}</td>
                                <td>${mem.membershipPoint}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${foundMemberList != null && foundMemberList.isEmpty() }">
                <table class="member-list-table">
                    <thead>
                        <tr>
                            <th>Index</th>
                            <th>이름</th>
                            <th>성별</th>
                            <th>나이</th>
                            <th>별명</th>
                            <th>생년월일</th>
                            <th>아이디</th>
                            <th>비밀번호</th>
                            <th>전화번호</th>
                            <th>누적 포인트</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td colspan="10">조회된 회원이 없습니다.</td>
                        </tr>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</body>
</html>
