<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Blank</title>
<c:set value="${LoginOK}" var="login" />
<!-- Custom fonts for this template-->
<link
	href="http://localhost:8080/iSpanCar/script/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="http://localhost:8080/iSpanCar/script/css/sb-admin-2.min.css"
	rel="stylesheet">
<link href="http://localhost:8080/iSpanCar/script/css/order.css"
	rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">

<style type="text/css">


.paidSate {
  font-weight: bold;
  margin: 10px; 

  display: inline-block;
  vertical-align: middle;
  border-top: 2px solid;
  border-left: 2px solid;
  border-right: 2px solid;
  border-bottom: 2px solid;
}

.title-container {
  text-align: center;
}

.title-container h1 {
  display: inline-block;
  margin: 0 auto;
  float: none;
}

.title-container img {
  float: right;
}
</style>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion bg-gradient-info"
			id="accordionSidebar">

			<!-- Sidebar - Brand 左上標誌 -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index">
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
			<li class="nav-item"><a class="nav-link" href="/"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
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
			<li class="nav-item"><a class="nav-link"
				href="memberselectall.controller"> <i class="fa-solid fa-user"></i>
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
			<li class="nav-item"><a class="nav-link"
				href="serviceAllController"> <i
					class="fa-solid fa-screwdriver-wrench"></i> <span>保養廠</span>
			</a></li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="threadsView">
					<i class="fa-brands fa-rocketchat"></i> <span>論壇</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/iSpancarShop.ProductListAll'/>"> <i
					class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/orderQueryAll.controller'/>"> <i
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
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<div class="h4 mt-2 text-gray-800">訂單列表管理</div>


					<!-- Topbar Navbar 右邊頭像 -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${login.accountnumber}</span>
								<!-- 職位 --> <input type="hidden" value="${login.accountnumber}"
								id="myAccountnumber"> <input type="hidden"
								value="${memberPosition.positionPk}" id="myPosition"> <input
								type="hidden" value="${memberPosition.permissionsInsert}"
								id="myPositionInsert"> <input type="hidden"
								value="${memberPosition.permissionsUpdate}"
								id="myPositionUpdate"> <input type="hidden"
								value="${memberPosition.permissionsDelete}"
								id="myPositionDelete"> <input type="hidden"
								value="${memberPosition.permissionsSelect}"
								id="myPositionSelect"> <img
								class="img-profile rounded-circle" id="myImage"
								src="showimageforthismember.controller?accountnumber=${login.accountnumber}">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
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
							</div></li>

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
				 <div style="text-align: center; padding: 20px 20px;">
				 <div  class="title-container">
<h1>Orders列表管理</h1>   <a href="http://localhost:8080/backstage/orderChart">
  <img src="/static/iSpanCar/script/img/statistics.png" alt="圖片說明" width="100" height="100">
</a>
</div>

<table id="table_id" class="display">  
    <thead>
      <tr>
        <th>狀態</th>
        <th>建立者</th>
        <th>訂單編號</th>
        <th>總計</th>
        <th>下單時間</th>
        <th>更改時間</th>
        <th>觀看</th>
      </tr>
    </thead>
    <tbody>
    					<c:forEach var="order" varStatus="statusX" items="${AllOrder}">
      <tr>
<td class="paidSate">${order.paidSate}</td>
        <td>${order.accountnumber}</td>
        <td>${order.orderId }</td>
        <td class="total-price">${order.totalPrice }</td>
        <td class="order-date">${order.orderDate }</td>
        <td class="newdate">${order.newDate }</td>
        <td>
        <form method="post" action="orderEdit" style="display: inline-block;">
  <input type="hidden" name="orderId" value="${order.orderId}">
        <button id="watch" >
  <i class="fa-solid fa-eye"></i>
</button>
</form></td>
      </tr>
      </c:forEach>

<!-- <tr><td>1</td></tr> -->
    </tbody>
</table>
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
			<a class="scroll-to-top rounded" href="#page-top"> <i
				class="fas fa-angle-up"></i>
			</a>

			<!-- Logout Modal-->
			<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">決定登出?</h5>
							<button class="close" type="button" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">取消</button>
							<a class="btn btn-primary"
								href="<c:url value='/logoutServlet.do' />">登出</a>
						</div>
						<!--                 <div class="modal-footer"> -->

						<!--                 </div> -->
					</div>
				</div>
			</div>

			<!-- Bootstrap core JavaScript-->
			<script
				src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
			<script
				src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
			<script src="https://kit.fontawesome.com/7065f74436.js"
				crossorigin="anonymous"></script>

			<!-- Core plugin JavaScript-->
			<script
				src="http://localhost:8080/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>

			<!-- Custom scripts for all pages-->
			<script
				src="http://localhost:8080/iSpanCar/script/js/sb-admin-2.min.js"></script>
				 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
			<script>
			$(document).ready( function () {
			    $('#table_id').DataTable(); 
			
			} );
			
			 var paidSates = document.getElementsByClassName("paidSate");
			  for (var i = 0; i < paidSates.length; i++) {
			    var paid = paidSates[i];
			    var color = "";
			    if (paid.textContent === "未支付") {
			      color = "red";
			    } else if (paid.textContent === "已支付") {
			      color = "green";
			    }
			    paid.style.color = color;
			  }
			  

			  var totalPrices = document.getElementsByClassName("total-price");
			  for (var i = 0; i < totalPrices.length; i++) {
			    var totalPrice = totalPrices[i];
			    totalPrice.textContent = totalPrice.textContent.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			  }
			  
			 
			  
			  var orderDates = document.getElementsByClassName("order-date");
			  for (var i = 0; i < orderDates.length; i++) {
			    var orderDate = orderDates[i];
			    var date = new Date(orderDate.textContent);
			    orderDate.textContent = date.getFullYear() + "-" + (date.getMonth() + 1).toString().padStart(2, "0") + "-" + date.getDate().toString().padStart(2, "0") + " " + date.getHours().toString().padStart(2, "0") + ":" + date.getMinutes().toString().padStart(2, "0");
			  }
			  
			  var newDates = document.getElementsByClassName("newdate");
			  for (var i = 0; i < newDates.length; i++) {
			    var newDate = newDates[i];
			    if (newDate.textContent) {

			    var dates = new Date(newDate.textContent);
			    newDate.textContent = dates.getFullYear() + "-" + (dates.getMonth() + 1).toString().padStart(2, "0") + "-" + dates.getDate().toString().padStart(2, "0") + " " + dates.getHours().toString().padStart(2, "0") + ":" + dates.getMinutes().toString().padStart(2, "0");
			    }}
			  
			  function showOrderDetails(element) {
				  const orderId = element.dataset.orderId;
				  const xhr = new XMLHttpRequest();
				  xhr.open("POST", "/orderEdit", true);
				  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				  xhr.onreadystatechange = function() {
				    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
				    }
				  };
				  xhr.send(`orderId=${orderId}`);
				}
			  
</script>
</body>

</html>