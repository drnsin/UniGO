package view.userScreen;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import controller.AppController;

/*
 * Author: Darren
 * This class shows the user information in the user profile screen. This includes its username, name, and last name
 */
@SuppressWarnings("serial")
public class UserInfoPanel extends JPanel {

	//Instance variables
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/userInfoPanel.png"));
	private JLabel username = new JLabel(AppController.loggedInUN);
	private JLabel name = new JLabel(AppController.loggedInName);
	private JLabel lastName = new JLabel(AppController.loggedInLM);
	
	public UserInfoPanel() {
		
		setLayout(null);
		setBounds(70,60,960,390);
		setBackground(Color.LIGHT_GRAY);
		setOpaque(false);
		
		username.setBounds(335,45,340,50);
		username.setFont((new Font("Times New Roman", Font.PLAIN, 50)));
		username.setForeground(Color.CYAN);
		
		name.setBounds(335,105,340,80);
		name.setFont((new Font("Times New Roman", Font.PLAIN, 80)));
		name.setForeground(Color.WHITE);
		
		lastName.setBounds(335,220,340,80);
		lastName.setFont((new Font("Times New Roman", Font.PLAIN, 80)));
		lastName.setForeground(Color.WHITE);
		
		backgroundImg.setBounds(0,0,960,390);
		
		add(username);
		add(name);
		add(lastName);
		
		add(backgroundImg);
		
	}

}