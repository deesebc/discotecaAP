<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/jquery/ui-lightness/jquery-ui-1.8.6.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/jqgrid/ui.jqgrid.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
    var jq = jQuery.noConflict();
    var contexPath = "<%=request.getContextPath() %>";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-ui-1.8.6.custom.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jqgrid/grid.locale-en.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jqgrid/jquery.jqGrid.min.js"></script>
<p>
	<fieldset>
		<legend><spring:message code="general.search"/></legend>
		<div>
			<input type="text" id="name" ><spring:message code="general.name"/>
			<button id="search" type="button" title="<spring:message code='general.search'/>"><spring:message code="general.search"/></button>
		</div>
	</fieldset>
	<div id="jqgrid">
		<table id="grid"></table>
		<div id="pager"></div>
	</div>
</p>