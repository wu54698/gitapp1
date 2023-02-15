<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>資車會統計圖表</title>

    <!-- Custom fonts for this template-->
    <link href="http://localhost:8080/iSpanCar/script/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="http://localhost:8080/iSpanCar/script/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
	<script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="http://localhost:8080/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="http://localhost:8080/iSpanCar/script/js/sb-admin-2.min.js"></script>

    <script src="https://kit.fontawesome.com/dbb4662278.js" crossorigin="anonymous"></script>
    <script type="text/javascript" charset="utf8"
        src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
</head>

<body id="page-top">
	<c:set value="${LoginOK}" var="login"/>
	<c:set value="${login.memberPosition.permissionsofposition}" var="memberPosition"/>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion bg-gradient-info"
            id="accordionSidebar">

            <!-- Sidebar - Brand 左上標誌 -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index" >
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fa-solid fa-car-rear"></i>
                </div>
                <div class="sidebar-brand-text mx-3">資車會<sup></sup></div>
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
            <div class="sidebar-heading">
                功能列表
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
             <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fa-solid fa-user"></i>
                    <span>會員</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
<!--                         <h6 class="collapse-header">Custom Components:</h6> -->
                        <a class="collapse-item" href="memberselectall.controller">會員資料</a>
                        <a class="collapse-item" href="memberposition.controller">權限設定</a>
                    </div>
                </div>
            </li> 
            
<!--             <li class="nav-item"> -->
<!--                 <a class="nav-link" href="memberselectall.controller"> -->
<!--                     <i class="fa-solid fa-user"></i> -->
<!--                     <span>會員</span></a> -->
<!--             </li> -->

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item"><a class="nav-link" href="findAllDealer.controller">
							<i class="fa-solid fa-car"></i> <span>車廠</span>
			</a></li>
        <li class="nav-item"><a class="nav-link" href="SelectAllCar.controller">
				<i class="fa-solid fa-car"></i> <span>車輛</span>
		</a></li>

            <!-- Divider -->
<!--             <hr class="sidebar-divider"> -->

<!--             Heading -->
<!--             <div class="sidebar-heading"> -->
<!--                 Addons  -->
<!--             </div>   -->

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="serviceAllController">
                    <i class="fa-solid fa-screwdriver-wrench"></i>
                    <span>保養廠</span></a>
            </li>

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="threadsView">
                    <i class="fa-brands fa-rocketchat"></i>
                    <span>論壇</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item"><a class="nav-link"
				href="iSpancarShop.ProductListAll"> <i
					class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

            <li class="nav-item">
                <a class="nav-link" href="orderBack">
                    <i class="fa-solid fa-coins"></i>
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

                    <div class="h4 mt-2 text-gray-800">資車國際</div>


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
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${login.memberName}</span>
                            <!-- 職位 -->
                                <input type="hidden" value="${login.accountnumber}" id="myAccountnumber">
                                <input type="hidden" value="${memberPosition.positionPk}" id="myPosition">
                                <input type="hidden" value="${memberPosition.permissionsInsert}" id="myPositionInsert">
                                <input type="hidden" value="${memberPosition.permissionsUpdate}" id="myPositionUpdate">
                                <input type="hidden" value="${memberPosition.permissionsDelete}" id="myPositionDelete">
                                <input type="hidden" value="${memberPosition.permissionsSelect}" id="myPositionSelect">
                                <img class="img-profile rounded-circle" id="myImage" src="/showimageforthismember.controller\?accountnumber=${login.accountnumber}">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    登出
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content 內容 -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
		                   <div class="col-sm-2 "> <h1 class="h3 mb-4 text-gray-800 d-inline-flex">統計圖表</h1></div>
		                   <div class="col-sm-10 ">
		                   		<button class="btn btn-info " type="button" onclick="location.href='/backstage/memberchartjs'">會員</button>
		                   		<button class="btn btn-info " type="button" onclick="location.href='/backstage/checkAnnounceDateChart.controller'">車輛</button>
		                   </div>
<!-- 		                   <div class="col-sm-1"><button class="update btn btn-info btn-circle" ><i class="fa-solid fa-pen btn-sm"></i></button></div> -->
					</div>
					<div class="row">
						<div class="col-sm-6 ">
						<canvas width="1000" height="700" id="memberchart1" style="display: block; box-sizing: border-box; height: 400px; width: 800px;"></canvas>
						</div>
						<div class="col-sm-6 ">
						<canvas width="1000" height="700" id="memberchart2" style="display: block; box-sizing: border-box; height: 400px; width: 800px;"></canvas>
						</div>
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
                    <a class="btn btn-primary" href="/logout.controller">登出</a></div>
