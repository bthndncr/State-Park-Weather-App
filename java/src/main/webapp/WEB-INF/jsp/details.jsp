<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div class="detailsPark">
		<div class="detailsImg">
			<a href=""><img  src="img/parks/${park.parkCode}.jpg" alt="parkImage" /></a>
			<i>
			<p class="quote mt-1 ml-2">"${park.inspirationalQuote}"</p>
			<p style="float:right" class="mr-3">- ${park.inspirationalQuoteSource}</p>	
			</i>	
		</div>
		
		<div class="detailsPage">
			<h2>${park.parkName}</h2>
			<h4>${park.state}</h4>
			<p>Year = ${park.yearOfFounded} <i class="far fa-calendar"></i> - Acreage = ${park.acreage} <i class="fas fa-chart-area"></i> - Elevation = ${park.elevationinFeet} ft. <i class="fas fa-mountain"></i> - Trail = ${park.milesOfTrail} mi. <i class="fas fa-hiking"></i>,   </p>
			<p>Campsites = ${park.numberOfCampSites} <i class="fas fa-campground"></i> - Climate = ${park.climate} <i class="fas fa-tree"></i> - Visitors = ${park.annualVisitorCount} <i class="fas fa-user-friends"></i></p>
			<p>${park.parkDescription}</p>
			<p>Our Park has ${park.numberOfAnimalSpecies} Animal Species! <i class="fas fa-paw"></i></p>
			<p>Stay at our park for just <span class="badge badge-success">$${park.entryFee}</span></p>
		</div>
</div>

<hr class="type_5" />
	
	<form class="temp" action="details" method=POST>
		<select class="form-control" name="temp">
			<option value="">Selected: ${unit}&#176;</option>
			<option value="C">C&#176;</option>
			<option value="F">F&#176;</option>
		</select>
			<input type="hidden" name="parkCode" value="${park.parkCode}" />
			<button class="ml-2 btn btn-sm btn-outline-primary" type="submit" value="Check">CONVERT</button>
	</form>
	
	<div class="weather">
		<c:forEach items="${weather}" var="theWeather">
		<c:choose>
			<c:when test="${theWeather.fiveDayForecastValue == 1 }">
				<div class="today">
					<h3>Today</h3>
					<img alt="" src="img/weather/${theWeather.forecast}.png">
					<p><i class="fas fa-temperature-high"></i> High: ${theWeather.high}&#176; - <i class="fas fa-temperature-low"></i> Low: ${theWeather.low}&#176;</p>					
					<p> ${theWeather.advisory}</p>
				</div>
			</c:when>
			<c:otherwise>
				<div class="otherDays">
					<img alt="" src="img/weather/${theWeather.forecast}.png">
					<p>High: ${theWeather.high}&#176;</p>
					<p>Low: ${theWeather.low}&#176;</p>
				</div>
			</c:otherwise>
		</c:choose>
		</c:forEach>
	</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />