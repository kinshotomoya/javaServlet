<%@ page import="sample.PlusBean" %><%--
  Created by IntelliJ IDEA.
  User: tomoya.kinsho
  Date: 2019-05-21
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PlusBean bean = (PlusBean) request.getAttribute("plus");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%= bean.getValue1() %> + <%= bean.getValue2() %> = <%= bean.getAnswer() %>

</body>
</html>
