package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Program;
import model.University;
import model.User;
import view.comparison.CompareProgramsFrame;
import view.dashboard.ComparisonPanel;
import view.dashboard.DashboardFrame;
import view.dashboard.MapPanel;
import view.dashboard.MatchPanel;
import view.dashboard.UserPanel;
import view.information.InformationSearchFrame;
import view.information.MapFrame;
import view.matching.ProgramMatchFrame;
import view.matching.UserPreferencesFrame;
import view.userScreen.LocationPanel;
import view.userScreen.UserFrame;
import view.userlogin.HomePanel;
import view.userlogin.LoginPanel;
import view.userlogin.LoginScreen;
import view.userlogin.SignupPanel;

/*
 * This class has the main logic of the application - setup of the application, input data, read files, implementation of buttons,
 * transition between screens, handling login and logout
 */
public class AppController implements ActionListener, ChangeListener {

	// Fields
	public static Program programArray[] = new Program[194]; // Contains all the researched program objects
	public static University universities[] = new University[23]; // Contains all the university objects
	private LoginScreen loginScreen; // Login Screen
	private DashboardFrame dashboardFrame; // Dashboard Screen
	private CompareProgramsFrame compareProgramsFrame; // Program comparison screen
	private UserPreferencesFrame userPreferencesFrame; // User preferences screen
	private ProgramMatchFrame programMatchFrame; // Program matching screen
	private InformationSearchFrame informationSearchFrame; // Information Search screen
	public UserFrame userFrame; // User profile screen

	private MapFrame mapFrame; // Map Screen
	public static int sliderValue = 0; // Map sliding value

	// Login Screen panels
	private HomePanel homePanel = new HomePanel(); //Instantiates the home panel
	private SignupPanel signupPanel = new SignupPanel(); //Instantiates the sign up panel
	private LoginPanel loginPanel = new LoginPanel(); //Instantiates the login panel
	private String filepath = "userInfo.csv"; //File path for the master file for all account login credentials
	private User user = new User(); // User object

	public static String loggedInName; //The name of the user that is current logged in
	public static String loggedInLM; //The last name of the user that is current logged in
	public static String loggedInUN; //The username of the user that is current logged in
	public static String loggedInPW; //The password of the user that is current logged in
	public static boolean userFound = false; //A boolean variable that flags if a user has been found or not during log in
	public static boolean userExists = false; //A boolean variable that flags if a user exists or not during sign up (Credentials taken)
	public static boolean enteredLocation = false; //A boolean variable that checks if the user has 

	private String universityName1Choice; // 1st university name choice in the graph panel (compareProgramsFrame)
	private String universityName2Choice; //2nd university name choice in the graph panel (compareProgramsFrame)
	private String topicNameChoice;  //Topic that you chose in the options panel (compareProgramsFrame)
	private String programNameChoice1;  // Program choice 1 in options panel (compareProgramsFrame)
	private String programNameChoice2; // Program choice 2 in options panel (compareProgramsFrame)
	
	// Constructor
	public AppController() {

		// Read university program data
		new PostSecondaryFileInput();

		// Read university location data
		new UniLocationFileInput();

		// Adds action listener to login screen buttons
		buttonActionListenersLogin();

		// Instantiates the login screen
		loginScreen = new LoginScreen();

		//Adds the panels onto the login screen
		loginScreen.add(homePanel);
		loginScreen.add(signupPanel);
		loginScreen.add(loginPanel);

		//Sets the login screen to visible and all other frames excluding the home panel to not visible
		loginScreen.setVisible(true);
		loginPanel.setVisible(false);
		signupPanel.setVisible(false);

		//System.gc();

	}

	// Added by: Ashwin
	// Gives each button in each panel of UserPreferencesFrame an ActionListener.
	// Gives ActionListener to each button in each panel based on the order that
	// they appear on the survey.
	private void addActionListenerProgramMatchScreen() {
		userPreferencesFrame.getMatch().addActionListener(this);

		// Adds ActionListener to all buttons in the 1st Panel
		for (int i = 0; i < userPreferencesFrame.getPanel1().getRangearray().length; i++) {
			userPreferencesFrame.getPanel1().getRangearray()[i].addActionListener(this);
		}

		for (int i = 0; i < userPreferencesFrame.getPanel2().getCooparray().length; i++) {
			userPreferencesFrame.getPanel2().getCooparray()[i].addActionListener(this);
		}

		// Adds ActionListener to all buttons in the 3rd Panel
		for (int i = 0; i < userPreferencesFrame.getPanel3().getSupparray().length; i++) {
			userPreferencesFrame.getPanel3().getSupparray()[i].addActionListener(this);
		}

		// Adds ActionListener to all buttons in the 4th Panel
		for (int i = 0; i < userPreferencesFrame.getPanel4().getParttimearray().length; i++) {
			userPreferencesFrame.getPanel4().getParttimearray()[i].addActionListener(this);
		}

		// Adds ActionListener to all buttons in the 5th Panel
		for (int i = 0; i < userPreferencesFrame.getPanel5().getSubjectarray().length; i++) {
			userPreferencesFrame.getPanel5().getSubjectarray()[i].addActionListener(this);
		}
	}
	
