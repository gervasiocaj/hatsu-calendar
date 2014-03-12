package com.example.models;

import java.util.Calendar;

public class Entry {
	
	private String description;
	private Calendar dateStart, dateEnd;
	private Repetition repetition;
	private int repeats, eventId;
	private String location;
	
	public enum Repetition {
		NONE, MONTHLY;
	}
	
	public Entry(int id, String desc, Calendar start, Calendar end, Repetition rep, int repeats, String loc) {
		this.eventId = id;
		this.description = desc;
		this.dateStart = start;
		this.dateEnd = end;
		this.repetition = rep;
		this.repeats = repeats;
		this.location = loc;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDateStart() {
		return dateStart;
	}

	public void setDateStart(Calendar dateStart) {
		this.dateStart = dateStart;
	}

	public Calendar getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Calendar dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Repetition getRepetition() {
		return repetition;
	}

	public void setRepetition(Repetition repetition) {
		this.repetition = repetition;
	}

	public int getRepeats() {
		return repeats;
	}

	public void setRepeats(int repeats) {
		this.repeats = repeats;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}

