<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select Service</title>
</head>
<body>
	<form action="<c:url value='/serviceSelectServlet.do'/>" method="POST">
		<input type="text" name="Service_name"><br> 
		<input type="submit" value="提交">
	</form>


</body>
</html>