package com.xyz.socialmedia.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyz.socialmedia.dao.UserDAO;
import com.xyz.socialmedia.dto.LoginDTO;
import com.xyz.socialmedia.dto.SignupDTO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("loginemail");
		String pwd = request.getParameter("password");
		System.out.println(email +" "+pwd);
		
		LoginDTO logindto = new LoginDTO();
		logindto.setEmail(email);
		logindto.setPassword(pwd);
		
		UserDAO userdao = new UserDAO();
		 try {
			SignupDTO signupdto = userdao.doLogin(logindto);
			if(signupdto==null) {
				System.out.println("login unsuccessful");
				String msg = "invalid username and password";
				response.sendRedirect("LoginSignup.jsp?msg="+msg);
			}
			else {
				System.out.println("login successfully");
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				System.out.println(signupdto.getFirstname());
				//request.setAttribute("data", signupdto);
				session.setAttribute("name", signupdto.getFirstname());
				response.sendRedirect("index.jsp?useremail="+email);
				
//				RequestDispatcher rd = request.getRequestDispatcher();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
