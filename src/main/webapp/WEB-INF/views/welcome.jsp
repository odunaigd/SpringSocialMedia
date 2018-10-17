<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
<link href="<c:url value='/static/css/customBootstrap.css' />"
	rel="stylesheet"></link>

<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
	<div>
		<center>Greeting : ${greeting}. This is the welcome page.</center>
	</div>

	<!---<div class="container">



		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<h2 class="form-signin-heading">Register your Account or Login</h2>
			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="name" class="form-control"
						placeholder="Name" autofocus="true"></form:input>
					<form:errors path="name"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="userProfiles">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="userProfiles" class="form-control"
						placeholder="UserProfile"></form:input>
					<form:errors path="userProfiles"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form> --->
		
		
		<div class="generic-container">
       <!--- <%@include file="authheader.jsp" %> --->
 
        <div class="well lead">User Registration Form</div>
        <form:form method="POST" modelAttribute="userForm" class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>
             
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="name" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="username">Username</label>
                    <div class="col-md-7">
                        <form:input type="text" path="username" id="username" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="username" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="password">Password</label>
                    <div class="col-md-7">
                        <form:input type="password" path="password" id="password" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

     
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/home' />">Clear</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-lg btn-primary btn-block"/> or <a href="<c:url value='/home' />">Clear</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
		
		
		
		
		<a class="btn btn-lg btn-primary btn-block"
			href="<c:url value='/login' />">Login</a>

	</div>
	<div class="container">
	<p>Simply enter your name, a username and a password in the above fields and hit submit to register for this site.</p>
	<hr>
	<p>If you are already a user, hit the Login button to be brought to the login screen</p>
	
	</div>


</body>
</html>