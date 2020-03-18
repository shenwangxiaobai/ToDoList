<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/9
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>墨迹代办-注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../css/login.css">
    <style>
        body{
                    background-image: url('../img/h.jpg');
                    background-size: 100%;
                    overflow:hidden;
                    z-index: -10;
                    background-position:20% 80%;
                    min-height: 300px;
                    min-width: 500px;
                    user-select: none;
                }
</style>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/register.js" charset="UTF-8"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row" style="height: 20%">
        <div class="col-lg-5"></div>
        <div class="col-lg-2" style="height: 100%">
        </div>
        <div class="col-lg-5"></div>
    </div>
    <div class="row" style="height: 60%">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form method="get" action="../register" autocomplete="off">
                <div class="panel panel-default moji2" >
                    <div class="panel-heading" style="background-color: transparent">
                        <div>
                            <p style="font-size: 200%; font-family: 华文琥珀;text-align: center;margin-bottom: 0">墨迹代办</p>
                        </div>
                    </div>
                    <div  class="panel-body" style=" height:80%;position: relative">
                        <input hidden type="password">
                        <div style="height: 20%;position: absolute;top: 10%;left: 20%">
                            <p style="width: 106px;display: inline;letter-spacing: 8px">账号:</p>
                            <input id="phonenumber" type="text" name="phonenumber" oninput="value=value.replace(/[^\d]/g,'')" maxlength="11" required autocomplete="off"/>
                        </div>
                        <div id="phonenumberinfo" style="height: 15%;position: absolute;top:20%;left: 37%">
                        </div>
                        <div style="height: 20%;position: absolute;top:30%;left: 20%">
                            <p style="width: 106px;display: inline;letter-spacing: 8px">昵称:</p>
                            <input id="username" type="text" name="username" required autocomplete="off"/>
                        </div>
                        <div id="usernameinfo" style="height: 15%;position: absolute;top:40%;left: 37%">
                        </div>
                        <div style="height: 20%;position: absolute;top: 50%;left: 20%">
                            <p style="width: 106px;display: inline;letter-spacing: 8px">密码:</p>
                            <input id="password" type="password" name="password" required autocomplete="new-password" style="ime-mode:disabled">
                        </div>
                        <div id="passwordinfo" style="height: 15%;position: absolute;top:60%;left: 37%">
                        </div>
                        <div style="height: 20%;position: absolute;top: 70%;left: 20%">
                            确认密码:<input id="repassword" type="password"required autocomplete="new-password" style="ime-mode:disabled">
                        </div>
                        <div id="repasswordinfo" style="height: 15%;position: absolute;top:80%;left: 37%">
                        </div>
                        <div style="height: 20%;position: absolute;top: 87%;left: 0%">
                            <div id="tologin" hidden style="font-size: 12px;color: red">返回登录页面</div>
                            <a id="yy" href="../jsp/login.jsp">
                                <i class="glyphicon glyphicon-share-alt" style="transform: rotateY(180deg)"></i></a>
                            <script>
                                $("#yy").on("mouseenter",function () {
                                    $("#tologin").removeAttr("hidden")
                                });
                                $("#yy").on("mouseleave", function () {
                                    $("#tologin").attr("hidden","hidden")
                                });
                            </script>
                        </div>
                        <div style="height: 20%;position: absolute;top: 87%;left: 45%">
                            <input id="register" hidden class="btn btn-primary" type="submit" value="注册"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-4"></div>
        </div>
    </div>
</body>
</html>
