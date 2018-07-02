<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Replenisher</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<div class="navbar  navbar-inverse navbar-fixed-top topBar"
		Style="background-color: #007DC6">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/home/">The Replenisher</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="/user" type="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">View
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="/user/users">Users and Tasks</a></li>
							<!--I will delete this  -->
							<li><a href="/user/list">All Users</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="/" type="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tasks
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="/task/assigned">Assigned</a></li>
							<li><a href="/task/inprogress">In Progress</a></li>
							<li><a href="/task/pending">Pending</a></li>
							<li><a href="/task/tasks">Recurrent</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/profile/view"><sec:authentication
								property="principal.username" /></a></li>
					<li><a href="/logout"> <span
							class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;Logout
					</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="jumbotron nextBar"></div>
</body>
</html>
