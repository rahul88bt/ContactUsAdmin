
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.Rahul.Request" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Active User</h2>
	<table border="1">
		<tr>
	  		<th>id</th>
		    <th>name</th>
		    <th>email</th>
		    <th>message</th>
		    <th>status</th>
	  	</tr>
	  	<%
    	List<Request> activeUser = (List<Request>) 
    	request.getAttribute("activeUser");
    	if (activeUser != null) {
        	for (Request dataObject : activeUser) {
            	out.println("<tr>");
             	out.println("<td>" + dataObject.getId() + "</td>");
            	out.println("<td>" + dataObject.getName() + "</td>");
            	out.println("<td>" + dataObject.getEmail() + "</td>");
            	out.println("<td>" + dataObject.getMessage() + "</td>");%>
            	<td><form action="DashboardServlet" method="post">
            	<input type="hidden" name="id" value="<%= dataObject.getId()%>">
               	<input type="hidden" name="status" value="false">
            	<input type="submit" value="Archive">
            	</form></td> 
            	<% out.println("</tr>");
        	}
    	}
    	%>
	</table>
	<br>
	<br>
	
	
	<h2>Archive User</h2>
	
	<table border="1">
	  	<tr>
	  		<th>id</th>
		    <th>name</th>
		    <th>email</th>
		    <th>message</th>
		    <th>status</th>
	  	</tr>
	  	<%
    	List<Request> archiveUser = (List<Request>) 
    	request.getAttribute("archiveUser");
    	if (archiveUser != null) {
        	for (Request dataObject : archiveUser) {
            	out.println("<tr>");
             	out.println("<td>" + dataObject.getId() + "</td>");
            	out.println("<td>" + dataObject.getName() + "</td>");
            	out.println("<td>" + dataObject.getEmail() + "</td>");
            	out.println("<td>" + dataObject.getMessage() + "</td>");%>
            	<td><form action="DashboardServlet" method="post">
            	<input type="hidden" name="id" value="<%= dataObject.getId()%>">
               	<input type="hidden" name="status" value="true">
            	<input type="submit" value="Active">
            	</form></td> 
            	<% out.println("</tr>");
        	}
    	}
    	%>
	</table>
	
</body>
</html>