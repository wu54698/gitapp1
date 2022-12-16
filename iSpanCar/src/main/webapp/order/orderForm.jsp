<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Order Form</title>

    <!-- Custom fonts for this template-->
    <link href="http://localhost:8080/iSpanCar/script/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="http://localhost:8080/iSpanCar/script/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="http://localhost:8080/iSpanCar/script/css/order.css" rel="stylesheet">


</head>

<body id="page-top">
<c:set value="${LoginOK}" var="login"/>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion bg-gradient-info"
            id="accordionSidebar">

            <!-- Sidebar - Brand 左上標誌 -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../index.jsp" >
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fa-solid fa-car-rear"></i>
                </div>
                <div class="sidebar-brand-text mx-3">資車會<sup></sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                功能列表
            </div>

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
            <li class="nav-item"><a class="nav-link" href="<c:url value='/memberSelectAll.do'/>">
					<i class="fa-solid fa-user"></i> <span>會員</span>
			</a></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/Car-Dearler/CarDealerForm_frame.jsp' />"> <i
					class="fa-solid fa-car"></i> <span>車廠</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/Car-Infomation/CarInfoForm_frame.jsp' />"> <i
					class="fa-solid fa-car"></i> <span>車輛</span></a></li>

			<!-- Divider -->
			<!-- <hr class="sidebar-divider"> -->

			<!-- Heading -->
			<!-- <div class="sidebar-heading">
                Addons
            </div> -->

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link" href="<c:url value='/serviceSelectallServlet.do'/>">
					<i class="fa-solid fa-screwdriver-wrench"></i> <span>保養廠</span>
			</a></li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="<c:url value='/dforum/threads.jsp'/>">
					<i class="fa-brands fa-rocketchat"></i> <span>論壇</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/ProductListServlet.do'/>"> <i
					class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

            <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/ispan_car/order/order.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>訂單</span></a>
            </li>
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

                    <div class="h4 mt-2 text-gray-800"></div>


                    <!-- Topbar Navbar 右邊頭像 -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
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
                        <li class="nav-item dropdown no-arrow">
                            <a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${login.accountnumber}</span> <img
								class="img-profile rounded-circle"
								src="<c:url value='/ImageServletforPage.do'/>">
						</a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
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
                    <!-- <div class="wrap">
                        <div class="search">
                            <input class="search-bar" type="text" name="search" id="search" placeholder="搜尋">
                            <button class="search-btn"><i class="fas fa-search"></i></button>

                            <select class="search-sel">
                                <option>請選擇搜尋條件</option>
                                <option>產品編號</option>
                                <option>會員編號</option>
                                <option>訂單編號</option>
                            </select>
                            <button class="search-btn-updata" id="add">新增</button>
                            <button class="search-btn-delect" id="del">刪除</button>
                            <button class="search-btn-revise">修改</button>


                        </div>

                    </div> -->

                    <!-- /.container-fluid -->

                </div>

                <!-- End of Main Content -->

                <!-- Footer -->
                <!-- <footer class="sticky-footer bg-white"> -->
                <!-- <div class="container my-auto"> -->
                <!-- <div class="copyright text-center my-auto"> -->
                <!-- <span>Copyright &copy; Your Website 2020</span>  -->
                <!-- </div> -->
                <!-- </div> -->
                <!-- </footer> -->
                <!-- End of Footer -->
                <div class="container">

                    <form action="<c:url value='/OrderInsertServlet.do'/>" style="margin: auto; width: 700px;" method="POST" enctype="multipart/form-data">
                        <div style="font-size:30px; ">訂單確認</div>
                        <table>
                            <tr>
                                <td> 訂購日期 </td>
                                <!-- <td><input style="border-style:none" type="text" name="" id="orderDate"></td> -->
                                <td>
                                    <span id="orderDate"></span>
                                </td>

                            </tr>
                            <tr>
                                <td>收件資料</td>
                            </tr>
                            
                            <tr style="padding: 1pX;">
                                <td> 姓名 </td>
                                <td><input type="text" name="orderName" id="" value="${login.memberName}"></td>
                            </tr>
                            <tr>
                                <td> 連絡電話 </td>
                                <td><input type="text" name="orderPhone" id="" value="${login.phonenumber}"></td>
                            </tr>
                            <tr>
                                <td> 收件地址 </td>
                                <td><input type="text" name="deliveryAddress" id=""></td>
                            </tr>
                            <tr>
                                <td> 訂購明細 </td>
                            </tr>
                            <tr>
                                <td>商品編號</td>
                                <td>商品名稱</td>
                                <td>商品價格</td>
                                <td>購買數量</td>
                            </tr>
                            
                            <c:forEach var="cart" varStatus="statusX" items="${AllCartById}">
                            	
                                <tr>                               							
                                    <td ><input type="hidden" name="productNumber[]" style="display: none" value="${cart.productNumber}" >${cart.productNumber}</td>
                                    <td ><input type="hidden" name="productName[]" style="display: none" value="${cart.productName}" >${cart.productName}</td>
                                    <td class="price"><input type="hidden" name="productPrice[]" style="display: none" value="${cart.productPrice}" >${cart.productPrice}</td>
                                    <td class="quantity"><input type="hidden" name="quantity[]" style="display: none" value="${cart.quantity}">${cart.quantity}</td>
                                    <td><input type="hidden" name="memberId" style="display: none" value="${cart.memberId}" ></td>
                                    <td><input type="hidden" name="cartId" style="display: none" value="${cart.cartId}" ></td>
                                  <td><input type="hidden" name=orderStatus style="display: none" value="未支付" ></td>
                        
                                </tr>
						
                            </c:forEach>	
                            <tr>
                           
                                <td>本次訂單金額:<input style= "background-color:transparent;border:0;" type="text" name="totalPrice" id="total"></td>
                        
                            </tr>
                            <tr>
                                <td><select required class="paidMethod" name="paidMethod">
                                        <option>請選擇付費方式</option>
                                        <option>貨到付款</option>
                                        <option>信用卡</option>
                                        <option>LINE PAY</option>

                                    </select></td>
                            </tr>
                        </table>
                        <input type="submit" value="確認送出" />
                    </form>
                </div>
            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
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
        <script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/7065f74436.js" crossorigin="anonymous"></script>

        <!-- Core plugin JavaScript-->
        <script src="http://localhost:8080/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="http://localhost:8080/iSpanCar/script/js/sb-admin-2.min.js"></script>
        <script>

            $(document).ready(function () {
                Date1();
                initialize();
            });

            function Date1() {
                var Today = new Date();
                $('#orderDate').text(Today.getFullYear() + "-" + (Today.getMonth() + 1) + "-" + Today.getDate())
            }

            function initialize() {
                var totalPrice = 0;
                var cartnumber = $('.price').length;

                for (var a = 0; a <= cartnumber; a++) {
                    var quantity = Number($('.quantity').eq(a).text());
                    var price = Number($('.price').eq(a).text());
                    var smallTotal = quantity * price;
                    totalPrice = totalPrice + smallTotal;

                    var total = document.getElementById("total");
                    total.value = totalPrice;
                    console.log(totalPrice)
                }
            };
            $(function () {
// 	$('.paidSate1').on('click',function(){
// 	console.log($('.paidSate').val())
// 	})


            });
        </script>

</body>

</html>