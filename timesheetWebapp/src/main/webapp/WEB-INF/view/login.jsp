<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<style>
	#form-messages {
		background-color: rgb(225, 232, 232);
		border: 1px solid red;
		color: red;
		display: none;
		font-size: 12px;
		font-weight: bold;
		margin-bottom: 10px;
		padding: 10px 25px;
		max-width: 250px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<body>

	<div class="form">
		<div>
			<ul id="form-messages">
				<li>Generic Error #1</li>
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
		$(document).ready(function () {
			$('#login-submit').click(function (event) {
				event.preventDefault();
				var username = $('#username').val();
				var password = $('#password').val();
				var form = $('#submit-form');

				if (username === "" && password === "") {
					$("#form-messages").css({ "display": "block" }).html('<li>Username can not be emply</li> <li>Password cannot be emply</li>');
				}
				else if (username === "") {
					$("#form-messages").css({ "display": "block" }).text('Username can not be emply');
				}

				else if (password === "") {
					$("#form-messages").css({ "display": "block" }).text('Password can not be emply');
				}

				else {
					var data = 'uname=' + username + '&passwd=' + password;

					$.ajax({
						type: form.attr('method'),
						url: form.attr('action'),
						data: data,
						cache: false,

						success: function (response) {
							if (response === true) {
								console.log('success');
								$(location).attr('href', 'home');
							} else {
								$("#form-messages").css({ "display": "block" }).text('Invalid Credentials');
								console.log('An error occurred.');
							}
						},
						error: function (data) {
							console.log('An error occurred.');
						},

					});
				}

			});

		});

	</script>

</body>

</html>