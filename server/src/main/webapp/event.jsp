<%-- 
    Document   : Event
    Created on : 21 nov. 2020, 12:54:21
    Author     : melisyatutoglu
--%>

<%@page import="fr.univlyon1.m1if.m1if10.model.Hashtag"%>
<%@page import="fr.univlyon1.m1if.m1if10.model.Event"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="static/event_style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <% Event event = (Event) request.getAttribute("event"); %>
        <jsp:include page="menu.jsp"/>
        <section class="container2">
            <h1 id="titre"><%=event.getName()%></h1>
            <p> <%=event.getDescription()%> </p>
            <div class="options">
                <h3> Choose the display options </h3>
                <form>
                    <input type="radio" id="random" name="random" value="random"
                             checked>
                    <label for="random">Show posts randomly</label>
                    <input type="radio" id="mostRecent" name="mostRecent" value="mostRecent">
                    <label for="mostRecent">Show the most recent posts</label>
                    <input type="radio" id="mostLiked" name="mostLiked" value="mostLiked">
                    <label for="mostLiked">Show the most liked posts</label>
                    <input type="submit" name="action" value="Save" class="button"/>
                </form>
            </div>
            <div class="options">
                <h3>Hashtags: </h3>
                <table>
                    <tr>
                        <th>Name of hashtag : </th>
                    </tr>
                    <% for (Hashtag h: event.getHashtags()) {
                    %>
                        <tr>
                            <td><%=h.getName()%></td>
                            <td><input type="submit" name="action" value="-" id="X"/></td>
                        </tr>
                    <% } %>
                </table>
            </div>
            <br> 
            <div>
                <form method="post" action="admin">
                    <input type="hidden" name="deleteEvent" value="<%=event%>" />
                    <input type="submit" name="action" value="Delete" class="button"/>
                </form>
            </div>
        </section>
    </body>
</html>
