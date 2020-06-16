/*
base.js-a020170815gz for wlw2017
*/


/*** 实例 公用部分 ***/


var a0all=$('.jsall,body,jspopall');
	
a0CkAll('.ckall','.ckrev','.ckyes');


/*** 界面函数***/



/** 一组对象 反复tog**/
/*不牵扯*/
function a0Tog0(where,a,hdr){
	var w=$(where);
	w.on('click',a,function(ev){
		ev.stopPropagation();
		var os=w.find(a),o=$(this),oi=os.index(o),ots=os.not(o);
		o.toggleClass('on');
		if(typeof(hdr)!='undefined'){hdr(w,os,o,oi,ots);}
	});
}/*0.5*/
/*牵扯*/
function a0Tog(where,a,hdr){
	var w=$(where);
	w.on('click',a,function(ev){
		ev.stopPropagation();
		var os=w.find(a),o=$(this),oi=os.index(o),ots=os.not(o);
		o.toggleClass('on'),ots.removeClass('on');
		if(typeof(hdr)!='undefined'){hdr(w,os,o,oi,ots);}
	});
}/*0.5*/



/** 两组对象 反复tog**/
/*不牵扯。比如菜单 */
function a0Togs0(where,a,b,hdr){
	var w=$(where);
	w.on('click',a,function(ev){
		ev.stopPropagation();
		var os=w.find(a),o=$(this),oi=os.index(o),ots=os.not(o);
		var ps=w.find(b),p=ps.eq(oi),pts=ps.not(p);
		
		o.toggleClass('on');
		p.toggleClass('now');
		
		if(typeof(hdr)!='undefined'){hdr(w,os,o,ps,p,oi,ots,pts);}
	});
}/*0.5*/
/** 两组对象 反复tog**/
/*牵扯。比如手风琴 */
function a0Togs(where,a,b,hdr){
	var w=$(where);
	w.on('click',a,function(ev){
		ev.stopPropagation();
		var os=w.find(a),o=$(this),oi=os.index(o),ots=os.not(o);
		var ps=w.find(b),p=ps.eq(oi),pts=ps.not(p);
		
		o.toggleClass('on'),ots.removeClass('on');
		p.toggleClass('now'),pts.removeClass('now');
		
		if(typeof(hdr)!='undefined'){hdr(w,os,o,ps,p,oi,ots,pts);}
		fuwei=o.attr('fuwei');
	});
}/*0.5*/

//关闭打开的tog
function a0TogOff(a,b){
	$('.jsall').on('click',function(ev){
		var tar=$(ev.target);o=tar.closest(a),p=tar.closest(b);
		
		if(!o.length && !p.length || tar.hasClass('maskbg') ){
			var o=a0all.find(a).filter('.on');
			o.click();
		}
	});

}/*0.5*/





/** 一组对象 **/
/*不牵扯 此用法少见*/
function a0Alt0(where,a,hdr){
	var w=$(where);
	w.on('click',a,function(ev){
		ev.stopPropagation();
		var os=w.find(a),o=$(this),oi=os.index(o),ots=os.not(o);
		o.addClass('on');
		if(typeof(hdr)!='undefined'){hdr(w,os,o,oi,ots);}
	});
}/*0.5*/
/*牵扯 交替alt 比如按钮组*/
function a0Alt(where,a,hdr){
	var w=$(where);
	w.on('click',a,function(ev){
		ev.stopPropagation();
		var os=w.find(a),o=$(this),oi=os.index(o),ots=os.not(o);
		o.addClass('on'),ots.removeClass('on');
		if(typeof(hdr)!='undefined'){hdr(w,os,o,oi,ots);}
	});
}/*0.5*/


/** 两组对象 **/
/*不牵扯 此用法少见*/
function a0Tabs0(where,a,b,hdr){
	var w=$(where);
	w.on('click',a,function(ev){
		ev.stopPropagation();
		var os=w.find(a),o=$(this),oi=os.index(o),ots=os.not(o);
		var ps=w.find(b),p=ps.eq(oi),pts=ps.not(p);
		
		o.addClass('on');
		p.addClass('now');
		
		if(typeof(hdr)!='undefined'){hdr(w,os,o,ps,p,oi,ots,pts);}
	});
	w.on('click',b,function(ev){
		//ev.stopPropagation();
	});
	
}/*0.5*/
/*牵扯 交替tab 比如选项卡*/
function a0Tabs(where,a,b,hdr){
	var w=$(where);
	w.on('click',a,function(ev){
		//ev.stopPropagation();
		var os=w.find(a),o=$(this),oi=os.index(o),ots=os.not(o);
		var ps=w.find(b),p=ps.eq(oi),pts=ps.not(p);
		
		o.addClass('on'),ots.removeClass('on');
		p.addClass('now'),pts.removeClass('now');
		
		if(typeof(hdr)!='undefined'){hdr(w,os,o,ps,p,oi,ots,pts);}
	});
	
}/*0.5*/



/** 两组对象 多对一模式 比如 ajax 获取数据 或 公共弹层 或弹窗 ，可用专门插件处理。或 a0Alt(where,a,hdr) 按钮组带hdr即可多对一 **/








