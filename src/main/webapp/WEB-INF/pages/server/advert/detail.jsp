<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<link href="<%=uiPath%>module/advert/css/detail.css" rel="stylesheet">
<title>${advertSubject.subjectName}</title>

</head>
<body>
	<div class="container">
        <img class="banner" src="<%=fpPath%>?bn=advertSubjectService&os=wechat&id=${advertSubject.id}&f=<fmt:formatDate value="${advertSubject.updateDate}"  pattern="yyyyMMddHHmmss"/>">
        <!-- 备注 -->
        <div class="subject_memo">
        	${advertSubject.subjectContent}
        </div>
    </div>
</body>
</html>