	/*
	 *Added by: Gordon
	 *Purpose: Listens to parts in the comparison frame 
	 */
	private void addActionListenerComparisonFrame() {
		compareProgramsFrame.getOptionsPanel().getDoneButton().addActionListener(this);
		compareProgramsFrame.getGoBackButton().addActionListener(this);
		compareProgramsFrame.getOptionsPanel().getUniversity1Box().addActionListener(this);
		compareProgramsFrame.getOptionsPanel().getUniversity2Box().addActionListener(this);
		compareProgramsFrame.getOptionsPanel().getTopicBox().addActionListener(this);
		compareProgramsFrame.getOptionsPanel().getPrograms1Box().addActionListener(this);
		compareProgramsFrame.getOptionsPanel().getPrograms2Box().addActionListener(this);
	}

	//Added by: Darren
	//This method adds action listeners to each button
	public void buttonActionListenersLogin() {
		
		HomePanel.signUp.addActionListener(this);
		HomePanel.login.addActionListener(this);
		
		SignupPanel.loginButton.addActionListener(this);
		SignupPanel.signupButton.addActionListener(this);
		
		LoginPanel.loginButton.addActionListener(this);
		LoginPanel.signupButton.addActionListener(this);
		
		UserPanel.checkProfile.addActionListener(this);
		UserPanel.logOut.addActionListener(this);
		LocationPanel.confirm.addActionListener(this);
		
		MapPanel.lookAtPrograms.addActionListener(this);
		MatchPanel.survey.addActionListener(this);
		ComparisonPanel.compare.addActionListener(this);
		
		UserFrame.toDashBoard.addActionListener(this);
		
	}

	// This method adds action listener to components in the map screen
	private void addActionListenerMapFrame() {
		mapFrame.getMapPanel().getBackButton().addActionListener(this);
		mapFrame.getMapPanel().getRadiusSlider().addChangeListener(this);
		mapFrame.getMapPanel().getConfirmRadius().addActionListener(this);
	}

