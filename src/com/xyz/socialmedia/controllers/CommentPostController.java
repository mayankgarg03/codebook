package com.xyz.socialmedia.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyz.socialmedia.dao.UserDAO;
import com.xyz.socialmedia.dto.CommentDTO;

/**
 * Servlet implementation class CommentPostController
 */
@WebServlet("/commentpost")
public class CommentPostController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String postid =  request.getParameter("postId");
		String email =  request.getParameter("calledBy");
		String postmessage = request.getParameter("postMessage");
		System.out.println(postid+" "+email);
		System.out.println("comment is: "+postmessage);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));
		
		UserDAO userdao = new UserDAO();
		String useremail =  (String)session.getAttribute("email");
		CommentDTO commentdto = new CommentDTO();
		commentdto.setPostid(Integer.parseInt(postid));
		commentdto.setCommentBy(email);
		commentdto.setCommentMessage(postmessage);
		commentdto.setDateOfComment(dtf.format(now));
		try {
			String msg = userdao.insertComment(commentdto);
			System.out.println(msg);
			response.sendRedirect("index.jsp?useremail="+useremail+"&msg="+msg);
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
