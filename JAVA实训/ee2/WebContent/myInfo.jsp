<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>我的页面</title>
	<link rel="icon" type="image/x-icon" href="./images/my.png">
	<link rel="stylesheet" type="text/css" href="./style/myInfo.css">
	<script type="text/javascript" src="./js/myInfo.js"></script>
</head>
<body>
		<div class="table">
			<s:form action="UpdateMyInfoAction" method="post" name="form">
				姓名:<input type="text" name="username" value="${myInfoList[0].getName()}" disabled><br>
				学号:<input type="text" name="userId" value="${myInfoList[0].getStudent_no()}" disabled><br>
				密码:<input id="pass" type="password" name="password" value="${myInfoList[0].getPassword()}"><br>
				性别:<input type="text" name="sex" value="${myInfoList[0].getSex()}" disabled><br>
				年龄:<input type="text" name="age" value="${myInfoList[0].getAge()}" disabled><br>
				电话:<input type="text" name="telphone" value="${myInfoList[0].getTelphone()}"><br>
				院系:<input type="text" name="department" value="${myInfoList[0].getDepartment()}" disabled>
				<s:submit cssClass="submit" cssStyle="width:130px;height:25px;border-radius: 5px;" value="修改"/>
			
			</s:form>
		</div>
</body>
</html>