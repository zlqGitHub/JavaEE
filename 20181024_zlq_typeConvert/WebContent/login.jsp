<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:fielderror cssStyle="color:red"/>
	<a href="regist.jsp">请先注册</a>
	<s:property value="address"/>
	<s:form action="loginAction" method="post">
		<s:textfield label="email"  name="emails"/>
		<s:password label="密码"  name="pass"/>
		<s:submit value="登录"/>
	</s:form>
</body>
</html>