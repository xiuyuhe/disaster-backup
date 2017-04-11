jQuery(document).ready(function($) {
    var localObj = window.location;
    var contextPath = localObj.pathname.split("/")[1];
    $('#login-form').validate({
        rules: {
            invitationCode: {
                required: true,
                // minlength: 2
            },
            password: {
                required: true,
                minlength: 5
            }
        },
        messages: {
            invitationCode: {
                required: "*请输入用户名",
                //minlength: "用户名必需由两个字母组成"
            },
            password: {
                required: "*请输入密码",
                minlength: "密码长度不能小于 5 个字母"
            }
        },
        errorClass: 'red',
        errorPlacement: function(error, element) {
            $(element).after(error);
        },
        submitHandler: function(form) {
            var paramObj = $(form).serializeJson();
            var param = JSON.stringify(paramObj);
            $.ajax({
                url: "/"+contextPath+"/attribution/login",
                type: 'POST',
                dataType: 'json',
                data: 'jsonParams=' + param
            }).done(function(data) {
                var errorCode = ~~data.errorCode;
                if (errorCode === 0) {
                    var result = data.result,
                        isSuper = result.isSuper,
                        province = result.province,
                        name = result.name,
                        type = result.type,
                        haveBlackWhiteList = result.haveBlackWhiteList,
                        invitationCode = form.invitationCode.value;
                    setCookie('invitationCode', invitationCode, 24);
                    setCookie('isSuper', isSuper, 24);
                    setCookie('province', province, 24);
                    setCookie('name', name, 24);
                    setCookie('type', type, 24);
                    setCookie('haveBlackWhiteList', haveBlackWhiteList, 24);
                    if (isSuper === "Y")
                        window.location.href = './pages/index.html';
                    else if (type === 0)
                        window.location.href = './pages/bigAccount/manage.html';
                    else
                        window.location.href = './pages/bigAccount/compareRecord.html';

                } else {

                    alert_fail('登录失败:' + data.errorMessage);
                    throw new Error("登录失败," + data.errorCode + ":" + data.errorMessage);
                }
            }).fail(function(error) {
                alert_fail('登录失败:' + error.statusText);
                throw new Error("登录失败," + error.status + error.statusText);
            });

        }
    });

    $('#login-button').click(function(event) {
        $('#login-form').submit();
    });
    $('body').keyup(function(event) {
        if (event.keyCode == 13) {
            $('#login-form').submit();
        }
    })

});
