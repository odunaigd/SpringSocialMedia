<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Page</title>
<link href="<c:url value='/static/css/customBootstrap.css' />"  rel="stylesheet"></link>
		
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

</head>
<body>
	<div class="generic-container">
       <h1> <%@include file="authheader.jsp" %> </h1>   
        <div class="panel panel-default">
    <br/>
    <br/>
    Go to <a href="<c:url value='/list' />">List of All Employees</a>
    	</div>
    </div>
     
</body>
 
</html>