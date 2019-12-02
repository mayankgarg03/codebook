<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.xyz.socialmedia.dao.UserDAO,java.util.ArrayList,com.xyz.socialmedia.dto.CommentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comments</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
				<h1 class=" alert alert-info text-center">Comments for this post are:</h1>
			
			<%
			 String postid =  request.getParameter("postId");
			int id = Integer.parseInt(postid);
			UserDAO userdao2 = new UserDAO();
				ArrayList<CommentDTO> list1 = userdao2.getAllComments(id);
				if(list1!=null){
					for(CommentDTO commentobj : list1){
					
					String name = userdao2.getName(commentobj.getCommentBy());
							
					%>
					<p class="card-subtitle"><span style="font-weight:bold;"><%=name%>:</span> <%=commentobj.getCommentMessage() %></p>
						  <p></p>
						  
						  <%}
				}%>

</body>
</html>