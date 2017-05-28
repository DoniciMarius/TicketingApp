package ro.unicredit.ticketingservice.businessLayer.services.interfaces;

import ro.unicredit.ticketingservice.repositoryLayer.entities.Event;

import java.util.List;

/**
 * Created by donic on 5/27/2017.
 */
public interface EventService {

    List<Event> getEvents();

    Event saveEvent(Event eventDTO);

    void deleteEvent(Integer eventId);

    Event getEventById(Integer eventId);
}
