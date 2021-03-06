package com.cisc181.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Student extends Person {

	private eMajor Major;
	private UUID StudentID;
	private double GradePoint;
	private ArrayList<Object[]> EnrolledCourses = new ArrayList<Object[]>();
	
	public eMajor getMajor ( )
    {
        return this.Major;
    }
	
    public void setMajor (eMajor Major)
    {
        this.Major = Major;    
    }
    
    public UUID getStudentID(){
    	return this.StudentID;
    }
    
    private void setGradePoint(){
    	double sum = 0;
    	int sectioncount = 0;
    	for (Enrollment enrollmentlist : Enrollment.getEnrollmentlist()){
    		if (enrollmentlist.getStudentID() == this.getStudentID()){
    			if (90<= enrollmentlist.getGrade()){
    				sum+= 4.0;
    			}
    			else if (80<=enrollmentlist.getGrade()){
    				sum+= 3.0;
    			}
    			else if (70<=enrollmentlist.getGrade()){
    				sum+= 2.0;
    			}
    			else if (60<=enrollmentlist.getGrade()){
    				sum+=1.0;
    			}
    			//sum+=enrollmentlist.getGrade();
    			sectioncount++;
    		}
    	}
    	GradePoint = sum/sectioncount;
    }
    
    public double getGradePoint(){
    	this.setGradePoint();
    	return GradePoint;
    }
    	
    
	public Student(String FirstName, String MiddleName, String LastName,Date DOB, eMajor Major,
			String Address, String Phone_number, String Email) throws PersonException
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email);
		this.StudentID = UUID.randomUUID();
		this.Major = Major;
		
	}
	
	
	@Override
	public void PrintName() {
		System.out.println(getLastName() + ","  + getFirstName() + ' ' + getMiddleName());
	}

	public void PrintName(boolean bnormal)
	{
		super.PrintName();
	}
}