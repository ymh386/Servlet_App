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
								<th>계좌번호</th>
								<th>상품번호</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="a" varStatus="st">
								<tr>
									<td><a href="./detail.do?accountNum=${a.accountNum}">${pageScope.a.accountNum}</a></td>
									<td>${a.productNum}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>