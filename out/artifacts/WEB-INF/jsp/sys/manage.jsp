<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="renderer" content="webkit|ie-stand"/>
    <meta http-equiv="X-UA-Compatible" content="IE=11;IE=10;IE=9;IE=edge,chrome=1"/>
    <meta name="viewport"
          content="initial-scale=1.0, width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="format-detection" content="telephone=no, email=no"/>
    <meta name="msapplication-tap-highlight" content="no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="x5-page-mode" content="app"/>
    <meta name="browsermode" content="application"/>
    <meta name="wap-font-scale" content="no"/>
    <link href="${pageContext.request.contextPath}/static/skin/a_nlkf.css" rel="stylesheet">
    <title>个人中心后台</title>
    <script type="text/javascript">
        var page = "${pageContext}";

        $(function () {
            alert(page);
        });
    </script>
</head>
<body id="n0backend">

<div class="jsall scr i0all">


    <div class="heado2">
        <div class="head2 cf">
            <h1>
                <a class="logo2 ht" href="">
                    pokemonWIKI
                </a>
            </h1>
            <p class="cut2 cf">
                <a class="i0log2" href="">登录</a>
                <a class="i0reg2" href="">注册</a>
            </p>
            <ul class="nav2 cf">
                <li><a href="">首页</a></li>
                <li class="on"><a href="${ctx}/skill/list">技能列表</a></li>
                <li><a href="${ctx}/pokemon/list">精灵列表</a></li>
                <li><a href="">管理中心</a></li>
            </ul>
            <!-- head2 --></div>
        <!-- heado2 --></div>


    <div class="g0admin">

        <div class="g0left">
            <ul class="i0menu cf usn" id="i0menu">
                <li class="hide">
                    <a class="blk i0mnh mnhsy jsmnh" href="" target="cpifr">首页</a>
                    <p class="jsmnp"></p>
                </li>
                <li>
                    <h4 class="i0mnh mnhzl jsmnh on">技能查询</h4>
                    <p class="i0mnp jsmnp now">
                        <a class="i0mna jsmna" href="${ctx}/skill/list" target="mainFrame">技能列表</a>
                    </p>
                </li>
                <li>
                    <h4 class="i0mnh mnhaq jsmnh">精灵查询</h4>
                    <p class="i0mnp jsmnp">
                        <a class="i0mna jsmna" href="${ctx}/pokemon/list" target="mainFrame">精灵列表</a>
                    </p>
                </li>
                <li>
                    <h4 class="i0mnh mnhaq jsmnh">系统管理</h4>
                    <p class="i0mnp jsmnp">
                        <a class="i0mna jsmna" href="" target="mainFrame">字典配置</a>
                    </p>
                </li>


            </ul>
            <!--g0left--></div>

        <div class="g0right">
            <iframe class="i0frame" id="rightFrame" name="mainFrame" src="" frameborder="0"></iframe>
            <!-- g0right --></div>

        <!--g0admin--></div>


    <!--jsall screen --></div>


<div class="mask vh tac" id="flmask4">
    <i class="maskbg"></i>
    <div class="inb maskin tal"></div>
    <i class="inb ht1"></i>
    <!--mask --></div>

<div class="mask vh tac" id="flmask6">
    <i class="maskbg"></i>
    <div class="inb maskin tal"></div>
    <i class="inb ht1"></i>
    <!--mask --></div>

<div class="mask vh tac" id="flmask8">
    <i class="maskbg"></i>
    <div class="inb maskin tal"></div>
    <i class="inb ht1"></i>
    <!--mask --></div>


<!--为提高页面渲染和防止js阻塞，请统一将js放在页面尾部！ feilong -->


<!-- 公用js-->
<script src="${ctxStatic}/js/jquery.js"></script>
<script src="${ctxStatic}/js/a_base.js"></script>


<!-- 本页独有js-->
<script src="${ctxStatic}/js/a_tomask.js"></script>
<script>
    /*0*/
    $(function () {




        /**左侧菜单 **/
        /**页头的 menu 菜单 js做法 **/
        var jsmnhhdr = function (w, os, o, ps, p, oi, ots, pts) {
            console.log('jsmnhhdr=', o.html());
        };
        a0Togs('#i0menu', '.jsmnh', '.jsmnp');
        var menuhdr = function (w, os, o, oi, ots) {
        };
        a0Alt('#i0menu', '.jsmna');


        /* 页头的 menu 菜单 css 做法
        var jsmnahdr=function(w,os,o,oi,ots){
            $('#i0menu .jsmna').removeClass('on');
            o.addClass('on');
            $('#i0menu .jsmnh').removeClass('on');
            o.closest('li').find('.jsmnh').addClass('on');
        };a0Alt('#i0menu','.jsmna,.mnhsy',jsmnahdr);
         */


        /**蒙版 **/
        /*mask.html, to shut flmask4 */
        a0shutmask('#flmask4 .maskshut', '#flmask4', false);

        /*mask.html, to shut flmask6 */
        a0shutmask('#flmask6 .maskshut', '#flmask6', false);

        /*mask.html, to shut flmask8 */
        a0shutmask('#flmask8 .maskshut', '#flmask8', false);


    });
    /*0*/
</script>
<script type="text/javascript">
    $(document).ready(function () {
        console.log($('li .now:first'));
        var src = $('li .now:first').find("a").attr("href");
        $("#rightFrame").attr("src", src);
    });
</script>
</body>
</html>
