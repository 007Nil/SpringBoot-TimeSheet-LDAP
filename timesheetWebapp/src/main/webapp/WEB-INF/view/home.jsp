<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="../CSS/home.css">
	<script type="text/javascript" src="/JS/home.js"></script>
</head>

<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
	%>
	<div class="main">
		<div class="nav-bar">
			<ul>
				<li><a href="#">Mail</a></li>
				<li><a href="#">Timesheet</a></li>
				<li><a href="#">Settings</a></li>
				<li style="float:right"><a class="active" href="/logout">Logout</a>
			</ul>
		</div>
		<div class="usertable-div">
			<table id="userDetails-table">
				<thead>
					<tr>
						<th colspan="2">User Details</th>
					</tr>
				</thead>
				<tbody id="table-data">
					<!-- Fillup using Javascript -->
				</tbody>
			</table>
		</div>
	</div>




</body>

</html>