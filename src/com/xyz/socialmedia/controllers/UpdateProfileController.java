package com.xyz.socialmedia.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyz.socialmedia.dao.UserDAO;


@WebServlet("/updateprofile")
public class UpdateProfileController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String studentAt = request.getParameter("studentat");
		String worksAt = request.getParameter("worksat");
		String address = request.getParameter("address");
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		System.out.println(address+" "+studentAt+" "+worksAt+" "+email);
		//response.setContentType("text/html");
		UserDAO userdao = new UserDAO();
		try {
			String msg = userdao.updateUserProfile(address, worksAt, studentAt, email);
			System.out.println(msg);
//			out.println(msg);
//			out.println("go to index.html");
			//out.print("<a href='index.jsp'>Index Page</a>");
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
