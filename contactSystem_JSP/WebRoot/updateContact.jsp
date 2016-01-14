<%@ page language="java" import="java.util.*,school.libenhe.contactSystem_web.entity.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改联系人</title>
</head>

<body>
<center><h3>修改联系人</h3></center>
<form action="${pageContext.request.contextPath }/UpdateContactServlet" method="post">
<input type="hidden" name="id" value="${contact.id }"/>
<table align="center" border="1" width="300px">
    <tr>
    	<th>姓名</th>
        <td><input type="text" name="name" value="${contact.name }"/></td>
    </tr>
    <tr>
    	<th>性别</th>
        <td>
        <input type="radio" name="gender" value="男"  <c:if test="${contact.gender=='男' }">checked="checked"</c:if> />男
        <input type="radio" name="gender" value="女"  <c:if test="${contact.gender=='女' }">checked="checked"</c:if> />女
        </td>
    </tr>
    <tr>
    	<th>年龄</th>
        <td><input type="text" name="age" value="${contact.age }"/></td>
    </tr>
    <tr>
    	<th>电话</th>
        <td><input type="text" name="phone" value="${contact.phone }"/></td>
    </tr>
    <tr>
    	<th>邮箱</th>
        <td><input type="text" name="email" value="${contact.email }"/></td>
    </tr>
    <tr>
    	<th>QQ</th>
        <td><input type="text" name="qq" value="${contact.qq }"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
        <input type="submit" value="保存"/>&nbsp;
        <input type="reset" value="重置"/></td>
    </tr>
</table>
</form>
</body>
</html>
