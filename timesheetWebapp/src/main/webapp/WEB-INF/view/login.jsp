<%@ page language="java"  session="false" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
 <script type="text/javascript" src="../JS/login.js"></script>
 <link rel="stylesheet" href="../CSS/login.css">
<body>

	<div class="form">
		<div>
			<ul id="form-messages">
				<!-- AJAX INPUT -->
			</ul>
		</div>
		<div>


			<form id="submit-form" action="/isValid" method="POST">
				<div>
					<label for="username">Username</label>
					<input type="text" name="uname" id="username">
				</div>

				<div>
					<label for="password">Password</label>
					<input type="password" name="passwd" id="password">
				</div>

				<div>
					<input type="submit" name="" id="login-submit" value="Login">
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		
	</script>

</body>

</html>