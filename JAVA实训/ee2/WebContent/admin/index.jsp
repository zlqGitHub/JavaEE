<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<link rel="stylesheet" type="text/css" href="../css/admin-index.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<title>管理系统</title>
	
</head>
<body>
	<div class="login-box">
		<div class="login-main">
			<form action="AdminLoginAction" method="post" class="form">
		        <input type="text" name="admin" value=""><br>
		        <input type="password" name="pass" value=""><br>
		        <select class="select" id="login" name="type">
					<option value="学校">学校</option>
					<option value="企业A">企业A</option>
					<option value="企业B">企业B</option>
					<option value="企业C">企业C</option>
                </select>
		        
		        <button type="submit" class="submit"></button>		     
			</form>
		</div>
	</div>

</body>
</html>