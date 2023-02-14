<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
			<meta name="description" content="" />
			<meta name="author" content="" />
			<title>Grayscale - Start Bootstrap Theme</title>
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
			<link rel="preconnect" href="https://fonts.googleapis.com">
			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
			<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">
			<script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/js/navhtml.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/js/footerhtml.js"></script>
			<style>
				#car {
					display: inline-block;
					color: red;
					float: left;
					margin-left: 10px;
				}

				.goTop {
					position: fixed;
					right: 10px;
					bottom: 10px;
				}

				.carousel-item img {
					display: block;
					margin: 0 auto;
					width: 500px;
					height: 300px;
				}

				.figure-img {
					display: block;
					margin-left: auto;
					margin-right: auto;
				}

				.center {
					text-align: center;
				}
			</style>

		</head>

		<body id="page-top">
		<c:set value="${LoginOK}" var="login"/>
		<c:set value="${GoogleLogin}" var="GoogleLogin"/>
		<c:set value="${login.memberPosition.permissionsofposition}" var="memberPosition"/>
		<input type="hidden" value="${login.accountnumber}" id="logincheck">
		<input type="hidden" value="${login.memberName}" id="loginName">
		<input type="hidden" value="${GoogleLogin.email}" id="logincheck2">
		<input type="hidden" value="${GoogleLogin.membername}" id="loginGooglemembername">
		<input type="hidden" value="${GoogleLogin.picture}" id="loginpicture">
			<!-- Navigation-->
			<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav"></nav>
			<header class="masthead2">
				<div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
					<div class="d-flex justify-content-center">
						<div class="text-center">
							<h2 class="mx-auto my-0 text-uppercase"
								style="color: white; font-size: 6em; font-family: 'Noto Sans TC', sans-serif;">買車找我</h2>
							<!--                     <h2 class=" mx-auto mt-2 mb-5" style="color:white;font-size:2em;font-family:DFKai-SB;font-family: 'Noto Sans TC', sans-serif;">資車國際</h2> -->
						</div>
					</div>
				</div>
			</header>

			<div class="">
				<!-- Product Section-->
				<div class="left">
					<section class="py-5">
						<div class="container px-lg-0 my-5">
							<div class="row gx-4 gx-lg-5 align-items-center">
								<c:forEach var="car" items="${SelectCarByCarNo}" varStatus="vs">
									<div class="col-md-4">
										<img class="card-img-top mb-5 mb-md-0"
											src="/carInfoImage.controller/${car.carNo}" alt="...">
									</div>
									<div class="col-md-5">
										<div class="small mb-1">車輛編號: ${car.carNo}</div>
										<p>上架日期: ${car.announceDate}</p>
										<h1 class="display-5 fw-bolder">${car.carBrand}</h1>
										<h3 class="display-18 fw-bolder">${car.carName}</h3>
										<h5>車輛描述:</h5>
										<p class="lead">${car.carDescription}</p>
										<div class="d-flex">
											庫存<input class="form-control text-center me-3" id="inputQuantity" type="num"
												value="${car.stock}" style="max-width: 3rem" readonly>
											<button class="btn btn-outline-dark flex-shrink-0" type="button">
												<i class="bi-cart-fill me-1"></i>歡迎來電預約賞車
											</button>
										</div>
									</div>
								</c:forEach>
								<!-- 存放車商資訊 -->
								<div class="col-md-3">
									<section>
										<c:forEach var="dealer" items="${SelectCarDealName}" varStatus="vs">
											<div class="card-body d-flex flex-column align-items-start">
												<strong class="d-inline-block mb-2 text-primary">嚴選中古車商</strong>
												<h3 class="mb-0">
													<a class="text-dark" href="#">${dealer.carDealName}</a>
												</h3>
												<h6>連絡電話: ${dealer.carDealPhone}</h6>
												<span>地址: ${dealer.carDealAddress}</span> <span>營業時間:
													${dealer.openTime}</span> <span>聯絡人: ${dealer.contactPerson}</span>
											</div>
										</c:forEach>
									</section>
								</div>
							</div>
						</div>
					</section>
				</div>
				<!--這裡是多張圖片輪播-->
				<section class="carousel-section center">
					<figure class="figure">
						<div>
							<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
								<div class="carousel-inner">
									<c:forEach var="multiImages" items="${ShowMultiImages}" varStatus="vs">
										<c:choose>
											<c:when test="${vs.first}">
												<div class="carousel-item active">
													<img class="figure-img img-fluid rounded"
														src="/multiCarImages.controller/${multiImages.imageNo}"
														alt="...">
												</div>
											</c:when>
											<c:otherwise>
												<div class="carousel-item">
													<img class="figure-img img-fluid rounded"
														src="/multiCarImages.controller/${multiImages.imageNo}"
														alt="...">
												</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
								<button class="carousel-control-prev" type="button"
									data-bs-target="#carouselExampleControls" data-bs-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Previous</span>
								</button>
								<button class="carousel-control-next" type="button"
									data-bs-target="#carouselExampleControls" data-bs-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Next</span>
								</button>
							</div>
						</div>
					</figure>
				</section>

				<div class="goTop">
					<a href="#" class="goTopBtn jq-goTop"><i class="fas fa-arrow-alt-circle-up fa-3x"></i> </a>
				</div>

			</div>
			<!-- 你可能也喜歡以下-->
			<section class="py-5 bg-light">
				<div class="container px-4 px-lg-5 mt-5">
					<h2 class="fw-bolder mb-4">您可能也喜歡以下車款</h2>
					<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
						<!-- 推薦卡片欄-->
						<c:forEach var="randomCar" items="${SelectRandomCar}" varStatus="vs">
							<div class="col mb-5">
								<div class="card h-100">
									<!-- Sale badge-->
									<div class="badge bg-dark text-white position-absolute"
										style="top: 0.5rem; right: 0.5rem">Sale</div>
									<!-- Product image-->
									<img class="card-img-top" src="/carInfoImage.controller/${randomCar.carNo}" height="180px"
										alt="...">
									<!-- Product details-->
									<div class="card-body p-4">
										<div class="text-center">
											<p>上架日期: ${randomCar.announceDate}</p>
											<!-- Product name-->
											<h4 class="fw-bolder">${randomCar.carBrand}</h4>
											<!-- Product reviews-->
											<div class="d-flex justify-content-center fw-bold text-danger mb-2">
												<h5><b>${randomCar.carName}</b></h5>
											</div>
									<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
										<a href="/SelectCarByCarNo.controller/${randomCar.carNo}"
											class="btn btn-outline-dark mt-auto">點我看更多</a>
									</div>
										</div>
									</div>
									<!-- Product actions-->
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>

			<!--  footer -->
			<div id="footertext"></div>


			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
			<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
		</body>

		</html>