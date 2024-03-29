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
<h1>EventList Application</h1>

<h2>All Events Listed</h2>
<%
User ted=User.getStUserByUserId("1");
ArrayList<EventListTitle> evtl=EventListTitle.getEventistTitleList();
%>
<div class="table-responsive">
<table class="table table-sm table-striped table-hover table-bordered">
<tr>
<th>Event List Title</th><th>Event List Description</th><th>Event URL Key</th>
<%
for (EventListTitle evt : evtl) {
%>
</tr><tr>
<td><%=evt.getEventTitle() %></td><td><%=evt.getEventDesc() %></td><td><a href="events.jsp?key=<%=evt.getUrlkey() %>"><%=evt.getUrlkey() %></a></td>
<% } %>
</tr>
</table>
</div>
<p>
<%
ArrayList<User> ul=User.getUserList();
%>
<h2>Users</h2>
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