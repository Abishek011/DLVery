<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/testlog" name="testlogin"  method="post"> 
	<input type="submit" name="btn" class= "button" value="login" >
	</form><br>
	<form action="<%= request.getContextPath() %>/testlog" name="testlogout"  method="post"> 
	<input type="submit" class= "button" value="logout" name="btn">
	</form><br>
</body>
</html>