package fr.univlyon1.m1if.m1if10;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univlyon1.m1if.m1if10.dao.PostDAO;
import fr.univlyon1.m1if.m1if10.model.Post;



class PostDaoTest {
    
    public PostDAO pDAO;
    public EntityManager em;
    
    @BeforeEach
    void setUp() {
        em = Persistence.createEntityManagerFactory("publictest").createEntityManager();
        em.getTransaction().begin();
        pDAO = new PostDAO(em);
    }

    @Test
    void getOrCreateTest() {
        //Given
        Post p;
        
        //When
        p = pDAO.getOrCreate("idTest","instaUrl.truc","NomGenerique","Description",999);
        em.getTransaction().commit();
        
        //Then
        assertEquals("idTest",p.getId());
        assertEquals("instaUrl.truc",p.getUrl());
        assertEquals("NomGenerique",p.getName());
        assertEquals("Description",p.getDescription());
        assertEquals(999,p.getNbLike());
        assertEquals(p, pDAO.getOrCreate("idTest","instaUrl.truc","NomGenerique","Description",999));
        em.close();
    }
    
    @Test
    void getPostByNameTest() {
        //Given
        Post p1,p2;
        
        //When
        p1 = pDAO.getOrCreate("12345","instaUrl.com","Pierre","Bijour",0);
        p2 = pDAO.getOrCreate("azerty","instaUrl.fr","Jean","Orvoir",1);
        em.getTransaction().commit();
        
        //Then
        assertEquals(p1,pDAO.getPostByID("12345"));
        assertEquals(null,pDAO.getPostByID(""));
        assertEquals(p2,pDAO.getPostByID(p2.getId()));
        
        em.close();
    }

}
