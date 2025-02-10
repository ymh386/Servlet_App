<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDTO departmentDTO = new DepartmentDTO();
	String department_id = request.getParameter("department_id");
	departmentDTO.setDepartment_id(Integer.parseInt(department_id));
	DepartmentDAO departmentDAO = new DepartmentDAO();
	departmentDTO = departmentDAO.getDetail(departmentDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">
</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
	<%@ include file="/template/header.jsp"%>

	<section class="contents wrap_left">
		<div class="left contents_left">
			
			<%@ include file="/template/nav.jsp" %>
			
		</div>
		<div class="right contents_right">
		
			<h3><a href="/">홈으로 가기</a></h3>
	
			<h1>Dept Detail Page</h1>
			
			<% if(departmentDTO != null) { %>
				<h3><%= departmentDTO.getDepartment_id() %></h3>
				<h3><%= departmentDTO.getDepartment_name() %></h3>
				<h3><%= departmentDTO.getManager_id() %></h3>
				
				<a href="./deleteProcess.jsp?department_id=<%= departmentDTO.getDepartment_id() %>">부서 삭제</a>
				<a href="./update.jsp?department_id=<%= departmentDTO.getDepartment_id() %>">부서 수정</a>
				
			<% } else { %>
				<h3>없는 부서입니다.</h3>
				
			<% } %>
		
		</div>
	</section>

	<%@ include file="/template/footer.jsp"%>
</body>
</html>