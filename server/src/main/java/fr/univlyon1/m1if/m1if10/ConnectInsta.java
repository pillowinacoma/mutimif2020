package fr.univlyon1.m1if.m1if10;

import java.util.ArrayList;



import fr.univlyon1.m1if.m1if10.model.ConnectHttp;
import fr.univlyon1.m1if.m1if10.model.InstaParser;
import fr.univlyon1.m1if.m1if10.model.Post;

/**
 * Class ConnectInsta used to get data og instagram.
 */
public class ConnectInsta  extends Thread {
    private String hashtag = "";
    private String urlbasique = "http://89.86.78.77:5600/";

    /**
     * @param hashtag String of hashtag chose
     */
    public ConnectInsta(final String hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public void run() {
        String response = ConnectHttp.get(urlbasique + hashtag + ".json");
        //Appel au dao pour sauvegarder du Hashtag Post
        //Permet que si ConnectHttp bloque le Hashtag n'est pas crée
        ArrayList<Post> listPost = InstaParser.parser(response);
        for (int i = 0; i < listPost.size(); i++) {
            System.out.println(listPost.get(i).toString());
            //Appel au dao pour sauvegarder chaque Post
        }
    }
}
