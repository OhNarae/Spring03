<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>** Board Detail Form **</title>
</head>
<body>
	<h1>** 게시글 상세보기 **</h1>
	<br>
	<form action="/Spring03/bupdate.do" method="post">
		<table bordercolor="black" border="1">
			<tr height="40" >
				<td bgcolor="gray" align="center">번호</td>
				<td align="left" width="500"><input type="text" name="seq"
					value="${boardDetail.seq}" readonly="readonly"></input></td>
			</tr>
			<tr height="40">
				<td bgcolor="gray" width="100" align="center">작성자</td>
				<td align="left" width="500"><input type="text" name="writer"
					value="${boardDetail.writer}" readonly="readonly"></input></td>
			</tr>
			<tr height="40">
				<td bgcolor="gray" width="100" align="center">제목</td>
				<td align="left" width="500"><input type="text" name="title"
					value="${boardDetail.title}"></input></td>
			</tr>
			<tr height="40">
				<td colspan="2" align="center" width="500"><textarea
					name="content" style="width: 99%;height: inherit;">${boardDetail.content}</textarea></td>
			</tr>
			<tr height="40">
				<td bgcolor="gray" width="100" align="center">작성일자</td>
				<td align="left" width="500"><input name="regdate" type="date"
					value="${boardDetail.regdate}" size="300" readonly="readonly"></input></td>
			</tr>
			<tr height="40">
				<td bgcolor="gray" width="100" align="center">조회수</td>
				<td align="left" width="500"><input type="text" name="cnt"
					value="${boardDetail.cnt}" readonly="readonly"></input></td>
			</tr>
			<tr height="40">
				<td colspan="2" align="center"><input type="submit"
					value="수  정" />
			</tr>
		</table>
	</form>
	<br>
	<br>
	<a href="/Spring03/mvcBoard/insertRForm.jsp"><b> [댓글쓰기] </b></a>
	<a href="/Spring03/bdelete.do?root=${boardDetail.root}"> <img
		src="/Spring03/image/kuma.gif"><b> [삭제하기] </b></a>
	<a href="/Spring03/blist.do"><b> [목록으로] </b></a>
</body>
</html>