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
		<section class="wrap contents">
			<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
			<div class="right contents_right">
			<!-- 내용기술 -->
			<div class="form_control">
					<form action="join.do" method="post">
						<fieldset>
							<legend>아이디</legend>
							<input type="text" name="userName">
						</fieldset>
						<fieldset>
							<legend>비밀번호</legend>
							<input type="password" name="password">
						</fieldset>
						<fieldset>
							<legend>이름</legend>
							<input type="text" name="name">
						</fieldset>
						<fieldset>
							<legend>전화번호</legend>
							<input type="tel" name="phone">
						</fieldset>
						<fieldset>
							<legend>이메일</legend>
							<input type="email" name="email">
						</fieldset>
						<fieldset>
							<button type="submit">가입</button>
						</fieldset>
					</form>
				</div>
			
			</div>
		</section>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>