<%@page import="oracle.jdbc.proxy.annotation.GetDelegate"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	DepartmentDAO departmentDAO = new DepartmentDAO();
	List<DepartmentDTO> ar = departmentDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Department_Id</th>
				<th>Department_Name</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i=0;i<ar.size();i++) { %>
				<tr>
					<td><%=ar.get(i).getDepartment_id() %></td>
					<td><a href="./detail.jsp?department_id=<%= ar.get(i).getDepartment_id()%>"><%=ar.get(i).getDepartment_name() %></a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>