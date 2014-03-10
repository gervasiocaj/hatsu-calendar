package com.example.models;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HatsuCalendar {
	
	private String owner;
	private List<Entry> entries;
	
	public HatsuCalendar(String owner) {
		this.owner = owner;
		this.entries = new LinkedList<Entry>();
	}

	public String getOwner() {
		return owner;
	}
	
	public Entry[] getEntries() {
		return entries.toArray(new Entry[entries.size()]);
	}
	
	public void addEntry(Entry e) {
		entries.add(e);
	}
	

}
