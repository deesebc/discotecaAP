<%@ include file="/layout/tags.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<<html>
<head>
<meta charset="utf-8">﻿
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