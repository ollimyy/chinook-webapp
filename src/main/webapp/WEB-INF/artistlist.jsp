<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<meta charset="UTF-8">
	<head>
		<title>Chinook Artist List</title>
	</head>
	<body>
		<h1>Chinook</h1>
		<form method="post">
			<input name="search" type="text" required placeholder="type search term here..."/>
			<input type="submit" value="Search" />
			</form><br/>
		<h2>All Artists:</h2>
		<form method="post">
			<input name="add" type="text" required  placeholder="type artist name here..."/>
			<input type="submit" value="Add to list" />
		</form><br/>
		<ol>
		<c:forEach items="${ artists }" var = "artist">
			<li><a href="/albums?ArtistId=${ artist.getArtistId() }"><c:out value="${ artist.getName() }"/></a></li>
		</c:forEach>
		</ol>
	</body>
</html>