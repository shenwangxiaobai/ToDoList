<%@ page import="com.mjdbsx.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/16
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>今日/本月事务</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <link rel="stylesheet" href="../font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../css/yanse.css">
    <style>
        .backimg{
            background-image: url('../img/bear.jpg');
            background-size: 100%;
        }
        .calender_back{
            background-image: url("../img/h.jpg");
            background-size: 100%;
            opacity: 80%;
        }
        .week{
            background-color: transparent;
        }
        body{
            background-image: url("../img/bear.jpg");
            user-select: none;
            background-size: 100%;
        }
        .panel-body input{
            color: black;
            background-color: #204d74;
            opacity: 70%;
        }
        input{
            background-color: #204d74;
            opacity: 70%;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/daymonth.js" charset="UTF-8"></script>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        #data{
            width: 850px;
            border: 1px solid whitesmoke;
            margin: 10px auto;
        }
        #data > p{
             display: flex;
        }
        #data > h5{
             text-align: center;
        }
        #data > p > span{
             padding: 0 10px;
        }
        #prev{
            cursor: pointer;
            float: left;
            padding: 10px;
            color: white;
            font-size: 16px;
            font-weight: bold;
        }
        #next{
            cursor: pointer;
            float: right;
            padding: 10px;
            color: white;
            font-size: 16px;
            font-weight: bold;
        }
        #nian{
            flex: 1;
            text-align: center;
            padding: 10px;
            float: left;
            position: absolute;
            padding-left: 17%;
            font-family:"Rockwell Extra Bold";
            color: white;
            font-weight: bold;
            font-size: 20px;
        }
        #yue{
            flex: 1;
            text-align: center;
            padding: 10px;
            float: left;
            position: absolute;
            padding-left: 25%;
            font-family: "Rockwell Extra Bold";
            color: white;
            font-weight: bold;
            font-size: 20px;
        }
        #title{
            overflow: hidden;
            list-style: none;
            background:transparent;
            width: 100%;
        }
        #title > li{
            float: left;
            width: 14%;
            height: 30px;
            line-height: 30px;
            text-align: center;
            font-family:楷体;
            color: white;
        }
        #date{
            overflow: hidden;
            list-style: none;
        }
        #date > li{
            float: left;
            width: 14%;
            height: 30px;
            margin: 1px 1px;
            border: 1px solid gainsboro;
            line-height: 30px;
            text-align: center;
            cursor: pointer;
        }
        #date >.hover:hover{
            border: 2px solid red;
        }
        .active{
            color: red;
        }
        .white{
            border: 1px solid white;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../jsp/header.jsp"></jsp:include>
</div>
<div id="data" class="calender_back">
    <p>
        <span id="prev">上一月</span>
        <span id="nian">2020</span>
        <span id="yue">一月</span> 
        <span id="next">下一月</span>
    </p>
    <ul id="title" class="week">
        <li>日</li>
        <li>一</li>
        <li>二</li>
        <li>三</li>
        <li>四</li>
        <li>五</li>
        <li>六</li>
    </ul> 
    <ul id="date">
    </ul> 
</div>
<script type="text/javascript">
    var dat = new Date(); //当前时间 
    var nianD = dat.getFullYear();//当前年份 
    var yueD = dat.getMonth(); //当前月 
    var tianD = dat.getDate(); //当前天 这保存的年月日 是为了 当到达当前日期 有对比 

    add(); //进入页面第一次渲染 

    function add(){
        document.getElementById('date').innerHTML = "";
        var nian = dat.getFullYear();//当前年份 
        var yue = dat.getMonth(); //当前月 
        var tian = dat.getDate(); //当前天 
        var arr=["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"];
        document.getElementById('nian').innerText = nian+"年";
        document.getElementById('yue').innerText = arr[yue];

        var setDat = new Date(nian,yue + 1,1 - 1); //把时间设为下个月的1号 然后天数减去1 就可以得到 当前月的最后一天; 
        var setTian = setDat.getDate(); //获取 当前月最后一天 
        var setZhou = new Date(nian,yue,1).getDay(); //获取当前月第一天 是 周几 

        for(var i=0;i<setZhou ;i++){//渲染空白 与 星期 对应上 
            var li=document.createElement('li');
            li.setAttribute("style","border:0px solid white");
            document.getElementById('date').appendChild(li);
        }

        for(var i=1;i<=setTian;i++){//利用获取到的当月最后一天 把 前边的 天数 都循环 出来 
            var li=document.createElement('li');
            li.setAttribute("name","chooseday");
            li.innerText = i;
            if(nian == nianD && yue == yueD && i == tianD){
                li.className = "active";
            }else{
                li.className = "hover";
            }

            document.getElementById('date').appendChild(li);
        }

    }

    document.getElementById("next").onclick = function(){
        dat.setMonth(dat.getMonth() + 1); //当点击下一个月时 对当前月进行加1; 
        add(); //重新执行渲染 获取去 改变后的 年月日 进行渲染; 
    };
    document.getElementById("prev").onclick = function(){
        dat.setMonth(dat.getMonth() - 1); //与下一月 同理 
        add();
    };
</script>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3">
        </div>
        <div class="col-lg-4">
            <input id="today" class="btn btn-default" type="button" name="todaymonth" value="今日待办">
        </div>
        <div class="col-lg-4" >
            <div>
                <input id="selecttime" name="month" type="month" class="btn btn-default">
                <input id="month"  type="button" name="todaymonth" value="查询月份" class="btn btn-default">
            </div>
        </div>
    </div>
<div class="container-fluid">
    <div class="panel panel-default backimg">
        <div class="row">
            <div class="col-lg-2">
            </div>
            <div class="col-lg-8" id = "dbsxbody">
            </div>
            <div class="col-lg-2">
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
