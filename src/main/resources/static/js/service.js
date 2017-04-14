/**
 * Created by hexiuyu on 2017/4/14.
 */
service  = {
    urlPreix: "http://localhost:8080/",

    getService : function (url) {
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
            contentType: 'application/json'
        })
    }
};