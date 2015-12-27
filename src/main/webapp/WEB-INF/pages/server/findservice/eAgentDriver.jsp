<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>代驾</title>
	
	<meta charset="utf-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="e代驾页面">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1 ,maximum-scale=1, user-scalable=no">
    <script src="<%=uiPath%>jquery/jquery-1.11.2.min.js"></script>
    
    <script type="text/javascript">
        
        $(function () {
        	var phone = $("#phone").val();
        	var latitude = $("#latitude").val();
        	var longitude = $("#longitude").val();
        	var eurl = "http://h5.d.edaijia.cn/app/index.html?from=test";
        	if(undefined != phone && '' != phone){
        		eurl = eurl + "&phone="+phone;
        	}
        	if(undefined != latitude && ''!= latitude){
        		eurl = eurl + "&lat="+latitude;
        	}
        	if(undefined != longitude && '' != longitude){
        		eurl = eurl + "&lng="+longitude;
        	}
        	window.location.href=eurl;
        });
     </script> 
    
    
  </head>
  
  <body>
  
	<form id="editform" method="get">
		  <input type="hidden" name="phone" id="phone" value="${phone }"/>
		  <input type="hidden" name="latitude" id="latitude" value="${latitude }"/>
		  <input type="hidden" name="longitude" id="longitude" value="${longitude }"/>
	</form>
  	
     
  </body>
</html>
