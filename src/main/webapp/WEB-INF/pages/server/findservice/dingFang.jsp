<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>订房</title>
	
	<meta charset="utf-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1 ,maximum-scale=1, user-scalable=no">
    <link href="<%=uiPath%>bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  </head>
  
  <body>
  
  	<div class="panel panel-info">
	   <div class="panel-heading">
	    	<h3 class="panel-title">订房电话</h3>
	   </div>
	   <div class="panel-body">
	      <a id="dingfatel" href="tel:4001017769"><h4>4001017769</h4></a>
	   </div>
	</div>
  
  	<div class="panel panel-info">
	   <div class="panel-heading">
	      <h3 class="panel-title">
	                       订房简介
	      </h3>
	   </div>
	   <div class="panel-body">
	      	为更好的服务H2Y会员/用户，我们推出国内外高端连锁酒店预定服务（4星或4星以上），价格请来电咨询。部分特价酒店需收取预定服务费10%，推广期间免收！
	   </div>
	</div>
	
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="<%=uiPath%>jquery/jquery-1.11.2.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="<%=uiPath%>bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
      
      <script type="text/javascript">
      
      	 $(function(){
      		 
      		 $("#dingfatel").click(function(){
	   			 h2y_save();
	   		 });
      	 });
      	 
      	function h2y_save() {
			 
			var postData = "{\"memberId\":${memberUser.id},\"mobile\":\"40010117769\",\"account\":\"${memberUser.account}\"}";
           <%--注意该处url可能不符合你的要求，请注意修改--%>
           $.post("<%=basePath%>server/third/dingFang.htm", {postData:postData}, function (data) {
        	   
           });
	     }
	  </script>
  </body>
</html>
