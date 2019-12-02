<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.xyz.socialmedia.dto.SignupDTO , com.xyz.socialmedia.dao.UserDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" href="editprofile.css">
</head>
<body>
		
        <h1 class="text-center alert alert-info">Edit Details</h1>
         <%String email = (String)session.getAttribute("email"); %> 
        
			<% UserDAO userdao = new UserDAO();
			SignupDTO signupdto = userdao.getData(email);%>
			
			
 <div class="edit">
      <form action="updateprofile" method="post">
        <div class="form-group">
        	<label for="studentat" class="student">Student at:</label>
        	<input  value="<%=signupdto.getStudentAt()%>"  name="studentat" id="studentat" value="" type="text" name="studentAt" class="form-control" placeholder="Your school" required="required">
        </div>
        <div class="form-group">
        	<label for="worksat" class="works">Works at:</label>
        	<input  value="<%=signupdto.getWorksAt() %> " id="worksat" name="worksat" value="" type="text" name="worksAt" class="form-control" placeholder="Your work place" required="required">
        </div>
        <div class="form-group">
        	<label for="address" class="address">Address:</label>
        	<input  value="<%=signupdto.getAddress() %>"   id="address" name="address" type="text" class="form-control" placeholder="Your address" required="required">
        </div>
      <div class="form-group">
      	<button type="submit"  class="btn btn-info btn-md update">Update</button>
      </div>
      </form>
   </div>
		
</body>
</html>