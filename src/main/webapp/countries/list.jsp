<%@page import="com.winter.app.countries.CountryDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	CountryDAO dao = new CountryDAO();
	List<CountryDTO> ar = dao.getList();
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
	<h1>Countries List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Country_id</th>
				<th>Country_name</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i=0;i<ar.size();i++) { %>
				<tr>
					<td><%=ar.get(i).getCountry_id() %></td>
					<td><a href="./detail.jsp?country_id=<%= ar.get(i).getCountry_id() %>">
					<%=ar.get(i).getCountry_name() %></a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
	<div>
		<a href="./add.jsp">국가 등록</a>
	</div>
	

</body>
</html>