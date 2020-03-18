<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*,java.util.*" errorPage=""%>
<html>
<head>
    <title>墨迹代办-登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/dbsx.js"></script>
    <script type="text/javascript" src="../js/login.js" charset="UTF-8"></script>
    <link rel="stylesheet" href="../css/login.css" charset="UTF-8">
</head>
<body>
<script>
</script>
<div class="row" style="height: auto">
    <div class="col-lg-5" style="height: 100%">
        <div class="TOP" readonly>
            <span class="H_M_S timertext" readonly>现在是:</span></br>
            <span class="H_M_S timer" id="hour" readonly></span>
            <span class="H_M_S timer" id="minute" readonly></span>
            <span class="H_M_S timer" id="second" readonly></span><br>
            <span class="H_M_S timertext" readonly>来不及解释了,快登录！</span>
        </div>
    </div>
    <div class="col-lg-6" style="height: 100%;position: relative">
    <div class="container-fluid" style="height: 80%;position: absolute;width:60%;top: 35%;right: 10%;">
          <div class="panel panel-default moji hhh">
            <ul class="list-group" style="height: 100%;background-color: transparent;">
              <div class="panel-heading" style="height: 20%;">
                <li class="list-group-item" style="border-bottom: 1px solid #1b6d85;background-color: transparent;">
                    <div>
                      <p style="font-size: 200%;color:#2e6da4 ; font-family: 华文琥珀;text-align: center;margin-bottom: 0">墨迹代办</p>
                    </div>
                </li>
              </div>
              <div  class="panel-body" style="height: 80%">
                <li class="list-group-item"style="height:5%;background-color:transparent;position:relative;border: 0px">
                <li class="list-group-item forinput">
                <div style="height:90%;background-color:transparent;position:absolute;left: 15%">
                  <span class="spanfont">账号:</span>
                  <input oninput="value=value.replace(/[^\d]/g,'')" type="text" name="phonenumber" maxlength="11"/>
                    <!--<input hidden class="" type="password" autocomplete="new-password"></input>-->
                </div>
              </li>
                <li class="list-group-item forinput">
                  <div style="height: 100%;position:absolute;left: 15%">
                    <span class="spanfont">密码:</span>
                    <input maxlength="20" type="password" name="password" readonly onfocus="this.removeAttribute('readonly');" onblur="this.readOnly = 'readonly'">
                      <a href="../jsp/editpassword.jsp" style="font-size: 12px;color: #2e6da4">忘记密码?</a>
                  </div>
                </li>
                <li class="list-group-item  forinput">
                  <div style="height: 90%;position:absolute;left: 40%">
                    <input id="login" type="button" class="btn btn-primary" value="登录"/>
                  </div>
              </li>
              <li class="list-group-item forinput">
                <div style="height:90%;position: absolute;left: 29%">
                  <p style="font-size: 12px;color: black">
                    还没有账号，点击
                    <a href="../jsp/regist.jsp" style="color: #2e6da4">注册</a>
                  </p>
                </div>
              </li>
              </div>
            </ul>
          </div>
        </div>
    </div>
    <div class="col-lg-1" style="height: 100%">
    </div>
</div>
</body>
</html>
