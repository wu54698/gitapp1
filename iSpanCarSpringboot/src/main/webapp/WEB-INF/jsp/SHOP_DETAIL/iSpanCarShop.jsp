<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <link href="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap.min.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap-slider.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/slick/slick.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/slick/slick-theme.css" rel="stylesheet">
  <link href="http://localhost:8080/iSpanCar/script/plugins/jquery-nice-select/css/nice-select.css" rel="stylesheet">
  
  <link href="http://localhost:8080/iSpanCar/script/css/shopstyle.css" rel="stylesheet">

	<script>
    function goToDetailPage(productname) {
      var productname = "${product.productname}";
      window.location.href = "iSpancarShop.DetailShopPage?productname=" + productname;
    }
  </script>
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
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto main-nav ">
							<li class="nav-item @@home">
								<a class="nav-link" href="index.html">Home</a>
							</li>
							<li class="nav-item dropdown dropdown-slide @@dashboard">
								<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#!">Dashboard<span><i class="fa fa-angle-down"></i></span>
								</a>

								<!-- Dropdown list -->
								<ul class="dropdown-menu">
									<li><a class="dropdown-item @@dashboardPage" href="dashboard.html">Dashboard</a></li>
									<li><a class="dropdown-item @@dashboardMyAds" href="dashboard-my-ads.html">Dashboard My Ads</a></li>
									<li><a class="dropdown-item @@dashboardFavouriteAds" href="dashboard-favourite-ads.html">Dashboard Favourite Ads</a></li>
									<li><a class="dropdown-item @@dashboardArchivedAds" href="dashboard-archived-ads.html">Dashboard Archived Ads</a></li>
									<li><a class="dropdown-item @@dashboardPendingAds" href="dashboard-pending-ads.html">Dashboard Pending Ads</a></li>
									
									<li class="dropdown dropdown-submenu dropright">
										<a class="dropdown-item dropdown-toggle" href="#!" id="dropdown0501" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sub Menu</a>
					
										<ul class="dropdown-menu" aria-labelledby="dropdown0501">
											<li><a class="dropdown-item" href="index.html">Submenu 01</a></li>
											<li><a class="dropdown-item" href="index.html">Submenu 02</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li class="nav-item dropdown dropdown-slide @@pages">
								<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Pages <span><i class="fa fa-angle-down"></i></span>
								</a>
							<li class="nav-item dropdown dropdown-slide active">
								<a class="nav-link dropdown-toggle" href="#!" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Listing <span><i class="fa fa-angle-down"></i></span>
								</a>
								<!-- Dropdown list -->
								<ul class="dropdown-menu">
									<li><a class="dropdown-item active" href="category.html">Ad-Gird View</a></li>
									<li><a class="dropdown-item @@listView" href="ad-list-view.html">Ad-List View</a></li>
									
									<li class="dropdown dropdown-submenu dropleft">
										<a class="dropdown-item dropdown-toggle" href="#!" id="dropdown0201" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sub Menu</a>
					
										<ul class="dropdown-menu" aria-labelledby="dropdown0201">
											<li><a class="dropdown-item" href="index.html">Submenu 01</a></li>
											<li><a class="dropdown-item" href="index.html">Submenu 02</a></li>
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
								<a class="nav-link text-white add-button" href="ad-listing.html"><i class="fa fa-plus-circle"></i> Add Listing</a>
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
								<input type="text" class="form-control my-2 my-lg-0" id="inputtext4" placeholder="What are you looking for" name="productname">
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

								<button type="submit" class="btn btn-primary active w-100" formaction="iSpancarShop.SearchResultShopPage">Search Now</button>
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
	<h4 class="widget-header">All Category</h4>
	<ul class="category-list">
		<li><a href="category.html">Laptops <span>93</span></a></li>
		<li><a href="category.html">Iphone <span>233</span></a></li>
		<li><a href="category.html">Microsoft  <span>183</span></a></li>
		<li><a href="category.html">Monitors <span>343</span></a></li>
	</ul>
</div>

<div class="widget category-list">
	<h4 class="widget-header">Nearby</h4>
	<ul class="category-list">
		<li><a href="category.html">New York <span>93</span></a></li>
		<li><a href="category.html">New Jersy <span>233</span></a></li>
		<li><a href="category.html">Florida  <span>183</span></a></li>
		<li><a href="category.html">California <span>120</span></a></li>
		<li><a href="category.html">Texas <span>40</span></a></li>
		<li><a href="category.html">Alaska <span>81</span></a></li>
	</ul>
</div>

<div class="widget filter">
	<h4 class="widget-header">Show Produts</h4>
	<select>
		<option>Popularity</option>
		<option value="1">Top rated</option>
		<option value="2">Lowest Price</option>
		<option value="4">Highest Price</option>
	</select>
