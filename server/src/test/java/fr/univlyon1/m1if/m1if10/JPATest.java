package fr.univlyon1.m1if.m1if10;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

class JPATest {

	@Test
	void ConnexionBDTest() {
		EntityManager em = Persistence.createEntityManagerFactory("publictest").createEntityManager();
		em.close();
	}

}
