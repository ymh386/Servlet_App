<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String c_id = request.getParameter("country_id");
	
	CountryDTO dto = new CountryDTO();
	dto.setCountry_id(c_id);
	
	CountryDAO dao = new CountryDAO();
	dto = dao.getDetail(dto);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>국가 정보 페이지</h1>

	<% if (dto != null) { %>
		<div>
			<h3>ID <%= dto.getCountry_id() %></h3>
			<h3>NAME <%= dto.getCountry_name() %></h3>
			<h3>REGION <%= dto.getRegion_id() %></h3>
		</div>
		
	<% } else { %>
		<div>
			<h3>없는 국가입니다.</h3>
		</div>	
	<% } %>
	
	<a href="./update.jsp?country_id=<%= dto.getCountry_id() %>">국가 수정</a>
	<a href="./deleteProcess.jsp?country_id=<%= dto.getCountry_id() %>">국가 삭제</a>
	
	
	
</body>
</html>