package com.xyz.socialmedia.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.xyz.socialmedia.dao.UserDAO;


@WebServlet("/image")
@MultipartConfig(maxFileSize = 16177215) 
public class UploadImageController extends HttpServlet {
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		
//		String path = "C:\\Users\\mayank\\Documents\\advnacejavaprojects\\SocialMedia\\WebContent\\images";
//		InputStream inputStream = null;
		//System.out.println(">>>.."+ File.separator);
		  Part filePart = request.getPart("f1");
		  String filename = null;
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getSubmittedFileName());
	            filename=filePart.getSubmittedFileName();
	           
	            System.out.println(filename);
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	           // inputStream = filePart.getInputStream();
	        }
	        
	        
	    
System.out.println("@@@@"+session.getAttribute("email"));

	     String savepath = "C:\\Users\\mayank\\Documents\\advnacejavaprojects\\SocialMedia\\WebContent\\images"+ "\\"+session.getAttribute("email");
	        File file = new File(savepath);
	        if(!file.exists()){
	        	file.mkdir();
	        }
	               	       System.out.println(savepath);
	               	       System.out.println(savepath + File.separator+filename);
	        filePart.write(savepath + File.separator+filename);
	      
	        
	       
	       	UserDAO userdao = new UserDAO();
	       	try {
				String msg = userdao.uploadImageForProfile(filename, savepath + File.separator+filename , (String)session.getAttribute("email"));
				System.out.println("at 67 line uploadimagecntrl "+msg);
				response.sendRedirect("index.jsp?useremail="+session.getAttribute("email")+"&name="+filename);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}


