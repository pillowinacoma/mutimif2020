package fr.univlyon1.m1if.m1if10.model;

/**
 * Class Post.
 */
public class Post {
    private String id;
    private String url;
    private String name;
    private String description;
    private int nbLike;

    /**
     * Constructor.
     * @param id String if of the post.
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

    @Override
    public String toString() {
        String returnString = id + " | " + url + " | " + name;
        return returnString;
    }
}
