$(document).ready(function(){
	 loadData(1);
	  generatPage();
	  service.generateTpl('tpl-task','side-table',{});
	   $("#queryBtn").on("click",function(){
            queryFun();
    })
    $("#clearBtn").on("click",function(){
            cleanFun();
    })
});

	function loadData(page,param){
        var start = (page - 1) * service.pageSize;
        if(!param){
            param={start:start};
        }else{
          param.start = start;
        }
        service.getGetService('siteInfo/page', param)
                    .done(function (data) {
                        if (data.status == "true") {
                            var html = template("tpl-task",data.data);
                            $("#site-table").html(html);
                        }
                    })
                    .fail(function () {
                        alert("something wrong");
                    });
    }

    // 生成分页
    function generatPage(param) {
        if(!param){
            param = {start:0};
        }
         service.generatePageByGet('siteInfo/page', param, 'pageBar', loadData);
    }

   // 查询
    function queryFun() {
        var param = service.transformFormData($('#queryForm'));
        loadData(1,param);
        generatPage(param);
    }

    // 清空
    function cleanFun() {

       $("#name").val("");
       $("#createTime").val("");
       $('#status option').first().prop('selected',true);
       
    }
