package ro.unicredit.ticketingservice.repositoryLayer.daos.interfaces;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by donic on 5/27/2017.
 */
public interface GenericDAO<T> {

    /**
     *
     * @param obj the object that will be persisted
     * @return the persisted object
     */
    T save(T obj);

    /**
     * Removes the object with the id @id if it exists
     * @param id the id of the object we want to remove
     */
    void delete(Integer id);

    /**
     *
     * @param id the id of the object we want to get
     * @return the object with the id @id if available
     */
    T get(Integer id);

}
