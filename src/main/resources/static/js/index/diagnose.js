var modalNum = 0;
var modalArray = ['', 'oneDiv', 'twoDiv', 'threeDiv', 'fourDiv'];
var editModalNum = 0;
var editModalArray = ['', 'editOneDiv', 'editTwoDiv', 'editThreeDiv', 'editFourDiv'];

function getUserList() {
    if (!jQuery().dataTable) {
        return;
    }
    userTable = $("#userTable").dataTable({
        "aLengthMenu": [
            [10, 20, 50, 100],
            [10, 20, 50, 100] // change per page values here
        ],

        "iDisplayLength": 10,
        "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
        "sAjaxSource": "/diagnose/rest/task/getTaskinfos", //指定要从哪个URL获取数据
        "sAjaxDataProp": "data", //指定当从服务端获取表格数据时，数据项使用的名字
        "sPaginationType": "full_numbers",
        "bServerSide": true,
        "bDestroy": true,
        "oLanguage": {
            "sLengthMenu": "_MENU_ 每页条数",
            "oPaginate": {
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sFirst": "首页",
                "sLast": "末页"
            },
            "sInfo": "第_START_到_END_条数据 /共_TOTAL_条",
            "sInfoEmpty": "0条数据",
            "sInfoFiltered": "(从_MAX_条数据中检索)",
            "sZeroRecords": "没有检索到数据",
            "sSearch": "搜索"
        },
        // "sScrollX": "20%",
        "bPaginate": true, // 分页按钮
        "bFilter": false, // 搜索栏
        "bSort": false, // 排序
        "bAutoWidth": false,
        "bDeferRender": true,
        "aoColumns": [{
                "sClass": "count",
                "mDataProp": "id"

            }, {
                "mDataProp": "taskno"
            }, {
                "mDataProp": "taskname"
            },

            {
                "mDataProp": "repeatnum",
            }, {
                "mDataProp": "state",
            }, {
                "mDataProp": "starttime",
            }, {
                "mDataProp": "endtime",
            }, {
                "mDataProp": "devicenum",
            }, {
                "mDataProp": "resourcenum",
            }, {
                "mDataProp": "priority",
            }, {
                "mDataProp": "fixedtime",
            }, {
                "mDataProp": "serverid",
            }, {
                "mDataProp": "updatetime",
            }
        ],

        "fnServerData": function(sSource, aoData, fnCallback) {
            var obj = convertToJson(aoData);
            var form = $('#queryForm').serializeJson();
            obj.taskname = form.taskname;
            if (form.starttime !== "") {
                obj.starttime = form.starttime;
                obj.endtime = form.endtime;
            }

            var jsonData = JSON.stringify(obj);
            $.ajax({
                dataType: 'json',
                contentType: "application/json",
                type: "POST",
                url: sSource,
                data: jsonData,
       
                success: function(data) {
                    if (data.success == "true") {
                        fnCallback(data);
                    } else {
                        alert_fail('获取列表失败');
                    }

                },
                "error": function(error) {
                    alert_fail('获取列表失败:' + data.error.statusText);
                    throw new Error("获取列表失败," + error.status + error.statusText);
                }


            });
        },

        "drawCallback": function(settings) {
            var countStart = settings._iDisplayStart + 1;
            $('#userTable>tbody .count').each(function(index, el) {
                el.innerHTML = countStart++;
            });
        },

    });

}
//初始化页面操作
function init() {
    //选择操作某一行
    $('#userTable tbody').on('click', 'tr', function() {
        $(this).toggleClass('selected');
    });
    $(".no-print").css({
        "display": "none"
    });
    //查询按钮点击事件
    $('#queryBtn').click(function() {
        getUserList();
    });
    //添加按钮点击事件
    $('#addUserBtn').click(function() {
        modalNum = 0;
        $('div.modal-body div.show').removeClass('show').addClass('hide');
        $('div.modal-footer button.showBtn').removeClass('showBtn').addClass('hide');
        modalNum++;
        $('#oneDiv').removeClass('hide').addClass('show');
        $('#nextBtn').removeClass('hide').addClass('showBtn');
    });
    //初始化修改按钮；
    $('#editUserBtn').click(function() {
        editModalNum = 0;
        $('div.modal-body div.show').removeClass('show').addClass('hide');
        $('div.modal-footer button.showBtn').removeClass('showBtn').addClass('hide');
        editModalNum++;
        $('#editOneDiv').removeClass('hide').addClass('show');
        $('#editNextBtn').removeClass('hide').addClass('showBtn');
        initEditUser();
    });
    //上一步按钮点击事件
    $('#frontBtn').click(function() {
        if (modalNum == 2)
            $('#frontBtn').removeClass('showBtn').addClass('hide');
        $('#' + modalArray[modalNum]).removeClass('show').addClass('hide');
        modalNum--;
        $('#' + modalArray[modalNum]).removeClass('hide').addClass('show');

    });
    //修改中上一步点击事件
    $('#editFrontBtn').click(function() {
        if (editModalNum == 2)
            $('#editFrontBtn').removeClass('showBtn').addClass('hide');
        $('#' + editModalArray[editModalNum]).removeClass('show').addClass('hide');
        editModalNum--;
        $('#' + editModalArray[editModalNum]).removeClass('hide').addClass('show');

    });
    //下一步按钮点击事件
    $('#nextBtn').click(function() {
        if (modalNum == 1) {
            $('#frontBtn').removeClass('hide').addClass('showBtn');
        }
        if (modalNum == 3) {
            saveTaskConfig();
        }
        if (modalNum == 4) {
            return;
        }
        $('#' + modalArray[modalNum]).removeClass('show').addClass('hide');
        modalNum++;
        $('#' + modalArray[modalNum]).removeClass('hide').addClass('show');

    });
    //修改中下一步按钮
    $('#editNextBtn').click(function() {
        if (editModalNum == 1) {
            $('#editFrontBtn').removeClass('hide').addClass('showBtn');
        }



        if (editModalNum == 3) {
            editTaskConfig();
        }
        if (editModalNum == 4) {
            return;
        }

        $('#' + editModalArray[editModalNum]).removeClass('show').addClass('hide');
        editModalNum++;
        $('#' + editModalArray[editModalNum]).removeClass('hide').addClass('show');

    });
    //初始化查询开始时间
    $('#starttime').click(function(event) {
        WdatePicker({
            dateFmt: 'yyyy-MM-dd HH:mm:ss',
            maxDate: '#F{$dp.$D(\'endtime\',{d:0}) || \'%y-%M-#{%d}\'}',
            autoUpdateOnChanged: true

        });
    });
    //初始化查询结束时间
    $('#endtime').click(function(event) {
        WdatePicker({
            dateFmt: 'yyyy-MM-dd HH:mm:ss',
            minDate: '#F{$dp.$D(\'starttime\',{d:1})}',
            maxDate: '%y-%M-#{%d}',
            autoUpdateOnChanged: true

        });
    });
    //初始化定时时间按钮
    $('#fixedtime').click(function(event) {
        WdatePicker({
            dateFmt: 'yyyy-MM-dd HH:mm:ss',

            autoUpdateOnChanged: true

        });
    });
    $('#editFixedtime').click(function(event) {
        WdatePicker({
            dateFmt: 'yyyy-MM-dd HH:mm:ss',

            autoUpdateOnChanged: true

        });
    });
    //添加中默认配置的按钮事件
    $('#isdefault').change(function() {
        if (this.checked) {
            $('#daytimeBegin').attr('disabled', true);
            $('#daytimeEnd').attr('disabled', true);
            $('#configTable').find('input').attr('disabled', true);
        } else {
            $('#daytimeBegin').attr('disabled', false);
            $('#daytimeEnd').attr('disabled', false);
            $('#configTable').find('input').attr('disabled', false)
        }
    });
    //初始默认设置
    $('#daytimeBegin').attr('disabled', true);
    $('#daytimeEnd').attr('disabled', true);
    $('#configTable').find('input').attr('disabled', true);

    //添加保存任务按钮事件
    $('#saveTaskinfo').click(function() {
        saveTaskinfo();
    });
    //修改保存任务按钮
    $('#editTaskinfo').click(function() {
        saveTaskinfo('edit');
    });
    //删除按钮
    $('#deleteUserBtn').click(function() {
        deleteTask();
    })
}
//*************添加任务************

