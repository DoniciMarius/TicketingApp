package ro.unicredit.ticketingservice.businessLayer.services.implementations;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unicredit.ticketingservice.businessLayer.services.interfaces.TicketService;
import ro.unicredit.ticketingservice.repositoryLayer.daos.interfaces.TicketDAO;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Ticket;

import javax.ws.rs.core.Response;
import java.time.LocalDate;

/**
 * Created by donic on 5/27/2017.
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDAO ticketDAO;

    public TicketServiceImpl() {
    }

    public TicketDAO getTicketDAO() {
        return ticketDAO;
    }

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public Ticket buyTicket(Ticket ticketDTO) {

        Ticket ticket = ticketDAO.save(ticketDTO);

        return ticket;
    }

    @Override
    public Ticket getTicketDetails(Integer ticketId) {
        Ticket ticket =  ticketDAO.get(ticketId);

        return ticket;
    }

    /**
     * The response shouldn't be hardcoded but for functionality
     * I hardcoded it
     * @param ticketId ticket's id
     * @return
     */
    @Override
    public String cancelTicket(Integer ticketId) {

        String responseString = "[INFO]Cannot cancel expired ticket.";

        Ticket ticket = ticketDAO.get(ticketId);
        if(ticket == null){
            responseString = "[INFO]Ticket does not exists.";
            return  responseString;
        }

        LocalDate currentTime = LocalDate.now();

        if(!ticket.getEvent().getEventDate().isBefore(currentTime)){
            responseString = "[SUCCESS]Canceled ticket.";
            ticketDAO.delete(ticketId);
        }

        return responseString;
    }
}
