<%-- 
    Document   : addHashtag
    Created on : 15 nov. 2020, 14:23:00
    Author     : melisyatutoglu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="static/interface_style.css">
        <title>Event et hashtag</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <form class="add" method="post" action="Init">
                <input type="hidden" name="contenu" value="addHashtag">
                <h1>add hashtags associated with one or more events </h1>
                <fieldset>
                         <input placeholder="ID" type="text" name="idEvent" autofocus>
                </fieldset>

                <fieldset>
                        <input placeholder="Name" type="text" name="nameEvent" autofocus>
                </fieldset>

                <fieldset>
                        <input placeholder="Description" type="textarea" name="descriptionEvent" autofocus>
                </fieldset>
                <button 
                    type="submit" name="submitEvent" id="submitHashtags" data-submit="...Connexion">
                    +
                </button>
            </form>
        </div>
    </body>
</html>
