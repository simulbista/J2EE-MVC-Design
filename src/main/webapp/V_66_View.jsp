<!-- User login form  = passes control to controller i.e. EmployeeController.java-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[][] friendsInfo = (String[][]) request.getAttribute("friendsInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
<link rel="stylesheet" type="text/css" href="mycss.css">
</head>
<body>
<h1>Simul's Friends</h1>
<table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Favorite Color</th>
        </tr>
        <% for (String[] friend : friendsInfo) { %>
        <tr>
            <td><%= friend[0] %></td>
            <td><%= friend[1] %></td>
            <td><%= friend[2] %></td>
            <td><%= friend[3] %></td>
            <td><%= friend[4] %></td>
        </tr>
        <% } %>
    </table>
    <a href="AddFormController">Add a new friend!</a>
</body>
</html>