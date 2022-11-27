<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<meta charset="UTF-8">
	<head>
		<title>Chinook Artist List</title>
	</head>
	<body>
		<h1>All Artists:</h1>
		<ol>
		<c:forEach items="${ artists }" var = "artist">
			<li><c:out value="${ artist.getName() }"/></li>
		</c:forEach>
		</ol>
	</body>
</html>