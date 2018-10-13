<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<font color="red"><s:property value="tip" /></font>
	<s:form action="zlq/cal2" method="post">
		<input type="text" name="num1" value="<s:property value="num1" />">&nbsp;
		<select name="op">
			<option value="+" ${sessionScope.op== "+" ? "selected" : ""} >+</option>
			<option value="-" ${sessionScope.op== "-" ? "selected" : ""}>-</option>
			<option value="*" ${sessionScope.op== "*" ? "selected" : ""}>*</option>
			<option value="/" ${sessionScope.op== "/" ? "selected" : ""}>/</option>
		</select>&nbsp;
		<input type="text" name="num2" value="<s:property value="num2" />">&nbsp;
		<input type="submit" value="=">&nbsp;
		<input type="text" name="result" value="${sessionScope.result}">
	
	</s:form>
</body>
</html>