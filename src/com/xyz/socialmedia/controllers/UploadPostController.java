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


@WebServlet("/uploadpost")
public class UploadPostController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession(false);
		String postmsg = request.getParameter("postMessage");
		System.out.println(postmsg);
		UserDAO userdao = new UserDAO();
		String email =  (String)session.getAttribute("email");
		try {
			String msg = userdao.insertWallposts(email, postmsg);
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
