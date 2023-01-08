<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>商品列表</title>
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
<link
	href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css"
	rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
<style>
.container{
margin:30px ;
padding:0;
}
input{
border:0;
background-color:#2db5c2;
color:#fff;
border-radius:10px;
opacity:1;
}
input:hover{

opacity:0.6;
}
body{
  background:#1f1f1f;
}

.wrap{
  overflow:hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.35);
}

table{
  font-family: 'Oswald', sans-serif;
  border-collapse:collapse;

}

th{
  background-color:rgba(79,192,210,0.7);
  color:#ffffff;
  width:25vw;
  height:75px;
}

td{
  background-color:#363636;
  color:#ffffff;
  width:25vw;
  height:50px;
  text-align:center;
  transition: all 0.3s ease-in-out;
}

tr:hover td{
  background-color:#2a2a2a;
    transition: all 0.3s ease-in-out;
}

tr td:first-child{
  color:rgba(79,192,210,0.6);
  border-left:5px solid rgba(79,192,210,0.6);
    transition: all 0.3s ease-in-out;
}

tr:hover td:first-child{
  color:rgba(79,192,210,1);
  border-left:5px solid rgba(79,192,210,1);
    transition: all 0.3s ease-in-out;
}

tr{
  border-bottom: 1px solid #2a2a2a;
}

tr:last-of-type{
  border-bottom: none;
}

</style>
</head>

<body id="page-top">
<c:set value="${LoginOK}" var="login"/>
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion bg-gradient-info"
			id="accordionSidebar">

			<!-- Sidebar - Brand 左上標誌 -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
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
			<li class="nav-item"><a class="nav-link" href="index.html">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
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
			<li class="nav-item">
                <a class="nav-link" href="<c:url value='/memberSelectAll.do'/>">
                    <i class="fa-solid fa-user"></i>
                    <span>會員</span></a>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item"><a class="nav-link"
							href="<c:url value='/Car-Dearler/CarDealerForm_frame.jsp' />">
							<i class="fa-solid fa-car"></i> <span>車廠</span>
						</a></li>
            <li class="nav-item"><a class="nav-link"
							href="<c:url value='/Car-Infomation/CarInfoForm_frame.jsp' />">
					<i class="fa-solid fa-car"></i> <span>車輛</span>
						</a></li>

            <!-- Divider -->
            <!-- <hr class="sidebar-divider"> -->

            <!-- Heading -->
            <!-- <div class="sidebar-heading">
                Addons
            </div> -->

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/serviceSelectallServlet.do'/>">
                    <i class="fa-solid fa-screwdriver-wrench"></i>
                    <span>保養廠</span></a>
            </li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="<c:url value='/dforum/threads.jsp'/>">
					<i class="fa-brands fa-rocketchat"></i> <span>論壇</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/ProductListServlet.do'/>"> <i
					class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

			<li class="nav-item"><a class="nav-link" href="<c:url value='/QueryAllOrderServlet.do'/>">
					<i class="fa-solid fa-coins"></i> <span>訂單</span>
			</a></li>
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

					<div class="h4 mt-2 text-gray-800">資車國際</div>


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
								class="mr-2 d-none d-lg-inline text-gray-600 small">${login.accountnumber}</span> <img
								class="img-profile rounded-circle"
								src="<c:url value='/ImageServletforPage.do'/>">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
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
 				<div class="container"> 

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">商城</h1>
					<div class="wrap">
					<form action="<c:url value='/QueryAllCart.do'/>" method="get">
						<input type="submit" value="購物車" />
					</form>
					<table>
						<thead>
							<tr >
								<th style="text-align: center">產品編號</th>
								<th style="text-align: center">產品名稱</th>
								<th style="text-align: center">價格</th>
								<th style="text-align: center">產品圖片</th>
								<th style="text-align: center">購買數量</th>
								<th style="text-align: center">加入購物車</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var='product' items='${queryallproduct}'
								varStatus="vs">
								<tr>
								<form action="<c:url value='/CartInsertServlet'/>"  method="POST" enctype="multipart/form-data">
								
									<td id="productno">${product.productno} <input type="hidden" value="${product.productno}" name="productNumber"><input type="hidden" name="memberId" value="${login.accountnumber}"></td>
									<td >${product.productname}<input type="hidden" value="${product.productname}" name="productName"></td>
									<td >${product.price}<input type="hidden" value="${product.price}" name="productPrice"></td>
									<td><img
										src="<c:url value='/ProductImgServlet?productno=${product.productno}'/>"
										width="180" height="180" /></td>
									<td><input name="quantity" type="number" id="quantity" style="background-color:#6C7A89;width:55px;"></td>
									<td><input style="border-radius:80%;width:90px;height:60px" type="submit"  value="加入購物車" ></td>
								</form>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">決定登出?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body"> <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                    <a class="btn btn-primary" href="<c:url value='/logoutServlet.do' />">登出</a></div>
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

	<!-- Core plugin JavaScript-->
	<script
		src="http://localhost:8080/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="http://localhost:8080/iSpanCar/script/js/sb-admin-2.min.js"></script>

	<script src="https://kit.fontawesome.com/dbb4662278.js"
		crossorigin="anonymous"></script>


</body>

</html>