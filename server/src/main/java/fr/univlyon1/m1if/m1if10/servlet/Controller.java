import fr.univlyon1.m1if.m1if10.model.Event;
import fr.univlyon1.m1if.m1if10.model.Hashtag;
import fr.univlyon1.m1if.m1if10.model.Post;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;


import java.io.IOException;


/**
 * Controller Servlet.
 */
@WebServlet(name = "Controller", urlPatterns = {"/main", "/main/*"})
public class Controller extends HttpServlet {

    /**
     * service method.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void service(final HttpServletRequest request, final HttpServletResponse response)
    throws ServletException, IOException {
        Random rand = new Random();
        List<Event> eventList = new ArrayList<Event>();
        List<Hashtag> hashtagList = new ArrayList<Hashtag>();
        List<Post> postList = new ArrayList<Post>();
        final int lim = 5;
        final int limPics = 10;
        Date date = new Date(System.currentTimeMillis());

        for (int i = 0; i < lim; i++) {
            eventList.add(new Event(i, date, "Event " + i, "Description " + i));
        }

        for (int i = 0; i < lim; i++) {
            hashtagList.add(new Hashtag(i, "hashtag " + i));
        }

        for (int i = 0; i < limPics; i++) {
            postList.add(new Post(i + "",
            "https://picsum.photos/" + rand.nextInt(lim * lim) * (lim + limPics) + "/" + rand.nextInt(lim * lim) * (lim + limPics),
            "name " + i,
            "description " + i,
            rand.nextInt(lim * lim)));
        }

        request.setAttribute("eventList", eventList);
        request.setAttribute("hashtagList", hashtagList);
        request.setAttribute("postList", postList);
        response.setHeader("Refresh",
        (postList.size() * hashtagList.size() * eventList.size()) + "");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
