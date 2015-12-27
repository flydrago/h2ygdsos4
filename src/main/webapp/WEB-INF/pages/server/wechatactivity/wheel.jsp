<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>大转盘</title>
<link href="<%=uiPath%>common/css/wechatactivity.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<div id="out_div" style="position:relative;margin:0px auto 70px auto;text-align:center;">
		<input name="openId" type="hidden" id="openId" value="${openId}" />
		<input name="activityId" type="hidden" id="activityId" value="${wechatActivity.id}" />
		<input name="memberId" type="hidden" id="memberId" value="${memberUser.id}" />
		<input name="zoneCode" type="hidden" id="zoneCode" value="${zoneCode}" />
		<canvas id="canvas">当前浏览器不支持画布</canvas>
		<br/>
		
		<%--left：(parentWidth-childWidth)/2 top:(parentHeight-childHeight)/2--%>
		<div id="but_div" style="position:absolute;"><a id="btn"><img id="prize_do"style="display: none;" alt="抽奖" src="<%=uiPath%>common/imgs/wechatactivity/start.png"></a></div>
		<table id="prizeInfo" class="prize_table">
			<caption><h2>奖项设置</h2></caption>
		</table>
		
		<table class="prize_table">
			<caption><h2>活动说明</h2></caption>
			<tr><td class="prize_td">${wechatActivity.description }</td></tr>
		</table>
		<div style="text-align: center;margin-top: 10px;">
			<span style="color: blue;display: block;">本活动解释权归H2Y所有</span>
			<span style="color: blue;display: block;">苹果及其他公司不赞助及参与本软件“抽奖”功能</span>
		</div>
	</div>
	
	<div id="tanchu_div" class="tanchu" style="display: none;">
		<div class="content_text_1">
			<img src="<%=uiPath%>common/imgs/wechatactivity/tc.png" />
			<div class="qiandao_illustrate_1">
				<p id="tanchu_msg">活动结束</p>
				<input id="tanchu_but" class="submit_1" type="button" value="确定">
			</div>
		</div>
	</div>
	
	<script src="<%=uiPath%>common/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

var colorArray = ["#008BD4","#AE623E","#F5B704"];
			
var info = ${wheelList};
var infoLength = info.length;//抽奖项数
var step = 2*Math.PI/infoLength;//单位弧度
var canvasR = 175;
var outerR = 150; //轮盘的大小
var interR = 50;//内存空白圆的大小
var fontMaxLength = 0;//字体显示的最大长度

var beginAngle=50;//旋转起来时默认开始旋转的度数，度数愈大旋转的初始速度愈大
var radio = 0.95;//旋转速度衰减系数，影响旋转时间

var luckIndexList = [];

var context = null;

var isRuning = false;

var clientWidth = 350;

window.onload=function() {
	
	//alert(colorArray.length);
	//alert(colorArray[0]);
	//$("#tanchu_div").show();
	//setTimeout('loadcavas()', 90);
	loadcavas();
	//$("#tanchu_div").hide();
};

function loadcavas(){
	
	$("#canvas").hide();
		 
	 clientWidth = document.body.clientWidth;
	 canvasR = clientWidth/2;
	 outerR = (clientWidth-10)/2;
	 interR = outerR/3;
	 fontMaxLength = outerR - interR - 30;
	 //外边框
	 $("#out_div").attr("width",clientWidth);
	 
	 $("#canvas").attr("width",clientWidth);
	 $("#canvas").attr("height",clientWidth);
	 
	 $("#prize_do").css({"height":interR*2,"width":interR*2*1.95});
	 $("#but_div").css({"height":interR*2,"width":interR*2*1.95,"top":(clientWidth-interR*2)/2,"left":(clientWidth-interR*2*1.94)/2});
	 
	 $(".prize_table").css("width",clientWidth-20);
	 //alert(window.screen.width+":"+window.screen.availWidth+":"+document.body.clientWidth);
	
	  var canvas = document.getElementById("canvas");
	  context = canvas.getContext("2d");
	  //250,250坐标映射到0,0
	  context.translate(canvasR,canvasR);
	  init(context);
	  
	  $(info).each(function(i){
		 if(this.flag == 0){
			 luckIndexList.push(i);
		 }else{
			$("#prizeInfo").append("<tr><td class=\"prize_td\">"+this.info+"</td></tr>");			 
		 }		  
	  });
	  
	  document.getElementById("btn").onclick=function(){
		  getPrize();
	  };
	 
	 $("#tanchu_but").click(function(){
		 $("#tanchu_div").hide();
	 });
	 
	 $("#canvas").show("normal",function(){
		 $("#prize_do").show("normal");
	 });
}




function tanchu(msg){
	
	$("#tanchu_msg").html(msg);
	$("#tanchu_div").show();	
}


