$(document).ready(function() {
    customValidateRules();
    serializeJson();

});



//设置Cookies
function setCookie(name, value, hours) {
    var Hours = hours;
    var exp = new Date(); //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Hours * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";path=/;expires=" + exp.toGMTString();
}

//读取Cookies
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) return unescape(arr[2]);
    return "";
}



//清除Cookies
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1270719748000);
    var cval = getCookie(name);
    if (cval != null) {
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString() + ";path=/";
    }
    //document.cookie = name + "=; expires=Fri, 31 Dec 1999 23:59:59 GMT;";
}

function clearCookie() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if (keys) {
        for (var i = keys.length; i--;)
            delCookie(keys[i]);
    }
}
//出错提示层--zhengchong
function alert_fail(str) {
    alert_fail_cacel();
    if ($("#alert_fail_el").length <= 0) {
        creat_alert_fail();
    }
    $("#alert_fail_content").html(str);
    $("#alert_fail_el").fadeIn("fast");
    alert_fail_keep();
}


function creat_alert_fail() {

    if ($("#alert_fail_el").length <= 0) {
        $("<div class=\"uspacealert\" style=\"display:none;\" id=\"alert_fail_el\"><div id=\"uspace_fail_box\"><div id=\"alert_fail_content\"></div><div onclick=\"alert_fail_hide();\" id=\"alert_fail_close\"></div></div></div>").appendTo("body");
    }
}

function alert_fail_hide() {
    $("#alert_fail_el").fadeOut("fast");
    alert_fail_cacel();
}

var alert_fail_resh = "";

function alert_fail_keep() {
    alert_fail_resh = window.setTimeout("alert_fail_hide()", 2000);
}

function alert_fail_cacel() {
    window.clearTimeout(alert_fail_resh);
}

$(document).ready(function() {
    creat_alert_fail();
});
//成功提示层--zhengchong
function alert_ok(str) {
    alert_ok_cacel();
    if ($("#alert_ok_el").length <= 0) {
        creat_alert_ok();
    }
    $("#alert_ok_content").html(str);
    $("#alert_ok_el").fadeIn("fast");
    alert_ok_keep();
}

function creat_alert_ok() {
    if ($("#alert_ok_el").length <= 0) {
        $("<div class=\"uspacealert\" style=\"display:none;\"  id=\"alert_ok_el\"><div id=\"uspace_success_box\"><div id=\"alert_ok_content\"></div><div onclick=\"alert_ok_hide();\" id=\"alert_success_close\"></div></div></div>").appendTo("body");
    }
}

function alert_ok_hide() {
    $("#alert_ok_el").fadeOut("fast");
    alert_ok_cacel();
}
var alert_ok_resh = "";

function alert_ok_keep() {
    alert_ok_resh = window.setTimeout("alert_ok_hide()", 1000);
}

function alert_ok_cacel() {
    window.clearTimeout(alert_ok_resh);
}
$(document).ready(function() {
    creat_alert_ok();
});



function convertToJson(aoData) {
    var json = new Object;
    for (var i in aoData) {
        if (aoData[i].name === "sEcho") {
            json.sEcho = aoData[i].value;
        } else if (aoData[i].name === "iDisplayLength") {
            json.iDisplayLength = aoData[i].value;
        } else if (aoData[i].name === "iDisplayStart") {
            json.iDisplayStart = aoData[i].value;
        }

    }
    return json;
}



function delAllCookie() {
    var cookies = document.cookie.split(";");
    /*for (var i = 0; i < cookies.length; i++) {
      var cookie = cookies[i];
      var eqPos = cookie.indexOf("=");
      var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
      document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/";
    }*/
    if (cookies.length > 0) {
        for (var i = 0; i < cookies.length; i++) {
            var cookie = cookies[i];
            var eqPos = cookie.indexOf("=");
            var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
            // var domain = location.host.substr(location.host.indexOf('.'));
            // document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/; domain=" + domain;
            delCookie(name);
        }
    }
}
//清除所有cookie
function clearCookie() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if (keys) {
        for (var i = keys.length; i--;)
            delCookie(keys[i]);
    }
}
// 序列化form表单为json格式
function serializeJson() {
    $.fn.serializeJson = function() {
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(function() {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };
}

//----------------------------------------------------------------------------------
// jquery.validate自定义校验规则
function customValidateRules() {
    // 匹配汉字  
    jQuery.validator.addMethod("isChinese", function(value, element) {
        return this.optional(element) || /^[\u4e00-\u9fa5]+$/.test(value);
    }, "（只能输入汉字）");

    // 匹配中文(包括汉字和字符) 
    jQuery.validator.addMethod("isChineseChar", function(value, element) {
        return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);
    }, "（只能包含中文字符）");

    // 字符验证，只能包含、英文、数字、_-.等字符。    
    jQuery.validator.addMethod("stringCheck", function(value, element) {
        return this.optional(element) || /^[a-zA-Z0-9-_.\-]+$/.test(value);
    }, "（只能包含中文、英文、数字、下划线等字符）");
    jQuery.validator.addMethod("isEnglish", function(value, element) {
        return this.optional(element) || /^[a-zA-Z]+$/.test(value);
    }, "（只能包含英文字符）");
    jQuery.validator.addMethod("isEngAndNum", function(value, element) {
        return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
    }, "（只能包含英文字符和数字）");
    // 判断是否包含中英文特殊字符，除英文"-_."字符外
    jQuery.validator.addMethod("isContainsSpecialChar", function(value, element) {
        var reg = RegExp(/[(\ )(\`)(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\|)(\{)(\})(\')(\:)(\;)(\')(',)(\[)(\])(\<)(\>)(\/)(\?)(\~)(\！)(\@)(\#)(\￥)(\%)(\…)(\&)(\*)(\（)(\）)(\—)(\+)(\|)(\{)(\})(\【)(\】)(\‘)(\；)(\：)(\”)(\“)(\’)(\。)(\，)(\、)(\？)]+/);
        return this.optional(element) || !reg.test(value);
    }, "（含有中英文特殊字符）");

    // 身份证号码验证

    jQuery.validator.addMethod("isIdCardNo", function(value, element) {
        return this.optional(element) || /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/.test(value);
    }, "请输入正确的身份证号");
    // jQuery.validator.addMethod("isIdCardNo1", function(value, element) {
    //     return this.optional(element) || /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/.test(value) || /^(\u65e0)$/.test(value);
    // }, "请输入正确的身份证号或者无");

    // 联系电话(手机/电话皆可)验证   
    jQuery.validator.addMethod("isTel", function(value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        var tel = /^(\d{3,4}-?)?\d{7,9}$/g;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "（请正确填写手机号）");
    jQuery.validator.addMethod("isTelRange", function(value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        var tel = /^(\d{3,4}-?)?\d{7,9}$/g;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "（请正确填写11位手机号段）");


    // 日期DateTime验证
    jQuery.validator.addMethod("isDateTime", function(value, element) {
        return this.optional(element) || /^([1-9]{1}\d{3}\-\d{2}-\d{2}(\ )\d{2}(\:)\d{2}(\:)\d{2})$/.test(value);
    }, "（请输入正确的日期时间）");
    //匹配IP
    jQuery.validator.addMethod("isIp", function(value, element) {
        //var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
        var ip = /^(?:[0-9]{1,3}\.){3}[0-9]{1,3}\:[0-9]{1,5}$/;
        return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256)) || /^(\u65e0)$/.test(value);
    }, "Ip地址格式错误");

}
