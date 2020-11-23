package fr.univlyon1.m1if.m1if10.dao;

import fr.univlyon1.m1if.m1if10.model.Event;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import java.sql.Date;
import java.util.List;

/**
 * Class EventDAO.
 */
public class EventDAO {

    private EntityManager manager;

    /**
     * Constructor.
     * @param em
     */
    public EventDAO(final EntityManager em) {
        this.manager = em;
    }

    /**
     * Renvoie l'Event correspondant à ce nom.
     * @param name name de l'event
     * @return ou null s'il n'existe pas
     */
    public Event getEventByName(final String name) {
        try {
            Event event =
                    (Event) this.manager.createQuery("SELECT e FROM Event e WHERE e.name=:name")
            .setParameter("name", name)
            .getSingleResult();
            return event;
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Function getOrCreate.
     * @param name
     * @param date
     * @param description
     * @return
     */
    public Event getOrCreate(final String name, final Date date, final String description) {
        Event event = this.getEventByName(name);
        if (event == null) {
            event = new Event();
            event.setName(name);
            event.setDate(date);
            event.setDescription(description);
            manager.persist(event);
        }
        return event;
    }
    public List<Event> getAllEvent() {
        return manager.createQuery("select e from Event e", Event.class).getResultList();
    }
}
