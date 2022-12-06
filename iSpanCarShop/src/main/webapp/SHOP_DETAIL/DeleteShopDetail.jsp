<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除產品</title>
</head>
<body>
<form action="<c:url value='/DeleteShopDetailServlet.do'/>" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="2" align="center"><h2>刪除產品</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="120" height="40">產品編號:</td>
					<td width="600" height="40" align="left"><input
						id='productno' style="text-align: left" name="productno"
						value="${param.productno}" type="text" size="14"></td>

				<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>