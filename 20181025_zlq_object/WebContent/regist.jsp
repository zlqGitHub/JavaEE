<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="RegistAction" method="post">
		<s:textfield label="用户名"   name="username" />
		<s:password label="密码"   name="password" />
		<s:password label="确认密码"   name="repassword" />
		<s:textfield label="邮箱地址" name="email" />
		<s:textfield label="电话号码"   name="telphone"/>
		<s:textfield label="省"     name="address"/>
		<s:textfield label="市"     name="address"/>
		<s:textfield label="区"     name="address"/>
		<s:textfield label="街道"     name="address"/>
		
		<s:submit value="注册"/>
	
	</s:form>
</body>
</html>