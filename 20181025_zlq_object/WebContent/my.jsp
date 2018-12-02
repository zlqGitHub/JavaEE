<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th width="80px"> 编号</th>
			<th width="80px"> 书名</th>
			<th width="80px"> 类型</th>
			<th width="80px"> 借书日期</th>
		</tr>
		
		<s:iterator value="books" var="b">
			<tr>
				<td align="center"><s:property value="#b.bookPrice" /></td>
				<td align="center"><s:property value="#b.bookName" /></td>
				<td align="center"><s:property value="#b.bookAuthor" /></td>
				<td align="center"><s:property value="#b.bookPrice" /></td>
			</tr>
		</s:iterator>
		
	</table>

</body>
</html>