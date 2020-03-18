$().ready(function () {
    $.ajax({
        url: "../tagmanage",
        type: "get",
        data: {
            initial: "initial",
        },
        dateType: "json",
        success: function (data) {
            var selectTag = $("#selecttag");
            var tags = JSON.parse(data);
            console.log(data[0]);
            selectTag.empty();
            selectTag.append(
                "<div class=\"panel-body\">" +
                "<ul class=\"list-group\">" +
                "<li class=\"list-group-item\">" +
                "<input type='text' value='默认'readonly>"
            )
            for (var i = 0; i < tags.length; i++) {
                if (tags[i] != "默认") {
                    selectTag.append(
                        "<div class=\"panel-body\">" +
                        "<ul class=\"list-group\">" +
                        "<i class=\"fa fa-tag\"></i>"+
                        "<li class=\"list-group-item\">" +
                        "<input type='text' name='" + tags[i] + "' value='" + tags[i] + "'>" +
                        "<input class='hhh1' type='button' value='保存修改' name='edittag'>" +
                        "<input class='hhh2' type='button' value='删除Tag' name='deletetag'>" +
                        "</li>" +
                        "</ul>" +
                        "</div>"
                    )
                }
            }
        },
        error: function () {
            alert(false);
        }
    });
    $(document).on("click", "[name='edittag']", function () {
        var tagname = $(this).prev().attr("name");
        var newtagname = $(this).prev().val();
        $.ajax({
            url: "../tagmanage",
            type: "get",
            data: {
                initial: "edittag",
                tagname: tagname,
                newtagname: newtagname,
            },
            dateType: "json",
            success: function (data) {
                var selectTag = $("#selecttag");
                var tags = JSON.parse(data);
                selectTag.empty();
                selectTag.append(
                    "<div class=\"panel-body\">" +
                    "<ul class=\"list-group\">" +
                    "<li class=\"list-group-item\">" +
                    "<input type='text' value='默认'readonly>"
                )
                for (var i = 0; i < tags.length; i++) {
                    if (tags[i] != "默认") {
                        selectTag.append(
                            "<div class=\"panel-body\">" +
                            "<ul class=\"list-group\">" +
                            "<li class=\"list-group-item\">" +
                            "<input type='text' name='" + tags[i] + "' value='" + tags[i] + "'>" +
                            "<input class='hhh1' type='button' value='保存修改' name='edittag'>" +
                            "<input class='hhh2' type='button' value='删除Tag' name='deletetag'>" +
                            "</li>" +
                            "</ul>" +
                            "</div>"
                        )
                    }
                }
            },
            error: function () {
                alert(false);
            },
        })
    });
    $(document).on("click", "[name='deletetag']", function () {
        var tagname = $(this).prev().prev().attr("name");
        $.ajax({
            url: "../tagmanage",
            type: "get",
            data: {
                initial: "deletetag",
                tagname: tagname,
            },
            dateType: "json",
            success: function (data) {
                var selectTag = $("#selecttag");
                var tags = JSON.parse(data);
                selectTag.empty();
                selectTag.append(
                    "<div class=\"panel-body\">" +
                    "<ul class=\"list-group\">" +
                    "<li class=\"list-group-item\">" +
                    "<input type='text' value='默认'readonly>"
                )
                for (var i = 0; i < tags.length; i++) {
                    if (tags[i] != "默认") {
                        selectTag.append(
                            "<div class=\"panel-body\">" +
                            "<ul class=\"list-group\">" +
                            "<li class=\"list-group-item\">" +
                            "<input type='text' name='" + tags[i] + "' value='" + tags[i] + "'>" +
                            "<input class='hhh1' type='button' value='保存修改' name='edittag'>" +
                            "<input class='hhh2' type='button' value='删除Tag' name='deletetag'>" +
                            "</li>" +
                            "</ul>" +
                            "</div>"
                        )
                    }
                }
            },
            error: function () {
                alert(false);
            }
        });
    });
    $(document).on("click", "[name='addtagname']", function () {
        var newtagname = $(this).prev().val();
        alert(newtagname)
        $.ajax({
            url: "../tagmanage",
            type: "get",
            data: {
                initial: "addtagname",
                newtagname: newtagname,
            },
            success: function (data) {
                var selectTag = $("#selecttag");
                var tags = JSON.parse(data);
                console.log(data[0]);
                selectTag.empty();
                selectTag.append(
                    "<div class=\"panel-body\">" +
                    "<ul class=\"list-group\">" +
                    "<li class=\"list-group-item\">" +
                    "<input type='text' value='默认'readonly>"
                )
                for (var i = 0; i < tags.length; i++) {
                    if (tags[i] != "默认") {
                        selectTag.append(
                            "<div class=\"panel-body\">" +
                            "<ul class=\"list-group\">" +
                            "<li class=\"list-group-item\">" +
                            "<i class=\"fa fa-tag\">  </i>"+
                            "<input type='text' name='" + tags[i] + "' value='" + tags[i] + "'>" +
                            "<input class='hhh1' type='button' value='保存修改' name='edittag'>" +
                            "<input class='hhh2' type='button' value='删除Tag' name='deletetag'>" +
                            "</li>" +
                            "</ul>" +
                            "</div>"
                        )
                    }
                }
            },
            error: function () {
                alert(false);
            },
        })
    });
});
