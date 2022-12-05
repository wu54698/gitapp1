<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/memberInsertServlet.do'/>" method="POST" enctype="multipart/form-data">
            <input type="text" name="accountnumber" id="accountnumber"><br>
            <input type="text" name="memberpassword"><br>
            <input type="text" name="membername"><br>
            <input type="text" name="phonenumber"><br>
            <input type="text" name="email"><br>
            <input type="text" name="memberaddress"><br>
            <input type="text" name="platenumber"><br>
            <input type="text" name="birthday"><br>
            <input type="text" name="idnumber"><br>
            <input type="file" name="file"><br>
            <input type="submit" value="提交"><br>


        </form>
	   <div id="response"></div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
	<script src="../vendor/jquery/jquery-3.6.1.js"></script>
	<script> 
    $(function () {
    
	    $(document).ready(function () {
	        $('#accountnumber').keyup(function () {
	            $.ajax({
	                type: 'POST',
	                url: "<c:url value='/checkAccountnumberServlet.do'/>",
	                dataType: 'text',
	                data:{ accountnumber : $('#accountnumber').val()},
	                success: function (response) {
	                    $('#response').text(response)
	                      console.log('123')
	                } ,
	                error:function(xhr, ajaxOptions, thrownError){
	                	 
	                    alert(xhr.status+"\n"+thrownError);
	                }
	            })
	       	 })
    	})
	   
    	
    })

	</script>
</body>
</html>