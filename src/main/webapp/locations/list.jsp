<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	LocationDAO locationDAO = new LocationDAO();
	List<LocationDTO> ar = locationDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width: 40%;
		margin: 0 auto;
		border: 1px solid red;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>Location List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Location_Id</th>
				<th>City</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i=0;i<ar.size();i++) { %>
				<tr>
					<td><%=ar.get(i).getLocation_id() %></td>
					<td><a href="./detail.jsp?location_id=<%= ar.get(i).getLocation_id()%>"><%=ar.get(i).getCity() %></a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
	<div>
		<a href="./add.jsp">지역등록</a>
	</div>
</body>
</html>