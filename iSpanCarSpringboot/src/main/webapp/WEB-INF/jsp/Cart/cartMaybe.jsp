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
        <title>iSpanCarShop - 購物車</title>
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="http://localhost:8080/iSpanCar/script/css/ShopFrontDetailstyles.css" rel="stylesheet" />
        <script src="http://localhost:8080/iSpanCar/script/plugins/jquery/jquery.min.js"></script>
    
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="iSpancarShop.ProductListAllShopPage.1">iSpanCarShop</a>
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
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center" >
                <div id="app" class="app">


					<table>
						<thead>
							<tr>
								<th>購物編號</th>
								<th>會員編號</th>
								<td>商品編號</td>
								<td>商品名稱</td>
								<td>商品價格</td>
								<td>購買數量</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cart" varStatus="statusX" items="${AllCart}">
								<tr>
									<td>${cart.cartId}</td>
									<td>${cart.memberId}</td>
									<td>${cart.productNumber}</td>
									<td>${cart.productName}</td>
									<td class="price" id="price">${cart.productPrice}</td>
									<td class="quantity" id="quantity">${cart.quantity}</td>
									<td>
										<form action="cartUpdate.controller"
											method="POST" enctype="multipart/form-data">
											<input type="button" class="decrement" value="-"> <input
												type="text" name="quantity" class="cart-count" value="1">
											<input type="button" class="increment" value="+"> <input
												type="hidden" style="display: none" name="cartId"
												value="${cart.cartId}"> <input type="submit"
												value="修改">
										</form>
									</td>
									<td>
										<form  action="/backstage/cartdeletecart.controller"
											method="POST" enctype="multipart/form-data" class="deleteForm">
											<input type="hidden" style="display: none" name="cartId"
												value="${cart.cartId}"> <input type="button"
												value="刪除" class="delete">
										</form>
									</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>

					<div align="right">

						總計:<span id="total"></span>元 <br>
						<form action="cartQueryAllCartById.controller" method="POST"
							enctype="multipart/form-data">
							前往結帳<input type="text"  name="memberId" value="${login.accountnumber}">
							<input id="pay" type="submit" value="結算" readonly="readonly">
						</form>

					</div>

				</div>


			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- End of Main Content -->
            
        </section>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
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
		$(document).ready(function() {
			initialize();

		});

		function initialize() {
			var totalPrice = 0;
			var cartnumber = $('.price').length;

			for (var a = 0; a <= cartnumber; a++) {
				var quantity = Number($('.quantity').eq(a).text());
				var price = Number($('.price').eq(a).text());
				var smallTotal = quantity * price;
				totalPrice = totalPrice + smallTotal;

				var total = document.getElementById("total");
				total.innerHTML = totalPrice;
				//             console.log(totalPrice)
			}
		};

		$(function() {

			$(".increment").click(function() {
				var n = $(this).prev(".cart-count").val();
				n++
				$(this).prev(".cart-count").val(n)
			})

			$(".decrement").click(function() {
				if ($(this).next(".cart-count").val() > 1) {
					var n = $(this).next(".cart-count").val();
					
					$(this).next(".cart-count").val(n)
				}
			})

		});
		$(function(){
			$('.delete').on('click',function(){
				
				 Swal.fire({
				      title: '確定刪除?',
				      text: "資料將被刪除",
				      icon: 'warning',
				      showCancelButton: true,
				      confirmButtonColor: '#3085d6',
				      cancelButtonColor: '#d33',
				      confirmButtonText: '刪除!',
				      cancelButtonText: '取消'
				    }).then((result) => {
				      if (result.isConfirmed) {
 				        $(this).closest(".deleteForm").submit();
				      }
				    })
			})
		})
		
		   
		 

	</script>
        
    </body>
</html>
