/*
a0tomask.js-20170823gz
Author URI: http://feilong.org
*/






/*click to insert a iframe and display the mask*/
function a0tomask(to,mm,toparent,hdr){
// alert('s8');
	  
	//获取 蒙版对象
	var mask=toparent?$(mm,window.parent.document):$(mm);//alert('4mask='+mask.length);
	
	var maskin=mask.find('.maskin');
	
	var totp=typeof(to);
	//console.log('totp=',totp);
	if(totp=='object'){

	//获取个性参数, to为 单个激发对象 
	var src=to.attr('href');
	
	
	}else{
		var src=to;
	}
	//console.log('src=',src);

	//与公用参数（commondata）整合,现去掉了，避免 js中夹杂 后台语言. 
	//if(src.indexOf('?')!=-1){src=src+'&'+commondata;}else{src=src+'?'+commondata;}
	//alert('s5'+src);
	//console.log('src=',src);

	//动态生成iframe
	var ifr=$('<iframe class="ifrpre maskifr" src="'+src+'" frameborder="0"></iframe><i class="maskshut">X</i>');
	   //console.log(mask.find('.maskin').length);
	   
	   //console.log('ifr=',ifr);

	//插入iframe
	maskin.width('').html(ifr);

	//激活 激发页 的 外关闭
	//a0shutmask('.maskshut',mm,false,hdr);
	//a0shutmask('.maskbg',mm,false,hdr);

	//ios兼容iframe滚动
	var isios=navigator.userAgent.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
	if(isios){maskin.addClass('maskios');}
	
	//预先给 maskin 设 wi
	if( totp=='object' && to.attr('wi') ){maskin.width(parseInt(to.attr('wi')));}


}/*0.5*/





/* get pop height then get mask height and popout */
function a0maskheight(popmodstr,mm,preboxhi){
	
	  //alert('loaded1');
	var popmod=$(popmodstr);
	//console.log(popmod.length+'len');
		
	var myheight=function(){

		//检查本网页是否被容纳在iframe中	
		var ifrdom=window.frameElement && window.frameElement || '', ifrhome=$(ifrdom);
		//如果被容纳
		if(ifrhome.length){
			ifrhome.removeClass('ifrpre');
			//console.log('我被容进来了');

			var pwinwi=window.parent.document.documentElement.clientWidth;//alert(pwinwi);
			var pwinhi=window.parent.document.documentElement.clientHeight;//alert(pwinhi);
			var maxwi=pwinwi*0.90;//alert(maxwi);
			var maxhi=pwinhi*0.93;//alert(maxhi);

			var boxhi=0;
			if(preboxhi){boxhi=preboxhi;}else{boxhi=popmod.height();}
			 //console.log(boxhi,'?=',maxhi);
			  /*需在ip访问协议，否则需定好高度*/

			var myhi=0;
			if(boxhi>=maxhi){myhi=maxhi;}else{myhi=boxhi;}
			//console.log(myhi);
			 

			

			popmod.css('max-width',maxwi+'px');	
			
			$('.jspopscr').height(myhi);


			
			var ifrbaba=ifrhome.closest('.maskin'),ifryeye=ifrbaba.closest('.mask');
			ifrbaba.height(myhi).css('max-width',maxwi+'px').width(ifrbaba.attr('wi'));
			ifryeye.width(pwinwi).height(pwinhi);
			  //alert('maskin='+ifrbaba.height());

			ifryeye.removeClass('vh'); 
		}		
	};	
			
	myheight();
	$(window.parent).on('resize',myheight);
	popmod.bind('DOMNodeInserted', myheight);

}/*0.5*/





function a0shutmask(a,mm,shutparent,hdr){
	$('.jsall,body').on('click',a,function(ev){
		if(hdr!=undefined){hdr();}
		
		a0shutmask0(mm,shutparent);
	});
}/*0.5*/



/*shut parent or self's mask */
function a0shutmask0(mm,shutparent){

	if(shutparent){
		//var ifrhomeid=window.frameElement && window.frameElement.id || '';
		//var ifrhome=$('#'+ifrhomeid,window.parent.document);
		var ifrdom=window.frameElement && window.frameElement || '', ifrhome=$(ifrdom);
		var maskin=ifrhome.closest('.maskin'),mask=maskin.closest('.mask');
		//console.log('maskin.length='+mask.length);
	}else{
		var mask=$(mm),maskin=mask.find('.maskin'); // alert('mask='+mask.length);
		//console.log('maskin.length='+mask.length);
		var ifrhome=mask.find('.maskifr'); //alert(ifr.length);
	}

	maskin.html('');//pbody.removeClass('oh');
	mask.addClass('vh');

}/*0.5*/






/*feilong.org-20150413-cs-end*/