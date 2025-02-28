package view.matching;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 *Author: Ashwin
 *This class is the panel that contains and displays the fifth and final question of the survey(What field of study do you want to pursue?) 
 *and it's respective options
 */

@SuppressWarnings("serial")
public class Qpanel5 extends JPanel{
	
	//Creating JLabel,RadioButtons, and an array to store the RadioButtons
	private JLabel question5=new JLabel("What field of study do you want to pursue?");
	private JRadioButton Engineer=new JRadioButton("Engineering");
	private JRadioButton CS=new JRadioButton("Computer Science");
	private JRadioButton Math=new JRadioButton("Math");
	private JRadioButton subjectarray[]={Engineer,CS,Math};
	
	public Qpanel5() {
		setLayout(null);
		setBounds(500,500,400,130);
		
		//Create a ButtonGroup to allow only one button to be selected(i.e if you select button A and then select button B, button A becomes unselected). 
		ButtonGroup subject=new ButtonGroup();
		subject.add(subjectarray[0]);
		subject.add(subjectarray[1]);
		subject.add(subjectarray[2]);
		
		//Sets the location,font, and font size for each radio button. 
		Engineer.setBounds(10, 60, 150, 20);
		Engineer.setFont(new Font("Hevetica",Font.BOLD,13));
		CS.setBounds(200, 60, 150, 20);
		CS.setFont(new Font("Hevetica",Font.BOLD,13));
		Math.setBounds(10, 100, 150, 20);
	    Math.setFont(new Font("Hevetica",Font.BOLD,13));
		
		//Sets the location,font and font size for the JLabel representing the question. 
		question5.setBounds(10,20,380,20);
		question5.setFont(new Font("Hevetica",Font.BOLD,16));
		question5.setOpaque(true);
		
		//added radio buttons and JLabel into the Panel. 
		add(question5);
		add(Engineer);
		add(CS);
		add(Math);
	}

	
	//getters and setters
	public JRadioButton getEngineer() {
		return Engineer;
	}

	public JRadioButton[] getSubjectarray() {
		return subjectarray;
	}

	public void setSubjectarray(JRadioButton[] subjectarray) {
		this.subjectarray = subjectarray;
	}

	public void setEngineer(JRadioButton engineer) {
		Engineer = engineer;
	}

	public JRadioButton getCS() {
		return CS;
	}

	public void setCS(JRadioButton cS) {
		CS = cS;
	}

	public JRadioButton getMath() {
		return Math;
	}

	public void setMath(JRadioButton math) {
		Math = math;
	}
	

}