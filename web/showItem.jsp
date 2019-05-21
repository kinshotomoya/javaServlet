<%@ page import="sample.ItemBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: tomoya.kinsho
  Date: 2019-05-21
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%
    List<ItemBean> items = (List<ItemBean>) request.getAttribute("items");
%>

<html>
<head>
    <title>show all items</title>
</head>
<body>
    <table border="1">
        <tr><td>NO</td><td>商品名</td><td>値段</td></tr>
<%--        <c:forEach items="${items}" var = "item">--%>

<%--        </c:forEach>--%>
        <% for(ItemBean item : items){ %>
            <%= item.getCode() %>
            <%= item.getName() %>
            <%= item.getPrice() %> <br>
        <% } %>
    </table>
</body>
</html>
