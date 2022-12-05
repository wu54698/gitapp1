<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>iSpan_Car</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
<body>
	<form name="carDealerInfoA"
		action="" method="post">
		<ul>
			<li>車商名稱<input id="carDealName" name="carDealName"
				value="${param.carDealName}" type="text"></li>
			<li>車商電話<input id="carDealPhone" name="carDealPhone"
				value="${param.carDealPhone}" type="text"></li>
			<li>地址<input id="carDealAddress" name="carDealAddress"
				value="${param.carDealAddress}" type="text"></li>
			<li>營業時間<input id="openTime" name="openTime"
				value="${param.openTime}" type="text"></li>
			<li>聯絡人<input id="contactPerson" name="contactPerson"
				value="${param.contactPerson}" type="text"></li>
			<li>統一編號<input id="carDealVATNumber" name="carDealVATNumber"
				value="${param.carDealVATNumber}" type="text"></li>
				
			<input type="submit" value="新增" formaction="<c:url value='/CarDealerServlet.do'/>">
			<input type="submit" value="刪除" formaction="<c:url value='/DeleteCarDealerServlet.do'/>">
			<input type="submit" value="改資訊" formaction="<c:url value='/UpdateCarDealerServlet.do'/>">
			<input type="submit" value="找車商" formaction="<c:url value='/ShowDealerServlet.do'/>">
		</ul>
	</form>
</body>

</html>