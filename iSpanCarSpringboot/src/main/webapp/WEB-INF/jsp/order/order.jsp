<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String jspOrderId = null;
%>
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
    <link href="http://localhost:8080/iSpanCar/script/css/orderClient.css" rel="stylesheet" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
  #btn:hover {
    /* :hover 代表滑鼠移到元素上時的狀態 */ 
    transform: scale(1.05);
  }

  #btn:active {
    /* :active是滑鼠點擊元素的狀態 */
    transform: scale(1);
    box-shadow: inset 0 0 10px 1px rgba(0, 0, 0, .2);
  }
  
   #btn {
    width: 180px;
    line-height: 40px;
    font-size: 20px;
    color: PapayaWhip;
    text-align: center;
    background-color: Chocolate;
    border: 5px solid SaddleBrown;
    border-radius: 15px;
    cursor: pointer;
  }
  
   .head.even {
 background-color: #A5B8BF;
} 
</style>
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
                                style="color:white;font-size:6em;font-family: 'Noto Sans TC', sans-serif;">訂單查詢</h2>
                            <!--                     <h2 class=" mx-auto mt-2 mb-5" style="color:white;font-size:2em;font-family:DFKai-SB;font-family: 'Noto Sans TC', sans-serif;">資車國際</h2> -->
                        </div>
                    </div>
                </div>
            </header>
    
<!--     content -->
    <div class="bg-black" id="content">
    <div class="row rounded">
     <div class="col-1"></div>
      <div class="col-10 bg-white justify-content-center text-center rounded">
            <div style="text-align: center; padding: 50px 100px;">
		
			

					<table class=table>
						<thead>
							<tr class=head>
								<td></td>
								<td>訂單編號</td>
								<td>訂購時間</td>
								<td>付款方式</td>
								<td>訂單金額</td>
								<td>訂單明細</td>
								<td>處理狀態</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="order" varStatus="statusX" items="${AllOrder}">
<tr class="head <c:if test="${statusX.count % 2 == 0}">even</c:if>">
									<td >${statusX.count}</td>
									<td >${order.orderId}</td>
									<td class="order-date">${order.orderDate}</td>
									<td >${order.paidMethod}<br/>${order.paidSate}</td>
									<td class="total-price">${order.totalPrice}</td>
									<td><button id="watch" data-order-id="${order.orderId}" onclick="showOrderDetails(this)">
  <i class="fa-solid fa-eye"></i>
</button>
									</td>
									<td>${order.orderStatus}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<c:forEach var="order" varStatus="statusX" items="${AllOrder}">
			  <div  style="display: none; text-align: center; padding: 50px 100px;" id="${order.orderId}"  >
							<h3>訂單明細</h3>
						<table class=table>	
								<thead > 
								<tr class=head>
									<td>商品名稱</td>
									<td>數量</td>
								</tr>
								</thead>
								<tbody>
								<tr>
								<c:forEach var="orderItem" varStatus="status"
										items="${AllOrderItme}">
										<tr>
										<c:if test="${order.orderId == orderItem.orderId}">
									<td><c:out value="${shopDetailMap[Integer.valueOf(orderItem.productNumber)].productname}" /></td>
								<th>${orderItem.quantity}</th>
								</c:if>
								</tr>
								</c:forEach>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td>收件地址</td>
									<td>${order.deliveryAddress }</td>
								</tr>
								<tr>
									<td>總計</td>
									<td class="total-price">${order.totalPrice }</td>
								</tr>
							</tfoot>
						
						</table>
		<button id="btn" onclick="closeOrderDetails('${order.orderId}')">關閉</button>


					</div>
					
					</c:forEach>
				</div>	
      </div>
     <div class="col-1"></div>
    </div>
  </div>
  <!--  footer -->
 <div id="footertext"></div>

 
 <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!--     <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script> -->
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript">

    

    
    function showOrderDetails(element) {
    	  var orderId = element.getAttribute("data-order-id");
    	  console.log(orderId);
    	  var target = document.getElementById(orderId);

    	  target.style.display = "block";
    	  target.style.position = "fixed";
    	  target.style.zIndex = "1";
    	  target.style.top = "50%";
    	  target.style.left = "50%";
    	  target.style.transform = "translate(-50%, -50%)";
    	  target.style.backgroundColor = "white";
    	  target.style.padding = "20px";
    	  target.style.boxShadow = "0px 0px 10px #ccc";

    	  // 放大 1 倍
    	  target.style.width = "50%";
    	  target.style.height = "50%";

    	  console.log(target);
    	}
    function closeOrderDetails(orderId) {
    	var orderDetails = document.getElementById(orderId);
    	orderDetails.style.display = "none";
    	}
    
    var orderDates = document.getElementsByClassName("order-date");
	  for (var i = 0; i < orderDates.length; i++) {
	    var orderDate = orderDates[i];
	    var date = new Date(orderDate.textContent);
	    orderDate.textContent = date.getFullYear() + "-" + (date.getMonth() + 1).toString().padStart(2, "0") + "-" + date.getDate().toString().padStart(2, "0") + " " + date.getHours().toString().padStart(2, "0") + ":" + date.getMinutes().toString().padStart(2, "0");
	  }
	  
	  var totalPrices = document.getElementsByClassName("total-price");
	  for (var i = 0; i < totalPrices.length; i++) {
	    var totalPrice = totalPrices[i];
	    totalPrice.textContent = totalPrice.textContent.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	  }

    </script>
</body>

</html>