package com.example.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.example.models.*;

public class CalendarDAO {

	private final static Map<Integer, HatsuCalendar> calendars = new HashMap<Integer, HatsuCalendar>();
	
	public static Collection<HatsuCalendar> getAllCalendars() {
		return calendars.values();
	}

	public static HatsuCalendar createCalendar(String owner) {
		int cal = new Random().nextInt();
		return calendars.put(cal, new HatsuCalendar(owner));
	}
}
