<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.BoardVo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h2>**게시판 목록 **</h2>
	<img src="/Spring03/image/bar.gif" width=800 />
	<table width=800 border=1>
		<tr bgcolor="pink" align="center" height="45">
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr height="40">
				<td align="center"><c:if test="${board.seq == board.root}">${board.seq}</c:if></td>
				<td align="left"><c:forEach begin="1" end="${board.indent}">
						<span>&nbsp;&nbsp;&nbsp;</span>
					</c:forEach> <c:forEach begin="1" end="${board.indent}">
						<span>RE:</span>
					</c:forEach> <a href="/Spring03/bdetail.do?seq=${board.seq}">${board.title}</a></td>
				<td align="center">${board.writer}</td>
				<td align="center">${board.regdate}</td>
				<td align="center">${board.cnt}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center" height="100px">
				<c:forEach var="i" begin="1" end="${totalPage}" step="1">
					<c:choose>
						<c:when test="${i==currPage}">
							<font size=5 color="orange">${i}</font>&nbsp;</c:when>
						<c:otherwise>
							<a href="/Spring03/plist.do?cPage=${i}">${i}</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="/Spring03/mvcBoard/boardCreateView.jsp"> <img
		src="/Spring03/image/kuma.gif"><b> [글쓰기] </b></a>
</body>
</html>