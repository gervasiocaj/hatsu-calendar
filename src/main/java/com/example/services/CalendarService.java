package com.example.services;

import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.controller.CalendarDAO;
import com.example.models.Calendar;

@Path("/calendar")
@Produces(MediaType.APPLICATION_JSON)
public class CalendarService {
	
	@GET
	public Collection<Calendar> get() {
		return CalendarDAO.getAllCalendars();
	}
	
	@PUT
	@Path("/{owner}")
	public void addCalendar(@PathParam("owner") String owner) {
		CalendarDAO.createCalendar(owner);
	}
}
