<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

</head>
<body >
	<body>
    <form name="carDealerInfoA" action="<c:url value='/CarDealerServlet.do'  /> " method="post">
        <ul>
            <li>
                <input id="carDealName" name="carDealName" value="${param.carDealName}" type="text">
            </li>
            <li>
                <input id="carDealPhone" name="carDealPhone" value="${param.carDealPhone}" type="text">
            </li>
            <li>
                <input id="carDealAddress" name="carDealAddress" value="${param.carDealAddress}" type="text">
            </li>
            <li>
                <input id="openTime" name="openTime" value="${param.openTime}" type="text">
            </li>
            <li>
                <input id="contactPerson" name="contactPerson" value="${param.contactPerson}" type="text">
            </li>
            <li>
                <input id="carDealVATNumber" name="carDealVATNumber" value="${param.carDealVATNumber}" type="text">
            </li>
            <input type="submit" value="送出">
        </ul>
    </form>
</body>
</body>
</html>