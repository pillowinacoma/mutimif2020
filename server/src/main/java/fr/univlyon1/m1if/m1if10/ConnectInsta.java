package fr.univlyon1.m1if.m1if10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import fr.univlyon1.m1if.m1if10.model.InstaParser;
import fr.univlyon1.m1if.m1if10.model.Post;

/**
 * Class ConnectInsta used to get data og instagram.
 */
public class ConnectInsta  extends Thread {
    private String response = "";
    private String hashtag = "";
    private String urlbasique = "https://www.instagram.com/explore/tags/";

    /**
     * @param hashtag String of hashtag chose
     */
    public ConnectInsta(final String hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public void run() {
        try {
            urlbasique += hashtag;
            urlbasique += "/?__a=1";
            URL url = new URL(urlbasique);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                String inputLine;
                StringBuilder response = new StringBuilder();
                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(urlConnection.getInputStream()));
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                this.response = response.toString();
                // et on ferme le flux
                getResponse();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * call to process the response.
     */
    public void getResponse() {
        ArrayList<Post> listPost = InstaParser.parser(response);
        for (int i = 0; i < listPost.size(); i++) {
            //appel au dao pour sauvegarder chaque Post
        }
    }
}
