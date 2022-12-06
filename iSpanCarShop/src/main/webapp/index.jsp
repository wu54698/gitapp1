<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="AppName" value="${SYSTEM.systemName}" scope="application"/>
<title>${AppName}</title>
</head>
<body>
<!-- 設定變數funcName的值為"IND", top.jsp會使用此變數-->
<c:set var="funcName" value="IND" scope="session"/>
<!-- 引入共同的頁首 -->
<jsp:include page="/fragment/topMVC.jsp" />
<div align='center'>
 <h1>
<font color='RED'>${AppName}</font><br>
<c:choose>
   <c:when test='${ ! empty logoutMessage}'>
      ${logoutMessage}
   </c:when>
   <c:otherwise>
   歡迎光臨<br>
 天天有優惠，天天有好康<br>
 今天舉辦<font color='BLUE'>滿仟送佰</font>的促銷活動<br>
 本店絕不販賣盜版書、山寨書與過期書
   </c:otherwise>
</c:choose>
  </h1> 

  <h2>
 </h2>
   <hr>
   <p style='font-family: "Verdana"; color: red'>
  本範例需要先執行_00_init.EDMTableReset.java來建立初始資料 
 </p>
  ${MsgOK.InsertOK}<br>
 <br>  
 <% // 顯示MsgOK.InsertOK / logoutMessage後，就要立刻移除，以免每次回到首頁都會不斷顯示相同的訊息
    session.removeAttribute("MsgOK");  
    session.removeAttribute("logoutMessage");  
 %>
 </div>
</body>
</html>