<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>新增帳號</title>

    <!-- Custom fonts for this template-->
    <link href="http://localhost:8080/iSpanCar/script/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="http://localhost:8080/iSpanCar/script/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary" onload="createmonth(),creatyear()">

    <div class="container">
	
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <!-- <div class="col-lg-5 d-none d-lg-block bg-register-image"></div> -->
                    <div class="col-lg-2"></div>
                    <div class="col-lg-8">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form action="" method="POST" enctype="multipart/form-data" id="createAccountForm" class="user">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="accountnumber"
                                        name="accountnumber" placeholder="${login.accountnumber}" value="${param.accountnumber}">
                                    <span>需輸入6-20字</span><span id="response"></span>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="memberpassword" name="memberpassword" placeholder="密碼">
                                        <span>需輸入8-20字含英文大小寫</span>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="RepeatPassword" placeholder="再次確認密碼"><span></span>

                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="membername"
                                            name="membername" placeholder="姓名"  value="${param.membername}"><span></span>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="tel" class="form-control form-control-user" id="phonenumber"
                                            name="phonenumber" placeholder="電話" value="${param.phonenumber}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="email" name="email"
                                        placeholder="Email Address" value="${param.email}"><span></span>
                                </div>
                                <div class="form-group row">
                                    <div id="twzipcode" class=" col-sm-4 mb-sm-0"></div>
                                    <div class="col-sm-8 mt-2">
                                        <input type="text" class="form-control form-control-user " id="
                                        memberaddress" name="memberaddress" placeholder="地址" value="${param.memberaddress}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="platenumber"
                                            name="platenumber" placeholder="車牌" value="${param.platenumber}">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="idnumber"
                                            name="idnumber" placeholder="身分證" value="${param.idnumber}"><span></span>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control ml-3" for="year">生日</label>
                                    <select name="year" id="year" class="form-select form-control col-sm-3" selected="${param.year}"></select>

                                    <select name="month" id="month" onblur="createdate()"
                                        class="form-control col-sm-3" selected="${param.month}"></select>

                                    <select name="date" id="date" class="form-control col-sm-3" selected="${param.date}"></select>
                                </div>
                                <div class="form-group row" id="cardnumber">
                                    <div class="div-card col-sm-3">
                                        <input type="text" class="card-input2 form-control" maxlength="4"
                                            placeholder="信用卡號" name="card1" value="${param.card1}">
                                    </div>
                                    <div class="div-card col-sm-3">
                                        <input type="text" class="card-input2 form-control" maxlength="4"
                                            placeholder="信用卡號" name="card2" value="${param.card2}">
                                    </div>
                                    <div class="div-card col-sm-3">
                                        <input type="text" class="card-input2 form-control" maxlength="4"
                                            placeholder="信用卡號" name="card3" value="${param.card3}">
                                    </div>
                                    <div class="div-card col-sm-3">
                                        <input type="text" class="card-input2 form-control" maxlength="4"
                                            placeholder="信用卡號" name="card4" value="${param.card4}">
                                    </div>
                                </div><span></span>
                                <div class="form-group">
                                    <input type="file" name="file" id="file" class="form-control">
                                </div>
                                <div id="imgshowbox">
                                    <img id="imgshow" src="" alt=""  />
                                </div>
								<input type="button" value='創建帳號' class="btn btn-primary btn-user btn-block" id="createAccount">
								<input type="button" value='一鍵輸入' class="btn btn-info btn-user btn-block" id="inputform">
<!--                                 <a href="#" class="btn btn-primary btn-user btn-block" id="createAccount"> -->
<!--                                     創建帳號 -->
<!--                                 </a> -->
						
                            </form>
                            <hr>
                            <!-- <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div> -->
                            <div class="text-center">
                                <a class="small" href= "<c:url value='/memberSelectAll.do'/>">已有帳號</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="http://localhost:8080/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="http://localhost:8080/iSpanCar/script/js/sb-admin-2.min.js"></script>
    <!-- 地址 -->
    <script src="https://cdn.jsdelivr.net/npm/jquery-twzipcode@1.7.14/jquery.twzipcode.min.js"></script>
    <!-- fontawson -->
    <script src="https://kit.fontawesome.com/dbb4662278.js" crossorigin="anonymous"></script>
    <script>//地址
        $("#twzipcode").twzipcode({
            zipcodeIntoDistrict: true,
            css: ["city form-control", "town form-control"],
            countyName: "city", // 自訂城市 select 標籤的 name 值
            districtName: "town" // 自訂地區 select 標籤的 name 值  
        });
    </script>
    <script src="http://localhost:8080/iSpanCar/script/js/birthday.js">//生日</script>
    <script src="http://localhost:8080/iSpanCar/script/js/verify.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/js/showimg.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    	<script> 
    $(function () {
    
	    $(document).ready(function () {
	        $('#accountnumber').keyup(function () {
	        	if(($('#accountnumber').val().length >= 6) && ($('#accountnumber').val().length <= 20)){
		            $.ajax({
		                type: 'POST',
		                url: "<c:url value='/checkAccountnumberServlet.do'/>",
		                dataType: 'text',
		                data:{ accountnumber : $('#accountnumber').val()},
		                success: function (response) {
		                	if(response=='帳號已存在'){
		                		$('#response').css('color','red').html("<i class='fa-regular fa-circle-xmark'></i>"+response)
		                		accountnumberok2 = false;
		                	}else{
		                		$('#response').css('color','green').html("<i class='fa-regular fa-circle-check'></i>");
		                		accountnumberok2 = true;
		                	}
		                    
		                } ,
		                error:function(xhr, ajaxOptions, thrownError){
		                	 
		                    alert(xhr.status+"\n"+thrownError);
		                }
		            })
	        	}else{
	        		$('#response').empty()
	        	}
	       	 })
    	})
    	$('#createAccount').on('click', function () {
        if (accountnumberok && password1ok && password2ok && idnumberok && emailok && membernameok && cardok && accountnumberok2) {
            $('#createAccountForm').attr('action', 'http://localhost:8080/iSpanCar/memberInsertServlet.do');
            $('#createAccount').attr('type','submit');
        }

	    })
	    
	    $('#inputform').on('click',function(){
	            $('#accountnumber').val('andy888')
	            $('#memberpassword').attr('value','Dd123456')
	            $('#RepeatPassword').attr('value','Dd123456')
	            $('#membername').attr('value','andy')
	            $('#phonenumber').attr('value','0955662778')
	            $('#email').attr('value','andy888@gmail.com')
	            $('#memberaddress').attr('value','新生路2段421號')
	            $('#platenumber').attr('value','V6-8929')
	            $('#idnumber').attr('value','H173107890')
	            // $('#accountnumber').attr('value','777')
	            // $('#accountnumber').attr('value','777')
	     })
	   
    	
    })

	</script>
</body>
</html>