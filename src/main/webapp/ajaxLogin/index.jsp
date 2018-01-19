<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>[index.jsp]</title>
<script src='./jquery-3.2.1.min.js'></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#btnLogin').click(function(){
			$.ajax({
				type: 'Get',
				url: '/Spring03/mlogin.do',
				data: {
					id: $('#id').val(),
					password: $('#password').val()},
				success: function(result){
					$('#resultDisplay').html(result);
				}	
			})
		})
	})
</script>
</head>
<body>
	<div align="center">
		<br>
		<h1>** 환영합니다 !!! _ MVC Member Test **</h1>
		<img src="/Spring03/image/christmas.png" width=600 height=350><br>
		<br> <img src="/Spring03/image/bar.gif" width=600><br>
		<h2>Login 하기</h2>
		<br>
		<div id="resultDisplay">
			<form>
				<table align="center">
					<tr>
						<td>ID :</td>
						<td><input type="text" id="id" name="id" size="10"></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password" id="password" name="password" size="10"></td>
					</tr>
					<tr height=60>
						<td></td>
						<td><input type="button" value="Login " id='btnLogin'></td>
					</tr>
				</table>
			</form>
			<h2>
				<a href="/Spring03/mvcMember/joinForm.html">memberJoin</a>
			</h2>
			<h2>
				<a href="/Spring03/mlist.do">memberList</a>
			</h2>
		</div>
</body>
</html>










