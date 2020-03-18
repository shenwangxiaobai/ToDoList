$(document).ready(function () {
    var phonenumber = "";
    $("#editpassword").click(function () {
        phonenumber = $("#phonenumber").val();
        var username = $("#username").val();
        $.ajax({
            url:"../forgetpassword",
            type:"get",
            data:{
                phonenumber:phonenumber,
                username:username,
                editorsave:"edit",
            },
            dataType:"json",
            success:function (date) {
                if(date.editinfo=="gosave"){
                    $("#zhanghao").empty();
                    $("#zhanghao").append(
                        "密<span style='opacity: 0'>密码</span>码<input id='password1' type='password' name='password1'>"+
                        "<div id='forpassword1'>"+
                        "</div>"
                    )
                    $("#nichen").empty();
                    $("#nichen").append(
                        "确认密码<input id='password2' type='password' name='password1'>"+
                        "<div id='forpassword2'>"+
                        "</div>"
                    )
                    $("#xiugai").empty();
                    $("#xiugai").append(
                        "<input hidden id='savepassword' class='btn btn-primary' type='button' value='保存'/>"
                    )
                }
            },
            error:function () {
                alert("失败");
            },
        })
    })
    $(document).on("input","#password1",function () {
        var password01 = $("#password1").val();
        if(password01.length<6){
            $("#forpassword1").empty();
            $("#forpassword1").append(
                "<p style='display: inline;font-size: 10px;color: #a94442'>密码长度不够</p>"
            )
        }
        else {
            $("#forpassword1").empty();
            $("#forpassword1").append(
                "<p style='display: inline;font-size: 10px;color: darkseagreen'>密码格式正确</p>"
            )
        }
    });
    $(document).on("input","#password2",function () {
        var password01 = $("#password1").val();
        var password02 = $("#password2").val();
        if(password01.length<6){
            $("#forpassword2").empty();
            $("#forpassword2").append(
                "<p style='display: inline;font-size: 10px;color: #a94442'>密码长度不够</p>"
            )
        }
        else {
            if(password01==password02) {
                $("#forpassword2").empty();
                $("#forpassword2").append(
                    "<p style='display: inline;font-size: 10px;color: darkseagreen'>密码正确</p>"
                )
            }else {
                $("#forpassword2").empty();
                $("#forpassword2").append(
                    "<p style='display: inline;font-size: 10px;color: #a94442'>密码有误</p>"
                )
            }
        }
    });
    $(document).on("input","#password1,#password2",function () {
        if($("#password1").val()==$("#password2").val()){
            $("#savepassword").removeAttr("hidden");
        }
        else {
            $("#savepassword").attr("hidden","hidden");
        }
    });
    $(document).on("click","#savepassword",function () {
        var password1 = $("#password1").val();
        var password2 = $("#password2").val();
        $.ajax({
            url:"../forgetpassword",
            type:"get",
            data:{
                phonenumber:phonenumber,
                password:password1,
                editorsave:"save",
            },
            dataType:"json",
            success:function (date) {
                if(date.success== "true") {
                    alert("修改成功");
                    location.href="../jsp/login.jsp"
                }else if(date.success=="false"){
                    alert("修改失败");
                    window.location.reload();
                }
            },
            error:function () {
                alert("修改失败");
                window.location.reload();
            },
        })
    })
})
