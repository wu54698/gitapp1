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
<form action="<c:url value='/serviceInsertServlet.do'/>"  method="POST" enctype="multipart/form-data">
<input type="text" name="Service_name"><br>
<input type="text" name="Serviceinfomation"><br>
<input type="text" name="Servicedescription"><br>
<input type="text" name="Contactperson"><br>
<input type="text" name="Reseller_nonreseller"><br>
<input type="file" name="Carimage"><br>
<input type="submit"  value="提交">
</form>


</body>
</html>