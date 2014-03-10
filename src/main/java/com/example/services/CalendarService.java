package com.example.services;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.controller.CalendarDAO;
import com.example.models.HatsuCalendar;

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
		return Response.status(200).entity("owner: " + result.getOwner()).build();
		
	}
}
