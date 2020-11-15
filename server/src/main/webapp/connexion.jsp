<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Affichage des events</title>
    <link rel="stylesheet" type="text/css" href="static/connexion_style.css">
</head>
<body>
<div class="container">
    <form id="connexion" method="post" action="Init">
        <h2>Connexion à l'interface administrateur</h2>
            <fieldset>
                    <input placeholder="Login" type="text" name="login" autofocus>
            </fieldset>

            <fieldset>
                    <input placeholder="mot de passe" type="text" name="nom">
            </fieldset>

            <fieldset>
                    <button 
                        type="submit" name="submit" id="connexionSubmit" data-submit="...Connexion">
                        Se connecter
                    </button>
            </fieldset>
        </form>
</div>
</body>
</html>
