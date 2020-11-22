package fr.univlyon1.m1if.m1if10.dao;

import fr.univlyon1.m1if.m1if10.model.Hashtag;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Created by ecoquery on 25/09/2016.
 */
public class HashtagDAO {

    private EntityManager manager;

    /**
     * Constructor.
     * @param em
     */
    public HashtagDAO(final EntityManager em) {
        this.manager = em;
    }

    /**
     * Renvoie l'hashtag correspondant à ce name.
     * @param name name du hashtag
     * @return l'hashtag ou null s'il n'existe pas
     */
    public Hashtag getHashtagByName(final String name) {
        try {
            Hashtag hashtag =
                    (Hashtag) this.manager.createQuery("SELECT h FROM Hashtag h WHERE h.name=:name")
            .setParameter("name", name)
            .getSingleResult();
            return hashtag;
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Function getOrCreate.
     * @param name
     * @return
     */
    public Hashtag getOrCreate(final String name) {
        Hashtag hashtag = this.getHashtagByName(name);
        if (hashtag == null) {
            hashtag = new Hashtag();
            hashtag.setName(name);
            manager.persist(hashtag);
        }
        return hashtag;
    }
}
