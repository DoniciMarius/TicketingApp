package ro.unicredit.ticketingservice.businessLayer.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unicredit.ticketingservice.businessLayer.services.interfaces.EventService;
import ro.unicredit.ticketingservice.repositoryLayer.daos.interfaces.EventDAO;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Event;

import java.util.List;

/**
 * Created by donic on 5/27/2017.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;

    public EventServiceImpl() {
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public List<Event> getEvents() {
        List<Event> events = eventDAO.getEvents();

        return events;
    }

    @Override
    public void deleteEvent(Integer eventId) {

        eventDAO.delete(eventId);

    }

    @Override
    public Event getEventById(Integer eventId) {
        Event event = eventDAO.get(eventId);

        return event;
    }

    @Override
    public Event saveEvent(Event eventDTO) {
        Event event = eventDAO.save(eventDTO);

        return event;
    }
}
