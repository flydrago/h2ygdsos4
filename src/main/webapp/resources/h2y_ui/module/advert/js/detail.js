//商品轮播监听初始化
function carouselInit(zhuanQu){
		
	//不定额专场监听
	zhuanQu.find(".quan .quanq1").click(function(){
		var i=$(this).index();
		//alert(i);
		zhuanQu.find(".quan .quanq1").eq(i).addClass("quanqt").siblings().removeClass("quanqt");
		zhuanQu.find(".jiujiu_nav_nav ul li").eq(i).show().siblings().hide();
	})
	
	zhuanQu.mouseover(function(){
		$(this).attr("is_mousevoer",1);
	});
	
	zhuanQu.mouseup(function(){
		$(this).attr("is_mousevoer",0);
	});
	
	//setInterval("junmper()",1500);
}

function junmper(lunBoNum){
	
	//alert(currentIndex);
	var count = $("#bude_block_"+lunBoNum+" .quan .quanq1").length;
	var currentIndex = $("#bude_block_"+lunBoNum).attr("lunbo_index");
	currentIndex++;
	if(currentIndex>count) currentIndex=0;
	$("#bude_block_"+lunBoNum).attr("lunbo_index",currentIndex);

	//鼠标经过是停止轮播
	if($("#bude_block_"+lunBoNum).attr("is_mousevoer")==1) return;
	//alert(lunBoNum);
	$("#bude_block_"+lunBoNum+" .quan .quanq1").eq(currentIndex).addClass("quanqt").siblings().removeClass("quanqt");
	$("#bude_block_"+lunBoNum+" .jiujiu_nav_nav ul li").eq(currentIndex).show().siblings().hide();
	//alert(lunBoNum);
}

//创建定额专区
function createDE(activitData,goodsList){
	
	//专区副本
	var zhuanQuClone = $("#de_block").clone();
	
	zhuanQuClone.prepend(createNav(activitData.title));//设置导航标题
	
	zhuanQuClone.removeAttr("id");
	zhuanQuClone.find(".chunye_nav_naver").html("");//清空之前的商品模板
	
	$(goodsList).each(function(){
		
		//商品副本
		var goodsClone = $("#de_block #de_goods_block").clone();
		goodsClone.removeAttr("id");
		
		if(this.goodsNickName.length>8){
			this.goodsNickName = this.goodsNickName.substring(0, 8)+"...";
		}
		if(activitData.memo.length>3){
			activitData.memo = activitData.memo.substring(0, 3);
		}
		
		goodsClone.find(".span1").html(this.goodsNickName);//设置商品名称
		goodsClone.find(".span3").html("¥"+this.singlePrice);//设置商品活动价
		goodsClone.find(".de_goods_img").attr("src","http://pic.jydapp.com:91/image/show.htm"+this.img);//设置商品图片
		goodsClone.find(".de_goods_img").attr("onclick","javascript:click_detail("+this.id+");");//设置商品图片点击事件
		goodsClone.find(".buy_href").attr("href","javascript:buyGoods("+this.id+");");//设置购买方法
		goodsClone.find(".ymd .ymd_img").html(activitData.memo);
		
		goodsClone.show();
		zhuanQuClone.find(".chunye_nav_naver").append(goodsClone);
	});
	zhuanQuClone.show();
	$("#activity_zhuanqu").append(zhuanQuClone);
}

