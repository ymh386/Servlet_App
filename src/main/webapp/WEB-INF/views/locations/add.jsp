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
			<div class="form-wrapper">
				<h2>지역 추가 페이지</h2>
		
				<form action="./add.do" method="post" id="add-form">
					
						
						<input type="text" name="street_address" value="주소">

					
					
						
						<input type="text" name="postal_code" value="우편번호">

					
					
						
						<input type="text" name="city" value="도시">
						
						<input type="text" name="state_province" value="state province">
						
						<input type="text" name="country_id" value="국가코드">

									
						<input type="submit" value="등록하기">

					
						
				</form>
			</div>
		</div>
	</section>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>