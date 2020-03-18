$(document).ready(function () {
    $("[name='dbsx_token']").click(function () {
        var choose = $(this).attr("checked");
        var dbsxid = $(this).val();
        $.get("dbsxtoken", {choose: choose, dbsxid: dbsxid});
    });
});
