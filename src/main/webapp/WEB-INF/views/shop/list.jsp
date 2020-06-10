<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Test</title>
	<link rel = "stylesheet" href = "/resources/css/shop/list.css">
	
	<link rel = "stylesheet" href = "/resources/css/admin/index/index.css">

	<!-- bootstrap -->
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
	<script src="/resources/bootstrap/bootstrap.min.js"></script>
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
		<aside id="aside">
			<%@ include file="../include/aside.jsp" %>
		</aside>
	
		<div id="container_box">
		
			<section id="content">
				<ul>
					<c:forEach items="${list}" var="list">
					<li>
						<div class="goodsThumb">
							<img src="${list.gdsThumbImg}">
						</div>
						<div class="goodsName">
							<a href="/shop/view?n=${list.gdsNum }">${list.gdsName }</a>
						</div>
					</li>
					</c:forEach>
					<div>
						<c:forEach items = "${pag}" begin = "1" end = "5" step = "1" var="pag">
							<a href="/shop/list?c=${cateCode }&l=${level}&p=${pag}">${pag }</a>		
						</c:forEach>
					</div>
					<a href="/shop/list?c=${cateCode }&l=${level}&p=2">2</a>
					<a href="/shop/list?c=${cateCode }&l=${level}&p=9">9</a>
				</ul>
			</section>
			
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
