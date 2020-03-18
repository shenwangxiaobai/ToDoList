$(document).ready(function () {
    var zhanghao = 0;
    var nichen = 0;
    //账号
    $("#phonenumber").on("input propertychange",function () {
        var phonenumber = $("#phonenumber").val();
        if($("#phonenumber").val().length<11){
            $("#phonenumberinfo").empty();
            $("#phonenumberinfo").append(
                "<p style='display: inline;font-size: 10px;color: #a94442'>账号输入有误</p>"
            )
        }
        if($("#phonenumber").val().length ==11){
            $.ajax({
                url:"../register",
                type:"get",
                data:{
                    selectuser:"selectuser",
                    phonenumber:phonenumber,
                },
                dataType:"json",
                success:function (data) {
                    if(data.number==0){
                        $("#phonenumberinfo").empty();
                        $("#phonenumberinfo").append(
                            "<p style='display: inline;font-size: 10px;color:darkseagreen'>可以正常使用</p>"
                        )
                        zhanghao = 1;
                    }else {
                        $("#phonenumberinfo").empty();
                        $("#phonenumberinfo").append(
                            "<p style='display: inline;font-size: 10px;color:#a94442'>请重新输入</p>"
                        )
                        zhanghao =0;
                    }

                },
                error:function () {
                    alert("失败");
                }
            })
        }
    });
    //用户名
    $("#username").on("input propertychange",function (event) {
        if ($("#username").val().length>1) {
            $("#usernameinfo").empty();
            $("#usernameinfo").append(
                "<p style='display: inline;font-size: 10px;color:darkseagreen'>可以正常使用</p>"
            );
            nichen = 1;
        }else {
            $("#usernameinfo").empty();
            $("#usernameinfo").append(
                "<p style='display: inline;font-size: 10px;color: #a94442'>账号输入有误</p>"
            );
            nichen = 0;
        }
    });
    //密码
    $(document).on("input propertychange","#password,#repassword",function () {
        var a = 0, b = 0, c = 0, d = 0;
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        for (var i = 0; i < password.length; i++) {
            //小写
            if (password[i] >= "a" && password[i] <= "z") {
                a = 1
            }
            //大写
            if (password[i] >= "A" && password[i] <= "Z") {
                b = 1
            }
            //数字
            if (password[i] >= "0" && password[i] <= "9") {
                c = 1
            }
            //特殊字符
            if (password[i] >= "!" && password[i] <= "/") {
                d = 1
            }
        }
        if(password.length==0) {
            $(this).attr("type", "text");
            $("#passwordinfo").empty();
        }else {
            $(this).attr("type", "password");
            if (password.length < 6) {
                $("#passwordinfo").empty();
                $("#passwordinfo").append(
                    "<p style='display: inline;font-size: 10px;color:#a94442'>密码长度不够</p>"
                )
            }else {
                $("#passwordinfo").empty();
                if (a + b + c + d > 2) {
                    $("#passwordinfo").empty();
                    $("#passwordinfo").append(
                        "<p style='display: inline;font-size: 10px;color:darkseagreen'>可以正常使用</p>"
                    )
                } else {
                    $("#passwordinfo").empty();
                    $("#passwordinfo").append(
                        "<p style='display: inline;font-size: 10px;color:#a94442'>必须包含数字、英文大写字母、小写字母、特殊字符中的三种</p>"
                    )
                }
            }
        }
        if(repassword==password){
            $("#repasswordinfo").empty();
            $("#repasswordinfo").append(
                "<p style='display: inline;font-size: 10px;color:darkseagreen'>可以正常使用</p>"
            )
            $("#register").removeAttr("hidden");
        }else {
            $("#repasswordinfo").empty();
            $("#repasswordinfo").append(
                "<p style='display: inline;font-size: 10px;color:#a94442'>密码不匹配</p>"
            )
            $("#register").attr("hidden","hidden");
        }
    })
})