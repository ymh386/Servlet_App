<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">
</head>
<style>
	
	

	.form-wrapper {
		width: 400px;
		height: 350px;
		padding: 40px;
		box-sizing: border-box;
	}

	.form-wrapper > h2 {
		font-size: 24px;
		color: #6A24FE;
		margin-bottom: 20px;
	}
	
	

	#add-form > input {
		width: 100%;
		height: 48px;
		padding: 0 10px;
		box-sizing: border-box;
		margin-bottom: 16px;
		border-radius: 6px;
		background-color: #F8F8F8;
	}
	
	#add-form > input[type="submit"]{
		color: #fff;
		font-size: 16px;
		background-color: #6A24FE;
		margin-top: 20px;
	}

</style>

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
				<h2>부서 추가 페이지</h2>
		
				<form action="./add.do" method="post" id="add-form">
					
						
						<input type="text" name="department_name" value="test">

					
					
						
						<input type="text" name="manager_id">

					
					
						
						<input type="text" name="location_id">

									
						<input type="submit" value="등록하기">

					
						
				</form>
			</div>
		</div>
	</section>

	<c:import url="../template/footer.jsp"></c:import>
	
</body>
</html>