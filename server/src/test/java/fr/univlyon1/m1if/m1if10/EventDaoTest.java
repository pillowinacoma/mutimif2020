package fr.univlyon1.m1if.m1if10;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univlyon1.m1if.m1if10.dao.EventDAO;
import fr.univlyon1.m1if.m1if10.model.Event;

class EventDaoTest {

    public EventDAO eDAO;
    public EntityManager em;

    @BeforeEach
    public void setUp() {
        em = Persistence.createEntityManagerFactory("publictest").createEntityManager();
        em.getTransaction().begin();
        eDAO = new EventDAO(em);
    }

    @Test
    void getOrCreateTest() {
        // Given
        Event e;
        Date d = new Date(2020, 23, 11);

        // When
        e = eDAO.getOrCreate("Nuit de l'info", d, "Description");
        em.getTransaction().commit();

        // Then
        assertEquals("Nuit de l'info", e.getName());
        assertEquals(d, e.getDate());
        assertEquals("Description", e.getDescription());

        em.close();
    }

    @Test
    void getEventByNameTest() {
        // Given
        Event e1, e2, e3;
        Date d = new Date(2020, 23, 11);

        // When
        e1 = eDAO.getOrCreate("Presentation du M2", d, "Description");
        e2 = eDAO.getOrCreate("Gala", d, "Description");
        e3 = eDAO.getOrCreate("Remise des diplomes", d, "Description");
        em.getTransaction().commit();

        // Then
        assertEquals(null, eDAO.getEventByName("Galalala"));
        assertEquals(e1, eDAO.getEventByName("Presentation du M2"));
        assertEquals(e3, eDAO.getEventByName(e3.getName()));

        em.close();
    }
}