	// This method adds action listener to components in the information screen
	private void addActionListenerInformationFrame() {
		informationSearchFrame.getSearchPanel().getMapButton().addActionListener(this);
		informationSearchFrame.getSearchPanel().getSearchButton().addActionListener(this);
		informationSearchFrame.getSearchPanel().getBackButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		// Added by Shreyas
		// INFORMATION SEARCH SCREEN
		// If the map button is clicked
		if (informationSearchFrame != null
				&& event.getSource() == informationSearchFrame.getSearchPanel().getMapButton()) {

			// Remove current screen
			informationSearchFrame.dispose();

			// Instantiate new screen
			mapFrame = new MapFrame();

			// Setup action listener
			addActionListenerMapFrame();
			mapFrame.getMapPanel().loadUpMap(user);
		}

		// If the search button is clicked
		if (informationSearchFrame != null
				&& event.getSource() == informationSearchFrame.getSearchPanel().getSearchButton()) {

			// Clear current components
			informationSearchFrame.getProgramListPanel().removeAll();
			informationSearchFrame.getProgramListPanel().revalidate();
			informationSearchFrame.getProgramListPanel().setVisible(true);
			informationSearchFrame.getProgramListPanel().showResults();
			informationSearchFrame.repaint();
		}

		// If the back button is clicked
		if (informationSearchFrame != null
				&& event.getSource() == informationSearchFrame.getSearchPanel().getBackButton()) {

			// Remove current screen
			informationSearchFrame.dispose();

			// Instantiate new screen
			dashboardFrame = new DashboardFrame();
		}

		// MAP GUI SCREEN
		// If the back button is clicked
		if (mapFrame != null && event.getSource() == mapFrame.getMapPanel().getBackButton()) {

			// Remove current screen
			mapFrame.dispose();

			// Instantiate new screen
			informationSearchFrame = new InformationSearchFrame();

			// Setup action listener
			addActionListenerInformationFrame();
		}

		// If the confirm radius button is clicked
		if (mapFrame != null && event.getSource() == mapFrame.getMapPanel().getConfirmRadius())
			mapFrame.getMapPanel().updateMap(sliderValue);

		// Added by: Darren
		// Sends user to the sign up panel
		if (event.getSource() == HomePanel.signUp) {
			homePanel.setVisible(false); //Sets the home panel to not visible
			signupPanel.setVisible(true); //Set the sign up panel to visible
		}

		// Sends user to login panel
		if (event.getSource() == HomePanel.login) {
			homePanel.setVisible(false); //Set the home panel to not visible
			loginPanel.setVisible(true); //Set the login panel to visible
		}

		// Creates an account for the user if all conditions are met
		if (event.getSource() == SignupPanel.signupButton) {
			signUp();
		}

		// Sends user to login panel from sign up panel
		if (event.getSource() == SignupPanel.loginButton) {
			loginPanel.setVisible(true); //Set the login panel to visible
			signupPanel.setVisible(false); //Set the sign up panel to not visible
		}

		// Logs in the user if all conditions are met
		if (event.getSource() == LoginPanel.loginButton) {
			checkValidID();
		}

		// Sends user to sign up panel from login panel
		if (event.getSource() == LoginPanel.signupButton) {
			signupPanel.setVisible(true); //Set the sign up panel to visible
			loginPanel.setVisible(false); //Set the login panel to not visible
		}

		// Goes to the profile page from the dashboard
		if (event.getSource() == UserPanel.checkProfile) {
			dashboardFrame.dispose(); //Closes the dashboard screen
			userFrame = new UserFrame(); //Instantiates the user frame
			LocationPanel.city.setText(user.getCity()); //Update the text field to the latest city
			LocationPanel.streetNum.setText(user.getStreetNum()); //Update the text field to the latest street number
			LocationPanel.streetName.setText(user.getStreetName()); //Update the text field to the latest street name
		}

		// Logs the user out of the application and sends back to home screen
		if (event.getSource() == UserPanel.logOut) {
			dashboardFrame.dispose(); //Closes the dashboard screen
			loggedOut(); //Logs user out

		}

		// Sends user back to the dashboard from the user profile
		if (event.getSource() == UserFrame.toDashBoard) {
			LocationPanel.saved.setVisible(false);
			userFrame.dispose(); //Closes user screen
			dashboardFrame = new DashboardFrame(); //Instantiates dashboard screen

		}

		//Saves the location of the user into their account file
		if (event.getSource() == LocationPanel.confirm) {
			writeLocation();
			LocationPanel.saved.setVisible(true);
		}

		// DASHBOARD - buttons
		// Look at Programs (Information Screen)
		if (event.getSource() == MapPanel.lookAtPrograms) {
			dashboardFrame.dispose(); //Closes the dasboard screen
			informationSearchFrame = new InformationSearchFrame();
			addActionListenerInformationFrame();
		}

		// User Preferences Screen
		if (event.getSource() == MatchPanel.survey) {
			dashboardFrame.dispose(); //Closes the dasboard screen
			userPreferencesFrame = new UserPreferencesFrame();
			addActionListenerProgramMatchScreen();
		}
		
		//Compare programs screen
		if(event.getSource() == ComparisonPanel.compare) {
			dashboardFrame.dispose(); //Closes the dasboard screen
			compareProgramsFrame = new CompareProgramsFrame();
			addActionListenerComparisonFrame();
		}

		// Program Match Frame - Ashwin
		if (userPreferencesFrame != null) {
			if (event.getSource() == userPreferencesFrame.getMatch()) {
				setOverallScore();
				sortOverallScore();
				userPreferencesFrame.dispose();
				programMatchFrame = new ProgramMatchFrame();
				programMatchFrame.getGoBackButton().addActionListener(this);

			}

			// Store ratings in the ratings array for each program.
			// Each element of the rating array represents a specific section of the survey.
			// What each element of the rating array represents is described in the program class.
			// Depending what button is clicked for a section of the survey, the corresponding element is given a value.
			
			// Sets the Tuition rating for a program
			for (int i = 0; i < userPreferencesFrame.getPanel1().getRangearray().length; i++) {
				if (event.getSource() == userPreferencesFrame.getPanel1().getRangearray()[i]) {

					setTuitionRating(i);
				}
			}

			// Sets the Co-op rating for a program
			for (int i = 0; i < userPreferencesFrame.getPanel2().getCooparray().length; i++) {
				if (event.getSource() == userPreferencesFrame.getPanel2().getCooparray()[i]) {

					setCoOpRating(i);
				}
			}

			// Sets the Supplementary app rating for a program
			for (int i = 0; i < userPreferencesFrame.getPanel3().getSupparray().length; i++) {
				if (event.getSource() == userPreferencesFrame.getPanel3().getSupparray()[i]) {

					setSuppRating(i);
				}

			}

			// Sets the Part-Time rating for a program
			for (int i = 0; i < userPreferencesFrame.getPanel4().getParttimearray().length; i++) {
				if (event.getSource() == userPreferencesFrame.getPanel4().getParttimearray()[i]) {
					setParttimeRating(i);
				}

			}

			// Sets the Subject rating for a program
			for (int i = 0; i < userPreferencesFrame.getPanel5().getSubjectarray().length; i++) {
				if (event.getSource() == userPreferencesFrame.getPanel5().getSubjectarray()[i]) {
					setSubjectRating(i);
				}
			}

		}
		
		if(programMatchFrame!=null) {
			if(event.getSource()==programMatchFrame.getGoBackButton()) {
				programMatchFrame.dispose();
				dashboardFrame = new DashboardFrame();
			}
		}
		
		/*
		 * Added by: Gordon 
		 * Purpose: Checks which options were chosen in the comparison screen. 
		 * 			Gets the selected options to be used for updating the graph panel.  
		 */
 
		if(compareProgramsFrame!=null) {
			
			//When the user clicks done button and the selected options are not empty
			if(event.getSource() == compareProgramsFrame.getOptionsPanel().getDoneButton() 
				&&compareProgramsFrame.getOptionsPanel().getUniversity1Box() != null 
				&&compareProgramsFrame.getOptionsPanel().getUniversity2Box() != null 
				&&compareProgramsFrame.getOptionsPanel().getTopicBox() != null
				&&compareProgramsFrame.getOptionsPanel().getPrograms1Box() != null
				&&compareProgramsFrame.getOptionsPanel().getPrograms2Box() != null) {
				
				accessAndSetComparisonInformation(); //Since user is finished selecting choices, calls class to set the new values 
			
				//Update graph panel 
				compareProgramsFrame.getGraphPanel().revalidate(); 
				compareProgramsFrame.getGraphPanel().repaint(); 
			}
			
			//If the user clicks the back button
			else if (event.getSource() == compareProgramsFrame.getGoBackButton()) {
				
				//Dispose current screen
				compareProgramsFrame.dispose();
				// Instantiate new screen
				dashboardFrame = new DashboardFrame();
			
			}	
			else if (event.getSource() == compareProgramsFrame.getOptionsPanel().getUniversity1Box()) {
				//Get the selected university name in the dropdown 
				universityName1Choice = compareProgramsFrame.getOptionsPanel().getUniversity1Box().getSelectedItem().toString(); 
			}
			else if (event.getSource() == compareProgramsFrame.getOptionsPanel().getUniversity2Box()) {
				//Get the selected university name in the dropdown 
				universityName2Choice = compareProgramsFrame.getOptionsPanel().getUniversity2Box().getSelectedItem().toString(); 
			}
			else if (event.getSource() == compareProgramsFrame.getOptionsPanel().getTopicBox()) {
				//Change topic name to the program topic name for graph panel 
				topicNameChoice = compareProgramsFrame.getOptionsPanel().getTopicBox().getSelectedItem().toString(); 
			}		
			else if (event.getSource() == compareProgramsFrame.getOptionsPanel().getPrograms1Box()) {
				programNameChoice1 = compareProgramsFrame.getOptionsPanel().getPrograms1Box().getSelectedItem().toString(); 
			}
			else if (event.getSource() == compareProgramsFrame.getOptionsPanel().getPrograms2Box()) {
				programNameChoice2 = compareProgramsFrame.getOptionsPanel().getPrograms2Box().getSelectedItem().toString(); 			
			}
			
		}

	}

