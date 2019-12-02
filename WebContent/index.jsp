<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.xyz.socialmedia.dto.SignupDTO , com.xyz.socialmedia.dto.WallpostDTO ,
    com.xyz.socialmedia.dao.UserDAO,java.util.ArrayList,com.xyz.socialmedia.dto.CommentDTO,com.xyz.socialmedia.dto.LikeDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index page</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="index.css">

 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>

<%-- <script>
      function changedpclicked(){
    	  console.log("hello")
      }
      
      var d = setInterval(()=>{
      		<%=session.getAttribute("sessionMessage")%>
      	}
      },1000);
      
</script> --%>
</head>
<body>
<%
if(session.getAttribute("email") == null){
	response.sendRedirect("LoginSignup.jsp");
	return;
}
%>

<% UserDAO userdao = new UserDAO();
SignupDTO signupdto = userdao.getData(request.getParameter("useremail"));%>
<%=signupdto %>

<%-- 
<% SignupDTO signupdto = (SignupDTO)request.getAttribute("data"); %>
<%=signupdto %> --%>
<%-- <h1>welcome to Index page</h1>
 <%=request.getParameter("useremail") %> 
<h1>${sessionScope.email}</h1> --%>

<!-- Navbar -->

<nav class="navbar navbar-expand-lg navbar-light  fixed-top">
   <a class="navbar-brand logo" href=""><img  src="images/logo.jpeg" height="60px" width="100px"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button> 
  
  <!-- <a class="navbar-brand" href=""><img src="images/facebooklogowhite.png" height="40px" width="270px"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button> -->
  

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      
    </ul>
    <ul class="navbar-nav justify-content-end">
      <li class="nav-item">
        <a href="" class="nav-link js-scroll-trigger"><span style="color: #000000;" class="nav-font"><b>Home</b></span></a>
      </li>
      <li class="nav-item">
        <a href="friendrequest.jsp" class="nav-link js-scroll-trigger"><span class="nav-font navbarlinks"><b>Friend Requests</b></span></a>
      </li>
      <li class="nav-item">
        <a href="myfriend.jsp" class="nav-link js-scroll-trigger"><span class="nav-font navbarlinks"><b>See Friends</b></span></a>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle"  id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <span style="font-weight: bold;cursor: pointer;" class="navbarlinks"><%=session.getAttribute("name").toString() %>'s Profile</span>
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
          <li><a class="dropdown-item" href="editdetails.jsp">Edit Profile</a></li>
    
          <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
        </ul>
      </li> 
      
      
    </ul>
    <datalist id="datalist">
    </datalist>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <form class="form-inline my-2 my-lg-0" method="post" action="searchfriend">
      <input class="form-control mr-sm-2" name="search"  type="text" placeholder="Type a name here">
      <div id="suggestionbox">
      </div>
      <button class="btn navbarsearchbutton my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<br><br><br>


<!-- SideBar -->

