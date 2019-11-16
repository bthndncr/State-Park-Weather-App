<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h3 class="mt-4 mb-4 text-center">Survey Results</h3>

	<div class="surveyParks">
	<c:forEach items="${surveys}" var="survey">

		<div class="card mb-3" style="width: 18rem">
		  <a href="details?parkCode=${survey.parkCode}"><img src="img/parks/${survey.parkCode}.jpg" class="card-img-top" alt="parkImage"></a>	
		  <div class="card-body">
		  	<h4 class="card-title">${survey.parkName}</h4>
		    <p class="card-text">Votes: <span class="badge badge-success">${survey.count} </span> <i class="fas fa-vote-yea"></i></p>
		  </div>
		</div>
		
	</c:forEach>
	</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />