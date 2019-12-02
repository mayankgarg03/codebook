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

@WebServlet("/changepassword")
public class ChangePasswordController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		HttpSession session = request.getSession(false);
//		 String email =  (String)session.getAttribute("email");
		String email = request.getParameter("email");
		String newpwd = request.getParameter("newpwd");
		UserDAO userdao = new UserDAO();
		try {
			String msg = userdao.updatePassword(newpwd, email);
			System.out.println(msg);
			response.sendRedirect("LoginSignup.jsp?msg="+msg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
