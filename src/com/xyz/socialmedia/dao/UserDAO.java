package com.xyz.socialmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.xyz.socialmedia.utils.CommonDAO;
import com.xyz.socialmedia.utils.MyQueries;
import com.xyz.socialmedia.dto.CommentDTO;
import com.xyz.socialmedia.dto.FriendRequestDTO;
import com.xyz.socialmedia.dto.LikeDTO;
import com.xyz.socialmedia.dto.LoginDTO;
import com.xyz.socialmedia.dto.SignupDTO;
import com.xyz.socialmedia.dto.WallpostDTO;

public class UserDAO {
		public String signUp(SignupDTO signupdto) throws ClassNotFoundException, SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(MyQueries.SIGNUP_SQL);
			pstmt.setString(1, signupdto.getFirstname());
			pstmt.setString(2,signupdto.getLastname() );
			pstmt.setString(3, signupdto.getEmail());
			pstmt.setString(4, signupdto.getPassword());
			pstmt.setString(5, signupdto.getDobDay());
			pstmt.setString(6, signupdto.getDobMonth());
			pstmt.setString(7, signupdto.getDobYear());
			pstmt.setString(8, signupdto.getGender());
			int result = pstmt.executeUpdate();
			return result>0 ?"insert successfully" :"";
			
		}
			finally {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			}
		}
		
		
		public SignupDTO doLogin(LoginDTO logindto) throws ClassNotFoundException, SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			SignupDTO signupdto = null;
			try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(MyQueries.LOGIN_SQL);
			pstmt.setString(1, logindto.getEmail());
			pstmt.setString(2, logindto.getPassword());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(signupdto == null) {
					signupdto = new SignupDTO();
					signupdto.setEmail(rs.getString("email"));
					signupdto.setPassword(rs.getString("password"));
					signupdto.setFirstname(rs.getString("firstName"));
					signupdto.setLastname(rs.getString("lastName"));
//					signupdto.setAddress(rs.getString("address"));
//					signupdto.setStudentAt(rs.getString("studentAt"));
//					signupdto.setWorksAt(rs.getString("worksAt"));
					
				}
			}
		}
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			}
			return signupdto;
		}
		
		public String updatePassword(String password , String email) throws ClassNotFoundException, SQLException {
			Connection con= null;
			PreparedStatement pstmt = null;
			
			try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.UPDATEPASSWORD_SQL);
				pstmt.setString(1, password);
				pstmt.setString(2, email);
				int record = pstmt.executeUpdate();
				return record>0 ?"password update successfully" :"password not updated";
				
			}
				finally {
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
				}
			}
				
		
			
			
			

		public SignupDTO getData(String email) throws ClassNotFoundException, SQLException {
			Connection con= null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			SignupDTO signupdto = null;
			try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.GETDATA_SQL);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					signupdto = new SignupDTO();
					signupdto.setWorksAt(rs.getString("worksAt"));
					signupdto.setAddress(rs.getString("address"));
					signupdto.setStudentAt(rs.getString("studentAt"));
				}
		}
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			
			}
			return signupdto;
		}
		
		

		public SignupDTO getUser(String email) throws ClassNotFoundException, SQLException {
			Connection con= null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			SignupDTO signupdto = null;
			try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.GETUSER_SQL);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					signupdto = new SignupDTO();
					signupdto.setFirstname(rs.getString("firstName"));
					signupdto.setLastname(rs.getString("lastName"));
					signupdto.setEmail(rs.getString("email"));
					signupdto.setDobDay(rs.getString("dobDay"));
					signupdto.setDobMonth(rs.getString("dobMonth"));
					signupdto.setDobYear(rs.getString("dobYear"));
					signupdto.setGender(rs.getString("gender"));
				}
		}
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			
			}
			return signupdto;
		}
		
		
		public ArrayList<FriendRequestDTO> getFriendRequest(String email) throws ClassNotFoundException, SQLException {
			Connection con= null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			FriendRequestDTO frdto = null;
			ArrayList<FriendRequestDTO> list = new ArrayList<FriendRequestDTO>();
			try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(MyQueries.FRIENDREQUEST_SQL);
			pstmt.setString(1,email);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 System.out.println("enter while");
				 frdto = new FriendRequestDTO();
				 System.out.println(rs.getInt("fid"));
				 frdto.setFid(rs.getInt("fid"));
				 frdto.setSendersmail(rs.getString("sendersEmail"));
				 list.add(frdto);
				 
			 }
			
		}
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			
			}
			return list;
			
		}
		
		public String getName(String email) throws ClassNotFoundException, SQLException{
			String name = "";
			
				
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.GETNAME_SQL);
				pstmt.setString(1, email);
				 rs = pstmt.executeQuery();
				while(rs.next()){
					name = rs.getString("firstname") + " " + rs.getString("lastname");
					System.out.println(rs.getString("firstname") + " " + rs.getString("lastname"));
				}
				
			} 
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			
			}
				return name;
				
		}



			public String updateUserProfile(String address,String worksAt , String studentAt,String email) throws ClassNotFoundException, SQLException {
				
				 Connection con = null;
				 PreparedStatement pstmt = null;
				 try {
				 con = CommonDAO.getConnection();
				 pstmt = con.prepareStatement(MyQueries.UPDATEPROFILE_SQL);
				 pstmt.setString(1,address);
				 pstmt.setString(2,worksAt);
				 pstmt.setString(3, studentAt);
				 pstmt.setString(4, email);
				 int record = pstmt.executeUpdate();
				 return record>0?"successfully inserted" : "not inserted error occured";
				 }
				 finally {
					 if(pstmt!=null) {
						 pstmt.close();
					 }
					 if(con!=null) {
		               con.close();
				 }
				 }
				
			}
			
			
			public String updateUserDetails(SignupDTO signupdto,String email) throws ClassNotFoundException, SQLException {
				
				 Connection con = null;
				 PreparedStatement pstmt = null;
				 try {
				 con = CommonDAO.getConnection();
				 pstmt = con.prepareStatement(MyQueries.UPDATEDETAILS_SQL);
				 pstmt.setString(1,signupdto.getFirstname());
				 pstmt.setString(2,signupdto.getLastname());
				 pstmt.setString(3, signupdto.getDobDay());
				 pstmt.setString(4, signupdto.getDobMonth());
				 pstmt.setString(5, signupdto.getDobYear());
				 pstmt.setString(6, signupdto.getGender());
				 pstmt.setString(7,email);
				 int record = pstmt.executeUpdate();
				 return record>0?"successfully inserted" : "not inserted error occured";
				 }
				 finally {
					 if(pstmt!=null) {
						 pstmt.close();
					 }
					 if(con!=null) {
		               con.close();
				 }
				 }
				
			}
			
            public String deleteFriend(int id) throws ClassNotFoundException, SQLException {

				 Connection con = null;
				 PreparedStatement pstmt = null;
				 try {
				 con = CommonDAO.getConnection();
				 pstmt = con.prepareStatement(MyQueries.DELETEFRIENDREQUEST_SQL);
				 pstmt.setInt(1,id);
				 int record = pstmt.executeUpdate();
				 return record>0?"successfully deleted" : "not deleted error occured";
				 }
				 finally {
					 if(pstmt!=null) {
						 pstmt.close();
					 }
					 if(con!=null) {
		               con.close();
				 }
				 }
				
			}
			
			
			public String updateFriendRequest(int id) throws ClassNotFoundException, SQLException {
				
				 Connection con = null;
				 PreparedStatement pstmt = null;
				 try {
				 con = CommonDAO.getConnection();
				 pstmt = con.prepareStatement(MyQueries.UPDATEFRIENDREQUEST_SQL);
				 pstmt.setInt(1,id);
				
				 int record = pstmt.executeUpdate();
				 return record>0?"successfully inserted" : "not inserted error occured";
				 }
				 finally {
					 if(pstmt!=null) {
						 pstmt.close();
					 }
					 if(con!=null) {
		               con.close();
				 }
				 }
				
			}
		
			public ArrayList<FriendRequestDTO> isFriend() throws SQLException, ClassNotFoundException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ArrayList<FriendRequestDTO> friendlist = null;
				FriendRequestDTO frdto = null;
				//String rmail = null;
				try {
					con = CommonDAO.getConnection();
					pstmt = con.prepareStatement(MyQueries.ISFRIEND_SQL);
					//pstmt.setString(1, semail);
//					pstmt.setString(2, remail);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						frdto = new FriendRequestDTO();
						friendlist = new ArrayList<FriendRequestDTO>();
						frdto.setSendersmail(rs.getString("sendersEmail"));
						frdto.setReceiversmail(rs.getString("receiversEmail"));
						friendlist.add(frdto);
						//rmail = rs.getString("receiversEmail");
						
					}
				}
				finally {
					if(rs!=null) {
						rs.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
			}
				return friendlist;
				
			}


			public ArrayList<SignupDTO> searchFriend(String search,String smail , String rmail) throws ClassNotFoundException, SQLException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ArrayList<SignupDTO> list = new ArrayList<SignupDTO>();
				SignupDTO signupdto = null;
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.SEARCHFRIEND_SQL);
				pstmt.setString(1, search);
				pstmt.setString(2, smail);
				pstmt.setString(3, rmail);
				 rs = pstmt.executeQuery();
				while(rs.next()){
					//System.out.println("inside while at userdao searchfriend");
					signupdto = new SignupDTO();
					signupdto.setFirstname(rs.getString("firstName"));
					signupdto.setEmail(rs.getString("email"));
					list.add(signupdto);
				}
				
			} 
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			
			}
				return list;
				
			}
			
			public ArrayList<SignupDTO> searchFriend1(String search,String mail) throws ClassNotFoundException, SQLException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ArrayList<SignupDTO> list = new ArrayList<SignupDTO>();
				SignupDTO signupdto = null;
				try {
				con = com.xyz.socialmedia.utils.CommonDAO.getConnection();
				pstmt = con.prepareStatement(com.xyz.socialmedia.utils.MyQueries.SEARCHFRIEND1_SQL);
				pstmt.setString(1, search);
				pstmt.setString(2, mail);
				
				 rs = pstmt.executeQuery();
				while(rs.next()){
					//System.out.println("inside while at userdao searchfriend");
					signupdto = new SignupDTO();
					signupdto.setFirstname(rs.getString("firstName"));
					signupdto.setEmail(rs.getString("email"));
					list.add(signupdto);
				}
				
			} 
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			
			}
				return list;
				
			}
			
			
			
			public ArrayList<String> myFriend(String mail , String mail1) throws ClassNotFoundException, SQLException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String rmail = null;
				String smail = null;
				ArrayList<String> list = null;
				try {
				con = com.xyz.socialmedia.utils.CommonDAO.getConnection();
				pstmt = con.prepareStatement(com.xyz.socialmedia.utils.MyQueries.MYFREIND_SQL);
				pstmt.setString(1, mail);
				pstmt.setString(2, mail1);
				
				 rs = pstmt.executeQuery();
				while(rs.next()){
					//System.out.println("inside while at userdao searchfriend");
					list = new ArrayList<String>();
					smail = rs.getString("sendersEmail");
					rmail = rs.getString("receiversEmail");
					list.add(smail);
					list.add(rmail);
				}
				
			} 
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			
			}
				return list;
				
			}
			
			public SignupDTO getFriend(String mail) throws ClassNotFoundException, SQLException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				//ArrayList<SignupDTO> list = new ArrayList<SignupDTO>();
				SignupDTO signupdto = null;
				try {
				con = com.xyz.socialmedia.utils.CommonDAO.getConnection();
				pstmt = con.prepareStatement(com.xyz.socialmedia.utils.MyQueries.GETFRIEND_SQL);
				pstmt.setString(1, mail);
				pstmt.setString(2, mail);
				
				 rs = pstmt.executeQuery();
				while(rs.next()){
					//System.out.println("inside while at userdao searchfriend");
					signupdto = new SignupDTO();
					signupdto.setFirstname(rs.getString("firstName"));
					signupdto.setEmail(rs.getString("email"));
					signupdto.setLastname(rs.getString("lastName"));
					signupdto.setPhotoname(rs.getString("photoname"));
					
				}
				
			} 
			finally {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
				
			
			}
				return signupdto;
				
			}
			
			
			
			public String insertFriend(String senderemail , String receiveremail) throws ClassNotFoundException, SQLException {
				Connection con = null;
				PreparedStatement pstmt = null;
			
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.INSERTFRIEND_SQL);
				pstmt.setString(1, senderemail);
				pstmt.setString(2, receiveremail);
				int record = pstmt.executeUpdate();
				return record>0?"friend request send":"friend resquest send";
				
			}
				finally {
					
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				}
				
			}
			
			
			public String insertWallposts(String email , String	postmsg) throws ClassNotFoundException, SQLException {
				Connection con = null;
				PreparedStatement pstmt = null;
		
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.INSERTWALLPOST_SQL);
				pstmt.setString(1, email);
				pstmt.setString(2, postmsg);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
				pstmt.setString(3, dtf.format(now));
				int record = pstmt.executeUpdate();
				return record>0?"Wallpost upload":"not upload";
				
			}
				finally {
					
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				}
				
			}
			
			public String insertComment(CommentDTO commentdto) throws ClassNotFoundException, SQLException {
				Connection con = null;
				PreparedStatement pstmt = null;
		
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.INSERTCOMMENT_SQL);
				pstmt.setInt(1, commentdto.getPostid() );
				pstmt.setString(2, commentdto.getCommentBy());
				pstmt.setString(3,commentdto.getCommentMessage());
				pstmt.setString(4, commentdto.getDateOfComment());
				int record = pstmt.executeUpdate();
				return record>0?"Comment Upload":"Comment Not Upload";
				
			}
				finally {
					
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				}
				
			}
			
			public String insertLikes(LikeDTO likedto) throws ClassNotFoundException, SQLException {
				Connection con = null;
				PreparedStatement pstmt = null;
		
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.INSERTLIKES_SQL);
				pstmt.setString(1, likedto.getPostId());
				pstmt.setString(2, likedto.getLikedBy());
		
				int record = pstmt.executeUpdate();
				return record>0?"likes Upload":"likes Not Upload";
				
			}
				finally {
					
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				}
				
			}
			
			
			public ArrayList<WallpostDTO> getAllWallpost() throws ClassNotFoundException, SQLException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				WallpostDTO wallpostdto = null;
				ArrayList<WallpostDTO> list = new ArrayList<>();
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.GETALLWALLPOST_SQL);
				 rs = pstmt.executeQuery();
				 while(rs.next()) {
					 System.out.println("enter while");
					 wallpostdto = new WallpostDTO();
					 //System.out.println("4"+rs.getInt("wid"));
					 wallpostdto.setId(rs.getInt("wid"));
					 wallpostdto.setEmail(rs.getString("email"));
					 wallpostdto.setPostMessage(rs.getString("postMessage"));
					 wallpostdto.setFriendstagged(rs.getString("freindsTagged"));
					 wallpostdto.setDateofpost(rs.getString("dateOfPost"));
					 list.add(wallpostdto);
					 
				 }
				
			}
				finally {
					if(rs!=null) {
						rs.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				
				}
				return list;
				
			}
			
			
			
			public ArrayList<CommentDTO> getAllComments(int postid) throws ClassNotFoundException, SQLException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				CommentDTO commentdto = null;
				ArrayList<CommentDTO> list = new ArrayList<>();
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.GETALLCOMMENT_SQL);
				pstmt.setInt(1, postid);
				 rs = pstmt.executeQuery();
				 while(rs.next()) {
					
					 commentdto = new CommentDTO();
					 //System.out.println("4"+rs.getInt("wid"));
					 commentdto.setCid(rs.getInt("cid"));
					 commentdto.setPostid(rs.getInt("postId"));
					 commentdto.setCommentBy(rs.getString("commentBy"));
					 commentdto.setCommentMessage(rs.getString("commentMessage"));
					 commentdto.setDateOfComment(rs.getString("dateOfComment"));
					 list.add(commentdto);
					 
				 }
				
			}
				finally {
					if(rs!=null) {
						rs.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				
				}
				return list;
				
			}
			
			

			
			public ArrayList<LikeDTO> getAllLikes(int postid) throws ClassNotFoundException, SQLException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				LikeDTO likedto = null;
				ArrayList<LikeDTO> list = new ArrayList<>();
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.GETLIKE_SQL);
				pstmt.setInt(1, postid);
				 rs = pstmt.executeQuery();
				 while(rs.next()) {
					
					 likedto = new LikeDTO();
					 likedto.setPostId(rs.getString("postid"));
					 likedto.setLikedBy(rs.getString("likedby"));
					 list.add(likedto);
					 
				 }
				
			}
				finally {
					if(rs!=null) {
						rs.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				
				}
				return list;
				
			}
			
			public String uploadImageForProfile(String name , String path , String email) throws ClassNotFoundException, SQLException {
				Connection con = null;
				PreparedStatement pstmt = null;
			
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.IMAGE_UPLOAD_PROFILE_SQL);
				pstmt.setString(1, name);
				pstmt.setString(2, path);
				pstmt.setString(3, email);
				int record = pstmt.executeUpdate();
				return record>0?"Upload Image":"Not upload image";
				
			}
				finally {
					
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				}
				
			}
			
			
			
			public String getImage(String email) throws ClassNotFoundException, SQLException {
				Connection con= null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String imagename = null;
				try {
				con = CommonDAO.getConnection();
				pstmt = con.prepareStatement(MyQueries.GET_IMAGE_SQL);
				pstmt.setString(1, email);
				 rs = pstmt.executeQuery();
				 while(rs.next()) {
					
					 imagename = rs.getString("photoname");
					System.out.println("at 642 userdao"+imagename);
				 }
				
			}
				finally {
					if(rs!=null) {
						rs.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
					
				
				}
				return imagename;
				
			}
			
			
//			public String retreiveImageForProfile() throws ClassNotFoundException, SQLException {
//				Connection con = null;
//				PreparedStatement pstmt = null;
//				ResultSet rs = null;
//				
//				con = CommonDAO.getConnection();
//				
//			}
			
			
			
}			
					
