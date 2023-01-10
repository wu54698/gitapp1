<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select member</title>
</head>
<body>
	<form action="<c:url value='/memberSelectServlet.do'/>" method="POST">
		<input type="text" name="accountnumber"><br> 
		<input type="submit" value="提交">
	</form>


</body>
</html>