<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    var contexPath = "<%=request.getContextPath() %>";
</script>
<link rel="stylesheet" type="text/css" media="screen" href='${pageContext.request.contextPath}/resources/css/jquery-ui/pepper-grinder/jquery-ui-1.8.16.custom.css'/>
<link rel="stylesheet" type="text/css" media="screen" href='${pageContext.request.contextPath}/resources/css/jqgrid/ui.jqgrid-4.3.1.css'/>
<link rel="stylesheet" type="text/css" media="screen" href='${pageContext.request.contextPath}/resources/css/style.css'/>

<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.6.4.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jqgrid/grid.locale-en-4.3.1.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jqgrid/jquery.jqGrid.min.4.3.1.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/saveDisc.js"></script>
<form:form method="post" action="/discoteca/save/disc.htm" modelAttribute="disco">
<p>
	<fieldset>
		<legend><spring:message code="general.edit"/></legend>
		<div>
			<form:label path="nombre"><spring:message code="general.name"/></form:label>&nbsp;<form:input path="nombre" />&nbsp;&nbsp;
			<form:label path="grupo"><spring:message code="general.group.name"/></form:label>&nbsp;<form:input path="grupo" />&nbsp;&nbsp;
			<button id="acceptButton" type="submit" title="<spring:message code='general.button.accept'/>"><spring:message code="general.button.accept"/></button>
		</div>
	</fieldset>
	<c:if test="${not empty disco.ident}">
		<div id='jqgrid'>
			<table id='gridSingers'></table>
			<div id='pagerSingers'></div>
		</div>
		<br/><br/>
		<div id='jqgrid'>
			<table id='gridSongs'></table>
			<div id='pagerSongs'></div>
		</div>
		<div id='msgbox' title='' style='display:none'></div>
	</c:if>
	
</p>
<form:hidden path="ident" id="idDisc" />
</form:form>
