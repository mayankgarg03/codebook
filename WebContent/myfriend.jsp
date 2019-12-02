<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.xyz.socialmedia.dao.UserDAO , java.util.ArrayList ,com.xyz.socialmedia.dto.SignupDTO "%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="index.css">
<meta charset="ISO-8859-1">
<title>My Friend</title>
</head>
<body>

	<h1 class="alert alert-info text-center">My Friends</h1>
		
		<%-- <%=session.getAttribute("email") %> --%>
		<%UserDAO userdao = new UserDAO();
		String mail = (String)session.getAttribute("email");
			ArrayList<String> list = userdao.myFriend(mail,mail);
			SignupDTO signupdto = null;
			if(list!=null){
			for(String obj : list){
				 
				 
				if(!obj.equals(mail)){%>
					<%-- <%=obj %> --%> 
					<%
					signupdto = new SignupDTO();
					 signupdto = userdao.getFriend(obj);
				}
			}
			}
			else{%>
				<p>You Have No Friends Till Now!!</p>
			<%}
				%>
				
	
	            		<table class="table table-bordered">
 						<thead class="thead-dark">
							<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>photo</th>
				
			</tr>
		</thead>
			<tbody>
					
					<% %>
					<tr>
							<% if(signupdto!=null){%>
							<td><%=signupdto.getFirstname() %></td>
							<td><%=signupdto.getLastname() %></td>
							<td><%=signupdto.getEmail() %></td>
							<% String path = "images\\"+ mail + "\\"+signupdto.getPhotoname();%>
							<td><img src= "<%=path %>" height="100" width="100"></td>
					<%} %>
					</tr>
					
					
					
		</tbody>
</table>
		
	
</body>
</html>