<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/detail.css">
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
		<section class="wrap contents">
			<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
			<div class="right contents_right">
			<!-- 내용기술 -->
				<div class="contents_right_detail">
	                <ul>
	                    <li><div class="title">회원 정보</div></li>
	                    <li><div class="title_sub">아이디</div><br>${user.userName}</li>
	                    <li><div class="title_sub">이름</div><br>${user.name}</li>
	                    <li><div class="title_sub">전화번호</div><br>${user.phone}</li>
	                    <li><div class="title_sub">이메일</div><br>${user.email}</li>
	                </ul>
				</div>
				<a href="./update.do">정보수정</a><br><br>
				<a href="../accounts/list.do?userName=${user.userName}">계좌목록</a>
			</div>
		</section>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>