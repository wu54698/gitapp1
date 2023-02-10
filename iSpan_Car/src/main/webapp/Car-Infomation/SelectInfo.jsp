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
<table>
        <c:forEach var="info" items="${selectCarBrand}" varStatus="vs">
            <tr>
                <th>車輛編號</th>
                <th>車商名稱</th>
                <th>帳號</th>
                <th>車輛品牌</th>
                <th>車輛名稱</th>
                <th>庫存</th>
                <th>車輛照片</th>
                <th>車輛描述</th>
                <th>發布日期</th>
            </tr>
            <tr>
                <td>${info.carNo}</td>
                <td>${info.carDealName}</td>
                <td>${info.accountNumber}</td>
                <td>${info.carBrand}</td>
                <td>${info.carName}</td>
                <td>${info.stock}</td>
                <td><img src="<c:url value='/ImageServlet?carBrand=${info.carBrand}'/>" width="260px" height="260px"></td>
                <td>${info.carDescription}</td>
                <td>${info.announceDate}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value='/Car-Infomation/CarInfoForm.jsp' />" >回上一頁</a>
</body>
</html>