	// State Changed method: Implemented for the JSlider
	@Override
	public void stateChanged(ChangeEvent event) {

		if (event.getSource() == mapFrame.getMapPanel().getRadiusSlider())
			sliderValue = mapFrame.getMapPanel().getRadiusSlider().getValue();

	}

	//Added by: Darren
	//This method validates the login information to check if it matches any existing accounts in the file
	public void checkValidID() {
		
		//Goes through the file to check if the username and password match
		user.currentAccount(LoginPanel.userNameTextField.getText(),	String.valueOf(LoginPanel.passwordField.getPassword()));
		
		//If there is an existing user that matches, set the current fields to the user's information and send user to dashboard
		if (userFound) {
			setCurrentProfile();
			loginScreen.dispose(); //Close the login screen
			dashboardFrame = new DashboardFrame(); //Instantiate dashboard screen
			//newProfile(loggedInName, loggedInLM, loggedInUN, loggedInPW); //Create a new file if the user logging in does not have one
			loadCurrentAccountFile(user.getUsername()); //Get the information of the current user
			LoginPanel.invalidID.setVisible(false);
			SignupPanel.fillFields.setVisible(false);
		}
		
		//Otherwise, if there is a blank space or username and password do not match, display an invalid message
		else if (LoginPanel.userNameTextField.getText().equals("") || LoginPanel.userNameTextField.getText().equals("") || !userFound) {
			LoginPanel.invalidID.setVisible(true);
		
		}
		
	}
	
