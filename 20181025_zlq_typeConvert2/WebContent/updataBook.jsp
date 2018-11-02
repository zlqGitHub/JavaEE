<%@ page language="java" import="java.util.*,nuc.sw.dangdang.entity.Book,nuc.sw.dangdang.db.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<s:form action="confirmUpdata_BookAction" method="post">
		<s:iterator value="book" var="b">
			书名：<s:property value="#b.bname"/>
			作者：<s:property value="#b.bauthor"/>
			价格：<s:property value="#b.bprice"/><br>
			<s:textfield label="书名"   name="bname"  value=""/><br>
			<s:textfield label="作者"   name="bauthor"  value=""/><br>
			<s:textfield label="价格"   name="bprice"  value=""/><br>
			<s:submit value="确认修改"/>
		</s:iterator>
	
	</s:form>

</body>
</html>