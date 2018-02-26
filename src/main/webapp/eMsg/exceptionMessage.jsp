<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 
<html><head>
<title>**  [ InsertMember.jsp _ MVC ]  **</title>
</head><body>
	<h1>** Member_Spring & Mybatis MVC **</h1> <hr>
	<h1>** 서버에 문제 발생 **</h1>
	<h1>** ${exception.getMessage()} **</h1> 
	<ul>
	<c:foreach items="${exception.getStackTrace()}" var="stack">
	<li>${stack.toString()}</li>
	</c:foreach>
	</ul>
	
	<h3>** 잠시만 기다려 주십시오!  신속히 처리하겠습니다. **</h3>
	<br><br>
	<a href="/Spring03/list.do">[Member List 보기]</a>
</body> </html>