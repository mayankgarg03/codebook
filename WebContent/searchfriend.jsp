<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList , com.xyz.socialmedia.dto.SignupDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search friend</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

<h1 class="alert alert-info text-center">Search Friend</h1>


<table class="table table-bordered">
<thead class="thead-dark">
<tr>
<th>Name</th>
<th>Email</th>
<th>Operations</th>
</tr>
</thead>
<tbody>
<%ArrayList<SignupDTO> list = (ArrayList<SignupDTO>)request.getAttribute("friend");
if(list!=null){
	for(SignupDTO obj : list){
		%>
		<tr>
		<td><%=obj.getFirstname() %></td>
		<td><%=obj.getEmail() %></td>
		 <td><a href="send?senderemail=<%=obj.getEmail()%>">Send</a> 
		 <br>
		  <a  href="load?id=<%=obj.getEmail()%>">See Profile</a></td>  
		</tr>
		<% 
	}
} %>
</tbody>
</table>

</body>
</html>