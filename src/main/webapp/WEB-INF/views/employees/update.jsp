<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/form.css">
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
		<section class="wrap_left contents">
			<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
			<div class="right contents_right">
				<!-- contents 내용 기술 -->
				<h2>정보 수정 페이지</h2>
				<div class="form_control">
					<form action="update.do" method="post">
						<fieldset>
							<input type="text" name="employee_id" value="${sessionScope.user.employee_id}" readonly>
						</fieldset>
						<fieldset>
							<legend>First Name</legend>
							<input type="text" name="first_name" value="${sessionScope.user.first_name}">
						</fieldset>
						<fieldset>
							<legend>Last Name</legend>
							<input type="text" name="last_name" value="${requestScope.user.last_name}">
						</fieldset>
						<fieldset>
							<button type="submit">수정</button>
						</fieldset>
					</form>
				</div>
			</div>
	
		</section>	
	
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	
</body>
</html>