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
<form action="<c:url value='/memberInsertServlet.do'/>"  method="POST" enctype="multipart/form-data">
<input type="text" name="accountnumber"><br>
<input type="text" name="memberpassword"><br>
<input type="text" name="membername"><br>
<input type="text" name="phonenumber"><br>
<input type="text" name="email"><br>
<input type="text" name="memberaddress"><br>
<input type="text" name="platenumber"><br>
<input type="text" name="birthday"><br>
<input type="text" name="idnumber"><br>
<input type="file" name="file"><br>
<input type="submit"  value="提交">
</form>


</body>
</html>