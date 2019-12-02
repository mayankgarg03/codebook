package com.xyz.socialmedia.controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyz.socialmedia.dao.UserDAO;


@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String sendermail = request.getParameter("name");
		HttpSession session = request.getSession();
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/facebook?user=root&password=test123");
//			PreparedStatement statement = con.prepareStatement("update friendrequest set requestStatus='ACCEPTED' where id=?");
//			statement.setString(1, request.getParameter("id"));
//			statement.executeUpdate();
//			session.setAttribute("sessionMessage", "You and " + request.getParameter("name") + " are now friends!");
//			response.sendRedirect("index.jsp");
			
			UserDAO userdao = new UserDAO();
			String msg = userdao.updateFriendRequest(id);
			System.out.println("frndrequest "+msg);
			session.setAttribute("sessionMessage", "You and " + sendermail + " are now friends!");
			out.println( "You and " + sendermail + " are now friends!");
		} catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
