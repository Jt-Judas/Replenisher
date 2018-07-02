<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="header.jsp"%>
	<h5 class="centerContent">Tasks based on selected filter in the menu</h5>
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
				<c:forEach items="${pendingTasks}" var="task">
					<tr>
						<spring:url value="/comment/comments/${task.id}" var="taskDetailInfo" />
					<tr>			
						<td><a href="${taskDetailInfo}" role="link">${task.name}</td>
						<td><a href="${taskDetailInfo}" role="link">${task.description}</td>
						<td><a href="${taskDetailInfo}" role="link">${task.status}</td>
						<td><a href="${taskDetailInfo}" role="link">${task.manHours}</td>
						<td><a href="${taskDetailInfo}" role="link">${task.priority}</td>
						<td><a href="${taskDetailInfo}" role="link">${task.rank}</td>
						<td><a href="${taskDetailInfo}" role="link">${task.progress }</td>
						<td><spring:url value="/task/deleteTask/${task.id }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">Delete</a></td>
						<td><spring:url value="/task/updateTask/${task.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>
						<td><spring:url
								value="/task/assignUserToTask/${task.id }/${user.id}"
								var="assignUserToTaskURL" /> <a class="btn btn-primary"
							href="${assignUserToTaskURL}" role="button">Assign to user</a></td>
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