//执行旋转大转盘
function doRotateWheel(hitIndex){
	
	 //初始化旋转角度
	 var initAngle = beginAngle +Math.random()*10;
	 var angle = 0;
	 
	 //最大旋转次数
	 var maxRound = 20;
	 
	 var t = setInterval(function(){
			//衰减旋转角度
			initAngle *=radio;
			
			if(maxRound < 0){
				   //暂停定时旋转
				   clearInterval(t);
				   
				   //获取旋转的单位抽奖项数
				   var pos = Math.ceil(angle*infoLength / 360);
				   var res = info[infoLength-pos];
				   
				   if(res.flag==0){
					   tanchu(res.text);
				   }else{
					   tanchu("恭喜您抽中了"+res.text);
				   }
				   isRuning = false;
			}else{   
			
				   if(maxRound == 0){
					   
					   $("#test").html("");
					   
					   //获取旋转的单位抽奖项
					   var pos = Math.ceil(angle*infoLength / 360);
					   //$("#test").append("angle："+angle+"</br>");
					   //$("#test").append("pos："+pos+"</br>");
					   //$("#test").append("hitIndex："+hitIndex+"</br>");
					   //$("#test").append("infoLength："+infoLength+"</br>");
					   //alert((infoLength-pos));
					   //alert((infoLength-pos-hitIndex)*36);
					   angle += (infoLength-pos-hitIndex)*360/infoLength;
					   
					   //盘针直到奖项中间
					   if(angle%30>15){
						   angle -= (angle%30-15);
					   }else{
						   angle += (15-angle%30);
					   }
					   //$("#test").append("angle："+angle%30+"</br>");
					   //$("#test").append("角度："+angle);
				   }else{   
					   
					   angle += initAngle;
					   if(angle > 360){
							  angle -=360;
					   }
				   }
				   rotateAngle(angle,context);
			}
			maxRound--;
	 },60);
	
}

//得到选中的奖项
function getHitIndex(prizeId){
	
	var index = -1;
	
	if(prizeId != 0){
		$(info).each(function(i){
			if(this.id == prizeId){
				index = i;
				return;
			} 
		});
	}
	
	if(index == -1){
		//$("#test1").html("");
		var randomIndex = Math.floor(Math.random()*(luckIndexList.length));
		//$("#test1").append("randomIndex:"+randomIndex);
		index = luckIndexList[randomIndex];
		//$("#test1").append("index:"+index);
	}
	return index;
}


//转动指定角度
function rotateAngle(angle,context){

	//清除画布
	context.clearRect(-canvasR,-canvasR,canvasR*2,canvasR*2);
    context.save();
    context.beginPath();
    context.rotate(angle * Math.PI/180);
    init(context);
    context.restore();
}


function init(context){
	
	  var colorLength = colorArray.length;
	  
	  //圆盘 
	  $(info).each(function(i){
			 context.save();
			 context.beginPath();
			 context.moveTo(0,0);
			 context.fillStyle = colorArray[i%colorLength];
			 
			 /*
			 if(this.flag == 0){
				 context.fillStyle="#FFF68F";
			 }else{
				context.fillStyle="#FF4500";
			 }*/
			 context.arc(0,0,outerR,i*step,(i+1)*step);
			 context.fill();
			 context.restore();
	  });
	  
	   //圆盘文字
	   $(info).each(function(i){
			 context.save();
			 context.beginPath();
			 context.fillStyle="#EEF3FA";
			 //alert(this.text.length);
			 //alert(fontMaxLength/this.text.length);
			 if(this.flag == 0){
				 context.font="bolder "+(parseInt(fontMaxLength/this.text.length))+"px 微软雅黑";
			 }else{
				 context.font="bolder "+(parseInt(fontMaxLength/this.text.length))+"px 微软雅黑";
			 }
			 context.textAlign="center";
			 context.textBaseline="middle";
			 context.rotate(i*step+step/2);
			 context.fillText(this.text,(outerR + interR)/2,0);
			 context.restore();
	  });
}

function getPrize(){
	
	if(isRuning){
		tanchu("请稍后操作！");
		return;
	}
	isRuning = true;
	
	var postData = {};
	postData.activityId = $("#activityId").val();
	postData.memberId = $("#memberId").val();
	postData.zoneCode = $("#zoneCode").val();
	
	<%--注意该处url可能不符合你的要求，请注意修改--%>
    $.post("server/wechatactivity/save.htm",{postData:JSON.stringify(postData)}, function (data) {
         var jsonReturn = eval("(" + data + ")");
         if (jsonReturn.resultFlag == "1") {
        	 doRotateWheel(getHitIndex(jsonReturn.resultData.id));
         } else {
        	 isRuning = false;
        	 tanchu(jsonReturn.resultMsg);
         }
    });
}

</script>
</body>
</html>