<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
		<h1>You Logout SuccessFully</h1>
<p>Redirect in <span id='sec'></span> sec</p>
<script>
var countDown = 5;
var d = setInterval(()=>{
	document.querySelector("#sec").innerText = countDown;
	countDown--;
	if(countDown==0){
		clearInterval(d);
		location.href="LoginSignup.jsp";
	}
},1000);
</script>
</body>
</html>