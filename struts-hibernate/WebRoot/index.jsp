<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
   <h2>部门：<s:proprety value="#request.dept.deptName"/></h2>
   <!-- 部门员工（懒加载） -->
   <table border="1" align="center">
   <tr>
   <td>员工编号</td>
   <td>员工姓名</td>
   <td>员工薪水</td>
   </tr>
   <s:if test="#request.dept.emp != null">
   <s:iterator var="emp" value="#request.dept.emps">
     <tr>
     	 <td><s:property value="#emp.empId"/> </td>
     	 <td><s:property value="#emp.empName"/> </td>
     	 <td><s:property value="#emp.empsalary"/> </td>
     </tr>
   </s:iterator>
   </s:if>
   <s:else>
   		<tr>
   		  <td colspan="3">没有员工信息！</td>
   		</tr>
   </s:else>
   </table>
  </body>
</html>













