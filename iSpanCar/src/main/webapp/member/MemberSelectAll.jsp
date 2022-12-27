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
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/dforum/threads.jsp'/>">
                    <i class="fa-brands fa-rocketchat"></i>
                    <span>論壇</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item"><a class="nav-link"
				href="<c:url value='/ProductListServlet.do'/>"> <i
					class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/QueryAllOrderServlet.do'/>">
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
                                <img class="img-profile rounded-circle" src="<c:url value='/ImageServletforPage.do'/>">
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
                    <h1 class="h3 mb-4 text-gray-800">會員名稱</h1>
						
		<c:choose>
		<c:when test="${empty selectAll}">
			<h3>查無任何會員資料</h3>
		</c:when>
		<c:otherwise>
			<c:forEach var='member' items='${selectAll}' varStatus="vs">
				<c:if test="${vs.first}">
					<c:out escapeXml='false' value="<table id='table_id'>" />
					<thead>
						<tr>
							<th>${login.accountnumber}</th>
							<th>密碼</th>
							<th>姓名</th>
							<th>電話</th>
							<th>e-mail</th>
							<th>地址</th>
							<th>車牌</th>
							<th>生日</th>
							<th>身分證</th>
							<th>信用卡號</th>
							<th>圖</th>
							<th>修改</th>
							<th>刪除</th>
						</tr>
					</thead>
				</c:if>
				
				<tr>
					
						<td class="accountnumber">${member.accountnumber}</td>
						<td>${member.memberpassword}</td>
						<td>${member.memberName}</td>
						<td>${member.phonenumber}</td>
						<td>${member.email}</td>
						<td>${member.memberaddress}</td>
						<td>${member.platenumber}</td>
						<td>${member.birthday}</td>
						<td>${member.idnumber}</td>
						<td>${member.cardnumber}</td>
						<td><form id="imgform" class="imgform" enctype="multipart/form-data"><label><input type='hidden' class='file' id='file' name='file' style='display:none' ><img id="imgshow" class="imgshow" src="<c:url value='/ImageServlet.do?accountnumber=${member.accountnumber}'/>"  width="120" height="120" /></label></form></td>
						<td class="button"><button class="update btn btn-info btn-circle"><i class="fa-solid fa-pen"></i></button></td>
						<td class="button"><button class="delete btn btn-danger btn-circle"><i class="fas fa-trash"></i></button></td>
					
					
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
                    <a class="btn btn-primary" href="<c:url value='/logoutServlet.do' />">登出</a></div>
<!--                 <div class="modal-footer"> -->
                   
