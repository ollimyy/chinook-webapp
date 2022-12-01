<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<meta charset="UTF-8">
	<head>
		<title>Chinook Artist List</title>
	</head>
	<body>
		<h1>All Artists:</h1>
		<form method="post">
			<input name="name" type="text" required placeholder="type artist name here..." autofocus />
			<input type="submit" value="Add to list" />
		</form><br/>
		<ol>
		<c:forEach items="${ artists }" var = "artist">
			<li><c:out value="${ artist.getName() }"/></li>
		</c:forEach>
		</ol>
	</body>
</html>