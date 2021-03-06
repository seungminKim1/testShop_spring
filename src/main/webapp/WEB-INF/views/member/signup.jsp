<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Test</title>
	
	<!-- css -->
	<link rel = "stylesheet" href = "/resources/css/admin/index/index.css">
	<link rel = "stylesheet" href = "/resources/css/member/signup.css">
	
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
				<form role="form" method="post" autocomplete="off">
					<div class="input_area">
						<label for="userId">아이디</label>
						<input type="email" id="userId" name="userId" placeholder="example@email.com" required="required" />
					</div>
					
					<div class="input_area">
						<label for="userPass">패스워드</label>
						<input type="password" id="userPass" name="userPass" required="required" />
					</div>
					
					<div class="input_area">
						<label for="userName">이름</label>
						<input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요" required="required" />
					</div>
					
					<div class="input_area">
						<label for="userPhon">연락처</label>
						<input type="text" id="userPhon" name="userPhon" placeholder="연락처를 입력해주세요" required="required" />
					</div>
					
					<button type="submit" id="signup_btn" class="btn btn-primary" name="signup_btn">회원가입</button>
				</form>
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
