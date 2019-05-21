<%--
  Created by IntelliJ IDEA.
  User: tomoya.kinsho
  Date: 2019-05-21
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ipAddress = request.getRemoteAddr();
    String Uri = request.getRequestURI();
    String httpMethod = request.getMethod();
    String browser = request.getHeader("User-Agent");
    String availableFile = request.getHeader("Accept");
    String language = request.getHeader("Accept-Language");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <%= ipAddress %><br>
    <%= Uri %><br>
    <%= httpMethod %><br>
    <%= browser %><br>
    <%= availableFile %><br>
    <%= language %>
</head>
<body>

</body>
</html>
