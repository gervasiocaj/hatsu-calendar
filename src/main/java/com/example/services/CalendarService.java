package com.example.services;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.controller.CalendarDAO;
import com.example.models.Entry;
import com.example.models.HatsuCalendar;
import com.example.models.Entry.Repetition;

@Path("/calendar")
@Produces(MediaType.APPLICATION_JSON)
public class CalendarService {
	
	@GET
	public Map<Integer, HatsuCalendar> get() {
		return CalendarDAO.getAllCalendars();
	}
	
	@GET
	@Path("/{ownerid}")
	public HatsuCalendar getCalendar(@PathParam("ownerid") int ownerid) {
		return CalendarDAO.getCalendar(ownerid);
	}
	
	@PUT
	@Path("/{owner}")
	public Response addCalendar(@PathParam("owner") String owner) {
		HatsuCalendar result = CalendarDAO.createCalendar(owner);
		return Response.ok(result).build();
	}
	
	@POST
	@Path("/{ownerid}/entry")
	public Response addEvent(
			@PathParam("ownerid") int ownerid,
			@QueryParam("id") int id,
			@QueryParam("desc") String desc, 
			@QueryParam("start") String start,
			@QueryParam("end") String end,
			@DefaultValue("0")		@QueryParam("repeats") int repeats,
			@DefaultValue("NONE")	@QueryParam("rep") String rep,
			@DefaultValue("NONE")	@QueryParam("loc") String loc) {
		
		Repetition repetition = Repetition.NONE;
		if (rep.equalsIgnoreCase("monthly"))
			repetition = Repetition.MONTHLY;
		
		Entry result = CalendarDAO.createEntry(ownerid, new Entry(id, desc, null, null, repetition, repeats, loc)); 
		// XXX Fix  start and end to Calendar objs
		// http://stackoverflow.com/questions/13716338/how-to-pass-calendar-param-as-input-to-a-rest-service
		
		if (result == null)
			return Response.noContent().build();
		
		return Response.ok(result).build();
	}
	

	
	
}
