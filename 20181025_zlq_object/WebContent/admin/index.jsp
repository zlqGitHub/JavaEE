<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<link rel="stylesheet" type="text/css" href="../style/admin-index.css">
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<title>管理系统</title>
	
	<script type="text/javascript" src="./js/jquery-1.4.4.js"  charset="gbk"></script>
	
	<script type="text/javascript">
		 function refreshCode(){
		 	document.getElementById("imgCode").src= "code.jhtml?hehe="+Math.random();
		 }
	</script>
	
</head>
<body>
	<div class="login-box">
		<div class="login-main">
			<form action="AdminAction" method="post" class="form">
		        <input type="text" name="admin" value=""><br>
		        <input type="password" name="pass" value=""><br>
		        <input class="input1" type="text" name="validation" value="">
		        <img class="img" onclick="refreshCode();" id="imgCode" title="看不清楚?点我换一张" src="code.jhtml" width="80px" height="20px" />
		        <button type="submit" class="submit"></button>
		        
			</form>
		</div>
	</div>

</body>
</html>