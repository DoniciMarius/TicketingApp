package ro.unicredit.ticketingservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ro.unicredit.ticketingservice.businessLayer.services.implementations.TicketServiceImpl;
import ro.unicredit.ticketingservice.repositoryLayer.daos.implementations.TicketDAOImpl;
import ro.unicredit.ticketingservice.repositoryLayer.daos.interfaces.TicketDAO;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Event;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by donic on 5/28/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {

    @Mock
    private TicketServiceImpl ticketService;

    private Ticket ticket;
    private Event event;


    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);

        ticketService = new TicketServiceImpl();

        ticket = new Ticket();
        ticket.setId(1);
        ticket.setBuyerName("Marius Donici");
        ticket.setBuyTimestamp(LocalDateTime.now().toString());

        event = new Event("Save the whales", LocalDate.now().minusDays(2));
    }

    @Test
    public void cancelTicketWhenAfterTheEventHasEnded2DaysAgo(){
        TicketDAO ticketDAO = Mockito.mock(TicketDAOImpl.class);

        ticket.setEvent(event);

        Mockito.when(ticketDAO.get(1)).thenReturn(ticket);

        ticketService.setTicketDAO(ticketDAO);

        String response = ticketService.cancelTicket(1);

        Assert.assertTrue(response.equals("[INFO]Cannot cancel expired ticket."));
    }

    @Test
    public void cancelTicketBeforeAnEventEnded(){
        TicketDAO ticketDAO = Mockito.mock(TicketDAOImpl.class);

        event.setEventDate(LocalDate.now().plusDays(3));

        ticket.setEvent(event);

        Mockito.when(ticketDAO.get(1)).thenReturn(ticket);

        ticketService.setTicketDAO(ticketDAO);

        String response = ticketService.cancelTicket(1);

        Assert.assertTrue(response.equals("[SUCCESS]Canceled ticket."));

    }

    @Test
    public void cancelATicketThatDoesNotExist(){
        TicketDAO ticketDAO = Mockito.mock(TicketDAOImpl.class);

        Mockito.when(ticketDAO.get(1)).thenReturn(null);

        ticketService.setTicketDAO(ticketDAO);

        String response = ticketService.cancelTicket(1);

        Assert.assertTrue(response.equals("[INFO]Ticket does not exists."));

    }
}
