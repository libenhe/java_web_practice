<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>管理员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	  
  </head>
  
  <body style="background-image:url(img/04.jpg); background-size:1400px 675px; no-repeat">
  
  <br/>
   <br/>
    <br/>
     <br/> <br/>
      <br/>
       <br/>
        <br/>
 <form name="frmLogin" action="${pageContext.request.contextPath }/loginServlet" method="post">
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
  			<td colspan="2" align="center">
  			  <input type="reset" value="重置"/>&nbsp;
  				<input type="submit" value="登陆">
  			</td>
  		</tr>
  	</table>
  </form>
  </body>
</html>
