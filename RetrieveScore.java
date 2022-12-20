package com.miniproject.multiplechoicequestions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetrieveScore extends Quiz_AbstractClass {

	Connection con = null;
	PreparedStatement psmnt = null;

	// create a method
	@Override
	void retrieveScore() throws SQLException {
		
	try {
		
		// Create ConnectionTest Class Object
		ConnectinTest cnt = new ConnectinTest();
			
		con=cnt.getConnectionDetails();	
			
		// Create the prepare statement
	psmnt=con.prepareStatement("select * from usernamescore");
			

		
		// Submit the SQL statement to Database
		ResultSet s=psmnt.executeQuery();
		
		while(s.next()) {
			
			System.out.println("Display the list of userId, name with score into console");
			System.out.println("\n");
			System.out.println("User Id > " + s.getInt(1));
			System.out.println("User Name > " + s.getString(2));
			System.out.println("User Score > " + s.getInt(3));
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		}
		
		// Retrieve Particular userId  Score from database
		
		// Create Scanner Object
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter User Id");
		int userId = scan.nextInt();
		// Create the prepare statement
		psmnt = con.prepareStatement("select * from usernamescore where userid = ?");
		psmnt.setInt(1, userId);
		
		// Submit the SQL statement to Database
		ResultSet rScore = psmnt.executeQuery();
		
		while(rScore.next()) {
			
			System.out.println("To retrieve the particlar score using userId");
			System.out.println("\n");
			System.out.println("User Name > " + rScore.getString(2));
			System.out.println("User Score > " + rScore.getInt(3));
		}
        
          s.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
	     finally {
		con.close();
		psmnt.close();
	}
		
	}

}
