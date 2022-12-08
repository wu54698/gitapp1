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
<form action=""  method="POST" enctype="multipart/form-data">
<label>保養廠名稱：</label><input type="text" name="servicename"><br>
<label>保養廠描述：</label><input type="text" name="Servicedescription"><br>
<label>保養廠資訊：</label><input type="text" name="Serviceinfomation"><br>
<label>保養廠聯繫：</label><input type="text" name="Contactperson"><br>
<label>原場副廠：</label><select name="Reseller_nonreseller" >
  <option value="0">原廠</option>
  <option value="1">副廠</option></select><br>
<label>保養廠圖片</label><input type="file" name="Carimage"><br>

<input type="submit"  value="提交" formaction="<c:url value='/serviceInsertServlet.do'/>"><br>

</form>


</body>
</html>