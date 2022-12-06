<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete title here</title>
</head>
<body>
 <form action="http://localhost:8080/iSpanCar/serviceDeleteServlet.do" method="POST">
	<label>刪除保養廠名稱：</label><input type="text" name="Servicename"><br> 
<input type="submit"  value="提交" ><br>
	</form>
	
	
</body>
</html>