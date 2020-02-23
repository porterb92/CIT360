<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
#submit{
	background-color: #FF4000;
	color: white;
	border: none;
	text-align: left;
	font-size: 20px;
	font-family: arial;
	padding: 6px 25px;
}

#submit:hover{
	background-color: #E6E6E6;
	border: none;
	color: #FF4000;
	text-align: left;
	font-size: 20px;
	font-family: arial;
	padding: 6px 25px;
}

h1{
	text-align: left;
	font-family: arial;
}
p{
	color: #FF4000;
	font-size: 16px;
}
form{
	display: inline-block;
	padding: 20px 0px 20px 90px;
	border: 2px solid white;
	text-align: left;
	width: 240px;
}
body{
	background-color: #0B615E;
	font-family: verdana;
	font-size: 14px;
	color: white;
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<p>Username and/or password are invalid. Please try again.</p>
<form method="post" action="BasicServlet">
	<label for = "uname">Username:</label><br>
	<input type = "text" id = "uname" name = "uname"><br>
	<label for = "pword">Password:</label><br>
	<input type = "password" id = "pword" name = "pword"><br><br>		
	<input type = "submit" id="submit" value = "Login">	
</form>
</body>
</html>