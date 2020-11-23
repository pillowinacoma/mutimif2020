<%-- 
    Document   : interface
    Created on : 27 oct. 2020, 22:16:39
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
            <form class="add" method="post" action="admin">
                <input type="hidden" name="contenu" value="addEvent">
                <h2>Add an event with associated hashtags</h2>

                <fieldset>
                        <input placeholder="Name" type="text" name="nameEvent" autofocus>
                </fieldset>

                <fieldset>
                    <input placeholder="Date" type="datetime-local" name="dateEvent">
                </fieldset>

                <fieldset>
                        <input placeholder="Description" type="textarea" name="descriptionEvent" autofocus>
                </fieldset>

                <fieldset>
                    <input placeholder="Hashtags" type="textarea" name="hashtags" autofocus>
                </fieldset>

                <fieldset>
                    <button 
                        type="submit" name="submitEvent" id="submitEvent" >
                        +
                    </button>
                </fieldset>

            </form>
        </div>
    </body>
</html>
