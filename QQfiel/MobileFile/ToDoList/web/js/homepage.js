$(document).ready(function () {
    $.ajax({
        url:"../homepage2",
        type:"get",
        data:{
            choose:"initial",
        },
        dataType:"json",
        success:function (date) {
            $("#Tagchoose").empty();
            $("#Tagchoose").append("<li class='active'><a name='tagname' href='#'>全部</a></li>")
            $("#Tagchoose").append("<li class=''><a name='tagname' href='#'>默认</a></li>")
            for (var index = 0; index < date.length; index++) {
                if (date[index] != "默认") {
                    $("#Tagchoose").append("<li class=''><a name='tagname' href='#'>" + date[index] + "</a></li>")
                }
            }
        },
        error:function () {
            alert("数据读取失败");
        },
    });
    var token = "全部";
    var tagname = "全部";
    $(document).on("click","[name='token']",function () {
        token = $(this).text();
        $(this).parent().attr("class","active");
        $(this).parent().siblings().attr("class"," ");
    });
    $(document).on("click","[name='tagname']",function () {
        tagname = $(this).text();
        $(this).parent().attr("class","active");
        $(this).parent().siblings().attr("class"," ");
    });
    $(document).on("click","[name='tagname'],[name='token']",function () {
        $.ajax({
            url: "../homepage2",
            type: "get",
            data: {
                choose: "select",
                token: token,
                tagname: tagname,
            },
            dataType: "json",
            success: function (dbsx) {
                var dbsxbody = $("#dbsxbody");
                dbsxbody.empty();
                for (var i = 0; i < dbsx.length; i++) {
                    var dbsx_token = "";
                    if (dbsx[i].token.toString() == "1") {
                        dbsx_token = "checked";
                    }
                    //获取时间
                    if (dbsx[i].week == "0" && dbsx[i].week.length == 1) {
                        var weekinfo = "不重复";
                        var year = 1900+dbsx[i].time.year;
                        var month = dbsx[i].time.month+1;
                        month = month<10?"0"+month:month;
                        var day = dbsx[i].time.day<10?"0"+dbsx[i].time.date:dbsx[i].time.date;
                        var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                        var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                        var date2 = year+"-"+month+"-"+day+" "+hour+":"+minute;
                    } else {
                        var weekinfo = "";
                        var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                        var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                        var date2 = hour+":"+minute;
                        for (var j = 0; j < dbsx[i].week.length; j++) {
                            for (var k = 1; k <= 7; k++) {
                                if (k.toString() == dbsx[i].week.charAt(j)) {
                                    if (k == 1) {
                                        var ji = "一"
                                    }
                                    ;
                                    if (k == 2) {
                                        var ji = "二"
                                    }
                                    if (k == 3) {
                                        var ji = "三"
                                    }
                                    if (k == 4) {
                                        var ji = "四"
                                    }
                                    if (k == 5) {
                                        var ji = "五"
                                    }
                                    if (k == 6) {
                                        var ji = "六"
                                    }
                                    if (k == 7) {
                                        var ji = "日"
                                    }
                                    weekinfo += "星期" + ji + " ";
                                }
                            }
                        }
                    }
                    dbsxbody.append(
                        "<div class=\"panel-body\">" +
                        "<input type=\"checkbox\" name=\"dbsx_token\" value= " + dbsx[i].dbsxid + " " + dbsx_token + ">是否完成" +
                        "<ul class=\"list-group\">" +
                        "<li class='list-group-item active'><i class=\"fa fa-vcard-o\"></i>  代办事项ID:" + dbsx[i].dbsxid + "</li>" +
                        "<li class=\"list-group-item\"><i class=\"fa fa-bars\"></i>  代办事项名称:" + dbsx[i].dbsxname + "</li>" +
                        "<li class=\"list-group-item\"><i class=\"fa fa-tag\"></i>  Tag标签:" + dbsx[i].tagname + "</li>" +
                        "<li class=\"list-group-item\"><i class=\"fa fa-clock-o\"></i>  提醒时间:" + date2 + "</li>" +
                        "<li class=\"list-group-item\"><i class=\"fa fa-file-text-o\"></i>  事项内容:" + dbsx[i].text + "</li>" +
                        "<li class=\"list-group-item\"><i class=\"fa fa-file-o\"></i>  事项备注:" + dbsx[i].remark + "</li>" +
                        "<li class='list-group-item'><i class=\"fa fa-spinner fa-pulse\"></i>  周期重复:" + weekinfo + "</li>" +
                        "<li class='list-group-item dab'>" +
                        "<a class='btn btn-default bianji' href='../jsp/dbsxedit.jsp?dbsxid=" + dbsx[i].dbsxid + "'><i class=\"fa fa-pencil fa-2x\"></i></a>" +
                        "<a class='btn btn-default shanchu'  id='"+dbsx[i].dbsxid+"' name='deletedbsx' href='#'><i class=\"fa fa-trash fa-2x\"></i></a>" +
                        "</li>" +
                        "</ul>" +
                        "</div>")
                }
            },
            error:function () {
                alert("Error");
            }
        })
    });
    $(document).on("click","[name='dbsx_token']",function () {
        var id = $(this).attr("value");
        var token = $(this).attr("checked");
        $.ajax({
            url: "../dbsxtoken",
            type: "get",
            data: {

                dbsxid: id,
                choose: token,
            },
            dataType:"json",
            success:function (data) {
                var success = data.success;
                if(success){
                    alert("成功");
                    location.reload();
                }else {
                    alert("失败");
                }
            },
            error: function () {
                alert("数据请求失败");
            }
        });
    });
    $(document).on("click","[name='deletedbsx']",function () {
        var dbsxid = $(this).attr("id");
        if(confirm("确定删除"+dbsxid+"吗？")){
            $.ajax({
                url: "../deletedbsx",
                type: "get",
                data: {

                    dbsxid: dbsxid,
                },
                dataType: "json",
                success: function (data) {
                    var deletedbsx = data.delete;
                    if (deletedbsx == true) {
                        alert("成功");
                        location.reload();
                    } else {
                        alert("失败");
                    }
                },
                error: function () {
                    alert("数据请求失败");
                }
            });
        }
    });
})
$(window).on("load",function() {
    $.ajax({
        type: "get",
        url: "../homepage2",
        data: {
            choose: "select",
            token: "全部",
            tagname: "全部",
        },
        dataType: "json",
        success: function (dbsx) {
            var dbsxbody = $("#dbsxbody");
            dbsxbody.empty();
            for (var i = 0; i < dbsx.length; i++) {
                var dbsx_token = "";
                if (dbsx[i].token.toString() == "1") {
                    dbsx_token = "checked";
                }
                //获取时间
                var date1 = new Date(dbsx[i].time.time);
                if (dbsx[i].week == "0" && dbsx[i].week.length == 1) {
                    var weekinfo = "不重复";
                    var year = 1900 + dbsx[i].time.year;
                    var month = dbsx[i].time.month + 1;
                    month = month < 10 ? "0" + month : month;
                    var day = dbsx[i].time.day < 10 ? "0" + dbsx[i].time.date : dbsx[i].time.date;
                    var hour = dbsx[i].time.hours < 10 ? "0" + dbsx[i].time.hours : dbsx[i].time.hours;
                    var minute = dbsx[i].time.minutes < 10 ? "0" + dbsx[i].time.minutes : dbsx[i].time.minutes;
                    var date2 = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                } else {
                    var weekinfo = "";
                    var hour = dbsx[i].time.hours < 10 ? "0" + dbsx[i].time.hours : dbsx[i].time.hours;
                    var minute = dbsx[i].time.minutes < 10 ? "0" + dbsx[i].time.minutes : dbsx[i].time.minutes;
                    var date2 = hour + ":" + minute;
                    for (var j = 0; j < dbsx[i].week.length; j++) {
                        for (var k = 1; k <= 7; k++) {
                            if (k.toString() == dbsx[i].week.charAt(j)) {
                                if (k == 1) {
                                    var ji = "一"
                                }
                                ;
                                if (k == 2) {
                                    var ji = "二"
                                }
                                if (k == 3) {
                                    var ji = "三"
                                }
                                if (k == 4) {
                                    var ji = "四"
                                }
                                if (k == 5) {
                                    var ji = "五"
                                }
                                if (k == 6) {
                                    var ji = "六"
                                }
                                if (k == 7) {
                                    var ji = "日"
                                }
                                weekinfo += "星期" + ji + " ";
                            }
                        }
                    }
                }
                dbsxbody.append(
                    "<div class=\"panel-body\">" +
                    "<input type=\"checkbox\" name=\"dbsx_token\" value= " + dbsx[i].dbsxid + " " + dbsx_token + ">是否完成" +
                    "<ul class=\"list-group\">" +
                    "<li class='list-group-item active'><i class=\"fa fa-vcard-o\"></i>  代办事项ID:" + dbsx[i].dbsxid + "</li>" +
                    "<li class=\"list-group-item\"><i class=\"fa fa-bars\"></i>  代办事项名称:" + dbsx[i].dbsxname + "</li>" +
                    "<li class=\"list-group-item\"><i class=\"fa fa-tag\"></i>  Tag标签:" + dbsx[i].tagname + "</li>" +
                    "<li class=\"list-group-item\"><i class=\"fa fa-clock-o\"></i>  提醒时间:" + date2 + "</li>" +
                    "<li class=\"list-group-item\"><i class=\"fa fa-file-text-o\"></i>  事项内容:" + dbsx[i].text + "</li>" +
                    "<li class=\"list-group-item\"><i class=\"fa fa-file-o\"></i>  事项备注:" + dbsx[i].remark + "</li>" +
                    "<li class='list-group-item'><i class=\"fa fa-spinner fa-pulse\"></i>  周期重复:" + weekinfo + "</li>" +
                    "<li class='list-group-item dab'>" +
                    "<a class='btn btn-default bianji' href='../jsp/dbsxedit.jsp?dbsxid=" + dbsx[i].dbsxid + "'><i class=\"fa fa-pencil fa-2x\"></i></a>" +
                    "<a class='btn btn-default shanchu'  id='"+dbsx[i].dbsxid+"' name='deletedbsx' href='#'><i class=\"fa fa-trash fa-2x\"></i></a>" +
                    "</li>" +
                    "</ul>" +
                    "</div>");
                $("[name='tagname']").each(function (index, element) {
                    if (element.innerText == "全部") {
                        element.parentElement.setAttribute("class", "active");
                    }
                });
                $("[name='token']").each(function (index, element) {
                    if (element.innerText == "全部") {
                        element.parentElement.setAttribute("class", "active");
                    }
                });
            }
        },
        error: function () {
            alert("Error");
        }
    });
    $.ajax({
        url:"../listeerner",
        type:"get",
        dataType:"json",
        success:function (dbsx) {
            setInterval(function () {
                var dbsxneed = "";
                var time = 0;
                var now = new Date();
                var h = now.getHours()<10?"0"+now.getHours():now.getHours();
                var m = now.getMinutes()<10?"0"+now.getMinutes():now.getMinutes();
                var now02 = h+":"+m;
                for(var i=0;i<dbsx.length;i++) {
                    console.log(dbsx.length);
                    if (dbsx[i].time.hours < 10) {
                        var hour = "0" + dbsx[i].time.hours;
                    } else {
                        var hour = dbsx[i].time.hours;
                    }
                    if (dbsx[i].time.minutes < 10) {
                        var minutes = "0" + dbsx[i].time.minutes;
                    } else {
                        var minutes = dbsx[i].time.minutes;
                    }
                    var now01 = hour + ":" + minutes;
                    if (now01 == now02) {
                        dbsxneed = dbsx[i].dbsxid;
                    }
                }
                if(dbsxneed!=""&&time==0){
                    alert(dbsxneed + "需要完成");
                    time++;
                }
            },1000*60)
        },
        error:function () {
            console.log("出现异常");
        }
    });
});
$(document).on("click","[name='quit']",function () {
    $.ajax({
        url:"../quit",
        type:"get",
        success:function () {
            window.location.href="../jsp/login.jsp";
        },
        error:function () {

        }
    })
})