//获取资源数
function getResourceNum() {
    $.ajax({
        type: "post",
        url: "/diagnose/rest/task/getResourceNum",
        dataType: "json",
        contentType: "application/json"
    }).done(function(data) {
        if (data.success === "true") {
            $('#allnum').text(data.allnum);
            $('#curnum').text(data.curnum);
            $('#resourcenum').attr('max', data.curnum);
        }
    }).fail(function(error) {
        throw new Error(error);
    })
}

function initDevice() {
    $('#deviceTree').tree({
        url: '/diagnose/rest/task/deviceTree',
        method: 'post',
        animate: true,
        queryParams: { id: '' },
        checkbox: true,
        formatter: function(node) {
            if (node.state == "open" && !node.attributes.root)
                var v_text = "<span>" + node.text + "</span>"
            else
                var v_text = "<span>" + node.text + "(" + node.attributes.count + ")</span>";

            return v_text;

        },
        onMouseOver: function(node) {
            //console.log(node);
        },
        onMouseOut: function(node) {
            //console.log(node);
        },
        onCheck: function(node, checked) {
            var nodes = $('#deviceTree').tree('getChecked');
            var leafChecked = [];
            var civilcode = [];
            nodes.forEach(function(node) {
                var b = $('#deviceTree').tree('isLeaf', node.target);
                if (b) { leafChecked.push(node.id); } else {
                    civilcode.push(node.id);
                    console.log(node.parent);
                };
            })
            $('#devicenum').text(leafChecked.length);
            $('#civilcode').text(civilcode.join(','));
        }
    });
}

