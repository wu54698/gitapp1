<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<style>
.card-img-top {
	width: 300px;
	float: left; /* 圖片在左邊 */
	padding: 20px;
}

.col-7 {
	float: left;
}
}
</style>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Grayscale - Start Bootstrap Theme</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesh0eet" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="http://localhost:8080/iSpanCar/script/css/styles.css"
	rel="stylesheet" />
<script
	src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
<script src="http://localhost:8080/iSpanCar/script/js/navhtml.js"></script>
<script src="http://localhost:8080/iSpanCar/script/js/footerhtml.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">

</head>

<body id="page-top">
	<!-- Navigation-->
	<c:set value="${LoginOK}" var="login" />
            <c:set value="${login.memberPosition.permissionsofposition}" var="memberPosition" />
            <input type="hidden" value="${login.accountnumber}" id="logincheck">
			<input type="hidden" value="${login.memberName}" id="loginName">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            </nav>

            <header class="masthead2">
                <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
                    <div class="d-flex justify-content-center">
                        <div class="text-center">
                            <h2 class="mx-auto my-0 text-uppercase"
                                style="color:white;font-size:6em;font-family: 'Noto Sans TC', sans-serif;">保養廠資訊</h2>
                            <!--                     <h2 class=" mx-auto mt-2 mb-5" style="color:white;font-size:2em;font-family:DFKai-SB;font-family: 'Noto Sans TC', sans-serif;">資車國際</h2> -->
                        </div>
                    </div>
                </div>
            </header>

	<!--     content -->
	
<div class="row rounded" style="text-align: left;">
  <div class="col-4 text-left">
    <br><br><br>
    <img class="img-fluid"
      src="/serviceimage.controller?servicename=${Service.servicename}"
      alt="Service Image"
      style="width: 300px; height: 300px; display: block; margin: 0 auto;">
  </div>
  <div class="col-8 text-left">
    <br><br><br>
    <h3 class="servicename" style="text-align: left;">${Service.servicename}</h3>
    <p class="servicedescription" style="text-align: left;">${Service.servicedescription}</p>
    <p class="serviceinfomation" style="text-align: left;">${Service.serviceinfomation}</p>
    <p class="contactperson" style="text-align: left;">${Service.contactperson}</p>
        <span class="mr-2"></span>
        <form action="/OrderServicename" class= "serviceName">
         <input type="hidden" id="serviceName" name="Servicename" value="${Service.servicename}" >
         <button class="btn btn-danger" type="submit" >預約點我
         </button>
	<input type ="button"class="btn btn-primary" onclick="history.go(-1)" value="回到上一頁"></input>
        </form>
       </div>



  </div>
<c:set var='Service' value='${Service}'></c:set>


	<div class="col-1"></div>

	<!--  footer -->
	<div id="footertext"></div>

	<script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!--     <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script> -->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<!-- 	<script> -->

<!-- 	</script> -->
</body>

</html>