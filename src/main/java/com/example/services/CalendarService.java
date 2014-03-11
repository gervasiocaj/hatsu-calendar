package com.example.services;

import java.util.Calendar;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	public Collection<HatsuCalendar> get() {
		return CalendarDAO.getAllCalendars();
	}
	
	@PUT
	@Path("/{owner}")
	public Response addCalendar(@PathParam("owner") String owner) {
		HatsuCalendar result = CalendarDAO.createCalendar(owner);
		return Response.ok(result).build();
		
	}
	
	@POST
	@Path("/{owner}/entry")
	public Response addEvent(@PathParam("entry") String desc, Calendar start, Calendar end, Repetition rep, int repeats, String loc) {
		Entry result = CalendarDAO.createEntry(desc, start, end, rep, repeats, loc);
		return Response.ok(result).build();
	}
	
}
