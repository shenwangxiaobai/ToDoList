<%@ page import="java.util.Enumeration,com.mjdbsx.domain.Dbsx" %><%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/1/7
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>墨迹代办</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="css/homepage.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/dbsx.js"></script>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#" style="font-family: 华文琥珀">
                    墨迹代办
                </a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href="../../../../web/jsp/homepage2.jsp">主页</a></li>
                    <li><a href="../../../../web/jsp/day_month.jsp">今日待办</a></li>
                    <li><a href="../../../../web/jsp/tagmanage.jsp"> Tag管理</a></li>
                    <li><a href="../../../../web/jsp/adddbsx.jsp">新增</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li style="font-size: 20px;font-family: 华文隶书">
                        <a href="./jsp/login.jsp" style="color: white">你好:<%=request.getSession().getAttribute("username")%></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container-fluid">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Token选择:</a>
            </div>
            <div>
            <ul class="nav navbar-nav">
                <%
                    String token_name = null;
                    String tag_name = null;
                    if(request.getSession().getAttribute("token_number") != null) {
                        token_name = request.getSession().getAttribute("token_number").toString();
                        System.out.println(token_name);
                    }
                    if(request.getSession().getAttribute("tag_name") != null){
                        tag_name = request.getSession().getAttribute("tag_name").toString();
                        System.out.println(tag_name);
                    }
                %>
                <%
                    String active = " ";
                    String active1 = "";
                    String active2 = " ";
                    if(request.getSession().getAttribute("token_number") == null) {
                        active = "active";
                    } else{
                        if(request.getSession().getAttribute("token_number").equals("全部")||request.getSession().getAttribute("token_number").equals("null")){
                            active = "active";
                        }
                        if(request.getSession().getAttribute("token_number").equals("ToDo")) {
                            active1 = "active";
                        }
                        if(request.getSession().getAttribute("token_number").equals("Token")) {
                            active2 = "active";
                        }
                    }
                %>
                <li class=<%=active%>><a name="token" href="homepage?token=全部&tag_name=<%=tag_name%>">全部</a></li>
                <li class=<%=active1%>><a name="token" href="homepage?token=ToDo&tag_name=<%=tag_name%>">ToDo</a></li>
                <li class=<%=active2%>><a name="token" href="homepage?token=Token&tag_name=<%=tag_name%>">Token</a></li>
            </ul>
            </div>
        </div>
    </nav>
</div>
        <!--Tag标签-->
<div class="container-fluid">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Tag选择:</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <%
                        String tag_moren = "";
                        if(request.getSession().getAttribute("tag_name") == null||request.getSession().getAttribute("tag_name").equals("默认"))
                        {
                            tag_moren = "active";
                        }
                    %>
                        <li class=<%=tag_moren%>><a name="tag_name" href="homepage?tag_name=默认&token=<%=token_name%>"><% out.write("默认"); %></a></li>
                        <%
                            String[] tagname = (String[])request.getSession().getAttribute(("tagname_session"));
                            for(String tg:tagname)
                            {
                                String tag_other = "";
                        %>
                        <%
                            if(!tg.equals("默认")){
                                if(request.getSession().getAttribute("tag_name")!=null){
                                    if(request.getSession().getAttribute("tag_name").equals(tg)){
                                        tag_other = "active";
                                    }
                                }
                        %>
                        <li class=<%=tag_other%>><a name="tag_name" href="homepage?tag_name=<%=tg%>&token=<%=token_name%>"><% out.write(tg);%></a></li>
                        <%
                                }
                            }
                        %>
                </ul>
            </div>
        </div>
    </nav>
</div>
        <!--待办事项  -->
        <div  class="panel panel-default">
        <%
        Dbsx[] dbsxinfo = (Dbsx[])request.getAttribute("dbsxinfo");
        for(Dbsx dbsx:dbsxinfo)
        {
        %>
            <%
                String checked = " ";
                if(dbsx.getToken()== 1)
                {
                    checked = "checked";
                }
            %>
            <div class="panel-body">
                是否完成：
                <input type="checkbox" name="dbsx_token" <%=checked%> value="<%=dbsx.getDbsxid()%>"><br/>
                <ul class="list-group">
                    <li class="list-group-item active"><%  out.write("事项ID:"+dbsx.getDbsxid());%></li>
                    <li class="list-group-item"><%  out.write("事项名称:"+dbsx.getDbsxname());%></li>
                    <li class="list-group-item"><%  out.write("事项提示时间:"+dbsx.getTime());%></li>
                    <li class="list-group-item"><%  out.write("事项内容:"+dbsx.getText());%></li>
                    <li class="list-group-item"><%  out.write("事项备注:"+dbsx.getRemark());%></li>
                    <li class="list-group-item">
                        <a class="btn btn-default" href="homepage?dbsxid=<%=dbsx.getDbsxid()%>&type=编辑">编辑</a>
                        <span ></span>
                        <a class="btn btn-default" href="homepage?dbsxid=<%=dbsx.getDbsxid()%>&type=删除">删除</a>
                    </li>
                </ul>
            </div>
                <%
                    }
                %>
        </div>
</body>
</html>
