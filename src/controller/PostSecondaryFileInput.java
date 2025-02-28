package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Program;

/*
 * Author: Shreyas Peddi
 * This class reads a spreadsheet file (csv format) which contains information regarding university programs.
 * It then updates the information in a program array (belongs to the controller class).
 */
public class PostSecondaryFileInput {

	//This method(constructor) reads information from csv file and updates it in the program
	//array of the controller class
	public PostSecondaryFileInput() {
		
		try {

			// Read the csv(comma separated values) file
			Scanner input = new Scanner(new File("programResearch.csv"));
			
			//Set up a delimeter which seperates each word by ',' or a new line character(\n)
			input.useDelimiter(",|\\r\\n");

			// Ignore the first line which contains column headings
			input.nextLine();

			// Start with index=0 to update the program array
			int index = 0;
			
			// As long as there is another line of information, keep doing the following
			while(input.hasNextLine()) {
				
				// Create a new program object by taking an instance of the Program class
				AppController.programArray[index] = new Program();
				
				//Read values from the csv file and store it in appropriate fields
				AppController.programArray[index].setUniversity(input.next());
				AppController.programArray[index].setCategory(input.next());
				AppController.programArray[index].setProgramName(input.next());
				AppController.programArray[index].setDegree(input.next());
				
				AppController.programArray[index].setProgramRating(input.nextDouble());
				
				AppController.programArray[index].setTuition(input.nextDouble());
				AppController.programArray[index].setLocation(input.next());
				AppController.programArray[index].setAdmissionAverage(input.next());
				AppController.programArray[index].setHasFullTimeStatus(input.nextBoolean());
				
				//Read all the course requirements
				for(int course=0;course<6;course++)
					AppController.programArray[index].getCourses()[course].setRequirement(input.next());
				
				AppController.programArray[index].setHasSupplementaryApplication(input.nextBoolean());
				AppController.programArray[index].setHasCoOp(input.nextBoolean());
				AppController.programArray[index].setURL(input.next());
				
				// Display object(program) information
				System.out.println(AppController.programArray[index]);
				
				// Increment the index to access next program object
				index++;
			}// End of loop
			
			input.close();
		}
		catch(FileNotFoundException error) {
			// Display the error to the console
			System.out.println("Sorry file not loading - please check the name/location");
		}
		
	}
}
