package view.dashboard;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Author: Darren
 * This class is the frame that contains all of the panels for the dashboard
 */
@SuppressWarnings("serial")
public class DashboardFrame extends JFrame {
	
	private UserPanel userPanel = new UserPanel();
	private MapPanel mapPanel = new MapPanel();
	private ComparisonPanel comparisonPanel = new ComparisonPanel();
	private MatchPanel matchPanel = new MatchPanel();
	private JLabel background = new JLabel(new ImageIcon("images/DashboardBG.png"));
	
	public DashboardFrame() {
		
		//Setting up frame
		setLayout(null);
		setSize(1920,1080);
		setTitle("UniGO - Dashboard");
		setVisible(true);
		
		background.setBounds(0,0,1920,1080);
		
		add(userPanel);
		add(mapPanel);
		add(comparisonPanel);
		add(matchPanel);
		add(background);
		
	}

}
