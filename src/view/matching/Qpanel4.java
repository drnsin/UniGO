package view.matching;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 *Author: Ashwin
 *This class is the panel that contains and displays the fourth question of the survey(Do you prefer a part-time status?) 
 *and it's respective options.
 */

@SuppressWarnings("serial")
public class Qpanel4 extends JPanel{
	
	//Creating JLabel,RadioButtons, and an array to store the RadioButtons
	private JLabel question4=new JLabel("Do you prefer a part time status?");
	private JRadioButton yes=new JRadioButton("Yes");
	private JRadioButton no=new JRadioButton("No");
	private JRadioButton[] parttimearray={yes,no};
	
	public Qpanel4() {
		setLayout(null);
		setBounds(500,390,400,100);
		
		//Create a ButtonGroup to allow only one button to be selected(i.e if you select button A and then select button B, button A becomes unselected). 
		ButtonGroup parttime=new ButtonGroup();
		parttime.add(parttimearray[0]);
		parttime.add(parttimearray[1]);
		
		//Sets the location,font, and font size for each radio button. 
		yes.setBounds(10, 60, 150, 20);
		yes.setFont(new Font("Hevetica",Font.BOLD,13));
		no.setBounds(200, 60, 150, 20);
		no.setFont(new Font("Hevetica",Font.BOLD,13));
		
		question4.setBounds(10,20,380,20);
		question4.setFont(new Font("Hevetica",Font.BOLD,14));
		question4.setOpaque(true);
		
		//added radio buttons and JLabel into the Panel.
		add(question4);
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

	public JRadioButton[] getParttimearray() {
		return parttimearray;
	}

	public void setParttimearray(JRadioButton[] parttimearray) {
		this.parttimearray = parttimearray;
	}
	
	

}