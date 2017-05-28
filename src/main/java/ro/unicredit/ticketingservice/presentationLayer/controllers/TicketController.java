package ro.unicredit.ticketingservice.presentationLayer.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unicredit.ticketingservice.businessLayer.services.interfaces.TicketService;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Event;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Ticket;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by donic on 5/27/2017.
 */
@Component
@Path("/ticket")
@Consumes("application/json")
@Produces("application/json")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GET
    @Path("/dummy")
    public Ticket getDummyTicket(){

        Ticket ticket = new Ticket();
        Event event = new Event("Save the whales", LocalDate.now());

        ticket.setBuyerName("Donici Marius");
        ticket.setBuyTimestamp(LocalDateTime.now().toString());
        ticket.setEvent(event);
        ticket.setId(1337);

        return ticket;
    }

    @POST
    @Path("/buy_ticket")
    public Response buyTicket(Ticket ticketDTO){

        Ticket ticket = ticketService.buyTicket(ticketDTO);

        return Response.ok(ticket).build();
    }


    @GET
    @Path("/details/{id}")
    public Response getTicketDetails(@PathParam("id") Integer ticketId){

        Ticket ticket = ticketService.getTicketDetails(ticketId);

        return Response.ok(ticket).build();

    }

    @DELETE
    @Path("/cancel/{id}")
    public Response cancelTicket(@PathParam("id") Integer ticketId){

        String responseString = ticketService.cancelTicket(ticketId);

        return Response.ok(new JSONPObject("response",responseString)).build();

    }
}
