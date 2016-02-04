<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>学生列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  <h1>欢迎您，${sessionScope.loginInfo.userName }</h1>
  <table align="center" border="1" width="50%" cellpadding="3" cellspacing="0">
    <tr>
      <td>序号</td>
      <td>学号</td>
      <td>姓名</td>
    </tr>
    
    <c:if test="${not empty requestScope.listEmp }">
     <c:forEach var="emp" items="${requestScope.listEmp }" varStatus="varSt">
     <tr>
     <td>${varSt.count }</td>
     <td>${emp.empId }</td>
     <td>${empName }</td>
     </tr>
     </c:forEach>
     </c:if>
  </table>
  <body>

  </body>
</html>
