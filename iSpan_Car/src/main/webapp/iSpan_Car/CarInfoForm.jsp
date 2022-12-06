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
	<form name="carInfoA" action=""
		method="post" enctype="multipart/form-data">
		<ul>
			<li>車輛編號<input id="carNo" name="carNo"
				value="${param.carNo}" type="text"></li>
			<li>車商名稱<input id="carDealName" name="carDealName"
				value="${param.carDealName}" type="text"></li>
			<li>帳號<input id="accountNumber" name="accountNumber"
				value="${param.accountNumber}" type="text"></li>
			<li>車輛品牌<input id="carBrand" name="carBrand"
				value="${param.carBrand}" type="text"></li>
			<li>車輛名稱<input id="carName" name="carName" value="${param.carName}"
				type="text"></li>
			<li>庫存<input id="stock" name="stock" value="${param.stock}"
				type="text"></li>
			<li>車輛照片<input id="carImage" name="carImage"
				value="${param.carImage}" type="file"></li>
			<li>車輛描述<input id="carDescription" name="carDescription"
				value="${param.carDescription}" type="text"></li>
			<li>發布日期<input id="announceDate" name="announceDate"
				value="${param.announceDate}" type="text"></li>
			<input type="submit" value="新增" formaction="<c:url value='/CarInfoServlet.do'/>">
			<input type="submit" value="刪除" formaction="<c:url value='/DeleteCarInfoServlet.do'/>">
			<input type="submit" value="搜尋全車輛" formaction="<c:url value='/ShowAllCarInfoServlet.do'/>">
		</ul>
	</form>
</body>
</html>