package view.matching;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/*Author: Ashwin
 *This class is the frame that contains and displays the survey for user to find University programs that best match their interests
 */

@SuppressWarnings("serial")
public class UserPreferencesFrame extends JFrame{	
	
	//Creates Panels
	private Qpanel1 panel1=new Qpanel1();
	private Qpanel2 panel2=new Qpanel2();
	private Qpanel3 panel3=new Qpanel3();
	private Qpanel4 panel4=new Qpanel4();
	private Qpanel5 panel5=new Qpanel5();
	private JButton match=new JButton("Match");
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/emptyBackground.png"));
	
	public UserPreferencesFrame(){
		setTitle("UniGO - User Preferences");
		setLayout(null);
		setSize(1920,1080);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Sets the border style and colours of each Panel and add them into the Frame.
		//Sets the location of the Match button.
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panel1);
		
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panel2);
		
		panel3.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panel3);
		
		panel4.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panel4);
		
		panel5.setBorder(BorderFactory.createLineBorder(Color.black));
		add(panel5);
		
		match.setBounds(800,650,100,50);
		
		backgroundImg.setBounds(0,0,1920,1080);
		
		add(match);
		add(backgroundImg);
		setVisible(true);
	}

	//getters and setters
	public Qpanel1 getPanel1() {
		return panel1;
	}


	public void setPanel1(Qpanel1 panel1) {
		this.panel1 = panel1;
	}


	public Qpanel2 getPanel2() {
		return panel2;
	}


	public void setPanel2(Qpanel2 panel2) {
		this.panel2 = panel2;
	}


	public Qpanel3 getPanel3() {
		return panel3;
	}


	public void setPanel3(Qpanel3 panel3) {
		this.panel3 = panel3;
	}


	public Qpanel4 getPanel4() {
		return panel4;
	}


	public void setPanel4(Qpanel4 panel4) {
		this.panel4 = panel4;
	}


	public Qpanel5 getPanel5() {
		return panel5;
	}


	public void setPanel5(Qpanel5 panel5) {
		this.panel5 = panel5;
	}


	public JButton getMatch() {
		return match;
	}


	public void setMatch(JButton match) {
		this.match = match;
	}

	

	
	
	
	
	

}