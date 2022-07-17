<%@ page import="events.db.User" %>
<html>
<head>
<title>Event Dummy</title>
</head>

<body>
<h1>Dummy Event</h1>
This is some dummy text.<br/>
<br/>
<%
User ted=User.getStUserByUserId("1");
%>
Name: <%=ted.getFirstname()%> <%=ted.getLastname() %><br/>
Username: <%=ted.getUsername() %>  <br/>
UserID: <%=ted.getUserId() %>
</body>
</html>