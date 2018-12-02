<%@ page language="java" import="java.util.*,com.opensymphony.xwork2.ActionContext" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>主页面</title>
	<link rel="stylesheet" type="text/css" href="./style/main.css">
</head>
<body>
	<div class="header">
		<img src="./images/logo_school.png">
		<a href="http://lib.nuc.edu.cn/new/index.action" target="_blank" title="关于我们"><img src="./images/book.png" style="width: 64px;height: 64px;position: absolute;right: -800px;"></a>
		<span>图书馆借阅</span>
	</div>
	<div class="shortcut">
		<s:if test="(#session.username) != '' ? 1 : 0">
			<span>欢迎&nbsp;<a class="a0" href="my.jsp">[<%=ActionContext.getContext().getSession().get("username") %>]</a>&nbsp;登录</span>
		</s:if>
		<s:else>
			<span><a class="a0" href="login.jsp">未登录</a></span>
		</s:else>
		<a class="a1" href="LoginedAction">我的借阅</a>
		<a class="a2" href="LeaveingAction" target="_parent">注销</a>
	</div>

	<div class="main">
		<div class="left">
			<div class="logo">
				<img src="./images/library.gif" width="130px" height="130px" style="border-radius: 50%;margin: 25px;">
			</div>
			<div class="bookType">
				<ul class="menu">
					<li>
						<a href="#">全部</a>
					</li>
					<li>
						<a href="#">科普类</a>
					</li>
					<li>
						<a href="#">计算机类</a>
					</li>
					<li>
						<a href="#">英语系</a>
					</li>
				</ul>
			</div>

		</div>
	
		<div class="right">
			<div class="form">
				<table>
					<tr>
						<form action="#" method="post" name="form3">
							<td><input class="content" type="text" name="search" placeholder="商品名称、作者、出版社"></td>
							<td><input class="submit" type="submit" name="submit" value=""></td>
						</form>
					</tr>
				</table>
			</div>

			<div class="books">

			</div>


		</div>

	</div>
	
</body>
</html>