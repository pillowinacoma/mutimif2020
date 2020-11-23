package fr.univlyon1.m1if.m1if10.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 * Class Post.
 */
@Entity(name = "Post")
public class Post {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "imageurl")
    private String url;

    @Column(name = "name")
    private String name;

    @Column(name = "descr")
    private String description;

    @Column(name = "nblike")
    private int nbLike;

    @ManyToMany
    @JoinTable(name = "PostHashtag",
                joinColumns = @JoinColumn(name = "idpost"),
                inverseJoinColumns = @JoinColumn(name = "idhashtag"))
    private List<Hashtag> hashtags = new ArrayList<>();

    /**
     * Constructor.
     * @param id String id of the post.
     * @param url String url of the picture.
     * @param name String name of the creator of the post.
     * @param description String Description of the post.
     * @param nbLike int Number of likes of the post.
     */
    public Post(final String id, final String url,
    final String name, final String description, final int nbLike) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.description = description;
        this.nbLike = nbLike;
    }

    /**
     * Default Constructor.
     */
    public Post() {

    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNbLike() {
        return nbLike;
    }

    /**
     * add hashtag.
     * @param h
     */
    public void addHashtag(final Hashtag h) {
        hashtags.add(h);
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    @Override
    public String toString() {
        String returnString = id + " | " + url + " | " + name;
        return returnString;
    }
}
