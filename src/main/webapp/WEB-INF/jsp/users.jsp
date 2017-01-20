<!DOCTYPE html>
<head>
    <title>Users</title>
</head>
<body>

<%@ page import="org.learn2code.seoul.pomodoro.user.domain.User" %>
<%@ page import="java.util.List" %>

<h1>User List</h1>

<ul>
<% List<User> users = (List<User>) request.getAttribute("users"); %>
<% for (int i = 0; i < users.size(); i++) { %>
    <li><a href="/users/<%=users.get(i).getId()%>"><%=users.get(i).toString()%></a></li>
<% }%>
</ul>

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