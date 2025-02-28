package view.matching;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.AppController;

/*
 *Author: Ashwin 
 *This class is the panel that displays the University with the second highest score
 */

public class UniPanel2 extends JPanel{
	
	//Create JLabels
	private JLabel university=new JLabel("University:");
	private JLabel program=new JLabel("Program:");
	private JLabel link=new JLabel("Learn more:");
	
	private JLabel universityname2=new JLabel(AppController.programArray[1].getUniversity());
	private JLabel programname2=new JLabel(AppController.programArray[1].getProgramName());
	private JLabel linkname2=new JLabel(AppController.programArray[1].getURL());
	
	
	public UniPanel2() {
		setLayout(null);
		setBounds(200,300,800,200);
		
		//Set the location, font and font size for the JLabels
		university.setBounds(10,10,150,20);
		university.setFont(new Font("Hevetica",Font.BOLD,18));
		universityname2.setBounds(120,10,600,20);
		universityname2.setFont(new Font("Hevetica",Font.BOLD,15));
		
		program.setBounds(10,80,150,23);
		program.setFont(new Font("Hevetica",Font.BOLD,18));
		programname2.setBounds(100,80,600,23);
		programname2.setFont(new Font("Hevetica",Font.BOLD,15));
		
		link.setBounds(10,150,150,20);
		link.setFont(new Font("Hevetica",Font.BOLD,18));
		linkname2.setBounds(120,150,600,25);
		linkname2.setFont(new Font("Hevetica",Font.BOLD,14));
		
		
		//Adds the JLabels into the Panel
		add(university);
		add(universityname2);
		add(program);
		add(programname2);
		add(link);
		add(linkname2);
	}

	

	

}