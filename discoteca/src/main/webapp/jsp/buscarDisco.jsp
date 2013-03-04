<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/buscarDisco.js"></script>
<script type="text/javascript">
        var contexPath = "<%=request.getContextPath() %>";
</script>
<p>
	<fieldset>
		<legend><spring:message code="general.search"/></legend>
		<div>
			<input type="text" id="name" ><spring:message code="general.name"/>
			<button id="search" type="button" title="<spring:message code='general.search'/>"><spring:message code="general.search"/></button>
		</div>
	</fieldset>
	<table id="sdTable">
	    <thead>
	        <tr>
	            <th>Nombre</th>
	            <th>Grupo</th>
	        </tr>
	    </thead>
	    <tbody>
	    <tr>
	        <td colspan="2" class="dataTables_empty">Loading data from server</td>
	    </tr>
	    </tbody>
	</table>
</p>