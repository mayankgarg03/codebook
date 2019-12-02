package com.xyz.socialmedia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
					
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rb = ResourceBundle.getBundle("configuration");
		
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");
		Connection con = DriverManager.getConnection(url,username,password);
		if(con!=null) {
			System.out.println("connection created");
		}
		else {
			System.out.println("connection not created");
		}
		
		return con;
		
	}
	
	
	
}
