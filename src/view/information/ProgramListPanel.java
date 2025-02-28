package view.information;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.AppController;
import model.Program;

/* Author: Shreyas Peddi
 * This panel displays all the programs in a scroll panel based on the filters selected in the search panel.
 */
public class ProgramListPanel extends JPanel{

	//Fields
	private JButton programInfoButtons[] = new JButton[200]; //Creates a list of buttons to display programs
	public static int programButtonIndex;	//Index to keep track of programs
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/programListPanel.png"));
	
	//Constructor
	public ProgramListPanel() {
		
		//Use a box layout
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		backgroundImg.setBounds(0,0,1920,680);
		add(backgroundImg);
		//Set the initial visibility to false
		setVisible(true);
	}

	//This method shows search after any filters are placed
	public void showResults() {
		programButtonIndex=0;
		
		//Get the combo box input information
		String universityName= (String) SearchPanel.uniDropdown.getItemAt(SearchPanel.uniDropdown.getSelectedIndex());
		String category= (String) SearchPanel.categoryDropdown.getItemAt(SearchPanel.categoryDropdown.getSelectedIndex());
		
		//Loop through all the programs and display the appropriate programs on the button
		for(int program=0;program<AppController.programArray.length;program++) {
			
			//Stop looping if there are no more programs
			if(AppController.programArray[program]==null)
				break;
			
			//Display all the universities program data if selected
			if(universityName.equals("All")) {
				
				//Display all programs
				if(category.equals("All")) {
					addButton(AppController.programArray[program]);
					repaint();
				}
				
				//Display a specific category data if selected
				else if(AppController.programArray[program].getCategory().equals(category)) {
					addButton(AppController.programArray[program]);
					repaint();
				}
			}
			
			//If a specific university is chosen
			else if(AppController.programArray[program].getUniversity().equals(universityName)) {
				
				//Display all programs if selected
				if(category.equals("All")) {
					addButton(AppController.programArray[program]);
					repaint();
				}
				
				//Display a specific category if selected
				else if(AppController.programArray[program].getCategory().equals(category)) {
					addButton(AppController.programArray[program]);
					repaint();
				}
			}
		}
				
	}

