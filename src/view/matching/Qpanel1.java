package view.matching;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 *Author: Ashwin
 *This is the panel that contains and displays the 1st question of the survey(What is your preferred tuition range?)
 *and the respective options. 
 */

public class Qpanel1 extends JPanel{
	
	//Creating JLabel,RadioButtons, and an array to store the RadioButtons
	private JLabel question1 = new JLabel("What is your preferred tuition range?");
	private JRadioButton range1=new JRadioButton("$5,000-$10,000");
	private JRadioButton range2=new JRadioButton("$10,000-$15,000");
	private JRadioButton range3=new JRadioButton("$15,000+");
	private JRadioButton rangearray[]= {range1,range2,range3};
	
	public Qpanel1(){
		
		setLayout(null);
		setBounds(500,10,400,150);
		
		//Create a ButtonGroup to allow only one button to be selected(i.e if you select button A and then select button B, button A becomes unselected)
		ButtonGroup ranges=new ButtonGroup();
		ranges.add(rangearray[0]);
		ranges.add(rangearray[1]);
		ranges.add(rangearray[2]);
		
		//Sets the location,font, and font size for each radio button. 
		range1.setBounds(10, 60, 150, 20);
		range1.setFont(new Font("Hevetica",Font.BOLD,13));
		range2.setBounds(200, 60, 150, 20);
		range2.setFont(new Font("Hevetica",Font.BOLD,13));
		range3.setBounds(10, 100, 150, 20);
		range3.setFont(new Font("Hevetica",Font.BOLD,13));
		
		
		question1.setBounds(10,20,300,20);
		question1.setFont(new Font("Hevetica",Font.BOLD,16));
		question1.setOpaque(true);
		
		//added radio buttons and JLabel into the Panel.
		add(question1);
		add(range1);
		add(range2);
		add(range3);
		
		
		
		
	}
	
	
//getters and setters
	public JRadioButton getRange2() {
		return range2;
	}



	public void setRange2(JRadioButton range2) {
		this.range2 = range2;
	}



	public JRadioButton getRange3() {
		return range3;
	}



	public void setRange3(JRadioButton range3) {
		this.range3 = range3;
	}



	public JRadioButton[] getRangearray() {
		return rangearray;
	}



	public void setRangearray(JRadioButton[] rangearray) {
		this.rangearray = rangearray;
	}



	public JRadioButton getRange1() {
		return range1;
	}

	public void setRange1(JRadioButton range1) {
		this.range1 = range1;
	}

	public JLabel getQuestion() {
		return question1;
	}

	public void setQuestion(JLabel question) {
		this.question1 = question;
	}
	
	

}