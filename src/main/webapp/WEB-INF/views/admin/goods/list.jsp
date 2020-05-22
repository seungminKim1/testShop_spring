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
						<th>썸네일</th>
						<th>번호</th>
						<th>이름</th>
						<th>카테고리</th>
						<th>가격</th>
						<th>수량</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>
								<img src="${list.gdsThumbImg}">
							</td>
							<td>${list.gdsNum }</td>
							<td>
								<a href="/admin/goods/view?n=${list.gdsNum }">${list.gdsName }</a>
							</td>
							<td>
								${list.cateName }
								<!-- ${list.cateCode } -->
							</td>
							<td>
								<fmt:formatNumber value="${list.gdsPrice }" pattern="###,###,###"/>
							</td>
							<td>${list.gdsStock }</td>
							<td>
								<fmt:formatDate value="${list.gdsDate }" pattern="yyyy-MM-dd"/>
							</td>
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

