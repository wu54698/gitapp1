<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>所有產品列表</title>
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
	<style>
/* textarea { */
/* 	background:transparent;  */
/* 	border-style:none;  */
/* 	text-indent:75px; */
	
/* } */
.container{
margin:30px ;
padding:0;
}
.sendbtn{
border:0;
background-color:#2db5c2;
color:#fff;
border-radius:10px;
height:30px;
width:80px;
opacity:1;
}
.sendbtn:hover{
opacity:0.6;
}
.backshopbtn{
border:0;
background-color:#2db5c2;
color:#fff;
border-radius:8px;
height:40px;
width:122px;
opacity:1;
}
.backshopbtn:hover{
opacity:0.6;
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
					<h2>商城管理</h2>
					<%-- <a href="<c:url value='/SHOP_DETAIL/iSpanShopInsert.jsp' />">新增產品</a> --%>
					<div>
						<form action="<c:url value='/ProductListServlet.do'/>"
							method="POST">
							<input type="submit" value="回商城管理頁面" class="backshopbtn">
						</form>
						<form name="updateProductForm"
							action="<c:url value='/UpdateShopDetailServlet.do'/>"
							method="POST" enctype="multipart/form-data">
							<table border="1">
								<thead>
									<tr bgcolor='transparent'>
										<th height="60" colspan="2" align="center"><h2 style="margin:0 auto;"><b>修改產品資料</b></h2></th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var='sentno' items='${sentno}' varStatus="vs">
								
									<tr bgcolor='transparent'>
										<td width="130" height="40" style="text-align: center"><font size="4">產品編號</font></td>
										<td width="600" height="40" align="left"><input required readonly
											id='productno' style="text-align: left;background-color:LightGray;" name="productno"
											value="${sentno.productno}" type="text" size="14"></td>
									</tr>
									<tr bgcolor='transparent'>
										<td width="120" height="40" style="text-align: center"><font size="4">產品名稱</font></td>
										<td width="600" height="40" align="left"><input required
											id='productname' style="text-align: left;" name="productname"
											value="${sentno.productname}" type="text" size="30"></td>
									</tr>
									<!-- 				<tr bgcolor='tan'> -->
									<!-- 					<td width="120" height="40">種類:</td> -->
									<!-- 					<td width="600" height="40" align="left"><input id='type' -->
									<%-- 						style="text-align: left" name="type" value="${param.type}" --%>
									<!-- 						type="text" size="14"></td> -->
									<!-- 				</tr> -->
									<!-- 				<tr bgcolor='tan'> -->
									<!-- 					<td width="120" height="40">規格:</td> -->
									<!-- 					<td width="600" height="40" align="left"><input name="spec" -->
									<%-- 						value="${param.spec}" type="text" size="20"></td> --%>
									<!-- 				</tr> -->
									<tr bgcolor='transparent'>
										<td width="120" height="40" style="text-align: center"><font size="4">價 格</font></td>
										<td width="600" height="40" align="left"><input required
											name="price" value="${sentno.price}" type="text" size="14"></td>
									</tr>
									<tr bgcolor='transparent'>
										<td width="120" height="40" style="text-align: center"><font size="4">庫存數量</font></td>
										<td width="600" height="40" align="left"><input required
											name="stock" value="${sentno.stock}" type="text" size="14"></td>
									</tr>
									<!-- 				<tr bgcolor='tan'> -->
									<!-- 					<td width="120" height="40">上架日期:</td> -->
									<!-- 					<td width="600" height="40" align="left"><input name="uptime" -->
									<%-- 						value="${param.uptime}" type="text" size="14"><font --%>
									<!-- 						color='blue' size="-1">&nbsp;&nbsp;格式為yyyy-MM-dd</font></td> -->
									<!-- 				</tr> -->
									<tr bgcolor='transparent'>
										<td width="120" height="40" style="text-align: center"><font size="4">產品資訊</font></td>
										<td width="120" height="400" align="left"><textarea required
												rows="30" cols="90" name="productinfo">${sentno.productinfo}</textarea>
									</tr>
									<tr>
									<tr bgcolor='transparent'>
										<td width="120" height="40" style="text-align: center"><font size="4">產品圖片</font></td>
										<td width="600" height="40" align="left"><input 
											name="productimage" value="${sentno.productimage}" type="file">
									</tr>
									<tr bgcolor='transparent'>
										<td height="50" colspan="2" align="center"><input
											type="submit" value="送出" class="sendbtn"></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</form>
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
		<script type="text/javascript" charset="utf8"
			src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
		<script>
			$(document).ready(function() {
				$('#productlist').DataTable();
			});
		</script>
</body>

</html>