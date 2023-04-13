<!--View jsp page that submits data to AddController in C_66_Insert.java -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String popUpMsg = (String) request.getAttribute("popUpMsg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
<link rel="stylesheet" type="text/css" href="mycss.css">
</head>
<body>
	<h1>Add a New Friend</h1>
	<form method="post" action="AddController">
		<label for="friendName">Friend Name:</label> 
		<input type="text" id="friendName" name="friendName" value="<%= request.getAttribute("friendName") != null ? request.getAttribute("friendName") : "" %>"><br>
		<br> <label for="emailAddress">Email Address:</label> 
		<input type="email" id="emailAddress" name="emailAddress" value="<%= request.getAttribute("emailAddress") != null ? request.getAttribute("emailAddress") : "" %>"><br>
		<br> <label for="age">Age:</label> 
		<input type="number" id="age" name="age" value="<%= request.getAttribute("age") != null ? request.getAttribute("age") : "" %>"><br>
		<br> <label for="favoriteColor">Favorite Color:</label> 
		<input type="text" id="favoriteColor" name="favoriteColor" value="<%= request.getAttribute("favoriteColor") != null ? request.getAttribute("favoriteColor") : "" %>"><br>
		<!-- displays empty field submission error if present back from the controller through request object -->
		<% if(popUpMsg != null) { %>
			<div class="error"><%= popUpMsg %></div>
		<%}else{ %>
			<div></div>
		<%} %>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>