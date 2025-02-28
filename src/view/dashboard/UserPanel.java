package view.dashboard;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import controller.AppController;

//This class
@SuppressWarnings("serial")
public class UserPanel extends JPanel {

	//Instance variables
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/userPanel.png"));
	private JLabel name = new JLabel(AppController.loggedInName);
	private JLabel lastName = new JLabel(AppController.loggedInLM);
	public static JButton checkProfile = new JButton("Check profile");
	public static JButton logOut = new JButton("Log Out");
	
	public UserPanel() {
		
		setLayout(null);
		setBounds(100,590,800,400);
		setBackground(Color.LIGHT_GRAY);
		setOpaque(false);
		
		name.setBounds(335,155,340,50);
		name.setFont((new Font("Times New Roman", Font.PLAIN, 50)));
		name.setForeground(Color.WHITE);
		
		lastName.setBounds(335,220,340,50);
		lastName.setFont((new Font("Times New Roman", Font.PLAIN, 50)));
		lastName.setForeground(Color.WHITE);
		
		
		checkProfile.setBounds(480,335,120,30);
		logOut.setBounds(615,335,120,30);
		
		backgroundImg.setBounds(0,0,800,400);
		
		add(name);
		add(lastName);
		
		add(checkProfile);
		add(logOut);
		
		add(backgroundImg);
		
	}

}
