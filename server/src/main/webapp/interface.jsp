<%-- 
    Document   : interface.jsp
    Created on : 15 nov. 2020, 13:32:51
    Author     : melisyatutoglu
--%>
<%@page import="fr.univlyon1.m1if.m1if10.model.Event"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="fr">
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
            <tr>
                <th>name of event: </th>
            </tr>
            <%  if(request.getAttribute("nosEvents")!=null){
                    List<Event> nosEvents = (List<Event>) request.getAttribute("nosEvents");
                    for(int i = 0 ; i< nosEvents.size() ; i++){ %>
                    <tr>
                        <td><%= nosEvents.get(i).toString() %> </td>
                    </tr>
                    <% }
                }%>
        </table>

    </div>
    </body>
</html>