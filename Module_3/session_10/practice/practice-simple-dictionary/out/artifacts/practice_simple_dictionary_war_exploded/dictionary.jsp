<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12-Mar-21
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
    <%
        Map<String, String> dictionary = new HashMap<>();
    %>
    <%
        dictionary.put("blue","màu xanh");
        dictionary.put("orange","màu cam");
        dictionary.put("green","màu xanh lá");
        dictionary.put("black","màu đen");
        dictionary.put("white","màu trắng");

        String search = request.getParameter("search");
        String result = dictionary.get(search);
        if (result != null) {
            out.println("Word : "+search+"\n");
            out.println("Result : "+result);
        } else {
            out.println("Oops, not found");
        }
    %>
</body>
</html>
