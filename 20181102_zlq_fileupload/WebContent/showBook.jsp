<%@ page language="java" import="java.util.*,nuc.sw.dangdang.entity.Book,nuc.sw.dangdang.db.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<table border=1>
		<caption>书籍系统</caption>
		<tr>
			<td width="80px" align="center"> 书名</td>
			<td width="80px" align="center"> 作者</td>
			<td width="80px" align="center"> 价格</td>
			<td width="100px" align="center" colspan="2"> 操作</td>
		</tr>
		
		<s:iterator value="books" var="b" status="sbook">
			<tr <s:if test="!#sbook.isOdd()">style="background-color:#1D82FE"</s:if>>
				<td align="center"><s:property value="#b.bname"/></td>
				<td align="center"><s:property value="#b.bauthor"/></td>
				<td align="center"><s:property value="#b.bprice"/></td>	
				<td width="50px" align="center"> <a href='<s:url action="delete_BookAction"><s:param name="bname" value='#b.bname'/></s:url>'>删除</a></td>	
				<td width="50px" align="center"> <a href='<s:url action="updata_BookAction"><s:param name="bname" value='#b.bname' /><s:param name="bauthor" value='#b.bauthor' /><s:param name="bprice" value='#b.bprice' /></s:url>'>修改</a></td>		
			</tr>
			<!-- 
			<s:if test="#sbook.isOdd()">
				<tr>
					<td align="center"><s:property value="#b.bname"/></td>
					<td align="center"><s:property value="#b.bauthor"/></td>
					<td align="center"><s:property value="#b.bprice"/></td>			
				</tr>
			
			</s:if>
			<s:else>
				<tr bgcolor="#1D82FE">
					<td align="center"><s:property value="#b.bname"/></td>
					<td align="center"><s:property value="#b.bauthor"/></td>
					<td align="center"><s:property value="#b.bprice"/></td>			
				</tr>
			
			</s:else>
			 -->
			
		</s:iterator>
		
	</table>
	

</body>
</html>