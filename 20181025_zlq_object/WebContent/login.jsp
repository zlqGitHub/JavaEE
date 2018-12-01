<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>登录页面</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/login.css">
</head>
<body>
	<div class="header">
		<a href="#">
			<img src="./images/logo_school.png">
			<span>数字化校园认知中心</span>
		</a>
	</div>

	<div class="main">
		<div class="main_left">
			<img src="./images/library.jpg" width="480px" height="345px">
		</div>
		<div class="main_right">
			<span>欢迎登录</span>
			<s:form action="" name="form1" method="post">
				<s:textfield name="student_no" placeholder="用户名"/>
				<s:password name="password" placeholder="密码"/>
				<s:submit value="登录" cssStyle="display:block;background: #6993DB;border:none;color: #FFF;font-size: 18px;letter-spacing: 10px;margin-left:7px;"/>
				
			</s:form>
			<text>还没有账号？<a href="regist.jsp" target="frame">立即注册>></a></text>
		</div>
	</div>

	<div class="bottom">
		<span>版权所有：田园实验室　CopyRight 2018-2020　地址：山西省太原市学院路3号</span><br>
		<span>Cop邮政编码：030051　　非经营性互联网信息服务审批号　(晋)ICP备05000467号</span>
	</div>
	
</body>
</html>