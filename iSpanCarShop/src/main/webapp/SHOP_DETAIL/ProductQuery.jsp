<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢產品</title>
</head>
<body>
<div>
		<form action="<c:url value='/ProductQueryServlet.do'/>" method="POST">
			請輸入產品編號：<input type="text" name="productno"> <input
				type="submit" value="查詢" />
		</form>
	</div>
</body>
</html>