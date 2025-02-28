package view.dashboard;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ComparisonPanel extends JPanel{
	
	public static JButton compare = new JButton(new ImageIcon("images/comparisonPanel.png"));

	public ComparisonPanel() {
		
		setLayout(null);
		setBounds(1000,380,880,290);
		setOpaque(false);
		
		compare.setBounds(0,0,880,290);
		compare.setContentAreaFilled(false);
		compare.setBorderPainted(false);
		
		add(compare);
		
	}
	
}
