<%--
  Created by IntelliJ IDEA.
  User: amanmahato
  Date: 8/12/17
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Page</title>
</head>
<body>
<p>This page is Working!</p>


<h3>Please Click</h3> <form action="/handlePresidentName"><input type="submit" value="Here"></form> <h3>to Securely stores Presidents name in a SQL table.</h3>


<h3>Please Click</h3><form action=""><input type="submit" value="Here"></form><h3>to Stores all date information (birth date, date started office, date ended office) in a time-tree (r-tree) in Neo4j</h3>

<p>
    Below are the functionality of the app.To use those features, please make sure you have clicked the above two buttons.
</p>

<h4>List all presidents, sorted by age when taking office from youngest to oldest.  Include name and age when taking office (years, months, days).</h4>
<form action="">
    <input type="submit" value="Here">
</form>
<h5>List of all presidents, sorted by the day of the month they were born, from 31 to 1.  List the day, the president's name, and the name of that president's successor in office.</h5>
<form action="">
    <input type="submit" value="Here">
</form>
</body>
</html>
