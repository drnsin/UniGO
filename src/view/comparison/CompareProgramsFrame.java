package view.comparison;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Author: Gordon 
 * This class is a frame that contains all the comparison panels which are used for comparing 2 programs 
 * and their numerical information(Tuition, Program rating, and Admission average) 
 */
public class CompareProgramsFrame extends JFrame{
	
	private GraphPanel graphPanel = new GraphPanel();
	private OptionsPanel optionsPanel= new OptionsPanel();
	private JButton goBackButton;
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/emptyBackground.png"));
	
	//Constructor
	public CompareProgramsFrame() {
			
		//Set up the frame 
		setTitle("UniGO - Comparison");
		setLayout(null);
		setSize(1920, 1080);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Setup background
		backgroundImg.setBounds(0,0,1920,1080);
		
		//Setup back button
		goBackButton = new JButton(new ImageIcon("images/backIconWhite.png")); 
		goBackButton.setBounds(this.getX()+30,this.getY()+20,40,40);
		goBackButton.setOpaque(false);
		goBackButton.setContentAreaFilled(false);
		goBackButton.setBorderPainted(false);
		add(goBackButton);
		
		add(optionsPanel); 
		add(graphPanel); 
		add(backgroundImg);
		setVisible(true);

	}
	

	//Generate getters and setters
	public GraphPanel getGraphPanel() {
		return graphPanel;
	}

	public void setGraphPanel(GraphPanel graphPanel) {
		this.graphPanel = graphPanel;
	}

	public OptionsPanel getOptionsPanel() {
		return optionsPanel;
	}

	public void setOptionsPanel(OptionsPanel optionsPanel) {
		this.optionsPanel = optionsPanel;
	}
	
	public JButton getGoBackButton() {
		return goBackButton;
	}

	public void setGoBackButton(JButton goBackButton) {
		this.goBackButton = goBackButton;
	}
	
	
}