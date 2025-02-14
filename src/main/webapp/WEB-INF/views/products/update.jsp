<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/form.css">
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
		<section class="wrap contents">
			<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
			<div class="right contents_right">
			<!-- 내용기술 -->
				<div class="form_control">
					<form action="update.do" method="post">
						<fieldset>
							<legend>상품번호</legend>
							<input type="text" name="productNum" value="${dto.productNum}" readonly>
						</fieldset>
						<fieldset>
							<legend>상품이름</legend>
							<input type="text" name="productName" value="${dto.productName}">
						</fieldset>
						<fieldset>
							<legend>이자율</legend>
							<input type="text" name="productRate" value="${dto.productRate}">
						</fieldset>
						<fieldset>
							<legend>상품기간</legend>
							<input type="date" name="productDate" value="${dto.productDate}">
						</fieldset>
						<fieldset>
							<legend>상품설명</legend>
							<input type="text" name="productDetail" value="${dto.productDetail}">
						</fieldset>
						<fieldset>
							<button type="submit">수정</button>
						</fieldset>
					</form>
				</div>
			
			</div>
		</section>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>