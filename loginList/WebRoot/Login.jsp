<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>管理员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath }/login" method="post"></form>
  <table align="center" border="1">
    <tr>
      <td>用户名</td>
      <td>
         <input type="text" name="userName">
      </td>  
    </tr>
    <tr>
      <td>密码</td>
	  <td>
	    <input type="password" name="pwd">
	  </td>
    </tr>
    <tr>
  	   <td>
  		<input type="submit" value="登陆">
    	</td>
  		</tr>
  </table>
  </body>
</html>
