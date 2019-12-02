package com.xyz.socialmedia.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyz.socialmedia.dao.UserDAO;

@WebServlet("/deleterequest")
public class DeleteRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UserDAO userdao = new UserDAO();
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				String msg = userdao.deleteFriend(id);
				response.sendRedirect("friendrequest.jsp?msg="+msg);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
