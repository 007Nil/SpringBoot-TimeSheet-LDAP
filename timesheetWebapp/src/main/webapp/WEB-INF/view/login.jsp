<%@ page language="java"  session="false" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="../CSS/login.css">
	<script type="text/javascript" src="/JS/login.js"></script>
</head>

<body>
	<div class="main">
		<p class="sign" align="center">Sign in</p>
		<div>
			<ul id="form-messages">
			 &nbsp;
			</ul>
		</div>
		<div class="form-div">
			<form class="form1" id="submit-form" action="isValid" method="POST">
				<input class="un " id="username" name="uname" type="text" align="center" placeholder="Username">
				<input class="pass" id="password" name="passwd" type="password" align="center" placeholder="Password">
				<input class="submit" id="login-submit" type="submit" align="center" value="Sign in"></input>
				<p class="forgot" align="center"><a href="#">Forgot Password?</p>
			</form>
		</div>
	
	
		</div>
</body>

</html>