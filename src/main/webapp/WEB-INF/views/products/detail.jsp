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
					
					<c:if test="${not empty dto}">
						<div class="contents_right_detail">
			                <ul>
			                    <li><div class="title">${dto.productName} 상세정보</div></li>
			                    <li><div class="title_sub">상품번호</div><br>${dto.productNum}</li>
			                    <li><div class="title_sub">이자율</div><br>${dto.productRate}</li>
			                    <li><div class="title_sub">상품기간</div><br>${dto.productDate}</li>
			                </ul>
			                ${dto.productDetail}
		                </div>
		                <c:if test="${not empty user}">
							<c:if test="${user.userName == 'admin'}">
								<a href="./update.do?productNum=${dto.productNum}">수정</a><br><br>
								<a href="./delete.do?productNum=${dto.productNum}">삭제</a><br><br>
							</c:if>
							<a href="../accounts/add.do?userName=${user.userName}&productNum=${dto.productNum}">해당 상품으로 계좌 개설</a>
						</c:if>
		            </c:if>
		            <c:if test="${empty dto}">
						<h3>등록되지 않은 상품입니다.</h3>
					</c:if>
				</div>
			</div>
		</section>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>