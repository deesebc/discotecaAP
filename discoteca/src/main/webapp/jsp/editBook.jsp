<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/editBook.js"></script>
<form:form method="post" action="${pageContext.request.contextPath}/save/book.htm" modelAttribute="libro" >
<p>
	<fieldset>
		<legend><spring:message code="general.edit"/></legend>
		<div>
			<div class="width20 height25 floatLeft"><form:label path="nombre"><spring:message code="general.name"/></form:label></div>
			<div class="width80 height25"><form:input path="nombre" /><form:errors path="nombre" cssStyle="color: #ff0000;"/></div>
			<div class="width20 height25 floatLeft"><form:label path="autor"><spring:message code="general.author.name"/></form:label></div>
			<div class="width80 height25"><form:input path="autor" /><form:errors path="autor" cssStyle="color: #ff0000;"/></div>
			<div class="width20 height25 floatLeft"><form:label path="serie"><spring:message code="general.serie.name"/></form:label></div>
			<div class="width80 height25"><form:input path="serie" /><form:errors path="serie" cssStyle="color: #ff0000;"/></div>
			<div class="width20 height25 floatLeft"><form:label path="volumen"><spring:message code="general.volumen.name"/></form:label></div>
			<div class="width80 height25"><form:input path="volumen" /><form:errors path="volumen" cssStyle="color: #ff0000;"/></div>
			<div class="width20 height25 floatLeft"><form:label path="paginas"><spring:message code="general.pages.name"/></form:label></div>
			<div class="width80 height25"><form:input path="paginas" /><form:errors path="paginas" cssStyle="color: #ff0000;"/></div>
			<div class="width20 height25 floatLeft"><form:label path="argumento"><spring:message code="general.argument.name"/></form:label></div>
			<div class="width80 height60"><form:textarea path="argumento" rows="5" cols="16" /><form:errors path="argumento" cssStyle="color: #ff0000;"/></div>
			<button id="acceptButton" type="submit" title="<spring:message code='general.button.accept'/>"><spring:message code="general.button.accept"/></button>
		</div>
	</fieldset>
</p>
<form:hidden path="ident" id="idBook" />
</form:form>
