<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<p><spring:message code="general.app.name"/></p>
<p><spring:eval expression="@propertyConfigurator.getProperty('app.debug.mode')" />mens</p>