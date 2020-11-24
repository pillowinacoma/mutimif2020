package fr.univlyon1.m1if.m1if10.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 * Class Event.
 */
@Entity(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "name")
    private String name;

    @Column(name = "descr")
    private String description;

    @ManyToMany
    @JoinTable(name = "HashtagEvent",
                joinColumns = @JoinColumn(name = "idevent"),
                inverseJoinColumns = @JoinColumn(name = "idhashtag"))
    private List<Hashtag> hashtags = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Event() {
    }

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

    public void setName(final String name) {
        this.name = name;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    @Override
    public String toString() {
        return name;
    }
}
