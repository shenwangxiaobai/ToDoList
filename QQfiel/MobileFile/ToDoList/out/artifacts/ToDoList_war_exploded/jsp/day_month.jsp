<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/16
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>今日代事务_本月事务</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../css/homepage.css">
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("[name='todaymonth']").click(function () {
                var today = $(this).attr("value");
                alert(today);
                $.ajax({
                    url: "../todaymonth",
                    type:"get",
                    data:{today:today,},
                    dateType:"json",
                    success:function () {
                    },
                    error:function () {
                        alert(222);
                    }
                });
            });
        });
    </script>
</head>
<input id="today" type="button" name="todaymonth" value="今日待办"></input>
<input id="month" type="button" name="todaymonth" value="本月待办"></input>
</body>
</html>
