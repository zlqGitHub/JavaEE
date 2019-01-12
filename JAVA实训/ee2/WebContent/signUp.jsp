<%@ page language="java" import="com.opensymphony.xwork2.ActionContext" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>在线报名</title>
	<link rel="icon" type="image/x-icon" href="./images/library3.png">
	<link rel="stylesheet" type="text/css" href="./css/signUp.css">
</head>
<body>
	<div class="header">
		<img src="./images/logo_school.png">
		<span>在线报名</span>
	</div>
	<div class="main_bg">
        <div class="main">
            <div class="myInfo">
                <span class="span1">填写表单</span>
                <form action="GignUpAction" class="form">
                	<span class="tip">注意>>你还有3提交报名的机会！！！</span>
                    <input class="input" type="text" placeholder="学号" name="userid"><br>
                    <input class="input" type="text" placeholder="姓名" name="username"><br>
                    <select class="input" name="td" class="select">
                        <option value="Java技术">Java技术</option>
                        <option value="大数据技术">大数据技术</option>
                        <option value="数据库技术">数据库技术</option>
                        <option value="前端">前端</option>

                    </select>

                    <input type="submit" class="submit" value="提交报名">

                </form>

            </div>
            <div class="info">
                <span class="span2">联系我们</span>
                <div style="padding-top: 50px;">
                    <div class="info_div">
                        <div><img class="img1" src="./images/dizhi.png" width="25px"></div>
                        <span class="info_span">地址：中北大学软件学院</span>
                    </div>
                    <div class="info_div">
                        <div><img src="./images/youxiang.png" width="20px"></div>
                        <span class="info_span">邮箱：email@email.com</span>
                    </div>
                    <div class="info_div">
                        <div><img src="./images/tel.png" width="20px"></div>
                        <span class="info_span">电话：15513268481</span>
                    </div>
                </div>
            </div>

        </div>

    </div>	
	
	
	
</body>
</html>
