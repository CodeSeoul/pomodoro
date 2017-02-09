<!DOCTYPE html>
<head>
    <title>User Update</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
         <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Barrio" />
</head>
<body>

<%@ page import="org.learn2code.seoul.pomodoro.user.domain.User" %>
<%@ page import="java.util.List" %>

<h1>User Update</h1>

<% User user = (User) request.getAttribute("user"); %>

<form action="/users/<%=user.getId()%>/update" method="POST">
    <input type="hidden" value="<%=user.getId()%>"/>
    <label for="email">E-mail</label>
    <input name="email" value="<%=user.getEmail()%>"/>
    <label for="password">Password</label>
    <input name="password" value="<%=user.getPassword()%>"/>
    <input type="submit" value="Submit" />
</form>
<a href="/users">Back</a>

</body>

</html>