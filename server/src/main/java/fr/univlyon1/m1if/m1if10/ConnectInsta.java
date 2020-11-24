package fr.univlyon1.m1if.m1if10;

import java.util.ArrayList;

import fr.univlyon1.m1if.m1if10.dao.HashtagDAO;
import fr.univlyon1.m1if.m1if10.dao.PostDAO;
import fr.univlyon1.m1if.m1if10.model.ConnectHttp;
import fr.univlyon1.m1if.m1if10.model.InstaParser;
import fr.univlyon1.m1if.m1if10.model.Post;
import fr.univlyon1.m1if.m1if10.model.Hashtag;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Class ConnectInsta used to get data og instagram.
 */
public class ConnectInsta  extends Thread {
    private String hashtag = "";
    private String urlbasique = "http://89.86.78.77:5600/";
    private EntityManager manager;

    /**
     * @param hashtag String of hashtag chose
     */
    public ConnectInsta(final String hashtag) {
        manager = Persistence.createEntityManagerFactory("public").createEntityManager();
        this.hashtag = hashtag;
    }

    @Override
    public void run() {
        String response = ConnectHttp.get(urlbasique + hashtag + ".json");
        manager.getTransaction().begin();
        HashtagDAO hdao = new HashtagDAO(manager);
        PostDAO pdao = new PostDAO(manager);
        //Appel au dao pour sauvegarder du Hashtag Post
        //Permet que si ConnectHttp bloque le Hashtag n'est pas crée
        ArrayList<Post> listPost = (ArrayList) InstaParser.parser(response);
        for (int i = 0; i < listPost.size(); i++) {
            Hashtag tmpHash = hdao.getHashtagByName(hashtag);
            Post tpmPost = pdao.getOrCreate(
                listPost.get(i).getId(),
                listPost.get(i).getUrl(),
                listPost.get(i).getName(),
                listPost.get(i).getDescription(),
                listPost.get(i).getNbLike());
            tpmPost.addHashtag(tmpHash);
            //Appel au dao pour sauvegarder chaque Post
        }
        manager.getTransaction().commit();
        manager.close();
    }
}
