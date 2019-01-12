<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师管理</title>
<link rel="icon" type="image/x-icon" href="../images/admin.png">
<style type="text/css">
	.tr1 td{
		display: inline-block;
		height:30px;
		line-height:30px;
	}
	.tr2 td{
		display: inline-block;
		height:90px;
		overflow: auto;
	}
	a{
		display:inline-block;
		margin:10px 0;
		text-decoration: none;
		color:blue;
	}
	a:hover {
		color:#00AE85;
	}
</style>
</head>
<body>
	<span style="font-size:18px;color:#00AE85;">学院开课信息：</span><br>
	<a href="UpdateCourseAction">更新课程>></a>
	<table border=1>
		<tr class="tr1">
			<td width="50px" align="center"> 编号</td>
			<td width="130px" align="center"> 课程名称</td>
			<td width="260px" align="center"> 简介</td>
			<td width="400px" align="center"> 详情</td>
		</tr>
		
		<s:iterator value="csList" var="c" status="sbook">
			<tr class="tr2" <s:if test="!#sbook.isOdd()">style="background-color:#1D82FE"</s:if>>
				<td style="line-height:90px;" width="50px" align="center"><s:property value="#c.getId()"/></td>
				<td style="line-height:90px;" width="130px" align="center"><s:property value="#c.getTd()"/></td>
				<td width="260px"><s:property value="#c.getIntroduce()"/></td>
				<td width="400px"><s:property value="#c.getDetails()"/></td>
				
			</tr>
			
		</s:iterator>
		
	</table>