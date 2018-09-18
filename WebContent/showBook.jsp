<%@ page language="java" import="java.util.*,com.test.book.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 width="300px">
		<tr align="center">
			<td>书名</td>
			<td>作者</td>
			<td>定价</td>
		</tr>
		<%			
			Iterator iter = ((ArrayList<Book>)request.getAttribute("books")).iterator();
			while(iter.hasNext()){
				pageContext.setAttribute("book", iter.next());
		%>
				<tr align="center">
					<td>${book.bookName}</td>
					<td>${book.bookAuthor}</td>
					<td>${book.bookPrice}</td>
				</tr>
					
		<%
		}
		%>
	
	</table>

</body>
</html>