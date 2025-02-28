package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.AppController;

public class User {

	private String lastName;
	private String firstName;
	private String username;
	private String password;
	
	private String fileUN, filePW, fileName, fileLM;
	
	private String city;
	private String streetNum;
	private String streetName;
	private double lat;
	private double longt;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetNum() {
		return streetNum;
	}
	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void currentAccount(String username, String password) {
	
		try {
			
			//Read the csv(comma seperated values) file
			Scanner input = new Scanner (new File("userInfo.csv"));
			input.useDelimiter(",|\\n");
			
			//As long as there is another line of information, keep doing the following
			while (input.hasNext()) {
				
				input.nextLine();
				
				fileName = input.next();
				fileLM = input.next();
				fileUN = input.next();
				filePW = input.next();
				
				System.out.printf("%s, %s, %s, %s\n", fileName, fileLM, fileUN, filePW);
				
				if (username.equals(fileUN) && password.equals(filePW)) {
				
					setFirstName(fileName);
					setLastName(fileLM);
					setUsername(fileUN);
					setPassword(filePW);
					
					AppController.userFound = true;
				
				}
				
				if (username.equals(fileUN))
					AppController.userExists = true;
				
			}
		
			input.close();
			
			if (AppController.userFound)
				System.out.println("LOGIN");
			
		} catch(FileNotFoundException error) {
			
			//Display the error to the console
			System.out.println("Sorry file not loading - please check the name/location");
		}
		
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLongt() {
		return longt;
	}
	public void setLongt(double longt) {
		this.longt = longt;
	}
	
}