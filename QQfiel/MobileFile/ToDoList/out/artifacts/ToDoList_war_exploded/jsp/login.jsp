<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*,java.util.*" errorPage=""%>
<html>
<head>
  <title>墨迹代办-登录</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link type="text/css" rel="stylesheet" href="css/homepage.css">
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/dbsx.js"></script>
</head>
<body>
<br><br>
<div style="margin-left:45%">登录</div>
<div class="container">
  <div class="row">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
<form method="get" action="login2">
账号：<input type="text" name="phonenumber"/></br><br>
密码：<input type="password" name="password"></br><br>
<input style="margin-left: 30%" type="submit" value="登录"/>
</form>
  </div>
    <div class="col-lg-4"></div>
  </div>
  </div>
</div>

<div style="margin-left: 40%">还没有账号，点击<a href="regist.jsp">注册</a></div>
</body>
</html>
