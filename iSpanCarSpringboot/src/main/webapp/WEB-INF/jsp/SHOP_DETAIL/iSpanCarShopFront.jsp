<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>

		<html>

		<head>
			<!-- ** Basic Page Needs ** -->
			<meta charset="utf-8">
			<title>iSpanCarShop</title>

			<!-- ** Mobile Specific Metas ** -->
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="description" content="Agency HTML Template">
			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
			<meta name="author" content="Themefisher">
			<meta name="generator" content="Themefisher Classified Marketplace Template v1.0">
			<!-- 
  Essential stylesheets
  =====================================-->
			<script src="http://localhost:8080/iSpanCar/script/plugins/jquery/jquery.min.js"></script>
			<link href="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap.min.css" rel="stylesheet">
			<link href="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap-slider.css" rel="stylesheet">
			<link href="http://localhost:8080/iSpanCar/script/plugins/font-awesome/css/font-awesome.min.css"
				rel="stylesheet">
			<link href="http://localhost:8080/iSpanCar/script/plugins/slick/slick.css" rel="stylesheet">
			<link href="http://localhost:8080/iSpanCar/script/plugins/slick/slick-theme.css" rel="stylesheet">
			<link href="http://localhost:8080/iSpanCar/script/plugins/jquery-nice-select/css/nice-select.css"
				rel="stylesheet">

			<link href="http://localhost:8080/iSpanCar/script/css/shopstyle.css" rel="stylesheet">
			<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
            <!-- Font Awesome icons (free version)-->
            <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
            <!-- Google fonts-->
            <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesh0eet" />
            <link
                href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                rel="stylesheet" />
            <!-- Core theme CSS (includes Bootstrap)-->
            <link href="http://localhost:8080/iSpanCar/script/css/styles.css" rel="stylesheet" />
            <script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
            <script src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">
            <link rel="icon" href="img/Fevicon.png" type="image/png">

			<style>
				.priceMark {
					font-weight: bold;
					font-size: 20px;
				}
				
				section {
  				background-color: #F0F0F0;
				}

				.col-10 {
				  padding-left: 0;
				  padding-right: 0;
				}
				
				.btn-primary{
				background-color: red;
				  border-color: red;
				}
				
				a {
			    text-decoration:none;
				}
				.takename:hover{
				background-color: #F5F5F5;
				color: #6ddbf7;
				}
				.btn-primary.active {
				  font-size: 20px;
				  padding:0;
				  padding-top:10px;
				  padding-bottom:10px;
				}
				
				.card:hover * {
				  background-color: #F5F5F5;
				  }
				  
				#randomDiv {
				  display: flex;
				  justify-content: center;
				}
				#randomImg {
				  display: block;
				  margin: auto;
				}
				
				.centered {
				  display: flex;
				  justify-content: center;
				  align-items: center;
				  font-size: 20px;
				}
				
			</style>
		</head>

		<body class="body-wrapper">
			<c:set value="${LoginOK}" var="login" />
            <c:set value="${login.memberPosition.permissionsofposition}" var="memberPosition" />
            <input type="hidden" value="${login.accountnumber}" id="logincheck">
			<input type="hidden" value="${login.memberName}" id="loginName">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            </nav>

            <header class="masthead2">
                <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
                    <div class="d-flex justify-content-center">
                        <div class="text-center">
                            <h2 class="mx-auto my-0 text-uppercase"
                                style="color:white;font-size:5em;font-family: 'Noto Sans TC', sans-serif;">您的座駕需要，<br>&emsp;&emsp;&emsp;我們的零件滿足。</h2>
                        </div>
                    </div>
                </div>
            </header>
            
            <div class="bg-black" id="content" >
                <div class="row rounded">
                    <div class="col-1" ></div>
                    <div class="col-10 bg-white justify-content-center rounded mb-2">
			<section class="page-search" style="background-color:#6c8472;">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<!-- Advance Search -->
							<div class="advance-search nice-select-white">
								<form>
									<div class="form-row align-items-center">
										<div class="form-group col-xl-4 col-lg-3 col-md-6">
											<input type="text" class="form-control my-2 my-lg-0" id="inputtext4"
												placeholder="在找什麼嗎?" name="productname" style="color: black">
										</div>
										<!-- 							<div class="form-group col-lg-3 col-md-6"> -->
										<!-- 								<select class="w-100 form-control my-2 my-lg-0"> -->
										<!-- 									<option>Category</option> -->
										<!-- 									<option value="1">Top rated</option> -->
										<!-- 									<option value="2">Lowest Price</option> -->
										<!-- 									<option value="4">Highest Price</option> -->
										<!-- 								</select> -->
										<!-- 							</div> -->
										<!-- 							<div class="form-group col-lg-3 col-md-6"> -->
										<!-- 								<input type="text" class="form-control my-2 my-lg-0" id="inputLocation4" placeholder="Location"> -->
										<!-- 							</div> -->
										<div class="form-group col-xl-2 col-lg-3 col-md-6">

											<button type="submit" class="btn btn-primary active w-100"
												formaction="iSpancarShop.SearchResultShopPage">找產品</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</section>
			<section class="section-sm">
				<div class="container">
					<div class="row">
						<div class="col-lg-3 col-md-4">
							<div class="category-sidebar">
								<div class="widget category-list">
									<h3 class="widget-header"><div class="centered" style="font-size:23px;">所有產品分類</div></h3>
									<ul class="category-list" style="padding:0;">
										<li><a href="#go" onclick="goToTypePage()" class="takename"><div class="centered">輪胎</div></a></li>
										<li><a href="#go" onclick="goToTypePage()" class="takename"><div class="centered">外飾</div></a></li>
										<li><a href="#go" onclick="goToTypePage()" class="takename"><div class="centered">內飾</div></a></li>
										<li><a href="#go" onclick="goToTypePage()" class="takename"><div class="centered">機油</div></a></li>
										<li><a href="#go" onclick="goToTypePage()" class="takename"><div class="centered">配件</div></a></li>
									</ul>
								</div>

								<!-- <div class="widget category-list"> -->
								<!-- 	<h4 class="widget-header">Nearby</h4> -->
								<!-- 	<ul class="category-list"> -->
								<!-- 		<li><a href="category.html">New York <span>93</span></a></li> -->
								<!-- 		<li><a href="category.html">New Jersy <span>233</span></a></li> -->
								<!-- 		<li><a href="category.html">Florida  <span>183</span></a></li> -->
								<!-- 		<li><a href="category.html">California <span>120</span></a></li> -->
								<!-- 		<li><a href="category.html">Texas <span>40</span></a></li> -->
								<!-- 		<li><a href="category.html">Alaska <span>81</span></a></li> -->
								<!-- 	</ul> -->
								<!-- </div> -->

								<div class="widget filter">
									<h4 class="widget-header"><div class="centered" style="font-size:23px;">商品排序</div></h4>
									<div class="centered" style="font-size:16px;">
									<select id="mySelect">
										<option>依價格排序</option>
										<option value="ASC">由低到高</option>
										<option value="DESC">由高到低</option>
									</select>
										</div>
								</div>

								<div class="widget price-range w-100"  style="text-align: center;border:5px dashed yellow">
									<c:forEach var="randomProduct" items="${selectRandomProduct}" varStatus="vs">
									<h4 class="widget-header" style="text-align: center;"><div class="centered" style="font-size:23px;color:#FFDC00">精選商品</div></h4>
									<div class="block">
										<div class="d-flex justify-content-between mt-2" id="randomDiv">
										<img width="195" id="randomImg" style="border-radius:10%;padding:10px" src="productimgfront.controller?productno=${randomProduct.productno}" alt="xxx" />
											
										</div>
											<span class="value"><a href="/iSpancarShop.DetailShopPage?productname=${randomProduct.productname}">${randomProduct.productname}</a></span>
									</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="col-lg-9 col-md-8">
