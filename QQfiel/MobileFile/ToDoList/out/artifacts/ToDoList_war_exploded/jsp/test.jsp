<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/9
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<%
    String[] tagname = (String[])request.getAttribute("dbsxidinfo");
    for(String tg:tagname)
    {
%>
<li><a href=""><% out.write(tg);%></a></li>
<%
    }
%>
</ul>
</body>
</html>
