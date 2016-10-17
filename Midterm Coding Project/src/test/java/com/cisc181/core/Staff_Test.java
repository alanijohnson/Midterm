package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	public static ArrayList<Staff> staff1 = new ArrayList<Staff>();
	@BeforeClass
	public static void setup() throws ParseException, PersonException {
		ArrayList<Staff> stafflist = new ArrayList<Staff>();
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Staff erma =new Staff("Erma", "Debra", "Paras",
				df.parse("08/11/1975"), 
				"3103 Green Street, Nashville, TN 37207", 
				"(615)-516-2335",
				"edparas@cisc.edu", 
				"Mon5pm", 
				6, 
				60000.0, 
				df.parse("10/12/2000"), 
				eTitle.MRS);
		stafflist.add(erma);
		
		stafflist.add(new Staff("Mattie", "K", "Raleigh",
				df.parse("08/11/1990"), 
				"3103 Green Street, Nashville, TN 31000", 
				"(615)-516-2115",
				"mkr@cisc.edu", 
				"Mon6pm", 
				6, 
				70000.0, 
				df.parse("10/12/2000"), 
				eTitle.MS));
		
		stafflist.add(new Staff("Gary", "D", "James",
				df.parse("08/11/1991"), 
				"3103 Green Street, Nashville, TN 37207", 
				"(615)-516-2335",
				"edparas@cisc.edu", 
				"Mon5pm", 
				6, 
				90000.0, 
				df.parse("10/12/2000"), 
				eTitle.MR));
				
		stafflist.add(new Staff("Peter", "K", "Avila",
				df.parse("08/11/1975"), 
				"3103 Purple Street, Nashville, TN 37207", 
				"(100)-516-2335",
				"pka@cisc.edu", 
				"Mon5pm", 
				6, 
				100000.0, 
				df.parse("10/12/1993"), 
				eTitle.MR));
		
		stafflist.add(new Staff("Bonnie", "Debra", "Sangster",
				df.parse("08/14/1975"), 
				"3103 Green Street, Nashville, TN 37207", 
				"(615)-512-2335",
				"bds@cisc.edu", 
				"Mon5pm", 
				6, 
				200000.0, 
				df.parse("11/12/2000"), 
				eTitle.MRS));
		
		staff1 = stafflist;
	}
	
	@Test
	public void test() throws PersonException, ParseException {
	
		int staffcount = 0;
		double salarysum = 0;
		for (Staff employee: staff1){
			staffcount++;
			salarysum+=employee.getSalary();
		}
		assertEquals((salarysum/staffcount),104000.0,.000001);
	}	
	
	@Test(expected= PersonException.class)
	public void test_InvalidDOB() throws PersonException, ParseException{
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Staff erma =new Staff("Erma", "Debra", "Paras",
				df.parse("08/11/0075"), 
				"3103 Green Street, Nashville, TN 37207", 
				"(615)-516-2335",
				"edparas@cisc.edu", 
				"Mon5pm", 
				6, 
				60000.0, 
				df.parse("10/12/2000"), 
				eTitle.MRS);
	}
	
	@Test(expected= PersonException.class)
	public void test_InvalidPhoneNumber() throws PersonException, ParseException{
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Staff erma =new Staff("Erma", "Debra", "Paras",
				df.parse("08/11/1975"), 
				"3103 Green Street, Nashville, TN 37207", 
				"615-516-2335",
				"edparas@cisc.edu", 
				"Mon5pm", 
				6, 
				60000.0, 
				df.parse("10/12/2000"), 
				eTitle.MRS);
	}

}
