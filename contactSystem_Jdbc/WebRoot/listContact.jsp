<%@ page language="java"
	import="java.util.*,school.libenhe.contactSystem_web.entity.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询所有联系人</title>

<style type="text/css">
table td { /*文字居中*/
	text-align: center;
}

/*合并表格的边框*/
table {
	border-collapse: collapse;
}
</style>

</head>
 <center>
	<h3>查询所有联系人(JDBC版本)</h3>
 </center>
<table align="center" border="1" width="1000px">
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>年龄</th>
		<th>电话</th>
		<th>邮箱</th>
		<th>QQ</th>
		<th>操作</th>
		<c:forEach items="${contacts}" var="contact" varStatus="varSta">
			<tr>
				<td>${varSta.count }</td>
				<td>${contact.name }</td>
				<td>${contact.gender }</td>
				<td>${contact.age }</td>
				<td>${contact.phone }</td>
				<td>${contact.email }</td>
				<td>${contact.qq }</td>
				<td><a
					href="${pageContext.request.contextPath }/QueryContactServlet?id=${contact.id}">修改</a>&nbsp;<a
					href="${pageContext.request.contextPath }/DeleteContactServlet?id=${contact.id}">删除</a></td>
			</tr>
		</c:forEach>
	</tr>
	<tr>
		<td colspan="8" align="center"><a
			href="${pageContext.request.contextPath }/addContact.jsp">[添加联系人]</a></td>
	</tr>
</table>
<body>

</body>
</html>
