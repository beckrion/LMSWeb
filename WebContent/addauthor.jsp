<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
</head>
<body>
	<form action="AdminServlet" method="post">
	${result}
		<h2>Enter Author details below:</h2>

		Author Name: <input type="text" name="authorName"> <br>
		<button type="submit">Add Author</button>
	</form>
</body>
</html>