<!--View jsp page that redirects to AddFormController in C_66_Insert.java through a link-->
<!--View jsp page that redirects to DeleteController in C_66_Delete.java passing the respective id for the row to be deleted-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String[][] friendsInfo = (String[][]) request.getAttribute("friendsInfo");
String popUpMsg = (String) request.getAttribute("popUpMsg");
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
            <th>Action</th>
        </tr>
        <% for (String[] friend : friendsInfo) { %>
        <tr>
            <td><%= friend[0] %></td>
            <td><%= friend[1] %></td>
            <td><%= friend[2] %></td>
            <td><%= friend[3] %></td>
            <td><%= friend[4] %></td>
            <td><a class= "delete-link" href="DeleteController?id=<%= friend[0] %>">Delete</a></td>
        </tr>
        <% } %>
    </table>
    <section><a href="AddFormController" class="view-link">Add a new friend!</a></section>
    <!-- display successful add and delete alerts coming from the controllers -->
    <% if(popUpMsg != null) { %>
    <script type="text/javascript">
        alert('<%= popUpMsg %>');
    </script>
    <% } %>
</body>
</html>