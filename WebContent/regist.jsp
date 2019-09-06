<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>
</head>
<body>
	<div>
		<form action="User" method="post">
			<input type="hidden" name="method" value="regist">
			邮箱：<input type="text" name="email" />
			密码：<input type="password" name="email">
			密码：<input type="password" name="emailConfirm">
			<input type="submit" name="submit" value="注册">
		</form>
	</div>
</body>
</html>