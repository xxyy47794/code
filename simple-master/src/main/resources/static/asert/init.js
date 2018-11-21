var vue = new Vue();
$.ajaxSetup({
    dataType:"json",
    contentType: 'application/json;charset=UTF-8',
    error: function (jqXHR, textStatus, errorThrown) {
        debugger;
        var status = 0;
        switch (jqXHR.status) {
            case (500):
                //TODO 服务器系统内部错误
                status = 500;
                break;
            case (401):
                //TODO 未登录
                status = 401;
                break;
            case (403):
                //TODO 无权限执行此操作
                status = 403;
                break;
            case (408):
                //TODO 请求超时
                status = 408;
                break;
            case (0):
                //TODO cancel
                break;
            default:
                status = 1;
            //TODO 未知错误
        }
        vue.$message.error('请求失败：'+textStatus);
    }
});

//深拷贝
function clone(obj) {
    // Handle the 3 simple types, and null or undefined
    if (null == obj || "object" != typeof obj) return obj;

    // Handle Date
    if (obj instanceof Date) {
        var copy = new Date();
        copy.setTime(obj.getTime());
        return copy;
    }

    // Handle Array
    if (obj instanceof Array) {
        var copy = [];
        for (var i = 0,len = obj.length; i < len; ++i) {
            copy[i] = clone(obj[i]);
        }
        return copy;
    }

    // Handle Object
    if (obj instanceof Object) {
        var copy = {};
        for (var attr in obj) {
            if (obj.hasOwnProperty(attr)) copy[attr] = clone(obj[attr]);
        }
        return copy;
    }

    throw new Error("Unable to copy obj! Its type isn't supported.");
}