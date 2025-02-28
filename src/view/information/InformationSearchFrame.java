package view.information;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/*
 * Author: Shreyas Peddi
 * This is the screen which displays all the programs and additional information regarding each program.
 * It has a filtering functionality to filter based on category and university selected
 */
public class InformationSearchFrame extends JFrame{
	
	//Search panel which has filter options
	private SearchPanel searchPanel = new SearchPanel();
	
	//Scrollable program list panel to display programs based on the filters selected
	private ProgramListPanel programListPanel = new ProgramListPanel();
	
	//Constructor
	public InformationSearchFrame() {
		
		//Set the frame
		setLayout(null);
		setTitle("UniGO - Program Information");
		setSize(1920, 1080);
		add(searchPanel);
		
		//https://stackoverflow.com/questions/10346449/scrolling-a-jpanel
		//Add the panel to JScrollPane to make it "scrollable"
		JScrollPane scrollPane = new JScrollPane(programListPanel);
		
		//Set scrolling policies and bounds
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0,400,1920,660);
		add(scrollPane);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//GETTERS AND SETTERS
	public SearchPanel getSearchPanel() {
		return searchPanel;
	}

	public void setSearchPanel(SearchPanel searchPanel) {
		this.searchPanel = searchPanel;
	}

	public ProgramListPanel getProgramListPanel() {
		return programListPanel;
	}

	public void setProgramListPanel(ProgramListPanel programListPanel) {
		this.programListPanel = programListPanel;
	}
	
	
}
