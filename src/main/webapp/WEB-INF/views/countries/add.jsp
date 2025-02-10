<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 국가 내용 작성 페이지</h1>
	
	<form action="./addProcess.jsp" method="post">
		<input type="text" name="country_id" value="국가 아이디 입력">
		<input type="text" name="country_name" value="국가 이름 입력">
		<input type="text" name="region_id" value="대륙 아이디 입력">
		
		<button type="submit">등록하기</button>
	
	</form>

</body>
</html>