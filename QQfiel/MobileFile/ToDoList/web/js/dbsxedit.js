
$(document).ready(function () {
    $.ajax({
        url:"../homepage2",
        type:"get",
        data:{
            choose:"initial",
        },
        dataType:"json",
        success:function (date) {
            $("#tagBianQian").empty();
            $("#tagBianQian").append("<input type='radio' name='tagname' value='默认'>默认</li>");
            for (var index = 0; index < date.length; index++) {
                if (date[index] != "默认") {
                    $("#tagBianQian").append("<input type='radio' name='tagname' value='"+date[index]+"'>" + date[index] + "</input>")
                }
            }
        },
        error:function () {
            alert("数据读取失败");
        },
    });
})
$(window).load(function(){
    $.ajax({
        url: "../editdbsx",
        type: "get",
        data: {
            dabsx_id: $("[name='dbsxid']").text(),
        },
        dataType: "json",
        success: function (dbsx) {
            $("[name='dbsxname']").attr("value",dbsx.dbsxname);
            $("[name='date']").attr("value",dbsx.time.toString().substring(0,10));
            $("[name='time']").attr("value",dbsx.time.toString().substring(11,16));
            $("[name='text']").attr("value",dbsx.text);
            $("[name='remark']").attr("value",dbsx.remark);
            var tagname = document.getElementsByName("tagname");
            for (var i = 0; i < tagname.length; i++){
                if(tagname[i].getAttribute("value")==dbsx.tagname){
                    tagname[i].setAttribute("checked","checked");
                }
            }
            var weekname = document.getElementsByName("week");
            if(dbsx.week.length==1&&dbsx.week=="0"){
                $("#first").attr("checked",true);
                $("[name='week']").removeAttr("checked");
                $("#date").empty();
                $("#date").append("<input type='date' name='date' value='"+dbsx.time.toString().substring(0,10)+"'>");
            }else {
                for (var i = 0; i < dbsx.week.length; i++) {
                    var j = dbsx.week.charAt(i)-1;
                    weekname[j].setAttribute("checked", "checked");
                    $("#date").empty();
                }
            }
        },
        error: function () {
            alert("数据读取失败");
        }
    });
    $(document).on("click","[name='tagname']",function () {
        $(this).attr("checked","checked");
        var choosetag = $(this).val();
        var tagname = document.getElementsByName("tagname");
        for (var i = 0; i < tagname.length; i++) {
            if (tagname[i].getAttribute("value") != choosetag) {
                tagname[i].setAttribute("checked","");
            }
        }

    });
    $(document).on("click","#first",function () {
        if(!$(this).is(":checked")) {
            $(this).removeAttr("checked");
            $("#date").empty();
        }
        else {
            $(this).attr("checked",true);
            $("[name='week']").removeAttr('checked');
            $("#date").empty();
            $("#date").append("<input type='date' name='date'>")
        }
    });
    $(document).on("click","[name='week']",function () {
        $("#first").removeAttr("checked");
        $(this).attr("checked",true);
        $("#date").empty();
    })
    $(document).on("click","#xiugai",function () {
        var tagname = document.getElementsByName("tagname");
        for (var i = 0; i < tagname.length; i++){
            if(tagname[i].getAttribute("checked")=="checked"){
                var tag_name = tagname[i].getAttribute("value");
            }
        }
        var week = "0";
        if($("#first").attr("checked")=="checked"){
            week = "0";
        }else {
            var week = "";
            var then = $("[name='week']");
            console.log(then)
            then.each(function (value) {
                console.log(this)
                if(this.getAttribute("checked")=="checked"){
                    week =week + this.getAttribute("value");
                }
            })
        }
        $.ajax({
            url: "../editdbsx",
            type: "get",
            data: {
                dbsxxiugai:"dbsxxiugai",
                dabsx_id: $("[name='dbsxid']").text(),
                dbsxname:$("[name='dbsxname']").val(),
                tagname:$("[name='tagname']").val(),
                date:$("[name='date']").val(),
                time01:$("[name='time']").val(),
                text:$("[name='text']").val(),
                remark:$("[name='remark']").val(),
                tagname:tag_name,
                week:week,
            },
            dataType: "json",
            success: function (dbsx) {
                if(dbsx.key==0){
                    alert("修改失败");
                }
                else if(dbsx.key ==1){
                    alert("修改成功");
                }
            },
            error: function () {
                alert("失败");
            }
        })
    })
})
