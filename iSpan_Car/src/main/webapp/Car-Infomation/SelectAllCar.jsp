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
        <c:forEach var="car" items="${SelectAllCar}" varStatus="vs">
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
            	<td>${car.carNo}</td>
                <td>${car.carDealName}</td>
                <td>${car.accountNumber}</td>
                <td>${car.carBrand}</td>
                <td>${car.carName}</td>
                <td>${car.stock}</td>
              <!--<td>${car.carImage}</td>--> 
                <td><img src="http://localhost:8080/iSpan_Car/AllImageServlet.do?carNo=${car.carNo}" width="260px" height="260px"></td>
                <td>${car.carDescription}</td>
                <td>${car.announceDate}</td>
            </tr>
        </c:forEach>	
    </table>
    <a href="<c:url value='/Car-Infomation/CarInfoForm.jsp' />" >回上一頁</a>
</body>
</html>