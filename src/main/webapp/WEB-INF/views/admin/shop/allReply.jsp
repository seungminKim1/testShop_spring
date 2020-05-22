<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Test</title>
	
	<link rel = "stylesheet" href = "/resources/css/admin/index/index.css">
	<link rel = "stylesheet" href = "/resources/css/admin/shop/allReply.css">
	
	<!-- bootstrap -->
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
	<script src="/resources/bootstrap/bootstrap.min.js"></script>
	
	<!-- jquery -->
	<script src = "/resources/jquery/jquery-3.3.1.min.js"></script>	
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
					<c:forEach items="${reply}" var="reply">
					<li>
						<div class="replyInfo">
							<p>
								<span>작성자</span>${reply.userName } (${reply.userId })
							</p>
							
							<p>
								<span>작성된 상품</span> <a href="/shop/view?n=${reply.gdsNum }">바로가기</a>
							</p>
						</div>
						
						<div class="replyContent">
							${reply.repCon }
						</div>
						
						<div class="replyControl">
					
								<button type="button" class="delete_${reply.repNum }_btn" data-repNum="${reply.repNum }">삭제</button>
								
								<script>
									$(".delete_${reply.repNum}_btn").click(function(){
										var confirm_val = confirm("정말로 삭제하시겠습니까?");
										var data_repNum;
										if(confirm_val) {
											console.log("innnn");
											data_repNum = $(this).attr("data-repNum");
											console.log(data_repNum);
											$.ajax({
												url : "/admin/shop/deleteReply",
												type : "post",
												data : {
													repNum : data_repNum
												},
												success : function(result){
													if(result == 1) {
														location.href = "/admin/shop/allReply";
													} else {
														alert("삭제 실패");
													}
												},
												error : function(){
													alert("삭제 실패 ㅠㅠ");
												}
											});
										}
									});
								</script>
							
						</div>
						
					</li>
					</c:forEach>
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
