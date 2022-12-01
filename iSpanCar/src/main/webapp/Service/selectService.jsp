<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select Service</title>
</head>
<body>

	<table>

		<c:forEach var='Service' items='${Serviceinfomation}' varStatus="vs">
			
				<tr>
					<th>保養廠名稱</th>
					<th>保養廠照片</th>
					<th>保養廠描述</th>
					<th>保養廠資訊</th>
					<th>聯繫</th>
					<th>原廠副廠</th>

											
				</tr>
			<tr>
				<td>${Service.Service_name}</td>
				<td>${Service.Carimage}</td>
				<td>${Service.Servicedescription}</td>
				<td>${Service.Serviceinfomation}</td>
				<td>${Service.email}</td>
				<td>${Service.Contactperson}</td>
				<td>${Service.Reseller_nonreseller}</td>
				<td><img src="<c:url value='/serviceImageServlet?Service_name=${Service.Service_name}'/>"  width="180" height="180"/></td>
			</tr>
		
		</c:forEach>
	</table>

</body>
</html>