	//Added by: Darren
	//This method validates the user's input text when they sign up
	public void signUp() {
	
		//Get the text from the text fields and set it to a variable
		String name = SignupPanel.nameTextField.getText();
		String lastName = SignupPanel.lastNameTextField.getText();
		String userName = SignupPanel.userNameTextField.getText();
		String password = String.valueOf(SignupPanel.passwordField.getPassword());
		
		//Check if the username that the user wants to sign up with is taken
		user.currentAccount(userName, password);
		
		//If any of the fields are blank, or there already exists an account with the username. display invalid message
		if (name.equals("") || lastName.equals("") || userName.equals("") || password.equals("") || userExists)
			SignupPanel.fillFields.setVisible(true);
		
		//Otherwise, write and save the user credentials into the account file
		else {
			
			//Write and save the user information
			saveProfile(name,lastName,userName,password,filepath);
			
			//Set the current information for the profile
			user.setFirstName(name);
			user.setLastName(lastName);
			user.setUsername(userName);
			user.setPassword(password);
			
			//Set user exists to false for next user
			userExists = false;
			
			//Set the current profile information
			setCurrentProfile();
			
			//Set the invalid message labels to not visible
			SignupPanel.fillFields.setVisible(false);
			LoginPanel.invalidID.setVisible(false);
			
			//Closes the login screen and sends the user to the dashboard
			loginScreen.dispose();
			dashboardFrame = new DashboardFrame();
			
			//Disables every button except the profile button in order to get user to input their location
			MatchPanel.survey.setEnabled(false);
			MapPanel.lookAtPrograms.setEnabled(false);
			ComparisonPanel.compare.setEnabled(false);
			UserFrame.toDashBoard.setEnabled(false);
			
			//System.out.println(user.getFirstName() + " " + user.getLastName() + " "  + user.getUsername() + " " + user.getPassword());
		}
	
	}

	//Added by: Darren
	//This method saves the user's profile into the account file
	public static void saveProfile(String name, String lastName, String userName, String password, String filepath) {
	
		try {
			
			//Create new writers
			FileWriter fileWriter = new FileWriter(filepath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);
			
			//Writer the new profile information into the account file
			printWriter.println();
			printWriter.print(name + "," + lastName + "," + userName + "," + password + ",");
			printWriter.flush();
			printWriter.close();
			
			//Display saved message into the csv
			System.out.println("saved");
			
			//Create new profile file for user
			newProfile(name, lastName, userName, password);
			
			userFound = true;
			
		} catch (Exception E) {
			
		}

	}

	//Added by: Darren
	//This method sets the current user credentials
	public void setCurrentProfile() {
		
		loggedInName = user.getFirstName();
		loggedInLM = user.getLastName();
		loggedInUN = user.getUsername();
		loggedInPW = user.getPassword();
		
	}
	
