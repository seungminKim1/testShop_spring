<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Test</title>
	<!-- css -->
	<link rel = "stylesheet" href = "/resources/css/admin/index/index.css">
	<link rel = "stylesheet" href = "/resources/css/shop/orderView.css">
	
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
				
				<div class="orderInfo">
					<c:forEach items="${orderView }" var="orderView" varStatus="status">
						
						<c:if test="${status.first }">
							<p><span>수령인</span>${orderView.orderRec }</p>
							<p><span>주소</span>(${orderView.userAddr1 }) ${orderView.userAddr2 } ${orderView.userAddr3 }</p>
							<p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.amount }" />  원</p>
							<p><span>배송상태</span>${orderView.delivery }</p>
						</c:if>
						
					</c:forEach>
				</div>
				
				<ul class="orderView">
					<c:forEach items="${orderView }" var="orderView">
						<li>
							<div class="thumb">
								<img src="${orderView.gdsThumbImg }" />
							</div>
							<div class="gdsInfo">
								<span>상품명</span>${orderView.gdsName }<br />
								<span>개당 가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.gdsPrice }"/><br />
								<span>구입 수량</span>${orderView.cartStock }<br />
								<span>최종 가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.gdsPrice * orderView.cartStock }"/><br />
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