function saveTaskConfig() {
    var taskConfigObj = new Object(),
        timeconfig = {},
        alarmconfig = [];
    time = Date.parse(new Date());
    taskConfigObj.isdefault = $('#isdefault').prop('checked');

    taskConfigObj.taskno = time;
    timeconfig.id = '';
    timeconfig.endtime = getTime($('#daytimeEnd').val());
    timeconfig.starttime = getTime($('#daytimeBegin').val());
    timeconfig.intervaltime = '1478056000';
    timeconfig.scopetype = "2";
    timeconfig.targetid = time;
    taskConfigObj.timeconfig = timeconfig;
    $('#configTable tbody tr').each(function(index, element) {
        var config = {};
        config.id = $(element).attr('id');
        $(element).children().each(function(i, e) {
            switch (i) {
                case 1:
                    config.idname = e.innerText;
                    break;
                case 2:
                    config.serious = e.innerText;
                    break;
                case 3:
                    config.limittime = $(e).find('input').prop('checked');
                    break;
                case 4:
                    config.isalarm = $(e).find('input').prop('checked');
            }
        });
        alarmconfig.push(config);
    })
    taskConfigObj.alarmconfig = alarmconfig;
    taskConfigObj = JSON.stringify(taskConfigObj);
    $.ajax({
        dataType: "json",
        contentType: "application/json",
        url: '/diagnose/rest/task/saveTaskConfig',
        type: 'post',
        data: taskConfigObj

    }).done(function(data) {
        if (data.success == 'true') {
            alert_ok('配置成功');
            $("#userTable").dataTable().fnDraw(false);

        } else {
            alert_fail('配置失败');
        }
    }).fail(function(error) {
        throw new Error(error);
    })
}

function getTime(time) {
    var t = new Date();
    var timeStr = t.getFullYear() + "-" + (t.getMonth() + 1) + "-" + t.getDate() + " " + time + ":00";
    return timeStr;
}

