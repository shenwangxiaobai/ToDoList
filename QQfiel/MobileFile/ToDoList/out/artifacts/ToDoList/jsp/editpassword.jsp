<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/19
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <style>
        body{
            background-image: url('../img/h.jpg');
            background-size: 100%;
            overflow:hidden;
            z-index: -10;
            background-position:20% 80%;
            min-height: 300px;
            min-width: 500px;"
            user-select: none;
        }
        .moji{
            background-image: url('../img/mo.jpg');
            background-size: 100%;
            z-index: -1;
        }
        input{
            border: none;
            border-bottom: 1px solid #a94442;
            outline:none;
            background-color: transparent;
            border-bottom-right-radius: 10px 50%;
            border-bottom-left-radius: 10px 50%;
            transition: background-color 5000s ease-in-out 0s;
            text-indent: 1em;
        }
        input:focus{
            color: #c7254e;
        }
        #savepassword{
            text-indent: 0;
        }
        #editpassword{
            text-indent: 0px;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/dbsx.js"></script>
    <script type="text/javascript" src="../js/editpaasword.js"></script>
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
        <div class="col-lg-4" style="">
            <form method="get" action="login2">
                <div class="panel panel-default moji">
                    <div class="panel-heading" style="background-color: transparent;">
                        <div>
                            <p style="font-size: 200%; font-family: 华文琥珀;text-align: center;margin-bottom: 0">墨迹代办</p>
                        </div>
                    </div>
                    <div  class="panel-body" style=" height:60%;position: relative">
                        <div id="zhanghao" style="height: 30%;position: absolute;top: 20%;left: 20%">
                            账号：<input id="phonenumber" maxlength="11" type="text" name="phonenumber" oninput="value=value.replace(/[^\d]/g,'')" />
                        </div>
                        <div id="nichen" style="height: 30%;position: absolute;top: 40%;left: 20%">
                            昵称：<input id ="username" type="text" name="username">
                        </div>
                        <div style="height: 20%;position: absolute;top: 60%;left: 0%">
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
                        <div id="xiugai" style="height: 30%;position: absolute;top: 60%;left: 45%">
                            <input id="editpassword" class="btn btn-primary" type="button" value="确认"/>
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
