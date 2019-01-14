<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>班级</td>
		<td>老师</td>
		<td>分配老师</td>
	</tr>
		<s:iterator var="b" value="classlist" status="l">
    		<tr>
    			<td><s:property value="classname"/></td>
    			<td><s:property value="teachername"/></td>
    			<td><center><a href="selectteacher?classname=<s:property value="classname"/>">进入</a></center></td>
    		</tr>
    	</s:iterator>   	
</table>
<a href="intoen">返回</a>
</body>
</html>