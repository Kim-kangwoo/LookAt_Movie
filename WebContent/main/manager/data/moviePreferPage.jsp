<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영화별 예매 통계</title>
    <!-- 외부 스타일 시트 연결 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/moviepreferpage.css">
    <!-- Chart.js 라이브러리 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <%@ include file="/main/header.jspf"%>
    <%@ include file="/main/nav.jspf"%>
    
    
    <div class="statistics-container">
        <h1 class="movie-title">${movieName} 예매 통계</h1>
        <h3 class="statistics-title">성별에 따른 예매율</h3>

<!-- 성별 예매율 표 -->
        <div class="table-container">
            <table class="gender-stats-table">
                <thead>
                    <tr>
                        <th>남</th>
                        <th>여</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${malePercentage == 0.0 && femalePercentage == 0.0}">
                            <tr>
                                <td colspan="2">집계된 데이터가 없습니다.</td>
                            </tr>
                        </c:when>
                        <c:when test="${malePercentage == 0.0}">
                            <tr>
                                <td>집계된 데이터가 없습니다.</td>
                                <td>${femalePercentage}</td>
                            </tr>
                        </c:when>
                        <c:when test="${femalePercentage == 0.0}">
                            <tr>
                                <td>${malePercentage}</td>
                                <td>집계된 데이터가 없습니다.</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td>${malePercentage}</td>
                                <td>${femalePercentage}</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>

        <!-- 성별 예매율 그래프 -->
        <div class="chart-container">
            <canvas id="genderChart"></canvas>
        </div>
    </div>

    <script>
        // Chart.js로 그래프 생성
        const malePercentage = ${malePercentage};
        const femalePercentage = ${femalePercentage};

        const ctx = document.getElementById('genderChart').getContext('2d');
        new Chart(ctx, {
            type: 'pie',
            data: {
                labels: ['남', '여'],
                datasets: [{
                    data: [malePercentage, femalePercentage],
                    backgroundColor: ['#4A90E2', '#F47373'],
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    tooltip: {
                        callbacks: {
                            label: function (context) {
                                return `${context.label}: ${context.raw}%`;
                            }
                        }
                    }
                }
            }
        });
    </script>

	
	
</body>
</html>