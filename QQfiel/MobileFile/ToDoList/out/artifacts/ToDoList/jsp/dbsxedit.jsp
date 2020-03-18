<%@ page import="com.mjdbsx.domain.Dbsx" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.mjdbsx.domain.User" %><%--
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
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <style>
        body{
            background-image: url('../img/bear.jpg');
            background-size: 100%;
            user-select: none;
        }
    </style>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/dbsx.js"></script>
    <script type="text/javascript" src="../js/dbsxedit.js"></script>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../jsp/header.jsp"></jsp:include>
</div>
<div  class="panel panel-default">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <div class="panel-body">
                <form name="" method="post" action="editdbsx">
                    <ul class="list-group">
                        <li class="list-group-item active">待办事项ID:
                            <a style="color: white" name="dbsxid"><%=request.getParameter("dbsxid")%></a>
                        </li>
                        <li class="list-group-item">待办事项名称:<input type="text" name="dbsxname"></li>
                        <li class="list-group-item" >Tag标签：
                            <div  id="tagBianQian" style="background-color: white"></div>
                        </li>
                        <li class="list-group-item">内容：<input type="text" name="text"></input></li>
                        <li class="list-group-item">备注：<input type="text" name="remark" width="300%"/></li>
                        <li class="list-group-item">
                            <input id="first" type="checkbox" name="first" value="0">不重复
                            <input type='checkbox' name='week' value='1'>每周一
                            <input type='checkbox' name='week' value='2'>每周二
                            <input type='checkbox' name='week' value='3'>每周三
                            <input type='checkbox' name='week' value='4'>每周四
                            <input type='checkbox' name='week' value='5'>每周五
                            <input type='checkbox' name='week' value='6'>每周六
                            <input type='checkbox' name='week' value='7'>每周日
                        </li>
                        <li class="list-group-item">提醒时间：
                            <span id="date"></span>
                            <input type="time" name="time"/>
                        </li>
                        <li class="list-group-item"><input class="btn btn-primary" id="xiugai" style="margin-left: 45%" type="button" value="修改"/></li>
                    </ul>
                </form>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
</body>
</html>
