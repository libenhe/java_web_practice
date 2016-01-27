<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
  <form name="frm2" action="${pageContext.request.contextPath }/AdminServlet?method=register" method="post" >
  		<table>
  			<tr>
  				<td>用户名</td>
  				<td>
  					<input type="text" name="userName"/>
  					${requestScope.message } <!-- 如果用户名存在注册失败，给用户提示 -->
  				</td>
  			</tr>
  			<tr>
  				<td>密码</td>
  				<td><input type="password" name="pwd"/></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="注册">
  				</td>
  			</tr>
  		</table>
  	
  	</form>
  </body>
</html>
