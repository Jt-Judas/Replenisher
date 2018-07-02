<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="header.jsp"%>
	<div class="container main-container">
		<h4 class="centerContent">Creating Notes for  Task ${task.name}</h4>
		<spring:url value="/comment/saveComment/${task.id}" var="saveComment" />
		<h2>Task</h2>
		<form:form modelAttribute="addNewComment" method="post"
			action="${saveComment}" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<div class="form-group col-md-8">
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="feedback">Your feedback</label>
							<form:input type="feedback" class="form-control" path="feedback"
								id="feedback" placeholder="Feedback" />
						</div>
						<div class="form-group col-md-4">
							<label for="description">Description</label>
							<form:input type="description" class="form-control"
								path="description" id="description"
								placeholder="Description" />
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
	</div>
	</form:form>
	</div>
</body>
</html>