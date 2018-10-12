<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function login(){
		targetForm = document.forms[0];
		targetForm.action="zlq/loginAction!loginMethod";
		targetForm.submit();
	}
	function regist(){
		targetForm = document.forms[0];
		targetForm.action="zlq/registAction!registMethod";
		targetForm.submit();
	}

</script>
</head>

<body>
	<s:fielderror cssStyle="color:red" />
	<s:property value="info"/>
	<s:form action="action!methodName.action" method="post">
		<s:textfield label="姓名" name="username"/><br>
		<s:textfield label="密码" name="password"/><br>
		<s:submit value="登录" onclick="login();"/>
		<s:submit value="注册" onclick="regist();"/>
		 
	</s:form>
</body>
</html>