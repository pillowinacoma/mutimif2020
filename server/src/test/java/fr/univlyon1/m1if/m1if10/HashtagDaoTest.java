package fr.univlyon1.m1if.m1if10;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univlyon1.m1if.m1if10.dao.HashtagDAO;
import fr.univlyon1.m1if.m1if10.model.Hashtag;


class HashtagDaoTest {
    
    public HashtagDAO htDAO;
    public EntityManager em;
    
    @BeforeEach
    void setUp() {
        em = Persistence.createEntityManagerFactory("public").createEntityManager();
        em.getTransaction().begin();
        htDAO = new HashtagDAO(em);
    }

    @Test
    void getOrCreateTest() {
        //Given
        Hashtag h;
        
        //When
        h = htDAO.getOrCreate("Covid19");
        em.getTransaction().commit();
        
        //Then
        assertEquals("Covid19",h.getName());
        assertEquals(h, htDAO.getOrCreate("Covid19"));
        
        em.close();
    }
    
    @Test
    void getHashtagByNameTest() {
        //Given
        Hashtag h1,h2,h3;
        
        //When
        h1 = htDAO.getOrCreate("Master1");
        h2 = htDAO.getOrCreate("oof");
        h3 = htDAO.getOrCreate("Redoublement");
        em.getTransaction().commit();
        
        //Then
        assertEquals(h1,htDAO.getHashtagByName("Master1"));
        assertEquals(null,htDAO.getHashtagByName("foo"));
        assertEquals(h3,htDAO.getHashtagByName(h3.getName()));
        
        em.close();
    }

}