function saveTaskinfo(edit) {
    var taskInfo, civilcode, devicenum;
    if (edit) {
        var selected = userTable.find('.selected'),
            obj = userTable.fnGetData(selected[0])[0];
        taskInfo = $('#editInfoForm').serializeJson();
        civilcode = $('#editCivilcode').text();
        devicenum = $('#editDevicenum').text();
        taskInfo.id = obj.id;
        taskInfo.taskno = obj.taskno;
    } else {
        taskInfo = $('#infoForm').serializeJson();
        civilcode = $('#civilcode').text();
        devicenum = $('#devicenum').text();
        taskInfo.taskno = time;
        taskInfo.id = "";
    }

    civilcode = civilcode.substr(civilcode.lastIndexOf('-') + 1);
    taskInfo.civilcode = civilcode;
    taskInfo.devicenum = devicenum
    taskInfo.endtime = ""

    taskInfo.note = ""
    taskInfo.operator = ""
    taskInfo.serverid = ""
    taskInfo.state = "1"
    taskInfo.starttime = "";

    taskInfo = JSON.stringify(taskInfo);
    $.ajax({
        dataType: 'json',
        url: '/diagnose/rest/task/saveTaskinfo',
        type: 'post',
        contentType: 'application/json',
        data: taskInfo
    }).done(function(data) {
        if (data.success == "true") {
            if (edit) {
                alert_ok('修改诊断任务成功');

            } else {
                alert_ok('添加诊断任务成功');

            }
            $("#userTable").dataTable().fnDraw(false);
        } else {
            if (edit) {
                alert_fail('修改诊断任务失败');
            } else {
                alert_fail('添加诊断任务失败');

            }
        }
    }).fail(function(error) {
        throw new Error(error);
    })

}

//*************修改任务************
//修改初始化
function initEditUser() {
    var selected = userTable.find('.selected');
    if (selected.size() < 1) {
        alert_fail('请选择修改项');
        return;
    } else if (selected.size() > 1) {
        alert_fail('每次只能修改一项');
        return;
    }
    editUser(selected);
}

//修改内容
function editUser(selected) {
    $("#editModal").modal('show');
    var editForm = $("#editInfoForm")[0],
        obj = userTable.fnGetData(selected[0]);
    editForm.taskname.value = obj.taskname;
    editForm.repeatnum.value = obj.repeatnum;
    editForm.priority.value = obj.priority;
    editForm.editFixedtime.value = obj.fixedtime;
    editForm.resourcenum.value = obj.resourcenum;
    editInitDevice(obj.civilcode)
    getTaskConfig(obj.taskno);

}
//获取已经选好的设备树
function editInitDevice(code) {
    $('#editDeviceTree').tree({
        url: '/diagnose/rest/task/deviceTree',
        method: 'post',
        animate: true,
        queryParams: { id: '' },
        checkbox: true,
        formatter: function(node) {
            if (node.state == "open" && !node.attributes.root)
                var v_text = "<span>" + node.text + "</span>"
            else
                var v_text = "<span>" + node.text + "(" + node.attributes.count + ")</span>";

            return v_text;

        },

        onMouseOver: function(node) {
            //console.log(node);
        },
        onMouseOut: function(node) {
            //console.log(node);
        },
        onLoadSuccess: function() {
            code = '6401-' + code;
            var node = $('#editDeviceTree').tree('find', code);
            // $('#editDeviceTree').tree('expand', node.target);
            $('#editDeviceTree').tree('check', node.target);
        },
        onCheck: function(node, checked) {
            var nodes = $('#editDeviceTree').tree('getChecked');
            var leafChecked = [];
            var civilcode = [];
            nodes.forEach(function(node) {
                var b = $('#editDeviceTree').tree('isLeaf', node.target);
                if (b) { leafChecked.push(node.id); } else {
                    civilcode.push(node.id);
                    console.log(node.parent);
                };
            })
            $('#editDevicenum').text(leafChecked.length);
            $('#editCivilcode').text(civilcode.join(','));
        }

    });
}
//获取报警配置供修改
function getTaskConfig(taskno) {
    var obj = {};
    obj.taskno = taskno;
    obj = JSON.stringify(obj);
    $.ajax({
        dataType: 'json',
        url: '/diagnose/rest/task/getTaskConfig',
        type: 'post',
        contentType: 'application/json',
        data: obj
    }).done(function(data) {
        console.log(data);
        var timeconfig = data.timeconfig,
            alarmconfig = data.alarmconfig,
            choose = ['', 'checked'];

        $('#editIsdefault').prop("checked", data.isdefault);
        $('#editdaytimeBegin').val(timeconfig.starttime);
        $('#editdaytimeEnd').val(timeconfig.endtime);
        $('#timeID').val(timeconfig.id)
        $('#editConfigTable tbody').empty();
        for (var i = 0; i < alarmconfig.length; i++) {
            $('#editConfigTable tbody').append(`<tr class=${alarmconfig[i].id}><td>${i+1}</td><td>${alarmconfig[i].idname}</td><td contenteditable = "true">${alarmconfig[i].serious}</td><td>
            <input type = "checkbox"  ${choose[alarmconfig[i].limittime]} ></td><td><input type = "checkbox" ${choose[alarmconfig[i].isalarm]}  ></td><td style="display:none;" >${alarmconfig[i].pk}</td></tr>`)
        }

    }).fail(function(error) {
        throw new Error(error);
    })
}

