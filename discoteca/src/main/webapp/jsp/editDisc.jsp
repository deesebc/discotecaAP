<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="saveDiscUrl" value="/save/disc.htm"/>
<form:form method="post" action="/discoteca/save/disc.htm" commandName="disco" modelAttribute="disco">
<p>
	<fieldset>
		<legend><spring:message code="general.edit"/></legend>
		<div>
			<form:label path="nombre"><spring:message code="general.name"/></form:label>&nbsp;<form:input path="nombre" />&nbsp;&nbsp;
			<form:label path="grupo"><spring:message code="general.group.name"/></form:label>&nbsp;<form:input path="grupo" />&nbsp;&nbsp;
			<button id="acceptButton" type="submit" title="<spring:message code='general.button.accept'/>"><spring:message code="general.button.accept"/></button>
		</div>
	</fieldset>
</p>
<form:hidden path="ident" />
</form:form>