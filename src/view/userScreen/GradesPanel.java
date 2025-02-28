package view.userScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradesPanel extends JPanel{
	JTextField courses[] = new JTextField[8];
	JTextField courseMarks[] = new JTextField[8];
	private JButton displayAverage = new JButton("Display Average");
	private JLabel showAverage = new JLabel();
	private JLabel backgroundImg = new JLabel(new ImageIcon("images/gradesPanel.png"));
	
	public GradesPanel(){
		setBounds(1080,60,740,869);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		setOpaque(false);
		
		for(int field=0;field<courses.length;field++){
			courses[field] = new JTextField();
			courses[field].setBounds(200,20+(field*86),150,40);
			
			courseMarks[field] = new JTextField();
			courseMarks[field].setBounds(430,20+(field*86),70,40);
			
			add(courses[field]);
			add(courseMarks[field]);
		}
		
		displayAverage.setBounds(430,800,120,30);
		showAverage.setBounds(240,800,150,30);
		showAverage.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		showAverage.setForeground(Color.WHITE);
		showAverage.setVisible(false);
		backgroundImg.setBounds(0,0,740,869);
		displayAverage.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			showAverage.setVisible(true);
			showAverage.setText(String.format("Course Average: %.2f",courseAverage()));
		}

		private double courseAverage() {
			
			double courseAverage=0;
			int counter=0;
			JLabel error = new JLabel("Error");
			for(int field=0;field<courses.length;field++){
			
				if(!courseMarks[field].getText().isEmpty()) {
					double mark = Double.parseDouble(courseMarks[field].getText());
					if(mark<0 || mark>100) {
						 
						 error.setBounds(showAverage.getX(),showAverage.getY()+50,50,30);
						 add(error);
						 
					}
					
					else {
						error.revalidate();
						courseAverage+=Double.parseDouble(courseMarks[field].getText());
						counter++;
					}	
					
				}
				
			}
			
			return (double)courseAverage/counter;
		}
		
		});
		
		add(displayAverage);
		add(showAverage);
		add(backgroundImg);
	}

}