<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="  com.xyz.socialmedia.dao.UserDAO , com.xyz.socialmedia.dto.SignupDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="index.css">
<title>User Profile</title>

</head>
<body>
	
	<%
	UserDAO userdao = new UserDAO();
	SignupDTO signupdto = userdao.getUser(request.getParameter("id"));
	%>
		
<div class="text-center">

						<h1 class="alert alert-success"><%=signupdto.getFirstname() %> <%=signupdto.getLastname() %></h1>	

			<%String path =   "images\\"
                    + request.getParameter("id") + "\\"+request.getParameter("image") ; %>
			<img src="<%=path %>" height="400" width="400">
		
</div>

</body>
</html>