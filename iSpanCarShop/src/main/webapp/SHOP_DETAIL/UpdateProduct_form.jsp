<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改產品資料</title>
</head>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body>
	<form name="updateProductForm"
		action="<c:url value='/UpdateShopDetailServlet.do'/>" method="POST"
		enctype="multipart/form-data">
		<table border="1">
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="2" align="center"><h2>修改產品資料</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="130" height="50">產品編號:</td>
					<td width="600" height="40" align="left"><input
						id='productno' style="text-align: left" name="productno"
						value="${param.productno}" type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">產品名稱:</td>
					<td width="600" height="40" align="left"><input
						id='productname' style="text-align: left" name="productname"
						value="${param.productname}" type="text" size="14"></td>
				</tr>
<!-- 				<tr bgcolor='tan'> -->
<!-- 					<td width="120" height="40">種類:</td> -->
<!-- 					<td width="600" height="40" align="left"><input id='type' -->
<%-- 						style="text-align: left" name="type" value="${param.type}" --%>
<!-- 						type="text" size="14"></td> -->
<!-- 				</tr> -->
<!-- 				<tr bgcolor='tan'> -->
<!-- 					<td width="120" height="40">規格:</td> -->
<!-- 					<td width="600" height="40" align="left"><input name="spec" -->
<%-- 						value="${param.spec}" type="text" size="20"></td> --%>
<!-- 				</tr> -->
				<tr bgcolor='tan'>
					<td width="120" height="40">價格:</td>
					<td width="600" height="40" align="left"><input name="price"
						value="${param.price}" type="text" size="20"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">庫存數量:</td>
					<td width="600" height="40" align="left"><input name="stock"
						value="${param.stock}" type="text" size="14"></td>
				</tr>
<!-- 				<tr bgcolor='tan'> -->
<!-- 					<td width="120" height="40">上架日期:</td> -->
<!-- 					<td width="600" height="40" align="left"><input name="uptime" -->
<%-- 						value="${param.uptime}" type="text" size="14"><font --%>
<!-- 						color='blue' size="-1">&nbsp;&nbsp;格式為yyyy-MM-dd</font></td> -->
<!-- 				</tr> -->
				<tr bgcolor='tan'>
					<td width="120" height="40">產品資訊:</td>
					<td width="600" height="40" align="left"><input
						name="productinfo" value="${param.productinfo}" type="text"
						size="14"></td>
				</tr>
				<tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">產品圖片:</td>
					<td width="600" height="40" align="left"><input
						name="productimage" value="${param.productimage}" type="file">
				</tr>
				<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>