package fr.univlyon1.m1if.m1if10.servlet;
import fr.univlyon1.m1if.m1if10.ConnectInsta;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import fr.univlyon1.m1if.m1if10.dao.EventDAO;
import fr.univlyon1.m1if.m1if10.dao.HashtagDAO;
import fr.univlyon1.m1if.m1if10.model.Event;
import fr.univlyon1.m1if.m1if10.model.Hashtag;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;

@WebServlet(name = "interfaceController", urlPatterns = "/admin")
public class InterfaceController extends HttpServlet {
    private EntityManager manager;
    private EventDAO eventDao;
    private HashtagDAO hashtagDao;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        manager = Persistence.createEntityManagerFactory("public").createEntityManager();
        this.eventDao = new EventDAO(manager);
        this.hashtagDao = new HashtagDAO(manager);
    }
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
    throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            if (request.getParameter("action") == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action non spécifiée.");
                return;
            }
            if (request.getParameter("action").equals("+")) {
                manager.getTransaction().begin();
                //récupération des éléments du formulaire:
                String nameEvent = request.getParameter("nameEvent");
                //Formater la date
                String dateEvent = request.getParameter("dateEvent");
                SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateform.parse(dateEvent);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String descriptionEvent = request.getParameter("descriptionEvent");
                //création des mes modèles DAO
                Event event = this.eventDao.getOrCreate(nameEvent,
                        sqlDate, descriptionEvent);
                System.out.println("POIRE = " + event.toString());
              //récupération des hashtags dans la table tabString
                if (request.getParameter("hashtags") != null) {
                    String sHashtags = request.getParameter("hashtags");
                    String[] tabString = sHashtags.split(";");
                    ArrayList<ConnectInsta> tests = new ArrayList<ConnectInsta>();
                    for (String tabString1 : tabString) {
                        Hashtag hash = hashtagDao.getOrCreate(tabString1);
                        System.out.println("HHHASH = " + hash);
                        hash.addEvent(event);
                        tests.add(new ConnectInsta(tabString1));
                        tests.get(tests.size() - 1).start();
                    }
                }
                manager.getTransaction().commit();
                manager.close();
                processRequest(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(InterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);
    }

    protected void processRequest(final HttpServletRequest request,
                                    final HttpServletResponse response)
                                    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("interface.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
                 //récuperation dans une list pour affichage dans la jsp
        List<Event> listEvent = eventDao.getAllEvent();
        request.setAttribute("nosEvents", listEvent);
        processRequest(request, response);
    }

}