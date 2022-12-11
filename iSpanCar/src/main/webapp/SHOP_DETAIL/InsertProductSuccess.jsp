<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增產品成功</title>
</head>
<body>
	新增產品 OK!
	<form action="<c:url value='/ProductListServlet.do'/>" method="POST">
		<input type="submit" value="回商城管理頁面" />
	</form>
</body>
</html>