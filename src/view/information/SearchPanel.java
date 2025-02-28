package view.information;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Author: Shreyas Peddi
 * This panel has front end elements for the information screen. Information should
 * be setup in this panel before proceeding. It also has the map button.
 */
public class SearchPanel extends JPanel{

	//Fields
	private Stack<String> universities = new Stack<String>();	//Stack of universities for drop down menu options
	public static JComboBox uniDropdown; //University drop down
	public static JComboBox categoryDropdown; //Category drop down
	private JButton searchButton; //Search Button to display results
	private JButton mapButton; //Go to the map screen
	private JButton backButton = new JButton(new ImageIcon("images/backIconWhite.png")); //Back button to return to information screen
	private JLabel backgroundImg; //Search panel background
	
	//Constructor
	public SearchPanel() {
		
		//Panel setup
		setLayout(null);
		setBounds(0,0,1920,400);
		
		//Setup components
		setUpUniDropdown();
		setUpCategoryDropdown();
		setUpSearchButton();
		setUpMapButton();
		setUpBackButton();
		
		//Add them to the panel
		add(uniDropdown);
		add(categoryDropdown);
		add(searchButton);
		add(backButton);
		add(mapButton);
		
		//Setup background 
		backgroundImg = new JLabel(new ImageIcon("images/searchPanel.png"));
		backgroundImg.setBounds(0,0,1920,400);
		
		//Add background
		add(backgroundImg);
	}

	//Sets up the back button which is used to go back to the information screen
	private void setUpBackButton() {
		backButton.setBounds(this.getX()+36,this.getY()+29,40,40);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
	}

	//Sets up the map button to go to the map screen
	private void setUpMapButton() {
		mapButton= new JButton();
		mapButton.setIcon(new ImageIcon(new ImageIcon("images/showOnMap.png").getImage().getScaledInstance(100, 100, 0)));
		mapButton.setBounds(this.getWidth()-200,searchButton.getBounds().y,100,100);

	}

	//Sets up the search button which displays results of programs
	private void setUpSearchButton() {
		searchButton= new JButton();
		searchButton.setIcon(new ImageIcon(new ImageIcon("images/search.png").getImage().getScaledInstance(48, 48,0)));
		searchButton.setBounds(categoryDropdown.getBounds().x+270,categoryDropdown.getBounds().y,50,50);
	}
	
	//Sets up category drop down
	private void setUpCategoryDropdown() {
		String[] categories = new String[] {"Computer Science", "Mathematics", "Engineering", "All"};
		categoryDropdown = new JComboBox(categories);
		categoryDropdown.setBounds(390,uniDropdown.getBounds().y,180,20);
	}

	//Sets up uni drop down by retrieving university list from a file
	private void setUpUniDropdown() {
		retrieveData();
		uniDropdown = new JComboBox(universities);
		uniDropdown.setBounds(80, 190,180,20);
	}

	//Read list of universities from a file
	private void retrieveData() {
		//Reads all universities from text file
		File file = new File("universities.txt");
		
		try {
			//Use scanner object
			Scanner input = new Scanner(file);
			input.useDelimiter(",|\\r\\n");
			
			//As long there is another line
			while(input.hasNextLine()) {
				
				//Add university name
				universities.add(input.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Add the "all" option
		universities.add("All");
	}

	//GETTERS AND SETTERS
	public Stack<String> getUniversities() {
		return universities;
	}

	public void setUniversities(Stack<String> universities) {
		this.universities = universities;
	}

	public JComboBox getUniDropdown() {
		return uniDropdown;
	}

	public void setUniDropdown(JComboBox uniDropdown) {
		this.uniDropdown = uniDropdown;
	}

	public JComboBox getCategoryDropdown() {
		return categoryDropdown;
	}

	public void setCategoryDropdown(JComboBox categoryDropdown) {
		this.categoryDropdown = categoryDropdown;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JButton getMapButton() {
		return mapButton;
	}

	public void setMapButton(JButton mapButton) {
		this.mapButton = mapButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	
}	//End of class
