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
	<h1>국가 정보 수정 페이지</h1>
	
	<form action="./updateProcess.jsp" method="post">
		<input type="hidden" name="country_id" value="<%= dto.getCountry_id() %>">
		<input type="text" name="country_name" value="<%= dto.getCountry_name() %>">
		<input type="text" name="region_id" value="<%= dto.getRegion_id() %>">
		
		<button type="submit">수정하기</button>
	
	</form>
	
	
	
	

</body>
</html>