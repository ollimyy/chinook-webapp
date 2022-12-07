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
			<input name="search" type="text" required placeholder="type search term here"/>
			<input type="submit" value="Search" />
		</form><br/>
		<h2>All Artists:</h2><br/>
		<!-- "Add Artist" input box -->
		Add artist to the list:
		<form method="post">
			<input name="add" type="text" required  placeholder="type artist name here"/>
			<input type="submit" value="Add" />
		</form><br/>
		<!-- Show success message after adding artist 
		https://stackoverflow.com/questions/19972073/how-to-show-success-message-on-page-redirect-from-servlet-to-jsp -->
		<c:if test="${ !addmessage.isEmpty() }">
			<c:out value="${ addmessage }"/>
			<!-- Prevent message showing when refreshing the page after adding an artist -->
			<c:remove var="addmessage"/>
		</c:if>
		<!-- List all artists -->
		<ol>
		<c:forEach items="${ artists }" var = "artist">
			<li><a href="/albums?ArtistId=${ artist.getArtistId() }"><c:out value="${ artist.getName() }"/></a></li>
		</c:forEach>
		</ol>
	</body>
</html>