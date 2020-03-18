<%@ page import="com.mjdbsx.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/9
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>墨迹代办-Tag管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <link rel="stylesheet" href="../font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../css/yanse.css">
    <style>
        body{
            background-image: url('../img/bear.jpg');
            background-size: 100%;
            background-position: 20% 70%;
            user-select: none;
        }
        .backimg{
            background-image: url('../img/bear.jpg');
            background-size: 100%;
            background-position: 20% 70%;
        }
        .panel-body ul {
            border: none;
        }
        .panel-body ul li{
            background-color: transparent;
            border: none;
        }
        .hhh1{
            border-radius: 5px;
            background-color: #1b6d85;
            color: white;
            opacity: 90%;
        }
        .hhh2{
            border-radius: 5px;
            background-color: #a94442;
            color: white;
            opacity: 90%;
        }
        .hhh3{
            border-radius: 5px;
            background-color: #3e8f3e;
            color: white;
            opacity: 90%;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/tagmanager.js"></script>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../jsp/header.jsp"></jsp:include>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-2"></div>
        <div id="selecttag" class="col-lg-4 backimg"style="overflow: scroll;height: 440px;overflow-x: hidden;">
        </div>
        <div class="col-lg-4 backimg">
            <div class=" panel-body">
                <ul class="list-group">
                    <i class="fa fa-tag"></i>
                    <li class="list-group-item">
                        <input type="text" name="newtagname" id="newname">
                        <button class="hhh3" name="addtagname" value="新增">新增Tag</button>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
</body>
</html>
