<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="header.jsp"%>
	<div class="container main-container">
		<h4>Add User</h4>
		<spring:url value="/user/saveUser" var="saveUser" />
		<h2>User</h2>
		<form:form modelAttribute="addNewUser" method="post"
			action="${saveUser }" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<div class="form-group col-md-8">
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="firstname">First Name</label>
							<form:input type="firstname" class="form-control"
								path="firstname" id="firstname" placeholder="First Name" />
						</div>
						<div class="form-group col-md-4">
							<label for="lastname">Last Name</label>
							<form:input type="lastname" class="form-control" path="lastname"
								id="lastname" placeholder="Last Name" />
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="email">Email</label>
							<form:input type="email" class="form-control" path="email"
								id="email" placeholder="Email" />
						</div>
						<div class="form-group col-md-4">
							<label for="username">Username</label>
							<form:input type="username" class="form-control" path="username"
								id="username" placeholder="Username" />
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
				</div>

			</div>

		</form:form>
	</div>
</body>
</html>