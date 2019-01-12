<%@ page language="java" import="com.opensymphony.xwork2.ActionContext" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>在线报名</title>
	<link rel="icon" type="image/x-icon" href="./images/library3.png">
	<link rel="stylesheet" type="text/css" href="./css/regist.css">
</head>
<body>
	<div class="header">
		<img src="./images/logo_school.png">
		<span>在线报名</span>
	</div>
	<div class="main_bg">
		
	</div>
	
	<script>
        sessionStorage.removeItem("ofHeight");
        sessionStorage.setItem("ofHeight",document.body.offsetHeight);
        console.log(document.body.offsetHeight);
    </script>
	
</body>
</html>
