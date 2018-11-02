<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add_BookAction" method="post" enctype="multipart/form-data">
		书图：<input type="file" name="upload"><br>
		书名：<input type="text" name="bname"><br>
		作者：<input type="text" name="bauthor"><br>
		定价：<input type="text" name="bprice"><br>
		<input type="submit" value="添加">
	</form>
</body>
</html>