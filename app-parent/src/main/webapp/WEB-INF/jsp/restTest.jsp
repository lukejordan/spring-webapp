<%@ include file="include/header.jspf"%>

<div class="main-body" ng-app="MyApp">
	<h1>My Test Rest App</h1>
	
	<div ng-controller="PostsCtrl">
		<h3>Test</h3>
		<p>JSON: {{posts}}</p>
		<p>First: {{posts.firstName}}</p>
		<p>Last: {{posts.lastName}}</p>
		<p>Job - Company: {{posts.job.company}}</p>
	</div>
	
	<div ng-controller="PostsMultiple">
		<h3>Test Multiple</h3>
		<p>JSON: {{posts}}<p>
		<ul class="cheese" ng-repeat="post in posts">
			<li>JSON: {{post}}</li>
			<li>First: {{post.firstName}}</li>
			<li>Last: {{post.lastName}}</li>
			<li>Job - Company: {{post.job.company}}</li>
		</ul>
	</div>
	
	<form action="service/testPost" method="POST">
		Some text: <input type="text" name="key" />
		<input type="submit" />
	</form>
</div>

<%@ include file="include/footer.jspf"%>