package fr.univlyon1.m1if.m1if10.model;

/**
 * Class PostPhoto.
 */
public class PostPhoto extends Post {

    /**
     * Constructor.
     * @param id String if of the post.
     * @param url String url of the picture.
     * @param name String name of the creator of the post.
     * @param description String Description of the post.
     * @param nbLike int Number of likes of the post.
     */
    public PostPhoto(final String id, final String url,
    final String name, final String description, final int nbLike) {
        super(id, url, name, description, nbLike);
    }
}
