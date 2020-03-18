<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/3/16
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.mjdbsx.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="font-family: 华文琥珀;font-size: 35px">
                墨迹代办
            </a>
        </div>
        <div>
            <ul class="nav navbar-nav" style="font-size: 25px;font-family:华文隶书;font-weight: bolder">
                <li><a href="../jsp/homepage2.jsp">主页</a></li>
                <li><a href="../jsp/day_month.jsp">今日待办</a></li>
                <li><a href="../jsp/tagmanage.jsp"> Tag管理</a></li>
                <li><a href="../jsp/adddbsx.jsp">新增</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li style="font-size: 25px;font-family: 华文隶书">
                    <a name="quit" href="#" style="color: white">你好:<%
                        User u = (User)request.getSession().getAttribute("user");
                    %><%=u.getUsername()%></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>
