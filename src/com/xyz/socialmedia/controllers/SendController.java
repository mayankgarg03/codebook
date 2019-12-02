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

/**
 * Servlet implementation class SendController
 */
@WebServlet("/send")
public class SendController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		String receiveremail = (String)session.getAttribute("email");
		String senderemail = request.getParameter("senderemail");
		System.out.println(senderemail+""+receiveremail);
		UserDAO userdao = new UserDAO();
		try {
			String msg = userdao.insertFriend(senderemail,receiveremail);
			System.out.println(msg);
			out.println(msg);
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
