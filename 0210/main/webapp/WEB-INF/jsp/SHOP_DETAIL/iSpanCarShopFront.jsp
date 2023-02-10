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

			<style>
				.priceMark {
					font-weight: bold;
					font-size: 20px;
				}
			</style>



		</head>

		<body class="body-wrapper">

			<header>
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<nav class="navbar navbar-expand-lg navbar-light navigation">
								<!-- 					<a class="navbar-brand" href="index.html"> -->
								<!-- 						<img src="images/logo.png" alt=""> -->
								<!-- 					</a> -->
								<button class="navbar-toggler" type="button" data-toggle="collapse"
									data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
									aria-expanded="false" aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div class="collapse navbar-collapse" id="navbarSupportedContent">
									<ul class="navbar-nav ml-auto main-nav ">
										<li class="nav-item @@home">
											<a class="nav-link" href="iSpancarShop.ProductListAllShopPage.1">Home</a>
										</li>
										<li class="nav-item dropdown dropdown-slide @@dashboard">
											<a class="nav-link dropdown-toggle" data-toggle="dropdown"
												href="#!">Dashboard<span><i class="fa fa-angle-down"></i></span>
											</a>

											<!-- Dropdown list -->
											<ul class="dropdown-menu">
												<li><a class="dropdown-item @@dashboardPage"
														href="dashboard.html">Dashboard</a></li>
												<li><a class="dropdown-item @@dashboardMyAds"
														href="dashboard-my-ads.html">Dashboard My Ads</a></li>
												<li><a class="dropdown-item @@dashboardFavouriteAds"
														href="dashboard-favourite-ads.html">Dashboard Favourite Ads</a>
												</li>
												<li><a class="dropdown-item @@dashboardArchivedAds"
														href="dashboard-archived-ads.html">Dashboard Archived Ads</a>
												</li>
												<li><a class="dropdown-item @@dashboardPendingAds"
														href="dashboard-pending-ads.html">Dashboard Pending Ads</a></li>

												<li class="dropdown dropdown-submenu dropright">
													<a class="dropdown-item dropdown-toggle" href="#!" id="dropdown0501"
														role="button" data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false">Sub Menu</a>

													<ul class="dropdown-menu" aria-labelledby="dropdown0501">
														<li><a class="dropdown-item" href="index.html">Submenu 01</a>
														</li>
														<li><a class="dropdown-item" href="index.html">Submenu 02</a>
														</li>
													</ul>
												</li>
											</ul>
										</li>
										<li class="nav-item dropdown dropdown-slide @@pages">
											<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false">
												Pages <span><i class="fa fa-angle-down"></i></span>
											</a>
										<li class="nav-item dropdown dropdown-slide active">
											<a class="nav-link dropdown-toggle" href="#!" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false">
												Listing <span><i class="fa fa-angle-down"></i></span>
											</a>
											<!-- Dropdown list -->
											<ul class="dropdown-menu">
												<li><a class="dropdown-item active" href="category.html">Ad-Gird
														View</a></li>
												<li><a class="dropdown-item @@listView" href="ad-list-view.html">Ad-List
														View</a></li>

												<li class="dropdown dropdown-submenu dropleft">
													<a class="dropdown-item dropdown-toggle" href="#!" id="dropdown0201"
														role="button" data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false">Sub Menu</a>

													<ul class="dropdown-menu" aria-labelledby="dropdown0201">
														<li><a class="dropdown-item" href="index.html">Submenu 01</a>
														</li>
														<li><a class="dropdown-item" href="index.html">Submenu 02</a>
														</li>
													</ul>
												</li>
											</ul>
										</li>
									</ul>
									<ul class="navbar-nav ml-auto mt-10">
										<li class="nav-item">
											<a class="nav-link login-button" href="login.html">Login</a>
										</li>
										<li class="nav-item">
											<a class="nav-link text-white add-button" href="ad-listing.html"><i
													class="fa fa-plus-circle"></i> Add Listing</a>
										</li>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</header>
			<section class="page-search">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<!-- Advance Search -->
							<div class="advance-search nice-select-white">
								<form>
									<div class="form-row align-items-center">
										<div class="form-group col-xl-4 col-lg-3 col-md-6">
											<input type="text" class="form-control my-2 my-lg-0" id="inputtext4"
												placeholder="在找什麼嗎?" name="productname">
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
									<h4 class="widget-header">所有產品分類</h4>
									<ul class="category-list">
										<li><a href="#go" onclick="goToTypePage()" class="takename">輪胎</a></li>
										<li><a href="#go" onclick="goToTypePage()" class="takename">外飾</a></li>
										<li><a href="#go" onclick="goToTypePage()" class="takename">內飾</a></li>
										<li><a href="#go" onclick="goToTypePage()" class="takename">機油</a></li>
										<li><a href="#go" onclick="goToTypePage()" class="takename">配件</a></li>
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
									<h4 class="widget-header">商品排序</h4>
									<select id="mySelect">
										<option>依價格排序</option>
										<option value="ASC">由低到高</option>
										<option value="DESC">由高到低</option>
									</select>
								</div>

								<div class="widget price-range w-100"  style="text-align: center;">
									<c:forEach var="randomProduct" items="${selectRandomProduct}" varStatus="vs">
									<h4 class="widget-header" style="text-align: center;">精選商品</h4>
									<div class="block">
										<div class="d-flex justify-content-between mt-2">
										<img width="195" src="productimgfront.controller?productno=${randomProduct.productno}" alt="xxx" />
											
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

													<div class="thumb-content">
														<a href="#go" onclick="goToDetailPage2()" class="loadingName">
															<img style="border-radius:10%;"
																src="productimgfront.controller?productno=${product.productno}"
																width="180" height="180" />
														</a>
													</div>

													<div class="card-body">
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
														<!-- 												<div class="product-ratings"> -->
														<!-- 													<ul class="list-inline"> -->
														<!-- 														<li class="list-inline-item selected"><i -->
														<!-- 															class="fa fa-star"></i></li> -->
														<!-- 														<li class="list-inline-item selected"><i -->
														<!-- 															class="fa fa-star"></i></li> -->
														<!-- 														<li class="list-inline-item selected"><i -->
														<!-- 															class="fa fa-star"></i></li> -->
														<!-- 														<li class="list-inline-item selected"><i -->
														<!-- 															class="fa fa-star"></i></li> -->
														<!-- 														<li class="list-inline-item"><i class="fa fa-star"></i></li> -->
														<!-- 													</ul> -->
														<!-- 												</div> -->
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
								</div>
							</div>
						</div>
			</section>
			<!-- 
Essential Scripts
=====================================-->

			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/popper.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap-slider.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/tether/js/tether.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/raty/jquery.raty-fa.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/slick/slick.min.js"></script>
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
</script>

		</body>

		</html>