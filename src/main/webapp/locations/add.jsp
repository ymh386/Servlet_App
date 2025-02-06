<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역 추가 페이지</h1>
	<form action="./addProcess.jsp" method="post">
		<input type="text" name="street_address" value="">
		<input type="text" name="postal_code">
		<input type="text" name="city">
		<input type="text" name="state_province">
		<input type="text" name="country_id">
		<button type="submit">등록</button>
	</form>
</body>
</html>