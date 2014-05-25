<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>
	<nav>
	    <div class="menu-item">
	      <h4><spring:message code="general.Disc"/></h4>
	      <ul>
	        <li><a href="<c:url value='/search/disc.htm'/>"><spring:message code="general.search"/></a></li>
	      </ul>
	    </div>
	    <div class="menu-item">
	      <h4><a href="#"><spring:message code="general.book"/></a></h4>
	      <ul>
	        <li><a href="<c:url value='/search/book.htm'/>"><spring:message code="general.search"/></a></li>
	      </ul>
	    </div>
	    <div class="menu-item">
	      <h4><a href="<c:url value="/j_spring_security_logout" />"><spring:message code="general.logout"/></a></h4>
	    </div>
	</nav>
</p>
<!-- initSI -->