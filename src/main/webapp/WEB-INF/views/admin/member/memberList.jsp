<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<html>
<head>
	<title>Test</title>
	
	<!-- css -->
	<link rel="stylesheet" href="/resources/css/admin/index/index.css">
	<link rel="stylesheet" href="/resources/css/admin/goods/list.css">
	
	<!-- jquery -->
	<script src="/resources/jquery/jquery-3.5.1.min.js"></script>
	
	<!-- bootstrap -->
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
	<script src="/resources/bootstrap/bootstrap.min.js"></script>
	
	<!-- 
	<style>
		.inputArea {
			margin : 10px 0;
		}
		
		select {
			width : 100px;
		}
		label {
			display : inline-block;
			width : 70px;
			padding : 5px;
		}
		label[for='gdsDes'] {
			display : block;
		}
		input {
			width: 150px;
		}
		textarea#gdsDes {
			width : 400px;
			height : 180px;
		}
	</style>
	 -->
	
</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="../include/header.jsp" %>
		</div>
	</header>
	
	<nav id="nav">
		<div id="nav_box">
			<%@ include file="../include/nav.jsp" %>
		</div>
	</nav>
	
	<section id="container">
	
		<aside>
			<%@ include file="../include/aside.jsp" %>
		</aside>
		<div id="container_box">
			<!-- <h2>상품 목록</h2> -->
			
			<table>
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>가입일</th>
						<th>권한</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberList}" var="memberList">
						<tr>
							<td>${memberList.userId }</td>
							<td>${memberList.userName }</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${memberList.regiDate }"/></td>
							
							<c:choose>
								<c:when test="${memberList.verify == 9 }">
									<td>관리자</td>
								</c:when>
								<c:otherwise>
									<td>회원</td>
								</c:otherwise>
							</c:choose>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</section>
	
	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp" %>		
		</div>	
	</footer>
</div>


</body>
</html>

