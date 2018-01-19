
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>** update finish **</title>
</head>
<body>
	<c:choose>
		<c:when test="${isUpdate=='T'}">
			<h1>${updateSeq}번 게시물, 수정 성공하였습니다!</h1>
		</c:when>
		<c:otherwise>
			<h1>수정 실패하였습니다.</h1>
		</c:otherwise>	
	</c:choose>
	<img src="/Spring03/image/event_1.png" width=600 height=350>
	<br>
	<br>
	<h2>
		<a href="/Spring03/blist.do">게시판 보러가기</a>
	</h2>
</body>
</html>