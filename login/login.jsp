<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登錄</title>
<style> 
form {
	margin: 0 auto;
	width: 400px;
}
</style>
</head>
<body>
<form action="<c:url value='/loginServlet.do'/>" method="POST">
    <table>
         <tr><th colspan='2'>
            <h1>登入</h1> 
         </th><th></th></tr>
         <tr>
             <td width='180' align="RIGHT">帳號：</td>
             <td width='140' align="LEFT">
             	<input	type="text" id="accountnumber" size="10" name ="accountnumber" value="${param.accountnumber}">
             </td>
             <td width='130'><small>
             	<font color='red' size="-1"></font></small>
             </td>
         </tr>
         <tr>
             <td align="RIGHT">密碼：</td>
             <td align="LEFT" >
             	<input	type="password" id="memberpassword" size="10" name="memberpassword" value="${param.memberpassword}">
             </td>
             <td width='130'><small>
             	<font color='red'  size="-1"></font></small>
             </td>
         </tr>            
         <tr>
             <td align="CENTER" colspan='3'>
             	<font color='red' size="-1">&nbsp;</font>
             </td>
         </tr>
        <tr>
            <td colspan="2" align="center">      
            	<input type="submit" value="提交" id="check"> </td>
            </tr>
         </Table>        
</form>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
	<script src="../vendor/jquery/jquery-3.6.1.js"></script>
<script> 
$(function () {
    
    $(document).ready(function () {
        $('#check').on('click',function () {
			$.ajax({
			    url: "<c:url value='/checkAccountPasswordServlet.do'/>",
			    dataType: 'text',
			    type:'POST',
			    async:'false',
			    data:{
			    	accountnumber : $("#accountnumber").val(),
			    	memberpassword : $("#memberpassword").val()
			    },
			    error: function(xhr) {
			        alert('Ajax request 發生錯誤');
			    },
			    success: function(response) {
			        if(response.trim() == "無資料" || response.trim() == "資料有誤") {
			            alert("帳號密碼錯誤，請重新輸入" + response);
			        } else {
			            alert("驗證成功，即將登入首頁"+ response);
			        }
			    }
			})
        })
    })
})
</script>
</body>

</html>