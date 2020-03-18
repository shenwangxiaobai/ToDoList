<%@ page import="com.mjdbsx.domain.User" %>
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
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <style>
        body{
            background-image: url('../img/bear.jpg');
            background-size: 100%;
            background-position: 20% 70%;
            user-select: none;
        }
    </style>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/dbsx.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(document).on("blur","[name='time02']",function () {
                var time02 = $("[name='time02']").val();//输入时间
                var date = new Date();
                var aa = new Date(+new Date()+8*3600*1000).toISOString().replace(/T/g,' ').replace(/\.[\d]{3}Z/,'');
                //当前时间
                var local_date = aa.substring(0,10);
                var local_time = aa.substring(11,16);
                var date01 = $("[name='time01']").val();
                //输入日期
                if(local_date>date01){
                    alert("提醒日期小于当前日期:请重新输入！");
                    $("[name='time01']").val("");
                }else if(local_date == date01){
                    if(local_time>=time02) {
                        alert("时间设置不足！");
                        $("[name='time02']").val("");
                    }
                }
            })
        })
        $(window).on("load",function(){
            //后台获取标签加载到页面
            $.ajax({
                url: "../homepage2",
                type: "get",
                data: {
                    choose: "initial",
                },
                dataType: "json",
                success: function (date) {
                    $("#tagBianQian").empty();
                    $("#tagBianQian").append("<input type='radio' name='tagname' value='默认'>默认"+'&nbsp;&nbsp;');
                    for (var index = 0; index < date.length; index++) {
                        if (date[index] != "默认") {
                            $("#tagBianQian").append("<input type='radio' name='tagname' value='"+date[index]+"'>" + date[index]+"&nbsp;&nbsp;")
                        }
                    }
                    var tagnames = document.getElementsByName("tagname");
                    for (var i = 0; i < tagnames.length; i++) {
                        if(tagnames[i].getAttribute("value")!="默认") {
                            tagnames[i].removeAttribute("checked");
                        }else {
                            tagnames[i].setAttribute("checked", "ckecked");
                        }
                    }
                },
                error: function () {
                    alert("数据读取失败");
                },
            });
            //获取标签
            //初始化为默认
            var choosetag = "默认";
            //选择tag标签
            $(document).on("click","[name='tagname']",function () {
                var tagnames = document.getElementsByName("tagname");
                for (var i = 0; i < tagnames.length; i++) {
                    tagnames[i].removeAttribute("checked");
                }
                $(this).attr("checked","checked");
                choosetag = $(this).val();
            })
            //重复事件
            $(document).on("click","#noweek",function () {
                if($(this).attr("checked")) {
                    $(this).attr("checked",false)
                    $("#weekdchoose").empty();
                    $("#weekdchoose").append(
                        "<input type='checkbox' name='week' value='1'>每周一"+
                        "<input type='checkbox' name='week' value='2'>每周二"+
                        "<input type='checkbox' name='week' value='3'>每周三"+
                        "<input type='checkbox' name='week' value='4'>每周四"+
                        "<input type='checkbox' name='week' value='5'>每周五"+
                        "<input type='checkbox' name='week' value='6'>每周六"+
                        "<input type='checkbox' name='week' value='7'>每周日"
                    );
                    $("#date").empty();
                    $("#date").append(
                        "<input class='form-control'name='time02'type='time'>")

                }else {
                    $(this).attr("checked",true)
                    $("#weekdchoose").empty();
                    $("#date").empty();
                    $("#date").append(
                        "<input class='form-control' type='date' name='time01'>"+
                        "<input class='form-control'name='time02'type='time'>"
                    )
                }
            })
            //添加事件
            $(document).on("click","#adddbsx",function(){
                var week = '';
                $('input[name="week"]:checked').each(function(){
                    week+=$(this).val()+"";
                });
                $.ajax({
                    url: "../adddbsx",
                    type: "get",
                    data: {
                        dbsxname: $("[name='dbsxname']").val(),
                        time01: $("[name='time01']").val(),
                        time02: $("[name='time02']").val(),
                        text: $("[name='text']").val(),
                        remark: $("[name='remark']").val(),
                        tagname: choosetag,
                        week:week,
                    },
                    dataType: "json",
                    success: function (dbsx) {
                        if (dbsx.key == 0) {
                            alert("添加失败");
                            window.location.reload();
                        } else if (dbsx.key == 1) {
                            alert("添加成功");
                            window.location.reload();
                        }
                    },
                    error: function () {
                        alert("失败");
                    }
                })
            });
        })
    </script>
</head>
<body>
<div class="container-fluid">
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
                <li style="font-size: 20px;font-family: 华文隶书">
                    <a href="../jsp/login.jsp" style="color: white">你好:
                        <%
                            User u = (User)request.getSession().getAttribute("user");
                        %><%=u.getUsername()%>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</div>
<div style="margin: 0 auto;width: 60%;margin-top: 50px">
<form>
        <ul class="list-group">
            <li class="list-group-item">
                <div class="input-group">
                    <span class="input-group-addon">事项名称</span>
                    <input name="dbsxname" type="text" class="form-control" placeholder="">
                </div>
            </li>
            <li class="list-group-item">
                <div class="input-group">
                    <span class="input-group-addon" style="border:solid 1px #ccc">Tag标签:</span>
                    <div id="tagBianQian"class="form-control">
                    </div>
                </div>
            </li>
            <li class="list-group-item" style="height: 100px" >
                <div class="input-group" style="height: 80px" >
                    <span class="input-group-addon">事项内容:</span>
                        <textarea class="form-control" name="text" style="height: 100%"></textarea>
                    </div>
            </li>
            <li class="list-group-item">
                <div class="input-group">
                <span class="input-group-addon">事项备注:</span>
                <input class="form-control" name="remark" type="text"/>
                </div>
            </li>
            <li class="list-group-item">
                <div class="input-group">
                 <span class="input-group-addon">周期重复:</span>
                    <div class="form-control" >
                        <input id="noweek" type="checkbox" checked="checked" name="week" value="0">不重复</input>
                        <span id="weekdchoose">
                        </span>
                    </div>
                </div>
            </li>
            <li class="list-group-item">
                <div class="input-group">
                    <span class="input-group-addon">提醒时间:</span>
                    <span id="date">
                        <input class='form-control' type='date' name='time01'>
                        <input class='form-control'name='time02'type='time'>
                    </span>
                </div>
            </li>
        </ul>
    <div style="margin-left: 45%"><input id="adddbsx" class="btn btn-primary" type="button" value="新增"></div>
    </form>
</div>
</body>
</html>
