<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common.jsp"></c:import>
</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
	<c:import url="../template/header.jsp"></c:import>

	<section class="contents wrap_left">
		<div class="left contents_left">
			
			<c:import url="../template/nav.jsp"></c:import>
			
		</div>
		<div class="right contents_right">
		
			<h1>Update Form</h1>
	
			<form action="./update.do" method="post">
			
				<fieldset>
					<legend>지역 주소</legend>
					<input type="text" name="department_name" value="${dto.street_address }">

				</fieldset>
				<fieldset>
					<legend>우편번호</legend>
					<input type="text" name="postal_code" value="${dto.postal_code }">

				</fieldset>
				<fieldset>
					<legend>도시</legend>
					<input type="text" name="city" value="${dto.city }">

				</fieldset>
				<fieldset>
					<legend>State Province</legend>
					<input type="text" name="state_province" value="${dto.state_province }">

				</fieldset>
				<fieldset>
					<legend>국가코드</legend>
					<input type="text" name="country_id" value="${dto.country_id }">

				</fieldset>
				<fieldset>
					<input type="hidden" name="location_id" value="${dto.location_id }">

				</fieldset>
			
				<fieldset>
					<button type="submit">수정하기</button>
				</fieldset>
				
				
			</form>
		
		</div>
	</section>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>