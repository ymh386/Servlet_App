<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String c_id = request.getParameter("country_id");
	String c_name = request.getParameter("country_name");
	String r_id = request.getParameter("region_id");
	
	CountryDTO dto = new CountryDTO();
	dto.setCountry_id(c_id);
	dto.setCountry_name(c_name);
	dto.setRegion_id(Integer.parseInt(r_id));
	
	CountryDAO dao = new CountryDAO();
	
	int result = dao.add(dto);
	
	String reply = "국가 등록 실패";
	
	if (result > 0) {
		reply = "국가 등록 성공";
		
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>국가 등록 처리 페이지</h1>
	
	<h3><%= reply %></h3>
	
	<a href="/">HOME</a>
	<a href="./list.jsp">LIST</a>
	

</body>
</html>