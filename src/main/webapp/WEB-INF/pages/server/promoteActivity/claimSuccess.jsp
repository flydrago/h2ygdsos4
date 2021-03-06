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
    <link href="<%=uiPath%>bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <link href="<%=uiPath%>common/css/promoteActivity/init.css?f=3" rel="stylesheet">
    
    <script src="<%=uiPath%>jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//alert($(".goods_show #caidai").height());
			$(".buttom_rule img").addClass("img-responsive");
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
	  		<div>
	  			<img id="caidai" src="<%=uiPath%>common/imgs/promoteActivity/caidai.png" class="img-responsive" alt="彩带">
	  		</div>
	  		<div class="jumbotron">
	  			<c:choose>
	  				<c:when test="${flag==1}">
	  					<c:if test="${claimMemberUser!=null}">
	  						<div id="goods_text1">恭喜您获得</div>
	  					</c:if>
		  		  		<!-- 0：优惠劵、1：商品、2：达人币、3：达人豆、4：储值 -->
		  		  		<div id="goods_text2">
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
	  				</c:when>
	  				<c:otherwise>
	  					<div id="goods_text1">${msg}</div>
	  				</c:otherwise>
	  			</c:choose>
			</div>
	  	</div>
	  	
	  	<div class="claim_info">
	  		<c:if test="${flag==1 && claimMemberUser!=null}">
	  			<div id="claim_info_msg1"><span>红包已经发送到至账户</span><span class="member_account">${claimMemberUser.account}</span></div>
	  		</c:if>
	  		<div id="claim_info_msg2">下载app客户端即可使用</div>
	  	</div>
	  	
	  	<div class="down_but">
	  		<a id="downApp_But" class="btn btn-primary btn-block" href="http://d.jydapp.com:88/cmbs/servlet/DownAppServlet?y=jk&t=1">下载H2Y客户端</a>
	  	</div>
	  	
		<div class="form-horizontal">
		 	<input type="hidden" id="promoteId" name="promoteId" value="${promoteActivity.id}">
			<input type="hidden" id="shareAccount" name="shareAccount" value="${shareAccount}">
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
						<span class="member_account">${fn:substring(user.claimAccount, 0, 3)}****${fn:substring(user.claimAccount, 7, 11)}</span>
						<span class="claim_date"><fmt:formatDate value="${user.createDate}"  pattern="MM.dd HH:mm"/></span>
					</div>
				</div>
			</c:forEach>
			
			<%--
			<table class="list_table">
				<c:forEach var="user" items="${userList}">
				<tr>
					<td class="touxiang_td"><img src="http://pic.jydapp.com:91/image/show.htm?path=${user.headPath}" alt="头像" class="img-rounded member_logo"></td>
					<td class="memberinfo_td">
						<span class="member_info1">${user.claimAccount}</span>
						<span class="member_info2"><fmt:formatDate value="${user.createDate}"  pattern="MM-dd HH:mm"/></span>
					</td>
				</tr>
			    </c:forEach>
			</table>
			 --%>
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
