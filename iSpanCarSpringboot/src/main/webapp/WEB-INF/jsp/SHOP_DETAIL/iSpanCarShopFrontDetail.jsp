<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>iSpanCarShop - 產品頁</title>
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="http://localhost:8080/iSpanCar/script/css/ShopFrontDetailstyles.css" rel="stylesheet" />
        <script src="http://localhost:8080/iSpanCar/script/plugins/jquery/jquery.min.js"></script>
        <link href="http://localhost:8080/iSpanCar/script/css/shopstyle.css" rel="stylesheet">
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
           <script src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
           <link rel="preconnect" href="https://fonts.googleapis.com">
           <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
           <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">
           <link rel="icon" href="img/Fevicon.png" type="image/png">
    <style>
    .supPaymethod{
  display: flex;
  justify-content: center;
    };
    
    </style>
    
    </head>
    <body>
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
                                style="color:white;font-size:6em;font-family: 'Noto Sans TC', sans-serif;">用戶資訊</h2>
                            <!--                     <h2 class=" mx-auto mt-2 mb-5" style="color:white;font-size:2em;font-family:DFKai-SB;font-family: 'Noto Sans TC', sans-serif;">資車國際</h2> -->
                        </div>
                    </div>
                </div>
            </header>
        <div class="bg-black" id="content">
                <div class="row rounded">
                    <div class="col-1"></div>
                    <div class="col-10 bg-white justify-content-center rounded mb-2">
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center" >
                <c:forEach items='${productdetail}' var="productd" varStatus="vs">
                    <div class="col-md-6" style="width:auto" ><img height="320" class="card-img-top mb-5 mb-md-0" src="productimgfront.controller?productno=${productd.productno}"/></div>
                    <div class="col-md-6 align-items-right">
                        <div class="small mb-1" id="productNoContainer" data-product-no="${productd.productno}">商品編號:${productd.productno}</div>
                        <h1 class="display-5 fw-bolder">${productd.productname}</h1>
                        <div class="fs-5 mb-5">
<!--                             <span class="text-decoration-line-through">$45.00</span> -->
                            <span>NT$${productd.price}</span>
                        </div>
                        <p class="lead">${productd.productinfo}</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="number" oninput="value=value.replace('-', '')"  value="1" min="1" max="${productd.stock}" style="max-width: 5rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button" id="addOK" style="padding:15px;" >
                                <i class="bi-cart-fill me-1"></i>
                                加入購物車
                            </button>
                        </div>
                        <span id="stock-info">剩餘數量:${productd.stock}</span>
                    </div>
                </c:forEach>
                </div>
            </div>
           <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel" style="text-align: center;">
								<div class="carousel-inner">
									<c:forEach var="mul" items="${multiimgs}" varStatus="vs">
										<c:choose>
											<c:when test="${vs.first}">
												<div class="carousel-item active" >
													<img class="figure-img img-fluid rounded"
														src="/showMultiImgesF.controller/${mul.imgsno}"
														alt="...">
												</div>
											</c:when>
											<c:otherwise>
												<div class="carousel-item">
													<img class="figure-img img-fluid rounded"
														src="/showMultiImgesF.controller/${mul.imgsno}"
														alt="...">
												</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									</div>
								<button class="carousel-control-prev" type="button"
									data-bs-target="#carouselExampleControls" data-bs-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Previous</span>
								</button>
								<button class="carousel-control-next" type="button"
									data-bs-target="#carouselExampleControls" data-bs-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Next</span>
								</button>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
							<div class="supPaymethod">
							<p>
							</div>
            <div class="supPaymethod">
            <h2>支援的線上付款方式</h2>
            </div>
            <div class="supPaymethod">
            <img alt="ec" src="http://localhost:8080/iSpanCar/script/img/shoppage/ecpayimg.png">
            </div>
            <div class="supPaymethod">
            </div>
            <div class="supPaymethod">
            <h2>支持的發卡單位</h2>
            </div>
            <p>
            <div class="supPaymethod">
            <img class="eccard" alt="ec"src="http://localhost:8080/iSpanCar/script/img/shoppage/ecpaysupcard.png">
            </div>
            
            
        </section>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">你可能感興趣的商品</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:forEach var="randomProduct" items="${selectRandomProduct}" varStatus="vs">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="productimgfront.controller?productno=${randomProduct.productno}" alt="xxx" />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${randomProduct.productname}</h5>
                                    <!-- Product price-->
                                    NT$${randomProduct.price}
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/iSpancarShop.DetailShopPage?productname=${randomProduct.productname}">查看該商品</a></div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                  </div>
                </div>
        </section>
        		</div>
        	</div>
        </div>
        <!-- Footer-->
        <div id="footertext"></div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="http://localhost:8080/iSpanCar/script/plugins/jquery/jquery.min.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/popper.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/bootstrap/bootstrap-slider.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/tether/js/tether.min.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/raty/jquery.raty-fa.js"></script>
			<script src="http://localhost:8080/iSpanCar/script/plugins/slick/slick.min.js"></script>
            <script src="http://localhost:8080/iSpanCar/script/js/navhtml.js"></script>
            <script src="http://localhost:8080/iSpanCar/script/js/footerhtml.js"></script>
			<script
				src="http://localhost:8080/iSpanCar/script/plugins/jquery-nice-select/js/jquery.nice-select.min.js"></script>
        
        <script>
        $(document).ready(function(){
        	  $("#addOK").click(function(){
        		  var productNoContainer = $("#productNoContainer");
        		  var productNo = productNoContainer.data("product-no");
        	    console.log("productNo:" + productNo);
        	    var accountNumber = $("#logincheck").val();
        	    console.log("accountNumber:" + accountNumber);
        	    var inputQuantity = $("#inputQuantity").val();
        	    console.log("inputQuantity:"+ inputQuantity);
        	    Swal.fire(
      				  '已放入您的購物車!',
      				  '',
      				  'success'
      				);
        	    $.ajax({
        	      type: "POST",
        	      url: "/cartInsert.controller",
        	      data: {productNumber: productNo, memberId: accountNumber,quantity: inputQuantity},
        	      success: function(){
        	        console.log("Good");
        	      }
        	    });
        	  });
        	});

		</script>
        
        
        
        <script>
        window.onload = function() {
            var stockInfo = document.getElementById("stock-info");
            var stock = parseInt(stockInfo.textContent.split(":")[1]);

            if (stock < 50) {
                stockInfo.style.color = "red";
            }
        };
        </script>
        
    </body>
</html>
