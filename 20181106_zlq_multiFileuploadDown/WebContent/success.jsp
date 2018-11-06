<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	上传成功！
	
	<s:iterator value="fileItems" var="fItem">
		<a href="downloadAction?inputPath=${fItem.filePath}&contentType=${fItem.fileName}&downFileName=${fItem.fileName}">${fItem.fileName}</a><br>	
	
	</s:iterator>
	

</body>
</html>