function editTaskConfig() {
    var taskConfigObj = new Object(),
        timeconfig = {},
        alarmconfig = [],
        selected = userTable.find('.selected'),
        obj = userTable.fnGetData(selected[0]),
        timeID = $('#timeID').val(),
        isdefault = $('#editIsdefault').prop('checked');
    taskConfigObj.taskno = obj.taskno;
    if (isdefault == true) {
        taskConfigObj.isdefault = isdefault;

    } else {
        taskConfigObj.isdefault = false;
        timeconfig.id = timeID;
        timeconfig.endtime = getTime($('#editdaytimeEnd').val());
        timeconfig.starttime = getTime($('#editdaytimeBegin').val());
        timeconfig.intervaltime = '1478056000';
        timeconfig.scopetype = "2";
        timeconfig.targetid = obj.taskno;
        taskConfigObj.timeconfig = timeconfig;
        $('#editConfigTable tbody tr').each(function(index, element) {
            var config = {};
            config.id = $(element).attr('class');
            $(element).children().each(function(i, e) {
                switch (i) {
                    case 1:
                        config.idname = e.innerText;
                        break;
                    case 2:
                        config.serious = e.innerText;
                        break;
                    case 3:
                        config.limittime = $(e).find('input').prop('checked');
                        break;
                    case 4:
                        config.isalarm = $(e).find('input').prop('checked');
                        break;
                    case 5:
                        if (timeID != '') {
                            config.pk = e.innerText;
                        }

                }
            });
            alarmconfig.push(config);
        })
        taskConfigObj.alarmconfig = alarmconfig;
    }
    taskConfigObj = JSON.stringify(taskConfigObj);
    $.ajax({
        dataType: "json",
        contentType: "application/json",
        url: '/diagnose/rest/task/saveTaskConfig',
        type: 'post',
        data: taskConfigObj

    }).done(function(data) {
        if (data.success == 'true') {
            alert_ok('修改配置成功');
            $("#userTable").dataTable().fnDraw(false);
        } else {
            alert_fail('修改配置失败');
        }
    }).fail(function(error) {
        throw new Error(error);
    })
}
//*************删除任务************
function deleteTask() {
    //userTable.fnGetData(selected[0]),
    var selected = userTable.find('.selected');
    if (selected.size() < 1) {
        alert_fail('请选择要删除的选项');
    } else {
        if (confirm("确定要删除员工信息吗？")) {
            var ids = [],
                obj = {};
            selected.each(function(item, i) {
                ids.push(userTable.fnGetData(item).id);
            });
            obj.ids = ids;
            obj = JSON.stringify(obj);
            $.ajax({
                data: obj,
                dataType: 'json',
                url: '/diagnose/rest/task/deleteTaskinfo',
                contentType: 'application/json',
                type: 'post'
            }).done(function(data) {
                if (data.success == 'true') {
                    alert_ok('删除任务成功');
                    $("#userTable").dataTable().fnDraw(false);
                } else
                    alert_fail('删除任务失败');
            }).fail(function(error) {
                throw new Error(error);
            })
        }
    }
}
$(document).ready(function() {
    init();
    initDevice();
    getUserList();
    getResourceNum();
   
});
