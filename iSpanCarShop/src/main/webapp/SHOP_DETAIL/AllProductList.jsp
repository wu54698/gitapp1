<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢所有產品</title>
</head>
<body>
	<div>
		<form action="<c:url value='/ProductListServlet.do'/>" method="POST">
			<input type="submit" value="查詢所有產品" />
		</form>
	</div>
</body>
</html>