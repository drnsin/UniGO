package view.userlogin;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Author: Darren
 * This class is the home panel of the application (first panel that shows up) that contains the buttons
 * to either login or sign up
 */
@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	
	private ImageIcon signupIcon = new ImageIcon("images/signupLabel.png");
	private ImageIcon loginIcon = new ImageIcon("images/loginLabel.png");
	private JLabel background;
	
	//Instance variables
	public static JButton signUp = new JButton("Sign Up");
	public static JButton login = new JButton("Login");
	
	public HomePanel() {
		
		setLayout(null);
		setBounds(0,0,1920,1080);
		
		background = new JLabel(new ImageIcon("images/UniGOLogo.png"));
		background.setBounds(0,0,1920,1080);
		
		addButtons();
		add(background);
		
	}
	
	//This method adds the buttons onto the panel
	public void addButtons() {
		
		signUp.setIcon(signupIcon);
		signUp.setContentAreaFilled(false);
		signUp.setBorderPainted(false);
		
		login.setIcon(loginIcon);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		
		signUp.setBounds(1040,460,400,400);
		login.setBounds(1440,460,400,400);
		
		add(signUp);
		add(login);
		
	}

}

