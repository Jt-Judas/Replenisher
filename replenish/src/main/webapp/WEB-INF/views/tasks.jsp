<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="header.jsp"%>
	<h4 class="centerContent">A list of all tasks</h4>
	<div class="container main-container">
		<table class="table table-striped">
			<thead>
				<th scope="row">Task name</th>
				<th scope="row">Description</th>
				<th scope="row">Status</th>
				<th scope="row">Man Hours</th>
				<th scope="row">Priority</th>
				<th scope="row">Rank</th>
				<th scope="row">Progress</th>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td>${task.name}</td>
						<td>${task.description}</td>
						<td>${task.status}</td>
						<td>${task.manHours}</td>
						<td>${task.priority}</td>
						<td>${task.rank}</td>
						<td>${task.progress }</td>
						<td><spring:url value="/task/updateTask/${task.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>
						<td><spring:url value="/task/deleteTask/${task.id }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">Delete</a></td>
							<td><spring:url value="/comment/addComment/${task.id }"
								var="addTaskCommentURL" /> <a class="btn btn-primary"
							href="${addTaskCommentURL }" role="button">Add comment or
								feedback</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/task/addTask/" var="addURL" />
		<a class="btn btn-primary" href="${addURL}" role="button">Add New
			Task</a>
	</div>
</body>
</html>