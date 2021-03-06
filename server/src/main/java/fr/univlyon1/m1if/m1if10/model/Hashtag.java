package fr.univlyon1.m1if.m1if10.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 * Class Hashtag.
 */
@Entity(name = "Hashtag")
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "HashtagEvent",
                joinColumns = @JoinColumn(name = "idhashtag"),
                inverseJoinColumns = @JoinColumn(name = "idevent"))
    private List<Event> events = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "PostHashtag",
                joinColumns = @JoinColumn(name = "idhashtag"),
                inverseJoinColumns = @JoinColumn(name = "idpost"))
    private List<Post> posts = new ArrayList<>();

    /**
     * Default Constructor.
     */
    public Hashtag() {
    }

    /**
     * Constructor.
     * @param id String id of the hashtag.
     * @param name String name of the hashtag.
     */
    public Hashtag(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * add Event.
     * @param e
     */
    public void addEvent(final Event e) {
        events.add(e);
    }
    /**
     * add Event.
     * @param e
     */
    public void removeEvent(final Event e) {
        for (int i = 0; i < this.events.size(); i++) {
            if (e.equals(events.get(i))) {
                events.remove(i);
            }
        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return name;
    }
}
