<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Grayscale - Start Bootstrap Theme</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    
	<script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/js/sb-admin-2.min.js"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesh0eet" />
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="http://localhost:8080/iSpanCar/script/css/styles.css" rel="stylesheet" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">

</head>

<body id="page-top">
	<c:set value="${LoginOK}" var="login"/>
	<c:set value="${login.memberPosition.permissionsofposition}" var="memberPosition"/>
	<input type="hidden" value="${login.accountnumber}" id="logincheck">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="/index" style="color:white;font-size:1.3em;font-family: 'Noto Sans TC', sans-serif;">首頁</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
                Menu
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><b><a class="nav-link" href="#about" style="color:white;font-size:1.3em;font-family: 'Noto Sans TC', sans-serif;">車廠</a></b></li>
                    <li class="nav-item"><b><a class="nav-link" href="#projects" style="color:white;font-size:1.3em;font-family: 'Noto Sans TC', sans-serif;">車輛</a></b></li>
                    <li class="nav-item"><b><a class="nav-link" href="#projects" style="color:white;font-size:1.3em;font-family: 'Noto Sans TC', sans-serif;">保養廠</a></b></li>
                    <li class="nav-item"><b><a class="nav-link" href="#about" style="color:white;font-size:1.3em;font-family: 'Noto Sans TC', sans-serif;">論壇</a></b></li>
                    <li class="nav-item"><b><a class="nav-link" href="#about" style="color:white;font-size:1.3em;font-family: 'Noto Sans TC', sans-serif;">商城</a></b></li>
                    <li class="nav-item login-info dropdown no-arrow"  style="color:white;font-size:1.3em;font-family: 'Noto Sans TC', sans-serif;"><b><a class="nav-link" href="login">登入</a></b></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Masthead-->
    <header class="masthead">
        <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
   
            <div class="d-flex justify-content-center">
                
                <div class="text-center">
                    <h2 class="mx-auto my-0 text-uppercase" style="color:white;font-size:7em;font-family: 'Noto Sans TC', sans-serif;">無此權限</h2>
                    <h2 class=" mx-auto mt-2 mb-5" style="color:white;font-size:2em;font-family:DFKai-SB;font-family: 'Noto Sans TC', sans-serif;">很抱歉帳號權限不夠</h2>
                    <!-- <a class="btn btn-primary" href="#about">Get Started</a> -->
                </div>
            </div>
        </div>
        
    </header>

    <footer class="footer bg-black small text-center text-white-50">
        <div class="container px-4 px-lg-5"><a class="nav-link"  href = "checkogin.controller" >Copyright &copy; Your Website 2022</a></div>
    </footer>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
    <script>
    $(function(){
    	if($('#logincheck').val() != ""){
    		var account = $('#logincheck').val();
    		
    		var loginhtml =  '<b><a class="nav-link colorchange" href="/userinfo" '+
               'style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">'+account+'&nbsp'+
    		'<img class="img-profile rounded-circle" id="myImage" width="25px" src="/showimageforthismember.controller\?accountnumber='+account+'"></a></b>';
    		
    		var logouttext = '<li class="nav-item"><b><a class="nav-link" href="/logout.controller" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">登出</a></b></li>';
    		
    		$('.login-info').html(loginhtml).after(logouttext);
    	}else{
    		var loginhtml='<b><a class="nav-link" href="login" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">登入</a></b>';
    		$('.login-info').html()
    	}
    })
    </script>
</body>

</html>