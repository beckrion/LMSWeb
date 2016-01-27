<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.gcit.training.lms.service.AdministrativeService" %>
 <%@ page import="com.gcit.training.lms.service.ConnectionUtil" %>
 <%@ page import="com.gcit.training.lms.entity.Author" %>
 <%@ page import="com.gcit.training.lms.dao.AuthorDAO" %>
 <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
AdministrativeService adminService = new AdministrativeService();
List<Author> authors = adminService.getAllAuthors();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Authors in LMS Application.</title>
</head>
<body>
<table>
<tr>
	<th>Author ID</th>
	<th>Author Name</th>
	</tr>
	<%for(Author author: authors){ %>
	<tr>
		<td><%=author.getAuthorId() %></td>
		<td><%=author.getAuthorName() %></td>
		<td><button type="button">Edit Author</button>
		<td><button type="button">Delete Author</button>
	</tr>
	<%} %>
</table>

</body>
</html>