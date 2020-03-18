layui.use('jquery', function() {
    var $ = layui.$;
    //演示动画
    $("#one ,#two").on('click', function () {
        var othis = $(this);
        var anim = othis.data('anim');
        if (othis.attr("id") == "one") {
            //停止循环
            if (othis.hasClass('layui-anim-loop')) {
                return othis.removeClass(anim);
            } else {
                othis.removeClass(anim);
                setTimeout(function () {
                    othis.addClass(anim);
                });
            }
            $("#two").removeClass(anim);
        } else {
            if (othis.hasClass('layui-anim-loop')) {
                return othis.removeClass(anim);
            } else {
                othis.removeClass(anim);
                setTimeout(function () {
                    othis.addClass(anim);
                });
            }
            $("#one").removeClass(anim);
        }
        //恢复渐隐
        if(anim === 'layui-anim-fadeout'){
            setTimeout(function(){
                othis.removeClass(anim);
            }, 1300);
        }
    });
});
layui.use('jquery',function () {
    var $ = layui.$;
    $("#one,#two").on('click', function () {
        if($(this).attr("id")=="one"){
            layui.use('table', function () {
                var table = layui.table;
                //第一个实例
                table.render({
                    elem: '#demo',
                    height: 458,
                    url: '../root?choose=selectuser&type=asc',
                    totalRow:true,
                    page: true,
                    limit: 10,
                    limits:[10,20,30],
                    cols: [[
                        {field: 'phonenumber', title: '用户账号', width: 200, sort: true, fixed: 'left'}
                        , {field: 'username', title: '用户名', width: 200,}
                        , {title: '操作', width: 200, align: 'center', toolbar: '#barDemo',event:"delete1"}
                    ]],done:function (res,curr,count) {
                        $('.layui-laypage-limits').hide();
                        console.log(res);
                        console.log(curr);
                        console.log(count)
                    },
                });
            });
        }else if($(this).attr("id")=="two"){
            layui.use('table', function () {
                var table = layui.table;
                //第一个实例
                table.render({
                    elem: '#demo',
                    height: 458,
                    url: '../root?choose=selectdbsxs&type=asc',
                    page: true,
                    limit: 10,
                    limits:null,
                    cols: [[
                        {field: 'dbsxid', title: '代办事项ID', width: 150, sort: true, fixed: 'left'}
                        , {field: 'username', title: '用户名', width:150,}
                        , {field: 'dbsxname', title: '待办事项名称', width:150,}
                        , {title: '操作', width: 150, align: 'center', toolbar: '#barDemo' ,event:"delete2"}
                    ]],done:function (res,curr,count) {
                        $('.layui-laypage-limits').hide();
                        console.log(res);
                        console.log(curr);
                        console.log(count)
                    },
                });
            });
        }
    });
});
layui.use('table', function() {
    layui.use('jquery', function () {
        var $ = layui.$;
        var table = layui.table;
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event == 'delete1') {
                var deletedata = {
                    choose :"deleteuser",
                    phonenumber:data.phonenumber,
                    username:data.username
                }                }
            else if(obj.event == "delete2"){
                var deletedata = {
                    choose:"deletedbsx",
                    dbsxid:data.dbsxid,
                }
            }
            $.ajax({
                url:"../root",
                type:"get",
                data:deletedata,
                datatype:"json",
                success:function () {
                    window.location.reload();
                },
                error:function () {
                    alert("ERROR");
                }
            })
        });
    });
})