<!-- 							<div class="category-search-filter"> -->
								<div class="row">
<!-- 									<div class="col-md-6 text-center text-md-left"> -->
<!-- 										<strong>Short</strong> -->
<!-- 										<select> -->
<!-- 											<option>Most Recent</option> -->
<!-- 											<option value="1">Most Popular</option> -->
<!-- 											<option value="2">Lowest Price</option> -->
<!-- 											<option value="4">Highest Price</option> -->
<!-- 										</select> -->
<!-- 									</div> -->
									<div class="col-md-6 text-center text-md-right mt-2 mt-md-0">
									</div>
<!-- 								</div> -->
							</div>
							<div class="product-grid-list">
								<div class="row mt-30" id="showproduct">
									<c:forEach items="${queryallproduct}" var="product" varStatus="vs">
										<div class="col-lg-4 col-md-6">
											<!-- product card -->
											<div class="product-item bg-light">
												<div class="card">

													<div class="thumb-content" style="text-align:center;">
														<a href="#go" onclick="goToDetailPage2()" class="loadingName" >
															<img style="border-radius:10%;padding:10px"
																src="productimgfront.controller?productno=${product.productno}"
																width="180" height="180"  />
														</a>
													</div>

													<div class="card-body" style="text-align:center;height: 135.6px">
														<h4 class="card-title">
															<a href="#go" onclick="goToDetailPage()"
																class="takename">${product.productname}</a>
														</h4>
														<ul class="list-inline product-meta">
															<li class="list-inline-item"><i
																		class="fa fa-folder-open-o"></i>${product.type}
															</li>
															<li class="priceMark">NT$${product.price}</li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<div class="pagination justify-content-center">
									<c:forEach var="i" begin="1" end="${totalPages}" step="1">
                                    	<li class="page-item"><a class="page-link" href="iSpancarShop.ProductListAllShopPage.${i}">${i}</a></li>
                               		</c:forEach>
                               		  <li style="text-align: center; padding: 10px; font-size: 10px">${nowPage}/${totalPages}</li>
								</div>
							</div>
						</div>
			</section>
					</div>
				</div>
			</div>
			
			 <div id="footertext"></div>
			<!-- 
