<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<h1>�n�J</h1>

<form action="MemberLoginServlet" method="Post">
  <label for="uname">�b��</label><br>
  <input type="text" id="uname" name="uname"><br>
  <label for="pwd">�K�X</label><br>
  <input type="text" id="pwd" name="pwd"><br><br>
  <p>${errorMsgMap.LoginError}</p>
  <input type="submit" value="Submit">
</form> 
</body>
</html>