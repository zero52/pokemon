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
    <link href="${ctxStatic}/skin/a_nlkf.css" rel="stylesheet">
    <title>字典列表</title>
</head>
<body id="nl_wode">


<div class="jsall scr bgk2 jstogs">

    <div class="g1here">
        <h4 class="g1mbx cf">
            <b class="g1wz">当前位置 >> 系统管理 >> 字典配置</b>
        </h4>
        <!-- g1here --></div>


    <div class="g1cnt cf">

        <form class="g1form rel z3 mt15 cf b bgw2 r" method="" action="">
            <ul class="fib tkz6 fb2 fz2 cf">

                <li>
                    <label>标签：</label>
                    <input class="ipu ipua w9 r" placeholder="标签" name="label" type="text"/>
                </li>
                <li>
                    <label>类型：</label>
                    <p class="sct scta r" swi="auto" pre="" id="">
                        <b class="s">全部</b><i class="v"></i>
                        <input class="kv" name="type" value="" type="hidden"/>
                        <b class="c">
                            <i class="t">全部</i>
                            <c:forEach items="${typeList}" var="typeList">
                                <i class="t" rel="${typeList.value }">${typeList.label}</i>
                            </c:forEach>
                        </b>
                    </p>
                    <input class="ipu ipua w9 r" placeholder="类型" name="type" type="text"/>
                </li>


                <li>
                    <label>描述：</label>
                    <input class="ipu ipua w9 r" placeholder="描述" name="description" type="text"/>
                </li>

                <!-- 			<li>
                                <label>分类：</label>
                                <p class="sct scta r" swi="auto" pre="" id="">
                                    <b class="s">请选择</b><i class="v"></i>
                                    <input class="kv" name="ccc" value="" type="hidden"/>
                                    <b class="c">
                                        <i class="t">全部分类</i>
                                        <i class="t" rel="a">查询类</i>
                                        <i class="t" rel="b">订购类</i>
                                        <i class="t" rel="b">支付类</i>
                                        <i class="t" rel="b">积分类</i>
                                    </b>
                                </p>
                            </li> -->

                <!-- 			<li title="从哪一天到哪一天">
                                <label>申请时间：</label>
                                <input id="a0day0" placeholder="开始日期" class="Wdate ipu ipua w9 r" type="text" onFocus="var a0day1=$dp.$('a0day1');WdatePicker({onpicked:function(){a0day1.focus();},maxDate:'#F{$dp.$D(\'a0day1\')}'})"/>
                                <i class="inb">至</i>
                                <input id="a0day1" placeholder="结束日期" class="Wdate ipu ipua w9 r" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'a0day0\')}'})"/>
                            </li> -->

                <!-- 			<li>
                                <label>申请状态：</label>
                                <p class="sct scta r" swi="auto" pre="" id="">
                                    <b class="s">请选择</b><i class="v"></i>
                                    <input class="kv" name="ccc" value="" type="hidden"/>
                                    <b class="c">
                                        <i class="t">全部</i>
                                        <i class="t" rel="a">子类a</i>
                                        <i class="t" rel="b">子类b</i>
                                    </b>
                                </p>
                            </li> -->

                <li>
                    <a class="btn btnbz w6 r jstomask" href="" id="">查询</a>
                </li>

            </ul>
        </form>


        <div class="g1mod mt6">
            <h3 class="g1mh imh imh12">字典列表</h3>
            <div class="cotb mt15 tb6bb0">
                <table class="tb6">
                    <thead>
                    <tr>
                        <th>键值</th>
                        <th>标签</th>
                        <th>类型</th>
                        <th>描述</th>
                        <th>排序</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="list">
                        <tr>
                            <td>${dict.value}</td>
                            <td>${dict.label}</td>
                            <td>${dict.type}</td>
                            <td>${dict.description}</td>
                            <td>${dict.sort}</td>
                            <td></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!-- cotb --></div>
            <!--g1mod --></div>


        <!-- 	<ul class="fl ml6 fib tkz6 fb2 fz2 cf">
                <li class="rel"><b class="btn btnyx r w6 r">导出</b></li>
                <li class="rel"><b class="btn btnbz r w6 r">调整次数</b></li>
            </ul> -->


        <!-- <div class="pagebar cex12 fz2 cf">
            <p class="fr ml12">
                 <b class="inb">第</b>
                <input class="ipu ipua w4 tac r" max="" min="1" type="text" maxlength="3" />
                <b class="inb">页</b>
                <i class="inb ml12 on">跳转</i>
            </p>
            <p class="fr ml18">
                <i class="pagefirst mr6">首页</i>
                <a id="pageprev">上一页</a>
                <b class="cex9">
                    <i id="pagecurr" class="pagecurr">2</i>/<i id="pagemax">12</i>
                </b>
                <a class="pagenext">下一页</a>
                <i class="pagelast ml6">尾页</i>
            </p>

            <p class="fr lh2 mr">
                <em class="inb">
                共 <b id="datatotal">122</b> 条记录
                </em>
            </p>
        pagebar</div> -->


        <!-- g1cnt --></div>


    <!--jsall screen --></div>


<!--为提高页面渲染和防止js阻塞，请统一将js放在页面尾部！ feilong -->


<!-- 公用js-->
<script src="${ctxStatic}/js/jquery.js"></script>
<script src="${ctxStatic}/js/a_base.js"></script>
<script src="${ctxStatic}/plugins/my97/WdatePicker.js" charset="utf-8"></script>
<script src="${ctxStatic}/js/a_tomask.js"></script>

<!-- 本页独有js-->
<script>
    $(function () {//0


        /* to show #flmask4 in parent true */
        a0all.on('click', '.jstomask', function (ev) {
            ev.preventDefault();
            var jstomasks = a0all.find('.jstomask').removeClass('on');
            var jstomask = $(ev.currentTarget).addClass('on');
            a0tomask(jstomask, '#flmask4', true);
        });

        /*sct usage */
        function a1scton(i, trel, oldkv, t, j) {
            console.log('i,trel,oldkv,t,j = ', '此sct索引值' + i + ', 新t值' + trel + ', 旧t值' + oldkv + ', 点的第' + j + '个t');

        }

        flscts('.sct', a1scton);


        //日期格式判断
        $('#gotj').on('click', function (ev) {
            var dateby = $(this).attr('dateby');

            if (dateby == 'period') {
                var a0day0 = $('#a0day0').val();
                var a0day1 = $('#a0day1').val();
                dateis = a0day0 !== '' ? [a0day0, a0day1] : '0';
            } else if (dateby == 'yue') {
                dateis = $('#a0month').val();
            } else if (dateby == 'zhou') {
                dateis = $('#a0week').val();
            } else if (dateby == 'ri') {
                dateis = $('#a0day').val();
            }
            console.log('dateby=', dateby, '&& dateis=', dateis);

            if (dateis != '') {
                //开始请求数据，返回，改变下面的表格数据内容
            } else {
                alert('统计时间不能为空');
            }
        });


    });	//0

</script>


</body>
</html>
