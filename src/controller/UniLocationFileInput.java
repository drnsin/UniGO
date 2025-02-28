package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Program;
import model.University;

/*
 * Author: Shreyas Peddi
 * This class reads university name, latitude and longitude from a text file. This information is stored in global array of
 * University type. This information will be used to setup the map screen when it needs to be displayed
 */
public class UniLocationFileInput {

	//Constructor
	public UniLocationFileInput(){
		
		try {
			
			// Read the csv(comma separated values) file
			Scanner input = new Scanner(new File("uniLocation.txt"));
			
			//Set up a delimeter which seperates each word by '&' or a new line character(\n)
			input.useDelimiter(",|\\r\\n");

			// Start with index=0 to update the university arrray
			int index = 0;
			
			// As long as there is another line of information, keep doing the following
			while(input.hasNextLine()) {
				
				// Create a new university object by taking an instance of the University class
				AppController.universities[index] = new University();
				AppController.universities[index].setName(input.next());
				AppController.universities[index].setLat(input.nextDouble());
				AppController.universities[index].setLongt(input.nextDouble());
				System.out.println(AppController.universities[index]);
				index++;
			}
			
			//Close the input
			input.close();
		}
			catch(FileNotFoundException error) {
				
				// Display the error to the console
				System.out.println("Sorry file not loading - please check the name/location");
			}
	}
}

