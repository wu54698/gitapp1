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
	<div>
		<h2>查詢全部</h2><br>
		<form action="<c:url value='/memberSelectAll.do'/>" method="POST">
			<input type="submit" value="查詢">
		</form>
	</div>
	<div id='result'>
	
		<c:choose>
		<c:when test="${empty selectAll}">
			<h3>查無任何會員資料</h3>
		</c:when>
		<c:otherwise>
			<c:forEach var='member' items='${selectAll}' varStatus="vs">
				<c:if test="${vs.first}">
					<c:out escapeXml='false' value="<table>" />
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
						<th>修改</th>
						<th>刪除</th>
					</tr>
				</c:if>
				<tr>
					<td class="accountnumber">${member.accountnumber}</td>
					<td>${member.memberpassword}</td>
					<td>${member.memberName}</td>
					<td>${member.phonenumber}</td>
					<td>${member.email}</td>
					<td>${member.memberaddress}</td>
					<td>${member.platenumber}</td>
					<td>${member.birthday}</td>
					<td>${member.idnumber}</td>
					<td><img src="<c:url value='/ImageServlet?accountnumber=${member.accountnumber}'/>"  width="180" height="180"/></td>
					<td class="button"><button class="update">修改</button></td>
					<td class="button"><button class="delete">刪除</button></td>
				</tr>
				<c:if test="${vs.last}">
					<c:out escapeXml='false' value='</table>' />
				</c:if>
			</c:forEach>
		</c:otherwise>

	</c:choose>
	
	</div>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
	<script src="../vendor/jquery/jquery-3.6.1.js"></script>
	<script>
	$(function () {
			$('#result').on('click','.delete',function(){//刪除
				let account = $(this).closest('tr').children('.accountnumber').text();
				console.log(account);
				$.ajax({
	                type: 'POST',
	                url: "<c:url value='/memberDelete.do'/>",
	                dataType: 'text',
	                data:{ accountnumber : account },
	                success: function (response) {
	                	alert(response);
	                	 
	                } ,
	                error:function(xhr, ajaxOptions, thrownError){
	                	 
	                    alert(xhr.status+"\n"+thrownError);
	                }
	            })
	            $(this).parent().parent().remove();
	           
			})

			$('#result').on('click', '.update', function () {//修改按鈕
	               let test = $(this).closest('tr').children('.accountnumber').text();
	               console.log(test);
	
	               let array = [];
	
	               $(this).closest('tr').find('td:not(.button)').each(function (index, ele) {
	                   array.push($(this).text());
	               })//陣列中加入.not以外的內文
	               console.log(array)
	               for (let i = 1; i < array.length-1; i++) {
	                   let content = "<input type='text' size='12px' value='" + array[i] + "'>";
	                   $(this).closest('tr').children('td').eq(i).text("");
	                   $(this).closest('tr').children('td').eq(i).append(content);
	               }
	               let buttonstring = "<button class='confirm'>確認</button><br><button class='cancel'>取消</button>"
	               $(this).parent().empty().append(buttonstring)
	
	           })
	           $('#result').on('click', '.cancel', function () {//修改取消
	               let buttonstring = "<button class='update'>修改</button>"
	               let account = $(this).closest('tr').find('.accountnumber').text();
	   				$.ajax({
	   	                type: 'POST',
	   	             	context:this,
	   	                url: "<c:url value='/memberReturnUpdateCancel.do'/>",
	   	                dataType: 'json',
	   	                data:{ accountnumber : account },
	   	                success: function (response) {
	   	                	let member = response[0];
	   	                	$(this).parent().parent().children('td').eq(1).text(member.memberpassword)
	   	                	$(this).parent().parent().children('td').eq(2).text(member.memberName)
	   	                	$(this).parent().parent().children('td').eq(3).text(member.phonenumber)
	   	                	$(this).parent().parent().children('td').eq(4).text(member.email)
	   	                	$(this).parent().parent().children('td').eq(5).text(member.memberaddress)
	   	                	$(this).parent().parent().children('td').eq(6).text(member.platenumber)
	   	                	$(this).parent().parent().children('td').eq(7).text(member.birthday)
	   	                	$(this).parent().parent().children('td').eq(8).text(member.idnumber)
	   	                	$(this).parent().empty().append(buttonstring)
	   	                } ,
	   	                error:function(xhr, ajaxOptions, thrownError){
	   	                	 
	   	                    alert(xhr.status+"\n"+thrownError);
	   	                }
	   	            })
	           })
	           $('#result').on('click', '.confirm', function () {//修改確認
	               	let buttonstring = "<button class='update'>修改</button>"
	            	let account = $(this).closest('tr').find('.accountnumber').text();
	               	let memberarray = [];
	               	let memberbeanlength = 11;
	               	for(let i=1;i<(memberbeanlength -2) ;i++){
	               		memberarray.push($(this).closest('tr').children('td').eq(i).children().val());
	               	}
	               	$.ajax({
	   	                type: 'POST',
	   	             	context:this,
	   	                url: "<c:url value='/memberReturnUpdate.do'/>",
	   	                dataType: 'json',
	   	                data:{ "accountnumber" : account,
	   	                		"memberpassword": memberarray[0],
	   	                		"memberName": memberarray[1],
	   	                		"phonenumber": memberarray[2],
	   	                		"email": memberarray[3],
	   	                		"memberaddress": memberarray[4],
	   	                		"platenumber": memberarray[5],
	   	                		"birthday": memberarray[6],
	   	                		"idnumber": memberarray[7]
	   	                },
	   	                success: function (response) {
	   	                	console.log(response);
	   	                	let member = response[0];
	   	                	$(this).parent().parent().children('td').eq(1).text(member.memberpassword)
	   	                	$(this).parent().parent().children('td').eq(2).text(member.memberName)
	   	                	$(this).parent().parent().children('td').eq(3).text(member.phonenumber)
	   	                	$(this).parent().parent().children('td').eq(4).text(member.email)
	   	                	$(this).parent().parent().children('td').eq(5).text(member.memberaddress)
	   	                	$(this).parent().parent().children('td').eq(6).text(member.platenumber)
	   	                	$(this).parent().parent().children('td').eq(7).text(member.birthday)
	   	                	$(this).parent().parent().children('td').eq(8).text(member.idnumber)
	   	                	$(this).parent().empty().append(buttonstring)
	   	                } ,
	   	                error:function(xhr, ajaxOptions, thrownError){
	   	                	 
	   	                    alert(xhr.status+"\n"+thrownError);
	   	                }
	   	            })
	               
	           })
		
			
// 			$.ajax({
//                 type: 'POST',
//                 url: "<c:url value='/memberDelete.do'/>",
//                 dataType: 'text',
//                 data:{ accountnumber : account },
//                 success: function (response) {
//                 	alert(response);
                	 
//                 } ,
//                 error:function(xhr, ajaxOptions, thrownError){
                	 
//                     alert(xhr.status+"\n"+thrownError);
//                 }
//             })
         
		
	})
	
	
	</script>

</body>
</html>