package com.xyz.socialmedia.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyz.socialmedia.dao.UserDAO;
import com.xyz.socialmedia.dto.LikeDTO;

/**
 * Servlet implementation class LikePostController
 */
@WebServlet("/likepost")
public class LikePostController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		 String postid =  request.getParameter("postId");
		 System.out.println(postid);
		 String calledby = request.getParameter("calledBy");
		 System.out.println(calledby);
		 UserDAO userdao = new UserDAO();
		 String email =  (String)session.getAttribute("email");
		 LikeDTO likedto = new LikeDTO();
		 likedto.setPostId(postid);
		 likedto.setLikedBy(calledby);
		 try {
			String msg = userdao.insertLikes(likedto);
			System.out.println(msg);
			response.sendRedirect("index.jsp?useremail="+email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
