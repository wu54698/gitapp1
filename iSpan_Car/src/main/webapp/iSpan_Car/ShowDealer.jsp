<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/ShowDealerServlet.do'/>" method="post">
        統編<input type="text" name="carDealVATNumber">
        <br>
        <input type="submit" name="送出">

    </form>
</body>
</html>