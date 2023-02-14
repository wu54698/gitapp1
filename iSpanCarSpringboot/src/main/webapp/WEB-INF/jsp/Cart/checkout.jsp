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
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesh0eet" />
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="http://localhost:8080/iSpanCar/script/css/styles.css" rel="stylesheet" />
    <script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/js/navhtml.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/js/footerhtml.js"></script>
         <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <link href="http://localhost:8080/iSpanCar/script/css/cartClient.css" rel="stylesheet" />
     <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
     <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">
 
</head>

<body id="page-top">
<c:set value="${LoginOK}" var="login" />
<c:set value="${login.memberPosition.permissionsofposition}" var="memberPosition" />
<input type="hidden" value="${login.accountnumber}" id="logincheck">
<input type="hidden" value="${login.memberName}" id="loginName">

    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav"></nav>
    <header class="masthead2">
                <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
                    <div class="d-flex justify-content-center">
                        <div class="text-center">
                            <h2 class="mx-auto my-0 text-uppercase"
                                style="color:white;font-size:6em;font-family: 'Noto Sans TC', sans-serif;">付款資訊</h2>
                            <!--                     <h2 class=" mx-auto mt-2 mb-5" style="color:white;font-size:2em;font-family:DFKai-SB;font-family: 'Noto Sans TC', sans-serif;">資車國際</h2> -->
                        </div>
                    </div>
                </div>
            </header>
    
<!--     content -->
    <div class="bg-black" id="content">
	   <div class="row rounded">
		   <div class="col-1"></div>
			   <div class="col-10 bg-white justify-content-center text-center rounded"   >
			    
			 			       <div style="text-align: center; padding: 50px 100px;">
			 
			       <div class="progress-text" style="position: relative;  height: 30px;">
  <div style="position: absolute; left: 16.6%;">購物明細</div>
  <div style="position: absolute; left: 49.6%;">付款資訊</div>
  <div style="position: absolute; left: 82.6%;">最後確認</div>
</div>
        <div class="progress" style="margin-bottom: 30px;">
          <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 66%"></div>
        </div>
        <h5 style="text-align: left; text-decoration: underline;">訂購人資訊</h5>
        	<label style="text-align:left;">姓名:<input type="text" value="${login.memberName}"  style="border: none;" readonly></label>
            <label style="text-align:left;">電話:<input type="text" value="${login.phonenumber}"  style="border: none; " readonly></label>
            <label style="text-align:left;">電子郵件:<input type="text" value="${login.email}"  style="border: none; " readonly></label><br>
            <hr>
        <h5 style="text-align: left; text-decoration: underline;">收件人資訊</h5>
<label style="float:left;">
<input name="same" style="float:left;" type="checkbox" >同訂購人資料
</label>
<br>        
	<label style="text-align:left;">姓名:<input type="text" value=""  name="orderName"id="orderName" style=" " ></label>
            <label style="text-align:left;">電話:<input type="text"  name="orderPhone"id="orderPhone" value=""  style=" " ></label> 
      	    <label style="text-align:left;">電子郵件:<input type="text" value=""  name="orderEmail" style=" " ></label><br>
      	    <hr>
      	
        <h5 style="text-align: left; text-decoration: underline;">輸入收件地址</h5>
				 <label style="text-align:left; margin-left: -380px;">收件地址:<input type="text" value="桃園市中壢區新生路二段421號"   name="deliveryAddress"id="deliveryAddress"  style="width: 300px;" ></label><br>
				
<!-- 				<label style="float: left;"> <input type="radio" name="delivery"> 宅配到府</label></br> -->
		<hr>
		<h5 style="text-align: left; text-decoration: underline;">選擇付款方式</h5>
<!-- 				<label style="float: left;"> <input type="radio"id="payment"name="payment" value="貨到付款"> 貨到付款</label> </br> -->
				<label style="float: left;"> <input type="radio"id="payment" name="payment" value="線上付款"> 線上付款(綠界支付)</label></br>
		<hr>
<form method="post" action="/cart" style="display: inline-block;">
  <input type="hidden" name="memberId" value="${login.accountnumber}">
  <button id="back" type="submit">
    <i class="fa-solid fa-backward"></i>返回上頁
  </button>
</form>			

<button id="checkout" type="submit">
  <i class="fa-solid fa-forward"></i>往下一頁
</button>
			</div>

		
		   <div class="col-1"></div>
	   </div>
	 </div>
</div>
<!-- 	footer -->
	<div id="footertext"></div>
	
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    <script type="text/javascript">
    const same = document.querySelector("input[name='same']");
    const loginName = document.querySelector("input[value='${login.memberName}']");
    const loginPhone = document.querySelector("input[value='${login.phonenumber}']");
    const loginEmail = document.querySelector("input[value='${login.email}']");
    const orderName = document.querySelector("input[name='orderName']");
    const orderPhone = document.querySelector("input[name='orderPhone']");
    const orderEmail = document.querySelector("input[name='orderEmail']");

   

    same.addEventListener("click", function() {
    	  if (same.checked) {
    	    orderName.value = loginName.value;
    	    orderPhone.value = loginPhone.value;
    	    orderEmail.value = loginEmail.value;
    	  } else {
    	    orderName.value = "";
    	    orderPhone.value = "";
    	    orderEmail.value = "";
    	  }
    	});


    document.getElementById("checkout").addEventListener("click", function() {
    	var orderName = document.getElementById("orderName");
    	var orderPhone = document.getElementById("orderPhone");
    	var deliveryAddress = document.getElementById("deliveryAddress");
    	var payment = document.querySelector('input[name="payment"]:checked');
    	console.log( payment);

    	if (!orderName.value || !orderPhone.value || !payment || !deliveryAddress.value) {
    		Swal.fire({
    			  icon: 'warning',
    			  text: '請輸入所有必填項目!',
    			 
    			})
    	      return;
    	    }

    	sessionStorage.setItem("orderName", orderName.value);
    	sessionStorage.setItem("orderPhone", orderPhone.value);
    	sessionStorage.setItem("payment", payment.value);
    	sessionStorage.setItem("deliveryAddress", deliveryAddress.value);
    	  var memberId = "${ login.accountnumber}";
    	
    	window.location.href = "/CartfinalCheckout?memberId=" + memberId;
    	});

   

    </script>
    
</body>

</html>