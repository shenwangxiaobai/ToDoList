<%@ page import="com.mjdbsx.domain.Dbsx" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/9
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>墨迹代办-修改待办事项</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/homepage.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/dbsx.js"></script>
</head>
<body>
<div  class="panel panel-default">
    <div class="panel-body">
<%
    Dbsx d = (Dbsx)request.getAttribute("edit_dbsx");
    String[] tagname = (String[])request.getSession().getAttribute(("tagname_session"));
    String date = d.getTime().toString().substring(0,10);
    String time = d.getTime().toString().substring(11,16);
    System.out.println(date+"`````````"+time);
%>
    <form name="" method="post" action="editdbsx">
        <ul class="list-group">
            <li class="list-group-item">待办事项id<input type="text" name ="dbsxid" value="<%=d.getDbsxid()%>" readonly="readonly"></li>
            <li class="list-group-item">待办事项名称:<input type="text" name="dbsxname" value="<%=d.getDbsxname()%>"></li>
            <li class="list-group-item">Tag标签：
        <%
            for(String tg : tagname){
                String checked = "";
                if(tg.equals(d.getTagname())){
                    checked = "checked";
                }
        %>
            <input type="radio" name="tagname" <%=checked%> value=<%=tg%>><%=tg%>
        <%
            }
        %></li>
            <li class="list-group-item">提醒时间：<input type="date" name="date" value=<%=date%>><input type="time" name="time" value="<%=time%>"/></li>
            <li class="list-group-item">内容：<input type="text" name="text" value="<%=d.getText()%>"></input></li>
            <li class="list-group-item">备注：<input type="text" name="remark" value="<%=d.getRemark()%>"/></li>
            <input style="margin-left: 10%" type="submit" value="修改"/>
        </ul>
    </form>
    </div>
</div>
</body>
</html>
