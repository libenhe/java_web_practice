<%@ page language="java"
	import="java.util.*,school.libenhe.contactSystem_web.entity.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门员工信息</title>

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
<br/>
 <center>
	<h2>部门员工信息</h2>
 </center>
 <br/><br/>
<table align="center" border="1" width="1250px">
	<tr>
		<th>员工编号</th>
		<th>姓名</th>
		<th>当前状态</th>
		<th>年龄</th>
		<th>受教育程度</th>
		<th>人事变更</th>	
		<th>职务</th>
		<th>联系方式</th>
		<th>备注</th>
		<th>操作</th>
		<c:forEach items="${contacts}" var="contact" varStatus="varSta">
			<tr>
				<td>${varSta.count }</td>
				<td>${contact.name }</td>
				<td>${contact.gender }</td>
				<td>${contact.age }</td>
				<td>${contact.edu }</td>
				<td>${contact.pchange }</td>
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
		<td colspan="10" align="center"><a
			href="${pageContext.request.contextPath }/addContact.jsp">[添加部门员工]</a></td>
	</tr>
</table>

 <body style="background-image:url(img/09.jpg); background-size:1400px 680px; no-repeat">

</body>
</html>
