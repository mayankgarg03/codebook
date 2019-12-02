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

/**
 * Servlet implementation class UpdateDetailsController
 */
@WebServlet("/updatedetails")
public class UpdateDetailsController extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		//String email = request.getParameter("email");
		String dobMonth = request.getParameter("dobMonth");
		String dobYear = request.getParameter("dobYear");
		String dobDay = request.getParameter("dobDay");
		String gender = request.getParameter("gender");
		System.out.println(firstname+" "+lastname+" "+dobDay+" "+dobMonth+" "+dobYear+" "+gender);
		
		SignupDTO signupdto = new SignupDTO();
		signupdto.setFirstname(firstname);
		signupdto.setLastname(lastname);
		//signupdto.setEmail(email);
		signupdto.setDobDay(dobDay);
		signupdto.setDobMonth(dobMonth);
		signupdto.setDobYear(dobYear);
		signupdto.setGender(gender);
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("email");
		UserDAO userdao = new UserDAO();
		try {
			String msg = userdao.updateUserDetails(signupdto,email);
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
