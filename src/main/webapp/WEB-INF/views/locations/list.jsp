<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="wrap_left contents">
		<c:import url="../template/nav.jsp"></c:import>
		<div class="right contents_right">
			<div class="contents_right_list">
				<table class="table_sprite">
					<thead>
						<tr>
							<th>지역번호</th>
							<th>지역명</th>
						</tr>
					</thead>
					<tbody>
	
						<c:forEach items="${list}" var="l">
						<tr>
							<td>${l.location_id }</td>
							<td><a
								href="./detail.do?location_id=${l.location_id }">${l.city }</a>
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
			<div>
				<a href="add.do">지역등록</a>
			</div>


		</div>

	</section>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>