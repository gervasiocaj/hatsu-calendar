package com.example.models;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HatsuCalendar {
	
	private String owner;
	private Map<Integer, Entry> entries;
	
	public HatsuCalendar(String owner) {
		this.owner = owner;
		this.entries = new HashMap<Integer, Entry>();
	}

	public String getOwner() {
		return owner;
	}
	
	public Entry[] getEntries() {
		return entries.values().toArray(new Entry[entries.size()]);
	}
	
	public Entry addEntry(Entry e) {
		return entries.put(new Random().nextInt(), e);
	}

}
