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
  <br/> <br/>
  <h2 align="center">人事管理系统欢迎您！${sessionScope.loginInfo.userName }，您是管理员用户！</h2>
  <br/>
    <br/> 
 
            
  <table align="center" border="1" width="50%" cellpadding="3" cellspacing="0">
    <tr>
      <td>部门编号</td>
      <td>部门名称</td>
      <td>部门主管</td>
      <td align="center">部门简介</td>
    
    </tr>
    
    <c:if test="${not empty requestScope.listEmp }">
     <c:forEach var="emp" items="${requestScope.listEmp }" varStatus="varSt">
     <tr>
     <td>${varSt.count }</td>
     <td>${emp.empId }</td>
     <td>${emp.empName }</td>
      <td>${emp.dept_id }</td>
      
     </tr>
     </c:forEach>
 
  
     </c:if>
  </table >
  <table  align="center" border="1" width="50%" cellpadding="3" cellspacing="0">
  <tr>
  <td align="center">
          部门员工人员信息详情
  </td>
  </tr>
  </table>
  <table   align="center" border="1" width="50%" cellpadding="3" cellspacing="0">
  <tr>
  <td align="center">
  <a href="http://localhost:1314/contactSystem_Jdbc/ListContactServlet">后端开发部</a>
  </td>
   <td align="center">
  <a href="http://localhost:1314/contactSystem_Jdbc/ListContactServlet">前端开发部</a>
  </td>
   <td align="center">
  <a href="http://localhost:1314/contactSystem_Jdbc/ListContactServlet">产品部</a>
  </td>
   <td align="center">
  <a href="http://localhost:1314/contactSystem_Jdbc/ListContactServlet">美工部</a>
  </td>
  </tr>
  </table>
 <body style="background-image:url(img/09.jpg); background-size:1400px 680px; no-repeat">

  </body>
</html>