	//Added by: Darren
	//This method creates a separate file when a user signs up
	public static void newProfile(String name, String lastName, String userName, String password) {
		
		try {
			
			File file = new File(userName + ".csv");
			
			//If the user file does not exist, create a new file
			if (!file.exists()) {
				file.createNewFile();
				
				//Set up writers
				FileWriter fileWriter = new FileWriter(file, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				
				//Write the user credentials into the new file
				printWriter.print(name + "," + lastName + "," + userName + "," + password + ",");
				printWriter.flush();
				printWriter.close();
				
				//Display message
				System.out.println("Created new account profile!");
			}
			
			//Otherwise, display error message
			else
				System.out.println("Account already exists!");
			
		} catch (Exception E) {
			
		}
		
	}
	
	//Added by: Darren
	//This method resets all of the frames, panels, and fields when the user logs out
	private void loggedOut() {
		
		//Create new login screen
		loginScreen = new LoginScreen();
		
		//Add all of the panels back
		loginScreen.add(homePanel);
		loginScreen.add(signupPanel);
		loginScreen.add(loginPanel);
		
		//Set the visibility
        loginScreen.setVisible(true);
        loginPanel.setVisible(false);
        signupPanel.setVisible(false);
		loginScreen.setVisible(true);
		homePanel.setVisible(true);
		
		//Set all of the text fields to blank
		LoginPanel.userNameTextField.setText("");
		LoginPanel.passwordField.setText("");
		
		SignupPanel.nameTextField.setText("");
		SignupPanel.lastNameTextField.setText("");
		SignupPanel.userNameTextField.setText("");
		SignupPanel.passwordField.setText("");
		
		LocationPanel.city.setText("");
		LocationPanel.streetNum.setText("");
		LocationPanel.streetName.setText("");
		
		//Set previous user fields to false
		user.setFirstName("");
		user.setLastName("");
		user.setUsername("");
		user.setPassword("");
		
		user.setCity("");
		user.setStreetNum("");
		user.setStreetName("");
		
		userFound = false; //Set userfound to false for next user
		enteredLocation = false; //Set enterLocation to false for next user
		
	}
	
	//Added by: Darren
	//This method loads the current account details when the user logs in (Name, login credentials, location) 
	public void loadCurrentAccountFile(String username) {

		try {
			
			//Read the csv(comma seperated values) file
			Scanner input = new Scanner (new File(username + ".csv"));
			input.useDelimiter(",|\\n");
			
			//Goes through csv file until there is no next input
			while (input.hasNext()) {
				
				//Set the current name and login credentials
				user.setFirstName(input.next());
				user.setLastName(input.next());
				user.setUsername(input.next());
				user.setPassword(input.next());
				
				input.nextLine();
				
				//Set the current location
				user.setCity(input.next());
				user.setStreetNum(input.next());
				user.setStreetName(input.next());
				input.next();
				enteredLocation = true;
				
				input.nextLine();
				
				//Display the user information into the console
				System.out.println("USER INFORMATION:");
				System.out.printf("%s, %s, %s, %s\n", user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
				System.out.printf("%s, %s, %s, %b\n", user.getCity(), user.getStreetNum(), user.getStreetName(), enteredLocation);
				
			}
		
			input.close();
			
		} catch(FileNotFoundException error) {
			
			//Display the error to the console
			System.out.println("Sorry file not loading - please check the name/location");
		}
		
	}
	
	//Added by: Darren
	//This method writes the location of the user into their csv file
	public void writeLocation() {
		
		//if the user did not initially set up a location, write their location onto the last line of the csv file
		if (!enteredLocation)
			try {
				
				//Set the file to the user's personal account file
				File file = new File(user.getUsername() + ".csv");
				
				FileWriter fileWriter = new FileWriter(file, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				
				//Set the location to the input values
				user.setCity(LocationPanel.city.getText());
				user.setStreetNum(LocationPanel.streetNum.getText());
				user.setStreetName(LocationPanel.streetName.getText());
				
				//Write the location into the file
				printWriter.println();
				printWriter.print(user.getCity() + "," + user.getStreetNum() + "," + user.getStreetName() + "," + "true" + ",");
				printWriter.println();
				printWriter.flush();
				printWriter.close();
				
				//Display message
				System.out.println("saved location");
				
				//Enable all of the buttons
				MatchPanel.survey.setEnabled(true);
				MapPanel.lookAtPrograms.setEnabled(true);
				ComparisonPanel.compare.setEnabled(true);
				UserFrame.toDashBoard.setEnabled(true);
				
			} catch (Exception E) {
				
			}
		
		//Otherwise, override the current location with the new location
		else
			overWrite(user.getUsername(), LocationPanel.city.getText() + "," + LocationPanel.streetNum.getText() 
						+ "," + LocationPanel.streetName.getText() + "," + "true" + ",");
		
	}
	
	//Added by: Darren
	//This method finds the row that the location of the user is written on in their csv. file and updates it
	public void overWrite(String username, String data) {
		
		//Overwrite the location of the user to the new location
		//https://stackoverflow.com/questions/31375972/how-to-replace-a-specific-line-in-a-file-using-java
		try {
			
		    Path path = Paths.get(username + ".csv"); //Set the path to the user's personal account fule
		    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8); //Create array list for the line that is going to be removed
		    lines.set(1,data); //Set the desired line to overwrite
		    Files.write(path, lines, StandardCharsets.UTF_8); //Overwrite the old location
		
		} catch (Exception E) {
			
			System.out.println("File not found!"); //Display error message
			
		}
		
		//Set the new location of the user
		user.setCity(LocationPanel.city.getText());
		user.setStreetNum(LocationPanel.streetNum.getText());
		user.setStreetName(LocationPanel.streetName.getText());
		
	}

	// Added by: Ashwin
	//Each program is each given an overall score by finding the sum of the elements of their respective ratings arrays.
	private void sortOverallScore() {

		// Sorts the scores of all the programs.
		for (int program = 0; program < programArray.length; program++) {
			Arrays.sort(AppController.programArray, Comparator.comparing(Program::getOverallScore).reversed());

		}

	}

	// Added by: Ashwin
	// Sets Overall score for all the programs
	private void setOverallScore() {

		for (int program = 0; program < programArray.length; program++) {
			int sumOfScores = 0;
			for (int i = 0; i < 6; i++) {
				sumOfScores += programArray[program].getRatings()[i];
			}
			programArray[program].setOverallScore(sumOfScores);
			System.out.println(programArray[program].getOverallScore());
		}

	}

	// Added by: Ashwin
	// Sets rating for tuition
	private void setTuitionRating(int index) {
		for (int program = 0; program < programArray.length; program++) {
			if (index == 0) {
				if (programArray[program].getTuition() > 5000 && programArray[program].getTuition() < 10000) {
					programArray[program].getRatings()[0] = 100;
				} else if (programArray[program].getTuition() > 10000 && programArray[program].getTuition() < 15000) {
					programArray[program].getRatings()[0] = 25;
				} else if (programArray[program].getTuition() > 15000) {
					programArray[program].getRatings()[0] = 0;
				}
			}
			if (index == 1) {
				if (programArray[program].getTuition() > 5000 && programArray[program].getTuition() < 10000) {
					programArray[program].getRatings()[0] = 25;
				} else if (programArray[program].getTuition() > 10000 && programArray[program].getTuition() < 15000) {
					programArray[program].getRatings()[0] = 100;
				} else if (programArray[program].getTuition() > 15000) {
					programArray[program].getRatings()[0] = 0;
				}
			}
			if (index == 2) {
				if (programArray[program].getTuition() > 5000 && programArray[program].getTuition() < 10000) {
					programArray[program].getRatings()[0] = 25;
				} else if (programArray[program].getTuition() > 10000 && programArray[program].getTuition() < 15000) {
					programArray[program].getRatings()[0] = 25;
				} else if (programArray[program].getTuition() > 15000) {
					programArray[program].getRatings()[0] = 100;
				}
			}

		}
	}

	// Added by: Ashwin
	// Sets rating for Co-op
	private void setCoOpRating(int index) {

		for (int program = 0; program < programArray.length; program++) {
			if (index == 0) {
				if (programArray[program].isHasCoOp() == true) {
					programArray[program].getRatings()[1] = 50;
				} else if (programArray[program].isHasCoOp() == false) {
					programArray[program].getRatings()[1] = 0;
				}
			}

			if (index == 1) {
				if (programArray[program].isHasCoOp() == true) {
					programArray[program].getRatings()[1] = 0;
				} else if (programArray[program].isHasCoOp() == false) {
					programArray[program].getRatings()[1] = 50;
				}
			}
		}

	}

	// Added by: Ashwin
	// Sets rating for Supplementary
	private void setSuppRating(int index) {
		for (int program = 0; program < programArray.length; program++) {
			if (index == 0) {
				if (programArray[program].isHasSupplementaryApplication() == true) {
					programArray[program].getRatings()[2] = 10;
				} else if (programArray[program].isHasSupplementaryApplication() == false) {
					programArray[program].getRatings()[2] = 0;
				}
			}

			if (index == 1) {
				if (programArray[program].isHasSupplementaryApplication() == true) {
					programArray[program].getRatings()[2] = 0;
				} else if (programArray[program].isHasSupplementaryApplication() == false) {
					programArray[program].getRatings()[2] = 10;
				}
			}
		}
	}

	// Added by: Ashwin
	// Sets rating for part-time
	private void setParttimeRating(int index) {
		for (int program = 0; program < programArray.length; program++) {
			if (index == 0) {
				if (programArray[program].isHasFullTimeStatus() == true) {
					programArray[program].getRatings()[3] = 25;
				} else if (programArray[program].isHasFullTimeStatus() == false) {
					programArray[program].getRatings()[3] = 0;
				}
			}

			if (index == 1) {
				if (programArray[program].isHasFullTimeStatus() == true) {
					programArray[program].getRatings()[3] = 0;
				} else if (programArray[program].isHasFullTimeStatus() == false) {
					programArray[program].getRatings()[3] = 25;
				}
			}
		}

	}

	// Added by: Ashwin
	// Sets rating for preferred subject of the user
	private void setSubjectRating(int index) {

		for (int program = 0; program < programArray.length; program++) {
			if (index == 0) {
				if (programArray[program].getCategory().equals("Engineering")) {
					programArray[program].getRatings()[4] = 1000;

				} else if (programArray[program].getCategory().equals("Computer Science")) {
					programArray[program].getRatings()[4] = 0;
				} else if (programArray[program].getCategory().equals("Mathematics")) {
					programArray[program].getRatings()[4] = 0;
				}

			}

			if (index == 1) {
				if (programArray[program].getCategory().equals("Engineering")) {
					programArray[program].getRatings()[4] = 0;
				} else if (programArray[program].getCategory().equals("Computer Science")) {
					programArray[program].getRatings()[4] = 1000;
				} else if (programArray[program].getCategory().equals("Mathematics")) {
					programArray[program].getRatings()[4] = 0;
				}

			}

			if (index == 2) {
				if (programArray[program].getCategory().equals("Engineering")) {
					programArray[program].getRatings()[4] = 0;
				} else if (programArray[program].getCategory().equals("Computer Science")) {
					programArray[program].getRatings()[4] = 0;
				} else if (programArray[program].getCategory().equals("Mathematics")) {
					programArray[program].getRatings()[4] = 1000;
				}

			}

		}

	}
	
	
	/*
	 * Added by: Gordon 
	 * Purpose: Gets the 2 universities information and sets the new graph panel's values. 
	 */
	private void accessAndSetComparisonInformation() {
		
		int count2 = 0; //Counts number of times the university name didn't match the user's selected universities
		
		//For loop tries to find the value needed in the right column
		for(int counter = 0; counter<programArray.length; counter++) {
			
			//If the university name matches the first university's name
			if(programArray[counter].getUniversity().equals(universityName1Choice)){
				
				//Check if the program name of the array is equal to the program name of unversity 1
				if(programNameChoice1.equals(programArray[counter].getProgramName())) {
					
					setTopicValue(counter, "Uni 1"); 
				}
			}
			
			//If the university name matches the second university's name
			else if(programArray[counter].getUniversity().equals(universityName2Choice)){
				
				//Check if the program name of the array is equal to the program name of unviersity 2
				if(programNameChoice2.equals(programArray[counter].getProgramName())) {
					
					setTopicValue(counter, "Uni 2"); 
				}
			}
			
			else {
				count2 += 1; 
			}
		}
		
		//If atleast 1 of the universities do not have the program
		if(count2 == programArray.length || count2 == programArray.length - 1) {
			System.out.println("Sorry 1 of the univeristies does not have this program"); 
		}
		
		//Set new values in the graph panel
			//These values can change the title and axis names. 
		compareProgramsFrame.getGraphPanel().setTopicChoice(topicNameChoice); 
		compareProgramsFrame.getGraphPanel().setUniversity1(universityName1Choice);
		compareProgramsFrame.getGraphPanel().setUniversity2(universityName2Choice);
		compareProgramsFrame.getGraphPanel().setProgram1(programNameChoice1);
		compareProgramsFrame.getGraphPanel().setProgram2(programNameChoice2);
		
	}
	/*
	 * Added by: Gordon 
	 * Purpose: Finds the specific information needed in the programArray so that it can be used to compare between the universities. 
	 * 			Sets the new value to the specific topic 
	 */
	private void setTopicValue(int counter, String uni) {

		//Checks what name the topic name chosen by user is
		//If selected name matches then it will set the information for that university 
		
		if(topicNameChoice.equals("Tuition")) {
				if (uni.equals("Uni 1"))
					compareProgramsFrame.getGraphPanel().setTuition1((programArray[counter].getTuition())); 
				else
					compareProgramsFrame.getGraphPanel().setTuition2((programArray[counter].getTuition())); 
		}
		
		else if(topicNameChoice.equals("Admission Average")) {
			int tempInt1;  //Takes the first number of the range part  
			int tempInt2;  //Takes the second number of the range part 
			
			//Calculates admission average for the corresponding university 
			//by take part of the strings and turning it to an integer				
			if (uni.equals("Uni 1")) {				
				tempInt1 = Integer.parseInt(programArray[counter].getAdmissionAverage().substring(0, 1));
				tempInt2 = Integer.parseInt(programArray[counter].getAdmissionAverage().substring(3, 4));
				compareProgramsFrame.getGraphPanel().setAdmissionAverage1((tempInt1+tempInt2)/2); 
			}
			else {
				tempInt1 = Integer.parseInt(programArray[counter].getAdmissionAverage().substring(0, 1));
				tempInt2 = Integer.parseInt(programArray[counter].getAdmissionAverage().substring(3, 4));
				compareProgramsFrame.getGraphPanel().setAdmissionAverage2((tempInt1+tempInt2)/2);
			}
		}
		
		else if(topicNameChoice.equals("Program Rating")) {
			System.out.println(programArray[counter]); 
			System.out.println(compareProgramsFrame.getGraphPanel().getProgramRating1()); 
			
			if (uni.equals("Uni 1")) {	
				compareProgramsFrame.getGraphPanel().setProgramRating1(programArray[counter].getProgramRating());
				
			}
			else {
				compareProgramsFrame.getGraphPanel().setProgramRating2(programArray[counter].getProgramRating());
			}
		}
		
	}

}
