package fr.univlyon1.m1if.m1if10.model;

/**
 * Class Hashtag.
 */
public class Hashtag {
    private int id;
    private String name;

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

    @Override
    public String toString() {
        String returnString = name;
        return returnString;
    }
}
