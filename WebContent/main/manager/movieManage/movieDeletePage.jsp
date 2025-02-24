<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신나는 영화! LookAt</title>
<!-- 외부 스타일 시트 연결 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/moviedeletepage.css">
<head>
<title>영화 삭제</title>
</head>
<body>
	<%@ include file="/main/header.jspf"%>
	<%@ include file="/main/nav.jspf"%>

	<h3>영화 삭제 페이지</h3>

	<form id="deleteForm"
		action="${pageContext.request.contextPath }/controller?command=MA_movieDelete"
		method="post">
		<table id="movieTable" class="movie-delete-table">
			<thead>
				<tr>
					<th>번호</th>
					<th>영화 제목</th>
					<th>감독 이름</th>
					<th>선택</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="movieList" items="${movieList }" varStatus="status">
					<tr>
						<td class="movie-delete-number">${status.count}</td>
						<!-- 번호 매기기 -->
						<td class="movie-delete-title">${movieList.movieName }</td>
						<td class="movie-delete-director">${movieList.movieDirector }
						</td>
						<td class="movie-delete-checkbox"><input type="checkbox"
							name="deleteMovie" value="${movieList.movieId }"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="movie-delete-button-container">
			<button class="movie-delete-button" onclick="deleteAlert()">삭제하기</button>
		</div>
	</form>

	<script>
		function deleteAlert() {

			//체크된 항목 있는지 확인
			var checkboxes = document.getElementsByName("deleteMovie");
			var isChecked = false;

			for (var i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].checked) {
					isChecked = true;
					break;
				}
			}

			if (!isChecked) {
				alert("선택된 항목이 없습니다.");
				location.href = "${pageContext.request.contextPath }/controller?command=MA_movieDeletePage";
				return;
			}

			if (confirm("선택하신 영화를 삭제하시겠습니까?")) {
				document.getElementById("deleteForm").submit();
			} else {
				location.href = "${pageContext.request.contextPath }/controller?command=MA_movieDeletePage";
			}
		}
	</script>



</body>
</html>