package view.dashboard;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MatchPanel extends JPanel {
	
	public static JButton survey = new JButton(new ImageIcon("images/matchPanel.png"));
	
	public MatchPanel() { 
		
		setLayout(null);
		setBounds(1000,705,880,290);
		setOpaque(false);
		
		survey.setBounds(0,0,880,290);
		survey.setContentAreaFilled(false);
		survey.setBorderPainted(false);
		
		add(survey);
		
	}

}
