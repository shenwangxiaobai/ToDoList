<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/9
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>墨迹代办-新增待办事项</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/homepage.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/dbsx.js"></script>
</head>
<body>
<div style="margin: 0 auto;width: 100px"><span style="font-size: 30px">新增</div>
<div style="margin: 0 auto;width: 70%;margin-top: 50px">
<form action="../adddbsx" method="post">
        <ul class="list-group">
        <li class="list-group-item">待办事项名称:<input name="dbsxname" type="text"/></li>
            <ul class="list-group-item">Tag标签:
                <li class="btn-group"><input type="radio" name="tagname" value="默认"/>默认</li>
            <%
                String[] tagname = (String[])request.getSession().getAttribute("tagname_session");
                pageContext.setAttribute("tagname",tagname);
                %>
            <%
                for(String tg:tagname)
                {
                if(!tg.equals("默认")){
            %>
                <li class="btn-group"><input type="radio" name="tagname" value="<%=tg%>"><% out.write(tg);%></li>
            <%
                    }
                }
            %>
        </ul>
    </li>
            <li class="list-group-item" style="height: 100px">
                        <span>代办事项内容:</span>
                        <textarea name="text" style="height: 80px;width: 50%"></textarea>
            </li>
    <li class="list-group-item">代办事项备注:<input name="remark" type="text"/></li>
    <li class="list-group-item">提醒时刻:<input name="time01" type="date"/><input name="time02" type="time"/></li>
    </ul>
    <div style="margin-left: 45%"><input type="submit" value="新增"></div>
    </form>
</div>
</body>
</html>
