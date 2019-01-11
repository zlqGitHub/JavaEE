<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>关于我们</title>
</head>
<body>
    <div>
        <span>我是span标签</span>
    </div>
    <script>
        sessionStorage.removeItem("ofHeight");
        sessionStorage.setItem("ofHeight",document.body.offsetHeight);
        console.log(document.body.offsetHeight);
    </script>
</body>
</html>