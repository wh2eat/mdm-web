/**
 * 项目JS主入口 以依赖layui的layer和form模块为例
 */
layui.define([ 'jquery', 'layer', 'element' ], function(exports) {
    var form = layui.form;
    var $ = layui.$;

    $(".sv-button-load-content").click(function() {
        var actionName = $(this).attr("name");
        var contentUrl = $(this).attr("contentUrl");
        $(".sv-main-content").load(contentUrl, {}, function() {
            console.log("load finish.");
        });
    });

    $("a[name=logoutBtn]").click(function() {
        $("form[name=logoutForm]").submit();
    });

    exports('userIndex', {}); // 注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});