<div class="container">
    <div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar" style="padding: 5px;">
				<!-- SIDEBAR USERPIC -->
				<div class="profile-userpic text-center">
				<br>
					<% String filename = request.getParameter("name");
					System.out.println(filename + "at index.jsp line104");
					/* response.setIntHeader("refresh", 10); */
					String profilepicpath = " ";
					if(filename==null){
						UserDAO userdao5 = new UserDAO();
						String imagename = userdao5.getImage((String)request.getParameter("useremail"));
						 profilepicpath = "images\\"
		                           + request.getParameter("useremail") + "\\"+imagename ;
		System.out.println(profilepicpath);
					}
					else{
					 profilepicpath = "images\\"
					                           + request.getParameter("useremail") + "\\"+filename ;
					System.out.println(profilepicpath);
					}
					%>
					                           
					<img onclick="changedpclicked()" src="<%=profilepicpath %>" class="img-responsive profilepic" alt=""><p></p>
					<div id="changedpbutton">
						<form  enctype="multipart/form-data" action="image" method="post">
					       <input id="changedpfilebutton" type="file" name="f1" required>
					       <input class="btn btn-info btn-sm" type="submit" value="Upload" >
					
					    </form>
					</div>
				</div>
				<!-- END SIDEBAR USERPIC -->
				<!-- SIDEBAR USER TITLE -->
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
						 <%=userdao.getName(request.getParameter("useremail")) %>
						<p><%=request.getParameter("useremail") %></p>
					</div>
					<br>
					<div class="profile-usertitle-job">
						<span style="color:#000000; font-weight:bold">Address:</span>  <%=signupdto.getAddress() %>  
					</div>
					<div class="profile-usertitle-job">
						<span style="color:#000000; font-weight:bold">Student at:</span>   <%=signupdto.getStudentAt() %>  
					</div>
					<div class="profile-usertitle-job">
						<span style="color:#000000; font-weight:bold">Works at:</span>  <%=signupdto.getWorksAt()%> 
					</div> 
				</div>
				<div class="profile-userbuttons editdetailsbutton">
					<a  type="button"  href="editprofile.jsp"  class="btn btn-danger btn-sm">Edit details</a>
				</div>
				<div class="profile-userbuttons sendfriendrequestbutton">
					<button type="button" class="btn btn-danger btn-sm">Add as friend</button>
				</div>
				<br>
			</div>
		</div>
		
		<br>
		<div class="col-md-9 postsection">
            <div class="profile-content">
				<div class="card wallpostsshadow" style="">
				
				  	<form action="uploadpost" method="post">
				  	  <div class="card-body">
				  		<textarea placeholder="What's on your mind?" style="border:none; resize: none; width:100%; height:100px" class="form-control" name="postMessage" required=""></textarea>
				  </div>
				  <div class="card-footer">
				  		<button type="submit" class="btn btn-info btn-md">Post</button>
				  </div>
				  </form>
				</div>
				<br>
				
				<div class="card wallpostsshadow">
				<%UserDAO userdao1 = new UserDAO();
				ArrayList<WallpostDTO> list =  userdao1.getAllWallpost();
				if(list!=null){
					for(WallpostDTO obj : list){%>
						<div class="card-body">
					  	<h6 onclick="window.location.assign('index.jsp?useremail=<%=obj.getEmail() %>')" class="card-title postname" style="color: red;"><%=userdao1.getName(obj.getEmail()) %></h6>
						<h6 class="card-text"><%=obj.getPostMessage()%></h6>
				<%-- 		
						<%
						
						UserDAO userdao3 = new UserDAO();
						ArrayList<LikeDTO> list2 = userdao3.getAllLikes(obj.getId());
						if(list2!=null){
							for(LikeDTO likedto:list2){
								String name = userdao3.getName(likedto.getLikedBy());
							
							%>
						
					  <p>Liked By: <span class="text-muted"><%=name%></span></p>  
					  
					  	<%}	
						}
						%> --%>
						
						
						<%-- <a href="LikePost?postId=<%=obj.getId() %>&calledBy=index.jsp?useremail=<%=request.getParameter("useremail") %>" class="btn btn-info btn-sm"><span style="color:#ffffff">Like Post</span></a>  --%> 
					 <a href="likepost?postId=<%=obj.getId() %>&calledBy=<%=request.getParameter("useremail") %>" class="btn btn-info btn-sm"><span style="color:#ffffff">Like Post</span></a> 
					<a href="likedby.jsp?postId=<%=obj.getId() %>"><i class="far fa-thumbs-up"  style="font-size: 20px; margin-left: 5px"></i></a>
					 <a href="postcomment.jsp?postId=<%=obj.getId()%>"><i class="fas fa-comments" style="font-size: 20px; margin-left: 5px"></i> </a>
					
					  </div>
					  <div class="card-footer" style="max-height:130px; overflow-y: scroll;">

					<%-- <%UserDAO userdao2 = new UserDAO();
				ArrayList<CommentDTO> list1 = userdao2.getAllComments(obj.getId());
				if(list1!=null){
					for(CommentDTO commentobj : list1){
					
					String name = userdao2.getName(commentobj.getCommentBy());
							
					%> --%>
					
					
					<%-- <p class="card-subtitle"><span style="font-weight:bold;"><%=getName(rs6.getString(2)) %>:</span> <%=rs6.getString(3) %></p>
						  <p></p> --%>
						  
						 
						  
						  <%-- <p class="card-subtitle"><span style="font-weight:bold;"><%=name%>:</span> <%=commentobj.getCommentMessage() %></p>
						  <p></p> --%>
						
						 
					       <form action="commentpost" method="get" class="form-inline">
		
							<input type="text"  value="<%=obj.getId() %>" readonly="readonly" name="postId" style="display:none;">
							<input type="text" value="<%=session.getAttribute("email") %>" readonly="readonly" name="calledBy" style="display:none;">
								<textarea placeholder="Comment here" style="border:none; resize: none; width:100%; height:50px" class="form-control" name="postMessage" required=""></textarea>
								<button class="btn btn-sm btn-info" style="margin-top: 10px" type="submit">Comment</button>
						   </form>
						  </div>
						<br>
						<hr style="border:2px solid blue">
						  
						  <%}
				}%>
						
					<%-- 	<%	
					}
					}%> --%>
					
					
				<%-- <%}
				%> --%>
						  				
</div>		
</div>
</div>
</div>
</div>
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>