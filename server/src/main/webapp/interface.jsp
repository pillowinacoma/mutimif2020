<%-- 
    Document   : interface.jsp
    Created on : 15 nov. 2020, 13:32:51
    Author     : melisyatutoglu
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="fr.univlyon1.m1if.m1if10.model.Event"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="fr" xml:lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Présence UCBL</title>
    <link rel="stylesheet" type="text/css" href="static/interface_style.css">
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class = container>
        <h2 id="titre"> Current Events </h2>

        <table>
            <caption></caption>
            <tr>
                <th scope="col">Name of event: </th>
                <th scope="col">Date: </th>
            </tr>
            <%  if(request.getAttribute("nosEvents")!=null){
                    List<Event> nosEvents = (List<Event>) request.getAttribute("nosEvents");
                    //récupération de la date actuelle pour afficher seulement les évenements courants
                    DateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    String dateactuelle = dateform.format(date);
                    Date currentDate = dateform.parse(dateactuelle);
                    java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
                    
                    for(int i = 0 ; i< nosEvents.size() ; i++){
                        if(nosEvents.get(i).getDate().compareTo(sqlCurrentDate) > -1){     
            %>
                    <tr>
                        <td><a href="admin?contenu=event&name=<%= nosEvents.get(i).getName()%>"> <%=nosEvents.get(i).toString()%> </td>
                        <td><%= nosEvents.get(i).getDate() %> </td>
                    </tr>
                    <% }}
                }%>
        </table>

    </div>
    </body>
</html>
