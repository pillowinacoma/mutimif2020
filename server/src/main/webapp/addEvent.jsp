<%-- 
    Document   : interface
    Created on : 27 oct. 2020, 22:16:39
    Author     : melisyatutoglu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr" xml:lang="fr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="static/interface_style.css">
        <title>Event et hashtag</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <form class="add" method="post" action="admin">
                <input type="hidden" name="contenu" value="addEvent">
                <h2>Add an event with associated hashtags</h2>

                <fieldset>
                    <legend></legend>
                    <input placeholder="Name" type="text" name="nameEvent" autofocus>
                </fieldset>

                <fieldset>
                    <legend></legend>
                    <input placeholder="Date" type="date" name="dateEvent">
                </fieldset>

                <fieldset>
                    <legend></legend>
                    <input placeholder="Description" type="textarea" name="descriptionEvent" autofocus>
                </fieldset>

                <fieldset>
                    <legend>Séparer les hashtags avec des ;</legend>
                    <input placeholder="Hashtags" type="textarea" name="hashtags" autofocus>
                </fieldset>

                <fieldset>
                    <legend></legend>
                    <input
                        type="submit" name="action" value="+" id="submitEvent" >
                </fieldset>

            </form>
        </div>
    </body>
</html>
