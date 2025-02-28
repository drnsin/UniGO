package view.comparison;

import javax.swing.*; 
import java.awt.*; 
import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException; 

/*
 * Author: Gordon 
 * This class is the panel that contains the buttons, dropdowns, and labels so that it can be used for user input. 
 */
public class OptionsPanel extends JPanel{
	
	private String[] universityList = new String[23]; 
	private String[] topicList = {"Tuition", "Admission Average", "Program Rating"}; 
	private String[] programList1 = new String[83]; 
	private String[] programList2 = new String[83]; 
	private JComboBox university1Box;
	private JComboBox university2Box;
	private JComboBox topicBox; 
	private JComboBox programs1Box; 
	private JComboBox programs2Box; 
	private JButton doneButton;
	 
	private JLabel uni1ChoiceLabel; 
	private JLabel uni2ChoiceLabel; 
	private JLabel topicChoiceLabel; 
	private JLabel program1ChoiceLabel; 
	private JLabel program2ChoiceLabel; 

	
	//Constructor
	public OptionsPanel() {
		setLayout(null);
		setBounds(860, 0, 920, 1080); //(x, y, length, width) 
		setOpaque(false);
		
		try {
			getLists(); //Get the lists to be used for the ComboBox
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		addComponents(); //Add the buttons, labels, and etc to the panel 
	}
	
	//Reads the files and gets the list of universities and programs
	private void getLists() throws FileNotFoundException{
		
		File theUniversityFile = new File("universities.txt");
		File theProgramFile = new File("programs.txt"); 
		
		Scanner scan = new Scanner(theUniversityFile);
		Scanner scan2 = new Scanner(theProgramFile); 
		
		//Populate the university list array with the 23 university names 
		for (int count = 0; count<23; count++) {
			universityList[count] = scan.nextLine(); 
		}	
		
		for (int count2 = 0; count2<83; count2++) {
			programList1[count2] = scan2.nextLine(); 
		}			
		programList2 = programList1; 
		
		scan.close(); 		
		scan2.close(); 
	}

	//Method adds the buttons, labels, dropdowns, and slider to panel
	private void addComponents() {
		
	    doneButton = new JButton("Done"); 
		doneButton.setBounds(305, 300, 100, 20); 
		add(doneButton);
		
	   
		
		uni1ChoiceLabel = new JLabel("Select University 1:"); 
		uni1ChoiceLabel.setBounds(0, 150, 300, 20); 
		uni1ChoiceLabel.setFont((new Font("Times New Roman", Font.PLAIN, 20)));
		uni1ChoiceLabel.setForeground(Color.WHITE);
		add(uni1ChoiceLabel);
		
		uni2ChoiceLabel = new JLabel("Select University 2:"); 
		uni2ChoiceLabel.setBounds(360, 150, 300, 20); 
		uni2ChoiceLabel.setFont((new Font("Times New Roman", Font.PLAIN, 20)));
		uni2ChoiceLabel.setForeground(Color.WHITE);
		add(uni2ChoiceLabel);
		
		topicChoiceLabel = new JLabel("Select topic:"); 
		topicChoiceLabel.setBounds(330, 250, 200, 20);  
		topicChoiceLabel.setFont((new Font("Times New Roman", Font.PLAIN, 20)));
		topicChoiceLabel.setForeground(Color.WHITE);
		add(topicChoiceLabel);
		
		program1ChoiceLabel = new JLabel("Select Program for university 1:"); 
		program1ChoiceLabel.setBounds(0, 200, 300, 20); 
		program1ChoiceLabel.setFont((new Font("Times New Roman", Font.PLAIN, 20)));
		program1ChoiceLabel.setForeground(Color.WHITE);
		add(program1ChoiceLabel);
		
		program2ChoiceLabel = new JLabel("Select Program for university 2:"); 
		program2ChoiceLabel.setBounds(360, 200, 350, 20);  
		program2ChoiceLabel.setFont((new Font("Times New Roman", Font.PLAIN, 20)));
		program2ChoiceLabel.setForeground(Color.WHITE);
		add(program2ChoiceLabel);
		
		university2Box = new JComboBox(universityList); 
		university2Box.setBounds(360, 170, 300, 20);
		add(university2Box);
		
	    university1Box = new JComboBox(universityList); 
		university1Box.setBounds(0, 170, 300, 20);
		add(university1Box);
		
		topicBox = new JComboBox(topicList); 
		topicBox.setBounds(315, 270, 120, 20);
		add(topicBox);
		
		programs1Box = new JComboBox(programList1); 
		programs1Box.setBounds(0, 220, 350, 20);
		add(programs1Box);
		
		programs2Box = new JComboBox(programList2); 
		programs2Box.setBounds(360, 220, 350, 20);
		add(programs2Box);
		
	}
	
	//Getters and setters
	public JComboBox getUniversity1Box() {
		return university1Box;
	}

	public void setUniversity1Box(JComboBox university1Box) {
		this.university1Box = university1Box;
	}

	public JComboBox getUniversity2Box() {
		return university2Box;
	}

	public void setUniversity2Box(JComboBox university2Box) {
		this.university2Box = university2Box;
	}

	public JComboBox getTopicBox() {
		return topicBox;
	}

	public void setTopicBox(JComboBox topicBox) {
		this.topicBox = topicBox;
	}

	public JComboBox getPrograms1Box() {
		return programs1Box;
	}

	public void setPrograms1Box(JComboBox programs1Box) {
		this.programs1Box = programs1Box;
	}

	public JComboBox getPrograms2Box() {
		return programs2Box;
	}

	public void setPrograms2Box(JComboBox programs2Box) {
		this.programs2Box = programs2Box;
	}

	public JButton getDoneButton() {
		return doneButton;
	}

	public void setDoneButton(JButton doneButton) {
		this.doneButton = doneButton;
	}
	
}