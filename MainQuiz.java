package com.miniproject.multiplechoicequestions;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainQuiz {
	
public static void main(String[] args) throws SQLException {
		
		// Try & Catch 
		
     try {
			// the file to be opened for reading  
	FileInputStream fileReader = new FileInputStream ("D:\\Java developer class\\Interview questions\\PropertiesFiles.txt");
					
			// Create Scanner Object
		Scanner scan = new Scanner (fileReader);
					
		//returns true if there is another line to read  
			while (scan.hasNextLine()) {
				
			//returns the line that was skipped  
			System.out.println(scan.nextLine());
		}
			scan.close(); //closes the scanner  
					
	 }
		catch (IOException e) {
					
		System.out.println(e);
					
	}
		  
   	 // Create an Object of Quiz Class
   		Quiz quiz = new Quiz();
   		
   	// Call Method by 'quiz' Object
           quiz.retrieveQuiz();
   		
   	
   	// Create an Object of RetrieveScore Class
   		RetrieveScore rScore = new RetrieveScore();
   		
   	// Call Method by 'rScore' Object
   		rScore.retrieveScore();
	}

}


