<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
      <link href="http://localhost:8080/iSpanCar/script/css/cartClient.css" rel="stylesheet" />
      <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">
     <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

      <script>
        var orderName = sessionStorage.getItem("orderName");
        var orderPhone = sessionStorage.getItem("orderPhone");
        var payment = sessionStorage.getItem("payment");
        var deliveryAddress = sessionStorage.getItem("deliveryAddress");
      </script>
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
                                style="color:white;font-size:6em;font-family: 'Noto Sans TC', sans-serif;">最後確認</h2>
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
                <div class="progress-text" style="position: relative;  height: 30px;">
                  <div style="position: absolute; left: 16.6%;">購物明細</div>
                  <div style="position: absolute; left: 49.6%;">付款資訊</div>
                  <div style="position: absolute; left: 82.6%;">最後確認</div>
                </div>
                <div class="progress" style="margin-bottom: 30px;">
                  <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar"
                    aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
                </div>
              <form action="<c:url value='/orderInsert.controller'/>" method="POST" enctype="multipart/form-data">
                <h2>訂單資訊</h2>
                <div style="border: 5px solid lightblue; border-radius: 5px;">

                  <table style="border: none; margin: auto;">
                    <tbody>
                      <tr>
                        <td style="padding-left: 10px; padding-right: 10px;text-align: left;">收件者</td>
                        <td style="padding-left: 10px; padding-right: 10px;text-align: left;"><span
                            id="orderNameDisplay"></span>
                            <input type="hidden" id="orderName"name="orderName" style="display: none">
                        </td>
                      </tr>
                      <tr>
                        <td style="padding-left: 10px; padding-right: 10px;text-align: left;">連絡電話</td>
                        <td style="padding-left: 10px; padding-right: 10px;text-align: left;"><span
                            id="orderPhoneDisplay"></span><input type="hidden" id="orderPhone"name="orderPhone" style="display: none">
                        </td>
                      </tr>
                      <tr>
                        <td style="padding-left: 10px; padding-right: 10px;text-align: left;">付款方式</td>
                        <td style="padding-left: 10px; padding-right: 10px;text-align: left;"><span
                            id="paymentDisplay"></span><input type="hidden" id="paidMethod" name="paidMethod" style="display: none">
                        </td>
                      </tr>
                      <tr>
                        <td style="padding-left: 10px; padding-right: 10px;text-align: left;">收件地址</td>
                        <td style="padding-left: 10px; padding-right: 10px;text-align: left;"><span
                            id="deliveryAddressDisplay"></span><input type="hidden" id="deliveryAddress"name="deliveryAddress"
                            style="display: none"></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div style="border: 5px solid lightblue; border-radius: 5px;">
                  <table class=table>
                    <thead>
                      <tr>
                        <td colspan="2">商品資訊</td>
                        <td>單價</td>
                        <td>數量</td>
                        <td>金額</td>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="cart" varStatus="statusX" items="${AllCartById}">
                        <c:if test="${statusX.index == 0}">
                          <td><input type="hidden" name="memberId" style="display: none" value="${cart.memberId}"></td>
                          <td><input type="hidden" name="cartId" style="display: none" value="${cart.cartId}"></td>
                          <td><input type="hidden" name=orderStatus style="display: none" value="未出貨"></td>
                        </c:if>
                        <tr>
                          <td>
                            <c:out value="${shopDetailMap[Integer.valueOf(cart.productNumber)].productname}" />
                           <c:set var="productName" value="${shopDetailMap[Integer.valueOf(cart.productNumber)].productname}" />
                            <input type="hidden" name="productNumber[]" style="display: none" value="${cart.productNumber}">
                              <input type="hidden" name="productName[]" style="display: none" value="${ productName}">
                          </td>
                          <td><img
                              src="productimgfront.controller?productno=${shopDetailMap[Integer.valueOf(cart.productNumber)].productno}"
                              width="90" height="90" /></td>
                          <td name="price">
                            <c:out value="${shopDetailMap[Integer.valueOf(cart.productNumber)].price}" />
                          </td>
                          <td name="quantity">${cart.quantity}<input type="hidden" name="quantity[]"
                              style="display: none" value="${cart.quantity}">