	//This method adds program info data button. When clicked a popup window will show up
	private void addButton(Program program) {
		
		//Setup the button
		programInfoButtons[programButtonIndex]=new JButton(program.getUniversity()+": "+program.getProgramName());
		programInfoButtons[programButtonIndex].setMaximumSize(new Dimension(1900,100));
		programInfoButtons[programButtonIndex].setPreferredSize(new Dimension(1900,100));
		programInfoButtons[programButtonIndex].setBackground(new Color(0,0,100));
		programInfoButtons[programButtonIndex].setForeground(new Color (255,255,255));
		programInfoButtons[programButtonIndex].setFont(new Font("Times New Roman", Font.PLAIN, 40));
		programInfoButtons[programButtonIndex].setOpaque(true);
		
		//Add the program to the scrollable panel
		this.add(programInfoButtons[programButtonIndex]);
		
		//Implement functionality using action listener
		programInfoButtons[programButtonIndex].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				//Custom color
				Color bgColor = new Color(246, 76, 114);
				
				//Create a new pop up window
				JFrame popUpWindow = new JFrame(program.getUniversity()+": "+program.getProgramName());
				
				//Setup popup window
				popUpWindow.setSize(500,580);
				popUpWindow.setLayout(null);
				JLabel universityIcon = new JLabel(new ImageIcon(new ImageIcon("images/"+program.getUniversity()+".png").getImage().getScaledInstance(200, 200,0)));
				universityIcon.setBounds(140,0,200,200);
				popUpWindow.add(universityIcon);
				
				//Add a University Name label and setup the label
				JLabel uniName = new JLabel("University Name: "+program.getUniversity());
				uniName.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				uniName.setBounds(50,210,400,20);
				uniName.setBackground(bgColor);
				uniName.setOpaque(true);
				popUpWindow.add(uniName);
				
				//Add a Programs Name label and setup the label
				JLabel programName = new JLabel("Program Name: "+program.getProgramName());
				programName.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				programName.setBounds(50,240,400,20);
				programName.setBackground(bgColor);
				programName.setOpaque(true);
				popUpWindow.add(programName);
				
				//Add a Degree label and setup the label
				JLabel degree = new JLabel("Degree: "+program.getDegree());
				degree.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				degree.setBounds(50,270,400,20);
				degree.setBackground(bgColor);
				degree.setOpaque(true);
				popUpWindow.add(degree);
				
				//Add a Tuition label and setup the label
				JLabel tuition = new JLabel("Tuition: $"+program.getTuition());
				tuition.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				tuition.setBounds(50,300,400,20);
				tuition.setBackground(bgColor);
				tuition.setOpaque(true);
				popUpWindow.add(tuition);
				
				//Add a Location label and setup the label
				JLabel location = new JLabel("Location: "+program.getLocation());
				location.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				location.setBounds(50,330,400,20);
				location.setBackground(bgColor);
				location.setOpaque(true);
				popUpWindow.add(location);
				
				//Add a Admission avergae label and setup the label
				JLabel admissionAverage = new JLabel("Admission Average: "+program.getAdmissionAverage());
				admissionAverage.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				admissionAverage.setBounds(50,360,400,20);
				admissionAverage.setBackground(bgColor);
				admissionAverage.setOpaque(true);
				popUpWindow.add(admissionAverage);
				
				//Display appropriate message for full time status boolean value
				String message;
				if(program.isHasFullTimeStatus())
					 message = "yes";
				else
					message="no";
				
				//Add a Full time status label and setup the label
				JLabel fullTimeStatus = new JLabel("Part- time study option: "+message);
				fullTimeStatus.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				fullTimeStatus.setBounds(50,390,400,20);
				fullTimeStatus.setBackground(bgColor);
				fullTimeStatus.setOpaque(true);
				popUpWindow.add(fullTimeStatus);
				
				//Loop through all the courses and display only the required courses for that specific program
				String preReq="";
				for(int course=0;course<program.getCourses().length;course++) 
	
					//Display if it is not recommended or not required
					if(!program.getCourses()[course].getRequirement().equals("RECOMMENDED") && !program.getCourses()[course].getRequirement().equals("-1")) {
						if(preReq.length()==0)
							preReq = program.getCourses()[course].getName();
						else
							preReq = preReq+","+program.getCourses()[course].getName();
					}
				
				//Add a Prereq courses label and setup the label
				JLabel preReqLabel = new JLabel("Prerequisities: "+preReq);
				preReqLabel.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,15));
				preReqLabel.setBounds(50,420,400,20);
				preReqLabel.setBackground(bgColor);
				preReqLabel.setOpaque(true);
				popUpWindow.add(preReqLabel);
				
				//Display appropriate message for supplementary application boolean value
				if(program.isHasSupplementaryApplication())
					 message = "yes";
				else
					message="no";
				
				//Add a Supplementary application label and setup the label
				JLabel suppAppLabel = new JLabel("Supplementary Application: "+message);
				suppAppLabel.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				suppAppLabel.setBounds(50,450,400,20);
				suppAppLabel.setBackground(bgColor);
				suppAppLabel.setOpaque(true);
				popUpWindow.add(suppAppLabel);
				
				//Display appropriate message for supplementary application boolean value
				if(program.isHasCoOp())
					 message = "yes";
				else
					message="no";
				
				//Add a Co-op label and setup the label
				JLabel coOpLabel = new JLabel("Co-op: "+message);
				coOpLabel.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,17));
				coOpLabel.setBounds(50,480,400,20);
				coOpLabel.setBackground(bgColor);
				coOpLabel.setOpaque(true);
				popUpWindow.add(coOpLabel);
				popUpWindow.setVisible(true);
			}
			
		});
		
		//Update the index
		programButtonIndex++;
	}

	//GETTERS AND SETTERS
	public JButton[] getProgramInfoButtons() {
		return programInfoButtons;
	}

	public void setProgramInfoButtons(JButton[] programInfoButtons) {
		this.programInfoButtons = programInfoButtons;
	}

	public static int getProgramButtonIndex() {
		return programButtonIndex;
	}

	public static void setProgramButtonIndex(int programButtonIndex) {
		ProgramListPanel.programButtonIndex = programButtonIndex;
	}
	
	
}
