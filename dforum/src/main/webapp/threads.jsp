<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>


<script src="threads.js"></script>

<title>車論壇</title>
</head>
<body>

	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills float-right">
					<li class="nav-item"></li>
					<li class="nav-item"></li>
					<li class="nav-item">
					<a type="button" href="newthread.jsp"
							class="btn btn-primary">發表文章</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">資車會論壇</h3>
		</div>


		<ul class="list-group">
			<li class="list-group-item"><a href="#">
					<div class="row">
						<div class="col-xl-1">category</div>
						<div class="col-xl-8">title</div>
						<div class="col-xl-3">User/Time</div>
					</div>

			</a></li>




		</ul>



		<footer class="footer"> </footer>

	</div>
	<!-- /container -->
</body>
</html>