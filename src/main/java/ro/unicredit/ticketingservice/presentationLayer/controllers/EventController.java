package ro.unicredit.ticketingservice.presentationLayer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unicredit.ticketingservice.businessLayer.services.interfaces.EventService;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Event;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by donic on 5/27/2017.
 */
@Component
@Path("/event")
@Consumes("application/json")
@Produces("application/json")
public class EventController {

    @Autowired
    private EventService eventService;

    @GET
    @Path("/dummy")
    public Event getDummyEvent() {

        Event event = new Event();

        event.setEventDate(LocalDate.now());
        event.setEventName("Save the whales");
        event.setId(3);

        return event;
    }

    @POST
    public Response addEvent(Event eventDTO) {
        Event event = eventService.saveEvent(eventDTO);

        return Response.ok(event).build();

    }

    @PUT
    @Path("/{id}")
    public Response updateEvent(@PathParam("id")Integer eventId, Event eventDTO){
        if(eventDTO.getId().equals(eventId)){

            Event event = eventService.saveEvent(eventDTO);

            return Response.ok(event).build();
        }

        return Response.status(400).build();
    }

    @GET
    @Path("/list_events")
    public Response getListEvent() {
        List<Event> eventList = eventService.getEvents();

        return Response.ok(eventList).build();
    }

    @GET
    @Path("/{id}")
    public Response getEventById(@PathParam("id") Integer eventId) {

        Event event = eventService.getEventById(eventId);

        return Response.ok(event).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvent(@PathParam("id") Integer eventId) {

        eventService.deleteEvent(eventId);

        return Response.ok().build();
    }


}
