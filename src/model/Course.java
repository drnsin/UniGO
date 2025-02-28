package model;

public class Course {
	
	private String courseCode;
	private String requirement;

	public Course(String name) {
		super();
		this.courseCode = name;
	}

	public String getName() {
		return courseCode;
	}

	public void setName(String name) {
		this.courseCode = name;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", requirement=" + requirement + "]";
	}
	
	

}
