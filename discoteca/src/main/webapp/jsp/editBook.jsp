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
<form:form method="post" action="${pageContext.request.contextPath}/save/book.htm" modelAttribute="libro">
<p>
	<fieldset>
		<legend><spring:message code="general.edit"/></legend>
		<div>
			<div class="width20 height25 floatLeft"><form:label path="nombre"><spring:message code="general.name"/></form:label></div>
			<div class="width50 height25"><form:input path="nombre" /></div>
			<div class="width20 height25 floatLeft"><form:label path="autor"><spring:message code="general.author.name"/></form:label></div>
			<div class="width50 height25"><form:input path="autor" /></div>
			<div class="width20 height25 floatLeft"><form:label path="serie"><spring:message code="general.serie.name"/></form:label></div>
			<div class="width50 height25"><form:input path="serie" /></div>
			<div class="width20 height25 floatLeft"><form:label path="volumen"><spring:message code="general.volumen.name"/></form:label></div>
			<div class="width50 height25"><form:input path="volumen" /></div>
			<div class="width20 height25 floatLeft"><form:label path="argumento"><spring:message code="general.argument.name"/></form:label></div>
			<div class="width50 height25"><form:input path="argumento" /></div>
			<div class="width20 height25 floatLeft"><form:label path="paginas"><spring:message code="general.pages.name"/></form:label></div>
			<div class="width50 height25"><form:input path="paginas" /></div>
			<div class="width20 height25 floatLeft"><form:label path="publicacion"><spring:message code="general.publicacion.name"/></form:label></div>
			<div class="width50 height25"><form:input path="publicacion" /></div>
			<button id="acceptButton" type="submit" title="<spring:message code='general.button.accept'/>"><spring:message code="general.button.accept"/></button>
		</div>
	</fieldset>
</p>
<form:hidden path="ident" id="idBook" />
</form:form>
