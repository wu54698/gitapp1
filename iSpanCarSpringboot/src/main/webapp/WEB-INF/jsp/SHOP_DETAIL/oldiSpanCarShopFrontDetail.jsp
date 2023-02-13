<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link href="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap.min.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap-slider.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/slick/slick.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/slick/slick-theme.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/jquery-nice-select/css/nice-select.css" rel="stylesheet">
  
  <link href="http://localhost:8080/iSpanCar/script/css/shopstyle.css" rel="stylesheet">
</head>

<body>  
<section class="page-search">
	<div class="container">
		<div class="row">
		</div>
	</div>
</section>
<!--===================================
=            Store Section            =
====================================-->
<section class="section bg-gray">
	<!-- Container Start -->
	<div class="container">
		<div class="row">
			<!-- Left sidebar -->
			<div class="col-lg-8">
			<c:forEach items="productdetail" var="product" varStatus="vs">
				<div class="product-details">
					<h1 class="product-title">${product.productname}</h1>
					<!-- product slider -->
					<div class="product-slider">
							<img style="border-radius:10%;"
										src="productimgfront.controller?productno=${product.productno}"
										width="180" height="180" />
						</div>
					</div>
					<!-- product slider -->

					<div class="content mt-5 pt-5">
						<div class="tab-content" id="pills-tabContent">
							<div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
								<h3 class="tab-title">Product Description</h3>
								<p>${product.productinfo}</p>
								<p></p>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
			<div class="col-lg-4">
				<div class="sidebar">
					<div class="widget price text-center">
						<h4>Price</h4>
<%-- 						<p>${product.price}</p> --%>
					</div>
				</div>
			</div>
			</div>
		</div>
	<!-- Container End -->
</section>
</body>
</html>
