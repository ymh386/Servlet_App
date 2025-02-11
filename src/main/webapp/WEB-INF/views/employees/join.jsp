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
				<h2>사원 등록 페이지</h2>
				<div class="form_control">
					<form action="./join.do" method="post">
						<fieldset>
							<legend>First Name</legend>
							<input type="text" name="first_name">
						</fieldset>
						<fieldset>
							<legend>Last Name</legend>
							<input type="text" name="last_name">
						</fieldset>
						<fieldset>
							<legend>Email</legend>
							<input type="text" name="email">
						</fieldset>
						<fieldset>
							<legend>Phone Num</legend>
							<input type="text" name="phone_number">
						</fieldset>
						<fieldset>
							<legend>Job ID</legend>
							<input type="text" name="job_id">
						</fieldset>
						<fieldset>
							<legend>Salary</legend>
							<input type="text" name="salary">
						</fieldset>
						<fieldset>
							<legend>Commission PCT</legend>
							<input type="text" name="commission_pct">
						</fieldset>
						<fieldset>
							<legend>Manager ID</legend>
							<input type="text" name="manager_id">
						</fieldset>
						<fieldset>
							<legend>Department ID</legend>
							<input type="text" name="department_id">
						</fieldset>
						<fieldset>
							<legend>Password</legend>
							<input type="text" name="password">
						</fieldset>
						<fieldset>
							<button type="submit">등록</button>
						</fieldset>
					</form>
				</div>
			</div>
		</section>	
	
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>