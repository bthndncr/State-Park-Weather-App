<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<form:form class="login" action="survey" method="POST" modelAttribute="survey">
    <div class="form-group">
        <h3>Survey</h3>
        
        <form:select class="form-control" path="parkCode">
        	<form:option value="">Favorite National Park</form:option>
	        <c:forEach items="${parks}" var="park">	        	
	        	<form:option value="${park.parkCode}">${park.parkName }</form:option>
	        </c:forEach>
         </form:select>
         <form:errors path="parkCode" cssClass="error"/>
         
        <form:input class="form-control mt-2" path="emailAddress" placeholder="Email" />
        <form:errors path="emailAddress" cssClass="error"/>
        
        <form:select class="form-control mt-2" path="state">
        	<option value="">State of Residence</option>
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District Of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</form:select>
		<form:errors path="state" cssClass="error"/>
		
		<form:select class="form-control mt-2" path="activityLevel">
			<option value="">Physical Activity Level</option>
			<option value="Inactive">Inactive</option>
			<option value="Sedentary">Sedentary</option>
			<option value="Active">Active</option>
			<option value="Extremely Active">Extremely Active</option>
		</form:select>
		<form:errors path="activityLevel" cssClass="error"/>
        
    </div>
    
    <button type="submit" class="btn btn-md btn-outline-dark btn-block">Submit</button>
</form:form>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />