package view.information;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import org.json.*;

import controller.AppController;
import model.User;

/*
 * Author: Shreyas Peddi
 * This panel has the map, slider to change the radius of displaying universities in that range.
 * Google Static Maps API is called using an API key, which provides static pictures of a map with 
 * markers displayed on it at a specific location and a specific zoom level
 * Maps Static API: The Maps Static API service creates a map based on URL parameters sent through a standard HTTP request and returns the map as an image
 * Google Geocoding API: Geocoding is the process of converting addresses (like "1600 Amphitheatre Parkway, Mountain View, CA") into geographic coordinates 
 * (like latitude 37.423021 and longitude -122.083739), which you can use to place markers on a map
 */
public class MapPanel extends JPanel{
	
	//Fields
	private JButton backButton = new JButton(new ImageIcon("images/backIconWhite.png")); //Back button to return to information screen
	private JLabel mapLabel = new JLabel();	//Map label
	private JSlider radiusSlider; //Slider
	private JButton confirmRadius = new JButton("Change radius"); //Confirm button
	private JButton zoomIn = new JButton("Zoom In"); //Button to zoom in the map
	private JButton zoomOut = new JButton("Zoom Out"); //Button to zoom out the map
	private JButton mapType = new JButton("Change map type"); //Button to change the map type
	private User user; //User object
	
	//List of map types based on Google Static Maps API convention
	private String[] mapTypeList = new String[] {"roadmap","satellite","terrain","hybrid"};
	
	//Keep track of what map type to display when it should be changed
	public static int mapTypeListCounter=0;
	
	//API Key needed to call Google static Maps API. 
	private String API_KEY="AIzaSyD6ojuCDd07VoBpZmgA3rJ6gHsfLkXKzRk";
	
	//JSON object used to parse json response from API
	private JSONObject jsonObj;
	
	//Initial map location
	private String initMap = "Orillia,+ON";
	
	//Initial zoom level
	private int zoomLevel=6;
	
	//User address
	private String userAddress;
	
	//Constructor - Sets up the MAP GUI panel
	public MapPanel() {
		
		//Setup the Map panel
		setLayout(null);
		setBounds(0,0,1680,1080);
		setOpaque(false);
		
		//Setup components
		setUpBackButton();
		setUpSlider();
		setUpZoomButtons();
		setUpMapType();
		
		//Add components to panel
		add(backButton);
		add(zoomIn);
		add(zoomOut);
		add(mapType);
	}

	//GETTERS AND SETTERS
	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	
	public JLabel getMapLabel() {
		return mapLabel;
	}

	public void setMapLabel(JLabel mapLabel) {
		this.mapLabel = mapLabel;
	}

	public JSlider getRadiusSlider() {
		return radiusSlider;
	}

	public void setRadiusSlider(JSlider radiusSlider) {
		this.radiusSlider = radiusSlider;
	}
	
	public JButton getConfirmRadius() {
		return confirmRadius;
	}

	public void setConfirmRadius(JButton confirmRadius) {
		this.confirmRadius = confirmRadius;
	}
	
