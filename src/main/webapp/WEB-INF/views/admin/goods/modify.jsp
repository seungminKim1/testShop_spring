<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Test</title>
	
	<!-- css -->
	<link rel="stylesheet" href="/resources/css/admin/index/index.css">
	<link rel="stylesheet" href="/resources/css/admin/goods/modify.css">
	
	
	<!-- jquery -->
	<script src="/resources/jquery/jquery-3.5.1.min.js"></script>
	
	<!-- bootstrap -->
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
	<script src="/resources/bootstrap/bootstrap.min.js"></script>
	
	<!-- ckeditor -->
	<script src="/resources/ckeditor/ckeditor.js"></script>	
		
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
			<h2>상품 수정</h2>
			
			<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
				
				<input type = "hidden" name = "gdsNum" value = "${goods.gdsNum }">
				
				<div class="inputArea">
					<label>1차 분류</label>
					<select class = "category1">
						<option value = "">전체</option>
					</select>
					
					<label>2차 분류</label>
					<select class = "category2" name="cateCode">
						<option value = "">전체</option>
					</select>
				</div>
				<div class="inputArea">
					<label for="gdsName">상품명</label>
					<input type="text" id="gdsName" name="gdsName" value="${goods.gdsName}">
				</div>
				
				<div class="inputArea">
					<label for="gdsPrice">상품가격</label>
					<input type="text" id="gdsPrice" name="gdsPrice" value="${goods.gdsPrice }">
				</div>
				
				<div class="inputArea">
					<label for="gdsStock">상품수량</label>
					<input type="text" id="gdsStock" name="gdsStock" value="${goods.gdsStock }">
				</div>
				
				<div class="inputArea">
					<label for="gdsDes">상품소개</label>
					<textarea rows="5" cols="50" id="gdsDes" name="gdsDes">${goods.gdsDes }</textarea>
					
					<script>
						var ckeditor_config = {
								resize_enaleb : false,
								enterMode : CKEDITOR.ENTER_BR,
								shiftEnterMode : CKEDITOR.ENTER_P,
								filebrowserUploadUrl : "/admin/goods/ckUpload"
						};
						
						CKEDITOR.replace("gdsDes",ckeditor_config);
					</script>
					
				</div>
				
				<div class="inputArea">
					<label for="gdsImg">이미지</label>
					<input type="file" id="gdsImg" name="file" />
					<div class="select_img">
						<img src="${goods.gdsImg} ">
						<input type="hidden" name="gdsImg" value="${goods.gdsImg }" />
						<input type="hidden" name="gdsThumbImg" value="${goods.gdsThumbImg }" />
					</div>
					
					<script>
						$("#gdsImg").change(function(){
							if(this.files && this.files[0]) {
								var reader = new FileReader;
								reader.onload = function(data){
									$(".select_img img").attr("src",data.target.result).width(500);
								}
								reader.readAsDataURL(this.files[0]);
							}
						});
					</script>
					<%= request.getRealPath("/") %>
				</div>
				
				<div class="inputArea">
					<button type="submit" id="update_Btn" class="btn btn-primary">수정</button>
					<button type="button" id="back_Btn" class="btn btn-warning">취소</button>
				</div>
				
				<script>
					$("#back_Btn").click(function(){
						//history.back();
						location.href="/admin/goods/view?n="+${goods.gdsNum};
					});
				</script>
				
			</form>
			
		</div>
		
	</section>
	
	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp" %>		
		</div>	
	</footer>
</div>

<script>
//컨트롤러에서 데이터 받기
var jsonData = JSON.parse('${category}');
console.log(jsonData);

var cate1Arr = new Array();
var cate1Obj = new Object();

for(var i = 0; i < jsonData.length; i++){
	
	if(jsonData[i].level == '1') {
		cate1Obj = new Object(); //초기화
		cate1Obj.cateCode = jsonData[i].cateCode;
		cate1Obj.cateName = jsonData[i].cateName;
		cate1Arr.push(cate1Obj);
	}
}
//1차 분류 셀렉트 박스에 데이터 삽입
var cate1Select = $("select.category1")

for(var i = 0; i < cate1Arr.length; i++){
	cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>" + cate1Arr[i].cateName + "</option>");
}

//2차분류
$(document).on("change","select.category1",function(){
	
	var cate2Arr = new Array();
	var cate2Obj = new Object();
	//2차 분류 셀렉트 박스에 삽입할 데이터 준비
	for(var i = 0; i < jsonData.length; i++) {
		
		if(jsonData[i].level == "2") {
			
			cate2Obj = new Object(); //초기화
			cate2Obj.cateCode = jsonData[i].cateCode;
			cate2Obj.cateName = jsonData[i].cateName;
			cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;
			
			cate2Arr.push(cate2Obj);
		}
	}
	
	var cate2Select = $("select.category2")
	/*
	for(var i = 0; i < cate2Arr.length; i++) {
		cate2Select.append("<option value ='" + cate2Arr[i].cateCode + "'>" + cate2Arr[i].cateName + "</option>");
	}
	*/
	
	cate2Select.children().remove();
	
	$("option:selected",this).each(function(){
		
		var selectVal = $(this).val();
		cate2Select.append("<option value = '"+ selectVal +"'>전체</option>");
		
		for(var i = 0; i < cate2Arr.length; i++){
			if(selectVal == cate2Arr[i].cateCodeRef) {
				cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>" + cate2Arr[i].cateName + "</option>");
			}
		}
		
	});
	
});

var select_cateCode = '${goods.cateCode}';
var select_cateCodeRef = '${goods.cateCodeRef}';
var select_cateName = '${goods.cateName}';

//2차분류 카테고리가 있을떄
if(select_cateCodeRef != null && select_cateCodeRef != ''){
	$(".category1").val(select_cateCodeRef);
	$(".catagory2").val(select_cateCode);
	$(".category2").children().remove();
	$(".category2").append("<option value = '" + select_cateCode + "'>" + select_cateName + "</option>");
} else {
	//2차분류 카테고리가 없을때
	$(".category1").val(select_cateCode);
// 	$(".category2").val(select_cateCode);
	$(".category2").append("<option value='" + select_cateCode + "' selected='selected'>전체</option>");
	
}


</script>

<!-- 상품 수량 및 가격 숫자체크 -->
<script>
		var regExp = /[^0-9]/gi;
		
		$("#gdsPrice").keyup(function(){numCheck($(this));});
		$("#gdsStock").keyup(function(){numCheck($(this));});
		
		function numCheck(selector) {
			var tempVal = selector.val();
			selector.val(tempVal.replace(regExp,""));
		}
		
</script>

</body>
</html>

