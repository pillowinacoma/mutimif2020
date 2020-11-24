<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<%@ page import="fr.univlyon1.m1if.m1if10.model.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.sql.Date" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">

		<title></title>

		<meta name="description" content="un affichage d'evenements à travers instagram">
		<meta name="author" content="Abdelaziz Sbaai">

		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">

		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="stylesheet" href="lib/reveal/dist/reset.css">
		<link rel="stylesheet" href="lib/reveal/dist/reveal.css">
		<link rel="stylesheet" href="lib/reveal/dist/theme/moon.css" id="theme">
		<link rel="stylesheet" href="css/post.css">

		<!-- Theme used for syntax highlighting of code -->
		<link rel="stylesheet" href="lib/reveal/plugin/highlight/monokai.css" id="highlight-theme">

</head>

	<body>

		<div class="reveal">

			<!-- Any section element inside of this container is displayed as a slide -->
			<div class="slides">
				<section >
					<a href="https://forge.univ-lyon1.fr/p1807434/multimif2020">
						<img src="img/redincWhite.png" alt="reveal.js logo" style="height: 100%;background: transparent;" class="demo-logo">
					</a>
					<h5>The Instagram event display tool</h5>
					<p>
						<small>Created by <a href="https://forge.univ-lyon1.fr/p1807434/multimif2020/-/wikis/team"> us</a> </small>
					</p>
				</section>
				<c:forEach items="${eventList}" var="event">
					<section data-background-opacity=".3" data-background-image="https://www.eventnroll.com//assets/home/bg-mobile.jpg">
						<section>
							<h2 id="h2"><c:out value="${event.name}"/></h2>
							<p><c:out value="${event.description}"/></p>
						</section>
					</section>
					<c:forEach items="${event.hashtags}" var="hashtag">
					<section>								
						<c:forEach items="${hashtag.posts}" var="posty" varStatus="status">
							<section>
								<a href="https://www.instagram.com/explore/tags/<c:out value="${hashtag.name}"/>/">#<c:out value="${hashtag.name}"/></a>
								<p class="username">@<c:out value="${posty.name}"/> : </p>
								<p class="caption"><c:out value="${posty.description}"/></p>
								<img class="r-stretch" src="<c:out value="${posty.url}"/>">
							</section>
						</c:forEach>
					</section>	
					</c:forEach>
				</c:forEach>


			</div>

		</div>

		<script src="lib/reveal/dist/reveal.js"></script>
		<script>
			Reveal.initialize({
				controls: false,
				progress: true,
				center: true,
				hash: true,
				autoSlideStoppable: false,
				autoSlide: 2000,
				loop: true,
			});
		</script>

	</body>
</html>
