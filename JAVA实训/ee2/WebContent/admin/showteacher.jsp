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
		<td>教师名字</td>
		<td>课程</td>
		<td colspan=2><center>分配老师</center></td>
	</tr>
		<s:iterator var="b" value="teacherlist" status="l">
    		<tr>
    			<td><s:property value="teachername"/></td>
    			<td><s:property value="td"/></td>
    			<td><a href="addteacher?teachername=<s:property value="teachername"/>">分配</a></td>
    		</tr>
    	</s:iterator>  
    	<tr>
    		<td></td>
    		<td></td>
    		<td><s:a href="addteacher?teachername=无">取消</s:a></td>
    	</tr>
</table>
</body>
</html>