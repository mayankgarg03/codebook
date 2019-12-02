<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.xyz.socialmedia.dao.UserDAO , com.xyz.socialmedia.dto.FriendRequestDTO , java.util.ArrayList "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friend Request</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
		
		<h1 class="text-center alert alert-info">Friend Request</h1>
		
		  <%   if(request.getParameter("msg")!=null){%>
        <p><strong><%= request.getParameter("msg")%></strong></p>  
    <%}
      else{ %>
    			<p></p>
    			<%} %>
	
		<%UserDAO userdao = new UserDAO(); 
		ArrayList<FriendRequestDTO> list = userdao.getFriendRequest((String)session.getAttribute("email"));%>
		
		
       <%--  <%
        Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/facebook?user=root&password=test123");
		PreparedStatement statement = con.prepareStatement("select * from friendrequest where receiversEmail=? and requestStatus='NOTACCEPTED'");
		statement.setString(1, session.getAttribute("sessionEmail").toString());
		ResultSet rs = statement.executeQuery();
		while(rs.next()){ 
			%>--%>
			
		<% 
					if(list!=null){
							for(FriendRequestDTO obj : list){%>
				<div class="card">
				  <div class="card-body">
				     <h5 class="card-title"> receiver:<%=userdao.getName((String)session.getAttribute("email"))%></h5>
				    <h6 class="card-text"> sender:<%=obj.getSendersmail() %></h6> 
				  </div>
				  <div class="card-footer">
				  	<a href="AcceptRequest?id=<%=obj.getFid() %>&name=<%=obj.getSendersmail() %>" class="btn btn-sm btn-info"><span style="color:#ffffff">Accept</span></a> 
				  	<a href="deleterequest?id=<%=obj.getFid()%>"class="btn btn-sm btn-danger"><span style="color:#ffffff">Delete</span></a>
				  </div>
				</div>
			<%}
			}%> 
			
    


</body>
</html>