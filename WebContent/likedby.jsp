<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.xyz.socialmedia.dao.UserDAO , java.util.ArrayList , com.xyz.socialmedia.dto.LikeDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Likes</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="index.css">

</head>
<body>
			
			<h1 class="alert alert-info text-center" >All Likes for this post:</h1>
				<%
				 String postid =  request.getParameter("postId");
				int id = Integer.parseInt(postid);
						UserDAO userdao3 = new UserDAO();
						ArrayList<LikeDTO> list2 = userdao3.getAllLikes(id);
						if(list2!=null){
							for(LikeDTO likedto:list2){
								String name = userdao3.getName(likedto.getLikedBy());
							
							%>
						
					  <p>Liked By: <span class="text-muted"><strong><%=name%></strong></span></p>  
					  
					  	<%}	
						}
						%>
</body>
</html>