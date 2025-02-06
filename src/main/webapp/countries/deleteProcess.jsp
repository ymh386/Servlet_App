<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("country_id");
	CountryDTO countryDTO = new CountryDTO();
	countryDTO.setCountry_id(id);
	
	CountryDAO countryDAO = new CountryDAO();
	int result = countryDAO.delete(countryDTO);
	
	String r = "국가 삭제 실패";
	
	if(result>0) {
		r = "국가 삭제 성공";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%= r %></h3>
	<a href="/">Home</a>
	<a href="./list.jsp">List</a>
</body>
</html>