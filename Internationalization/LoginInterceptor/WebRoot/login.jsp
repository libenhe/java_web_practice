<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title> 登陆页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
  <form method="post" action="${pageContext.request.contextPath }/user_login.action">
  <s:text name="username"></s:text>  <input type="text" name="admin.userName"><br/>
   <s:text name="pwd"></s:text>  <input type="password" name="admin.pwd"><br/>
    <input type="submit" value="登陆"><br/>
  </form>
   
  </body>
</html>








