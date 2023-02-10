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
<c:forEach var="i" begin="1" end="${totalPages}" step="1">
                                    <li class="page-item"><a class="page-link" href="${i}">${i}</a></li>
                                </c:forEach>
                                <li style="text-align: center; padding: 10px; font-size: 10px">${nowPage}/${totalPages}</li>
</body>
</html>