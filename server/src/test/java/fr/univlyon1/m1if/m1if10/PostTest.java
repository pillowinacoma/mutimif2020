package fr.univlyon1.m1if.m1if10;

import static org.junit.jupiter.api.Assertions.*;

import fr.univlyon1.m1if.m1if10.model.Hashtag;
import fr.univlyon1.m1if.m1if10.model.Post;

import org.junit.jupiter.api.Test;

class PostTest {

	private Post p;
	
	@Test
	void PostConstructeurGetTest() {
		//Given
		p = new Post("ID","insta.url","XU","Description",777);
		
		//Then
		assertEquals("ID", p.getId());
		assertEquals("insta.url", p.getUrl());
		assertEquals("XU", p.getName());
		assertEquals("Description", p.getDescription());
		assertEquals(777, p.getNbLike());
	}
	
	void PostAddHashtagTest() {
		//Given
		p = new Post();
		Hashtag h = new Hashtag(1,"testAdd");
		
		//When
		p.addHashtag(h);
		
		//Then
		assertEquals(h, p.getHashtags().iterator().next());
	}

}
