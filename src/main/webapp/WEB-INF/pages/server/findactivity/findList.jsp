<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>小达快报</title>

<meta charset="utf-8">
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="小达快报">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 ,maximum-scale=1, user-scalable=no">
<link href="<%=uiPath%>bootstrap-3.3.2-dist/css/bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
html {
	height: 100%;
	background-color: #eee;
}

html,body {
	min-height: 100%;
}
</style>

</head>

<body>

	<form>
		<input type="hidden" id="page" name="page" value="${page }"/>
		<input type="hidden" id="pagesize" name="pagesize" value="${pagesize }"/>
		<input type="hidden" id="zoneCode" name="zoneCode" value="${zoneCode }"/>
		<input type="hidden" id="fpUrl" name="fpUrl" value="${fpUrl }"/>
		<input type="hidden" id="listCount" name="listCount" value="${listCount }"/>
		<div class="container-fluid" style="padding:2px">
			<div class="row-fluid">
				<div class="span12" id="listDiv">
				 
					<c:forEach var="dataFind" items="${dataList}">
						<a href="javascript:findDetail(${dataFind.id })">
							<div class="thumbnail">

								<img alt="${dataFind.title }" src="${fpUrl}${dataFind.img }" />
								<div class="caption">
									<h3>${dataFind.title }</h3>
									<p style="text-align: right;">${dataFind.activity_type_name }
									</p>
									<p style="text-align: right;">
										<fmt:formatDate value="${dataFind.create_date}"
											pattern="yyyy-MM-dd HH:mm:ss" />
									</p>
								</div>
							</div>
						</a>
					</c:forEach>
									
				</div>
				
					<p style="text-align: center;<c:if test="${listCount < pagesize*page }">display:none</c:if>" id="findMore"><a href="javascript:findMoreList()">加载更多</a></p>
				
			</div>
		</div>


	</form>



</body>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=uiPath%>jquery/jquery-1.11.2.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=uiPath%>bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

<script type="text/javascript">

	$(function () {
		//findMoreList();
	})
	
	
      	function findDetail(id){
      		var url = "<%=basePath%>server/findActivity/findActivityDetail.htm?id="+id;
      		window.location.href = url;           
      	}
      	
      	function findMoreList2(){
      		var page = parseInt($("#page").val())+1;
      		var url = "<%=basePath%>server/findActivity/findActivityList.htm?page="+page;
      		window.location.href = url;           
      	}
      	
      	function findMoreList(){

      		var page = parseInt($("#page").val())+1;
      		var fpUrl = $("#fpUrl").val();
      		var url = "<%=basePath%>server/findActivity/findActivityListJson.htm?page="+page;
      		var moreHtml = "";
      		
      		$.post(url, function (data) {

      			var json = eval("(" + data + ")");
      			
                if(json.length != 0){
                	
                	 for(var i=0;i<json.length;i++){
                		 moreHtml = moreHtml + '<a href="javascript:findDetail('+json[i].id+')">'+
							'<div class="thumbnail">'+

								'<img alt="'+json[i].title +'" src="'+fpUrl+json[i].img+ '" />'+
								'<div class="caption">'+
									'<h3>'+json[i].title+'</h3>'+
									'<p style="text-align: right;">'+json[i].activity_type_name +'</p>'+
									'<p style="text-align: right;">'+json[i].create_date +'</p>'+
									'</div>'+
									'</div>'+
									'</a>';
                		 
                	 }
                	 
                	 $("#page").val(page);
                	 $("#listDiv").append(moreHtml);
                }
                
            });
      		var pagesize = parseInt($("#pagesize").val());
      		var listCount = parseInt($("#listCount").val());
      		
      		if(listCount > pagesize*page){
      			$("#findMore").show();
      		}else{
      			$("#findMore").hide();
      		}
      		
      		
      	}
      	
	  </script>
</body>
</html>
