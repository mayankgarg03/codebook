package com.xyz.socialmedia.utils;

public interface MyQueries {
	
	String 	SIGNUP_SQL = "insert into users(firstName,lastName,email,password,dobDay,dobMonth,dobYear,gender) values (?,?,?,?,?,?,?,?)";
	String LOGIN_SQL = "select email , password , firstName , lastName from users where email = ? and password = ?";
	String UPDATEPASSWORD_SQL= "update users set password=? where email=?";
	String 	GETNAME_SQL = "select firstName,lastName from users where email=?";
	String GETDATA_SQL="select worksAt,studentAt,address from users where email=?";
	String GETUSER_SQL="select firstName,lastName,email,dobDay,dobMonth,dobYear,gender from users where email=?";
	String UPDATEPROFILE_SQL = "update users set address=? , worksAt=? , studentAt=? where email=?";
	String UPDATEFRIENDREQUEST_SQL = "update friendrequest set requestStatus='accepted' and status='n' where fid=?";
	String DELETEFRIENDREQUEST_SQL = "delete from friendrequest where fid=?";
	String FRIENDREQUEST_SQL = "select fid , sendersEmail from friendrequest where receiversEmail=? and requestStatus='notaccepted'";
	String UPDATEDETAILS_SQL = "update users set firstName=?,lastName=?,dobDay=?,dobMonth=?,dobYear=?,gender=? where email=?";
	String SEARCHFRIEND1_SQL = "select firstName,email from users where firstName=? and email <> ?";
	String INSERTFRIEND_SQL = "insert into friendrequest(sendersEmail , receiversEmail) values(?,?)";
	String INSERTWALLPOST_SQL = "insert into wallposts(email,postMessage,dateOfPost) values(?,?,?)";
	String GETALLWALLPOST_SQL = "select wid,email,postMessage,freindsTagged,dateOfPost from wallposts order by wid desc";
	String INSERTCOMMENT_SQL = "insert into comments (postId,commentBy,commentMessage,dateOfComment) values(?,?,?,?)";
	String INSERTLIKES_SQL = "insert into likes (postid , likedby) values(?,?)";
	String GETLIKE_SQL = "select postid , likedby from likes where postid=?";
	String GETALLCOMMENT_SQL = "select cid,postId,commentBy,commentMessage,dateOfComment from comments where postId=? order by cid desc";
	String IMAGE_UPLOAD_PROFILE_SQL = "insert into imageprofile(photoname , path , email) values(?,?,?)";
	String GET_IMAGE_SQL ="select photoname from imageprofile where email=?  order by id desc limit 1";
	String ISFRIEND_SQL = "select receiversEmail,sendersEmail from friendrequest where requestStatus='accepted'";
	String SEARCHFRIEND_SQL = "select firstName,email from users where firstname=? and  email <> ? and email <> ?";
	String MYFREIND_SQL = "select receiversEmail,sendersEmail from friendrequest where sendersEmail=? or receiversEmail=? and requestStatus='accepted'";
	String GETFRIEND_SQL = " select firstName,photoname,lastName,users.email from users,imageprofile where users.email=? and imageprofile.email=? order by id desc limit 1;";
}
