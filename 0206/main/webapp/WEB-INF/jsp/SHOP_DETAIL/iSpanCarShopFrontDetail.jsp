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
    <style>
    .supPaymethod{
  display: flex;
  justify-content: center;
    };
    
    </style>
    
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="iSpancarShop.ProductListAllShopPage">iSpanCarShop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            購物車
<!--                             <span class="badge bg-dark text-white ms-1 rounded-pill">0</span> -->
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center" >
                <c:forEach items='${productdetail}' var="productd" varStatus="vs">
                    <div class="col-md-6" style="width:auto" ><img height="320" class="card-img-top mb-5 mb-md-0" src="productimgfront.controller?productno=${productd.productno}"/></div>
                    <div class="col-md-6 align-items-right">
                        <div class="small mb-1">商品編號:${productd.productno}</div>
                        <h1 class="display-5 fw-bolder">${productd.productname}</h1>
                        <div class="fs-5 mb-5">
<!--                             <span class="text-decoration-line-through">$45.00</span> -->
                            <span>NT$${productd.price}</span>
                        </div>
                        <p class="lead">${productd.productinfo}</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="number" oninput="value=value.replace('-', '')"  value="1" style="max-width: 4rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button" id="addOK">
                                <i class="bi-cart-fill me-1"></i>
                                加入購物車
                            </button>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
           
            <div class="supPaymethod">
            <h2>本商店支援的付款方式</h2>
            </div>
            <div class="supPaymethod">
            <img alt="ec" src="http://localhost:8080/iSpanCar/script/img/shoppage/ecpayimg.png">
            </div>
            <p>
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
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; iSpanCar 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="http://localhost:8080/iSpanCar/script/plugins/jquery/jquery.min.js"></script>
        <script>
        $("#addOK").click(function(){
        	alert("加入成功!");
        	});
        </script>
    </body>
</html>
