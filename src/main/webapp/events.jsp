<%@ page import="java.util.ArrayList" %>
<%@ page import="events.db.User" %>
<%@ page import="events.db.EventList" %>
<%@ page import="events.db.EventListTitle" %>
<%
String key=request.getParameter("key");
String evlid=request.getParameter("evlid");
if (evlid == null) evlid="1";
EventListTitle evt=null;
if (key != null) {
	evt=EventListTitle.getEventistTitleByKey(key);
	evlid=evt.getEventListId();
}
else
	evt=EventListTitle.getEventistTitleById(evlid);
EventListTitle.getEventistTitleById(evlid);
ArrayList<EventList> evl=EventList.getEventistById(evlid);
String uid=evt.getUserId();
User ted=User.getStUserByUserId("1");
String uname=ted.getUsername();
%>
<html>
<head>
<title><%=uname%> Event List</title>
<title>Event List Config</title>
<%@ include file="../meta.html" %>
</head>

<body>
<%@ include file="../menu.html" %>
<script>set_tab("events");</script>
<%@ include file="start-mid10.html" %>
<h1><%=evt.getEventDesc()%></h1>

<div class="table-responsive">
<table class="table table-sm table-striped table-hover table-bordered">
<tr>
<th colspan="3"><%=evt.getEventTitle() %></th>
</tr><tr>
<th><%=evt.getEvdateHdr() %></th><th><%=evt.getEvnameHdr() %></th><th><%=evt.getEvlocationHdr() %></th>
<%
for (EventList ev : evl) {
%>
</tr><tr>
<td><%=ev.getEvdate() %></td><td><%=ev.getEvname() %></td><td><%=ev.getEvlocation() %></td>
<% } %>
</table>
</div>

<%@ include file="end-page.html" %>
</body>
</html>