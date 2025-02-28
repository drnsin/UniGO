package view.dashboard;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	
	public static JButton lookAtPrograms = new JButton(new ImageIcon("images/mapPanel.png"));
	
	public MapPanel() {
		setLayout(null);
		setBounds(1000,55,880,290);
		setOpaque(false);
		
		lookAtPrograms.setBounds(0,0,880,290);
		lookAtPrograms.setContentAreaFilled(false);
		lookAtPrograms.setBorderPainted(false);
		
		add(lookAtPrograms);
		
	}

}
