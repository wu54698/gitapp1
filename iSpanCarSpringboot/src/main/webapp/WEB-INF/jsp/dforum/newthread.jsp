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


<script type="text/javascript">
	$(document).ready(
			function() {
				$("#time").val(new Date().getTime());
				$.ajax({
					url : "/category/all",
					method : "GET",
					dataType : "json",
					success : function(res) {
						console.log(res);

						var sel = $('<select>',{class:'custom-select',name:'category'}).appendTo('#catediv');
						$(res).each(
								function() {
									sel.append($("<option>").attr('value',
											this.id).text(this.name));
								});

					},
					error : function(err) {
						console.log(err)
					},
				});
				
			});
</script>

<title>車論壇</title>
</head>
<body>

	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills float-right">
					<li class="nav-item"></li>
				</ul>
			</nav>
			<h3 class="text-muted">發表文章</h3>
		</div>

		<form action="/thread" method="post" accept-charset="UTF-8">
			<div id="catediv" class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-sm">分類</span>
				</div>

			</div>


			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">標題</span>
				</div>
				<input type="text" class="form-control" id="title" name="title" required>
			</div>



			<div id="newt" style="width: 100%; height: 100%">
				<textarea id="body" name="body" class="form-control"
					style="width: 100%; height: 100%" placeholder="在此輸入文章..." required></textarea>
			</div>

			<div>
				<input type="hidden" id="memberId" name="memberId" value="1" /> 
				<input type="hidden" id="time" name="time" /> 
				<input type="submit" class="btn btn-primary" />
			</div>
		</form>





		<footer class="footer"> </footer>

	</div>
	<!-- /container -->
</body>
</html>