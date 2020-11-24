package fr.univlyon1.m1if.m1if10.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class InstaParser used to parser return message of ConnectInsta.
 */
public final class InstaParser {

    /**
     * Private default Constructor.
     */
    private InstaParser() {
    }

    /**
     * Function static to parse message.
     * @param message String.
     * @return ArrayList<Post>
     */
    public static List<Post> parser(final String message) {
        ArrayList<Post> returnArray = new ArrayList<>();
        JSONObject messageJSON = new JSONObject(message);
        JSONArray postList = (((messageJSON
                                .getJSONObject("graphql"))
                                .getJSONObject("hashtag"))
                                .getJSONObject("edge_hashtag_to_top_posts"))
                                .getJSONArray("edges");
        for (int i = 0; i < postList.length(); i++) {
            JSONObject objTmp = postList.getJSONObject(i).getJSONObject("node");
            if (objTmp.getString("__typename").equals("GraphImage")) {
                returnArray.add(
                    new Post(
                        objTmp.getString("id"),
                        objTmp.getString("display_url"),
                        objTmp.getJSONObject("owner").getString("id"),
                        objTmp.getString("accessibility_caption"),
                        objTmp.getJSONObject("edge_liked_by").getInt("count")
                    )
                );
            }
        }
        return returnArray;
    }
}
