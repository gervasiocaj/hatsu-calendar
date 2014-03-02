package com.example.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Calendar {
	
	private String owner;
	
	public Calendar(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

}
