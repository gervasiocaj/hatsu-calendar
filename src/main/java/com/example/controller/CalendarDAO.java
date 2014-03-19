package com.example.controller;

import java.util.*;

import com.example.models.*;

public class CalendarDAO {

	private final static Map<Integer, HatsuCalendar> calendars = new HashMap<Integer, HatsuCalendar>();
	//private final static Map<Integer, Entry> entry = new HashMap<Integer, Entry>();
	
	public static Map<Integer, HatsuCalendar> getAllCalendars() {
		return calendars;
	}

	public static HatsuCalendar createCalendar(String owner) {
		int cal = new Random().nextInt();
		return calendars.put(cal, new HatsuCalendar(owner));
	}
	
	public static Entry createEntry(int ownerid, Entry e) {
		HatsuCalendar cal = getCalendar(ownerid);
		if (cal == null)
			return null;
		
		return cal.addEntry(e);
	}
	
	public static HatsuCalendar getCalendar(int id) {
		return calendars.get(id);
	}
	
	public static Entry[] getEntries(int id) {
		return calendars.get(id).getEntries();
	}
	
}
