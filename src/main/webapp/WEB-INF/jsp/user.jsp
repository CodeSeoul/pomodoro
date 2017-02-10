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

<table align="center">
    <tr><td>ID: <%=user.getId()%></td>
    <td>E-mail: <%=user.getEmail()%></td>
    <td>Password: <%=user.getPassword()%></td>
</table>

<form style="float:left;padding-left:44%;background: #D2E9FF;" method="GET" action="/users/<%=user.getId()%>/update">
    <input type="submit" value="Update"/>
</form>
<form style="display:inline;align:center;" method="GET" action="/users/<%=user.getId()%>/delete">
    <input type="hidden" value="<%=user.getId()%>"/>
    <input type="submit" value="Delete"/>
</form>
<form style="display:inline;"method="GET" action="/users">
    <input type="submit" value="Back"/>
</form>
</body>

</html>