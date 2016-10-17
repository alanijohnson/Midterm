package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	static ArrayList<Course> courselist = new ArrayList<Course>();
	static ArrayList<Semester> semesterlist = new ArrayList<Semester>();
	static ArrayList<Section> sectionlist = new ArrayList<Section>();
	static ArrayList<Student> studentlist = new ArrayList<Student>();
	static ArrayList<Enrollment> enrollmentlist = new ArrayList<Enrollment>();
	
	@BeforeClass
	public static void setup() throws ParseException, PersonException {
	DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
	
	//add 3 courses to courselist
	courselist.add(new Course("CISC181",eMajor.COMPSI));
	courselist.add(new Course("CISC220",eMajor.COMPSI));
	courselist.add(new Course("CISC275",eMajor.COMPSI));
	
	//add 2 semesters to semesterlist
	semesterlist.add(new Semester(df.parse("08/23/2016"),df.parse("12/23/2016")));
	semesterlist.add(new Semester(df.parse("02/01/2017"),df.parse("05/01/2017")));
	
	//add sections
	int room = 0;
	for (Semester semester : semesterlist){
		for (Course course : courselist){
			sectionlist.add(new Section(semester.getSemesterID(),course.getCourseID(),room++));
		}
	}
	
	//create 10 students
	for (int i=0; i<10; i++){
	studentlist.add(new Student("Alani","Jarai","Johnson",
			df.parse("12/21/1960"),
			eMajor.CHEM,
			"651 Appleton Drive",
			"(302)-971-8313",
			"alanij@edu.edu"));
	}
	
	//enrollment
	for (Student student: studentlist){
		for (Section section: sectionlist){
			enrollmentlist.add(new Enrollment(student.getStudentID(),section.getSectionID()));
		}
	}
	
	//set grade
	double i = 100.0;
	for (Enrollment enrollment:enrollmentlist){
		enrollment.SetGrade(i);
		i--;
	}
	
	}
	

	@Test
	public void test() {
		assertEquals(4.0,studentlist.get(0).getGradePoint(),0.001);
		assertEquals(3.833,studentlist.get(1).getGradePoint(),0.001);
		assertEquals(3,studentlist.get(2).getGradePoint(),0.001);
		assertEquals(2.5,studentlist.get(3).getGradePoint(),0.001);
		assertEquals(2,studentlist.get(4).getGradePoint(),0.001);
		assertEquals(1.167,studentlist.get(5).getGradePoint(),0.001);
		assertEquals(0.833,studentlist.get(6).getGradePoint(),0.001);
		assertEquals(0,studentlist.get(7).getGradePoint(),0.001);
		assertEquals(0,studentlist.get(8).getGradePoint(),0.001);
		assertEquals(0,studentlist.get(9).getGradePoint(),0.001);
		
		
		//setter testing for major
		assertEquals(eMajor.CHEM,studentlist.get(0).getMajor());
		studentlist.get(0).setMajor(eMajor.COMPSI);
		assertEquals(eMajor.COMPSI,studentlist.get(0).getMajor());
		
		//average grade testing		
		assertEquals(71.5,courselist.get(0).getAvgGrade(),0.001);
		assertEquals(70.5,courselist.get(1).getAvgGrade(),0.001);
		assertEquals(69.5,courselist.get(2).getAvgGrade(),0.001);
		
		
		
	}
}