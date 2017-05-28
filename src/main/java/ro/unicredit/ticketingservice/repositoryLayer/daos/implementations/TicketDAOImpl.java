package ro.unicredit.ticketingservice.repositoryLayer.daos.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.unicredit.ticketingservice.repositoryLayer.daos.interfaces.TicketDAO;
import ro.unicredit.ticketingservice.repositoryLayer.entities.Ticket;

import javax.persistence.EntityManager;

/**
 * Created by donic on 5/27/2017.
 */
@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Ticket save(Ticket ticketDTO) {

        Ticket ticket = entityManager.merge(ticketDTO);

        return ticket;

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Ticket ticket = entityManager.find(Ticket.class,id);

        entityManager.remove(ticket);

    }

    @Override
    public Ticket get(Integer id) {
        Ticket ticket = entityManager.find(Ticket.class,id);

        return ticket;
    }
}
