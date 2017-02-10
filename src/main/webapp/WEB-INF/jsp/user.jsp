<!DOCTYPE html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
         <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Barrio" />
</head>
<body>

<%@ page import="org.learn2code.seoul.pomodoro.user.domain.User" %>

<% User user = (User) request.getAttribute("user"); %>

<h1>User Details</h1>

<ul>
    <li>ID: <%=user.getId()%></li>
    <li>E-mail: <%=user.getEmail()%></li>
    <li>Password: <%=user.getPassword()%></li>
</ul>

<form method="GET" action="/users/<%=user.getId()%>/delete">
    <input type="hidden" value="<%=user.getId()%>"/>
    <input type="submit" value="delete"/>
    <a href="/users/<%=user.getId()%>/update">Update</a>
</form>
<a href="/users">Back</a>

</body>

</html>