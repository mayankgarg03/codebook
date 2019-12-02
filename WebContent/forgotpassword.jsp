<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" type="text/css" href="login.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<h1 class="tect-center alert alert-danger">Welcome to password change page</h1>
<form action="changepassword" method="post">

<div class="form-group">
<label>Enter Email</label>
<input type="email" placeholder="enter email" name="email" class="form-control">
</div>

<div class="form-group">
<label>Enter Old Password you remeber:</label>
<input type="password" placeholder="enter the old password" name="oldpwd" class="form-control">
</div>

<div class="form-group">
<label>Enter New Password</label>
<input type="password" placeholder="enter the new password" name="newpwd" class="form-control">
</div>
<div class="form-group">
<button class="btn btn-primary" type="submit">Submit</button>
</div>
</form>
</body>
</html>