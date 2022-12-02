<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="carInfoA" action="<c:url value='/CarInfoServlet.do'  /> "
		method="post" enctype="multipart/form-data">
		<ul>
			<li><input id="carDealVATNumber" name="carDealVATNumber"
				value="${param.carDealVATNumber}" type="text"></li>
			<li><input id="carDealName" name="carDealName"
				value="${param.carDealName}" type="text"></li>
			<li><input id="accountNumber" name="accountNumber"
				value="${param.accountNumber}" type="text"></li>
			<li><input id="carBrand" name="carBrand"
				value="${param.carBrand}" type="text"></li>
			<li><input id="carName" name="carName" value="${param.carName}"
				type="text"></li>
			<li><input id="stock" name="stock" value="${param.stock}"
				type="text"></li>
			<li><input id="carImage" name="carImage"
				value="${param.carImage}" type="file"></li>
			<li><input id="carDescription" name="carDescription"
				value="${param.carDescription}" type="text"></li>
			<li><input id="announceDate" name="announceDate"
				value="${param.announceDate}" type="text"></li>
			<input type="submit" value="送出">
		</ul>
	</form>
</body>
</html>