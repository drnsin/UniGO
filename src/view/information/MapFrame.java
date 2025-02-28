package view.information;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.User;

/*
 * Author: Shreyas Peddi
 * This class is the base frame which has the map panel to display the map
 */
public class MapFrame extends JFrame{
	
	//Map panel consists of the map, slider and zoom in/out buttons
	private MapPanel mapPanel = new MapPanel();
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/mapFrame.png"));
	
	//Constructor to initialize the screen
	public MapFrame() {
		
		//Setup the screen
		setLayout(null);
		setSize(1680,1080);
		setTitle("UniGO - Find Your Uni");
		setResizable(false);
		setVisible(true);
		
		backgroundImg.setBounds(0,0,1680,1080);
		
		//Add the map panel
		add(mapPanel);	
		add(backgroundImg);
	}

	//GETTERS AND SETTERS
	public MapPanel getMapPanel() {
		return mapPanel;
	}

	public void setMapPanel(MapPanel mapPanel) {
		this.mapPanel = mapPanel;
	}
	
	
	
}
