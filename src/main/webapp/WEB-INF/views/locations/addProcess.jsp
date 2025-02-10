<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LocationDTO locationDTO = new LocationDTO();
	String address = request.getParameter("street_address");
	String postal = request.getParameter("postal_code");
	String city = request.getParameter("city");
	String state = request.getParameter("state_province");
	String country = request.getParameter("country_id");
	
	locationDTO.setStreet_address(address);
	locationDTO.setPostal_code(postal);
	locationDTO.setCity(city);
	locationDTO.setState_province(state);
	locationDTO.setCountry_id(country);
	
	LocationDAO locationDAO = new LocationDAO();
	int result = locationDAO.add(locationDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역 등록 진행 페이지</h1>
	<% if(result>0) { %>
		<h3>지역 등록 성공</h3>
	<%}else { %>
		<h3>지역 등록 실패</h3>
	<%} %>
	
	<a href="./list.jsp">지역 리스트</a>
	<a href="/">Home</a>
	
</body>
</html>