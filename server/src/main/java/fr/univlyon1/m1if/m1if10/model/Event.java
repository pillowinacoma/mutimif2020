package fr.univlyon1.m1if.m1if10.model;

import java.sql.Date;

/**
 * Class Event.
 */
public class Event {
    private int id;
    private Date date;
    private String name;
    private String description;

    /**
     * Constructor.
     * @param id String id of the event.
     * @param date Date date of the event.
     * @param name String name of the event.
     * @param description String Description of the event.
     */
    public Event(final int id, final Date date, final String name, final String description) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String returnString = name;
        return returnString;
    }
}
