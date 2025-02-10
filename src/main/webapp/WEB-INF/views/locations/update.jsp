<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LocationDTO locationDTO = (LocationDTO)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/common.jsp"%>
</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
	<%@ include file="../template/header.jsp"%>

	<section class="contents wrap_left">
		<div class="left contents_left">
			
			<%@ include file="../template/nav.jsp" %>
			
		</div>
		<div class="right contents_right">
		
			<h1>Update Form</h1>
	
			<form action="./update.do" method="post">
			
				<fieldset>
					<legend>지역 주소</legend>
					<input type="text" name="department_name" value="<%= locationDTO.getStreet_address() %>">

				</fieldset>
				<fieldset>
					<legend>우편번호</legend>
					<input type="text" name="postal_code" value="<%= locationDTO.getPostal_code() %>">

				</fieldset>
				<fieldset>
					<legend>도시</legend>
					<input type="text" name="city" value="<%= locationDTO.getCity() %>">

				</fieldset>
				<fieldset>
					<legend>State Province</legend>
					<input type="text" name="state_province" value="<%= locationDTO.getState_province() %>">

				</fieldset>
				<fieldset>
					<legend>국가번호</legend>
					<input type="text" name="country_id" value="<%= locationDTO.getCountry_id() %>">

				</fieldset>
				<fieldset>
					<input type="hidden" name="location_id" value="<%= locationDTO.getLocation_id() %>">

				</fieldset>
			
				<fieldset>
					<button type="submit">수정하기</button>
				</fieldset>
				
				
			</form>
		
		</div>
	</section>

	<%@ include file="../template/footer.jsp"%>
</body>
</html>