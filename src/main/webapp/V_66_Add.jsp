<!-- User login form  = passes control to controller i.e. EmployeeController.java-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<label for="friendName">Friend Name:</label> <input type="text" id="friendName" name="friendName"><br>
		<br> <label for="emailAddress">Email Address:</label> <input type="email" id="emailAddress" name="emailAddress"><br>
		<br> <label for="age">Age:</label> <input type="number" id="age" name="age"><br>
		<br> <label for="favoriteColor">Favorite Color:</label> <input type="text" id="favoriteColor" name="favoriteColor"><br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>