/*** 委托式 js全选反选20170504 飞龙 供同行参考使用 ***/	

 
function a0CkAll(a,b,c,hdr){
	
	var where=$('.jsall,.jspopall,.jspopscr');

	var ckall=$(a),ckrev=$(b),ckits,ckeds,cknoeds;	

	where.on('click',c,function(ev){
		
		var p=$(this);if(typeof(hdr)!='undefined'){hdr(p);}

		if($(this).prop('checked')){
			
			cknoeds=where.find(c).not(':checked');
			if(cknoeds.length){ckall.prop('checked',false);
		
			}else{ckall.prop('checked',true);}

		}else{
			ckall.prop('checked',false);
		}
		

	});

	ckall.on('click',function(ev){
		
		if($(this).prop('checked')){console.log('$(this)=',$(this));
			ckits=where.find(c).not(':checked').trigger('click');

		}else{
			ckits=where.find(c).filter(':checked').trigger('click');
		}

		ckrev.prop('checked',false);

	});

	ckrev.on('click',function(ev){
	 ckits=where.find(c).trigger('click');

	});

}/*0.5*/



/*0*/$(function(){
  $('.cotb').each(function(i,el){
	var cotb=$(this),tb6=cotb.find('.tb6,.tb8');
	if(cotb.height()-tb6.height()>10){
		cotb.removeClass('tb6bb0');
	}else{
		cotb.addClass('tb6bb0');
	}
	
	
});
});/*0*/



 

/*
flscts.js-fl20180110gz 完整版 管或不管宽度
Author URI: http://feilong.org
*/



function flscts(a,onfn){
var scts=$(a);scts.length && scts.each(function(i,el){/*1*/

/*本页内sct对象准备*/
var sct=$(el),sv=sct.children('.s,.v'),s=sct.find('.s'),
kv=sct.find('.kv'),c=sct.find('.c'),
otscts=scts.not(scts[i]);





/*点击每个 sv 时候 展开c, 再次点击sv 关闭c*/
var evt=sct.attr('evt');
if(evt=='hover'){
		sct.hover(function(){
		sct.addClass('scton');otscts.removeClass('scton');
		},function(){
		sct.removeClass('scton');
		});
}else{
		sv.click(function(ev){ev.stopPropagation();
		sct.toggleClass('scton');otscts.removeClass('scton');
});
}/*2*/






/*委托 如果是 单选项select模式, 则点击c中的 某个t 时,给此t添加 now样式，把t的rel值传给kv，把t的嵌套文本传给s，然后关闭c.
tok 单选项select模式 还是 链接挑转模式， 默认值:'1' 单选项select模式
*/
c.on('click','.t',function(ev){
ev.stopPropagation();
var tok=sct.attr('tok');tok=tok?tok:'1';var t=$(ev.currentTarget);
var tno=t.hasClass('tno');
if(tok=='1' && !tno){
flsctt(i,sct,t,onfn);
}
});/*2*/


//显示预置的值
var pre=sct.attr('pre');
flsctpre(i,sct,pre,onfn);

//预置宽度
var swi=sct.attr('swi');
if(swi!='auto'&& parseFloat(swi)||swi=='auto'){
	flsctswi(sct,swi);
}






});




/*点击其它区域关闭页面的sct*/
$('.jsall').click(function(ev){scts.removeClass('scton');});

}/*0.5*/






/*按给定t，改变sct*/
function flsctt(i,sct,t,onfn){
	var c=sct.find('.c'),kv=sct.find('.kv'),kv=sct.find('.kv'),s=sct.find('.s'),ts=c.find('.t');
	var trel=t.attr('rel'),thtml=t.html(),oldkv=c.find('.now').attr('rel'),j=ts.index(t);
		if(onfn!==undefined){onfn(i,trel,oldkv,t,j);}
		t.addClass('now').siblings('.t').removeClass('now');
		kv.val(trel);c.attr('oldkv',oldkv);s.html(thtml);
		sct.removeClass('scton');
}/*0.5*/

/*按给定pre,预置/后置 改变sct */
function flsctpre(i,sct,pre,onfn){
if(pre){
var t=sct.find('.c').find('[rel='+pre+']');
if(t.length){sct.attr('pre',pre);flsctt(i,sct,t,onfn);}else{
	console.log(sct),console.log('预置/改变 失败，找不到对应opt值:'+pre);
	}
}
}/*0.5*/


/*给某个sct自适应宽或预置宽*/
function flsctswi(sct,swi){
var c=sct.find('.c'),v=sct.find('.v');swi=swi?swi:'auto';sct.attr('swi',swi);
if(swi=='max'){
	sct.removeClass('bzb');
	c.removeClass('cwi');
	var swi=c.width()+v.width();
}
sct.width(swi);

c.addClass('cwi');
sct.addClass('bzb');
}/*0.5*/


var althdr=function(w,os,o,oi,ots){
os.removeClass('prev');
 if(oi){
 os.eq(oi-1).addClass('prev');
 }
};/*0.05*/
//a0Alt('.jsalts','.jsalt',althdr);


var althdr=function(w,os,o,oi,ots){
os.removeClass('prev');
 if(oi){
 os.eq(oi-1).addClass('prev');
 }
};/*0.05*/
//a0Alt('.jsalts','.jsalt',althdr);

var tabhdr=function(w,os,o,ps,p,oi,ots,pts){
os.removeClass('prev');
 if(oi){
 os.eq(oi-1).addClass('prev');
 }
};/*0.05*/
//a0Tabs('.jstabs','.jstab','.jstabcnt',tabhdr);



	
//根据菜单索引值，模拟点击
function a0mnon(m,n){
	var mnps=parent.$('.mnp',window.parent.document);
	var mnp=mnps.eq(m);
	var mnas=mnp.find('.mna');
	var mna=mnas.eq(n);
	mna.click();
	window.location.href=mna.attr('href');
}/*0.5*/	
	

/*feilong.org-20150709-gz-end*/

/*****feilong-a020170318gz-org*****/