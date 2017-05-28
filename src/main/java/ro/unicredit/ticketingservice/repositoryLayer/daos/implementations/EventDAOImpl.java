package ro.unicredit.ticketingservice.repositoryLayer.daos.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.unicredit.ticketingservice.repositoryLayer.daos.interfaces.EventDAO;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

/**
 * Created by donic on 5/27/2017.
 */
@Repository
public class EventDAOImpl implements EventDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public Event save(Event obj) {
        Event event = entityManager.merge(obj);

        return event;
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Event event = entityManager.find(Event.class, id);

        if (event != null) {
            entityManager.remove(event);
        }
    }

    @Override
    public Event get(Integer id) {
        Event event = entityManager.find(Event.class,id);

        return event;
    }

    @Override
    public List<Event> getEvents() {
        String queryString = "SELECT event FROM Event event";

        Query query = entityManager.createQuery(queryString);

        List<Event> events = query.getResultList();

        return events;
    }


}
