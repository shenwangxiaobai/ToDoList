<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/3/10
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--第二个页面-->
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script>
        $(document).ready(function () {
            alert(window.location);
        })
    </script>
    <p>))))))))))))))))))))</p>
</head>
<!--第二个页面-->
<body>
<div>
    <!--第一个页面 -->
    <script>
        $(document).on('click',"[name='hhh']",function () {
            var user = {'id':'1234','password':'QQww11'}
            user = encodeURIComponent(JSON.stringify(user));
            $.ajax({
                url:"test.jsp",
                type:"get",
                success:function () {
                    location.href="test.jsp?user="+user+"";
                },
                error:function () {
                    alert("flase");
                }
            })
        })
    </script>
    <input style="background: black" type="button" name="hhh" value="HHH"></input>
</div>
<p>
</p>
</body>
<!--第一个页面 -->
</html>
