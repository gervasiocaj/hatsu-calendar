package com.example.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.example.models.*;
import com.example.models.Entry.Repetition;

public class CalendarDAO {

	private final static Map<Integer, HatsuCalendar> calendars = new HashMap<Integer, HatsuCalendar>();
	private final static Map<Integer, Entry> entry = new HashMap<Integer, Entry>();
	
	public static Collection<HatsuCalendar> getAllCalendars() {
		return calendars.values();
	}

	public static HatsuCalendar createCalendar(String owner) {
		int cal = new Random().nextInt();
		return calendars.put(cal, new HatsuCalendar(owner));
	}
	
	public static Entry createEntry(String desc, Calendar start, Calendar end, Repetition rep, int repeats, String loc) {
		int randNum = new Random().nextInt();
		return entry.put(randNum, new Entry(desc,start,end,rep,repeats,loc));
		
	}
	
}
