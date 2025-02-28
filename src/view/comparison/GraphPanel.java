package view.comparison; 

import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 

import controller.AppController;

import javax.swing.*; 

/*
 * Author: Gordon 
 * Purpose: Generates bar chart 
 * Requirements:- Download and extract zip at https://sourceforge.net/projects/jfreechart/
 * 		        - Add jar files and select all the files in jfreechart's library. 
 * Areas of concern: - The chart panel is added to the graph panel, likely causing issues 
 * 					 - User should enter information first then, this graph panel should be added to the screen. 
 */
public class GraphPanel extends JPanel{
	
	private String topicChoice; 
	private String University1;      
	private String University2;   
	private String Program1; 
	private String Program2;
	private double programRating1;
	private double programRating2;
	private	double tuition1; 
	private double tuition2; 
	private	int admissionAverage1; 
	private int admissionAverage2; 
	

	
	//Constructor 
	public GraphPanel() {
		//Set panel 
		setLayout(null);
		setBounds(50, 70, 800, 1020); //sets the size of the panel
		setOpaque(false);
		setVisible(true);
		
		//For testing purposes since it currently can't update the values. 
		topicChoice = "Program rating";
	    University1 = "University name 1";      
	    University2 = "University name 2";      
	    Program1 = "Program 1";
	    Program2 = "Program 2";
	    programRating1 = 5030; 
	    programRating2 = 8432; 

		createBarChart(); 	
    }
	
	//Creates the bar chart panel so that it can be added to the graph panel and displayed 
    private void createBarChart() {
    	//Create bar chart
    	JFreeChart barChart = ChartFactory.createBarChart(
		  Program1 + " vs " + Program2, //Chart's title 
          "Programs", //x-axis name 
          topicChoice, 
        createDataset(), PlotOrientation.VERTICAL,true, //sets legend visibility to true 
           											  true, false);
       
    	ChartPanel chartPanel = new ChartPanel(barChart);
    	add(chartPanel); //Adds the chart to the graph panel
    	chartPanel.setSize(700, 650); //Sets the size of the chart
    	
    	//Create data set 
    	CategoryDataset dataset = createDataset(); 
    }
   	
   	//Creates the data set so that information can be sent to the bar chart
	private CategoryDataset createDataset() {
	   
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

	   //Depending on the topic choice, it displays the matching set of data on the graph 
		   //Adds value(Y value / topic choice data, university name, X value / program name) 
		   //Note this is supposed to make bar chart look off center because dividing them into different categories 
	   
	   	if(topicChoice.equals("Program rating")) {
		   dataset.addValue(programRating1, University1, Program1);        
		   dataset.addValue(programRating2, University2, Program2);  
	   	}
	   
	   	else if(topicChoice.equals("Tuition")) {
	   		dataset.addValue(tuition1, University1, Program1);        
	   		dataset.addValue(tuition2, University2, Program2);  
	   	}
		   
	   	else if(topicChoice.equals("Admission Average")) {
	   		dataset.addValue(admissionAverage1, University1, Program1);        
	   		dataset.addValue(admissionAverage2, University2, Program2);  
	   	}
	   
	   return dataset; 
   	}
	
	//Getters and setters
	public String getTopicChoice() {
		return topicChoice;
	}

	public void setTopicChoice(String topicChoice) {
		this.topicChoice = topicChoice;
	}

	public String getUniversity1() {
		return University1;
	}

	public void setUniversity1(String university1) {
		University1 = university1;
	}

	public String getUniversity2() {
		return University2;
	}

	public void setUniversity2(String university2) {
		University2 = university2;
	}

	public String getProgram1() {
		return Program1;
	}

	public void setProgram1(String program1) {
		Program1 = program1;
	}

	public String getProgram2() {
		return Program2;
	}

	public void setProgram2(String program2) {
		Program2 = program2;
	}

	public double getProgramRating1() {
		return programRating1;
	}

	public void setProgramRating1(double programRating1) {
		this.programRating1 = programRating1;
	}

	public double getProgramRating2() {
		return programRating2;
	}

	public void setProgramRating2(double programRating2) {
		this.programRating2 = programRating2;
	}

	public double getTuition1() {
		return tuition1;
	}

	public void setTuition1(double tuition1) {
		this.tuition1 = tuition1;
	}

	public double getTuition2() {
		return tuition2;
	}

	public void setTuition2(double tuition2) {
		this.tuition2 = tuition2;
	}

	public int getAdmissionAverage1() {
		return admissionAverage1;
	}

	public void setAdmissionAverage1(int admissionAverage1) {
		this.admissionAverage1 = admissionAverage1;
	}

	public int getAdmissionAverage2() {
		return admissionAverage2;
	}

	public void setAdmissionAverage2(int admissionAverage2) {
		this.admissionAverage2 = admissionAverage2;
	}
	
  
 
}