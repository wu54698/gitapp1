<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shop Application</title>
</head>
<body>
    <center>
        <h1>Products Management</h1>
        <h2>
            <a href="<c:url value='/SHOP_DETAIL/InsertSHOP_DETAIL_form.jsp'/>">新增產品</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Product</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>產品列表</h2></caption>
            <tr>
                <th>產品編號</th>
                <th>產品名稱</th>
                <th>產品類型</th>
                <th>規格</th>
                <th>價格</th>
                <th>庫存數量</th>
                <th>上架日期</th>
                <th>產品資訊</th>
            </tr>
            <c:forEach var="product" items="">
                <tr>
                    <td><c:out value="${product.productno}" /></td>
                    <td><c:out value="${product.productname}" /></td>
                    <td><c:out value="${product.type}" /></td>
                    <td><c:out value="${product.spec}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td><c:out value="${product.stock}" /></td>
                    <td><c:out value="${product.uptime}" /></td>
                    <td><c:out value="${product.productinfo}" /></td>
                    <td>
                        <a href="<c:url value='/SHOP_DETAIL/UpdateProduct.jsp'/>?id=<c:out value='${product.productno}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${product.productno}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>