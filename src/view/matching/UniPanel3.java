package view.matching;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.AppController;

/*
 *Author: Ashwin 
 *This class is the panel that displays the University with the third highest score
 */

public class UniPanel3 extends JPanel{
	
	//Create JLabels
	private JLabel university=new JLabel("University:");//JLabel for indicating where the University name is located on the panel
	private JLabel program=new JLabel("Program:");//JLabel for indicating where the program name is located on the panel
	private JLabel link=new JLabel("Learn more:");//JLabel for indicating where the link to the program website is located on the panel
	
	
	private JLabel universityname3=new JLabel(AppController.programArray[2].getUniversity());//JLabel for containing and displaying the university name
	private JLabel programname3=new JLabel(AppController.programArray[2].getProgramName());//JLabel for containing and displaying the program name
	private JLabel linkname3=new JLabel(AppController.programArray[2].getURL());//JLabel for containing and displaying the link to the program website. 
	
	
	public UniPanel3() {
		setLayout(null);
		setBounds(200,510,800,200);
		
		//Sets the location, font, and font size for the JLabels
		university.setBounds(10,10,150,20);
		university.setFont(new Font("Hevetica",Font.BOLD,18));
		universityname3.setBounds(120,10,600,20);
		universityname3.setFont(new Font("Hevetica",Font.BOLD,15));
		
		program.setBounds(10,80,150,20);
		program.setFont(new Font("Hevetica",Font.BOLD,18));
		programname3.setBounds(100,80,600,20);
		programname3.setFont(new Font("Hevetica",Font.BOLD,15));
		
		link.setBounds(10,150,150,20);
		link.setFont(new Font("Hevetica",Font.BOLD,18));
		linkname3.setBounds(120,150,600,20);
		linkname3.setFont(new Font("Hevetica",Font.BOLD,14));
		
		//Adds JLabels into the Panel
		add(university);
		add(universityname3);
		add(program);
		add(programname3);
		add(link);
		add(linkname3);
	}

	

	

}