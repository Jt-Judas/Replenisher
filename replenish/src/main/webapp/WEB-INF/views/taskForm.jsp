<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="header.jsp"%>
	<div class="container main-container">
		<h4>Add Task</h4>
		<spring:url value="/task/saveTask" var="saveTask" />
		<h2>Task</h2>
		<form:form modelAttribute="addNewTask" method="post"
			action="${saveTask }" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<div class="form-group col-md-8">
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="name">Task name</label>
							<form:input type="name" class="form-control" path="name"
								id="name" placeholder="Task Name" />
						</div>
						<div class="form-group col-md-4">
							<label for="description">Description</label>
							<form:input type="description" class="form-control"
								path="description" id="description"
								placeholder="Task Description" />
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="progress">Progress</label>
							<form:input type="progress" class="form-control" path="progress"
								id="progress" placeholder="progress" />
						</div>
						<div class="form-group col-md-4">
							<label for="manHours">Man Hours</label>
							<form:input type="manHours" class="form-control" path="manHours"
								id="manHours" placeholder="manHours" />
						</div>
						<div class="form-group col-md-4">
							<label for="priority">Priority</label>
							<form:select class="form-control" path="priority">
								<form:option value="${PRIORITY.value}" label="--Please Select" />
								<form:options items="${priorities}"></form:options>
							</form:select>
						</div>
						<div class="form-group col-md-4">
							<label for="status">Status</label>
							<form:select class="form-control" path="status">
								<form:option value="${STATUS.name}" label="--Please Select" />
								<form:options items="${statusList}"></form:options>
							</form:select>
						</div>
						<div class="form-group col-md-4"></div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
	</div>

	</form:form>
	</div>
</body>
</html>