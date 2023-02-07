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

    <title>登入</title>

    <!-- Custom fonts for this template-->
    <link href="http://localhost:8080/iSpanCar/script/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="http://localhost:8080/iSpanCar/script/css/sb-admin-2.css" rel="stylesheet">
    <script src="https://apis.google.com/js/platform.js" async defer></script>

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">請輸入帳密</h1>
                                    </div>
                                    <form class="user" action="login" method="POST" id="login">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user" value="${param.accountnumber}"
                                                id="accountnumber" name ="username" aria-describedby="emailHelp"
                                                placeholder="請輸入帳號">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" value="${param.memberpassword}"
                                                id="memberpassword" name="password" placeholder="請輸入密碼">
                                        </div>
                                        <div class="form-group row">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck" name="rememberMe-key">
                                                <label class="custom-control-label mr-1" for="customCheck">Remember
                                                    Me</label>
                                             </div>
                                             <div class="custom-control custom-checkbox small">  
                                                <input type="checkbox" class="custom-control-input" id="showpassword" name="showpassword">
                                                <label class="custom-control-label" for="showpassword">顯示密碼</label>
                                            </div>
                                        </div>
                                        <input type="submit" class="btn btn-primary btn-user btn-block"  value="登入" id="check">
                                        <a href="/login/oauth2/authorization/google" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
<!--                                         https://accounts.google.com/o/oauth2/auth?response_type=token&redirect_uri=http://localhost:8080/login/oauth2/code/google&client_id=958888186961-cfm93ockmgmk3nhdiv0lmrrvs1fpv9ms.apps.googleusercontent.com&scope=openid profile email -->
                                    </form>
                                    <hr>
                                    <div class="row">
	                                    <div class="text-right col-lg-6">
	                                        <a class="small" href="forgot-password">忘記密碼?</a>
	                                    </div>
	                                    <div class="text-left col-lg-6">
	                                        <a class="small" href="memberInsert">創建帳號</a>
	                                    </div>
                                    </div>
                                </div>
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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script> 
	$(function () {
		$('#showpassword').on('change',function(){
			if($('#showpassword').is(':checked')){
				$('#memberpassword').prop('type','text');
			}else{
				$('#memberpassword').prop('type','password');
			}
		})

		
	    $(document).ready(function () {
	        $('#check').on('click',function (e) {
	        	console.log("check")
				$.ajax({
				    url: "checkAccountPassword.controller",
				    dataType: 'text',
				    type:'POST',
				    async:false,
				    data:{
				    	accountnumber : $("#accountnumber").val(),
				    	memberpassword : $("#memberpassword").val()
				    },
				    error: function(xhr) {
				        alert('Ajax request 發生錯誤');
				    },
				    success: function(response) {
				        if(response.trim() == "資料有誤") {
				        	e.preventDefault();
				        	Swal.fire({
				        		  icon: 'error',
				        		  title: '錯誤',
				        		  text: '帳號密碼錯誤，請重新輸入!',
				        		  footer: '<a href="memberInsert">沒有帳號? 創建帳號</a>'
				        		})
				        } else {
				        	Swal.fire({
				        		  position: 'center',
				        		  icon: 'success',
				        		  title: '驗證成功，即將登入首頁',
				        		  showConfirmButton: false,
				        		  timer: 1500
				        		})
				        	e.submit();
				        }
				    }
				})
	        })
	    })
	})
	</script>
</body>

</html>