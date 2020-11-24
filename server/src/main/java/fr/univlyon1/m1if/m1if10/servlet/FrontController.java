package fr.univlyon1.m1if.m1if10.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.univlyon1.m1if.m1if10.dao.EventDAO;
import fr.univlyon1.m1if.m1if10.dao.HashtagDAO;
import fr.univlyon1.m1if.m1if10.model.Event;
import fr.univlyon1.m1if.m1if10.model.Hashtag;
import fr.univlyon1.m1if.m1if10.model.Post;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;

@WebServlet(name = "FrontController", urlPatterns = {"/user"})
public class FrontController extends HttpServlet {
    private EntityManager em;
    private EventDAO eventDAO;
    private HashtagDAO hashtagDAO;
    private final int delai = 2;


    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        em = Persistence.createEntityManagerFactory("public").createEntityManager();
        this.eventDAO = new EventDAO(em);
        this.hashtagDAO = new HashtagDAO(em);
    }


    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
    throws ServletException, IOException {
        List<Event> eventList = eventDAO.getAllEvent();
        final int estimateSeconds = estimateSeconds(eventList);

        resp.setHeader("Refresh", estimateSeconds * delai + "");
        req.setAttribute("eventList", eventList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    /**
     *
     * @param  eventList
     * @return estimated seconds
     */
    private static int estimateSeconds(final List<Event> eventList) {
        int estimatedSecondes = 0;
        if (eventList != null) {
            for (Event e : eventList) {
                estimatedSecondes++;
                List<Hashtag> hashList = e.getHashtags();
                if (hashList != null) {
                    for (Hashtag hash : hashList) {
                        estimatedSecondes++;
                        List<Post> postList = hash.getPosts();
                        if (postList != null) {
                            for (Post post : hash.getPosts()) {
                                estimatedSecondes++;
                            }
                        }
                    }
                }
            }
        }
        return estimatedSecondes;
    }

}
