package com.xyz.socialmedia.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyz.socialmedia.dao.UserDAO;
import com.xyz.socialmedia.dto.FriendRequestDTO;
import com.xyz.socialmedia.dto.SignupDTO;

/**
 * Servlet implementation class SearchFriendController
 */
@WebServlet("/searchfriend")
public class SearchFriendController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String search = request.getParameter("search");
//	System.out.println(search);
//	String[] a = search.split(" ");
//	for(int i=0; i<a.length;i++) {
//		System.out.println(a[i]);
//	}

	HttpSession session = request.getSession(false);
	System.out.println("???????"+session.getAttribute("email"));
	String sessionmail = (String)session.getAttribute("email");
	System.out.println("at 37 in searchfrndcntrl"+sessionmail);
	ArrayList<SignupDTO> list = null;
	//String rmail = null;
	//SignupDTO signupdto = null;
	//ArrayList<SignupDTO> newlist =null;
	//FriendRequestDTO frdto = null;
	UserDAO userdao = new UserDAO();
	try {
		
//		for(SignupDTO obj : list) {
//			//System.out.println("9(999"+obj.getEmail());
//			frdto = new FriendRequestDTO();
//		     frdto = userdao.isFriend(sendermail);
//		    // System.out.println("##"+frdto.getReceiversmail());
//		     
//		     if(frdto==null) {
//		    	    newlist = new ArrayList<SignupDTO>();
//			    	signupdto = new SignupDTO();
//			    	signupdto.setFirstname(obj.getFirstname());
//			    	signupdto.setEmail(obj.getEmail());
//			    	newlist.add(signupdto);
//			    	request.setAttribute("friend",newlist);
//		            RequestDispatcher rd = request.getRequestDispatcher("searchfriend.jsp");
//		            rd.forward(request, response);
//		     }
//		     else {
//		    	 request.setAttribute("friend",list);
//					RequestDispatcher rd = request.getRequestDispatcher("searchfriend.jsp");
//					rd.forward(request, response);
//		     }
		     
//		     if(obj.getEmail().equals(frdto)) {
//		    	newlist = new ArrayList<SignupDTO>();
//		    	signupdto = new SignupDTO();
//		    	signupdto.setFirstname(obj.getFirstname());
//		    	signupdto.setEmail(obj.getEmail());
//		    	newlist.add(signupdto);
//		     }
		
		ArrayList<FriendRequestDTO> friendlist =  userdao.isFriend();
		if(friendlist!=null) {
		for(FriendRequestDTO obj : friendlist) {
		String smail = obj.getSendersmail();
		String rmail = obj.getReceiversmail();
		System.out.println("%%%%"+smail +" "+ rmail);
			
		if((sessionmail.equals(smail)) || (sessionmail.equals(rmail))) {
			System.out.println("inside if at 81 in searchcntrllr");
			list = new ArrayList<SignupDTO>();
			list = userdao.searchFriend(search,smail,rmail);
			request.setAttribute("friend",list);
			RequestDispatcher rd = request.getRequestDispatcher("searchfriend.jsp");
			rd.forward(request, response);
				
		}
		
		else {
			list = userdao.searchFriend1(search,sessionmail);
			request.setAttribute("friend",list);
			RequestDispatcher rd = request.getRequestDispatcher("searchfriend.jsp");
			rd.forward(request, response);
		}
		
		}
		}
		else {
			list = userdao.searchFriend1(search,sessionmail);
			request.setAttribute("friend",list);
			RequestDispatcher rd = request.getRequestDispatcher("searchfriend.jsp");
			rd.forward(request, response);
	
		}
		
//		request.setAttribute("friend",list);
//				
//		
//		
//		RequestDispatcher rd = request.getRequestDispatcher("searchfriend.jsp");
//		rd.forward(request, response);
//		   
		
	
		//}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
}
