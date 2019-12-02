package com.xyz.socialmedia.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyz.socialmedia.dao.UserDAO;
import com.xyz.socialmedia.dto.SignupDTO;


@WebServlet("/signup")
public class SignUpController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String emailconfirm = request.getParameter("emailcnf");
		String pwd = request.getParameter("password");
		String dobMonth = request.getParameter("dobMonth");
		String dobYear = request.getParameter("dobYear");
		String dobDay = request.getParameter("dobDay");
		String gender = request.getParameter("gender");
		System.out.println(firstname+" "+lastname+" "+email+" "+emailconfirm+" "+pwd+" "+dobDay+" "+dobMonth+" "+dobYear+" "+gender);
		
		SignupDTO signupdto = new SignupDTO();
		signupdto.setFirstname(firstname);
		signupdto.setLastname(lastname);
		signupdto.setEmail(email);
		signupdto.setPassword(pwd);
		signupdto.setDobDay(dobDay);
		signupdto.setDobMonth(dobMonth);
		signupdto.setDobYear(dobYear);
		signupdto.setGender(gender);
		
		
		UserDAO userdao = new UserDAO();
		try {
			String msg = userdao.signUp(signupdto);
			if(msg.equals("")) {
				System.out.println("not inserted");
				out.println("Not inserted");
				response.sendRedirect("LoginSignup.jsp?msg=can't registered try again later ");
			}
			else {
				System.out.println("successfully inserted");
				out.println("successfully registered");
				File file = new File("C:\\Users\\mayank\\Documents\\advnacejavaprojects\\SocialMedia\\WebContent\\images" + "\\" + email);
				file.mkdir();
				String path = "";
				if(request.getParameter("gender").equals("Male")) {
					path = "C:\\Users\\mayank\\Documents\\advnacejavaprojects\\SocialMedia\\WebContent\\images" + "\\placeholderboy.jpg";
				} else {
					path = "C:\\Users\\mayank\\Documents\\advnacejavaprojects\\SocialMedia\\WebContent\\images" + "\\placeholdergirl.jpg";
				}
				FileInputStream fis = new FileInputStream(path);
				FileOutputStream fos = new FileOutputStream("C:\\Users\\mayank\\Documents\\advnacejavaprojects\\SocialMedia\\WebContent\\images"
						+ "\\" + request.getParameter("email") + "\\profilepicture.jpg");
				int i;
				while((i=fis.read())!=-1) {
					fos.write(i);
				}
				fis.close();
				fos.close();
				response.getWriter().write("ok");
			}
				response.sendRedirect("LoginSignup.jsp?msg=registered succesfully ");
//				out.println("Redirecting to login page after 5 seconds............");
//				response.setHeader("refresh", "5; url=LoginSignup.jsp");
				
			
		
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
