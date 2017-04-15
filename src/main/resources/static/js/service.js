/**
 * Created by hexiuyu on 2017/4/14.
 */
service  = {
    urlPreix: "http://localhost:8080/",
    pageSize: 10,

    getService : function (url) {
        return $.ajax({
            url: service.urlPreix + url,
            method: 'GET',
            dataType: 'json'
        });
    },
   
    getGetService : function (url,data) {
        url += "?";
        for(var p in data){
            if(typeof ( data [ p ]) != " function " ){
                url += p + "=" + data [ p ] + "&";
            }
        }
        url = url.substring(0,url.length-1);
        return $.ajax({
            url: service.urlPreix + url,
            method: 'GET',
            dataType: 'json'
        });
    },

    postService : function (url, data) {
        return $.ajax({
            url: service.urlPreix + url,
            method: 'POST',
            dataType: 'json',
            // contentType: 'application/json',
            data: data
        })
    },
    /**
     *
     * @param form 参数 form  为 表单的jquery 对象
     * @returns  组装好的对象
     */
    transformFormData : function (form) {
        var arr = form.serializeArray();
        var data = {};
        arr.forEach(function (item) {
            if(item.value){
                data[item.name] = item.value;
            }
        });
        return data;
    },


    /**
     *  tplId : template Id
     */
    generateTpl: function (tplId, domId, data) {
        var html = template(tplId, data);
        $('#'+domId).html(html);
    },

    generatePagination : function(url, queryUserData, pageBarId, changeFun){
        service.postService(url, queryUserData).done(function (json) {
            var trueData = json.data;
            $('#'+pageBarId).jqPaginator({
                totalPages: trueData.totalPages,
                visiblePages: 5,
                currentPage: trueData.currentPage + 1,
                prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
                next: '<li class="next"><a href="javascript:;">Next</a></li>',
                page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
                onPageChange: function (num, type) {
                    if (type == 'change') {
                        changeFun(num);
                    }
                }
            })
        });
    },
    generatePageByGet : function(url, queryUserData, pageBarId, changeFun){
        service.getGetService(url, queryUserData).done(function (json) {
            var trueData = json.data;
            $('#'+pageBarId).jqPaginator({
                totalPages: trueData.totalPages,
                visiblePages: 5,
                currentPage: trueData.currentPage + 1,
                prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
                next: '<li class="next"><a href="javascript:;">Next</a></li>',
                page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
                onPageChange: function (num, type) {
                    if (type == 'change') {
                        changeFun(num);
                    }
                }
            })
        });
    },
    /**
     * @param args
     * {
     *   userName : 用户名
     *   currentPage : 当前页面分组
     *   currentSubPage: 当前具体导航
     *   role : []  权限组

     * }
     *
     */
    generateSideBar: function (args) {
        $.get(service.urlPreix+"pages/sidebar.html", function (data,args) {
            var render = template.compile(data);
            var args = {
                usesName: args.userName,
                currentPage: args.currentPage
            };
            var html = render(args);
            $('#sidebar').html(html);
        })
    },


};