var lunBoNum = 0;
//创建不定额专区
function createNoDE(activitData,goodsList){
	
	//专区副本
	var zhuanQuClone = $("#bude_block").clone();
	zhuanQuClone.removeAttr("id");
	lunBoNum++;
	zhuanQuClone.attr("id","bude_block_"+lunBoNum)
	zhuanQuClone.attr("lunbo_index",0);//设置轮播初始索引
	zhuanQuClone.prepend(createNav(activitData.title));//设置导航标题
	zhuanQuClone.find("ul").html("");
	
	//获取需要补上的记录数
	var remainNum = $(goodsList).length%3;
	
	var listClone;
	$(goodsList).each(function(i){
		
		if(i%3==0){
			listClone = $("#bude_block li").clone();//列表
			listClone.html("");
			zhuanQuClone.find("ul").append(listClone);//添加商品列表
			zhuanQuClone.find(".quan").append("<div class=\"quanq1\"></div>");
		}
					
		//商品副本
		var goodsClone = $("#bude_block li .jiujiu_nav_naver").clone();
		
		if(this.goodsNickName.length>15){
			this.goodsNickName = this.goodsNickName.substring(0, 15)+"...";
		}
		
		if(activitData.memo.length>3){
			activitData.memo = activitData.memo.substring(0, 3);
		}
			
		goodsClone.find(".jiujiu_nav_baijia01").html(this.goodsNickName);//设置商品名称
		goodsClone.find(".jiujiu_nav_naverr img").attr("src",fpPath+this.img);//设置商品图片
		goodsClone.find(".jiujiu_nav_naverr img").attr("onclick","javascript:click_detail("+this.id+");");//设置商品图片点击事件
		goodsClone.find(".jiujiu_nav_baijia a").attr("href","javascript:buyGoods("+this.id+");");//设置购买方法
		goodsClone.find(".ymd .ymd_img").html(activitData.memo);//设置左上角logo
		listClone.append(goodsClone);
		
		
		//在最后一条数据后补齐高度
		if(remainNum>0 && $(goodsList).length == (i+1)){
			var imgWidth = goodsClone.find(".jiujiu_nav_naverr img").width();			
			var divWidth = imgWidth + parseInt(40) + parseInt(120);
			var remainDivHtml = '<div style="width:100%;height:'+divWidth+'px"></div>';
			for(var r=remainNum;r<3;r++){				
				zhuanQuClone.find("li:last").append(remainDivHtml);
			}
			
		}
		
		
	});
	
	var lunBoSize = zhuanQuClone.find("li").length;
	//if(lunBoSize>3){
		zhuanQuClone.find(".jiujiu_nav_nav ul").css({"width":lunBoSize*100+"%"});
		zhuanQuClone.find(".jiujiu_nav_nav ul li").css({"width":(100/lunBoSize-4)+"%"});
	//}
	zhuanQuClone.find(".jiujiu_nav_nav .quan").css({"width":lunBoSize*55+"px","margin-left":"-"+lunBoSize*55/2+"px"});
	zhuanQuClone.show();
	zhuanQuClone.find(".quan :eq(0)").addClass("quanqt");
	carouselInit(zhuanQuClone);//轮播初始化
	$("#activity_zhuanqu").append(zhuanQuClone);
	
	setInterval("junmper("+lunBoNum+")",2000);
}




//创建导航栏
function createNav(title){
	
	//专区副本
	var navClone = $("#nav_title").clone();
	navClone.find("span").html(title);
	navClone.show();
	navClone.css({"margin-bottom":"12px"});
	
	return navClone;
}

