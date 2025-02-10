<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<LocationDTO> ar = (List<LocationDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/common.jsp"%>
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<%@ include file="../template/header.jsp"%>
	<section class="wrap_left contents">
		<%@ include file="../template/nav.jsp"%>
		<div class="right contents_right">
			<div class="contents_right_list">
				<table class="table_sprite">
					<thead>
						<tr>
							<th>지역번호</th>
							<th>지역명</th>
						</tr>
					</thead>
					<tbody>
	
						<%
						for (int i = 0; i < ar.size(); i++) {
						%>
						<tr>
							<td><%=ar.get(i).getLocation_id()%></td>
							<td><a
								href="./detail.do?location_id=<%=ar.get(i).getLocation_id()%>"><%=ar.get(i).getCity()%></a>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<div>
				<a href="add.do">지역등록</a>
			</div>


		</div>

	</section>

	<%@ include file="../template/footer.jsp"%>
</body>
</html>