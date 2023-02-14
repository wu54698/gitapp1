<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


			<!DOCTYPE html>
			<html lang="en">

			<head>

				<meta charset="utf-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
				<meta name="description" content="">
				<meta name="author" content="">

				<title>SB Admin 2 - Blank</title>
				<c:set value="${LoginOK}" var="login" />
				<!-- Custom fonts for this template-->
				<link href="http://localhost:8080/iSpanCar/script/vendor/fontawesome-free/css/all.min.css"
					rel="stylesheet" type="text/css">
				<link
					href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
					rel="stylesheet">

				<!-- Custom styles for this template-->
				<link href="http://localhost:8080/iSpanCar/script/css/sb-admin-2.min.css" rel="stylesheet">
				<link href="http://localhost:8080/iSpanCar/script/css/order.css" rel="stylesheet">
				<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
				<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>

				<style type="text/css">
					.fa-cart-shopping {
						font-size: 37px;
					}
					
/* 					.title-container { */
/*   display: flex; */
/*   align-items: center; */
/* } */

/* .title-container h1 { */
/*   margin-right: auto; */
/* } */

.title-container img {
    float: right;
        margin-top: -80px;
    
}
				</style>
			</head>

			<body id="page-top">

				<!-- Page Wrapper -->
				<div id="wrapper">

					<!-- Sidebar -->
					<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion bg-gradient-info"
						id="accordionSidebar">

						<!-- Sidebar - Brand 左上標誌 -->
						<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index">
							<div class="sidebar-brand-icon rotate-n-15">
								<i class="fa-solid fa-car-rear"></i>
							</div>
							<div class="sidebar-brand-text mx-3">
								資車會<sup></sup>
							</div>
						</a>

						<!-- Divider -->
						<hr class="sidebar-divider my-0">

						<!-- Nav Item - Dashboard -->
						
						<li class="nav-item"><a class="nav-link" href="/"> <i class="fas fa-fw fa-tachometer-alt"></i>
								<span>Dashboard</span>
							</a></li>  

						<!-- Divider -->
						<hr class="sidebar-divider">

						<!-- Heading -->
						<div class="sidebar-heading">功能列表</div>

						<!-- Nav Item - Pages Collapse Menu -->
						<!-- <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>會員</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Components:</h6>
                        <a class="collapse-item" href="buttons.html">Buttons</a>
                        <a class="collapse-item" href="cards.html">Cards</a>
                    </div>
                </div>
            </li> -->
						<li class="nav-item"><a class="nav-link" href="memberselectall.controller"> <i
									class="fa-solid fa-user"></i>
								<span>會員</span>
							</a></li>

						<!-- Nav Item - Utilities Collapse Menu -->
						<li class="nav-item"><a class="nav-link" href="CarDealerForm">
								<i class="fa-solid fa-car"></i> <span>車廠</span>
							</a></li>
						<li class="nav-item"><a class="nav-link" href="CarInfoForm">
								<i class="fa-solid fa-car"></i> <span>車輛</span>
							</a></li>

						<!-- Divider -->
						<!-- <hr class="sidebar-divider"> -->

						<!-- Heading -->
						<!-- <div class="sidebar-heading">
                Addons
            </div> -->

						<!-- Nav Item - Pages Collapse Menu -->
						<li class="nav-item"><a class="nav-link" href="serviceAllController"> <i
									class="fa-solid fa-screwdriver-wrench"></i> <span>保養廠</span>
							</a></li>

						<!-- Nav Item - Charts -->
						<li class="nav-item"><a class="nav-link" href="threadsView">
								<i class="fa-brands fa-rocketchat"></i> <span>論壇</span>
							</a></li>

						<!-- Nav Item - Tables -->
						<li class="nav-item"><a class="nav-link" href="<c:url value='/iSpancarShop.ProductListAll'/>">
								<i class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

						<li class="nav-item"><a class="nav-link" href="http://localhost:8080/orderBack"> <i
									class="fas fa-fw fa-table"></i> <span>訂單</span></a></li>
						<!-- Divider -->
						<hr class="sidebar-divider d-none d-md-block">

						<!-- Sidebar Toggler (Sidebar) -->
						<div class="text-center d-none d-md-inline">
							<button class="rounded-circle border-0" id="sidebarToggle"></button>
						</div>

					</ul>
					<!-- End of Sidebar -->

					<!-- Content Wrapper -->
					<div id="content-wrapper" class="d-flex flex-column">

						<!-- Main Content -->
						<div id="content">

							<!-- Topbar -->
							<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

								<div class="h4 mt-2 text-gray-800">訂單列表管理</div>


								<!-- Topbar Navbar 右邊頭像 -->
								<ul class="navbar-nav ml-auto">

									<!-- Nav Item - Search Dropdown (Visible Only XS) -->
									<li class="nav-item dropdown no-arrow d-sm-none"><a class="nav-link dropdown-toggle"
											href="#" id="searchDropdown" role="button" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false"> <i
												class="fas fa-search fa-fw"></i>
										</a> <!-- Dropdown - Messages -->
										<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
											aria-labelledby="searchDropdown">
											<form class="form-inline mr-auto w-100 navbar-search">
												<div class="input-group">
													<input type="text" class="form-control bg-light border-0 small"
														placeholder="Search for..." aria-label="Search"
														aria-describedby="basic-addon2">
													<div class="input-group-append">
														<button class="btn btn-primary" type="button">
															<i class="fas fa-search fa-sm"></i>
														</button>
													</div>
												</div>
											</form>
										</div>
									</li>

									<div class="topbar-divider d-none d-sm-block"></div>

									<!-- Nav Item - User Information -->
									<li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#"
											id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false"> <span
												class="mr-2 d-none d-lg-inline text-gray-600 small">${login.accountnumber}</span>
											<!-- 職位 --> <input type="hidden" value="${login.accountnumber}"
												id="myAccountnumber"> <input type="hidden"
												value="${memberPosition.positionPk}" id="myPosition"> <input
												type="hidden" value="${memberPosition.permissionsInsert}"
												id="myPositionInsert"> <input type="hidden"
												value="${memberPosition.permissionsUpdate}" id="myPositionUpdate">
											<input type="hidden" value="${memberPosition.permissionsDelete}"
												id="myPositionDelete"> <input type="hidden"
												value="${memberPosition.permissionsSelect}" id="myPositionSelect"> <img
												class="img-profile rounded-circle" id="myImage"
												src="showimageforthismember.controller?accountnumber=${login.accountnumber}">
										</a> <!-- Dropdown - User Information -->
										<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
											aria-labelledby="userDropdown">
											<a class="dropdown-item" href="#"> <i
													class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
											</a> <a class="dropdown-item" href="#"> <i
													class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
												Settings
											</a> <a class="dropdown-item" href="#"> <i
													class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
												Activity Log
											</a>
											<div class="dropdown-divider"></div>
											<a class="dropdown-item" href="#" data-toggle="modal"
												data-target="#logoutModal"> <i
													class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
												Logout
											</a>
										</div>
									</li>

								</ul>

							</nav>
							<!-- End of Topbar -->

							<!-- Begin Page Content 內容 -->
							<div class="container-fluid">

								<!-- Page Heading -->
								<!-- <h1 class="h3 mb-4 text-gray-800">功能名稱</h1> -->
								<div class="wrap">
									<div class="search">


									</div>

								</div>

								<!-- /.container-fluid -->

							</div>

							<!-- End of Main Content -->

							<!-- Footer -->
							<div class="container">
					<h2>Dashboard</h2>	
								<div class="row">
									<div class="col-sm-4">
										<div class="card">
											<div class="card-body">
												<h5 class="card-title">日銷售總額</h5>
												<p class="card-text" style="font-size: larger;"><i
														class="fa-solid fa-cart-shopping"></i>　$
													<fmt:formatNumber value="${todayTotalPrice}" type="currency"
														currencySymbol="$" pattern=",###,###" />
												</p>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="card">
											<div class="card-body">
												<h5 class="card-title">月銷售總額</h5>
												<p class="card-text" style="font-size: larger;"><i
														class="fa-solid fa-cart-shopping"></i>　$
													<fmt:formatNumber value="${thisMonthTotalPrice}" type="currency"
														currencySymbol="$" pattern=",###,###" />
												</p>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="card">
											<div class="card-body">
												<h5 class="card-title">年銷售總額</h5>
												<p class="card-text" style="font-size: larger;"><i
														class="fa-solid fa-cart-shopping"></i>　$
													<fmt:formatNumber value="${ yearTotalPrice}" type="currency"
														currencySymbol="$" pattern=",###,###" />
												</p>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6" style="margin-top:20px;">
										<div class="card">
											<div class="card-body">
												<h5 class="card-title">月銷售紀錄</h5>
												<canvas id="myChart"></canvas>
											</div>
										</div>
									</div>
									<div class="col-sm-6" style="margin-top:20px;">
										<div class="card">
											<div class="card-body">
												<h5 class="card-title">月銷售件數</h5>
												<canvas id="myChart2"></canvas>

											</div>
										</div>
									</div>
								</div>

							</div>
							<!-- End of Content Wrapper -->

						</div>
						<footer class="sticky-footer bg-white">
							<div class="container my-auto">
								<div class="copyright text-center my-auto">
									<!-- <span>Copyright &copy; Your Website 2020</span>  -->
								</div>
							</div>
						</footer>
						<!-- End of Footer -->
						<!-- End of Page Wrapper -->

						<!-- Scroll to Top Button-->
						<a class="scroll-to-top rounded" href="#page-top"> <i class="fas fa-angle-up"></i>
						</a>

						<!-- Logout Modal-->
						<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">決定登出?</h5>
										<button class="close" type="button" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">×</span>
										</button>
									</div>
									<div class="modal-body">
										<button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
										<a class="btn btn-primary" href="<c:url value='/logoutServlet.do' />">登出</a>
									</div>
									<!--                 <div class="modal-footer"> -->

									<!--                 </div> -->
								</div>
							</div>
						</div>

						<!-- Bootstrap core JavaScript-->
						<script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
						<script
							src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
						<script src="https://kit.fontawesome.com/7065f74436.js" crossorigin="anonymous"></script>

						<!-- Core plugin JavaScript-->
						<script
							src="http://localhost:8080/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>

						<!-- Custom scripts for all pages-->
						<script src="http://localhost:8080/iSpanCar/script/js/sb-admin-2.min.js"></script>
						<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
						<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
						<script>

														$.ajax({
															type: "GET",
															url: "/backstage/orderCharts",
															success: function (response) {
																console.log(response);
																// 將回傳的資料存到 JavaScript 變數中
																var orderData = response.ThisMonthOrders;
																var orderitem = response.OrderItemCollections;
																// 定義一個物件來儲存每日的資料

																var dailyData = {};

																// 將所有訂單的日期和總價統計到 dailyData 中
																for (var i = 0; i < orderData.length; i++) {
																	var orderDate = orderData[i].orderDate;
																	var totalPrice = parseFloat(orderData[i].totalPrice);
																	// 將 orderDate 轉換為只顯示年月日的格式
																	var dateKey = orderDate.substring(0, 10);
																	// 取得當前月份
																		// 如果 dailyData 中沒有對應的日期，則建立一個新的日期項目
																		if (!dailyData[dateKey]) {
																			dailyData[dateKey] = {
																				orderDate: dateKey,
																				totalPrice: 0
																			};
																		// 累加總價
																		dailyData[dateKey].totalPrice += totalPrice;
																	}
																}

																// 將 dailyData 中的資料轉換為陣列，方便在圖表中使用
																var chartData = [];
																for (var dateKey in dailyData) {
																	chartData.push	(dailyData[dateKey]);
																}

																// 將 chartData 按照日期排序
																chartData.sort(function (a, b) {
																	return new Date(a.orderDate) - new Date(b.orderDate);
																});

																// 建立圖表
																var ctx = document.getElementById("myChart").getContext("2d");
																var myChart = new Chart(ctx, {
																	type: "line",
																	data: {
																		labels: chartData.map(function (data) { return data.orderDate; }),
																		datasets: [
																			{
																				label: "銷售金額",
																				data: chartData.map(function (data) { return data.totalPrice; }),
																				backgroundColor: "rgba(255, 99, 132, 0.2)",
																				borderColor: "rgba(255, 99, 132, 1)",
																				borderWidth: 1
																			}
																		]
																	},
																	options: {

																		scales: {
																			yAxes: [
																				{
																					ticks: {
																						beginAtZero: true
																					}
																				}
																			]
																		}
																	}
																});
															}
														});


														
														function randomColor(alpha) {
															  var r = Math.floor(Math.random() * 256);
															  var g = Math.floor(Math.random() * 256);
															  var b = Math.floor(Math.random() * 256);
															  return "rgba(" + r + "," + g + "," + b + "," + alpha + ")";
															}
							$.ajax({
								url: "/backstage/orderCharts",
								type: "GET",
								success: function (result) {
									var orderDateToQuantity = result.OrderIdToQuantity;
									var orderDates = [];
									var quantities = [];

									for (var key in orderDateToQuantity) {
										orderDates.push(key);
										quantities.push(orderDateToQuantity[key]);
									}
									
									orderDates.sort(function(a, b){
										  return new Date(a) - new Date(b);
										});

										var sortedQuantities = [];
										for (var i = 0; i < orderDates.length; i++) {
										  sortedQuantities.push(orderDateToQuantity[orderDates[i]]);
										}
			
										var backgroundColor = [];
										var borderColor = [];

										for (var i = 0; i < quantities.length; i++) {
										  backgroundColor.push(randomColor(0.2));
										  borderColor.push(randomColor(1));
										}
									var ctx = document.getElementById("myChart2").getContext("2d");
									var myChart = new Chart(ctx, {
										type: 'bar',
										data: {
											labels: orderDates,
											  datasets: [{
											      label: '銷售數量',
											      data: quantities,
											      backgroundColor: backgroundColor,
											      borderColor: borderColor,
											      borderWidth: 1
											    }]
										},
										options: {
											scales: {
												yAxes: [{
													ticks: {
														beginAtZero: true
													}
												}]
											}
										}
									});
								}
							});
						</script>
			</body>

			</html>