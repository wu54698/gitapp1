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

    <title>資車會</title>

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
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index" >
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fa-solid fa-car-rear"></i>
                </div>
                <div class="sidebar-brand-text mx-3">資車會<sup></sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="/">
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
                <a class="nav-link" href="orderQueryAll.controller">
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
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${login.accountnumber}</span>
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
		                   <div class="col-sm-11 "> <h1 class="h3 mb-4 text-gray-800 d-inline-flex">會員權限 </h1></div>
		                   <div class="col-sm-1"><button class="update btn btn-info btn-circle" ><i class="fa-solid fa-pen btn-sm"></i></button></div>
					</div>
		<c:choose>
		<c:when test="${empty selectAll}">
			<h3>查無任何會員資料</h3>
		</c:when>
		<c:otherwise>
			<c:forEach var='permissions' items='${selectAll}' varStatus="vs">
				<c:if test="${vs.first}">
					<c:out escapeXml='false' value="<table id='table_id'>" />
					<thead>
						<tr>
							<th>身分</th>
							<th>新增</th>
							<th>修改</th>
							<th>刪除</th>
							<th>查詢</th>
						</tr>
					</thead>
				</c:if>
				<tr class="tr-block">
					
						<td class="accountnumber">${permissions.positionPk}</td>
						<td><input class="Insertbox mybox" type="checkbox" value="${permissions.permissionsInsert}"></td>
						<td><input class="Updatebox mybox" type="checkbox" value="${permissions.permissionsUpdate}"></td>
						<td><input class="Deletebox mybox" type="checkbox" value="${permissions.permissionsDelete}"></td>
						<td><input class="Selectbox mybox" type="checkbox" value="${permissions.permissionsSelect}"></td>
					
				</tr>
				<c:if test="${vs.last}">
					<c:out escapeXml='false' value='</table>' />
				</c:if>
			</c:forEach>
		</c:otherwise>

	</c:choose>
					
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
 
	 $(document).ready(function () {
	     $('#table_id').DataTable({
	    	"searching": false, //搜尋功能, 預設是開啟
   		    "paging": false, //分頁功能, 預設是開啟
   		    "ordering": false, //排序功能, 預設是開啟
   		 	"info": false	//頁面訊息功能, 預設是開啟
	     });
	 });
 
	 $(function(){
		 //用controller傳來的值判斷是否要打勾
		 function toCheck(){
			$('.Insertbox').each(function(){
				if($(this).val() == 1){
					$(this).prop('checked',true);
				}else{
					$(this).prop('checked',false);
				}
			})
			$('.Updatebox').each(function(){
				if($(this).val() == 1){
					$(this).prop('checked',true);
				}else{
					$(this).prop('checked',false);
				}
			})
			$('.Deletebox').each(function(){
				if($(this).val() == 1){
					$(this).prop('checked',true);
				}else{
					$(this).prop('checked',false);
				}
			})
			$('.Selectbox').each(function(){
				if($(this).val() == 1){
					$(this).prop('checked',true);
				}else{
					$(this).prop('checked',false);
				}
			})
		 }
		 toCheck();//執行
		 
		
		//一開始不能修改
		$('.mybox').attr('disabled','disabled');

		
		 //修改按鈕
			$('#content').on('click','.update',function(){
				var myPosition = $('#myPosition').val();
				if($.trim(myPosition) == 'manager'){
					$('.mybox').removeAttr('disabled');
					let buttonstring = "<button class='confirm btn btn-success btn-circle btn-sm'><i class='fa-solid fa-check'></i></button> <button class='cancel btn btn-danger btn-circle btn-sm'><i class='fa-solid fa-xmark'></i></button>"
			        $(this).parent().empty().append(buttonstring)
				}else{
					Swal.fire({
						  icon: 'error',
						  title: '無法修改',
						  text: '經理職位才可修改',
						  //footer: '<a href="">Why do I have this issue?</a>'
					})
				}
			})
		//取消按鈕
		 $('#content').on('click', '.cancel', function () {
			 $.ajax({
					type:'POST',
					context:this,
		            url:'memberpositioncancel.controller',
		            dataType:'json',
		            success: function (response) {
			            	$('.tr-block').each(function(i,e){
			            		$(this).find('.Insertbox').val(response[i].permissionsInsert);
			            		$(this).find('.Updatebox').val(response[i].permissionsUpdate);
			            		$(this).find('.Deletebox').val(response[i].permissionsDelete);
			            		$(this).find('.Selectbox').val(response[i].permissionsSelect);
			            	})
			            	toCheck();
		                } ,
		                error:function(xhr, ajaxOptions, thrownError){
		                    alert(xhr.status+"\n"+thrownError);
		                }
				 })
			 
			//按鈕變回修改
			 let buttonstring = "<button class='update btn btn-info btn-circle'><i class='fa-solid fa-pen btn-sm'></i></button>"
				 $('.mybox').attr('disabled','disabled');
				 $(this).parent().empty().append(buttonstring)
		 })
		//確認按鈕
		 $('#content').on('click', '.confirm', function () {
			 
			 let checkboxArray = [];
			 //tr
			 $('.tr-block').each(function(index){
				 let trObject = {};
				 trObject.positionPk = $(this).find('.accountnumber').text();
				 trObject.permissionsInsert = $(this).find('.Insertbox').val();
				 trObject.permissionsUpdate = $(this).find('.Updatebox').val();
				 trObject.permissionsDelete = $(this).find('.Deletebox').val();
				 trObject.permissionsSelect = $(this).find('.Selectbox').val();
				 console.log(trObject);
				 checkboxArray.push(trObject);
			 })

			 var jsonstr = JSON.stringify(checkboxArray);
			 
			 console.log(jsonstr);
			 
			 $.ajax({
				type:'POST',
				context:this,
			    contentType: "application/json",
	            url:'permissionupdate.controller',
	            dataType:'json',
	            data:jsonstr,
	            success: function (response) {
	                	console.log(response);
	                } ,
	                error:function(xhr, ajaxOptions, thrownError){
	                    alert(xhr.status+"\n"+thrownError);
	                }
			 })
			 
			 
			 //按鈕變回修改
			 let buttonstring = "<button class='update btn btn-info btn-circle'><i class='fa-solid fa-pen' btn-sm></i></button>"
				 $('.mybox').attr('disabled','disabled');
				 $(this).parent().empty().append(buttonstring)
		 })
			 
		 //改變value
		 $('#content').on('change','.mybox',function(){
			 if($(this).is(':checked')){
				$(this).val('1');
			 }else{
				 $(this).val('0');
			 }
		 })
		
	 })
 </script>
</body>
</html>