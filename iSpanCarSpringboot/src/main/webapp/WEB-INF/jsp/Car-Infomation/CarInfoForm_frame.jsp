<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Blank</title>

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
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
</head>

<body id="page-top">
	<c:set value="${LoginOK}" var="login" />
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion bg-gradient-info"
			id="accordionSidebar">

			<!-- Sidebar - Brand 左上標誌 -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/index">
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
			<li class="nav-item">
                <a class="nav-link" href="/backstage/memberchartjs">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>統計圖表</span></a>
            </li>

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
			<li class="nav-item"><a class="nav-link"
				href="findAllDealer.controller"><i class="fa-solid fa-car"></i><span>車廠</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="SelectAllCar.controller"> <i class="fa-solid fa-car"></i>
					<span>車輛</span></a></li>

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
				href="iSpancarShop.ProductListAll"> <i
					class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

			<li class="nav-item"><a class="nav-link"
				href="orderQueryAll.controller"> <i
					class="fa-solid fa-coins"></i> <span>訂單</span>
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
								src="/showimageforthismember.controller\?accountnumber=${login.accountnumber}">
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
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">管理者功能: 車輛品牌產品維護</h1>
					<form name="carInfoA" action="" method="post"
						enctype="multipart/form-data" id="addCarForm">
						<table border="1" id="insertP">
							<thead>
								<tr bgcolor='transparent'>
									<th height="60" colspan="2" align="center">
										<h2>
											<b>--在店潮車。實車實價。車況保證--</b>
										</h2>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var='addCar' items='${addCar}' varStatus="vs">
									<!--             <tr bgcolor='transparent'> -->
									<!--                 <td width="120" height="40">車輛編號</td> -->
									<%--                 <td width="600" height="40" align="left"><input id="carNo" name="carNo" class="checkNotNull" value="${param.carNo}" --%>
									<!--                         type="text" size="14" style="text-align: left"></td> -->
									<!--             </tr> -->
									<tr bgcolor='transparent'>
										<td width="120" height="40">車商名稱</td>
										<td width="600" height="40" align="left"><input
											id="carDealName" name="carDealName" class=""
											value="${addCar.carDealName}" type="text" size="14"
											style="text-align: left" readonly> <small><font
												color='red' size="-1">${ErrorMsg.carDealName}</font></small></td>

									</tr>
									<tr bgcolor='transparent'>
										<td width="120" height="40">帳號</td>
										<td width="600" height="40" align="left"><input
											id="accountNumber" name="accountNumber" class="accountNumberCheck"
											value="${login.accountnumber}" type="text" size="14"
											style="text-align: left"><span></span></td>
									</tr>
									<!-- 									<tr bgcolor='transparent'> -->
									<!-- 										<td width="120" height="40">帳號</td> -->
									<!-- 										<td width="600" height="40" align="left"><input -->
									<!-- 											id="accountNumber" name="accountNumber" class="checkNotNull" -->
									<%-- 											value="${login.accountnumber}" type="text" size="14" --%>
									<!-- 											style="text-align: left"></td> -->
									<!-- 									</tr> -->
									<tr bgcolor='transparent'>
										<td width="120" height="40">車輛品牌</td>
										<td width="600" height="40" align="left"><input
											id="carBrand" name="carBrand" class="carBrandCheck"
											value="${param.carBrand}" type="text" size="14"
											style="text-align: left"><span></span></td>
									</tr>
									<tr bgcolor='transparent'>
										<td width="120" height="40">車輛名稱</td>
										<td width="600" height="40" align="left"><input
											id="carName" name="carName" class="carNameCheck"
											value="${param.carName}" type="text" size="14"
											style="text-align: left"><span></span></td>
									</tr>
									<tr bgcolor='transparent'>
										<td width="120" height="40">庫存</td>
										<td width="600" height="40" align="left"><input
											id="stock" name="stock" class="stockCheck"
											value="${param.stock}" type="text" size="14"
											style="text-align: left"><span></span></td>
									</tr>
									<tr bgcolor='transparent'>
										<td width="120" height="80">車輛描述</td>
										<td width="600" height="40" align="left"><textarea
												id="carDescription" name="carDescription"
												class="carDescriptionCheck"
												cols="30" rows="10" style="text-align: left"></textarea><span></span></td>
									</tr>
									<tr bgcolor='transparent'>
										<td width="120" height="40">車輛照片(主圖，一張)</td>
										<td width="600" height="40" align="left"><input
											id="carImage" name="carImage" class="carImageCheck"
											value="${param.carImage}" type="file"><span></span></td>
									</tr>
									<tr bgcolor='transparent'>
										<td width="120" height="40">車輛照片(副圖，多張)</td>
										<td width="600" height="40" align="left"><input
											id="carMultiImage" name="multiImages" class="carImageCheck"
											value="${param.carImage}" type="file" multiple><span></span></td>
									</tr>
									<tr>
									<tr>
										<td width="120" height="40">發布日期</td>
										<td width="600" height="40" align="left"><input
											id="announceDate" name="announceDate" class="announceDateCheck"
											value="${param.announceDate}" type="text" size="14"
											style="text-align: left"> <font color='blue'
											size="-1">&nbsp;&nbsp;格式為MM-dd-yyyy</font></td>
									</tr>
									<tr bgcolor='transparent'>
										<td height="50" colspan="2" align="center"><input
											type="button" value="新增" id="addCar" class="btn btn-info">
										<input type="button" value="一鍵輸入" id="inputForm" class="btn btn-info"></input>
										</td>
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
						href="/logout.controller">登出</a>
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
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#announceDate").datepicker();
		});

		//驗證不得為空值
		  
		  $('#addCar').on('click', function(){
			let wrong = '<i class="fa-regular fa-circle-xmark"></i>'
			let carBrandCheck = $('.carBrandCheck').val();
			let carNameCheck = $('.carNameCheck').val();
			let stockCheck = $('.stockCheck').val();
			let carDescriptionCheck = $('.carDescriptionCheck').val();
			let carImageCheck = $('.carImageCheck').val();
			let announceDateCheck = $('.announceDateCheck').val();
			if((carBrandCheck && carNameCheck && stockCheck && carDescriptionCheck && carImageCheck && announceDateCheck) != ""){
				$('.carBrandCheck').next().empty();
				$('.carNameCheck').next().empty();
				$('.stockCheck').next().empty();
				$('.carDescriptionCheck').next().empty();
				$('.carImageCheck').next().empty();
				$('.announceDateCheck').next().empty();
				verifyok = true;
			}else{
				$('.carBrandCheck').next().css('color', 'red').html(wrong + '必填')
				$('.carNameCheck').next().css('color', 'red').html(wrong + '必填')
				$('.stockCheck').next().css('color', 'red').html(wrong + '必填')
				$('.carDescriptionCheck').next().css('color', 'red').html(wrong + '必填')
				$('.carImageCheck').next().css('color', 'red').html(wrong + '必填')
				$('.announceDateCheck').next().css('color', 'red').html(wrong + '必填')
	            verifyok = false;
			}
		})
		
		//新增車輛
		$('#addCar').on({
			'click' : function() {
// 				$('.checkNotNull').attr('required', true)
				var addCarForm = $('#addCarForm')
			console.log(addCarForm)
			var fromData = new FormData(addCarForm[0])
			console.log(fromData)
			var carDealName = $('#carDealName').val()
			$.ajax({
				type: "POST",
				url: "addCarInfo.controller",
				//contentType text
				dataType: "text",
				data: fromData,
				processData: false,
				contentType : false,
				success: function (response) {
					console.log("OK")
					location.href = 'SelectCarInOneSeller.controller/' + carDealName
				},
// 				error:function(xhr, ajaxOptions, thrownError){
	           	 
// 	                alert(xhr.status+"\n"+thrownError);
// 	            }
			})
			}
		});
		
		//一鍵輸入
		$('#inputForm').on('click', function(){
			$('#carBrand').val('MG汽車')
			$('#carName').val('2023 MG HS')
			$('#stock').val('1')
			$('#carDescription').val('2023年式。無肇事、泡水車紀錄。原廠保養。女用。價格面議')
			$('#announceDate').val('02/13/2023')
		})
		
		
	</script>

</body>

</html>