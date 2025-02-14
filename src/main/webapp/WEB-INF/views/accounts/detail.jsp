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
	                    <li><div class="title">${dto.accountNum}</div></li>
	                    <li><div class="title_sub">상품번호</div><br>${dto.productNum}</li>
	                    <li><div class="title_sub">잔액</div><br>${dto.accountBalance}</li>
	                    <li><div class="title_sub">개설날짜</div><br>${dto.accountDate}</li>
	                </ul>
				</div>
			</div>
		</section>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>