<c:set var="stockValue" value="${shopDetailMap[Integer.valueOf(cart.productNumber)].stock}" />                            
  <input type="hidden" name="stock[]" style="display: none" value="${stockValue}"></td>
                          <td name="Total"></td>
                        </tr>
                      </c:forEach>
                          <input type="hidden" id="totalPrice" name="totalPrice" style="display: none">
                    </tbody>
                    <tfoot>
                      <tr>
                        <td colspan="3"></td>
                        <td>總金額</td>
                        <td name="sumTotal"></td>
                      </tr>
                    </tfoot>
                  </table>
                  <button id="back" type="button" onclick="window.location.href='/CartCheckout'">
                    <i class="fa-solid fa-backward"></i>返回上頁
                  </button>
                  <button id="submit" type="submit">
                    <i class="fa-solid fa-forward"></i>確定送出
                  </button>
					
                </div>

            </form>
            </div>
          </div>
<!-- <form id="backcart" method="post" action="/cart" style="display: inline-block;"> -->
<%--   <input type="hidden" name="memberId" value="${login.accountnumber}"> --%>
<!-- </form>	 -->
        </div>
        <div class="col-1"></div>
      </div>


      <!--  footer -->
      <div id="footertext"></div>


      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
      <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
      <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>


      <script>
        document.addEventListener("DOMContentLoaded", function () {
          // 取得所有金額元素
          const prices = document.querySelectorAll("td[name='price']");
          const quantities = document.querySelectorAll("td[name='quantity']");
          const totalPrices = document.querySelectorAll("td[name='Total']");
          var sum = 0;
          // 計算所有金額
          for (let i = 0; i < prices.length; i++) {
            const price = parseInt(prices[i].textContent);
            const quantity = parseInt(quantities[i].textContent);
            totalPrices[i].textContent = (price * quantity).toLocaleString();
            sum += price * quantity;
          }
        document.getElementsByName("sumTotal")[0].innerText = sum.toLocaleString();
        document.getElementById("totalPrice").value = sum;
        console.log(document.getElementById("totalPrice").value)
        document.getElementById("orderName").value = orderName;
        document.getElementById("orderPhone").value = orderPhone;
        document.getElementById("deliveryAddress").value = deliveryAddress;
        document.getElementById("paidMethod").value = payment;
		

        });
        
        
        document.getElementById("orderNameDisplay").innerHTML = orderName;
        document.getElementById("orderPhoneDisplay").innerHTML = orderPhone;
        document.getElementById("paymentDisplay").innerHTML = payment;
        document.getElementById("deliveryAddressDisplay").innerHTML = deliveryAddress;
        
        
        document.getElementById("submit").addEventListener("click", function() {
        	  const quantityElements = document.querySelectorAll("input[name='quantity[]']");
        	  const stockElements = document.querySelectorAll("input[name='stock[]']");
        	  var memberId = "${ login.accountnumber}";
        	  for (let i = 0; i < quantityElements.length; i++) {
        	      const quantity = parseInt(quantityElements[i].value);
        	      const stock = parseInt(stockElements[i].value);


        	      if (quantity > stock) {
        	    	  event.preventDefault();
        	    	  Swal.fire({
        	    	  icon: 'error',
        	    	  title: '庫存不足，請檢查數量'
        	    	  }).then(function() {
        	    	  window.location.href = "/cart?memberId=" + memberId;
        	    	  });
        	    	  }
          	  }
        	  
        	  var xhr = new XMLHttpRequest();
        	    xhr.open("POST", "https://payment-stage.ecpay.com.tw/Cashier/AioCheckOut/V5", true);
        	    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        	    xhr.onreadystatechange = function() {
        	        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
        	            // API呼叫成功，送出表單
        	            document.getElementById("form").submit();
        	        }
        	    };
        	    xhr.send("data=your_data");
        	});

      </script>
    </body>

    </html>