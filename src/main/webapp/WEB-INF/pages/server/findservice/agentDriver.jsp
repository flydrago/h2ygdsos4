<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>代驾</title>
	
	<meta charset="utf-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="代驾页面">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1 ,maximum-scale=1, user-scalable=no">
    <link href="<%=uiPath%>bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  </head>
  
  <body>
  
  	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div id="modal_msg" class="modal-body">
	        	代驾订单提交成功！
	      </div>
	      <div class="modal-footer">
	        	<button type="button" class="btn btn-primary btn-block" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<form id="editform">
		  <div class="form-group">
		    <label class="control-label">代驾位置：</label>
		    <div>
		      <p class="form-control-static">${locationAddress}</p>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="daijiaTime" class="control-label">代驾时间：</label>
		    <div >
		       <select id="daijiaTime" name="daijiaTime" class="form-control">
				  <option>现在</option>
				  <option>半小时</option>
				  <option>一个小时后</option>
				  <option>两个小时后</option>
				  <option>三个小时后</option>
				  <option>四个小时后</option>
				  <option>五个小时后</option>
				</select>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="driverCount" class="control-label">所需司机：</label>
		     <div >
		       <select id="driverCount" name="driverCount" class="form-control">
				  <option value="1">一个</option>
				  <option value="2">两个</option>
				  <option value="3">三个</option>
				</select>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="name" class="control-label">姓名：</label>
		    <div>
    			<input type="text" class="form-control" name="name" id="name" value="${memberUser.realName}" placeholder="姓名">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="phone" class="control-label">手机：</label>
		    <div>
		    	<input id="phone" type="number" name="phone" class="form-control" value="${memberUser.account}" placeholder="手机">
		    </div>
		  </div>
		   
		  <button id="btn_submit" type="button" class="btn btn-primary btn-lg btn-block">提交订单</button>
	</form>
  	
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="<%=uiPath%>jquery/jquery-1.11.2.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="<%=uiPath%>bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
       
      <script type="text/javascript">
      
      	 $(function(){
      		 
      		 $("#btn_submit").click(function(){
	   			 h2y_save();
	   		 });
      		 
	      	 $("#myModal").modal({
	      		  keyboard: false,
	      		  show:false
	      	 });
      	 });
      	 
		 function h2y_save() {
			
			var phone = $("#phone").val();
			var name = $("#name").val();
			
			if(!checkMobile(phone)) return;
			if(""==name){
				tanchu("请填写姓名！");
				return;
			}
			  
			var driverCount = $("#driverCount").val();
			$("#btn_submit").attr("disabled",true);
			
			var postData = "{\"memberId\":${memberUser.id},\"nickName\":\"${memberUser.nickName}\",\"account\":\"${memberUser.account}\",\"realName\":\"${memberUser.realName}\",\"clientType\":\"${os}\",\"lon\":\"${locationLongitude}\",\"lat\":\"${locationLatitude}\",\"contactTel\":\""+phone+"\",\"clientTel\":\""+phone+"\",\"contactName\":\""+name+"\",\"driverCount\":\""+driverCount+"\",\"startAddress\":\"${locationAddress}\"}";
            <%--注意该处url可能不符合你的要求，请注意修改--%>
            $.post("<%=basePath%>server/third/agentDriver.htm", {postData:postData}, function (data) {
            	 var jsonReturn = eval("(" + data + ")");
                 if (jsonReturn.result == "1") {
                	 tanchu("代驾订单提交成功！");
                 } else{
                	 tanchu("代驾订单提交失败！");
                 }
                 $("#btn_submit").attr("disabled",false);
            });
	     }
		 
		 function checkMobile(str) {
		    var re = /^1\d{10}$/
		    if (!re.test(str)) {
		    	tanchu("请输入合法的手机号码");
		        return false;
		    }
		    return true;
		 }
		 
		 function tanchu(msg){
			 
			 $("#modal_msg").html(msg);
			 $("#myModal").modal("show");
		 }
	  </script>
  </body>
</html>
