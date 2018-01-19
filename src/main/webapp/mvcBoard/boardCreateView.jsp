<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>** Board Create Form **</title>
</head>
<body>
	<h1>** 게시글 작성하기 **</h1>
	<img src="/Spring03/image/bar.gif" width=800 />
	<br>
	<form action="/Spring03/bcreate.do" method="post">
		<table border="1">
			<tr height="40">
				<td bgcolor="gray" width="100" align="center">작성자</td>
				<td align="left" width="500"><input type="text" name="writer"></input></td>
			</tr>
			<tr height="40">
				<td bgcolor="gray" width="100" align="center">제목</td>
				<td align="left" width="500"><input type="text" name="title"></input></td>
			</tr>
			<tr height="40">
				<td colspan="2" align="left" width="500"><input type="text"
					name="content" size="120" style=""></input></td>
			</tr>
			<tr height="40">
				<td colspan="2" align="center"><input type="submit"
					value="입  력" />
			</tr>
		</table>
	</form>
</body>
</html>