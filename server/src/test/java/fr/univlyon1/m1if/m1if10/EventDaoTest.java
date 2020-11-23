package fr.univlyon1.m1if.m1if10;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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
        em = Persistence.createEntityManagerFactory("public").createEntityManager();
        em.getTransaction().begin();
        eDAO = new EventDAO(em);
    }

    @Test
    void getOrCreateTest() {
        // Given
        Event e;

        // When
        e = eDAO.getOrCreate("Nuit de l'info");
        em.getTransaction().commit();

        // Then
        assertEquals("Nuit de l'info", e.getName());

        em.close();
    }

    @Test
    void getEventByNameTest() {
        // Given
        Event e1, e2, e3;

        // When
        e1 = eDAO.getOrCreate("Presentation du M2");
        e2 = eDAO.getOrCreate("Gala");
        e3 = eDAO.getOrCreate("Remise des diplomes");
        em.getTransaction().commit();

        // Then
        assertEquals(null, eDAO.getEventByName("Galalala"));
        assertEquals(e1, eDAO.getEventByName("Presentation du M2"));
        assertEquals(e3, eDAO.getEventByName(e3.getName()));

        em.close();
    }
}
