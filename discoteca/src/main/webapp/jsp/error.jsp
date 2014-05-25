<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<p><h1><spring:message code="general.error"/></h1></p>
<p><spring:message code="general.error.message" arguments="${exception}, ${user}"/></p>

