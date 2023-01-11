<!DOCTYPE html>
<html>
<%@ page import="restlib.ReqHelper" %>
<%@ page import="subs.db.AppLog" %>
<%@ page import="subs.Email" %>
<%
String sid=session.getId();
String clientip=ReqHelper.getClientIpAddress(request);
String ua=request.getHeader("user-agent");
String user_id="0";
String url=(String) request.getAttribute("javax.servlet.forward.request_uri"); 
AppLog.writeAppLog(user_id, sid, "unauthenticated", "ERROR404", "IP: "+clientip+" "+url);
%>
<head>
<%@ include file="st-meta.html" %>
  <title>Subtractor - Error 404</title>
  <meta name="description" content="Stop wasting money on unused subscriptions!">
  <meta name="keywords" content="subscriptions tracker, subscriptions tracking, recurring bills">
<script src="fb.js"></script>
<%@ include file="fb-noscript.html" %>
</head>

<body class="">
<%@ include file="st-nav.html" %>
  <div class="py-5" id="about_ST">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h2 class="" contenteditable="true">Error 404</h2>
        </div>
      </div>
      <div class="row">
        <div class="col-md-8">
<h3>The requested resouce could not be found: <%=url%></h3>
          <br/>
        </div>
      </div>
      <div class="col-md-12"> </div>
    </div>
    <div class="row justify-content-start align-items-start align-self-start"> </div>
    <!--  row -->
  </div>
<%@ include file="st-footer.html" %> 
</body>

</html>