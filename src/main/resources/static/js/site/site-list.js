$(document).ready(function() {
    console.log('sss');
   loadData();
});

function loadData(){
    service.getGetService('siteInfo/page', {start:0})
                .done(function (data) {
                    if (data.status == "true") {
                        var html = template("tpl-task",data.data);
                        $("#task-table").html(html);
                    }
                })
                .fail(function () {
                    alert("something wrong");
                });
}

