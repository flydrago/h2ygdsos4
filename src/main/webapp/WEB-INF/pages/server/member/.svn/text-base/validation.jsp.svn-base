<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="dns-prefetch" href="<%=basePath%>" />
	<link rel="stylesheet" href="<%=uiPath%>bootstrap-3.3.2-dist/css/bootstrap.min.css" />
	<script src="<%=uiPath%>jquery/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script src="<%=uiPath%>bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    <link href="<%=uiPath%>module/member/css/validation.css?f=3" rel="stylesheet">
    <script src="<%=uiPath%>module/member/js/validation.js?f=1"></script>
    
</head>
<body>

	<div class="container-fluid" id="XS">
	
		<input type="hidden" id="opCode" name="opCode" value="${opCode}" />
		<input type="hidden" id="loginType" name="loginType" value="${loginType}" />
		<input type="hidden" id="regDevice" name="regDevice" value="${regDevice}" />
		<input type="hidden" id="regSource" name="regSource" value="${regSource}" />  
		<input type="hidden" id="data1" name="data1" value="${data1}" />
		<input type="hidden" id="data2" name="data2" value="${data2}" />
		<input type="hidden" id="data3" name="data3" value="${data3}" />
	
		 <div class="modal fade" id="modal_container" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div id="modal_msg" class="modal-body">
			        	
			      </div>
			      <div class="modal-footer">
			        	<button type="button" class="btn btn-primary btn-block" data-dismiss="modal">确定</button>
			      </div>
			    </div>
			  </div>
		</div>
  	
  		<div class="vali_head">
	  		<img id="jyd_logo" src="<%=uiPath%>module/member/imgs/jyd_logo.png" class="img-responsive" alt="头部广告">
	  	</div>
	  	
	  	<div class="vali_main" >
	  		<div class="jumbotron">
	  		  <div id="vali_declare">
	  		  	<p class="text-left">声明：</p>
	  		  	<p class="text-justify">&nbsp;&nbsp;&nbsp;&nbsp;为确保活动公平，防止刷票和刷奖品，需要进行手机验证。本次活动一个手机号只能参与一次。</p>
	  		  </div>
	  		  
		  	 <div id="vali_phone" class="form-group">
		    	<div class="input-group">
		      	<div class="input-group-addon"><img class="img-responsive" alt="" src="<%=uiPath%>module/member//imgs/phone_logo.png"></div>
		      	<input type="tel" class="form-control" id="phone_input" placeholder="请输入手机号码">
		    	</div>
		  	 </div>
		  	  
		  	 <div id="vali_veriCode" class="form-group">
			      <button id="veriCode_Btu" type="vericode_but" class="btn btn-primary">获取验证码</button>
			      <input id="veriCode_input" type="tel" class="form-control" id="exampleInputAmount" placeholder="请输入验证码">
			 </div>
			</div>
	  	</div>
	  	
	  	<div class="vali_submit" >
		      <button id="validation_Btu" type="button" class="btn btn-primary  btn-block">完成验证</button>
	  	</div>
	  	
	  	<div class="resultMessage">
	  		
		</div>
	</div>
</body>
</html>