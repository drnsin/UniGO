package view.matching;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 *Author: Ashwin
 *This class is the panel that contains and displays the second question of the survey(Do you prefer Co-OP?) 
 *and it's respective options
 */

@SuppressWarnings("serial")
public class Qpanel2 extends JPanel{
	
	//Creating JLabel,RadioButtons, and an array to store the RadioButtons
	private JLabel question2=new JLabel("Do you prefer Co-op?");
	private JRadioButton yes=new JRadioButton("Yes");
	private JRadioButton no=new JRadioButton("No");
	private JRadioButton[] cooparray= {yes,no};
	
	
	public Qpanel2() {
		setLayout(null);
		setBounds(500,170,400,100);
		
		//Create a ButtonGroup to allow only one button to be selected(i.e if you select button A and then select button B, button A becomes unselected). 
		ButtonGroup coop=new ButtonGroup();
		coop.add(cooparray[0]);
		coop.add(cooparray[1]);
		
		//Sets the location,font, and font size for each radio button. 
		yes.setBounds(10, 60, 150, 20);
		yes.setFont(new Font("Hevetica",Font.BOLD,13));
		no.setBounds(200, 60, 150, 20);
		no.setFont(new Font("Hevetica",Font.BOLD,13));
		
		
		question2.setBounds(10,20,300,20);
		question2.setFont(new Font("Hevetica",Font.BOLD,16));
		question2.setOpaque(true);
		
		//added radio buttons and JLabel into the Panel.
		add(question2);
		add(yes);
		add(no);
	}

//getters and setters
	public JRadioButton getYes() {
		return yes;
	}


	public void setYes(JRadioButton yes) {
		this.yes = yes;
	}


	public JRadioButton getNo() {
		return no;
	}


	public void setNo(JRadioButton no) {
		this.no = no;
	}


	public JRadioButton[] getCooparray() {
		return cooparray;
	}


	public void setCooparray(JRadioButton[] cooparray) {
		this.cooparray = cooparray;
	}
	
	
	

}