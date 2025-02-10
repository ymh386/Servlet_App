<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="org.eclipse.jdt.internal.compiler.codegen.IntegerCache"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("department_id");
	String name = request.getParameter("department_name");
	String manager = request.getParameter("manager_id");
	String lid	= request.getParameter("location_id");
	DepartmentDTO departmentDTO = new DepartmentDTO();
	departmentDTO.setDepartment_id(Integer.parseInt(id));
	departmentDTO.setDepartment_name(name);
	departmentDTO.setManager_id(Integer.parseInt(manager));
	departmentDTO.setLocation_id(Integer.parseInt(lid));
	
	DepartmentDAO departmentDAO = new DepartmentDAO();
	int result = departmentDAO.update(departmentDTO);
	
	String r = "부서 수정 실패";
	
	if(result>0) {
		r="부서 수정 성공";
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
	<a href="./list.jsp">부서 리스트</a>
</body>
</html>