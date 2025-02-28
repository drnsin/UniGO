package view.matching;


import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.AppController;

/*
 *Author: Ashwin
 *This class is the panel that displays the University program with the highest score
 */

public class UniPanel1 extends JPanel{
	
	//Creating JLabels
	private JLabel university=new JLabel("University:");
	private JLabel program=new JLabel("Program:");
	private JLabel link=new JLabel("Learn more:");
	
	private JLabel universityname1=new JLabel(AppController.programArray[0].getUniversity());
	private JLabel programname1=new JLabel(AppController.programArray[0].getProgramName());
	private JLabel linkname1=new JLabel(AppController.programArray[0].getURL());
	
	
	public UniPanel1() {
		setLayout(null);
		setBounds(200,90,800,200);
		
		//Sets the location,font,  
		university.setBounds(10,10,150,20);
		university.setFont(new Font("Hevetica",Font.BOLD,18));
		universityname1.setBounds(120,10,600,20);
		universityname1.setFont(new Font("Hevetica",Font.BOLD,15));
		
		program.setBounds(10,80,150,20);
		program.setFont(new Font("Hevetica",Font.BOLD,18));
		programname1.setBounds(100,80,600,20);
		programname1.setFont(new Font("Hevetica",Font.BOLD,15));
		
		link.setBounds(10,150,150,20);
		link.setFont(new Font("Hevetica",Font.BOLD,18));
		linkname1.setBounds(120,150,600,23);
		linkname1.setFont(new Font("Hevetica",Font.BOLD,15));
		
		//Adds the JLabels to the Panel
		add(university);
		add(universityname1);
		add(program);
		add(programname1);
		add(link);
		add(linkname1);
		
	}

	

	

}