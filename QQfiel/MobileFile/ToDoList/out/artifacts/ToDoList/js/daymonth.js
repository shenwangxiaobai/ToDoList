
$(document).ready(function () {
    $.ajax({
        url: "../todaymonth",
        type:"get",
        data:{
            today:"今日待办",
            selecttime:null,
        },
        dataType:"text",
        success:function (data) {
            var dbsx = JSON.parse(data);
            var dbsxbody = $("#dbsxbody");
            dbsxbody.empty();
            for(var i=0;i<dbsx.length;i++){
                var dbsx_token = "";
                if(dbsx[i].token.toString() == "1"){
                    dbsx_token = "checked";
                }
                if(dbsx[i].week.match("0")){
                    var week = "不重复";
                    var year = 1900+dbsx[i].time.year;
                    var month = dbsx[i].time.month+1;
                    month = month<10?"0"+month:month;
                    var day = dbsx[i].time.day<10?"0"+dbsx[i].time.day:dbsx[i].time.day;
                    var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                    var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                    var date2 = year+"-"+month+"-"+day+" "+hour+":"+minute;
                }else {
                    var week = "";
                    var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                    var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                    var date2 =hour+":"+minute;
                    if(dbsx[i].week.match("1")){
                        week = week + "星期一  ";
                    }if(dbsx[i].week.match("2")){
                        week = week + "星期二  ";
                    }if(dbsx[i].week.match("3")){
                        week = week + "星期三  ";
                    }if(dbsx[i].week.match("4")){
                        week = week + "星期四  ";
                    }if(dbsx[i].week.match("5")){
                        week = week + "星期五  ";
                    }if(dbsx[i].week.match("6")){
                        week = week + "星期六  ";
                    }if(dbsx[i].week.match("7")){
                        week = week + "星期日  ";
                    }
                }
                dbsxbody.append(
                    "<div class=\"panel-body\">"+
                    "<input type=\"checkbox\" name=\"dbsx_token\" value= "+dbsx[i].dbsxid+" "+dbsx_token+ ">是否完成"+
                    "<ul class=\"list-group\">"+
                    "<li class=\"list-group-item active\"><i class=\"fa fa-vcard-o\"></i>代办事项ID:"+dbsx[i].dbsxid+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-bars\"></i>代办事项名称:"+dbsx[i].dbsxname+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-tag\"></i>Tag标签:"+dbsx[i].tagname+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-clock-o\"></i>提醒时间:"+date2+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-file-text-o\"></i>事项内容:"+dbsx[i].text+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-file-o\"></i>事项备注:"+dbsx[i].remark+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-spinner fa-pulse\"></i>周期重复:"+week+"</li>"+
                    "</ul>"+
                    "</div>")
            };
        },
        error:function () {
            alert("数据请求失败");
        }
    });
    $(document).on("click","[name='todaymonth']",function () {
        var today = $(this).attr("value");
        var selettime= "";
        if(today=="查询月份"){
            selettime = $("#selecttime").val();
        }
        $.ajax({
            url: "../todaymonth",
            type:"get",
            data:{
                today:today,
                selecttime:selettime,
            },
            dataType:"text",
            success:function (data) {
                var dbsx = JSON.parse(data);
                var dbsxbody = $("#dbsxbody");
                dbsxbody.empty();
                for(var i=0;i<dbsx.length;i++){
                    var dbsx_token = "";
                    if(dbsx[i].token.toString() == "1"){
                        dbsx_token = "checked";
                    }
                    if(dbsx[i].week.match("0")){
                        var week = "不重复";
                        var year = 1900+dbsx[i].time.year;
                        var month = dbsx[i].time.month+1;
                        month = month<10?"0"+month:month;
                        var day = dbsx[i].time.day<10?"0"+dbsx[i].time.date:dbsx[i].time.date;
                        var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                        var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                        var date2 = year+"-"+month+"-"+day+" "+hour+":"+minute;
                    } else {
                        var week = "";
                        var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                        var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                        var date2 =hour+":"+minute;
                        if (dbsx[i].week.match("1")) {
                            week = week + "星期一  ";
                        }
                        if (dbsx[i].week.match("2")) {
                            week = week + "星期二  ";
                        }
                        if (dbsx[i].week.match("3")) {
                            week = week + "星期三  ";
                        }
                        if (dbsx[i].week.match("4")) {
                            week = week + "星期四  ";
                        }
                        if (dbsx[i].week.match("5")) {
                            week = week + "星期五  ";
                        }
                        if (dbsx[i].week.match("6")) {
                            week = week + "星期六  ";
                        }
                        if (dbsx[i].week.match("7")) {
                            week = week + "星期日  ";
                        }
                    }
                    dbsxbody.append(
                        "<div class=\"panel-body\">"+
                        "<input type=\"checkbox\" name=\"dbsx_token\" value= "+dbsx[i].dbsxid+" "+dbsx_token+ ">是否完成"+
                        "<ul class=\"list-group\">"+
                        "<li class=\"list-group-item active\"><i class=\"fa fa-vcard-o\"></i>代办事项ID:"+dbsx[i].dbsxid+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-bars\"></i>代办事项名称:"+dbsx[i].dbsxname+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-tag\"></i>Tag标签:"+dbsx[i].tagname+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-clock-o\"></i>提醒时间:"+date2+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-file-text-o\"></i>事项内容:"+dbsx[i].text+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-file-o\"></i>事项备注:"+dbsx[i].remark+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-spinner fa-pulse\"></i>周期重复:"+week+"</li>"+
                        "</ul>"+
                        "</div>")
                };
            },
            error:function () {
                alert("数据请求失败");
            }
        });
    });
});
$(document).on("click","[name='dbsx_token']",function () {
    var id = $(this).attr("value");
    var token = $(this).attr("checked");
    $.ajax({
        url: "../todaymonth",
        type: "get",
        data: {
            today:"今日待办",
            id: id,
            token: token,
        },
        dataType:"text",
        success:function (data) {
            var dbsx = JSON.parse(data);
            var dbsxbody = $("#dbsxbody");
            dbsxbody.empty();
            for (var i = 0; i < dbsx.length; i++) {
                var dbsx_token = "";
                if (dbsx[i].token.toString() == "1") {
                    dbsx_token = "checked";
                }
                if(dbsx[i].week.match("0")){
                    var week = "不重复";
                    var year = 1900+dbsx[i].time.year;
                    var month = dbsx[i].time.month+1;
                    month = month<10?"0"+month:month;
                    var day = dbsx[i].time.day<10?"0"+dbsx[i].time.date:dbsx[i].time.date;
                    var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                    var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                    var date2 = year+"-"+month+"-"+day+" "+hour+":"+minute;
                }else {
                    var week = "";
                    var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                    var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                    var date2 =hour+":"+minute;
                    if (dbsx[i].week.match("1")) {
                        week = week + "星期一  ";
                    }
                    if (dbsx[i].week.match("2")) {
                        week = week + "星期二  ";
                    }
                    if (dbsx[i].week.match("3")) {
                        week = week + "星期三  ";
                    }
                    if (dbsx[i].week.match("4")) {
                        week = week + "星期四  ";
                    }
                    if (dbsx[i].week.match("5")) {
                        week = week + "星期五  ";
                    }
                    if (dbsx[i].week.match("6")) {
                        week = week + "星期六  ";
                    }
                    if (dbsx[i].week.match("7")) {
                        week = week + "星期日  ";
                    }
                }
                dbsxbody.append(
                    "<div class=\"panel-body\">" +
                    "<input type=\"checkbox\" name=\"dbsx_token\" value= " + dbsx[i].dbsxid + " " + dbsx_token + ">是否完成" +
                    "<ul class=\"list-group\">"+
                    "<li class=\"list-group-item active\"><i class=\"fa fa-vcard-o\"></i>代办事项ID:"+dbsx[i].dbsxid+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-bars\"></i>代办事项名称:"+dbsx[i].dbsxname+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-tag\"></i>Tag标签:"+dbsx[i].tagname+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-clock-o\"></i>提醒时间:"+date2+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-file-text-o\"></i>事项内容:"+dbsx[i].text+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-file-o\"></i>事项备注:"+dbsx[i].remark+"</li>"+
                    "<li class=\"list-group-item\"><i class=\"fa fa-spinner fa-pulse\"></i>周期重复:"+week+"</li>"+
                    "</ul>"+
                    "</div>")
            };
        },
        error: function () {
            alert("数据请求失败");
        }
    });
});
$(window).on("load",function () {
    $(document).on("click","[name='chooseday']",function () {
        var nian = $("#nian").text();
        nian = nian.substring(0,4);
        var yue = $("#yue").text();
        var day = $(this).text();
        if(yue=="1月"){var yue_number = "01";}
        if(yue=="2月"){var yue_number = "02";}
        if(yue=="3月"){var yue_number = "03";}
        if(yue=="4月"){var yue_number = "04";}
        if(yue=="5月"){var yue_number = "05";}
        if(yue=="6月"){var yue_number = "06";}
        if(yue=="7月"){var yue_number = "07";}
        if(yue=="8月"){var yue_number = "08";}
        if(yue=="9月"){var yue_number = "09";}
        if(yue=="10月"){var yue_number = "10";}
        if(yue=="11月"){var yue_number = "11";}
        if(yue=="12月"){var yue_number = "12";}
        var y_m_d = nian+"-"+yue_number+"-"+day;
        $.ajax({
            url: "../chooseday",
            type: "get",
            data: {
                today:"chooseday",
                y_m_d:y_m_d,
            },
            dataType:"text",
            success:function (data) {
                console.log(data);
                var dbsx = JSON.parse(data);
                var dbsxbody = $("#dbsxbody");
                dbsxbody.empty();
                for (var i = 0; i < dbsx.length; i++) {
                    var dbsx_token = "";
                    if (dbsx[i].token.toString() == "1") {
                        dbsx_token = "checked";
                    }
                    if(dbsx[i].week.match("0")){
                        var week = "不重复";
                        var year = 1900+dbsx[i].time.year;
                        var month = dbsx[i].time.month+1;
                        month = month<10?"0"+month:month;
                        var day = dbsx[i].time.day<10?"0"+dbsx[i].time.date:dbsx[i].time.date;
                        var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                        var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                        var date2 = year+"-"+month+"-"+day+" "+hour+":"+minute;
                    }else {
                        var week = "";
                        var hour = dbsx[i].time.hours<10?"0"+dbsx[i].time.hours:dbsx[i].time.hours;
                        var minute = dbsx[i].time.minutes<10?"0"+dbsx[i].time.minutes:dbsx[i].time.minutes;
                        var date2 =hour+":"+minute;
                        if (dbsx[i].week.match("1")) {
                            week = week + "星期一  ";
                        }
                        if (dbsx[i].week.match("2")) {
                            week = week + "星期二  ";
                        }
                        if (dbsx[i].week.match("3")) {
                            week = week + "星期三  ";
                        }
                        if (dbsx[i].week.match("4")) {
                            week = week + "星期四  ";
                        }
                        if (dbsx[i].week.match("5")) {
                            week = week + "星期五  ";
                        }
                        if (dbsx[i].week.match("6")) {
                            week = week + "星期六  ";
                        }
                        if (dbsx[i].week.match("7")) {
                            week = week + "星期日  ";
                        }
                    }
                    dbsxbody.append(
                        "<div class=\"panel-body\">" +
                        "<input type=\"checkbox\" name=\"dbsx_token\" value= " + dbsx[i].dbsxid + " " + dbsx_token + ">是否完成" +
                        "<ul class=\"list-group\">"+
                        "<li class=\"list-group-item active\"><i class=\"fa fa-vcard-o\"></i>代办事项ID:"+dbsx[i].dbsxid+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-bars\"></i>代办事项名称:"+dbsx[i].dbsxname+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-tag\"></i>Tag标签:"+dbsx[i].tagname+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-clock-o\"></i>提醒时间:"+date2+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-file-text-o\"></i>事项内容:"+dbsx[i].text+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-file-o\"></i>事项备注:"+dbsx[i].remark+"</li>"+
                        "<li class=\"list-group-item\"><i class=\"fa fa-spinner fa-pulse\"></i>周期重复:"+week+"</li>"+
                        "</ul>"+
                        "</div>")
                };
            },
            error: function () {
                alert("数据请求失败");
            }
        });
    })
})
