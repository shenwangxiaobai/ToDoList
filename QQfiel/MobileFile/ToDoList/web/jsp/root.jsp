<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/3/14
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台用户界面</title>
    <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../js/root.js"></script>
    <style>
        .site-doc-icon li{width: 180px;}
        .site-doc-icon li .layui-anim{width: 150px; height: 150px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;}
        ul li{
            user-select: none;
        }
    </style>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>ROOT管理</legend>
</fieldset>
<div class="layui-container">
<div class="layui-row">
    <div class="layui-col-lg1" style="border: transparent 1px solid" ></div>
    <div class = "layui-col-lg2">
        <ul class="site-doc-icon site-doc-anim" style="height: inherit">
            <li>
                <div id="one" class="layui-anim" data-anim="layui-anim-rotate layui-anim-loop">用户管理</div>
                <div class="code"></div>
            </li>
            <li>
                <div id = "two" class="layui-anim" data-anim="layui-anim-rotate layui-anim-loop">待办事项管理</div>
                <div class="code"></div>
            </li>
        </ul>
    </div>
    <div class="layui-col-lg8" style="border: 1px solid red;height: 464px" id="choose">
        <table id="demo" lay-filter="test"></table>
    </div>
    <div class="layui-col-lg1"></div>
</div>
</div>
<!--演示动画-->
<script type="text/html" id="barDemo">
    <a name="delete" class="layui-btn layui-btn-danger" href="#">删除</a>
</script>
</body>
</html>
