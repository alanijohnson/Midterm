package com.cisc181.core;

import java.util.ArrayList;
import java.util.UUID;

public class Section{
	private UUID SemesterID;
	private UUID CourseID;
	private int RoomID;
	private UUID SectionID;
	private static ArrayList<Section> sectionlist = new ArrayList<Section>();
	
	public static ArrayList<Section> getSectionlist() {
		return sectionlist;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	
	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public Section(UUID semesterID, UUID courseID, int roomID) {
		SemesterID = semesterID;
		this.CourseID = courseID;
		RoomID = roomID;
		SectionID = UUID.randomUUID();
		sectionlist.add(this);
	}
}
