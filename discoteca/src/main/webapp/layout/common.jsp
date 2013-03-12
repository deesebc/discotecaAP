<%@ include file="/layout/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />﻿
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
    <div id="wrapper">
        <div id="headerwrap">
	        <div id="header">
	        	<tiles:insertAttribute name="header" />
	        </div>
        </div>
        <div id="leftcolumnwrap">
	        <div id="leftcolumn">
	            <tiles:insertAttribute name="menu" />
	        </div>
        </div>
        <div id="contentwrap">
	        <div id="content">
	           <tiles:insertAttribute name="content" />
	        </div>
        </div>
    </div>
</body>
</html>
