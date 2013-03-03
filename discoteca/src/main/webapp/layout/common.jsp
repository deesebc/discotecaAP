<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
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