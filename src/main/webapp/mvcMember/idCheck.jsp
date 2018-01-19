<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>** ID 중복 확인 **</title>
<script src="../resources/js/jquery-3.2.1.min.js"></script>
<script src="../resources/js/inCheckM.js"></script>
<script type="text/javascript">
function idOK(){
	window.opener.document.myform.id.value = "${userId}";
	window.opener.document.myform.password.focus();
	window.close();
}
</script>
</head>
<body style="width: 300px;height: 300px">
<h1>** ID 중복 확인 **</h1>
<!-- <form action="/Spring03/idcheck.do" method="get" name=icform> -->
<form>
User ID <input type=text name=id id=id value="${userId}">
		<button value="ID 확인" onclick="idCheck()">id확인</button><br>
		<div>
			<c:if test="${resultId > 0}"><div style="color:red">사용 중인 ID 입니다.</div></c:if>
			<c:if test="${resultId == 0}">사용 가능한 ID 입니다.
			<input type="button" value="사용" onclick="idOK()"/>
 			</c:if>
		</div>
</form>
</body>
</html>