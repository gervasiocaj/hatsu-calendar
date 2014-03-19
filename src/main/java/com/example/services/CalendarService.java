package com.example.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	// GET 		calendar (all, single), event (all, single) (read)
	// POST		calendar, event (create)
	// PUT		calendar, event (update)
	// DELETE	calendar, event (delete)
	
	// ---------- GET
	
	@GET
	public Response get() {
		Map<Integer, HatsuCalendar> result = CalendarDAO.getAllCalendars();
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/{ownerid}")
	public Response getCalendar(@PathParam("ownerid") int ownerid) {
		HatsuCalendar result = CalendarDAO.getCalendar(ownerid);
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/{ownerid}/event")
	public Response getEntries(@PathParam("ownerid") int ownerid) {
		Entry[] result = CalendarDAO.getEntries(ownerid);
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/{ownerid}/event/{eventid}")
	public Response getEvent(
			@PathParam("ownerid") int ownerid,
			@PathParam("eventid") int eventid) {
		
		Entry result;
		
		try {
			result = CalendarDAO.getEntries(ownerid)[eventid];
		} catch (ArrayIndexOutOfBoundsException e) {
			return Response.noContent().build();
		}
		return Response.ok(result).build();
	}
	
	// ---------- POST
	
	@POST
	public Response addCalendar(@QueryParam("owner") String owner) {
		HatsuCalendar result = CalendarDAO.createCalendar(owner);
		return Response.ok(result).build(); // TODO change to response created
	}
	
	@POST
	@Path("/{ownerid}/event")
	public Response addEvent(
			@PathParam("ownerid") int ownerid,
			@QueryParam("desc") String desc, 
			@QueryParam("start") String start,
			@QueryParam("end") String end,
			@DefaultValue("0")		@QueryParam("repeats") int repeats,
			@DefaultValue("NONE")	@QueryParam("rep") String rep,
			@DefaultValue("NONE")	@QueryParam("loc") String loc) {
		
		Repetition repetition = Repetition.NONE;
		if (rep.equalsIgnoreCase("monthly"))
			repetition = Repetition.MONTHLY;
		
		Entry result = null;
		
		try {
		Calendar startString = Calendar.getInstance();
		Calendar endString = Calendar.getInstance();
		
			startString.setTime(dateFormat.parse(start));
			endString.setTime(dateFormat.parse(end));
			
			result = CalendarDAO.createEntry(ownerid, new Entry(desc, startString, endString, repetition, repeats, loc));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result == null)
			return Response.status(400).build();
		
		return Response.ok(result).build();
	}
	
	// ---------- DELETE
	
	@DELETE
	@Path("/{ownerid}/event/{eventid}")
	public Response deleteEvent(
			@PathParam("ownerid") int ownerId,
			@PathParam("eventid") int eventId){
		
		try {
			CalendarDAO.removeEntry(ownerId, eventId);
		} catch (Exception e) {
			return Response.status(400).build();
		}
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/{ownerid}")
	public Response deleteCalendar(@PathParam("ownerid") int ownerId){
		if (CalendarDAO.removeCalendar(ownerId) == null)
			return Response.noContent().build();
		
		return Response.status(200).build();
	}
}
