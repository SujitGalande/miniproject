package com.miniproject.multiplechoicequestions;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectinTest {
	
	Connection con = null;
	
	// create a connection Return type Method
	
	public Connection getConnectionDetails() {
		
	try {
	
	// Load the Driver Class
		
	Class.forName("com.mysql.jdbc.Driver");
		
	// Establish the connection

	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","sujit");	
			
	}catch(Exception e) {
	System.out.println(e);
	}
	return con;
	}
  }
