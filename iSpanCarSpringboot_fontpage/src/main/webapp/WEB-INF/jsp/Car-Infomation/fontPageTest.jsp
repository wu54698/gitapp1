<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

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
<style>
#car {
	display: inline-block;
	color: red;
	float: left;
	margin-left: 10px;
}
</style>




</head>

<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top bg-black"
		id="mainNav"></nav>

	<!--     content -->
	<div class="bg-black" id="content">
		<div class="row rounded" style="margin-top: 88px">
			<div class="col-1"></div>
			<div
				class="col-10 bg-white justify-content-center text-center rounded">
				<br>
				<!-- Select標籤處 -->
				<form name="selectCarBrand" action="" method="post" enctype="multipart/form-data">
					<select id="selectCarBrand" name="selectedOption">
						<c:forEach var="carBrand" items="${carBrand}" varStatus="vs">
							<option value="${carBrand}">${carBrand}</option>
						</c:forEach>
					</select> <input type="submit" id="findCarBrand" value="找品牌" formaction="">
				</form>

				<div class="container">
					<div class="row" id="result">
						<c:forEach var="car" items="${SelectAllCar}" varStatus="vs">
							<div class="card .col-12"
								style="width: 20rem; margin: 10px; padding: 10px">
								<img class="card-img-top"
									src="/carInfoImage.controller/${car.carNo}"
									alt="Card image cap" width="200" height="200">
								<div class="card-body">
									<h3 class="card-title" style="font-weight: bold">${car.carDealerBean.carDealName}</h3>
									<h4 class="card-brand" style="font-weight: bold" id="car">${car.carBrand}</h4>
									<h5 class="card-name" style="font-weight: bold" id="car">${car.carName}</h5>
									<br>
									<h6 class="card-name" style="font-weight: bold" align="right">庫存尚有
										${car.stock} 輛</h6>
									<!-- 									<p class="card-text">Some quick example text to build on -->
									<!-- 										the card title and make up the bulk of the card's content.</p> -->
									<!-- 									<a href="#" class="btn btn-primary">點我看更多</a> -->
									<a href="SelectCarByCarNo.controller/${car.carNo}"><button
											type="submit" class="btn btn-primary">點我看更多</button></a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

			</div>
			<div class="col-1"></div>
		</div>
	</div>

	<!--  footer -->
	<div id="footertext"></div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!--     <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script> -->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
	
	<script>
	$('#findCarBrand').on('click', function(e){
		e.preventDefault();
		var selectCarBrand = $('#selectCarBrand').val();
		console.log(selectCarBrand);
		$.ajax({
			type:"post",
			url:"/backstage/SelectCarBrand.controller",
			context: this,
			dataType: "json",
			data:{
				"carBrand" : selectCarBrand
			},
			success: function(data){
				console.log(data)
				let result = '';
				data.forEach(car=>{
					console.log(car)
					result += '<div class="card .col-12"'+
						'style="width: 20rem; margin: 10px; padding: 10px">'+
						'<img class="card-img-top"'+
							'src="/carInfoImage.controller/'+ car.carNo +'"'+
							'alt="Card image cap" width="200" height="200">'+
						'<div class="card-body">'+
							'<h3 class="card-title" style="font-weight: bold">'+car.carDealerBean.carDealName+'</h3>'+
							'<h4 class="card-brand" style="font-weight: bold" id="car">'+car.carBrand+'</h4>'+
							'<h5 class="card-name" style="font-weight: bold" id="car">'+car.carName+'</h5>'+
							'<br>'+
							'<h6 class="card-name" style="font-weight: bold" align="right">庫存尚有'+
								''+car.stock+' 輛</h6>'+
							'<a href="SelectCarByCarNo.controller/'+car.carNo+'"><button'+
									'type="submit" class="btn btn-primary">點我看更多</button></a>'+
						'</div>'+
					'</div>'
				});
				console.log(result)
				$('#result').html(result);
			}
			
		})
	})
	
	
	</script>
	
	
</body>

</html>