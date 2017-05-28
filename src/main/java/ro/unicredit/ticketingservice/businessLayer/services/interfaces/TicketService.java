package ro.unicredit.ticketingservice.businessLayer.services.interfaces;

import ro.unicredit.ticketingservice.repositoryLayer.entities.Ticket;

/**
 * Created by donic on 5/27/2017.
 */
public interface TicketService {

    Ticket buyTicket(Ticket ticketDTO);

    Ticket getTicketDetails(Integer ticketId);

    /**
     *
     * @param ticketId ticket's id
     * @return a response string that specifies if the ticket was canceled or not
     */
    String cancelTicket(Integer ticketId);

}
