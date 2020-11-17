package fr.univlyon1.m1if.m1if10;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;

import fr.univlyon1.m1if.m1if10.model.Post;

/**
 * Class ConnectPostgreSQL used to communicate to BD.
 */
public final class ConnectPostgreSQL {

    /**
     * Private default Constructor.
     */
    private ConnectPostgreSQL() {
    }

    /**
     * Function static add Post on BD.
     * @param postList ArrayList<Post> List of post
     */
    public static void addPosts(final ArrayList<Post> postList) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/test",
                "pi",
                "raspberry");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "";
            for (int i = 0; i < postList.size(); i++) {
                sql += "INSERT INTO \"Post\"(\"imageURL\",\"name\",\"descr\",\"nbLike\")";
                sql += "VALUES ("
                    + "'" + postList.get(i).getUrl() + "',"
                    + "'" + postList.get(i).getName() + "',"
                    + "'" + postList.get(i).getDescription() + "',"
                    + "'" + String.valueOf(postList.get(i).getNbLike()) + ");";
                stmt.executeUpdate(sql);
            }

            stmt.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}
