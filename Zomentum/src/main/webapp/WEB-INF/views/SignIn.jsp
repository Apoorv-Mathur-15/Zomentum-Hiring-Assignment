<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignIn</title>
<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<form action="/signin" method=POST>
		<div class="container-fluid">
			<div class="input-group">
				Email:	<input class="input100" type="text" name="email" placeholder="Enter your username/email">
			</div>
			<div class="input-group">
			Password: <input class="input100" type="text" name="password" placeholder="Enter your password">
			</div>
			<br><button class="btn btn-success" style="width: 64px; ">Submit</button>
		</div>
	</form>
	
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>