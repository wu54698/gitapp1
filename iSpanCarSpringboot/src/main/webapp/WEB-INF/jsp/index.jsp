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

</head>

<body id="page-top">
	<c:set value="${LoginOK}" var="login"/>
	<c:set value="${login.memberPosition.permissionsofposition}" var="memberPosition"/>
	<input type="hidden" value="${login.accountnumber}" id="logincheck">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="#page-top">首頁</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
                Menu
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><b><a class="nav-link" href="#about">車廠</a></b></li>
                    <li class="nav-item"><b><a class="nav-link" href="#projects">車輛</a></b></li>
                    <li class="nav-item"><b><a class="nav-link" href="#projects">保養廠</a></b></li>
                    <li class="nav-item"><b><a class="nav-link" href="#about">論壇</a></b></li>
                    <li class="nav-item"><b><a class="nav-link" href="#about">商城</a></b></li>
                    <li class="nav-item login-info dropdown no-arrow"><b><a class="nav-link" href="login">登入</a></b></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Masthead-->
    <header class="masthead">
        <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
            <div class="d-flex justify-content-center">
                <div class="text-center">
                    <h1 class="mx-auto my-0 text-uppercase">資車會</h1>
                    <h2 class="text-white-50 mx-auto mt-2 mb-5">資車國際</h2>
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
    		
    		var loginhtml = '<b><a class="nav-link " href="" id="userDropdown" role="button"'+
                'data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'+account+'&nbsp'+
    		'<img class="img-profile rounded-circle" id="myImage" width="25px" src="/showimageforthismember.controller\?accountnumber='+account+'"></a></b>';
    		
    		var logouttext = '<li class="nav-item"><b><a class="nav-link" href="/logout.controller">登出</a></b></li>';
    		
    		$('.login-info').html(loginhtml).after(logouttext);
    	}else{
    		var loginhtml='<b><a class="nav-link" href="login">登入</a></b>';
    		$('.login-info').html()
    	}
    })
    </script>
</body>

</html>