<%@ page import="java.util.ArrayList" %>
<%@ page import="events.db.User" %>
<%@ page import="events.db.EventListTitle" %>
<html>
<head>
<title>Events List</title>
<%@ include file="meta.html" %>
</head>

<body>
<%@ include file="menu.html" %>
<script>set_tab("home");</script>
<%@ include file="start-mid10.html" %>
<h1>EventList Members</h1>

<%
ArrayList<User> ul=User.getUserList();
%>
<h2>Members</h2>
<div class="table-responsive">
<table class="table table-sm table-striped table-hover table-bordered">
<tr>
<th>Username</th><th>Name</th><th>User ID</th><th>E-mail</th>
<%
for (User u : ul) {
%>
</tr><tr>
<td><a href="user.jsp?username=<%=u.getUsername()%>"><%=u.getUsername() %></a></td><td><%=u.getFirstname() %> <%=u.getLastname() %></td><td><a href="user.jsp?userid=<%=u.getUserId() %>"><%=u.getUserId() %></a></td><td><%=u.getEmail() %></td>
<% } %>
</tr>
</table>
</div>
<%@ include file="end-page.html" %>
</body>
</html>