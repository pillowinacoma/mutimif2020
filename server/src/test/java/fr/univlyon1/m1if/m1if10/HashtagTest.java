package fr.univlyon1.m1if.m1if10;

import static org.junit.jupiter.api.Assertions.*;

import fr.univlyon1.m1if.m1if10.model.Hashtag;

import org.junit.jupiter.api.Test;

class HashtagTest {
	private Hashtag ht;
	
	@Test
	void HashtagConstructeurGetTest() {
		//Given
		ht = new Hashtag(7,"Confinement");
		
		//Then
		assertEquals(7, ht.getId());
		assertEquals("Confinement",ht.getName());
	}
	
	@Test
	void HashtagSetTest() {
		//Given
		ht = new Hashtag();
		
		//When
		ht.setId(99);
		ht.setName("MIF10");
		
		//Then
		assertEquals(99,ht.getId());
		assertEquals("MIF10",ht.getName());
	}

}
