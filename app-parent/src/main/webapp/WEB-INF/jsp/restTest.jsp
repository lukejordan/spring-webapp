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
	
	<h1>Form 2 - Angular</h1>
	<form name="formuser" ng-submit="submit(user)" ng-controller="PostData">
		<input type="text" ng-model="user.firstName" />
		<input type="text" ng-model="user.lastName" />
		<input type="text" ng-model="user.age" />
		<input type="text" ng-model="user.job" />
	    <button type="submit">Submit</button>
	</form>
	
	<h1>Form 3 - Angular</h1>
	  <form id="myform" ng-submit="confirm()">
	    <label for="myinput">My Input</label>
	    <input type="text" id="myinput" name="myinput">
	  </form>
	  <br>
  
  <input type="submit" value="Submit" form="myform">
  
  
</div>

<%@ include file="include/footer.jspf"%>