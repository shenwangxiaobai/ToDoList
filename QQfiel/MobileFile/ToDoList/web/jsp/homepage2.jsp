<%@ page import="com.mjdbsx.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/22
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no" >
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../css/yanse.css">
    <style>
        body{
            background-image: url('../img/bear.jpg');
            user-select: none;
            background-repeat: repeat;
            background-position: 90% 60%;
            overflow: hidden;
         }
        .dab{
            overflow: hidden;
        }
        .dab a{
            float: right;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/dbsx.js"></script>
    <script type="text/javascript" src="../js/homepage.js"></script>
    <script>
        var height = $(window).height;
        var width = $(window).width;
        console.log(height+"--"+width)
    </script>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../jsp/header.jsp"></jsp:include>
</div>
<div class="container-fluid">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" style="font-family: 华文新魏 Serif;font-weight: bolder;" href="#">Taken选择:</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a name="token" href="#">全部</a></li>
                    <li class=""><a name="token" href="#">ToDo</a></li>
                    <li class=""><a name="token" href="#">Done</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container-fluid">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" style="font-family: 华文新魏 Serif;font-weight: bolder;" href="#">Tag选择:</a>
            </div>
            <div>
                <ul id="Tagchoose" class="nav navbar-nav">
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container-fluid" style="width: 80%" >
    <div class="panel panel-default" style="background-color: transparent">
        <div class="row" style="border:none">
            <div class="col-lg-2">
            </div>
            <div class="col-lg-8" id = "dbsxbody" style="overflow: scroll;height: 450px;overflow-x: hidden;" >
            </div>
            <div class="col-lg-2">
            </div>
        </div>
    </div>
</div>
<%
    User user=(User) request.getSession().getAttribute("user");
    String phonenumber = user.getPhonenumber();
    String username = user.getUsername();
%>
<input hidden id="p" value="<%=phonenumber%>">
<input hidden id="u" value="<%=username%>">
<jsp:include page="tailer.jsp"></jsp:include>
</body>
</html>
