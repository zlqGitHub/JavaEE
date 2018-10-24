<%@ page language="java" import="java.util.*,nuc.sw.dangdang.entity.Book,nuc.sw.dangdang.db.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<table border=1>
		<tr>
			<td width="80px" align="center"> 书名</td>
			<td width="80px" align="center"> 作者</td>
			<td width="80px" align="center"> 价格</td>
		</tr>
		
		<s:iterator value="books" var="b">
			<tr>
				<td align="center"><s:property value="#b.bname"/></td>
				<td align="center"><s:property value="#b.bauthor"/></td>
				<td align="center"><s:property value="#b.bprice"/></td>			
			</tr>
		
		</s:iterator>
		
	</table>
	

</body>
</html>