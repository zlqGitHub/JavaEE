<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>学校后台管理</title>
	<link rel="stylesheet" href="./css/admin.css">
	<script type="text/javascript" src="./js/jquery.min.js" ></script>
	<script type="text/javascript" src="./js/admin.js" ></script>
</head>
<body>
	<div class="left">
		<div class="bigTitle">后台管理系统</div>
		<div class="lines">
			<div onclick="pageClick(this)" class="active">
				<img src="images/icon-1.png" />
				<a href="nameListAction" target="main">查看报名表</a>
			</div>
			<div onclick="pageClick(this)">
				<img src="images/icon-2.png" />
				<a href="tdListAction" target="main">分班</a>
			</div>
			<div onclick="pageClick(this)">
				<img src="images/icon-3.png" />
				<a href="classesListAction" target="main">查看分班表</a>
			</div>
		</div>
	</div>

	<div class="top">
			<div class="leftTiyle" id="flTitle">业务人员管理</div>
			<div class="thisUser">当前用户：${sessionScope.admin}</div>
	</div>

	<iframe name="main" target="_parent" frameborder="0" scrolling="no" class="content-main" id="content-main" src="">
	</iframe>
		 
</body>
</html>