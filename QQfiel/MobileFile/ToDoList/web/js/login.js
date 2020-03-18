$(document).ready(function () {
    localStorage.clear();
    $(document).on("click","#login",function () {
        var phonenumber = $("[name='phonenumber']").val();
        var password = $("[name='password']").val();
        $.ajax({
            url:"../login2",
            type:"get",
            data:{
                phonenumber:phonenumber,
                password:password,
            },
            dataType:"json",
            success:function (date) {
                var time = new Date();
                var year = time.getFullYear();
                var month= time.getMonth()+1;
                month = month<10?"0"+month:month;
                var day = time.getDate()<10?"0"+time.getDate():time.getDate();
                if (date.login != "") {
                    if(date.login=="Root"){
                        window.location.href="../jsp/root.jsp"
                    }else {
                        localStorage.setItem("user", date.login);
                        localStorage.setItem("phonenumber",phonenumber);
                        localStorage.setItem("time",year+"-"+month+"-"+day);
                        window.location.href="../jsp/homepage2.jsp";
                    }
                } else {
                    alert("请重新登录！");
                    window.location.reload();
                }
            },
            error:function () {
                alert("请重新登录！");
                window.location.reload();
            }
        });
    });
    function time_H(){
        var date = new Date();
        var h = date.getHours();
        if(h<=18&&h>=6){
            $('body').addClass("baitian");
        }else {
            $('body').addClass("heiye");
        }
    }
    time_H();
    window.setInterval(time_H ,1000*60);
});
$(document).ready(setInterval(function () {
    var date = new Date();
    var H = date.getHours()<10?"0"+date.getHours():date.getHours();
    var M = date.getMinutes()<10?"0"+date.getMinutes():date.getMinutes();
    var S = date.getSeconds()<10?"0"+date.getSeconds():date.getSeconds();
    $("#hour").text(H+"时");
    $("#minute").text(M+"分");
    $("#second").text(S+"秒");
}),1000);
