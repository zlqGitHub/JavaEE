<%@ page language="java" import="nuc.sw.dangdang.entity.*,java.util.*,com.opensymphony.xwork2.ActionContext" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
			<span>欢迎&nbsp;<a id="myInfo" class="a0" title="我的信息" href="myInfo.jsp">[<%=ActionContext.getContext().getSession().get("username") %>]</a>&nbsp;登录</span>
		</s:if>
		<s:else>
			<span><a class="a0" href="login.jsp">未登录</a></span>
		</s:else>
		<a class="a1" href="LoginedAction">我的借阅</a>
		<a class="a2" href="LeaveingAction" target="_parent">注销</a>
		<div id="info" class="myInfo">
			<div class="image">
				<img src="${list[0].getIcon()}" width="90px" height="110px;">
			</div>
			<span class="name">${list[0].getName()}</span>
		</div>
	</div>

	<div class="main" id="main">
		<div class="left" id="left">
			<div class="logo">
				<img src="./images/library.gif" width="130px" height="130px" style="border-radius: 50%;margin: 25px;">
			</div>
			<div class="bookType">
				<ul class="menu">
					<li>
						<a href="TypeSelectAction?type='全部'">全部</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='小说'">小说</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='文学'">文学</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='心理'">心理</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='成功励志'">成功励志</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='历史'">历史</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='管理'">管理</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='生活'">生活</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='互联网'">互联网</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='体育'">体育</a>
					</li>
					<li>
						<a href="TypeSelectAction?type='自然学科'">自然科学</a>
					</li>
				</ul>
			</div>

		</div>
	
		<div class="right" id="right">
			<div class="form">
				<table>
					<tr>
						<s:form action="BookNameSelectAction" method="post" name="form3">
							<td><s:textfield cssClass="content" name="bookName" placeholder="商品名称、作者、出版社"/></td>
							<td><s:submit cssClass="submit" value=" "/></td>
						</s:form>
						
					</tr>
				</table>
			</div>

			<div class="books">
				<h3>         
					<span class="title">以下图书可供借阅</span>
				</h3>
				
				
				<s:iterator value="bookList" var="b">
					<div>
						<a href="BookIdSelectAction?id=${b.getBook_id()}" class="pic" target="_blank">
							<img src="${b.getIcon()}">
						</a>
						<p class="book_type">
							<span class="type_b">${b.getType()}</span>
						</p>
						<p class="book_name">
							<a href="BookIdSelectAction?id=${b.getBook_id()}"><span class="type_n">${b.getBook_name()}</span></a>
						</p>
						<p class="book_author">${b.getAuthor()}</p>
					</div>
				</s:iterator>
			</div>
			
			<span class="tip">没有更多了~~~</span>

		</div>

	</div>
	
	<div class="footer">
		<s:text name="">© 2018-2020 ZlqStudy.com 中北大学文澜苑田园实验室 版权所有</s:text>
	</div>
	
	
<!-- 
	${list[0].getIcon()}   
	${bookList[0]}   
 -->	       

	<script type="text/javascript" src="./js/main.js"></script>
</body>
</html>