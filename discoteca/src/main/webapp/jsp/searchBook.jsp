<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" type="text/css" media="screen" href='${pageContext.request.contextPath}/resources/css/jquery-ui/pepper-grinder/jquery-ui-1.8.16.custom.css'/>
<link rel="stylesheet" type="text/css" media="screen" href='${pageContext.request.contextPath}/resources/css/jqgrid/ui.jqgrid-4.3.1.css'/>
<link rel="stylesheet" type="text/css" media="screen" href='${pageContext.request.contextPath}/resources/css/style.css'/>

<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.6.4.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jqgrid/grid.locale-en-4.3.1.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jqgrid/jquery.jqGrid.min.4.3.1.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/searchBook.js"></script>

<script type="text/javascript">
    var contexPath = "<%=request.getContextPath() %>";
</script>

<p>
	<fieldset>
		<legend><spring:message code="general.list.book"/></legend>
		<div id='jqgrid'>
			<table id='grid'></table>
			<div id='pager'></div>
		</div>
		<div id='msgbox' title='' style='display:none'></div>
	</fieldset>
</p>