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

		<c:set value='${Service}' var='Service'>
		</c:set>
			
				<tr>
					<th>保養廠名稱</th>
					<th>保養廠照片</th>
					<th>保養廠描述</th>
					<th>保養廠資訊</th>
					<th>聯繫</th>
					<th>原廠副廠</th>

											
				</tr>
			<tr>
				<td>${Service.service_name}</td>
				<td><img src="<c:url value='/serviceImageServlet?Service_name=${Service.service_name}'/>"  width="180" height="180"/></td>
				<td>${Service.servicedescription}</td>
				<td>${Service.serviceinfomation}</td>
				<td>${Service.contactperson}</td>
				<td>${Service.reseller_nonreseller}</td>
				
			</tr>
		
	
	</table>

</body>
</html>