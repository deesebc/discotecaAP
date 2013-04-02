<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>
	<nav>
	    <div class="menu-item">
	      <h4><spring:message code="general.Disc"/></h4>
	      <ul>
	        <li><a href="<c:url value='/search/disc.htm'/>"><spring:message code="general.search"/></a></li>
	        <li><a href="#">Print</a></li>
	        <li><a href="#">Other</a></li>
	      </ul>
	    </div>
	    <div class="menu-item">
	      <h4><a href="#"><spring:message code="general.interpret"/></a></h4>
	      <ul>
	        <li><a href="<c:url value='/initSI.htm'/>"><spring:message code="general.search"/></a></li>
	        <li><a href="#">Meet The Owners</a></li>
	        <li><a href="#">Awards</a></li>
	      </ul>
	    </div>
	    <div class="menu-item">
	      <h4><a href="#">Contact</a></h4>
	      <ul>
	        <li><a href="#">Phone</a></li>
	        <li><a href="#">Email</a></li>
	        <li><a href="#">Location</a></li>
	      </ul>
	    </div>
	</nav>
</p>