<!--                 </div> -->
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
   
    <script>
        $(document).ready(function () {
            $('#table_id').DataTable();
        });
        
        $(function () {
			$('#content').on('click','.delete',function(){//刪除
				let account = $(this).closest('tr').children('.accountnumber').text();
				//console.log(account);
						Swal.fire({
						  title: '確定刪除?',
						  text: "資料將被刪除",
						  icon: 'warning',
						  showCancelButton: true,
						  confirmButtonColor: '#3085d6',
						  cancelButtonColor: '#d33',
						  confirmButtonText: '刪除',
						  cancelButtonText: '取消'
						}).then((result) => {
						  if (result.isConfirmed) {
						    Swal.fire(
						      'Deleted!',
						      'Your file has been deleted.',
						      'success'
						    )
						    $.ajax({
				                type: 'POST',
				                url: "<c:url value='/memberDelete.do'/>",
				                dataType: 'text',
				                async: false,
				                data:{ accountnumber : account },
				                success: function (response) {
				                	//alert(response);
				                	 
				                } ,
				                error:function(xhr, ajaxOptions, thrownError){
				                	 
				                    alert(xhr.status+"\n"+thrownError);
				                }
				            })
				            $(this).parent().parent().remove();
						  }
						})
				
	           
			})

			$('#content').on('click', '.update', function () {//修改按鈕
	               let test = $(this).closest('tr').children('.accountnumber').text();
	               console.log(test);
	
	               let array = [];
	
	               $(this).closest('tr').find('td:not(.button)').each(function (index, ele) {
	                   array.push($(this).text());
	               })//陣列中加入.not以外的內文
	               console.log(array)
	               for (let i = 1; i < array.length-1; i++) {
	                   let content = "<input type='text' size='7'class='form-control form-control-user updateinput' value='" + array[i] + "'>";
	                   $(this).closest('tr').children('td').eq(i).text("");
	                   $(this).closest('tr').children('td').eq(i).append(content);
	               }
	               //修改圖片
	               let imgtag = $(this).closest('tr').children('td').eq(array.length-1).html()
	               $(this).closest('tr').children('td').eq(array.length-1).find('.file').attr('type','file')
	               $(this).closest('tr').children('td').eq(array.length-1).find('label').attr('style','cursor:pointer')
	               
	               let buttonstring = "<button class='confirm btn btn-success btn-circle btn-sm'><i class='fa-solid fa-check'></i></button><br><br><button class='cancel btn btn-danger btn-circle btn-sm'><i class='fa-solid fa-xmark'></i></button>"
	               $(this).parent().empty().append(buttonstring)
	
	           })
	           $('#content').on('mouseover','.updateinput',function(){
		           var value = $(this).val()
		            $(this).parent().html('<textarea name="" class="textarea" cols="10" rows="3">'+value+'</textarea>')
		           
		        })
		        $('#content').on('mouseleave','.textarea',function(){
		       		var text = $(this).val();
		       		console.log(text)
		            $(this).parent().html("<input type='text' size='7'class='form-control form-control-user updateinput' value='"+text+"'>")
		        })
	         	
	           $('#content').on('change','.file',function(){
	        	 //獲取input file的files文件數組;
	        	    //$('#filed')獲取的是jQuery對象，.get(0)轉為原生對象;
	        	    //這邊預設只能選一個，但是存放形式仍然是數組，所以取第一個元素使用[0];
	        	   var imgshow = $(this).next('.imgshow')
	        	    var file = $(this).get(0).files[0];
	        	    //創建用來讀取此文件的對象
	        	    var reader = new FileReader();
	        	    //使用該對象讀取file文件
	        	    reader.readAsDataURL(file);
	        	    //讀取文件成功後執行的方法函數
	        	    reader.onload = function (e) {
	        	        //讀取成功後返回的一個參數e，整個的一個進度事件
	        	        console.log(e);
	        	        console.log(imgshow)
	        	        //選擇所要顯示圖片的img，要賦值給img的src就是e中target下result裡面
	        	        //的base64編碼格式的地址
	        	        imgshow.attr('src',e.target.result)
	        	     }
	           })
	           
	           
	           $('#content').on('click', '.cancel', function () {//修改取消
	               let buttonstring = "<button class='update btn btn-info btn-circle'><i class='fa-solid fa-pen'></i></button>"
	               let account = $(this).closest('tr').find('.accountnumber').text();
	               let imgshow = $(this).closest('tr').find('.imgshow')
	               let originimg = 
	   				$.ajax({
	   	                type: 'POST',
	   	             	context:this,
	   	                url: "<c:url value='/memberReturnUpdateCancel.do'/>",
	   	                dataType: 'json',
	   	             	async: false,
	   	                data:{ accountnumber : account },
	   	                success: function (response) {
	   	                	let member = response[0];
	   	                	$(this).parent().parent().children('td').eq(1).text(member.memberpassword)
	   	                	$(this).parent().parent().children('td').eq(2).text(member.memberName)
	   	                	$(this).parent().parent().children('td').eq(3).text(member.phonenumber)
	   	                	$(this).parent().parent().children('td').eq(4).text(member.email)
	   	                	$(this).parent().parent().children('td').eq(5).text(member.memberaddress)
	   	                	$(this).parent().parent().children('td').eq(6).text(member.platenumber)
	   	                	$(this).parent().parent().children('td').eq(7).text(member.birthday)
	   	                	$(this).parent().parent().children('td').eq(8).text(member.idnumber)
	   	                	$(this).parent().parent().children('td').eq(9).text(member.cardnumber)
	   	                	$(this).parent().empty().append(buttonstring)
	   	                	imgshow.attr('src',"http://localhost:8080/iSpanCar/ImageServlet.do?accountnumber="+member.accountnumber)
	   	                	$('.file').attr('type','hidden')
	               			$('label').attr('style','cursor:default')
	   	                } ,
	   	                error:function(xhr, ajaxOptions, thrownError){
	   	                	 
	   	                    alert(xhr.status+"\n"+thrownError);
	   	                }
	   	            })
	           })
	          
	           
	           $('#content').on('click', '.confirm', function () {//修改確認
	               	let buttonstring = "<button class='update btn btn-info btn-circle'><i class='fa-solid fa-pen'></i></button>"
	            	let account = $(this).closest('tr').find('.accountnumber').text();
	               	console.log(account)
	               	let memberarray = [];
	               	let memberbeanlength = 12;
	               	for(let i=1;i<(memberbeanlength -2) ;i++){
	               		memberarray.push($(this).closest('tr').children('td').eq(i).children().val());
	               	}
	               	$.ajax({
	   	                type: 'POST',
	   	             	context:this,
	   	                //async: false,
	   	                url: "<c:url value='/memberReturnUpdate.do'/>",
	   	                dataType: 'json',
	   	                data:{ "accountnumber" : account,
	   	                		"memberpassword": memberarray[0],
	   	                		"memberName": memberarray[1],
	   	                		"phonenumber": memberarray[2],
	   	                		"email": memberarray[3],
	   	                		"memberaddress": memberarray[4],
	   	                		"platenumber": memberarray[5],
	   	                		"birthday": memberarray[6],
	   	                		"idnumber": memberarray[7],
	   	                		"cardnumber":memberarray[8]
	   	                },
	   	                success: function (response) {
	   	                	let member = response[0];
	   	                	$(this).parent().parent().children('td').eq(1).text(member.memberpassword)
	   	                	$(this).parent().parent().children('td').eq(2).text(member.memberName)
	   	                	$(this).parent().parent().children('td').eq(3).text(member.phonenumber)
	   	                	$(this).parent().parent().children('td').eq(4).text(member.email)
	   	                	$(this).parent().parent().children('td').eq(5).text(member.memberaddress)
	   	                	$(this).parent().parent().children('td').eq(6).text(member.platenumber)
	   	                	$(this).parent().parent().children('td').eq(7).text(member.birthday)
	   	                	$(this).parent().parent().children('td').eq(8).text(member.idnumber)
	   	                	$(this).parent().parent().children('td').eq(9).text(member.cardnumber)
	   	                	$(this).parent().empty().append(buttonstring)
	   	                	$('.file').attr('type','hidden')
	               			$('label').attr('style','cursor:default')
	   	                } ,
	   	                error:function(xhr, ajaxOptions, thrownError){
	   	                	 
	   	                    alert(xhr.status+"\n"+thrownError);
	   	                }
	   	            })
	               
	           })
	           //修改確認圖
	           $('#content').on('click', '.confirm', function () {
	        	   let account = $(this).closest('tr').find('.accountnumber').text();
	        	   let form = $(this).closest('tr').find('.imgform')
					
	        	   var formData = new FormData(form[0]);
// 	        	   formData.append("file",)
	        	   formData.append("accountnumber",account)
	        	   $.ajax({
	        		   type:"POST",
	        		   //async: false,
	        		   data:formData,
	        		   context:this,
	        		   url:"<c:url value='/memberUpdateimg.do'/>",
	        		   enctype:"multipart/form-data",
	        		   cache: false,
	        		   processData : false,  
	        		   contentType : false,
	        		   success: function (response) {
	   	                
	   	                } ,
	   	                error:function(xhr, ajaxOptions, thrownError){
	   	                	 
	   	                    alert(xhr.status+"\n"+thrownError);
	   	                }
	        	   })
	           })
	           
		
	})
    </script>

</body>

</html>