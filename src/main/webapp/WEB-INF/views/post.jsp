<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
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
    <a href="<c:url value='/list' />" class="btn btn-default">Find Friends</a><a href="<c:url value='/photo' />" class="btn btn-default">Photos</a><a href="<c:url value='/post' />" class="btn btn-default">Posts</a>
    <a href="<c:url value='/myRequests' />" class="btn btn-default">My Requests</a> <a href="<c:url value='/myFriends' />" class="btn btn-default">My Friends</a>
    <br/>
    
    <div class="well lead">Write a Post</div>
    <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Posts </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Post Name</th>
                        <th>Content</th>
                        
                         
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>${post.postName}</td>
                        <td>${post.postContent}</td>
                        
                            
                        
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        
        <form:form method="POST" modelAttribute="postForm" class="form-horizontal">
            <form:input type="hidden" path="postId" id="id"/>
             
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Post Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="postName" id="postName" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="postName" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="username">Post Content</label>
                    <div class="col-md-7">
                        <form:input type="text" path="postContent" id="postContent" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="postContent" class="help-inline"/>
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
                            <input type="submit" value="Write Post" class="btn btn-lg btn-primary btn-block"/> or <a href="<c:url value='/home' />">Clear</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
    </div>
    
     
</body>
 
</html>