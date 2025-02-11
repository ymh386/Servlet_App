<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common.jsp"></c:import>
</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
	<c:import url="../template/header.jsp"></c:import>

	<section class="contents wrap_left">
		<div class="left contents_left">
			
			<c:import url="../template/nav.jsp"></c:import>
			
		</div>
		<div class="right contents_right">
		
			<h3><a href="./list.do">홈으로 가기</a></h3>
	
			<h1>Location tail Page</h1>
			
			
			
			<c:if test="${not empty dto }">
				<h3>${dto.location_id }</h3>
				<h3>${dto.street_address }</h3>
				<h3>${dto.postal_code }</h3>
				<h3>${dto.city }</h3>
				<h3>${dto.state_province }</h3>
				<h3>${dto.country_id }</h3>
				
				<a href="./delete.do?location_id=${dto.location_id }">지역 삭제</a>
				<a href="./update.do?location_id=${dto.location_id }">지역 수정</a>
			</c:if>
				
			<c:if test="${empty dto }">
				<h3>없는 지역입니다.</h3>
			</c:if>
				
			
		
		</div>
	</section>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>