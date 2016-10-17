package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private eMajor Major;
	private double AvgGrade;
	
	public Course(String courseName, eMajor major) {
		CourseID = UUID.randomUUID();
		CourseName = courseName;
		Major = major;
	}
	
	
	public double getAvgGrade(){
    	double sum = 0;
    	int count = 0;
    	for (Section section : Section.getSectionlist()){
    		if (section.getCourseID() == this.CourseID){
    			for (Enrollment enrollment : Enrollment.getEnrollmentlist()){
    				if (enrollment.getSectionID() == section.getSectionID()){
    					sum+=enrollment.getGrade();
    					count++;
    				}
    			}
    		}
    	}
    	return AvgGrade = sum/count;
    }
	
	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public eMajor getMajor() {
		return Major;
	}

	public void setMajor(eMajor major) {
		Major = major;
	}

	
}
