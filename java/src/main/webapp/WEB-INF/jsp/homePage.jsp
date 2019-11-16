<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div class="parks">
	<c:forEach items="${parks}" var="park">
	
	<div class="park mt-3">
		<c:url var="detailsPage" value="/details">
			<c:param value="${park.parkCode}" name="parkCode" />
		</c:url>
		
		<div class="img-container">
			
				<img class="image" src="img/parks/${park.parkCode}.jpg" alt="parkImage" />
			
				<a class="overlay" href="${detailsPage}">
   			 		<h3 class="text">Learn more</h3>
   			 	</a>
		</div>
			
		<div class="details mt-2">
			<h2>${park.parkName}</h2>
			<h4>${park.state}</h4>
			<p>${park.parkDescription}</p>
			
		</div>
	</div>
	
	</c:forEach>
</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />