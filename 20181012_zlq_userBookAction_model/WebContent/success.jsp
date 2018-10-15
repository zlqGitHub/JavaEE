<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	欢迎${sessionScope.username}登录成功！<br>
	<a href="addBook.jsp" target="frame">添加书籍信息</a>
	<a href="deleteBook.jsp" target="frame">删除书籍信息</a>
	<a href="updataBook.jsp" target="frame">修改书籍信息</a>
	<a href="get_BookAction" target="frame">查询书籍信息</a><br>
	
	<iframe name="frame" width="800px" height="300px"></iframe>
</body>
</html>