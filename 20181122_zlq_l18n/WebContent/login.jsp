<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:i18n name="nuc.sw.i18n.login">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="loginPage"></s:text></title>
</head>
<body>
	<font color="red">${requestScope.error}  </font>
	<font color="red"><s:fielderror></s:fielderror></font>
	<s:form action="loginAction" method="post">
		<s:textfield name="username" key="用户名"></s:textfield>
		<s:password name="password" key="密码"></s:password>
		<s:submit key="login"></s:submit>
	
	</s:form>
	<a href="loginAction?request_locale=en_US"><s:text name="英文显示"></s:text></a>
	<a href="loginAction?request_locale=zh_CN"><s:text name="中文显示"></s:text></a>

</body>
</html>
</s:i18n>