<!--                 <div class="modal-footer"> -->
                   
<!--                 </div> -->
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
 
 <script>
	 $(function(){
		 //地區圓餅圖
		var ctx = $('#memberchart1');
		var locationarray = [];
		$.ajax({
			type:"GET",
			async: false,
			url:"/backstage/memberlocation.controller",
			dataType: 'json',
            success: function (response) {
            	locationarray = response;
           } ,
           error:function(xhr, ajaxOptions, thrownError){
               alert(xhr.status+"\n"+thrownError);
           }
		})
		console.log(locationarray)
		
 		var xValues =[];
 		var yValues =[];
		
 		locationarray.forEach(function(item){
 			xValues.push(item.city); 
 			yValues.push(item.cityNumber);
 		})
		
 		var barColors = [
 			  "#DC143C",
 			  "#FAEBD7",
 			  "#fa8072",
 			  "#ff8c00",
 			  "#FFFF00",
 			  "#daa520",
 			  "#FF5959",
 			  "#BD7B00",
 			  "#FF0080",
 			  "#EA7500"
 			];
 		new Chart(ctx, {
 			  type: "pie",
 			  data: {
 			    labels: xValues,
 			    datasets: [{
 			      backgroundColor: barColors,
 			      data: yValues
 			    }]
 			  },
 			  options: {
 			    title: {
 			      display: true,
 			      text: "會員地區分布",
 			      fontSize: 24
 			    }
 			  }
 			});
 		//折線圖-------------------------------
		var memberAmount = [];
		var sixmonth = [];
				$.ajax({
					type:"GET",
					async: false,
					url:"/backstage/memberamount.controller",
					dataType: 'json',
		            success: function (response) {
		            	memberAmount = response;
		           } ,
		           error:function(xhr, ajaxOptions, thrownError){
		               alert(xhr.status+"\n"+thrownError);
		           }
				})
 		//判斷現在幾月
 		var Today = new Date();
		var TodayMonth = Today.getMonth()+1;
		var lastsixmonth = [7,8,9,10,11,12];
		if(TodayMonth >= 6){
			for(let i = 5; i <= 0; i--){
				sixmonth.push(TodayMonth - i);
			}
		}else{
			for(let i = TodayMonth;i <=5;i++){
				sixmonth.push(lastsixmonth[i]);
			}
			for(let i = 1; i <=TodayMonth;i++ ){
				sixmonth.push(i);
			}
		}
		var mounthAmount = [0,0,0,0,0,0];
		console.log(sixmonth)
		sixmonth.forEach(function(sixitem,index){
	 		memberAmount.forEach(function(item){//拿會員登入月份
	 			let monthstring = item.logindate.substring(5,7);
	 			if(item.logindate.substring(5,7)[0] == 0){
	 				monthstring = monthstring[1];
	 			}else{
	 				monthstring = monthstring;
	 			}
	 			if(monthstring == sixitem){
	 				mounthAmount[index] = mounthAmount[index] + 1;
	 			}
	 		})
		})
		Array.prototype.max = function () {
            return Math.max.apply({}, this)
        }
 		var ctx2 = document.getElementById('memberchart2').getContext('2d');
        new Chart(ctx2, {
            type: 'line',
            data: {
                labels: sixmonth,
                datasets: [{
                    label: '會員人數',
                    data: mounthAmount,
                    fill: false,
                    borderColor: 'rgb(75, 192, 192)',
                }]
            },
            options: {
                title: {
                  display: true,
                  text: '每月會員成長人數',
                  fontSize: 24
                },
                legend:{ 
                  labels: { 
                    fontColor: 'rgb(0, 0, 0)',
                    usePointStyle: true
                  } 
                },
                scales: {
                  // 各軸標題設定
                  // https://www.chartjs.org/docs/latest/axes/labelling.html
                  // 各軸格線設定
                  // https://www.chartjs.org/docs/latest/axes/styling.html
                  // x 軸設置
                  xAxes: [{
                    // x 軸標題
                    scaleLabel:{
                      display: true,
                      labelString:"月份",
                      fontSize: 16
                    },
                    // x 軸格線
                    gridLines: {
                      display: true
                    }
                  }],
                  // y 軸設置
                  yAxes: [{
                    // y 軸標題
                    scaleLabel:{
                      display: true,
                      labelString:"數量",
                      fontSize: 16
                    },
                    // y 軸格線
                    gridLines: {
                      display: false
                    },
                    // y 軸間距
                    ticks: {
                      min: 0,
                      max: mounthAmount.max()
                    }
                  }]
                }
               }
        });

	 })
 </script>
</body>
</html>