<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/2/15
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>initial</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var token = localStorage.getItem("user");
        var key = localStorage.getItem("phonenumber");
        var date = localStorage.getItem("time");
        var time = new Date();
        var year = time.getFullYear();
        var month= time.getMonth()+1;
        month = month<10?"0"+month:month;
        var day = time.getDate()<10?"0"+time.getDate():time.getDate();
        var today = year+"-"+month+"-"+day;
        if(token==null){
            alert("认证过期，请重新登录！1");
            window.location.href="./jsp/login.jsp";
        }else{
            $.ajax({
                url:"initial",
                type:"get",
                data:{
                    token:token,
                    key:key,
                },
                dataType: "json",
                success:function (data) {
                    if(data.token==true){
                        if(date==null||date!=today) {
                            localStorage.setItem("time",today);
                            $.ajax({
                                url:"resetdbsx",
                                type:"get",
                                dataType:"json",
                                success:function (object) {
                                    if(object.key==true){
                                        window.location.href = "./jsp/homepage2.jsp";
                                    }else{
                                        alert("认证过期，请重新登录！4");
                                        window.location.href = "./jsp/login.jsp";
                                    }
                                },
                                error:function () {
                                    window.location.reload();
                                }
                            })
                        }else {
                            window.location.href = "./jsp/homepage2.jsp";
                        }
                    }else{
                        alert("认证过期，请重新登录！2");
                        window.location.href="./jsp/login.jsp";
                    }
                },error:function () {
                    alert("认证过期，请重新登录！3");
                    window.location.href="./jsp/login.jsp";
                }
            })
        }
    })
</script>
</body>
</body>
</html>