//获取优惠券数据
var claimedText = "您已领取!";
function getCouponsData(){
	
	var postData = {};
	postData.account = memberAccount;
	postData.subjectId = subjectId;
	postData.zoneCode = zoneCode;
	postData.page = 1;
	postData.pagesize = 10;

    $.post("cmbs/coupons/getPosterCouponsList.htm",{postData:JSON.stringify(postData)},function (data) {
    	//alert(data);
    	
    	if('' != data && undefined != data){
    		
    		var jsonReturn = eval("(" + data + ")");
	    	 var couponsHtml = '<div class="box">';
			 var len = jsonReturn.resultData.length;
			 if(len>0){
				 $(".container .main").prepend(createNav("百万礼券免费送"));//设置导航标题createNav("100万优惠劵大发送");
			 }else{
				 $(".container .main").hide();
			 }
			 
			 //遍历优惠券列表
	    	 for(var i=0;i<len;i++){
	    		 var j = i;
	    		 var jsonDetail = jsonReturn.resultData[i];
	    		 //处理点击领取按钮
	    		 var clickClaimHtml = '<a href="javascript:claimCoupons(\''+jsonDetail.couponsId+'\',\''+jsonDetail.coupons_code+'\','+i+')">点击领取</a>';
	    		 if(jsonDetail.couponsFlag == 1 || jsonDetail.couponsFlag == '1'){
	    			 //clickClaimHtml = '已领取';	    			 
	    			 clickClaimHtml = '<a href=\'javascript:claimedMsg("'+claimedText+'")\'>已领取</a>';
	    		 }
	    		 
	    		 //由于只设置了6个样式例如img1~img6，如果优惠券数量大于6，样式需要重复使用前边样式
	    		 if(i>=6){
	    			 j=i-6;
	    		 }
	    		  
	    		  if((i+1)%3 == 0){
	    			  couponsHtml += '<div class="img img'+(j+1)+'">';
	    		  }else{
	    			  couponsHtml += '<div class="img img'+(j+1)+'">';
	    		  }
	    		  
	    		  if(jsonDetail.coupons_name.length>5){
	    			  jsonDetail.coupons_name = jsonDetail.coupons_name.substring(0, 5)+"...";
	    		  }
	    		  
	    		  couponsHtml += '<div class="img_img">'+
	    		 						'<span class="img_img_txt img_img_txt_img'+(j+1)+'">'+jsonDetail.coupons_name+'</span><br/>'+
	    		 						'<span class="img_img_txt1">'+
	    		 							'<strong class="img_img_biao">￥</strong>'+
	    		 							'<strong class="img_img_ge img_img_ge'+(j+1)+'">'+jsonDetail.coupons_balance+'</strong>'+
	    		 						'</span><br/>'+
	    		 						'<div id="clickClaimDiv_'+i+'" class="img_img_txt img_img_txt_a'+(j+1)+'">'+
	    		 								clickClaimHtml +
	    		 						'</div><br/>'+
	    		 						'<span class="img_img_txt2 img_img_txt2_span'+(j+1)+'">'+jsonDetail.short_name+'专享</span>'+
	    		 					'</div>'+
                       	 			'<div class="ding ding1">'+
                        				'<p class="dingwei1">优惠劵</p>'+
                        			'</div>'+
                        		'</div>';
	    		  if((i+1)%2 == 0){
					couponsHtml +='</div>';
					if((i+1)!=len)
						couponsHtml +='<div class="box">';
	    		  }	    		  
	    	 }
	    	 
	    	 $("#coupons_div").append(couponsHtml);
    		
    	}
    	 
    });
}

//领取优惠券
function claimCoupons(couponsId,coupons_code,i){
	var postData = {};
	if(undefined == memberAccount || '' == memberAccount){//未登陆
		opFlag = 1; //app处理
		postData.opFlag = opFlag;
		postData.opMoudle = 2;//1 shopingcart_app 2 member_app 3 goods_detail
		var postDataJson = JSON.stringify(postData);
		if(getOs() == "isAndroid"){//android
			jydJs_App.requestApp(postDataJson);
		}else if(getOs() == "isiOS"){//ios操作			
			window.location.href = "\*"+postDataJson;
		}else{
			//window.location.href = "http://d.jydapp.com:88/cmbs/down.html";
			var appOs = getAppOs();//获取手机操作系统
			if(isWeiXin()){
				alert("腾讯用户请复制链接在浏览器中打开!");
			}else{
				if(appOs == "isAndroid"){//android
					//window.location.href = "jydclient://openApp";
					window.location.href = "jydclient://openApp?postData="+postDataJson;
				}else if(appOs == "isiOS"){//ios操作				
					window.location.href = "jydclient://open?postData="+postDataJson;
				}else{
					window.location.href = "http://d.jydapp.com:88/cmbs/down.html";
				}
				setTimeout(function(){
					window.location.href = "http://d.jydapp.com:88/cmbs/down.html";//如果超时就跳转到app下载页
				},500);
			}
		}
		
	}else{
		opFlag = 0; //app处理
		postData.sourceCode = 'posterSend';
		postData.account = memberAccount;
		postData.couponsId = couponsId;
		postData.couponsCode = coupons_code;
		
		$.post("cmbs/coupons/addCoupons.htm",{postData:JSON.stringify(postData)},function (data) {
			if('' != data && undefined != data){
	    		var jsonReturn = eval("(" + data + ")");
	    		
	    		if(jsonReturn.resultFlag == 1){//操作成功	    			
	    			toastShow("优惠劵领取成功!");
	    			//$("#clickClaimDiv_"+i).html('已领取');
	    			$("#clickClaimDiv_"+i).html('<a href=\'javascript:claimedMsg("'+claimedText+'")\'>已领取</a>');
	    		}else{
	    			toastShow(jsonReturn.resultMsg);
	    		}
			}
		});
	}
	
	
}


