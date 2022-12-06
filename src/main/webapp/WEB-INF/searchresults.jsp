<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<meta charset="UTF-8">
	<head>
		<title>Chinook</title>
		<!-- https://github.com/oxalorg/sakura -->
		<link rel="stylesheet" href="/styles/sakura.css" type="text/css">
	</head>
	<body>
		<h1>Chinook</h1>
		<!-- Search box -->
		Search artists and albums:
		<form method="post">
			<input name="search" type="text" required value="${ searchterm }"/>
			<input type="submit" value="Search" />
		</form><br/>
		<a href="/">&#11013 Back to artists.</a><br/><br/>
		<h5>Results for "<c:out value="${ searchterm }"/>":</h5>
		<h4>Artists:</h4>
		<c:if test="${ artists.isEmpty() }">
			<p>No artists found for "<c:out value="${ searchterm }"/>".</p>
		</c:if>
		<ol>
		<c:forEach items="${ artists }" var = "artist">
			<li><a href="/albums?ArtistId=${ artist.getArtistId() }"><c:out value="${ artist.getName() }"/></a></li>
		</c:forEach>
		</ol>
		<h4>Albums:</h4>
		<c:if test="${ albums.isEmpty() }">
			<p>No albums found for "<c:out value="${ searchterm }"/>".</p>
		</c:if>
		<ol>
		<c:forEach items="${ albums }" var = "album">
			<li><a href="/albums?ArtistId=${ album.getArtistId() }"><c:out value="${ album.getTitle() }"/></a> by <c:out value="${ albumartists.get(album.getTitle()) }"/></li>
		</c:forEach>
		</ol>
	</body>
</html>