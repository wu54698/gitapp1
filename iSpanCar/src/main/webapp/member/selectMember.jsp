<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select member</title>
</head>
<body>

	<table>

		<c:forEach var='member' items='${selectaccountnumber}' varStatus="vs">
			
				<tr>
					<th>帳號</th>
					<th>密碼</th>
					<th>姓名</th>
					<th>電話</th>
					<th>e-mail</th>
					<th>地址</th>
					<th>車牌</th>
					<th>生日</th>
					<th>身分證</th>
											<th>圖</th>
				</tr>
			<tr>
				<td>${member.accountnumber}</td>
				<td>${member.memberpassword}</td>
				<td>${member.memberName}</td>
				<td>${member.phonenumber}</td>
				<td>${member.email}</td>
				<td>${member.memberaddress}</td>
				<td>${member.platenumber}</td>
				<td>${member.birthday}</td>
				<td>${member.idnumber}</td>
				<td><img src="<c:url value='/ImageServlet?accountnumber=${member.accountnumber}'/>"  width="180" height="180"/></td>
			</tr>
		
		</c:forEach>
	</table>

</body>
</html>