//获取商品数据
function getGoodsData(){
	
	var postData = {};
	postData.id = subjectId;
	
    $.post("cmbs/advert/getPosterActivityData.htm",{postData:JSON.stringify(postData)},function (data) {
    	
    	//alert(data);
    	if('' != data && undefined != data){
    		var jsonReturn = eval("(" + data + ")");
    		
    		if(jsonReturn.resultFlag == 1){
    			//循环活动数据
    			$(jsonReturn.resultData).each(function(){
    				
    				var dataType = this.dataType;
    				var goodsList = this.goodsData;
    				
    				if(dataType==3){//定额商品
    					
    					createDE(this,goodsList);
    				}else{//不定额商品
    					
    					createNoDE(this,goodsList);
    				}
    			})
    		}
    	}
    })
}

//立即购买 - 加入购物车
function buyGoods(id){
	opFlag = 1; //app处理
	
	var postData = {};
	postData.opFlag = opFlag;
	postData.goodsPriceId = id;
	postData.opMoudle = 1;//1 shopingcart_app 2 member_app 3 goods_detail
	var postDataJson = JSON.stringify(postData);
	if(getOs() == "isAndroid"){//android
		jydJs_App.requestApp(postDataJson);
	}else if(getOs() == "isiOS"){//ios操作
		window.location.href = "\*"+postDataJson;
	}else{
		//window.location.href = "http://d.jydapp.com:88/cmbs/down.html";
		var appOs = getAppOs();//获取手机操作系统
		if(isWeiXin()){
			alert("腾讯用户请复制链接在浏览器中打开!");
		}else{
			if(appOs == "isAndroid"){//android
				//window.location.href = "jydclient://openApp";
				window.location.href = "jydclient://openApp?postData="+postDataJson;
			}else if(appOs == "isiOS"){//ios操作				
				window.location.href = "jydclient://open?postData="+postDataJson;
			}else{
				window.location.href = "http://d.jydapp.com:88/cmbs/down.html";
			}
			setTimeout(function(){
				window.location.href = "http://d.jydapp.com:88/cmbs/down.html";//如果超时就跳转到app下载页
			},500);
		}
	}
	
}


//点击图片跳转到详情页
function click_detail(id){
	opFlag = 1; //app处理
	
	var postData = {};
	postData.opFlag = opFlag;
	postData.goodsPriceId = id;
	postData.opMoudle = 3;//1 shopingcart_app 2 member_app 3 goods_detail
	var postDataJson = JSON.stringify(postData);
	if(getOs() == "isAndroid"){//android
		jydJs_App.requestApp(postDataJson);
	}else if(getOs() == "isiOS"){//ios操作
		window.location.href = "\*"+postDataJson;
	}else{
		var appOs = getAppOs();//获取手机操作系统
		if(isWeiXin()){
			alert("腾讯用户请复制链接在浏览器中打开!");
		}else{
			if(appOs == "isAndroid"){//android
				window.location.href = "jydclient://openApp?postData="+postDataJson;
			}else if(appOs == "isiOS"){//ios操作				
				window.location.href = "jydclient://open?postData="+postDataJson;
			}else{
				window.location.href = "http://d.jydapp.com:88/cmbs/down.html";
			}
			setTimeout(function(){
				window.location.href = "http://d.jydapp.com:88/cmbs/down.html";//如果超时就跳转到app下载页
			},1000);
		}

	}
	
}


//判断是否为微信浏览器
function isWeiXin(){
    var ua = window.navigator.userAgent.toLowerCase();
    //判断是否在微信或者qq内置浏览器打开
    if(ua.match(/MicroMessenger/i) == 'micromessenger' || (ua.indexOf('qq') >0 && ua.match(/mqqbrowser/) != 'mqqbrowser')){ 
      return true; 
    }
    
}

function getAppOs(){
	
	var u = navigator.userAgent, app = navigator.appVersion;
	//var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
	var isAndroid = u.indexOf('Android') > -1; //android终端
	var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
	if(isAndroid){
		return "isAndroid";
	}else if(isiOS){
		return "isiOS";
	}else{
		return "isOther";
	}
}

//判断android、ios操作
function getOs(){
	
	var os = $("#os").val();
	if(os == "android"){
		return "isAndroid";
	}else if(os == "ios"){
		return "isiOS";
	}else{
		return "isOther";
	}
}

function claimedMsg(msg){
	toastShow(msg);
}


function toastShow(msg){
	
	$(".resultMessage").text(msg);
	$(".resultMessage").fadeIn(500);
	setTimeout(function(){$(".resultMessage").fadeOut(500)},2000);
}
