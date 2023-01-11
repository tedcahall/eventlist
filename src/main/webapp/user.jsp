<%@ page import="java.util.ArrayList" %>
<%@ page import="events.db.User" %>
<%@ page import="events.db.EventList" %>
<%@ page import="events.db.EventListTitle" %>
<%
String username=request.getParameter("username");
String userid=request.getParameter("userid");
if (userid == null) userid="1";
User u=null;
if (username != null) {
	u=User.getStUserByUsername(username);
	userid=u.getUserId();
}
else {
	u=User.getStUserByUserId(userid);
	username=u.getUsername();
}
// EventListTitle.getEventistTitleById(evlid);
ArrayList<EventListTitle> evtl=EventListTitle.getEventistTitleListByUserId(userid);
// String uid=evt.getUserId();
User ted=User.getStUserByUserId("1");
String uname=ted.getUsername();
%>
<html>
<head>
<title><%=username%> Event List</title>
<%@ include file="../meta.html" %>
</head>

<body>
<%@ include file="../menu.html" %>
<script>set_tab("events");</script>
<%@ include file="start-mid10.html" %>
<h1><%=username%> Event List</h1>

<div class="table-responsive">
<table class="table table-sm table-striped table-hover table-bordered">
<tr>
<th colspan="3"><%=username%> Event List</th>
</tr><tr>
<th>Title</th><th>Description</th><th>URL Key</th>
<%
for (EventListTitle evt : evtl) {
%>
</tr><tr>
<td><%=evt.getEventTitle() %></td><td><%=evt.getEventDesc() %></td><td><%=evt.getUrlkey() %></td>
<% } %>
</table>
</div>

<%@ include file="end-page.html" %>
</body>
</html>