<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>律师</title>
	
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
	    	<h3 class="panel-title">联系电话</h3>
	   </div>
	   <div class="panel-body">
	      <a id="dingfatel" href="tel:13598066743"><h4>13598066743</h4></a>
	   </div>
	</div>
  
  	<div class="panel panel-info">
	   <div class="panel-heading">
	      <h3 class="panel-title">
	                       简介
	      </h3>
	   </div>
	   <div class="panel-body">
	      	赵春先律师，河南则政鼎律师事务所副主任，赵（照）理说法律师团创始人，从事律师工作二十年，有着长期诉讼实践经验和企业的法律风险防范的工作技巧。赵理说法律师团的宗旨：为普通百姓提供免费的日常法律咨询服务，为中小微企业提供性价比高的法律风险防范服务。 qq：1932492017
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
			 
			//var postData = "{\"memberId\":${memberUser.id},\"mobile\":\"40010117769\",\"account\":\"${memberUser.account}\"}";
           
	     }
	  </script>
  </body>
</html>
