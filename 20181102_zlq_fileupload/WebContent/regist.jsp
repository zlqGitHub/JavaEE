<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=jutf-8">
<title>Insert title here</title>
</head> 
<body>
	<s:form action="registAction" method="post" enctype="multipart/form-data">
		<s:textfield label="Email地址" name="email"/>
		<s:password label="登录密码" name="password"/>
		<s:password label="确认密码" name="password2"/>
		<s:textfield label="重置姓名(昵称)" name="nickname"/>
		<s:textfield label="真实姓名" name="username"/>
		<s:file label="选择照片"   name="upload"/>
		<s:textfield label="手机号码" name="telphone"/>
		<s:textfield label="省" name="address.province"/>
		<s:textfield label="市" name="address.city"/>
		<s:textfield label="区" name="address.area"/>
		<s:textfield label="街道" name="address.street"/>
		<s:submit value="提交注册"/>
	</s:form>
</body>
</html>