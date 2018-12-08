<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>借书</title>
	<link rel="stylesheet" type="text/css" href="./style/borrow.css">
	<script type="text/javascript" src="./js/borrow.js"></script>
</head>
<body>
	<div class="form">
		<s:form action="OrderAction" method="post" name="form">
			学号：<input id="input" type="text" name="student_no" value="${myInfo[0].getStudent_no()}"><br>
			书号：<input type="text" name="book_id" value="${abook[0].getBook_id()}" ><br>
			书名：<input type="text" name="book_name" value="${abook[0].getBook_name()}"><br>
			类型：<input type="text" name="type" value="${abook[0].getType()}" ><br>
			电话：<input type="text" name="telphone" value="${myInfo[0].getTelphone()}"><br>
			日期：<input type="text" name="date" value="${sd}"><br>
			<input class="submit" type="submit" value="确定"/>
				
		</s:form>
	</div>
	
	<div id="tip" class="tip">
		<img src="./images/tip.png">
	</div>
	
	
</body>
</html>