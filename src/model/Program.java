package model;

import java.util.Arrays;

public class Program {

	private String university;
	private String category;
	private String programName;
	private String degree;
	private double programRating;
	private double tuition;
	private String location;
	private String admissionAverage;
	private boolean hasFullTimeStatus;
	private int overallScore=0;
	
	public int getOverallScore() {
		return overallScore;
	}
	public void setOverallScore(int overallScore) {
		this.overallScore = overallScore;
	}
	private Course[] courses = new Course[]{new Course("ENG4U"), new Course("MHF4U"),
			new Course("MCV4U"), new Course("SCH4U"), new Course("SPH4U"), new Course("ICS4U")};
	private String URL;
	
	private boolean hasSupplementaryApplication;
	private boolean hasCoOp;
	private int ratings[]=new int[6];
	
	//rating[0]=tuition
	//rating[1]=Co-op
	//rating[2]=supplementary app
	//rating[3]=part time
	//rating [4]=preferred field of study
	//rating[5]=program rating
	
	public int[] getRatings() {
		return ratings;
	}
	public void setRatings(int[] ratings) {
		this.ratings = ratings;
	}
	public Program() {
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public double getProgramRating() {
		return programRating;
	}
	public void setProgramRating(double programRating) {
		this.programRating = programRating;
	}
	public double getTuition() {
		return tuition;
	}
	public void setTuition(double tuition) {
		this.tuition = tuition;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAdmissionAverage() {
		return admissionAverage;
	}
	public void setAdmissionAverage(String admissionAverage) {
		this.admissionAverage = admissionAverage;
	}
	public boolean isHasFullTimeStatus() {
		return hasFullTimeStatus;
	}
	public void setHasFullTimeStatus(boolean hasFullTimeStatus) {
		this.hasFullTimeStatus = hasFullTimeStatus;
	}
	
	public boolean isHasSupplementaryApplication() {
		return hasSupplementaryApplication;
	}
	public void setHasSupplementaryApplication(boolean hasSupplementaryApplication) {
		this.hasSupplementaryApplication = hasSupplementaryApplication;
	}
	public boolean isHasCoOp() {
		return hasCoOp;
	}
	public void setHasCoOp(boolean hasCoOp) {
		this.hasCoOp = hasCoOp;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Program [university=" + university + ", category=" + category + ", programName=" + programName
				+ ", degree=" + degree + ", programRating=" + programRating + ", tuition=" + tuition + ", location="
				+ location + ", admissionAverage=" + admissionAverage + ", hasFullTimeStatus=" + hasFullTimeStatus
				+ ", courses=" + Arrays.toString(courses) + ", URL=" + URL + ", hasSupplementaryApplication="
				+ hasSupplementaryApplication + ", hasCoOp=" + hasCoOp + "]";
	}
	
	
	
}