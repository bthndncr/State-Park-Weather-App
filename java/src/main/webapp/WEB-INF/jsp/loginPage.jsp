<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<form:form class="login" action="login" method="POST" modelAttribute="user" >
    <div class="form-group">
        <h3>Login</h3>
        <form:input class="form-control" path="username" placeholder="Username" />
        <form:errors path="username" cssClass="error"/>
    </div>
    <div class="form-group">
        <form:password  class="form-control" path="password" placeholder="Password" />
        <form:errors path="password" cssClass="error"/>
    </div>
    <button type="submit" class="btn btn-md btn-outline-dark btn-block">Login</button>
</form:form>







<c:import url="/WEB-INF/jsp/common/footer.jsp" />