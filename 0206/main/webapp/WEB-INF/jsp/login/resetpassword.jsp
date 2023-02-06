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

    <title>忘記密碼</title>

    <!-- Custom fonts for this template-->
    <link href="http://localhost:8080/iSpanCar/script/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="http://localhost:8080/iSpanCar/script/css/sb-admin-2.css" rel="stylesheet">

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
                            <div class="col-lg-6 d-none d-lg-block bg-password-image2"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">變更密碼</h1>
                                        <p class="mb-4">需輸入8-20字含英文大小寫</p>
                                    </div>
                                    <form class="user" method="POST" action="changepassword.controller" id="changepasswordForm">
                                    <input type="hidden" value="${accountnumber}" name="accountnumber" >
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" name="memberpassword" 
                                                id="memberpassword" aria-describedby="emailHelp"
                                                placeholder="輸入密碼">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" name="RepeatPassword" 
                                                id="RepeatPassword" aria-describedby="emailHelp"
                                                placeholder="再次輸入密碼">
                                        </div>
                                        <div class="form-group row">
                                             <div class="custom-control custom-checkbox small">  
                                                <input type="checkbox" class="custom-control-input" id="showpassword" name="showpassword">
                                                <label class="custom-control-label" for="showpassword">顯示密碼</label>
                                            </div>
                                        </div>
                                        <a href="" class="btn btn-primary btn-user btn-block" id="resetpwd">
                                            變更密碼
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="row">
	                                    <div class="text-right col-lg-6">
	                                        <a class="small" href="memberInsert">創建帳號</a>
	                                    </div>
	                                    <div class="text-left col-lg-6">
	                                        <a class="small" href="login">已有帳號</a>
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

	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- Custom scripts for all pages-->
    <script src="http://localhost:8080/iSpanCar/script/js/sb-admin-2.min.js"></script>
    
	<script type="text/javascript">
	
		$(function(){

			$('#showpassword').on('change',function(){
				if($('#showpassword').is(':checked')){
					console.log('tttt')
					$('#memberpassword').attr('type','text');
				}else{
					$('#memberpassword').attr('type','password');
				}
			})
			
			$('#resetpwd').on('click',function(e){
				e.preventDefault();
				var pwd1 = $('#memberpassword').val();
				var pwd2 = $('#RepeatPassword').val();
		        let hasCapital = false;
		        let hasLower = false;
		        for (i = 0; i < pwd1.length; i++) {
		            if (pwd1[i] >= 'A' && pwd1[i] <= 'Z') { hasCapital = true }
		            if (pwd1[i] >= 'a' && pwd1[i] <= 'z') { hasLower = true }
		        }
		        if ((pwd1.length >= 8 && pwd1.length <= 20) && hasCapital && hasLower && ($.trim(pwd1) == $.trim(pwd2))) {
		            
					$('#changepasswordForm').submit();
		        	
		        }else{
		        	Swal.fire({
			    		  icon: 'error',
			    		  title: '密碼格式錯誤',
			    		  text: '請重新輸入'
			    		})
		        }
		        
			})
			
			
			
		})
	
	</script>
</body>

</html>