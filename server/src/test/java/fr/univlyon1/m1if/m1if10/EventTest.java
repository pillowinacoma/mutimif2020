package fr.univlyon1.m1if.m1if10;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import fr.univlyon1.m1if.m1if10.model.Event;

class EventTest {
    private Event e;
    
    @Test
    void EventConstructeurGetTest() {
        //Given
        Date d = new Date(2020, 23, 11);
        e = new Event(1, d, "Nom", "Description");
        
        //Then
        assertEquals(1, e.getId());
        assertEquals(d, e.getDate());
        assertEquals("Nom", e.getName());
        assertEquals("Description", e.getDescription());
    }
    
    void EventSetTest() {
        //Given
        e = new Event();
        Date d = new Date(1, 1, 1);
        
        //When
        e.setDate(d);
        e.setDescription("trucs!");
        e.setId(42);
        e.setName("Jean");
        
        //Then
        assertEquals(42, e.getId());
        assertEquals(d, e.getDate());
        assertEquals("Jean", e.getName());
        assertEquals("trucs!", e.getDescription());
    }
}
