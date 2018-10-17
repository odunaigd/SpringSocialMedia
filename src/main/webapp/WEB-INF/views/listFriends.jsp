<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Friends</title>
<link href="<c:url value='/static/css/customBootstrap.css' />"  rel="stylesheet"></link>
		
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

</head>
<body>
	<div class="generic-container">
       <h1> <%@include file="authheader.jsp" %> </h1>   
        <div class="panel panel-default">
        
    <br/>
    <a href="<c:url value='/list' />" class="btn btn-default">Find Friends</a><a href="<c:url value='/photo' />" class="btn btn-default">Photos</a><a href="<c:url value='/post' />" class="btn btn-default">Posts</a>
    <a href="<c:url value='/myRequests' />" class="btn btn-default">My Requests</a> <a href="<c:url value='/myFriends' />" class="btn btn-default">My Friends</a>
    <br/>
    
    	</div>
    </div>
    
    <h3>User List</h3>
    <div class="generic-container">
        <%@include file="authheader.jsp" %>   
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Friends </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Username</th>
                        
                         
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${friends}" var="friend" varStatus="i">
                    <tr>
                        <td>${friend.user.username}</td>                      
                        
                        <td><a href="<c:url value='/friendsPost/${friends[i.index].user.username}' />" class="btn btn-success custom-width">View Page</a></td> 
                        
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        
    </div>

</body>
</html>