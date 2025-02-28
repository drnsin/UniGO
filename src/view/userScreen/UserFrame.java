package view.userScreen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class UserFrame extends JFrame {
	
	public static JButton toDashBoard = new JButton("Back");
	
	private LocationPanel locationPanel = new LocationPanel();
	private GradesPanel gradesPanel = new GradesPanel();
	private UserInfoPanel userInfoPanel = new UserInfoPanel();
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/emptyBackground.png"));
	
	public UserFrame() {
		
		setLayout(null);
		setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("UniGO - User Profile");
        
        backgroundImg.setBounds(0,0,1920,1080);
		toDashBoard.setBounds(10,10,80,30);
		
		add(toDashBoard);
        add(locationPanel);
        add(gradesPanel);
        add(userInfoPanel);
        add(backgroundImg);
        
        setVisible(true);
        
		
	}
	
}