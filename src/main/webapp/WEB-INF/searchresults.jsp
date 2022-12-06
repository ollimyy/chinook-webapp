<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<meta charset="UTF-8">
	<head>
		<title>Chinook</title>
	</head>
	<body>
		<h1>Chinook</h1>
		<a href="/">Back to artists.</a><br/><br/>
		<h2>Results for <c:out value="${ searchterm }"/>:</h2>
		<h3>Artists:</h3>
		<c:if test="${ artists.isEmpty() }">
			<p>No artists found for "<c:out value="${ searchterm }"/>".</p>
		</c:if>
		<ol>
		<c:forEach items="${ artists }" var = "artist">
			<li><a href="/albums?ArtistId=${ artist.getArtistId() }"><c:out value="${ artist.getName() }"/></a></li>
		</c:forEach>
		</ol>
		<h3>Albums:</h3>
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