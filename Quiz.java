package com.miniproject.multiplechoicequestions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Quiz implements Quiz_InterfaceClass {
	
	Connection con = null;
	PreparedStatement psmnt = null;
	
	@Override
	public void retrieveQuiz() throws SQLException {
		
		int score = 0;
        int correctAns = 0;
        int inCorrectAns = 0;
        
        int a = 1;
try {
	
	// Create Scanner Object
	
	Scanner scan = new Scanner(System.in);
	
	ConnectinTest cnt = new ConnectinTest();
	con=cnt.getConnectionDetails();
	
	// Create the prepare statement
	
	psmnt=con.prepareStatement("select * from questionanswer1 ORDER BY RAND()");
	
	// Submit the SQL statement to Database
	
     ResultSet rst	=psmnt.executeQuery();
  
     System.out.println("Enter Username");
	 String userName = scan.next();
	
	 System.out.println("\n");
	 System.out.println("==================================== Quiz Started ====================================");
	
	  while(rst.next()) {
		
      System.out.println("\n-------------------------------------------------------------------------------------------------------");
		
	  System.out.println("Question " + a + " : " + rst.getString(2));
		System.out.println("1." + rst.getString(3));
		System.out.println("2." + rst.getString(4));
		System.out.println("3." + rst.getString(5));
		System.out.println("4." + rst.getString(6));
		System.out.println("\n----------------------------------------------------------------------------------------------------------");
		
       System.out.println("Enter Correct Answer");
	    int userAnswer = scan.nextInt();

         if (userAnswer == rst.getInt(7)) {
	    	
	    	System.out.println("Correct Answer");
	    	
	    	score++;
	    	a++;
	       correctAns++;
	     }
	   
	    else {
	            	   
	    	System.out.println("Incorrect Answer!...Correct Answer is >>> " + rst.getInt(7));
	    	
	    	 a++;     
	    	 inCorrectAns++;
	     }
	  
	   }

	System.out.println("\n-------------------------------------------------------------------------------------------------------------");
	System.out.println("Display the score out of 10 with remark & count correct & incorrect answers");
	System.out.println("\n");
	System.out.println("Score of Candidate >>> " + score + " Out of 10 ");
	System.out.println("Correct Answers > " + correctAns);
	System.out.println("Incorrect Answers > " + inCorrectAns);
	
	// Store UserName & Score into Database
	psmnt =con.prepareStatement("insert into usernamescore(username , score)values(?,?)");
	psmnt.setString(1, userName);
	psmnt.setInt(2, score);
   
   int p = psmnt.executeUpdate();
   System.out.println("Record is inserted >>> " + p);
   
   rst.close();
   
   // Show Grade Bases on User Score 
   
    if (score < 5) {
   	
   	System.out.println("Grade : Class-D > Fail");
   }
   
    else {

	   	if (score == 5) {
	   		
	   		System.out.println("Grade : Class-C");
	   		
	   	}
	   	else if (score >= 6 && score < 8) {
	   		
		    	System.out.println("Grade : Class-B");
		    }
	   	else {
	   		
	   		   System.out.println("Grade : Class-A");
	   	  }
	  }
	    System.out.println("\n*************************************************************************************************************");

     } catch(Exception e) {
	     System.out.println(e);
     
     
   }finally {
	   
   }
     con.close();
    psmnt.close();

   }
}
