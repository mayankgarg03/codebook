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
import com.xyz.socialmedia.dto.SignupDTO;


@WebServlet("/load")
public class LoadUserDataController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		String senderemail = (String)session.getAttribute("email");
		String mail = request.getParameter("id");
		System.out.println("###"+mail);
		UserDAO userdao = new UserDAO();
		try {
			String imagename = userdao.getImage(mail);
			String name=imagename.trim();
			response.sendRedirect("userprofile.jsp?image="+name+"&id="+mail);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
