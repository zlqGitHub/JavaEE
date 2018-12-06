<%@ page language="java" import="nuc.sw.dangdang.entity.*,java.util.*,com.opensymphony.xwork2.ActionContext" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>书籍详情页</title>
	<link rel="stylesheet" type="text/css" href="./style/detail.css">
	<script type="text/javascript" src="./js/detail.js"></script>
</head>
<body>
	<span class="logo">中北大学图书网</span>
	<div class="detail">
		<h3 class="detail_title">${abookList[0].getBook_name()}</h3>
		<div class="detail_con">
			<div class="detail_con_left">
				<img id="img" src="http://booklibimg.kfzimg.com/data/book_lib_img_v2/isbn/0/7cca/7ccae78ef705ac36c5f0a755ec3aec79_0_0_0_0.jpg" style="width: 160px;height: 212px; margin-left: 20px;display: block;cursor: pointer;">
				<a href="#">借阅</a>
			</div>
			<div id="img2" class="pic">
				<img src="http://booklibimg.kfzimg.com/data/book_lib_img_v2/isbn/0/7cca/7ccae78ef705ac36c5f0a755ec3aec79_0_0_0_0.jpg" style="width: 240px;height: 318px;cursor: pointer;">
			</div>
			<div class="detail_con_right">
				<div class="detail_con_right_top">
					<div class="info_left">
						<span>作者：${abookList[0].getAuthor()}</span>
						<span>出版社：${abookList[0].getPublisher()}</span>
						<span>出版时间：2018-12</span>
						<span>定价：39.99</span>
					</div>
					<div class="info_right">
						<span>装帧：平装</span>
						<span>开本：其他</span>
						<span>纸张：其他</span>
						<span>分类：${abookList[0].getType()}</span>
					</div>
				</div>

				<div class="introduction">
					<span>${abookList[0].getIntroduction()}</span>
				</div>

			</div>
		</div>
	</div>

	${abookList[0].getBook_id()}
 ${abookList[0].getBook_name()}  

${abookList[0].getAuthor()}
${abookList[0].getPublisher()}
${abookList[0].getIcon()}
${abookList[0].getIntroduction()}
${abookList[0].getType()}
${abookList[0].getNum()}
				
</body>
</html>