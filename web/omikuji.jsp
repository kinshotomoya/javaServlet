<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: tomoya.kinsho
  Date: 2019-05-21
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
op0;
//    void printResult(String result) {
//        System.out.println(result + "ですよね。おめでとう！");
//    }

    String omikuji() {
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        String result = null;

        switch (dice) {
            case 1:
                result = "大吉";
                break;
            case 2:
                result = "小吉";
                break;
            case 3:
                result = "凶";
                break;
            default:
                result = "吉";
                break;
        }
        return result;
    }

%>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    あなたは、<%= omikuji() %>です。
</head>
<body>

</body>
</html>
