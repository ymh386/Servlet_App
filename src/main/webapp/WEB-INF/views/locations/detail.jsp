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
		
			<h3><a href="./list.do">홈으로 가기</a></h3>
	
			<h1>Location tail Page</h1>
			
			<% if(locationDTO != null) { %>
				<h3><%= locationDTO.getLocation_id() %></h3>
				<h3><%= locationDTO.getStreet_address() %></h3>
				<h3><%= locationDTO.getPostal_code() %></h3>
				<h3><%= locationDTO.getCity() %></h3>
				<h3><%= locationDTO.getState_province() %></h3>
				<h3><%= locationDTO.getCountry_id() %></h3>
				
				<a href="./delete.do?location_id=<%= locationDTO.getLocation_id() %>">지역 삭제</a>
				<a href="./update.do?location_id=<%= locationDTO.getLocation_id() %>">지역 수정</a>
				
			<% } else { %>
				<h3>없는 지역입니다.</h3>
				
			<% } %>
		
		</div>
	</section>

	<%@ include file="../template/footer.jsp"%>
</body>
</html>