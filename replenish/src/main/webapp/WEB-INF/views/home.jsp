<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="header.jsp"%>
	<h2 class="centerText">Replenish....</h2>
	
	<div class="jombortan"><img alt="Logo" src="/resources/images/walmart-live-better.gif" class="image-responsive left-block"></div>

	<button type="button" class="btn btn-primary">
	  <a href="/task/pending"> No of Pending Tasks:<span class="badge badge-light">${pending}</span></a>
    </button>
    <button type="button" class="btn btn-primary">
	   <a href="/task/assigned"> No of Assigned Tasks:<span class="badge badge-light">${assigned}</span></a>
    </button>
    <button type="button" class="btn btn-primary"><a href="/task/inprogress">
	    No of inprogress Tasks:<span class="badge badge-light">${inprogress}</span></a>
    </button>
	</div>
</body>
</html>
