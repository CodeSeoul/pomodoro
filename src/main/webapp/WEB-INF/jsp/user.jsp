<!DOCTYPE html>
<head>
    <title>Users</title>
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

</body>

</html>