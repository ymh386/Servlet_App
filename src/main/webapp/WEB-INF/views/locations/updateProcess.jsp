<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("location_id");
	String address = request.getParameter("street_address");
	String pc = request.getParameter("postal_code");
	String city = request.getParameter("city");
	String sp = request.getParameter("state_province");
	String cid = request.getParameter("country_id");
	LocationDTO locationDTO = new LocationDTO();
	locationDTO.setLocation_id(Integer.parseInt(id));
	locationDTO.setStreet_address(address);
	locationDTO.setPostal_code(pc);
	locationDTO.setCity(city);
	locationDTO.setState_province(sp);
	locationDTO.setCountry_id(cid);
	
	LocationDAO locationDAO = new LocationDAO();
	int result = locationDAO.update(locationDTO);
	
	String r = "지역 수정 실패";
	if(result>0) {
		r = "지역 수정 성공";
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
	<a href="./list.jsp">지역 리스트</a>
</body>
</html>