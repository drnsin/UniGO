package model;

import java.math.BigDecimal;

/*
 * Model Class for University type object which has university name and location fields. 
 * This will primarily be used in displaying the location of universities on the map
 */
public class University {
	private String name;
	private double lat;
	private double longt;
	private boolean visibleOnMap=true;
	
	//Constructor
	public University(String name, String location) {
		super();
		this.name = name;
	}
	
	public University() {
		
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLongt() {
		return longt;
	}

	public void setLongt(double longt) {
		this.longt = longt;
	}

	public boolean isVisibleOnMap() {
		return visibleOnMap;
	}

	public void setVisibleOnMap(boolean visibleOnMap) {
		this.visibleOnMap = visibleOnMap;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", lat=" + lat + ", longt=" + longt
				+ ", visibleOnMap=" + visibleOnMap + "]";
	}
	
	
	
	

}
