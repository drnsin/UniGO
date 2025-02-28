package view.userlogin;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/*
 * Author: Darren
 * This class is the sign up panel that contains buttons and text fields for the user's information used
 * to create a new student profile
 */
@SuppressWarnings("serial")
public class SignupPanel extends JPanel {

	//Instance variables
	private JLabel signupBox;
	private JLabel background;
	public static JLabel fillFields;
	
	public static JButton loginButton = new JButton();
	public static JButton signupButton = new JButton();
	
	public static JTextField nameTextField;
	public static JTextField lastNameTextField;
	public static JTextField userNameTextField;
	public static JPasswordField passwordField;

	public SignupPanel() {
		
		setLayout(null);
		setBounds(0,0,1920,1080);
		
		addTextField();
		addButtons();
		
		fillFields = new JLabel();
		fillFields.setText("Fill out all fields/User Exists!");
		fillFields.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		fillFields.setForeground(Color.RED);
		fillFields.setBounds(840,700,400,40);
		fillFields.setVisible(false);
		add(fillFields);
		
		signupBox = new JLabel(new ImageIcon("images/SignupPanel.png"));
		signupBox.setBounds(0,0,1920,1080);
		add(signupBox);
		
		background = new JLabel(new ImageIcon("images/UniGOCentre.png"));
		background.setBounds(0,0,1920,1080);
		add(background);
		
	}
	
	//This method adds the buttons onto the panel
	public void addButtons() {
		
		loginButton.setBounds(1020,800,200,70);
		loginButton.setText("Login");
		
		signupButton.setBounds(770,800,200,70);
		signupButton.setText("Sign Up");
		
		add(loginButton);
		add(signupButton);
		
	}
	
	//This method adds the text fields onto the panel
	public void addTextField() {
		
		nameTextField = new JTextField();
		nameTextField.setBounds(900,405,380,40);
		nameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(nameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(900,485,380,40);
		lastNameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(lastNameTextField);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(900,565,380,40);
		userNameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(userNameTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(900,645,380,40);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		add(passwordField);
		
	}

}
