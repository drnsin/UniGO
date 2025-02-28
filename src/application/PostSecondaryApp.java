package application;

import controller.AppController;
/*    Project Header
 * Authors: Shreyas, Gordon, Imraan, Darren, Ashwin
 * Course Code: ICS4U1-01
 * Teacher: Mr. Fernandes
 * Date: 2021-16-12
 * Title: UniGO
 * Description: This application runs the Post Secondary Application (UniGO). Allows the user to create a new profile to login in back even after
 * the application is restarted. This application stores user data (name, location, login information). It has an interactive dashboard with
 * panels to access the unique features of this application. It can use user address to display all universities within a a given radius. 
 * Our app finds the best university program (Computer Science, Mathematics, Engineering) for you using the matching algorithm.
 * We have a comparison model to compare programs visually (using graphs).
 * Added Features:
 *  - Login, Signup and Home screen (Darren):
 *  - Dashboard (Darren):
 *  - Program Information Screen (Shreyas): Filter function to select a university(or all) and a subject area(or all) to display university programs
 *  in a scrollable area. Further information about the program is provided when the program button is clicked.
 *  - Map Screen (Shreyas): This screen implements the MAPS static API and Geocoding API to get convert user location to latitude and longitude,
 *  display a static map, display markers for each university(within the selected radius) and the user. It has the zoom in, zoom out and change map type features
 *  - Comparison Screen(Gordon): Takes user's selected options, displaying the numerical information(Tuition, program tating, and admission average) 
 *  for the selected university programs on a generated bar graph.
 *  - User Preferences Screen (Ashwin):  Takes the users entered responses for each survey question.
 *  - Matching Screen (Ashwin): Finds and displays the top three universities  that fit the user preferences.
 *  - User Profile screen (Darren and Imraan):
 *  
 * Areas of Concern:  
 * - When the user is finished selecting their options, the bar graph will not update with the new values(Comparison screen)
 * 
 * Major Skills: File reading and writing, using algorithms, using external APIs and libraries, Object-Oriented Programming
 * Requirements: Add jar files by selecting all the files in the "libraries" folder
 */

public class PostSecondaryApp {

	public static void main(String[] args) {
		new AppController();
	}

}
