<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Car Dealer</title>
</head>
<body>
<table>
        <c:forEach var="dealer" items="${selectcarDealName}" varStatus="vs">
            <tr>
                <th>車商名稱</th>
                <th>車商電話</th>
                <th>地址</th>
                <th>營業時間</th>
                <th>聯絡人</th>
                <th>統一編號</th>
            </tr>
            <tr>
            	<td>${dealer.carDealName}</td>
                <td>${dealer.carDealPhone}</td>
                <td>${dealer.carDealAddress}</td>
                <td>${dealer.openTime}</td>
                <td>${dealer.contactPerson}</td>
                <td>${dealer.carDealVATNumber}</td>
            </tr>
        </c:forEach>

    </table>
    <a href="<c:url value='/Car-Dearler/CarDealerForm.jsp' />" >回上一頁</a>
</body>
</html>