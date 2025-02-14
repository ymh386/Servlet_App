<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
		<section class="wrap contents">
			<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
			<div class="right contents_right">
			<!-- 내용기술 -->
				<div class="contents_right_list">
					<table class="table_sprite">
						<thead>
							<tr>
								<th>상품번호</th>
								<th>상품이름</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="p" varStatus="st">
								<tr>
									<td>${pageScope.p.productNum}</td>
									<td><a href="./detail.do?productNum=${p.productNum}">${p.productName}	</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<a href="./add.do">상품등록</a>
			</div>
		</section>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>