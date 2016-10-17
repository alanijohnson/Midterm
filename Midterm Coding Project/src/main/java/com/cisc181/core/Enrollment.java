package com.cisc181.core;

import java.util.ArrayList;
import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	private static ArrayList<Enrollment> enrollmentlist = new ArrayList<Enrollment>();
	
	private Enrollment() {
	}
	
	public Enrollment(UUID StudentID, UUID SectionID){
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.EnrollmentID = UUID.randomUUID();
		enrollmentlist.add(this);
	}
	
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}

	public double getGrade() {
		return Grade;
	}

	public void setGrade(double grade) {
		Grade = grade;
	}

	public static ArrayList<Enrollment> getEnrollmentlist() {
		return enrollmentlist;
	}


	void SetGrade(double Grade){
		this.Grade = Grade;
	}
	
	double GetGrade(){
		return this.Grade;
	}
	
}
