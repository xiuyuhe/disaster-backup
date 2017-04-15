$(document).ready(function() {
    init();
})

function init() {
    $('#starttime').click(function(event) {
        WdatePicker({
            dateFmt: 'yyyy-MM-dd',
            maxDate: '#F{$dp.$D(\'endtime\',{d:0}) || \'%y-%M-#{%d}\'}',
            autoUpdateOnChanged: true

        });
    });
    //初始化查询结束时间
    $('#endtime').click(function(event) {
        WdatePicker({
            dateFmt: 'yyyy-MM-dd',
            minDate: '#F{$dp.$D(\'starttime\',{d:1})}',
            maxDate: '%y-%M-#{%d}',
            autoUpdateOnChanged: true

        });
    });
}
