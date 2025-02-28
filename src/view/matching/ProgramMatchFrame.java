package view.matching;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.information.MapPanel;

/*Author: Ashwin
 *This class is the frame that contains and displays the top three universities that fit the preferences of the user
 */

@SuppressWarnings("serial")
public class ProgramMatchFrame extends JFrame{
	
	//Creates JLabels
	private JLabel title=new JLabel("Your Matches: ");
	private UniPanel1 uniPanel1=new UniPanel1();
	private UniPanel3 uniPanel2=new UniPanel3();
	private UniPanel2 uniPanel3=new UniPanel2();
	private JButton goBackButton = new JButton("Go Back to Dashboard");
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/emptyBackground.png"));

	public ProgramMatchFrame() {
		setTitle("UniGO - Program Matches");
		setLayout(null);
		setSize(1800,1080);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Sets the Borders and adds the Panels.
		//Sets the location, font size, and font of the JLabel representing the Title. 
		title.setFont(new Font("Hevetica",Font.BOLD,19));
		title.setBounds(10,20,300,20);
		
		
		goBackButton.setBounds(this.getWidth()/2,900,190,60);
		add(goBackButton);
		
		backgroundImg.setBounds(0,0,1920,1080);
		
		uniPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
		uniPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
		uniPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
		add(title);
		add(uniPanel1);
		add(uniPanel2);
		add(uniPanel3);
		add(backgroundImg);
		
		setVisible(true);
		
		
	}

	//Getters and Setters
	public UniPanel1 getUnipanel1() {
		return uniPanel1;
	}


	public void setUnipanel1(UniPanel1 unipanel1) {
		this.uniPanel1 = unipanel1;
	}
	
	public JButton getGoBackButton() {
		return goBackButton;
	}

	public void setGoBackButton(JButton goBackButton) {
		this.goBackButton = goBackButton;
	}

}