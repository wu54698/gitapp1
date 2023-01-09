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
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">


<script src="thread.js"></script>
<script>
function reloadpage(){
	//e.preventDefault();
	//location.reload(); 
}
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
			<h3 class="text-muted">討論串</h3>
		</div>

		<div id="posts"></div>

		<div class="row">
			<div class="col-md-12">
				<div class="card bg-default">

					<form action="newpost" method="post" accept-charset="UTF-8">

						<div class="card-body" style="width: 100%; height: 100%">
							<textarea id="body" name="body" class="form-control"
								style="width: 100%; height: 100%;" placeholder="在此輸入回覆..."
								required></textarea>
						</div>

						<div>
							<input type="hidden" id="memberId" name="memberId" value="1" /> 
							<input type="hidden" id="time" name="time" />
							<input type="hidden" id="threadId" name="threadId" />
							<input type="hidden" id="title" name="title" value="" /> 
							<input type="submit" class="btn btn-primary" onclick="reloadpage()" />
						</div>
					</form>

				</div>
			</div>
		</div>


		<footer class="footer"> </footer>

	</div>
	<!-- /container -->
</body>
</html>
