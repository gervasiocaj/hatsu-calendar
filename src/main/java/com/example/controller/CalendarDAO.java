package com.example.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.example.models.*;

public class CalendarDAO {

	private final static Map<Integer, Calendar> calendars = new HashMap<Integer, Calendar>();

	public static Collection<Calendar> getAllCalendars() {
		return calendars.values();
	}

	public static void createCalendar(String owner) {
		calendars.put(new Random().nextInt(), new Calendar(owner));
	}
}