	//This method updates the static map image any time the slider is changed.
	public void updateMap(int selectedRadius) {
		System.out.println("Selected radius: "+selectedRadius);
		
		//Loop through the map and display updated university locations
		for(int uni=0;uni<AppController.universities.length;uni++) {
			
			//Checks to see if the university is within the selected radius
			if(distance(AppController.universities[uni].getLat(),AppController.universities[uni].getLongt(),user.getLat(),user.getLongt())<selectedRadius) 
				AppController.universities[uni].setVisibleOnMap(true);
			
			else
				AppController.universities[uni].setVisibleOnMap(false);
		}
		
		//Get the marker parameter information
		String markerParameter = getUniversityMarkerInfo(userAddress);
		
		//Remove the current map image
		mapLabel.revalidate();
		
		try {
			
			//Call Google Static Maps API
			Image googleMapsImage = ImageIO.read(new URL("http://maps.googleapis.com/maps/api/staticmap?center="+initMap+",5&zoom="+zoomLevel+"&size=640x440&scale=2&"+markerParameter+"&visual_refresh=true&maptype="+mapTypeList[mapTypeListCounter]+"&key="+API_KEY));
			
			//Set the icon based on the updated image
			mapLabel.setIcon(new ImageIcon(googleMapsImage));
			repaint();
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Calculates the distance between two points on a map based on latitude and longitude
	//geeksforgeeks.org/program-distance-two-points-earth/
	public static double distance(double lat1,double lon1,double lat2, double lon2){
		
		// The math module contains a function named toRadians which converts from degrees to radians.
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		
		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2)
		        + Math.cos(lat1) * Math.cos(lat2)
		        * Math.pow(Math.sin(dlon / 2),2);
		    
		double c = 2 * Math.asin(Math.sqrt(a));
		
		// Radius of earth in kilometers. Use 3956
		// for miles
		double r = 6371;
		
		// calculate the result
		return(c * r);
	}

	/*
	 * This method loads up the initial MAP label based on the user's location. MAP static API is 
	 * called to get an image which is used to add it back to the GUI label
	 */
	
	public void loadUpMap(User user) {
		
		//Setup the map label
		mapLabel.setBounds(100,100,1480,880);
		
		//Dynamically get user data
		 this.user=user;
		 String streetNum=user.getStreetNum();
		 String streetName = user.getStreetName();
		 String city = user.getCity();
		 
		 //MAPS PARAMETER CONVENTION: Replace all spaces with "+" signs
		 streetNum = streetNum.replace(' ', '+');
		 streetName = streetName.replace(' ', '+');
		 city = city.replace(' ', '+');
		
		//Combine the user address
		userAddress = streetNum+"+"+streetName+"+"+city+"+ON";
		
		System.out.println("Loading Up:"+userAddress);
		//Get marker information
		String markerParameter = getMarkerInfo(userAddress);
		
		//This method converts human readable address to latitude and longitude using GEOCODING API
		getJSONGeocode(userAddress);
		try {
			
			//Call Google Static Maps API
			Image googleMapsImage = ImageIO.read(new URL("http://maps.googleapis.com/maps/api/staticmap?center="+initMap+",5&zoom="+zoomLevel+"&size=640x440&scale=2&"+markerParameter+"&visual_refresh=true&key="+API_KEY));
			mapLabel.setIcon(new ImageIcon(googleMapsImage));
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		//Add the updated label to screen
		add(mapLabel);
		
	}
	
	//Marker information (userAddress) is used to send a part of the API parameter called "marker"
	private String getMarkerInfo(String userAddress) {
		
		//Setup user marker parameter
		getUserMarkerInfo(userAddress);
		
		//Return the university specific marker parameters
		return getUniversityMarkerInfo(user.getLat()+","+user.getLongt());
	
		
	}

	//Marker information (user address) is used to send a part of the API parameter called "marker"
	private String getUserMarkerInfo(String userAddress) {
		
		//Get latitude and longitude using geocoding API
		getJSONGeocode(userAddress);
		
		//Set the user latitude and longitude to use it for future purposes
		user.setLat(getLat().doubleValue());
		user.setLongt(getLongt().doubleValue());
		
		//Return the address
		return user.getLat()+","+user.getLongt();
	}

	//This method returns updated marker parameter which is sent as a request to MAPS static API
		private String getUniversityMarkerInfo(String userAddress) {
			
			//Specify the size and color
			String uniMarkerInfo = "&markers=size:tiny%7Ccolor:red%7Clabel:U";
			String userMarkerInfo=userAddress;
			
			
			
			//Loop through all universities and display the ones which are within the radius
			for(int uni=0;uni<AppController.universities.length;uni++) {
				if(AppController.universities[uni].isVisibleOnMap())
					
					//Add a marker parameter if the university is within the radius
					uniMarkerInfo=uniMarkerInfo+"%7C"+AppController.universities[uni].getLat()+","+AppController.universities[uni].getLongt();
			}
			
			//Return back the marker information
			return "markers=color:blue%7Clabel:U%7C"+userMarkerInfo+uniMarkerInfo;
		}
	
	//This method reads JSON object from the url (call to maps API which returns a JSON object with
	//latitude and longitude
	private void getJSONGeocode(String address) {
		
		try {
			//Call Google Geocoding Maps API. The response is then converted and parsed to a json object
			jsonObj = readJsonFromUrl("https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key=AIzaSyD6ojuCDd07VoBpZmgA3rJ6gHsfLkXKzRk");
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
		//This methods reads JSON object from a URL
		public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		   
			//Open the URL
			InputStream is = new URL(url).openStream();
		    try {
		    	
		    //Use buffered reader object to read data
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      
		      //Convert to string
		      String jsonText = readAll(rd);
		      
		      //Return a parsed JSON object
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    } finally {
		    	
		    	//Close the input
		      is.close();
		    }
		  }

		//https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
		//This method parses JSON object
		private static String readAll(Reader rd) throws IOException {
		    
			//Convert to string
			StringBuilder sb = new StringBuilder();
		    int cp;
		    
		    //Loop through until there is text
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    //Return the converted string
		    return sb.toString();
		  }
	
	
	//This method returns the longitude given the json object. External library used
	private BigDecimal getLongt() {
		return (BigDecimal) jsonObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lng");
	}

	//This method returns the latitude given the json object. External library used
	private BigDecimal getLat() {
		return (BigDecimal) jsonObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lat");
	}
	
	//Sets up the Slider GUI - bounds, tick spacing, maximum and initial radius(distance)
	private void setUpSlider() {
		
		//https://www.javatpoint.com/java-jslider
		//Setup the JSlider - minor tick spacing, major tick spacing, paint ticks, paint labels
		radiusSlider = new JSlider(JSlider.HORIZONTAL, 0, 500, 500);
		radiusSlider.setMinorTickSpacing(20);  
		radiusSlider.setMajorTickSpacing(100);
		radiusSlider.setPaintTicks(true);  
		radiusSlider.setPaintLabels(true);
		radiusSlider.setBounds(1400,35,250,50);
		add(radiusSlider);
		
		//Setup the confirm button
		confirmRadius.setBounds(radiusSlider.getX()+20,radiusSlider.getY()+60,120,25);
		add(confirmRadius);
		
	}
	
	//Sets up the back button which is used to go back to the information screen
	private void setUpBackButton() {
		backButton.setBounds(this.getX()+30,this.getY()+30,40,40);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
	}

	//This method sets up the zoom buttons and adds functionality to each button
	private void setUpZoomButtons() {
		
		//Set Bounds
		zoomIn.setBounds(radiusSlider.getX(),radiusSlider.getY()+120,100,25);
		zoomOut.setBounds(radiusSlider.getX()+120,radiusSlider.getY()+120,100,25);
		
		//Add functionality when the zoom in button is clicked
		zoomIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				//Increase zoom level
				zoomLevel+=1;
				
				//Get the marker parameter information
				String markerParameter = getUniversityMarkerInfo(userAddress);
				
				//Remove the current map image
				mapLabel.revalidate();
				
				try {
					
					//Call Google Static Maps API
					Image googleMapsImage = ImageIO.read(new URL("http://maps.googleapis.com/maps/api/staticmap?center="+initMap+",5&zoom="+zoomLevel+"&size=640x440&scale=2&"+markerParameter+"&visual_refresh=true&key="+API_KEY));
					
					//Set the icon based on the updated image
					mapLabel.setIcon(new ImageIcon(googleMapsImage));
					
					//Update the screen
					repaint();
					
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		//Add functionality when the zoom out button is clicked
		zoomOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				//Decrease zoom level
				zoomLevel-=1;
				
				//Get the marker parameter information
				String markerParameter = getUniversityMarkerInfo(userAddress);
				
				//Remove the current map image
				mapLabel.revalidate();
				
				try {
					
					//Call Google Static Maps API
					Image googleMapsImage = ImageIO.read(new URL("http://maps.googleapis.com/maps/api/staticmap?center="+initMap+",5&zoom="+zoomLevel+"&size=640x440&scale=2&"+markerParameter+"&visual_refresh=true&key="+API_KEY));
					
					//Set the icon based on the updated image
					mapLabel.setIcon(new ImageIcon(googleMapsImage));
					repaint();
					
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	//This method updates map type - roadmap,satellite,terrain, hybrid
	private void setUpMapType() {
		
		//Set size and location
		mapType.setBounds(radiusSlider.getX(),radiusSlider.getY()+160,150,25);
		
		//Add functionality to the button
		mapType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				//If the button is cliked and all the map types are explored, repeat the map type
				if(mapTypeListCounter==3) 
					mapTypeListCounter=0;
				
				//Display the next map type
				else
					mapTypeListCounter++;
				
				//Get the marker parameter information
				String markerParameter = getUniversityMarkerInfo(userAddress);
				
				//Remove the current map image
				mapLabel.revalidate();
				
				try {
					
					//Call Google Static Maps API
					Image googleMapsImage = ImageIO.read(new URL("http://maps.googleapis.com/maps/api/staticmap?center="+initMap+",5&zoom="+zoomLevel+"&size=640x440&scale=2&"+markerParameter+"&visual_refresh=true&maptype="+mapTypeList[mapTypeListCounter]+"&key="+API_KEY));
					
					//Set the icon based on the updated image
					mapLabel.setIcon(new ImageIcon(googleMapsImage));
					repaint();
					
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
}	//End of class