//		}
//		
////		public ArrayList<String> getFriends(String email){
////			ArrayList<String> friends = new ArrayList<>();
////			try{
////				PreparedStatement statement = con.prepareStatement("SELECT * FROM FRIENDREQUEST WHERE (SENDERSEMAIL=? OR RECEIVERSEMAIL=?) AND REQUESTSTATUS='ACCEPTED'");
////				statement.setString(1, email);
////				statement.setString(2, email);
////				ResultSet rs = statement.executeQuery();
////				while(rs.next()){
////					if(rs.getString(2).equals(email)){
////						friends.add(rs.getString(3));
////					} else {
////						friends.add(rs.getString(2));
////					}
////				}
////				con.close();
////			} catch(Exception e){
////				return friends;
////			}
////			return friends;
////		}
//		
//		public String getLikedByNames(String postId) throws ClassNotFoundException, SQLException{
//			String name = "";
//			Connection con= null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			try {
//			con = CommonDAO.getConnection();
//			pstmt = con.prepareStatement(MyQueries.GETLIKE_SQL);
//				//PreparedStatement statement = con.prepareStatement("select * from likes where postId=?");
//				pstmt.setString(1, postId);
//				rs = pstmt.executeQuery();
//				while(rs.next()){
//					name += getName(rs.getString("likedby")) + "," + " ";
//					System.out.println(rs.getString("likedby") + "," + " ");
//				}
//				
//			}
//			finally {
//				if(rs!=null) {
//					rs.close();
//				}
//				if(pstmt!=null) {
//					pstmt.close();
//				}
//				if(con!=null) {
//					con.close();
//				}
//				
//			}
//			return name;
//		}
//		
//		
//		public FriendRequestDTO friendrequest(String email) throws ClassNotFoundException, SQLException {
//			Connection con= null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			FriendRequestDTO frdto = null;
//			try {
//			con = CommonDAO.getConnection();
//			pstmt = con.prepareStatement(MyQueries.FRIENDREQUEST_SQL);
//		
//				pstmt.setString(1,email);
//			   rs = pstmt.executeQuery();
//				while(rs.next()){
//					if(frdto==null) {
//						frdto = new FriendRequestDTO();
//						frdto.setId(rs.getInt("id"));
//						frdto.setSendersmail(rs.getString("sendersmail"));
//					}
//					
//				}	
//			}
//			finally {
//				if(rs!=null) {
//					rs.close();
//				}
//				if(pstmt!=null) {
//					pstmt.close();
//				}
//				if(con!=null) {
//					con.close();
//				}
//				
//			}
//			return frdto;
//		}