</div>

<div class="widget price-range w-100">
	<h4 class="widget-header">Price Range</h4>
	<div class="block">
						<input class="range-track w-100" type="text" data-slider-min="0" data-slider-max="5000" data-slider-step="5"
						data-slider-value="[0,5000]">
				<div class="d-flex justify-content-between mt-2">
						<span class="value">$10 - $5000</span>
				</div>
	</div>
</div>

<div class="widget product-shorting">
	<h4 class="widget-header">By Condition</h4>
	<div class="form-check">
	  <label class="form-check-label">
	    <input class="form-check-input" type="checkbox" value="">
	    Brand New
	  </label>
	</div>
	<div class="form-check">
	  <label class="form-check-label">
	    <input class="form-check-input" type="checkbox" value="">
	    Almost New
	  </label>
	</div>
	<div class="form-check">
	  <label class="form-check-label">
	    <input class="form-check-input" type="checkbox" value="">
	    Gently New
	  </label>
	</div>
	<div class="form-check">
	  <label class="form-check-label">
	    <input class="form-check-input" type="checkbox" value="">
	    Havely New
	  </label>
	</div>
</div>

				</div>
			</div>
			<div class="col-lg-9 col-md-8">
				<div class="category-search-filter">
					<div class="row">
						<div class="col-md-6 text-center text-md-left">
							<strong>Short</strong>
							<select>
								<option>Most Recent</option>
								<option value="1">Most Popular</option>
								<option value="2">Lowest Price</option>
								<option value="4">Highest Price</option>
							</select>
						</div>
						<div class="col-md-6 text-center text-md-right mt-2 mt-md-0">
							<div class="view">
								<strong>Views</strong>
								<ul class="list-inline view-switcher">
									<li class="list-inline-item">
										<a href="#!" onclick="event.preventDefault();" class="text-info"><i class="fa fa-th-large"></i></a>
									</li>
									<li class="list-inline-item">
										<a href="ad-list-view.html"><i class="fa fa-reorder"></i></a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="product-grid-list">
					<div class="row mt-30">
							<c:forEach items="${queryallproduct}" var="product" varStatus="vs">
								<div class="col-lg-4 col-md-6">
									<!-- product card -->
									<div class="product-item bg-light">
										<div class="card">
									
											<div class="thumb-content">
												<!-- <!-- 												<div class="price">$200</div> -->
												<a href="single.html"> <img style="border-radius:10%;"
										src="productimg.controller?productno=${product.productno}"
										width="180" height="180" />
												</a>
											</div>

											<div class="card-body">
												<h4 class="card-title">
													
<%-- 														<a href="#" onclick="goToDetailPage(${product.productname})">${product.productname}</a> --%>
<a href="#" onclick="location.href='/iSpancarShop.DetailShopPage?productname=${product.productname}'">${product.productname}</a>
												</h4>
												<ul class="list-inline product-meta">
													<li class="list-inline-item"><a href="single.html"><i
															class="fa fa-folder-open-o"></i>${product.type}</a></li>
													
												</ul>
<%-- 												<p class="card-text">${product.productinfo}</p> --%>
												<div class="product-ratings">
													<ul class="list-inline">
														<li class="list-inline-item selected"><i
															class="fa fa-star"></i></li>
														<li class="list-inline-item selected"><i
															class="fa fa-star"></i></li>
														<li class="list-inline-item selected"><i
															class="fa fa-star"></i></li>
														<li class="list-inline-item selected"><i
															class="fa fa-star"></i></li>
														<li class="list-inline-item"><i class="fa fa-star"></i></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

			</div>
							<div class="pagination justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item">
								<a class="page-link" href="category.html" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
							</li>
							<li class="page-item active"><a class="page-link" href="category.html">1</a></li>
							<li class="page-item"><a class="page-link" href="category.html">2</a></li>
							<li class="page-item"><a class="page-link" href="category.html">3</a></li>
							<li class="page-item">
								<a class="page-link" href="category.html" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						</ul>
					</nav>
				</div>
		</div>
	</div>
</section>
<!-- 
Essential Scripts
=====================================-->
<script src="http://localhost:8080/iSpanCar/script/plugins/jquery/jquery.min.js"></script>
<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/popper.min.js"></script>
<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap.min.js"></script>
<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap-slider.js"></script>
<script src="http://localhost:8080/iSpanCar/script/plugins/tether/js/tether.min.js"></script>
<script src="http://localhost:8080/iSpanCar/script/plugins/raty/jquery.raty-fa.js"></script>
<script src="http://localhost:8080/iSpanCar/script/plugins/slick/slick.min.js"></script>
<script src="http://localhost:8080/iSpanCar/script/plugins/jquery-nice-select/js/jquery.nice-select.min.js"></script>

</body>
</html>