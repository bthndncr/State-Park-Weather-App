<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" integrity="sha256-0rguYS0qgS6L4qVzANq4kjxPLtvnp5nn2nB5G1lWRv4=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/b344601191.js" crossorigin="anonymous"></script>
	<link href="https://fonts.googleapis.com/css?family=Ibarra+Real+Nova&display=swap" rel="stylesheet">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- custom CSS -->
    <c:url value="/css/style.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        		<a href="${homePageHref}">
        		<img src="${logoSrc}" alt="National Park Geek" />
        </a>
     </header>
     
     <div class="navbar navbar-expand-lg navbar-dark bg-dark">
    	<a href="<c:url value="/"/>" class="navbar-brand">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
               	<span class="navbar-toggler-icon"></span>
 			</button>
    	<div class="collapse navbar-collapse" id="navbarNav" style="justify-content: space-between">
        	<ul class="navbar-nav nav">
            
                   <li><a class="nav-item nav-link" href="<c:url value="/survey"/>">Survey</a></li>
                   <li><a class="nav-item nav-link" href="<c:url value="/login"/>">Login</a></li>
                
              </ul>
                   <c:if test="${not empty appCurrentUser}">
               <ul class="nav navbar-nav navbar-right">
                   		<li><a class="nav-item nav-link mr-2" href="<c:url value="/"/>">${appCurrentUser.username}</a></li>
                        
                        <c:url var="logoffUrl" value="/logoff"/>
                        <li>
                            <form action="${logoffUrl}" method="POST" class="navbar-form">
                                <button type="submit" class="btn btn-outline-danger btn-md mt-1 ">Log Out</button>
                            </form>
                        </li>
                 </ul>
                    </c:if>
				
            </div>
    	</div>