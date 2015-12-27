<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>签到页面</title>
	
	<meta charset="utf-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=uiPath%>bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  </head>
  
  <body>
  	
      <div id="msg_show" class="alert alert-success" role="alert">每天签到可领取积分10！</div>
      <br>
      <br>
      <br>
      <br>
      <button id="qiandao_btn" type="button" class="btn btn-primary btn-block btn-lg">点击签到</button>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="<%=uiPath%>jquery/jquery-1.11.2.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="<%=uiPath%>bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
      
      <script type="text/javascript">
      
		 $("#qiandao_btn").click(function(){
			 
			 $("#qiandao_btn").attr("disabled",true);
			 h2y_save();
		 });
		 
		 function h2y_save() {
			 
			 var paraJson = "{\"uid\":${uid},\"type\":0}";
	        	
            <%--注意该处url可能不符合你的要求，请注意修改--%>
            $.post("<%=basePath%>server/grade/sign.htm", {paraJson:paraJson}, function (data) {
                var jsonReturn = eval("(" + data + ")");
                if (jsonReturn.result == "1") {
                    $("#msg_show").html("签到成功！");
                } else if(jsonReturn.result == "2") {
                	$("#msg_show").html("今天已签到，明天再来吧！");
                }else{
                	$("#msg_show").html("签到失败！");
                }
                $("#qiandao_btn").attr("disabled",false);
            });
	     }
	  </script>
  </body>
</html>
