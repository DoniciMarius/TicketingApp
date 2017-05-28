package ro.unicredit.ticketingservice.repositoryLayer.daos.interfaces;

import org.springframework.transaction.annotation.Transactional;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Event;

import java.util.List;

/**
 * Created by donic on 5/27/2017.
 */
public interface EventDAO extends GenericDAO<Event>{

    List<Event> getEvents();

}
