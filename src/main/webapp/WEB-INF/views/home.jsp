<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Test</title>
	<!-- css -->
	<link rel = "stylesheet" href = "/resources/css/admin/index/index.css">
	
	<!-- bootstrap -->
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
	<script src="/resources/bootstrap/bootstrap.min.js"></script>
	
	<style>
	section#containber {
		height : 80%;
	}
	.jumbotron {
		text-shadow: black 0.2em 0.2em 0.2em;
		color : white !important;
		background-image: url('/resources/images/background.png');
		background-size: cover;
		height : 100%;
	}
	</style>
	
</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="include/header.jsp" %>
		</div>
	</header>
	
	<nav id="nav">
		<div id="nav_box">
			<%@ include file="include/nav.jsp" %>
		</div>
	</nav>
	
	<section id="container">
	
		<aside id="aside">
			<%@ include file="include/aside.jsp" %>
		</aside>
	
		<div id="container_box">
			<div class="jumbotron">
				<h1 class="text-center">어서오세요 환영합니다.</h1>
			</div>
		</div>
		
	</section>
	
	<footer id="footer">
		<div id="footer_box">
			<%@ include file="include/footer.jsp" %>		
		</div>	
	</footer>
</div>
</body>
</html>
