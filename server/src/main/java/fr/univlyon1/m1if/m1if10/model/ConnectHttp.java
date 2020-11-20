package fr.univlyon1.m1if.m1if10.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

/**
 * Class ConnectHttp used to get on http.
 */
public final class ConnectHttp {

    /**
     * Private default Constructor.
     */
    private ConnectHttp() {
    }

    /**
     * Function static to parse message.
     * @param urlString String
     * @return String
     */
    public static String get(final String urlString) {
        String finalResponse = " ";
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                String inputLine;
                StringBuilder response = new StringBuilder();
                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(urlConnection.getInputStream()));
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                finalResponse = response.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalResponse;
    }
}
