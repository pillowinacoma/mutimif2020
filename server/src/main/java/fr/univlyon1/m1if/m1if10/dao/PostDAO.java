package fr.univlyon1.m1if.m1if10.dao;

import fr.univlyon1.m1if.m1if10.model.Post;

import javax.persistence.EntityManager;

/**
 * Created by ecoquery on 25/09/2016.
 */
public class PostDAO {

    private EntityManager manager;

    /**
     * Constructor.
     * @param em
     */
    public PostDAO(final EntityManager em) {
        this.manager = em;
    }

    /**
     * Renvoie le Post correspondant à l'ID.
     * @param id l'id du post
     * @return le Post ou null s'il n'existe pas
     */
    public Post getPostByID(final String id) {
        if (id == null) {
            return null;
        }
        return manager.find(Post.class, id);
    }

    /**
     * Function getOrCreate.
     * @param id
     * @param url
     * @param name
     * @param description
     * @param nbLike
     * @return
     */
    public Post getOrCreate(final String id, final String url,
    final String name, final String description, final int nbLike) {
        //Ajouter un Id de Hashtag
        Post post = this.getPostByID(id);
        if (post == null) {
            post = new Post(id, url, name, description, nbLike);
            manager.persist(post);
        }
        return post;
    }
}
