<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
  	<base href="<%=basePath%>" />
    <title>优惠劵和实物类</title>
	<meta charset="utf-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1 ,maximum-scale=1, user-scalable=no">
    <meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="cache-control" content="no-cache"> 
	<meta http-equiv="expires" content="0">
	   
    <link href="<%=uiPath%>bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <link href="<%=uiPath%>common/css/promoteActivity/init.css?f=4" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="<%=uiPath%>jquery/jquery-1.11.2.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="<%=uiPath%>bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
      <script type="text/javascript">
      	$(function(){
      		
      		/*
      		if(typeof(Storage)!=="undefined"){
      			
      			var memberInfo = getItem("jydapp_member_auth_info");
      			alert(memberInfo);
      			if(memberInfo){//如果存在则进行刷新页面领取
      				removeItem("jydapp_member_auth_info");
      				memberInfo = eval("(" + memberInfo + ")");
      				window.location.href = "server/promoteActivity/claimSuccess.htm?promoteId=${promoteActivity.id}&shareUuid=${shareMemberUser.uuid}&claimUuid="+memberInfo.uuid;
      			}
      	  	}else{
      	  		document.getElementById("result").innerHTML="Sorry, your browser does not support web storage...";
      	  	}*/
      	  	$(".buttom_rule img").addClass("img-responsive");
      		
      		$("#claimBut").click(function(){
      			
      			window.location.href = "<%=memberBasePath%>server/init/validation.htm?loginType=5&regDevice=5&opCode=promote&regSource=5&data1=${promoteActivity.id}&data2=${shareMemberUser.uuid}";
	   	 	});
   	 	});
      	
      	
		function imgLoad(){
			
			$(".jumbotron").css("padding-top",$(".goods_show #caidai").height());
		}
	  </script>
  </head>
  
  <body style="	background-color: #FCFFCD;">
  
  	<div class="container-fluid" id="XS">
  	
  		<div class="head_advert">
	  		<img onload="imgLoad();" src="<%=uiPath%>common/imgs/promoteActivity/head_advert.png" class="img-responsive" alt="头部广告">
	  	</div>
	  	
	  	<div class="goods_show" >
	  		<div >
	  			<img id="caidai" src="<%=uiPath%>common/imgs/promoteActivity/caidai.png" class="img-responsive" alt="头部广告">
	  		</div>
	  		<div class="jumbotron">
  				<div id="goods_text1">恭喜您获得</div>
  		  		<div id="goods_text2">
  		  		<!-- 0：优惠劵、1：商品、2：达人币、3：达人豆、4：储值 -->
  		  		<c:choose>
  		  			<c:when test="${promoteActivityRewardRt.dataType==0}">
  		  				${promoteActivityRewardRt.str2}
  		  			</c:when>
  		  			<c:when test="${promoteActivityRewardRt.dataType==1}">
  		  				${promoteActivityRewardRt.str2}<span id="goodsCount">x${promoteActivityRewardRt.int1}</span>
  		  			</c:when>
  		  			<c:when test="${promoteActivityRewardRt.dataType==2}">
  		  				达人币${promoteActivityRewardRt.double1}
  		  			</c:when>
  		  			<c:when test="${promoteActivityRewardRt.dataType==3}">
  		  				达人豆${promoteActivityRewardRt.double1}
  		  			</c:when>
  		  			<c:when test="${promoteActivityRewardRt.dataType==4}">
  		  				${promoteActivityRewardRt.double1}元
  		  			</c:when>
  		  		</c:choose>
  		  		</div>
			</div>
	  	</div>
	  	
	  	<div class="claim_but">
	  		<button type="button" id="claimBut" class="btn btn-primary btn-block" >点击领取</button>
	  	</div>
	  	
		<div class="info_title">
			<span class="left_line"></span>
			<span class="title_text">看看大家手气</span>
			<span class="right_line"></span>
		</div>
		
		<div class="member_list">
			<c:forEach var="user" items="${userList}">
				<div class="member_li">
					<c:choose>
						<c:when test="${user.headPath!=null && user.headPath!=''}">
							<img src="http://pic.jydapp.com:91/image/show.htm?path=${user.headPath}" alt="头像" class="img-rounded member_logo">
						</c:when>
						<c:otherwise>
							<img src="<%=uiPath%>common/imgs/promoteActivity/no_def.png" alt="头像" class="img-rounded member_logo">
						</c:otherwise>
					</c:choose>
					<div class="member_info">
						<%--
						<span class="member_account">${user.claimAccount}</span>
						 --%>
						<span class="member_account">${fn:substring(user.claimAccount, 0, 3)}****${fn:substring(user.claimAccount, 7, 11)}</span>
						<span class="claim_date"><fmt:formatDate value="${user.createDate}"  pattern="MM.dd HH:mm"/></span>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div id="claim_pagination">
		
			${pageHtml}
		</div>
		
		<div class="info_title">
			<span class="left_line"></span>
			<span class="title_text">活动细则</span>
			<span class="right_line"></span>
		</div>
		
		<div class="buttom_rule">
			<div class="span12">
				${promoteActivityDetail.promoteRule}
			</div>
		</div>
	</div>
  </body>
</html>