Essential Scripts
=====================================-->
			<script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/popper.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap-slider.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/tether/js/tether.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/raty/jquery.raty-fa.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/slick/slick.min.js"></script>
            <script src="http://localhost:8080/iSpanCar/script/js/navhtml.js"></script>
            <script src="http://localhost:8080/iSpanCar/script/js/footerhtml.js"></script>
			<script
				src="http://localhost:8080/iSpanCar/script/plugins/jquery-nice-select/js/jquery.nice-select.min.js"></script>


			<script>
				var pval;
				$(".takename").on('mouseover', function () {
					pval = $(this).text();
					console.log(pval)
				});

				function goToDetailPage() {
					console.log("---------xxxxxxxx----------")
					console.log(pval);
					console.log("----------xxxxxxxxx---------------")
					window.location.href = "iSpancarShop.DetailShopPage?productname=" + pval;
				}

				function goToTypePage() {
					console.log("---------xxxxxxxx----------")
					console.log(pval);
					console.log("----------xxxxxxxxx---------------")
					window.location.href = "iSpancarShop.SearchByType?type=" + pval;
				}
			</script>

			<script>
				var productName;

				$(".loadingName").on('mouseover', function () {
					productName = $(this).closest('.product-item').find('.takename').text();
					console.log(productName);
				});

				function goToDetailPage2() {
					console.log("----------xxxx222xxxx---------------")
					console.log(productName);
					console.log("----------xxxx222xxxx---------------")
					window.location.href = "iSpancarShop.DetailShopPage?productname=" + productName;
				}


			</script>
			<script>
  	document.getElementById("mySelect").addEventListener("change", function() {
    switch (this.value) {
      case "ASC":
    	  window.location.href ="iSpancarShop.ProductListByLowPrice";
        break;
      case "DESC":
    	  window.location.href ="iSpancarShop.ProductListByHighPrice";
        break;
    }
  });
  	$(function(){
  	  $('#userDropdown').on('click',function(){
  		  location.href = '/userinfo';
  	  })
    })
</script>

		</body>

		</html>