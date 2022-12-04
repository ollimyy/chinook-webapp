<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<meta charset="UTF-8">
	<head>
		<title><c:out value="${ artist }"/> albums</title>
	</head>
	<body>
		<h1>Chinook</h1>
		<a href="/">Back to artists.</a><br/><br/>
		<!-- If the artist has at least one album -->
		<c:if test="${ !albums.isEmpty() }">
		<h2>Albums by <c:out value="${ artist }"/></h2>
		<ol>
		<c:forEach items="${ albums }" var = "album">
			<li><c:out value="${ album.getTitle() }"/></li>
		</c:forEach>
		</ol>
		</c:if>
		<!-- If the artist has no albums -->
		<c:if test="${ albums.isEmpty() }">
			There are no albums by <c:out value="${ artist }"/>.
		</c:if>
	</body>
</html>