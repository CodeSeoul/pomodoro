<!DOCTYPE html>
<head>
    <title>Users</title>
     <link rel="stylesheet" type="text/css" href="/css/style.css">
     <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Barrio" />
</head>
<body>

<%@ page import="org.learn2code.seoul.pomodoro.user.domain.User" %>
<%@ page import="org.learn2code.seoul.pomodoro.user.domain.UserCleaner" %>
<%@ page import="java.util.List" %>

<h1>User List</h1>

<table align="center">
<% List<User> users = (List<User>) request.getAttribute("users"); %>
<% for (int i = 0; i < users.size(); i++) { %>
    <tr><td><a href="/users/<%=users.get(i).getId()%>"><%=UserCleaner.regexIt(users.get(i).toString())%></a></td></tr>
<% }%>
</table>

<hr/>

<form action="/users" method="POST">
    <label for="email">E-mail</label>
    <input name="email" />
    <label for="password">Password</label>
    <input name="password" />
    <input type="submit" value="Submit" />
</form>

</body>

</html>