<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢產品顯示</title>
</head>
<body>

	
	<table>
		<c:forEach var='product' items='${querybyproductno}' varStatus="vs">

			<tr>
				<th>產品編號</th>
				<th>產品名稱</th>
				<th>種類</th>
				<th>規格</th>
				<th>價格</th>
				<th>庫存數量</th>
				<th>上架日期</th>
				<th>產品資訊</th>
				<th>產品圖片</th>
			</tr>
			<tr>
				<td>${product.productno}</td>
				<td>${product.productname}</td>
				<td>${product.type}</td>
				<td>${product.spec}</td>
				<td>${product.price}</td>
				<td>${product.stock}</td>
				<td>${product.uptime}</td>
				<td>${product.productinfo}</td>
				<td><img
					src="<c:url value='/ProductImgServlet?productno=${product.productno}'/>"
					width="240" height="240" /></td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>